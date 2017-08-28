
package com.dsu.accoutingdsu.dao;


import com.dsu.accoutingdsu.entity.Post;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;


public interface IPost {
    
    // create
    void addPost(String post, BigDecimal salary) throws SQLException;
    
    // read
    List<Post> getAllPost() throws SQLException;
    Post getPost() throws SQLException;
    
    // delete
    void removePost(Integer postId) throws SQLException;
}
