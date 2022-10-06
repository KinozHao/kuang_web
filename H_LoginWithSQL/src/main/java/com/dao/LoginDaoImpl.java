package com.dao;

import com.entity.User;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author kinoz
 * @Date 2022/7/11 - 16:58
 * @apiNote
 */
@Component
public class LoginDaoImpl implements LoginDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
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

    @Override
    public User getLoginUser_Spring(String name) throws Exception {
        String sql = "select * from cusinfo where name = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name);
        // TODO: 2022/10/4 此数据如何处理?
        Object[] param = {name};
        return user;
    }

}
