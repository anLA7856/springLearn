package com.anla.springbean.componet.myimport;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**MyMainImporter 注解怎么样才能起作用。
 * @author luoan
 * @version 1.0
 * @date 2020/3/19 19:27
 **/
@Import({ImportTestA.class,
        ImportSelectorTest.class,
        ImportBeanDefinitionRegistrarTest.class,
        DeferredImportSelectorTest.class,
        DeferredImportSelectorWithGroupTest.class})
@Configuration
public class MyMainImporter {
}
