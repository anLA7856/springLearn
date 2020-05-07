package com.anla.springaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 11:19
 * ConditionalOnProperty:
 * 1.
 * public @interface ConditionalOnProperty {
 *     String[] value() default {}; //数组，获取对应property名称的值，与name不可同时使用
 *
 *     String prefix() default "";//property名称的前缀，可有可无
 *
 *     String[] name() default {};//数组，property完整名称或部分名称（可与prefix组合使用，组成完整的property名称），与value不可同时使用
 *
 *     String havingValue() default "";//可与name组合使用，比较获取到的属性值与havingValue给定的值是否相同，相同才加载配置
 *
 *     boolean matchIfMissing() default false;//缺少该property时是否可以加载。如果为true，没有该property也会正常加载；反之报错
 *
 *     boolean relaxedNames() default true;//是否可以松散匹配，至今不知道怎么使用的
 * }
 * 2. 以下4中用法
 * @ConditionalOnBean         //	当给定的在bean存在时,则实例化当前Bean
 * @ConditionalOnMissingBean  //	当给定的在bean不存在时,则实例化当前Bean
 * @ConditionalOnClass        //	当给定的类名在类路径上存在，则实例化当前Bean
 * @ConditionalOnMissingClass //	当给定的类名在类路径上不存在，则实例化当前Bean
 *
 * 3. ProxyConfig属性分析
 * https://blog.csdn.net/wt_better/article/details/84775621?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-11&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-11
 *
 * 4. advisor 顺序
 * Sort the rest by AspectJ precedence. If two pieces of advice have
 * come from the same aspect they will have the same order.
 * Advice from the same aspect is then further ordered according to the
 * following rules:
 * <ul>
 * <li>if either of the pair is after advice, then the advice declared
 * last gets highest precedence (runs last)</li>
 * <li>otherwise the advice declared first gets highest precedence (runs first)</li>
 * </ul>
 * <p><b>Important:</b> Advisors are sorted in precedence order, from highest
 * precedence to lowest. "On the way in" to a join point, the highest precedence
 * advisor should run first. "On the way out" of a join point, the highest precedence
 * advisor should run last.
 *
 *
 *  5. cglib 也是使用 ProxyFactory  管理advisor。ProxyFactory  用法：https://blog.csdn.net/u012834750/article/details/71773887
 *  6. advisor 管理 advice 以及 pointcut
 **/
@SpringBootApplication
public class AopApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }
}
