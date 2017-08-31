/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsu.accoutingdsu.web_controller.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author andrey
 */
public class SetCharFilter implements Filter {
    
   
    private FilterConfig filterConfig = null;
    
    public SetCharFilter() {
    }    

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String encoding = request.getCharacterEncoding();
        if(!"UTF-8".equalsIgnoreCase(encoding)) {
            response.setCharacterEncoding("UTF-8");
        }
        
    }

    @Override
    public void destroy() {
    }
    
   
    
}
