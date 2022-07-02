package database.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author kinoz
 * @Date 2022/7/1 - 9:21
 * @apiNote
 */
public class jdbc_utils {
    private static String name = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;
    static {
        InputStream in = jdbc_utils.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pis = new Properties();
        try {
            pis.load(in);
            name=pis.getProperty("name");
            url=pis.getProperty("url");
            username=pis.getProperty("username");
            password=pis.getProperty("password");
            Class.forName(name);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    //4.关闭流
    public static void CloseConnection(Connection con, Statement sta, ResultSet rst) throws SQLException {
        //最好判断一下每个资源是否为null
        con.close();
        sta.close();
        rst.close();
    }
}
