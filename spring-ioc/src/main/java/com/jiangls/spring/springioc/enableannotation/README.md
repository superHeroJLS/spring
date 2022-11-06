## @Enable*注解的工作原理
在本章的第一部分我们通过:
1. @EnableAspectJAutoProxy开启对AspectJ自动代理的支持。
2. @EnableAsync开启异步方法的支持。
3. @EnableScheduling开启计划任务的支持。

通过简单的@Enable*来开启一项功能的支持，从而避免自己配置大量的代码，大大降低使用难度。那么这个神奇的功能的实现原理是什么呢?
我们一起来研究一下。通过观察这些@Enable*注解的源码，我们发现所有的注解都有一个@Import注解，@Import是用来导入配置类的，
这也就意味着这些自动开启的实现其实是导入了一些自动配置的Bean。这些导入的配置方式主要分为以下三种类型。

1. 第一类：直接导入Configuration类，@EnableScheduling
2. 第二类：依据条件选择Configuration类，@EnableAsync
3. 第三类：动态注册Bean，@EnableAspectJAutoProxy

可以直接进入源码查看。

