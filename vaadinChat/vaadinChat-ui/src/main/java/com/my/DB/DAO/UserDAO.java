package com.my.DB.DAO;

import com.my.DB.HibernateUtils;
import org.hibernate.Session;

/**
 * Created by azu on 17.01.2015.
 */
public class UserDAO {
    public static void checkLogin(String name, String password) {

    }

    public static User getUserById(int id) {
        Session session = null;
        User user = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            user = (User) session.load(User.class, id);
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }
}
