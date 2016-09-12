package com.run;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by dai on 16-9-12.
 */
public class EncryptUtil {

    /**
     * 不需要组装的属性
     */
    private static String[] ignores = {"needIgnore"};

    /**
     * 组装属性
     *
     * @param object 待组装的对象
     * @return a=a&b=b 类型的字符串
     * @throws Exception
     */
    public static String encrypt(Object object) throws Exception {

        Class clazz = object.getClass();
        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 升序排序
                        return obj1.compareTo(obj2);
                    }
                });

        //循环自身及所有父级
        while (clazz != null) {
            setMap(clazz, object, map);
            clazz = clazz.getSuperclass();
        }

        StringBuffer sb = new StringBuffer();

        for (String element : map.keySet()) {
            sb.append("&" + element + "=" + map.get(element));
        }

        return sb.toString().substring(1);
    }

    /**
     * 添加属性
     *
     * @param clazz  class
     * @param object bean
     * @param map
     * @throws Exception
     */
    private static void setMap(Class clazz, Object object, Map map) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.get(object) != null && checkAttribute(field.getName())) {
                map.put(field.getName(), field.get(object));
            }
        }
    }

    /**
     * 判断属性是否不需要组装
     *
     * @param name
     * @return
     */
    private static boolean checkAttribute(String name) {
        for (String ignore : ignores) {
            if (ignore.equals(name))
                return false;
        }
        return true;
    }
}
