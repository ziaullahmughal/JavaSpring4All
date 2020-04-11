/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.jspringusers.dao;

import evs.jspringusers.model.users_all;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author zia
 */
public interface Users_allDao {

    public String query = "SELECT "
            + "user_id, description, user_name, user_password, email_address, phone_num, is_enabled, creation_date, last_update_date "
            + "FROM users_all";

    // Database 
    public void setDataSource(DataSource ds);

    // Create
    public boolean create(users_all user);

    // Read Single
    public users_all get(Integer id);

    // Read All
    public List<users_all> all();

    // Update
    public boolean update(users_all user);

    // Delete
    public boolean delete(Integer id);

    // Validate 
    public users_all validate(String username, String userpass, String is_enabled);
}
