package com.anla.springbean.componet.myimport;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

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

        private static List<Entry> imports;

        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            imports = new ArrayList<>();
            Entry entry = new Entry(metadata, "com.anla.springbean.componet.myimport.ImportTestE");
            imports.add(entry);
            Entry entry1 = new Entry(metadata, "com.anla.springbean.componet.myimport.ImportTestF");
            imports.add(entry1);
        }

        @Override
        public Iterable<Entry> selectImports() {
            return imports;
        }
    }
}
