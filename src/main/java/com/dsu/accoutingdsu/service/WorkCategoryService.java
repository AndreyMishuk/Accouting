
package com.dsu.accoutingdsu.service;

import com.dsu.accoutingdsu.dao.IWorkCategory;
import com.dsu.accoutingdsu.entity.WorkCategory;
import com.dsu.accoutingdsu.util.SessionUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class WorkCategoryService extends SessionUtil implements IWorkCategory{

    @Override
    public List<WorkCategory> getAllCategory() throws SQLException {
        
        openTransactionSession();
        Session session = getSession();
        
        String sql = "FROM WorkCategory";
        Query query = session.createQuery(sql);
        
        List<WorkCategory> listPost = query.list();
        
        closeTransactionSession();
        
        return listPost;
        
    }
    
}
