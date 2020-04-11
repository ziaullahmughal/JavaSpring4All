/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.jspringusers.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.springframework.jdbc.core.RowMapper;

public class users_all implements Serializable, RowMapper<users_all> {
    private Integer user_id;
    private String description;
    private String user_name;
    private String user_password;
    private String email_address;
    private String phone_num;
    private String is_enabled;
    private Timestamp creation_date;
    private Timestamp last_update_date;

    public users_all() {
    }

    public users_all(Integer user_id, String description, String user_name, String user_password, String email_address, String phone_num, String is_enabled) {
        this.user_id = user_id;
        this.description = description;
        this.user_name = user_name;
        this.user_password = user_password;
        this.email_address = email_address;
        this.phone_num = phone_num;
        this.is_enabled = is_enabled;
    }

    public users_all(Integer user_id, String user_name, String user_password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public users_all(String user_name, String user_password) {
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public users_all(String description, String user_name, String user_password, String email_address, String phone_num) {
        this.description = description;
        this.user_name = user_name;
        this.user_password = user_password;
        this.email_address = email_address;
        this.phone_num = phone_num;
    }

    public users_all(Integer user_id, String description, String user_name, String user_password, String email_address, String phone_num, String is_enabled, Timestamp creation_date, Timestamp last_update_date) {
        this.user_id = user_id;
        this.description = description;
        this.user_name = user_name;
        this.user_password = user_password;
        this.email_address = email_address;
        this.phone_num = phone_num;
        this.is_enabled = is_enabled;
        this.creation_date = creation_date;
        this.last_update_date = last_update_date;
    }

    public users_all(String description, String user_name, String user_password, String email_address, String phone_num, String _enabled) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(String is_enabled) {
        this.is_enabled = is_enabled;
    }

    public Timestamp getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Timestamp creation_date) {
        this.creation_date = creation_date;
    }

    public Timestamp getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Timestamp last_update_date) {
        this.last_update_date = last_update_date;
    }

    

    @Override
    public String toString() {
        return "users_all{" + "user_id=" + user_id + ", description=" + description + ", user_name=" + user_name + ", user_password=" + user_password + ", email_address=" + email_address + ", phone_num=" + phone_num + ", is_enabled=" + is_enabled + ", creation_date=" + creation_date + ", last_update_date=" + last_update_date + '}';
    }

   
    
    @Override
    public users_all mapRow(ResultSet rs, int i) throws SQLException {
        users_all usr = new users_all();
        usr.setUser_id(rs.getInt("user_id"));
        usr.setDescription(rs.getString("description"));
        usr.setUser_name(rs.getString("user_name"));
        usr.setUser_password(rs.getString("user_password"));
        usr.setEmail_address(rs.getString("email_address"));
        usr.setPhone_num(rs.getString("phone_num"));
        usr.setIs_enabled(rs.getString("is_enabled"));
        usr.setCreation_date(rs.getTimestamp("creation_date"));
        usr.setLast_update_date(rs.getTimestamp("last_update_date"));
        return usr;
        
    }
    
}
