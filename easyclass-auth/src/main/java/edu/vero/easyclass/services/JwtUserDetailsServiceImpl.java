package edu.vero.easyclass.services;


import edu.vero.easyclass.auth.JwtUserFactory;
import edu.vero.easyclass.domain.User;
import edu.vero.easyclass.repositories.UserJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 0:59 2017/12/20.
 * @since easyclass
 */

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService
{
    private UserJpaDao userJpaDao;

    @Autowired
    public void setUserJpaDao(UserJpaDao userJpaDao)
    {
        this.userJpaDao = userJpaDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException
    {
        User user = userJpaDao.findByUsername(username);
        if (user == null)
        {
            throw new UsernameNotFoundException(
                String.format("No user found with username '%s'.", username));
        }
        else
        {
            return JwtUserFactory.create(user);
        }
    }
}
