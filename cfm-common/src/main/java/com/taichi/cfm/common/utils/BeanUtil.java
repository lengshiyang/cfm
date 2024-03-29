package com.taichi.cfm.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.core.ResolvableType;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static java.util.Locale.ENGLISH;

/**
 * Created by shiyang.leng
 * on 2019/6/1
 * ClassDescription：
 */
public class BeanUtil  extends BeanUtils {

    /**
     * 拷贝对象属性到目标对象
     * <p>
     * <b>示例</b> BeanSource bs = new BeanSource(); bs.set(...); ... BeanTarget
     * bt = BeanUtil.copyProperties(bs,BeanTarget.class);
     *
     * </p>
     *
     * @param sourceObj
     *            源对象
     * @param targetClazz
     *            目标类
     * @return 目标对象
     */
    public static <T> T copyProperties(Object sourceObj, Class<T> targetClazz) {
        return BeanUtil.copyProperties(sourceObj, targetClazz, new String[] {});
    }

    public static <T> T copyProperties(Object sourceObj, Class<T> targetClazz, String... ignoreProperties) {
        if (sourceObj == null) {
            return null;
        }

        T targetObj = null;
        try {
            targetObj = (T) targetClazz.newInstance();
            BeanUtils.copyProperties(sourceObj, targetObj, ignoreProperties);
        } catch (IllegalAccessException e) {

        } catch (InstantiationException e) {

        }
        return targetObj;
    }

    /**
     * 拷贝源列表对象到目标列表
     *
     * @param sourceList
     *            源列表
     * @param targetClazz
     *            目标列表元类型
     * @return 目标列表
     */
    public static <T> List<T> copyBeans(List<?> sourceList, Class<T> targetClazz) {
        return BeanUtil.copyBeans(sourceList, targetClazz, new String[] {});
    }

    public static <T> List<T> copyBeans(List<?> sourceList, Class<T> targetClazz, String... ignoreProperties) {
        if (sourceList == null) {
            return null;
        }
        List<T> targetList = new ArrayList<T>();
        for (Object sourceObj : sourceList) {
            T targetObj = BeanUtil.copyProperties(sourceObj, targetClazz, ignoreProperties);
            targetList.add(targetObj);
        }
        return targetList;
    }

    /**
     * 将一个 JavaBean 对象转化为一个 Map
     *
     * @param bean
     *            要转化的JavaBean 对象
     * @return 转化出来的 Map 对象
     * @throws IntrospectionException
     *             如果分析类属性失败
     * @throws IllegalAccessException
     *             如果实例化 JavaBean 失败
     * @throws InvocationTargetException
     *             如果调用属性的 setter 方法失败
     */
    public static Map<String, Object> convertBean(Object bean) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Class<? extends Object> type = bean.getClass();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }

    /**
     * 通过getter方法比较同一个类的两个对象的属性， 返回有变化的属性名列表 <see> 如果 target.propertyName ==
     * null 则不返回 <see> 如果 source.propertyName == null && target.propertyName !=
     * null 则返回 [propertyName] <see> 如果
     * !source.propertyName.equals(target.propertyName) 则返回[propertyName]
     *
     * @param source
     * @param target
     * @return
     * @author zhaofei
     * @date 2015年9月29日 下午1:43:35
     */
    public static <T> List<String> compareBean(T source, T target) {
        Field[] fields = target.getClass().getDeclaredFields();
        Method[] methods = target.getClass().getMethods();
        List<String> filedNameList = new ArrayList<String>();
        for (Field field : fields) {
            try {
                for (Method method : methods) {
                    if (hasMethod(method.getName(), field.getName(), method.getReturnType())) {
                        PropertyDescriptor pd = new PropertyDescriptor(field.getName(), target.getClass());
                        Method readMethod = pd.getReadMethod();
                        Object sourceValue = readMethod.invoke(source);
                        Object targetValue = readMethod.invoke(target);
                        if (targetValue == null) {
                            continue;
                        } else if (sourceValue == null || !sourceValue.equals(targetValue)) {
                            filedNameList.add(field.getName());
                        }
                    }
                }
            } catch (IntrospectionException e) {

            } catch (Exception e) {

            }
        }
        return filedNameList;
    }

    /**
     * 获取Bean变化信息
     *
     * @param source
     * @param target
     * @return 返回 变化了的字段，值=变化前的值->变化后的值
     */
    public static <T> Map<String, String> getBeanChangedInfo(T source, T target) {
        Field[] fields = target.getClass().getDeclaredFields();
        Method[] methods = target.getClass().getMethods();
        Map<String, String> changed = new HashMap<>();
        for (Field field : fields) {
            try {
                for (Method method : methods) {
                    if (hasMethod(method.getName(), field.getName(), method.getReturnType())) {
                        PropertyDescriptor pd = new PropertyDescriptor(field.getName(), target.getClass());
                        Method readMethod = pd.getReadMethod();
                        Object sourceValue = readMethod.invoke(source);
                        Object targetValue = readMethod.invoke(target);
                        if (targetValue == null && null == sourceValue) {
                            continue;
                        } else if (sourceValue == null || !sourceValue.equals(targetValue)) {
                            changed.put(field.getName(), sourceValue + "->" + targetValue);
                        }
                    }
                }

            } catch (IntrospectionException e) {

            } catch (Exception e) {

            }
        }
        return changed;
    }

    public static boolean hasMethod(String method, String filed, Class<?> returnType) {
        if (filed == null || filed.length() == 0) {
            return false;
        }
        StringBuffer get = new StringBuffer();
        StringBuffer set = new StringBuffer();
        String end = filed.substring(0, 1).toUpperCase(ENGLISH) + filed.substring(1);
        if (returnType == boolean.class || returnType == Boolean.class) {
            get.append("is").append(end);
        } else {
            get.append("get").append(end);
        }
        set.append("set").append(end);

        return method.equals(get.toString()) || method.equals(set.toString());
    }

    /**
     * 获取泛型类
     */
    public static Class<?> getGenericClass(Class<?> mainCls, int idx) {
        ResolvableType resolvableType = ResolvableType.forClass(mainCls);
        return resolvableType.getGeneric(idx).resolve();
    }

    public static void copyPermittedProperties(Object source, Object target, String... permitProperties) throws BeansException {
        copyPermitedProperties(source, target, null, permitProperties);
    }

    private static void copyPermitedProperties(Object source, Object target, Class<?> editable, String... permitProperties) throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");

        Class<?> actualEditable = target.getClass();
        if (editable != null) {
            if (!editable.isInstance(target)) {
                throw new IllegalArgumentException(
                        "Target class [" + target.getClass().getName() + "] not assignable to Editable class [" + editable.getName() + "]");
            }
            actualEditable = editable;
        }
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        List<String> permitList = (permitProperties != null ? Arrays.asList(permitProperties) : null);

        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod();

            if (writeMethod == null || (permitList != null && !permitList.contains(targetPd.getName()))) {
                continue;
            }

            PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
            if (sourcePd != null) {
                Method readMethod = sourcePd.getReadMethod();
                if (readMethod != null && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0], readMethod.getReturnType())) {
                    try {
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);
                        if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                            writeMethod.setAccessible(true);
                        }
                        writeMethod.invoke(target, value);
                    } catch (Throwable ex) {

                        throw new FatalBeanException("Could not copy property '" + targetPd.getName() + "' from source to target", ex);
                    }
                }
            }
        }
    }
}
