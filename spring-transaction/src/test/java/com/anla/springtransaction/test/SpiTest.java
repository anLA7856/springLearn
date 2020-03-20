package com.anla.springtransaction.test;

import com.anla.springtransaction.TransactionApplication;
import com.anla.springtransaction.springspi.SpringSpiBeanTest;
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
 * @date 2020/3/20 13:48
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TransactionApplication.class)
@WebAppConfiguration
@Slf4j
public class SpiTest {

    @Autowired
    private SpringSpiBeanTest springSpiBeanTest;



    @Test
    public void printNameTest(){
        springSpiBeanTest.printName();
    }
}
