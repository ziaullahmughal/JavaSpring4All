/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.jspringusers.template;

import evs.jspringusers.dao.Users_allDao;
import evs.jspringusers.model.users_all;
import evs.jspringusers.rowmapper.User_allRowMapper;
import java.sql.Timestamp;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Users_allJdbcTemplate implements Users_allDao {

    private DataSource datasource;

    private JdbcTemplate template;

    @Override
    public void setDataSource(DataSource ds) {
        this.datasource = ds;
        this.template = new JdbcTemplate(this.datasource);
    }

    @Override
    public boolean create(users_all user) {
        // Create 
        String sql = "INSERT INTO users_all (description, user_name, user_password, email_address, phone_num) "
                + "VALUES (?,?,?,?,?)";
        int ret = template.update(sql,
                user.getDescription(), user.getUser_name(), user.getUser_password(),
                user.getEmail_address(), user.getPhone_num());
        return ret > 0;
    }

    @Override
    public users_all get(Integer id) {
        String sql = query + " WHERE user_id=?";
        users_all user = null;
        try {
            user = template.queryForObject(
                    sql, // SQL
                    new User_allRowMapper(), // Row Mapper
                    id
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<users_all> all() {
        return template.query(query, new User_allRowMapper());
    }

    @Override
    public boolean update(users_all user) {
        // Create 
        String sql = "UPDATE users_all "
                + "SET description=?, user_name=?, user_password=?, "
                + "email_address=?, phone_num=?, is_enabled=?"
                + "WHERE user_id=?";
        int ret = template.update(sql,
                user.getDescription(), user.getUser_name(), user.getUser_password(),
                user.getEmail_address(), user.getPhone_num(), user.getIs_enabled(),
                user.getUser_id());
        return ret > 0;
    }

    @Override
    public boolean delete(Integer id) {
        // Create 
        String sql = "DELETE FROM users_all WHERE user_id=?";
        int ret = template.update(sql, id);
        return ret > 0;
    }

    @Override
    public users_all validate(String username, String userpass, String is_enabled) {
        // Validate 
        String sql = query + " WHERE is_enabled = 'Y' and user_name=? and user_password=?";
        users_all user = null;
        try {
            user = template.queryForObject(
                    sql, // SQL
                    new User_allRowMapper(), // Row Mapper
                    username, userpass
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
