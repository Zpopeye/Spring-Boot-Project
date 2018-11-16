package sz.zxl.com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("sz.zxl.com")
@MapperScan("sz.zxl.com.demo.dao")
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}
}
