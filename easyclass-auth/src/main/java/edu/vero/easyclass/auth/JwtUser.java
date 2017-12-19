package edu.vero.easyclass.auth;


import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.vero.easyclass.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import java.util.Collection;
import java.util.Date;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 0:39 2017/12/20.
 * @since easyclass
 */

@Entity
public class JwtUser extends User implements UserDetails
{

    private final Collection<? extends GrantedAuthority> authorities;

    private final Date lastPasswordResetDate;

    public JwtUser(Integer userId, String username, String password, String email,
                   Collection<? extends GrantedAuthority> authorities, Date lastPasswordResetDate)
    {
        super(userId, username, password, email);
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return null;
    }

    /**
     * 账户未过期
     * 
     * @return
     */
    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    /**
     * 账户是否未过期
     * 
     * @return
     */
    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    /**
     * 账号是否已激活
     * 
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate()
    {
        return lastPasswordResetDate;
    }
}
