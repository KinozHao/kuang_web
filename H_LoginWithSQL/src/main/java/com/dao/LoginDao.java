package com.dao;

import com.entity.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author kinoz
 * @Date 2022/7/11 - 16:54
 * @apiNote
 */
@Component
public interface LoginDao {
    User getLoginUser(Connection con,String name) throws Exception;
    User getLoginUser_Spring(String name) throws Exception;
}
