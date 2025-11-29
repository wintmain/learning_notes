package com.wintmain.restfulcrud.config;

import com.wintmain.restfulcrud.component.LoginHandlerInterceptor;
import com.wintmain.restfulcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @Description
 * @Author wintmain    <wosintmain@gmail.com>
 * @Date 2022-04-10 10:40:01
 */

//使用WebMvcConfigurer可以来扩展SpringMVC的功能
//@EnableWebMvc   //不要接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送 /wintmain 请求来到 success
        registry.addViewController("/wintmain").setViewName("success");
    }

    //所有的WebMvcConfigurer组件都会一起起作用
    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer = new MyMvcConfig() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 注册拦截器

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //静态资源；  *.css , *.js
                //SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html", "/", "/user/login");
            }
        };

        return configurer;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
