package com.taichi.cfm.domain.annotations;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.*;
import java.util.Map.Entry;

public class Condition<T> implements Specification<T> {
	public enum Operator {

		EQ, LIKE, GT, LT, GTE, LTE, NOT,IN;

		public static Operator fromString(String value) {
			try {
				return Operator.valueOf(value.toUpperCase(Locale.US));
			} catch (Exception e) {
				throw new IllegalArgumentException(String.format(
						"Invalid value '%s' for Operator given! Has to be in 'eq, like, gt, lt, gte, lte, not' (case insensitive).", value), e);
			}
		}
	}

	private List<Filter> filters = new ArrayList<Filter>();

	public static <T> Condition<T> build() {
		return new Condition<T>();
	}

	public Condition<T> clear() {
		filters.clear();
		return this;
	}

	public Condition<T> put(String field, Object value) {
		filters.add(new Filter(field, value));
		return this;
	}

	public Condition<T> put(String field, Operator op, Object value) {
		filters.add(new Filter(field, op, value));
		return this;
	}

	public Condition<T> put(Map<String, Object> params) {
		for (Entry<String, Object> entry : params.entrySet()) {
			String key = entry.getKey();

			String[] names = StringUtils.split(key, ":");
			Operator operator = names.length == 1 ? Operator.EQ : Operator.fromString(names[1]);
			filters.add(new Filter(names[0], operator, entry.getValue()));
		}
		return this;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (filters.isEmpty()) {
			return cb.conjunction();
		}

		List<Predicate> predicates = new ArrayList<Predicate>();
		for (Filter filter : filters) {
			String[] names = StringUtils.split(filter.field, ".");
			Path<String> expression = root.get(names[0]);
			for (int i = 1; i < names.length; i++) {
				expression = expression.get(names[i]);
			}

			switch (filter.operator) {
			case EQ:
				if (filter.value == null) {
					predicates.add(cb.isNull(expression));
				} else {
					predicates.add(cb.equal(expression, filter.value));
				}
				break;
			case LIKE:
				predicates.add(cb.like(expression, "%" + filter.value + "%"));
				break;
			case GT:
				predicates.add(cb.greaterThan(expression, (Comparable) filter.value));
				break;
			case LT:
				predicates.add(cb.lessThan(expression, (Comparable) filter.value));
				break;
			case GTE:
				predicates.add(cb.greaterThanOrEqualTo(expression, (Comparable) filter.value));
				break;
			case LTE:
				predicates.add(cb.lessThanOrEqualTo(expression, (Comparable) filter.value));
				break;
			case IN:
				if (filter.value != null && StringUtils.isNotBlank(filter.value.toString())) {
					List<String> queryInList = Arrays.asList(filter.value.toString().split(","));
					predicates.add(expression.in(queryInList));
				}
				break;
			case NOT:
				if (filter.value == null) {
					predicates.add(cb.isNotNull(expression));
				} else {
					predicates.add(cb.notEqual(expression, filter.value));
				}
			default:
			}
		}

		return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	}

	class Filter {
		protected String field;
		protected Object value;
		protected Operator operator;

		public Filter(String field, Object value) {
			this.field = field;
			this.value = value;
			this.operator = Operator.EQ;
		}

		public Filter(String field, Operator operator, Object value) {
			this.field = field;
			this.value = value;
			this.operator = operator;
		}
	}
}