package com.liaocc.demo.Service;

import com.liaocc.demo.dao.UserDao;
import com.liaocc.demo.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public List<User> getAllUser() {
        List<User> users=userDao.getAllUser();
        for(User user:users){
            user.setBlogs(userDao.getblogs(user.getId()));
        }
        return users;
    }
}
