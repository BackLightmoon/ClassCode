package com.sfac.javaSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*
为什么继承该类，SpringBootServletInitializer源码注释：

Note that a WebApplicationInitializer is only needed if you are building a war file and deploying it. If you prefer to run an embedded web server then you won't need this at all.

注意，如果您正在构建WAR文件并部署它，则需要WebApplicationInitializer。如果你喜欢运行一个嵌入式Web服务器，那么你根本不需要这个。

启动类代码：
@SpringBootApplication
public class JavaSpringBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(JavaSpringBootApplication.class);
    }

}
*/


@SpringBootApplication
public class JavaSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootApplication.class, args);
    }

}
