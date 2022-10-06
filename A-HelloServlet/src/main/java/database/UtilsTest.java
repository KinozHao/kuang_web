package database;

import database.utils.dbcp_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author kinoz
 * @Date 2022/6/30 - 21:12
 * @apiNote
 */
public class UtilsTest {
    public static void main(String[] args) throws Exception{
        Connection con = dbcp_utils.getConnection();
        String sql = "insert into springframe.cusinfo (name, money) VALUES (?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        // parameterIndex the first parameter is 1, the second is 2, ...
        pst.setObject(1,"刘遂");
        pst.setObject(2,"500");

        int i = pst.executeUpdate();
        if (i>0){
            System.out.println("update success!!");
        }

        dbcp_utils.CloseStream(con,pst,null);
    }
}
