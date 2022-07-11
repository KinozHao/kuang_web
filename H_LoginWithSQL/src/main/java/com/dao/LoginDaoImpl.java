package com.dao;

import com.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author kinoz
 * @Date 2022/7/11 - 16:58
 * @apiNote
 */
public class LoginDaoImpl implements LoginDao{
    @Override
    public User getLoginUser(Connection con, String name) throws Exception{
        PreparedStatement state = null;
        ResultSet result = null;
        User user = null;
        if (con != null){
            String sql = "select * from cusinfo where name = ?";
            Object[] param = {name};

            result = SQLDao.execute(con, state, result, sql, param);
            while (result.next()){
                user = new User();
                user.setId(result.getLong("id"));
                user.setName(result.getString("name"));
                user.setPassword(result.getString("password"));
                user.setMoney(result.getFloat("money"));
            }
            SQLDao.closeResource(null,state,result);

        }
        return user;
    }
}
