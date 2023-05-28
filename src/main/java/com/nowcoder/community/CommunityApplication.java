package com.nowcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * SpringBootApplication:标识了一个springboot项目工程
 * 包含了三个注解组合其实这个注解就是
 * SpringBootConfiguration
 * 只是用来修饰是 Spring Boot 配置而已，
 * EnableAutoConfiguration
 * 允许 Spring Boot 自动配置注解，开启这个注解之后，Spring Boot 就能根据当前类路径下的包或者类来配置 Spring Bean。
 * ComponentScan
 * 这是 Spring 3.1 添加的一个注解，用来代替配置文件中的 component-scan 配置，开启组件扫描，即自动扫描包路径下的 @Component 注解进行注册 bean 实例到 context 中。
 * Bean注解：定义Bean
 * @Controller
 * 控制器，处理http请求。
 * @RequestBody
 * 通过HttpMessageConverter读取Request Body并反序列化为Object（泛指）对象
 * @RequestMapping
 * @RequestMapping 是 Spring Web 应用程序中最常被用到的注解之一。这个注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上
 * @GetMapping用于将HTTP get请求映射到特定处理程序的方法注解
 * @PathVariable:获取url中的数据
 * @RequestParam:获取请求参数的值
 * @RequestHeader 把Request请求header部分的值绑定到方法的参数上
 * @CookieValue 把Request header中关于cookie的值绑定到方法的参数上
 * @Component
 * 把普通pojo实例化到spring容器中，相当于配置文件中的
 * @Repository
 * DAO层注解，DAO层中接口继承JpaRepository<T,ID extends Serializable>,需要在build.gradle中引入相关jpa的一个jar自动加载
 * @Service是@Component注解的一个特例，作用在类上
 * @Service注解作用域默认为单例
 * 使用注解配置和类路径扫描时，被@Service注解标注的类会被Spring扫描并注册为Bean
 * @Service用于标注服务层组件,表示定义一个bean
 * @ExceptionHandler 注解声明异常处理方法
 * @ControllerAdvice 注解定义全局异常处理类
 */
@SpringBootApplication
public class CommunityApplication {

	@PostConstruct
	public void init() {
		// 解决netty启动冲突问题
		// see Netty4Utils.setAvailableProcessors()
		System.setProperty("es.set.netty.runtime.available.processors", "false");
	}
	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

}
