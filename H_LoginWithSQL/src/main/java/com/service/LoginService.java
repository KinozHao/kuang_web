package com.service;

import com.entity.User;

/**
 * @author kinoz
 * @Date 2022/7/11 - 17:04
 * @apiNote
 */
public interface LoginService {
    User getLoginUser(String name,String password);
}
