package com.wyq.emailcode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//取消数据源自动配置
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EmailcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailcodeApplication.class, args);
    }

}
