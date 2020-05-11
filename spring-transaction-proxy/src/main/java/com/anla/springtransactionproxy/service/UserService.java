package com.anla.springtransactionproxy.service;

import com.anla.springtransactionproxy.config.MyAfterTransactionEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.anla.springtransactionproxy.dao.UserMapper;
import com.anla.springtransactionproxy.model.User;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 1. 如果 UserService 中有发方法带有@Test，那么该类将不会被Spring 扫描到。
 *
 *
 *
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 15:48
 **/

@Slf4j
@Component
public class UserService {


    @Autowired
    private UserMapper userMapper;



    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Transactional(rollbackFor = Exception.class)
    public int addUser(User user){
        return userMapper.insertSelective(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public int addUserWithTransaction(){
        User user = new User();
        user.setDescription("测试 addUserWithTransaction");
        int result = addUser(user);
        log.info("addUserWithTransaction 修改行数为:{}", result);
        // throw new RuntimeException("addUserWithTransaction 故意报错");\

        applicationEventPublisher.publishEvent(new MyAfterTransactionEvent("尝试发送下事务", result));
        return result;
    }

    public int addUserWithOutTransaction(){
        User user = new User();
        user.setDescription("测试 addUserWithOutTransaction");
        int result = addUser(user);
        log.info("addUserWithOutTransaction 修改行数为:{}", result);
        throw new RuntimeException("addUserWithOutTransaction 故意报错");
    }

    public int addWithSubTransaction(){
        return this.addWithSubSubTransaction();
    }

    @Transactional(rollbackFor = Exception.class)
    public int addWithSubSubTransaction() {
        User user = new User();
        user.setDescription("test addWithSubSubTransaction");
        int result = addUser(user);
        log.info("addWithSubSubTransaction affect:{}", result);
        throw new RuntimeException("addWithSubSubTransaction");
    }

    /**
     * 不加注解，不会走代理
     * @return
     */
    public int addWithSubNoTransaction() {
        return this.addWithSubSubNoTransaction();
    }

    public int addWithSubSubNoTransaction() {
        User user = new User();
        user.setDescription("test addWithSubSubTransaction");
        int result = addUser(user);
        log.info("addWithSubSubTransaction affect:{}", result);
        throw new RuntimeException("addWithSubSubTransaction");
    }


    @Transactional(rollbackFor = Exception.class)
    public int addUserWithTransactionManagerCallback(){
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                System.out.println("I have Commit");
            }
        });
        User user = new User();
        user.setDescription("测试 addUserWithTransactionManagerCallback");
        int result = addUser(user);
        log.info("addUserWithTransactionManagerCallback 修改行数为:{}", result);
        // throw new RuntimeException("addUserWithTransaction 故意报错");\
        return result;
    }

}
