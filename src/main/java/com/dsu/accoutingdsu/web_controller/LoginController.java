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

@WebServlet(name = "LoginController", urlPatterns = {"/persannelDepartment"})
//@ServletSecurity( @HttpConstraint(rolesAllowed = {"persanneldepartment"}) )
public class LoginController extends DispatcherServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url="/error/401.html";
        String name = request.getUserPrincipal().getName();

        if (request.isUserInRole("persanneldepartment")) {
            url = "/staff";
            request.setAttribute("nameUser",name);
        } else {
            forward("/error/401.html", request, response);
        }

        request.getRequestDispatcher(url).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
