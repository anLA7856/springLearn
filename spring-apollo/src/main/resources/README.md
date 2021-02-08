1. apollo.meta.`环境` 的配置文件读取：DefaultMetaServerProvider
2. app.id 和 apollo.accesskey.secret 配置文件：DefaultApplicationProvider
3. apollo.refreshInterval : 延时任务刷新间隔，默认5秒
4. apollo.connectTimeout：建立http连接超时时间，默认为1秒
5. apollo.readTimeout：读超时时间，默认5秒
6. apollo.cluster：集群，如果没有配置，则使用datacenter作为，如果datacenter也没有，就用默认的default。
7. apollo.loadConfigQPS：每秒次数，默认为2，用于令牌桶限流算法。
8. apollo.configCacheSize： 缓存key的数量，默认为500
9. apollo.longPollingInitialDelayInMills：长轮训初始轮训延迟，默认2秒
10. apollo.autoUpdateInjectedSpringProperties：是否自动更新，默认为false。
11. apollo.property.order.enable：是否保持配置在配置文件中的顺序性，默认为false。
12. apollo.cacheDir： 本地缓存路径 C:\\opt\\data\\%s" : "/opt/data/%s"