package com.baidu.fsg.uid.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.baidu.fsg.uid.worker.mapper")
public class DataSourceConfig {

}
