package com.anla.springtransactionaspectJ.service;

import com.anla.springtransactionaspectJ.dao.UserMapper;
import com.anla.springtransactionaspectJ.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author luoan
 * @version 1.0
 * @date 2020/1/16 15:48
 **/
@Service
@Slf4j
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public int addUser(User user){
        return userMapper.insertSelective(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public int addUserWithTransaction(){
        User user = new User();
        user.setDescription("测试 addUserWithTransaction");
        int result = addUser(user);
        log.info("addUserWithTransaction 修改行数为:{}", result);
        throw new RuntimeException("addUserWithTransaction 故意报错");
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
}
