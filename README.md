AOP（Aspect Oriented Programming），即面向切面编程（也叫面向方面编程，面向方法编程）。其主要作用是，在不修改源代码的情况下给某个操作添加额外的功能。像日志记录，事务处理，权限控制，都可以用AOP来“优雅”地实现，使这些额外功能和真正的业务逻辑分离开来，软件的结构将更加清晰。

Spring AOP是基于代理机制的，通过JDK Proxy和CGLIB Proxy两种方法实现代理。
1）如果target object没有实现任何接口，那么Spring将使用CGLIB来实现代理。CGLIB是一个开源项目,它是一个强大的,高性能,高质量的Code生成类库,它可以在运行期扩展Java类与实现Java接口。
2）如果target object实现了一个以上的接口，那么Spring将使用JDK Proxy来实现代理，因为Spring默认使用的就是JDK Proxy，并且JDK Proxy是基于接口的。这也是Spring提倡的面向接口编程。