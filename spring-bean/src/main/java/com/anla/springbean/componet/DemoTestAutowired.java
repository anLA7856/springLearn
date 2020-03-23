package com.anla.springbean.componet;

import com.anla.springbean.componet.lookup.DemoTrueLookUpConfiguration;
import com.anla.springbean.componet.myimport.MyMainImporter;
import com.anla.springbean.componet.primary.BasePeople;
import com.anla.springbean.componet.sub.Bird;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.DateFormat;

/**
 * @author anLA7856
 * @date 20-3-1 下午6:18
 * @description
 */
@MyMainImporter
@Component
public class DemoTestAutowired {

    @Autowired
    private DateFormat dateFormat;

    @Autowired
    private DemoTrueLookUpConfiguration demoTrueLookUpConfiguration;

    private static Bird bird;

    /**
     * 如果有static，则不回被注入。
     * @param bird
     */
    @Autowired
    public void setBird(Bird bird) {
        DemoTestAutowired.bird = bird;
    }

    /**
     * LookUp 相关解析在 LookupOverrideMethodInterceptor 中。
     *
     */
    public void sayLookUP(){
        demoTrueLookUpConfiguration.print();
        System.out.println("It's another one?");
        demoTrueLookUpConfiguration.print();
    }

    @Autowired
    private BasePeople basePeople;

    @Qualifier("girl")
    @Autowired
    private BasePeople basePeopleGir;

    public void basePeopleBoySay(){
        basePeople.say();
    }

    public void basePeopleGirlSay(){
        basePeopleGir.say();
    }
}
