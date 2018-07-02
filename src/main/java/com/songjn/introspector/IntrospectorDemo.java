package com.songjn.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author songjn
 * @create 2018-06-18 16:53
 * @desc 内省将配置文件中的属性给javaBean
 **/
public class IntrospectorDemo {
    //加载properties文件
    private static Properties prop = new Properties();

    static {
        InputStream resourceAsStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream("com/songjn/introspector/userInfo.properties");
        try {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String name) {
        Object bean = null;
        String beanName = prop.getProperty(name);
        try {
            Class<?> aClass = Class.forName(beanName);
            bean = aClass.newInstance();

            //通过类信息获取javaBean的描述信息。
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);

            //通过javaBean的描述信息，获取该类的所有属性描述信息
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String properName = propertyDescriptor.getName();
                Method writeMethod = propertyDescriptor.getWriteMethod();
                if ("userName".equals(properName)) {
                    writeMethod.invoke(bean, prop.getProperty("bean.userName"));
                }else if("userPwd".equals(properName)) {
                    writeMethod.invoke(bean, prop.getProperty("bean.userPwd"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

//    public static void main(String[] args) {
//        UserInfo bean = (UserInfo) IntrospectorDemo.getBean("bean.beanName");
//        System.out.println(bean);
//    }
}
