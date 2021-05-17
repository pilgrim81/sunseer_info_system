package jp.co.sunseer.sunseerservice.sunseerprj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

//@SpringBootApplication
//@PropertySource(value = {"classpath:jp.co.sunseer.sunseerservice.sunseerprj.config/config_prj"})
@EnableAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class sunseerprjApplication {

	public static void main(String[] args) {

		SpringApplication.run(sunseerprjApplication.class, args);
	}

}
