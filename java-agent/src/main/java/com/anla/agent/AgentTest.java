package com.anla.agent;

/**1. 加上打包完的agent：-javaagent:E:\idea-project\anla\springLearn\java-agent\target\java-agent-1.0-SNAPSHOT.jar
 * @author luoan
 * @version 1.0
 * @date 2020/4/27 11:02
 **/
public class AgentTest {
    public static void main(String[] args) {
        System.err.println("TestHelloAgent main 方法");
    }
}
