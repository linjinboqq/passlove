package cn.edu.cqupt.nmid.passloveserver.util;

import java.lang.reflect.Field;

/**
 * \* Author: MrWangx
 * \* Date: 2019/4/19
 * \* Time: 22:01
 * \* Description:
 **/
public class PojoUtil {

    /**
     * 通过反射将一个对象转为另一个对象
     * @param from
     * @param fromClass
     * @param toClass
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object convert(Object from, Class fromClass, Class toClass) throws IllegalAccessException, InstantiationException {
        Object to = toClass.newInstance();
        Field[] fieldsFrom = fromClass.getDeclaredFields();
        for (Field f : fieldsFrom) {
            f.setAccessible(true);
            String fieldName = f.getName();
            try {
                Field fto = toClass.getDeclaredField(fieldName);
                fto.setAccessible(true);
                fto.set(to, f.get(from));
            } catch (NoSuchFieldException e) {
                continue;
            }
        }
        return to;
    }

}
