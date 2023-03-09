package com.jiangls.spring.springwebmvc.config.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义OncePerRequestFilter
 * @author Jiangls
 * @date 2023/3/9
 */
@Component
public class MyFilter2 extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("--------------------myfilter2 start");

        filterChain.doFilter(request, response);

        System.out.println("--------------------myfilter2 end");
    }
}
