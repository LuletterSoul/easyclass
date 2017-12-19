package edu.vero.easyclass.auth;


import edu.vero.easyclass.domain.Role;
import edu.vero.easyclass.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @author XiangDe Liu qq313700046@icloud.com .
 * @version 1.5 created in 0:45 2017/12/20.
 * @since easyclass
 */

public final class JwtUserFactory
{
    private JwtUserFactory()
    {}

    public static JwtUser create(User user)
    {
        return new JwtUser(user.getUserId(), user.getUsername(), user.getPassword(),
            user.getEmail(), mapToGrantedAuthorities(user.getRoles()),
            user.getLastPasswordResetDate());
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Set<Role> authorities)
    {
        List<String> roleNames = new ArrayList<>();
        for (Role role : authorities)
        {
            roleNames.add(role.getRoleName());
        }
        return roleNames.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
