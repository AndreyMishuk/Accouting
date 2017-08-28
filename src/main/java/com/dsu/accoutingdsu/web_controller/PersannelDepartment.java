package com.dsu.accoutingdsu.web_controller;

import com.dsu.accoutingdsu.entity.Post;
import com.dsu.accoutingdsu.entity.UserProfile;
import com.dsu.accoutingdsu.entity.WorkCategory;
import com.dsu.accoutingdsu.service.PostService;
import com.dsu.accoutingdsu.service.UserProfileService;
import com.dsu.accoutingdsu.service.WorkCategoryService;
import com.dsu.accoutingdsu.web_controller.dispatcherServlet.LayoutRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PersannelDepartment", urlPatterns = "/staf")
public class PersannelDepartment extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        UserProfileService userService = new UserProfileService();
        PostService postService = new PostService();
        WorkCategoryService categoryService = new WorkCategoryService();
        LayoutRequest lr = new LayoutRequest();
        
        List<Post> listPost = null;
        List<WorkCategory> listCategory = null;
        List<UserProfile> listUsers = null, listOneUser = null;
        
        int userId_int;
        
        String userIdButton = request.getParameter("userId");
        
        String editButton = request.getParameter("edit");
        
        String addButton = request.getParameter("addButton");
        
        String removeButton = request.getParameter("remove");
        
        String addRedactButton = request.getParameter("addRedact");
        
        if (userIdButton != null) {
            
            try {
                userId_int = Integer.parseInt(userIdButton);
                listOneUser = userService.getUserById(userId_int);
                listPost = postService.getAllPost();
                listCategory = categoryService.getAllCategory();
                
            } catch (SQLException ex) {
                System.out.println("SQL ERROR: " + ex);
            }
            
            request.setAttribute("listPost", listPost);
            request.setAttribute("listCategory", listCategory);
            request.setAttribute("listOneUser", listOneUser);
            
        }
        
        if (editButton != null) {
            
            try {
                lr.editUser(request);
            } catch (SQLException ex) {
                System.out.println("SQL ERROR: " + ex);
            }
        }
        
        if (addButton != null) {
            
            try {
                listPost = postService.getAllPost();
                listCategory = categoryService.getAllCategory();
                
                request.setAttribute("lPost", listPost);
                request.setAttribute("lCategory", listCategory);
            } catch (SQLException ex) {
                System.out.println("SQL ERROR: " + ex);
            }
            
        }
        
        if (addRedactButton != null) {
            
            try {
                lr.addUser(request);
            } catch (SQLException ex) {
                System.out.println("SQL ERROR: " + ex);
            }
            
        }
        
        if (removeButton != null) {
            
            try {
                lr.removeUser(request);
            } catch (SQLException ex) {
                System.out.println("SQL ERROR: " + ex);
            }
            
            
        }
        
        try {
            listUsers = userService.getAllUsers();
            
        } catch (SQLException ex) {
            System.out.println("SQL ERROR: " + ex);
        }
        
        request.setAttribute("listUsers", listUsers);
        
        request.getRequestDispatcher("/WEB-INF/persannelDepartment/staf.jsp").forward(request, response);
        
    }
    
}
