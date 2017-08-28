
package com.dsu.accoutingdsu.service;

import com.dsu.accoutingdsu.dao.IPost;
import com.dsu.accoutingdsu.entity.Post;
import com.dsu.accoutingdsu.util.SessionUtil;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


public class PostService extends SessionUtil implements IPost{

    @Override
    public void addPost(String post, BigDecimal salary) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> getAllPost() throws SQLException {
        
        openTransactionSession();
        Session session = getSession();
        
        String sql = "FROM Post";
        Query qurey = session.createQuery(sql);
        
        List<Post> listPost = qurey.list();
        
        closeTransactionSession();
        
        return listPost;
    }

    @Override
    public Post getPost() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePost(Integer postId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
