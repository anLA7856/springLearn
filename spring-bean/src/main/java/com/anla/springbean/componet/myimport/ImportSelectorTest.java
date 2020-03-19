package com.anla.springbean.componet.myimport;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 相当于执行二次import
 * @author anLA7856
 * @date 20-3-19 下午10:32
 * @description
 */
public class ImportSelectorTest implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 返回应该作为bean的返回
        return new String[]{"com.anla.springbean.componet.myimport.ImportTestB"};
    }
}
