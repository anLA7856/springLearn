package com.anla.springtransaction.test;

import com.anla.springtransaction.TransactionApplication;
import com.anla.springtransaction.dao.UserMapper;
import com.anla.springtransaction.model.User;
import com.anla.springtransaction.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 15:58
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TransactionApplication.class)
@WebAppConfiguration
@Slf4j
public class TransactionTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    /**
     * 会回滚
     */
    @Test
    public void addUserWithTransactionTest(){
        userService.addUserWithTransaction();
    }

    /**
     * 不会回滚
     */
    @Test
    public void addUserWithOutTransactionTest(){
        userService.addUserWithOutTransaction();
    }

    @Test
    public void addWithSubTransactionTest(){
        userService.addWithSubTransaction();
    }

    @Test
    public void addWithSubNoTransactionTest(){
        userService.addWithSubNoTransaction();
    }

    /**
     * 是否提交，主要看是否设置mysql 的 autoCommit
     * 需要手动提交，否则不会提交
     */
    @Test
    public void autoSubmitTest(){
        User user = new User();
        user.setDescription("autoSubmitTest");
        userMapper.insertSelective(user);
    }
}
