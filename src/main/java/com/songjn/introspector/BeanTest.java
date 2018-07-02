package com.songjn.introspector;

import org.apache.naming.factory.BeanFactory;
import org.junit.jupiter.api.Test;

/**
 * @author songjn
 * @create 2018-06-18 17:27
 * @desc
 **/
public class BeanTest {
    @Test
    public void getBeanTest() {
        UserInfo bean = (UserInfo) IntrospectorDemo.getBean("bean.beanName");
        System.out.println(bean);
    }
}
