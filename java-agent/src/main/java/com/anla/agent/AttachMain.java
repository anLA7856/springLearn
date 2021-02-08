package com.anla.agent;


import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * 1. 启动 StackDisappearDemo
 * 2. 启动AttachMain
 * @author luoan
 * @version 1.0
 * @date 2021/2/8 16:37
 **/
public class AttachMain {
    public static void main(String args[]) {
        try {
            String javaPid = "15192";
            VirtualMachine vm = VirtualMachine.attach(javaPid);
            System.out.println(javaPid);
            vm.loadAgent("E:\\java_util\\java-agent-1.0-SNAPSHOT.jar");
            vm.detach();
        } catch (AttachNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AgentLoadException e) {
            e.printStackTrace();
        } catch (AgentInitializationException e) {
            e.printStackTrace();
        }
    }
}
