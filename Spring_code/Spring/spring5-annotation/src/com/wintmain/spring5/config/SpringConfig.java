package com.wintmain.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-21 16:36:40
 */

@Configuration //作为配置类，代替xml配置文件
@ComponentScan(basePackages = {"com.wintmain.spring5"})
public class SpringConfig {

}
