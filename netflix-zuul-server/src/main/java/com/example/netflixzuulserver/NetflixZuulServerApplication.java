package com.example.netflixzuulserver;

import com.example.netflixzuulserver.filter.CustomZullFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy // 开启网关功能
public class NetflixZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NetflixZuulServerApplication.class, args);
    }

    /**
     * 开启过滤器
     *
     * @return
     */
    @Bean
    public CustomZullFilter preCustomZullFilter() {
        return new CustomZullFilter();
    }
}
