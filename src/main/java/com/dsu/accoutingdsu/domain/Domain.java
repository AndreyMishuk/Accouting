package com.dsu.accoutingdsu.domain;

import com.dsu.accoutingdsu.entity.Post;
import com.dsu.accoutingdsu.entity.UserProfile;
import com.dsu.accoutingdsu.entity.WorkCategory;
import com.dsu.accoutingdsu.service.UserProfileService;
import com.dsu.accoutingdsu.util.HibernateUtil;
import java.sql.SQLException;

public class Domain {

    public static void main(String[] args) throws SQLException {

        UserProfileService userProfileService = new UserProfileService();
        UserProfile user = new UserProfile();

//        for (UserProfile users : userProfileService.getAllUsers()) {
//            System.out.println(users.getUserSurname()+ ", " +
//                    users.getUserName() + ", " + 
//                    users.getUserMiddleName() + " - " +
//                    users.getPost().getPost() + " | " + 
//                    users.getWorkCategory().getCategory());
//            
//            System.out.println(users.toString());
//        }
//        user.setUserId(4);
        user.setUserSurname("Путин");
        user.setUserName("Вова");
        user.setUserMiddleName("D");
        user.setPost(new Post());
        user.getPost().setPostId(7);
        user.setWorkCategory(new WorkCategory());
        user.getWorkCategory().setCategoryId(3);
        
        userProfileService.addUser(user);

        HibernateUtil.shutdown();

    }
}
