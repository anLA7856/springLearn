package com.anla.agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**1. 实现premain方法。
 * 2. 增加MAINIFEST.MF 文件
 * 3. 配置pom，指定打包路径
 * @author luoan
 * @version 1.0
 * @date 2020/4/27 10:56
 **/
public class HelloAgent {
    public static void premain(String arg, Instrumentation instrumentation) {
        System.err.println("装载成功 方法 premain 参数：" + arg);
        // agent 可以动态更改类的字节码
        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class classBeingRedefined,
                                    ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                String cname = "com.anla.agent.AgentTest";
                ClassPool classPool = new ClassPool();
                classPool.insertClassPath(new LoaderClassPath(loader));
                if (className.replaceAll("/", ".").equals(cname)) {
                    try {
                        CtClass ctClass = classPool.get(cname);
                        CtMethod ctMethod = ctClass.getDeclaredMethod("main");
                        ctMethod.insertBefore("System.err.println(System.currentTimeMillis());");

                        return ctClass.toBytecode();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return new byte[0];
            }
        });
    }
}
