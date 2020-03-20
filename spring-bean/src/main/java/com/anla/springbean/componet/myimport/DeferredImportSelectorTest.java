package com.anla.springbean.componet.myimport;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/3/20 15:09
 **/
public class DeferredImportSelectorTest implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.anla.springbean.componet.myimport.ImportTestD"};
    }

    @Override
    public Class<? extends Group> getImportGroup() {
        return null;
    }
}
