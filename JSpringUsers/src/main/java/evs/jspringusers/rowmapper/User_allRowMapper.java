/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.jspringusers.rowmapper;

import evs.jspringusers.model.users_all;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class User_allRowMapper implements RowMapper<users_all>{
    
    @Override
    public users_all mapRow(ResultSet rs, int i) throws SQLException {
        users_all u = new users_all();
        u.setUser_id(rs.getInt("user_id"));        
        u.setDescription(rs.getString("description"));
        u.setUser_name(rs.getString("user_name"));
        u.setUser_password(rs.getString("user_password"));        
        u.setEmail_address(rs.getString("email_address"));
        u.setPhone_num(rs.getString("phone_num"));
        u.setIs_enabled(rs.getString("is_enabled"));
        u.setCreation_date(rs.getTimestamp("creation_date"));
        u.setLast_update_date(rs.getTimestamp("last_update_date"));        
        return u;
    }
}
