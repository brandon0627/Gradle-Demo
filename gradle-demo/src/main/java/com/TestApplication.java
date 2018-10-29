package com;

//import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
// @EnableAutoConfiguration
//@MapperScan("com.dao") // 将项目中对应的mapper类的路径加进来就可以了
public class TestApplication extends SpringBootServletInitializer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@RequestMapping("/hello")
	@ResponseBody
	public String home() {
		System.out.println("========进入home============");
		logger.trace("日志输出 trace");
		logger.debug("日志输出 debug");
		logger.info("日志输出 info");
		logger.warn("日志输出 warn");
		logger.error("日志输出 error");
		return "Hello ,spring boot!";
	}

//	@Bean
//	public MultipartConfigElement multipartConfigElement() {
//		MultipartConfigFactory factory = new MultipartConfigFactory();
//		// 单个数据大小
//		factory.setMaxFileSize("307200KB");
//		// 总上传数据大小
//		factory.setMaxRequestSize("307200KB");
//		return factory.createMultipartConfig();
//	}

}
