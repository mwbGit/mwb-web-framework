package com.mwb.web.framework.util;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Description: List集合工具类
 * @Author: MengWeiBo
 * @Created: 2016-08-08
 */
public class BaseListUtility {

    /**
     * @param attributeKeyName:T中属性名称
     * @param attributeClass：attributeKeyName 属性的类型;
     * @param <E>:属性类型支持超类是Object类型，暂不支持集合类型
     * @return 返回list中attributeName属性的List集合
     * @throws Exception
     */
    public static <T, E> List<E> getKeys(List<T> list, String attributeKeyName, Class<E> attributeClass) throws Exception {
        List<E> result = new ArrayList<E>();
        if (list != null && list.size() > 0 && attributeKeyName != null && attributeClass != null) {
            for (T curObject : list) {
                Field field = curObject.getClass().getDeclaredField(attributeKeyName);
                field.setAccessible(true);
                Object object = field.get(curObject);
                result.add((E) object);
            }
        }
        return result;
    }

    /**
     * @param attributeName:T中属性名称，根据此属性值判断是否存在
     * @param attributeValue:attributeName属性值
     * @param <E>:属性类型只包含String和Integer类型,如果是其他Object则比较的是地址相同才会return
     * @return 查找List集合对象中attributeName属性包含attributeValue的一个对象
     * @throws Exception
     */
    public static <T, E> T containsKey(List<T> list, String attributeName, E attributeValue) throws Exception {
        if (list != null && list.size() > 0 && attributeValue != null && attributeName != null) {
            for (T curObject : list) {
                Field field = curObject.getClass().getDeclaredField(attributeName);
                field.setAccessible(true);
                Object val = field.get(curObject);
                if (val.equals(attributeValue)) {
                    return curObject;
                }
            }
        }
        return null;
    }

    /**
     * @param attributeName:T中属性名称，根据此属性判断是否删除
     * @param attributeValue:attributeName属性值
     * @param <E>:属性类型只包含String和Integer类型,如果是其他Object则比较的是地址相同才会删除
     * @return 删除集合中,对象属性attributeName是attributeValue的元素
     * @throws Exception
     */
    public static <T, E> void remove(List<T> list, String attributeName, E attributeValue) throws Exception {
        if (list != null && list.size() > 0 && attributeValue != null && attributeName != null) {
            Iterator<T> iterator = list.iterator();
            while (iterator.hasNext()) {
                T curObject = iterator.next();
                Field field = curObject.getClass().getDeclaredField(attributeName);
                field.setAccessible(true);
                Object val = field.get(curObject);
                if (val.equals(attributeValue)) {
                    iterator.remove();
                }
            }
        }
    }

    /**
     * @param removeList:需要删除元素的集合
     * @param containsList:与removeList比较的集合
     * @param sameAttributeName:判断两集合对象属性值相同的属性名
     * @return 删除集合removeList中，与containsList集合对象属性sameAttributeName值一样的元素
     * @throws Exception
     */
    public static <T> void removeAll(List<T> removeList, List<T> containsList, String sameAttributeName) throws Exception {
        if (containsList == null
                || containsList.size() == 0 || removeList == null || removeList.size() == 0) {
            return;
        } else if (sameAttributeName == null) {
            removeList.removeAll(containsList);
        } else {
            Iterator<T> iterator = removeList.iterator();
            while (iterator.hasNext()) {
                T curObject = iterator.next();
                Field field = curObject.getClass().getDeclaredField(sameAttributeName);
                field.setAccessible(true);
                Object val = field.get(curObject);
                if (containsKey(containsList, sameAttributeName, val) != null) {
                    iterator.remove();
                }
            }

        }
    }

    /**
     * @param list 要转换成Map的List
     * @param attributeName 作为键的属性名称
     * @return 返回以attributeName的值为键,键的类型为String，以V为值得Map
     * @throws Exception
     */
    public static <V> Map<String,V> toKeyMap(List<V> list ,String attributeName) throws Exception {
        Map<String,V> map = new HashMap<String, V>();
        if (list != null && list.size() > 0 && attributeName != null) {
            for (V curObject : list) {
                Field field = curObject.getClass().getDeclaredField(attributeName);
                field.setAccessible(true);
                Object val = field.get(curObject);
                map.put(val.toString(), curObject);
            }
        }
        return map;
    }

    /**
     * @param list 要转换成Map的List
     * @param attributeName 作为键的属性名称
     * @param attributeValue 键的类型
     * @return 返回以attributeName的值为键，以V为值得Map
     * @throws Exception
     */
    public static <K,V> Map<K,V> toKeyMap(List<V> list ,String attributeName,K attributeValue) throws Exception {
        Map<K,V> map = new HashMap<K, V>();
        if (list != null && list.size() > 0 && attributeName != null && attributeValue != null) {
            for (V curObject : list) {
                Field field = curObject.getClass().getDeclaredField(attributeName);
                field.setAccessible(true);
                Object val = field.get(curObject);
                map.put((K)val, curObject);
            }
        }
        return map;
    }
    public static <T, E> boolean containsKey1(List<T> list, String attributeName, E attributeValue) throws Exception {
        if (list != null && list.size() > 0 && attributeValue != null && attributeName != null) {
            for (T curObject : list) {
                Field[] fields = curObject.getClass().getSuperclass().getDeclaredFields();
                for (Field field : fields){
                    field.setAccessible(true);
                    System.out.println(field.getName());
                    if (field.getName().equals(attributeName)){
                        Object val = field.get(curObject);
                        if (val.equals(attributeValue)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}