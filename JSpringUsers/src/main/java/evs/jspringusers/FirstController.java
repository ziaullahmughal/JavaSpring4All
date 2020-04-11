/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evs.jspringusers;

import evs.jspringusers.dao.Users_allDao;
import evs.jspringusers.model.users_all;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author shahzad
 */
@Controller
public class FirstController {

    @Autowired
    private Users_allDao userTemplate;

    @RequestMapping("/index.htm")
    public ModelAndView index(
            @RequestParam(name = "pass", required = false) String pass,
            @RequestParam(name = "fail", required = false) String fail
    ) {
        return new ModelAndView("index",
                "first", "this is mvc first application");
    }

    @RequestMapping("/login.htm")
    public ModelAndView login(
            @RequestParam(name = "login") String username,
            @RequestParam(name = "pass") String userpass
    ) {
        String is_enabled = "Y";
        users_all user = userTemplate.validate(username, userpass, is_enabled);
        if (user != null) {
            // valid user 
            return home("User logged in successfully", null);
        } else {
            // invalid user
            return index(null, "Invalid User");
        }
    }

    @RequestMapping("/home.htm")
    private ModelAndView home(
            @RequestParam(name = "pass", required = false) String pass,
            @RequestParam(name = "fail", required = false) String fail
    ) {
        Map<String, Object> map
                = new HashMap<String, Object>();
        // All User
        List<users_all> all = userTemplate.all();
        map.put("all", all);
        if (pass != null && pass.trim().length() > 0) {
            map.put("pass", pass.trim());
        }

        if (fail != null && fail.trim().length() > 0) {
            map.put("fail", fail.trim());
        }
        return new ModelAndView("home",
                "map", map);
    }

    @RequestMapping(value = {"/useradd.htm"}, method = {RequestMethod.GET})
    public ModelAndView useradd() {
        Map<String, Object> map
                = new HashMap<String, Object>();
        return new ModelAndView("useradd", "map", map);
    }

    @RequestMapping(value = {"/useradd.htm"}, method = {RequestMethod.POST})
    public ModelAndView useraddpost(
            @RequestParam(name = "description") String description,
            @RequestParam(name = "user_name") String user_name,
            @RequestParam(name = "user_password") String user_password,
            @RequestParam(name = "email_address") String email_address,
            @RequestParam(name = "phone_num") String phone_num
    ) {
        users_all user = new users_all(description, user_name, user_password, email_address, phone_num);
        String pass = null, fail = null;
        boolean insert = userTemplate.create(user);
        if (insert) {
            pass = "User registered successfully ... ";
        } else {
            fail = "Unable to insert user ... ";
        }
        return home(pass, fail);
    }

    @RequestMapping(value = "/userupd.htm", method = RequestMethod.GET)
    public ModelAndView userupd(
            @RequestParam(name = "id") String id
    ) {
        Map<String, Object> map
                = new HashMap<String, Object>();
        users_all user = userTemplate.get(Integer.parseInt(id));
//        if ( user != null ) {
        map.put("user", user);
        return new ModelAndView("userupd", "map", map);
//        }
//        else {
//            // Error 
//        }
    }

    @RequestMapping(value = {"/userupd.htm"}, method = {RequestMethod.POST})
    public ModelAndView userupdpost(
            @RequestParam(name = "user_id") String user_id,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "user_name") String user_name,
            @RequestParam(name = "user_password") String user_password,
            @RequestParam(name = "email_address") String email_address,
            @RequestParam(name = "phone_num") String phone_num,
            @RequestParam(name = "is_enabled") String is_enabled
    ) {
        users_all user = new users_all(Integer.parseInt(user_id), description, user_name, user_password, email_address, phone_num, is_enabled);
        boolean update = userTemplate.update(user);
        return home(
                update ? "User Updated Successfully " : null,
                update == false ? "Unable to update user " : null
        );
    }

    @RequestMapping(value = {"/userdel.htm"}, method = {RequestMethod.POST})
    public ModelAndView userdel(
            @RequestParam(name = "id") String id
    ) {
        // Delete Operation
        boolean delete = userTemplate.delete(Integer.parseInt(id));
        return home(
                delete ? "User Deleted Successfully " : null,
                delete == false ? "Unable to delete user " : null
        );
    }

}
