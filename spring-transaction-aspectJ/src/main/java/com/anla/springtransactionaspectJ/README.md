在调试中，发现事务突然无法切入了。这个正在找原因：
1. main服务启动时候，在通用aop获取@Aspect时候，也没有AnnotationTransactionAspect切面。
2. 发现在获取切面时候，主要由于 AnnotationTransactionAspect 中有 `ajc$perSingletonInstance` 字段导致获取失败。
3. 下一步继续研究这个问题，从书本上看一遍看书上怎么讲。
原因已找到，是使用AspecJ模式导致

Spring AOP 与 AspectJ 异同点：
https://blog.csdn.net/dm_vincent/article/details/57526325
1. AspectJ的功能更加全面和强大。支持全部的Pointcut类型。
2. 毕竟Spring作为一个以集成起家的框架，在设计Spring AOP的时候也是为了减轻开发人员负担而做了不少努力的。它提供的开箱即用(Out-of-the-box)的众多AOP功能让很多开发人员甚至都不知道什么是AOP
3. Spring AOP: 基于代理(Proxying) AspectJ: 基于字节码操作(Bytecode Manipulation)


