package com.dsu.accoutingdsu.web_controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "PageRedirectSecurityFilte", urlPatterns = "/jsp/*",
        initParams = {
            @WebInitParam(name = "INDEX_PATH", value = "/index.jsp")})

public class PageRedirectSecurityFilter implements Filter {

    private String indexPath;

    public PageRedirectSecurityFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponcse = (HttpServletResponse) response;
        System.out.println("****************************************");
        httpResponcse.sendRedirect(httpRequest.getContextPath() + indexPath);
        chain.doFilter(request, response);
    }

    /**
     * Destroy method for this filter
     */
    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {

        indexPath = filterConfig.getInitParameter("INDEX_PATH");

    }

}
