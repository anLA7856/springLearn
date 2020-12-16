package com.anla.springapollo.controller;

import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.context.annotation.Configuration;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/12/15 14:47
 **/
@Configuration
public class TestRefresh {
    //@ApolloConfigChangeListener //监听application.properties配置变化事件
    //@ApolloConfigChangeListener("application") //监听application.properties配置变化事件
    @ApolloConfigChangeListener({"application", "application-init"})
    private void anotherOnChange(ConfigChangeEvent changeEvent) {
        //监听application.properties,application-init.properties配置变化事件

        for (String changeKey:changeEvent.changedKeys()){
            System.out.println(String.format("在指定配置文件中所有改动过的配置项有:%s",changeEvent.getChange(changeKey).getPropertyName()));
        }
        ConfigChange change = changeEvent.getChange("server.port");
        if(change!=null){
            //判断server.port配置项是否存在改变
            System.out.println(String.format(
                "server.port配置项值有改变，原来值为: %s, 现在值为: %s, 状态是添加，删除，改变类型中的: %s",
                change.getOldValue(),change.getNewValue(), change.getChangeType()));
        }
    }
}
