package com.anla.springtransactionproxy.config;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/5/11 13:27
 **/
@Component
public class MyTransactionListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    private void onAfterEvent(MyAfterTransactionEvent event) {
        Object source = event.getSource();
        Integer id = event.getId();

        System.out.println("onAfterEvent source: " + source);
        System.out.println("onAfterEvent id: " + id);

    }


    /**
     * 有多个，就顺序调用，按初始化顺序
     * @param event
     */
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    private void onAfterEvent2(MyAfterTransactionEvent event) {
        Object source = event.getSource();
        Integer id = event.getId();

        System.out.println("onAfterEvent2 source: " + source);
        System.out.println("onAfterEvent2 id: " + id);

    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    private void onBeforeEvent(MyAfterTransactionEvent event) {
        Object source = event.getSource();
        Integer id = event.getId();

        System.out.println("before is source: " + source);
        System.out.println("before is id: " + id);

    }
}
