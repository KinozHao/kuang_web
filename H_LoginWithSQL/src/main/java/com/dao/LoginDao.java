package com.dao;

import com.entity.User;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author kinoz
 * @Date 2022/7/11 - 16:54
 * @apiNote
 */
public interface LoginDao {
    User getLoginUser(Connection con,String name) throws Exception;
}
