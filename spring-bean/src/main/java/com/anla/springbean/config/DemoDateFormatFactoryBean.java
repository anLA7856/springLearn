package com.anla.springbean.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 *
 * 从 DefaultListableBeanFactory 的 getBeanNamesForType 方法为debug点进行分析
 * @author anLA7856
 * @date 20-3-1 下午6:14
 * @description
 */
public class DemoDateFormatFactoryBean implements FactoryBean<DateFormat>, InitializingBean {

    private DateFormat dateFormat = new SimpleDateFormat();

    @Override
    public DateFormat getObject() throws Exception {
        return dateFormat;
    }

    @Override
    public Class<?> getObjectType() {
        return dateFormat.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Asia/Shanghai
        dateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.SHORT_IDS.get("CTT")));
    }
}
