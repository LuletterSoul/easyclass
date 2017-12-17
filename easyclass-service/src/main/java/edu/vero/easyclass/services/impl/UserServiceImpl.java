package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.User;
import edu.vero.easyclass.repositories.UserJpaDao;
import edu.vero.easyclass.services.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  12:36 2017/12/11.
 * @since easyclass
 */

@Service
public class UserServiceImpl implements UserService {


    private UserJpaDao userJpaDao;

    @Autowired
    public void setUserJpaDao(UserJpaDao userJpaDao) {
        this.userJpaDao = userJpaDao;
    }

    @Override
    public User findUserById(String userId) {
        Integer id = Integer.valueOf(userId);
        return userJpaDao.findOne(id);
    }

    @Override
    public User save(User user) {
        return userJpaDao.save(user);
    }

}