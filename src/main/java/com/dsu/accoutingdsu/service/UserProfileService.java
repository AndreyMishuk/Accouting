package com.dsu.accoutingdsu.service;


import com.dsu.accoutingdsu.dao.IUserProfile;
import com.dsu.accoutingdsu.entity.UserProfile;
import com.dsu.accoutingdsu.util.SessionUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class UserProfileService extends SessionUtil implements IUserProfile {

    @Override
    public void addUser(UserProfile user) throws SQLException {

        openTransactionSession();
        Session session = getSession();

        session.save(user);

        closeTransactionSession();

    }

    @Override
    public List<UserProfile> getAllUsers() throws SQLException {

        openTransactionSession();

        String sql = "FROM UserProfile as u LEFT JOIN FETCH u.post as p "
                + "LEFT JOIN FETCH u.workCategory as wc";

        Session session = getSession();
        Query query = session.createQuery(sql);

        List<UserProfile> listUsers = query.list();
        closeTransactionSession();
        return listUsers;
    }

    @Override
    public List<UserProfile> getUserById(Integer userId) throws SQLException {

        openTransactionSession();
        Session session = getSession();

        String sql = "FROM UserProfile as u LEFT JOIN FETCH u.post as p "
                + "LEFT JOIN FETCH u.workCategory as wc "
                + "WHERE u.userId = :userId";
        
        Query query = session.createQuery(sql);
        query.setParameter("userId", userId);
        
        List<UserProfile> listOneUser = query.list();
        
        closeTransactionSession();

        return listOneUser;
    }

    @Override
    public void removeUserById(Integer userId) throws SQLException {
        
        openTransactionSession();
        Session session = getSession();
        
        UserProfile user = (UserProfile) session.load(UserProfile.class, userId);
        
        if(user != null) {
            session.delete(user);
        }
        
        closeTransactionSession();
        
    }

    @Override
    public void updateUser(UserProfile user) throws SQLException {
        
        openTransactionSession();
        Session session = getSession();
        
        session.update(user);
        
        closeTransactionSession();
        
    }

    

}
