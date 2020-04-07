package com.anla.springannotation;

import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * https://my.oschina.net/u/3557716/blog/3059428/print
 * Spring组合注解 例子
 * @author luoan
 * @version 1.0
 * @date 2020/4/7 13:28
 **/
public class SynthesizedAnnotationTest {

    @Target({ ANNOTATION_TYPE, FIELD, TYPE })
    @Retention(RUNTIME)
    @interface Test1 {
        String test1() default "test1";
    }

    @Target({ ANNOTATION_TYPE, FIELD, TYPE })
    @Retention(RUNTIME)
    @interface Test2 {
        String test2() default "test2";
    }

    @Target({ ANNOTATION_TYPE, FIELD, TYPE })
    @Retention(RUNTIME)
    @Test2
    @interface Test3 {
        String tset3() default "test3";
    }

    /**
     * 只有@Test3注解，但是Test3注解上组合了@Test2注解，故就可以通过Spring的工具类获取到Test2注解的内容，详见main方法
     * 当然也可以将组合注解作用于更高层次，如Test3组合Test2,Test2组合Test1，然后将Test3作用于元素，通过工具类获取Test1注解功能
     */
    @Test3
    static class Element {}

    public static void main(String[] args) {
        Test2 test2 = AnnotatedElementUtils.getMergedAnnotation(Element.class, Test2.class);
        // 输出'@com.anla.springannotation.SynthesizedAnnotationTest$Test2(test2=test2)'
        System.out.println(test2);
    }
}
