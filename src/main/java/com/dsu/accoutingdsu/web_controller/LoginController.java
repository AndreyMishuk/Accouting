/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsu.accoutingdsu.web_controller;

import com.dsu.accoutingdsu.web_controller.dispatcherServlet.DispatcherServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends DispatcherServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
        if("andrey".equals(login) && "qwerty".equals(password)) {

            request.setAttribute("name", login);
            
            request.getRequestDispatcher("staf").forward(request, response);
            
        } else {
            forward("/error/401.html", request, response);
        }
        
        
    }

  

}
