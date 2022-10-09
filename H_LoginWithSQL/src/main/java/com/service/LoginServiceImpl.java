package com.service;

import com.dao.LoginDao;
import com.dao.LoginDaoImpl;
import com.dao.SQLDao;
import com.entity.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author kinoz
 * @Date 2022/7/11 - 17:04
 * @apiNote
 */
@Service
public class LoginServiceImpl implements LoginService{
    public final LoginDao loginDao;
    public LoginServiceImpl() {
        loginDao = new LoginDaoImpl();
    }

    @Override
    public User getLoginUser(String name,String password) {
        Connection con = null;
        User loginUser = null;
        try {
            con = SQLDao.getConnection();
            loginUser = loginDao.getLoginUser(con, name);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            SQLDao.closeResource(con,null,null);
        }

        //密码校验
        if (null != loginUser){
            if (!loginUser.getPassword().equals(password)){
                loginUser = null;
            }
        }

        return loginUser;

    }

    @Override
    public User getLoginUser_Spring(String name,String password) {

        User loginUser = null;
        try {
            loginUser = loginDao.getLoginUser_Spring(name);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

        //密码校验
        if (null != loginUser){
            if (!loginUser.getPassword().equals(password)){
                loginUser = null;
            }
        }

        return loginUser;

    }

    @Test
    public void  mytest(){
        LoginServiceImpl user = new LoginServiceImpl();
        User yonghu1 = user.getLoginUser("admin", "123456");
        System.out.println(yonghu1.getMoney());
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        LoginServiceImpl loginService = context.getBean("loginServiceImpl", LoginServiceImpl.class);
        User admin = loginService.getLoginUser("admin", "123456");
        System.out.println(admin.getMoney());
    }
}
