package com.anla.springaop.advisor;

/**
 * test文件下有具体例子，这样就可以，不更改框架源码，改变框架行为
 *
 * 用于在someService上面，实现其他功能接口
 * @author luoan
 * @version 1.0
 * @date 2020/5/7 11:56
 **/
public interface IOther {
    /**
     * 该接口提供doOther功能
     */
    public void doOther();
}
