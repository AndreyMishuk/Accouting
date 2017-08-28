
package com.dsu.accoutingdsu.dao;


import com.dsu.accoutingdsu.entity.UserProfile;
import java.sql.SQLException;
import java.util.List;

public interface IUserProfile {
    
    // create
    void addUser(UserProfile user) throws SQLException;
    
    void updateUser(UserProfile user) throws SQLException;
    
    // read
    List<UserProfile> getAllUsers() throws SQLException;
    List<UserProfile> getUserById(Integer userId) throws SQLException;
    
    // delete
    void removeUserById(Integer userId) throws SQLException;
    
}
