package sz.zxl.com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sz.zxl.com.demo.component.LoginHandlerInterceptor;
import sz.zxl.com.demo.component.MyLocaleResolver;



//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

	/**
	 * 视图映射
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/index.html").setViewName("login");
		registry.addViewController("/main.html").setViewName("dashboard");
		registry.addViewController("/code").setViewName("login");
	}

	// 注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// WebMvcConfigurer.super.addInterceptors(registry);
		// .addPathPatterns("/**"(任意多层路径下的任意请求)) 拦截哪些请求
		// excludePathPatterns 不需要拦截的请求
		// 静态资源: springboot 已经做了静态资源映射
		registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html",
				"/", "/login","/asserts/**", "/webjars/**","/emp","/addemp","/code.action");
	}

	@Bean
	public LocaleResolver localeResolver() {
		System.out.println("进来自建的MyLocaleResolver....");
		return new MyLocaleResolver();

	}
	//分页插件注入
	

	/*@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}
*/
	/*
	 * @Bean //将组件注册在容器 Spring Boot2.0的版本这个类过期了 WebMvcConfigurerAdapter 过时 public
	 * WebMvcConfigurerAdapter webMvcConfigurerAdapter(){ WebMvcConfigurerAdapter
	 * adapter = new WebMvcConfigurerAdapter() {
	 * 
	 * @Override public void addViewControllers(ViewControllerRegistry registry) {
	 * registry.addViewController("/").setViewName("login");
	 * registry.addViewController("/index.html").setViewName("login"); } }; return
	 * adapter; }
	 */

}
