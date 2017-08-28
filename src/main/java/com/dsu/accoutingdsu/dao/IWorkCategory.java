
package com.dsu.accoutingdsu.dao;

import com.dsu.accoutingdsu.entity.WorkCategory;
import java.sql.SQLException;
import java.util.List;

public interface IWorkCategory {

    // read
    
    List<WorkCategory> getAllCategory() throws SQLException;
    
}
