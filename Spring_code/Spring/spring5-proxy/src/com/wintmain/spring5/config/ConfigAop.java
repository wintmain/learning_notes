package com.wintmain.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-03-24 23:05:07
 */

@Configuration
@ComponentScan(basePackages = {"com.wintmain"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
