package com.anla.springbean.componet.myimport;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 实现了group的 deferredImportSelector方法
 * @author luoan
 * @version 1.0
 * @date 2020/3/20 15:09
 **/
public class DeferredImportSelectorWithGroupTest implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.anla.springbean.componet.myimport.ImportTestD"};
    }

    @Override
    public Class<? extends Group> getImportGroup() {
        return DeferredImportSelectorWithGroupGroupTest.class;
    }

    /**
     * 自定义Group
     */
    private static class DeferredImportSelectorWithGroupGroupTest
            implements DeferredImportSelector.Group {

        private static List<String> imports;

        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            imports = new ArrayList<>();
            imports.add("com.anla.springbean.componet.myimport.ImportTestE");
            imports.add("com.anla.springbean.componet.myimport.ImportTestF");
        }

        @Override
        public Iterable<Entry> selectImports() {
            return imports.stream()
                    .map((importClassName) -> new Entry(this.entries.get(importClassName), importClassName))
                    .collect(Collectors.toList());
        }
    }
}
