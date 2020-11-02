package com.anla.springwebfluxhello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring WebFlux特性
 *
 * 特性一 异步非阻塞
 *
 * 众所周知，SpringMVC是同步阻塞的IO模型，资源浪费相对来说比较严重，当我们在处理一个比较耗时的任务时，例如：上传一个比较大的文件，首先，服务器的线程一直在等待接收文件，在这期间它就像个傻子一样等在那儿（放学别走），什么都干不了，好不容易等到文件来了并且接收完毕，我们又要将文件写入磁盘，在这写入的过程中，这根线程又再次懵bi了，又要等到文件写完才能去干其它的事情。这一前一后的等待，不浪费资源么？
 *
 * 没错，Spring WebFlux就是来解决这问题的，Spring WebFlux可以做到异步非阻塞。还是上面那上传文件的例子，Spring WebFlux是这样做的：线程发现文件还没准备好，就先去做其它事情，当文件准备好之后，通知这根线程来处理，当接收完毕写入磁盘的时候（根据具体情况选择是否做异步非阻塞），写入完毕后通知这根线程再来处理（异步非阻塞情况下）。这个用脚趾头都能看出相对SpringMVC而言，可以节省系统资源。666啊，有木有！
 *
 * 特性二 响应式(reactive)函数编程
 *
 * 如果你觉得java8的lambda写起来很爽，那么，你会再次喜欢上Spring WebFlux，因为它支持函数式编程，得益于对于reactive-stream的支持（通过reactor框架来实现的），喜欢java8 stream的又有福了。为什么要函数式编程？ 这个别问我，我也不知道，或许是因为bi格高吧，哈哈，开玩笑啦。
 *
 * 特性三 不再拘束于Servlet容器
 *
 * 以前，我们的应用都运行于Servlet容器之中，例如我们大家最为熟悉的Tomcat, Jetty...等等。而现在Spring WebFlux不仅能运行于传统的Servlet容器中（前提是容器要支持Servlet3.1，因为非阻塞IO是使用了Servlet3.1的特性），还能运行在支持NIO的Netty和Undertow中。
 *
 * 所以，看完Spring WebFlux的新特性之后，内心五味杂陈的我，只能用一个表情来形容：
 *
 *
 *
 * @author luoan
 * @version 1.0
 * @date 2020/6/7 19:30
 **/
@SpringBootApplication
public class WebFluxHelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebFluxHelloApplication.class, args);
    }

}
