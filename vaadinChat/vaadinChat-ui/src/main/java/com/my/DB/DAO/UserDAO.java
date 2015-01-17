package com.my.DB.DAO;

import com.my.DB.ClosableSession;
import com.my.DB.HibernateUtils;

/**
 * Created by azu on 17.01.2015.
 */
public class UserDAO {
    public static void checkLogin(String name, String password) {

    }

    public static User getUserById(int id) {
        User user = null;
        try (ClosableSession session = new ClosableSession(HibernateUtils.getSessionFactory().openSession())) {
            user = (User) session.delegate().load(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
