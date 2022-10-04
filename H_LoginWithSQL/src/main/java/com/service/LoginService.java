package com.service;

import com.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author kinoz
 * @Date 2022/7/11 - 17:04
 * @apiNote
 */
@Service
public interface LoginService {
    User getLoginUser(String name,String password);
    User getLoginUser_Spring(String name,String password);
}
