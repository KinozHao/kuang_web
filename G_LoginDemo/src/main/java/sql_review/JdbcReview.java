package sql_review;

import java.sql.*;

/**
 * @author kinoz
 * @Date 2022/7/8 - 9:15
 * @apiNote
 */
public class JdbcReview {
    public static void main(String[] args) throws Exception {
        //Query();
        Affaris();
    }

    private static void Affaris(){
        Connection con = null;
        try {
            con = dbcp_utils.getConnection();
            //关闭自动提交(相当于开启事务)
            con.setAutoCommit(false);

            //事务操纵
            String sql1 = "update bank.cusinfo set money=money-100 where id=1";
            con.prepareStatement(sql1).executeUpdate();
            String sql2 = "update bank.cusinfo set money=money+100 where id=2";
            con.prepareStatement(sql2).executeUpdate();

            //事务提交
            con.commit();


        } catch (Exception e) {
            try {
                //断言 相当于if判断
                assert con != null;
                //事务回滚
                con.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                assert con != null;
                //关闭流资源
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    private static void Query() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/school?&useUnicode=true&characterEncoding=utf-8&useSSL=true";
        String name = "root";
        String password = "123456";

        Connection con = DriverManager.getConnection(url, name, password);
        String sql = "select * from school.student;";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        while (rst.next()){
            System.out.println(rst.getObject("StudentName"));
        }

        con.close();
        rst.close();
    }
}
