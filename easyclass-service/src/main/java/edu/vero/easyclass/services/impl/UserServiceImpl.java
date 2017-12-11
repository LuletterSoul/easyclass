package edu.vero.easyclass.services.impl;

import edu.vero.easyclass.domain.User;
import edu.vero.easyclass.repositories.UserJpaDao;
import edu.vero.easyclass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5
 * created in  12:36 2017/12/11.
 * @since easyclass
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserJpaDao userJpaDao;

    /**
     *
     * @param UserName
     * @return
     */
    @Override
    public User getUserByName(String username) {
        return userJpaDao.findUser(username);
    }
}