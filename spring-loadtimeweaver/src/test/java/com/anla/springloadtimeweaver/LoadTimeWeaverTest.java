package com.anla.springloadtimeweaver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/4/27 13:16
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes ={CustomerLoadTimeWeaverConfig.class})
public class LoadTimeWeaverTest {

    @Autowired
    private LoadTimeWeaverService loadTimeWeaverService;


    @Test
    public void testLTW() throws InterruptedException {

        loadTimeWeaverService.test();

    }
}
