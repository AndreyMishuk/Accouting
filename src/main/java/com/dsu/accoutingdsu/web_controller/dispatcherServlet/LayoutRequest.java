package com.dsu.accoutingdsu.web_controller.dispatcherServlet;

import com.dsu.accoutingdsu.entity.Post;
import com.dsu.accoutingdsu.entity.UserProfile;
import com.dsu.accoutingdsu.entity.WorkCategory;
import com.dsu.accoutingdsu.service.UserProfileService;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class LayoutRequest {

    UserProfileService userService = new UserProfileService();

    public void editUser(HttpServletRequest request) throws SQLException {

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

    public void addUser(HttpServletRequest request) throws SQLException {

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

    public void removeUser(HttpServletRequest request) throws SQLException {

        userService.removeUserById(Integer.parseInt(request.getParameter("id")));

    }

}
