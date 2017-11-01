package com.dsu.accoutingdsu.web_controller;

import com.dsu.accoutingdsu.entity.Post;
import com.dsu.accoutingdsu.entity.UserProfile;
import com.dsu.accoutingdsu.entity.WorkCategory;
import com.dsu.accoutingdsu.service.PostService;
import com.dsu.accoutingdsu.service.UserProfileService;
import com.dsu.accoutingdsu.service.WorkCategoryService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PersannelDepartment", urlPatterns = "/staff")
//@RolesAllowed("persanneldepartment")
public class PersannelDepartment extends HttpServlet {
    
    UserProfileService userService = new UserProfileService();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
    
        WorkCategoryService categoryService = new WorkCategoryService();
        PostService postService = new PostService();        
        
        List<Post> listPost = null;
        List<WorkCategory> listCategory = null;
        List<UserProfile> listUsers = null, listOneUser = null;
        
        int userId_int;
        
        String nameUser = (String) request.getAttribute("nameUser");
        request.setAttribute("nameUser", nameUser);
        
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
                helperEditUser(request);
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
                helperAddUser(request);
            } catch (SQLException ex) {
                System.out.println("SQL ERROR: " + ex);
            }
            
        }
        
        if (removeButton != null) {
            
            try {
                helperRemoveUser(request);
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
        
        request.getRequestDispatcher("/WEB-INF/persannelDepartment/staff.jsp").forward(request, response);
        
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
    
private void helperEditUser(HttpServletRequest request) throws SQLException {

        UserProfile user = new UserProfile();

        user.setUserId((Integer.parseInt(request.getParameter("id"))));
        user.setUserSurname(request.getParameter("surname"));
        user.setUserName(request.getParameter("name"));
        user.setUserMiddleName(request.getParameter("middlename"));
        user.setPost(new Post());
        user.getPost().setPostId(Integer.parseInt(request.getParameter("post")));
        user.setWorkCategory(new WorkCategory());
        user.getWorkCategory().setCategoryId(Integer.parseInt(request.getParameter("category")));

        userService.updateUser(user);

    }

    private void helperAddUser(HttpServletRequest request) throws SQLException {

        UserProfile user = new UserProfile();

        user.setUserSurname(request.getParameter("surnameAdd"));
        user.setUserName(request.getParameter("nameAdd"));
        user.setUserMiddleName(request.getParameter("middlenameAdd"));
        user.setPost(new Post());
        user.getPost().setPostId(Integer.parseInt(request.getParameter("postAdd")));
        user.setWorkCategory(new WorkCategory());
        user.getWorkCategory().setCategoryId(Integer.parseInt(request.getParameter("categoryAdd")));

        userService.addUser(user);

    }

    private void helperRemoveUser(HttpServletRequest request) throws SQLException {

        userService.removeUserById(Integer.parseInt(request.getParameter("id")));

    }    
    
}
