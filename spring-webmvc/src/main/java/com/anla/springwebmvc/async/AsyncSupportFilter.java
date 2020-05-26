package com.anla.springwebmvc.async;

import org.apache.catalina.Globals;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 开启异步处理
 *
 * @author luoan
 * @version 1.0
 * @date 2020/5/26 16:50
 **/
@Component
public class AsyncSupportFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setAttribute(Globals.ASYNC_SUPPORTED_ATTR, true);
        chain.doFilter(request, response);
    }
}
