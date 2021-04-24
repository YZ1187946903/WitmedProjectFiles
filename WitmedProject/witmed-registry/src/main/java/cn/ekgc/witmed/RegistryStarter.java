package cn.ekgc.witmed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <b>智慧医疗-注册中心启动类</b>
 * @author Arthur
 * @version 1.0.0
 */
@EnableEurekaServer
@SpringBootApplication
public class RegistryStarter {
	public static void main(String[] args) {
		SpringApplication.run(RegistryStarter.class, args);
	}
}
