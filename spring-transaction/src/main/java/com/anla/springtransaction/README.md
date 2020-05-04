在调试中，发现事务突然无法切入了。这个正在找原因：
1. main服务启动时候，在通用aop获取@Aspect时候，也没有AnnotationTransactionAspect切面。
2. 发现在获取切面时候，主要由于 AnnotationTransactionAspect 中有 `ajc$perSingletonInstance` 字段导致获取失败。
3. 下一步继续研究这个问题，从书本上看一遍看书上怎么讲。
原因已找到，是使用AspecJ模式导致