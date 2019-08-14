package com.taichi.cfm.service.utils;

import com.taichi.cfm.domain.annotations.Condition;
import com.taichi.cfm.domain.annotations.JpaCondition;
import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 查询条件工具类
 */
public class ConditionUtil {

	/**
	 * 根据查询条件字段，初始化查询条件
	 * @param condition
	 * @param queryBo
	 * @date 2015年11月30日 下午4:41:45
	 */
	public static <T> void initCondition(Condition<T> condition, Object queryBo) {
		Field[] fields = queryBo.getClass().getDeclaredFields();
		for(Field field : fields){
			JpaCondition jpaCondition = field.getAnnotation(JpaCondition.class);
			if(jpaCondition == null){
				continue;
			}
			Object fieldValue = null;
			try {
				PropertyDescriptor pd = new PropertyDescriptor(field.getName(), queryBo.getClass());
				Method getMethod = pd.getReadMethod();
				fieldValue = getMethod.invoke(queryBo);
			} catch (Exception e) {
				throw new RuntimeException("call getter method faild, field: " + field.getName(), e);
			}
			Condition.Operator operator = jpaCondition.operator();
			String fieldName = jpaCondition.field();
			if(fieldValue != null){
				if(fieldValue instanceof String) {
					if(StringUtils.isBlank((String)fieldValue)){
						continue;
					}
				}
				condition.put(fieldName, operator, fieldValue);
			}
		}
	}
}
