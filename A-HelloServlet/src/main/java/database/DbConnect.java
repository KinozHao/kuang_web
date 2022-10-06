package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author kinoz
 * @Date 2022/6/30 - 21:05
 * @apiNote 连接数据库进行查询
 */
public class DbConnect {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");

        String ulr = "jdbc:mysql://localhost:3306/school?userUnicode=true&characterSet=GBK&useSSL=true";
        String name = "root";
        String pass = "123456";
        Connection con = DriverManager.getConnection(ulr, name, pass);

        Statement statement = con.createStatement();

        String sql = "select * from school.student;";
        ResultSet rst = statement.executeQuery(sql);
        while (rst.next()){
            System.out.println(rst.getObject("StudentName"));
            System.out.println("======================");
        }
    }
}
