package com.anla.springtransactionproxy.config;

import org.springframework.context.ApplicationEvent;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/11 13:28
 **/
public class MyAfterTransactionEvent extends ApplicationEvent {

    private Integer id;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyAfterTransactionEvent(Object source, Integer id) {
        super(source);
    }

    public Integer getId() {
        return id;
    }
}
