package com.my.DB.DAO;

import com.vaadin.data.util.filter.Compare;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.JDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;

import java.sql.SQLException;

/**
 * Created by azu on 15.01.2015.
 */
public class DAO {
    private static JDBCConnectionPool pool;

    public static JDBCConnectionPool getConnectionPool() throws SQLException {
        if (pool == null) {
            pool = new SimpleJDBCConnectionPool(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/chatdb", "root", "root", 2, 5);
        }
        return pool;
    }

    public static TableQuery getTableQuery(String tableName) throws SQLException {
        return new TableQuery(tableName, getConnectionPool());
    }

    public static boolean checkUser(String name, String password) {
        TableQuery query = null;
        try {
            query = getTableQuery("users");
            SQLContainer container = new SQLContainer(query);
            container.addContainerFilter(new Compare.Equal("userid", name));
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;

    }

}
