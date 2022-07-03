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
        String sql = "insert into bank.cusinfo (name, money) VALUES (?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setObject(1,"刘遂");
        pst.setObject(2,"100000");

        int i = pst.executeUpdate();
        if (i>0){
            System.out.println("update success!!");
        }

        dbcp_utils.CloseStream(con,pst,null);
    }
}
