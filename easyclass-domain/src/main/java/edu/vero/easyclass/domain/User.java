package edu.vero.easyclass.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "serviceLevel", discriminatorType = DiscriminatorType.STRING)
public class User
{

    private int userId;

    private String username;

    private String password;

    private String email;

    private Department department;

    private Date lastPasswordResetDate;

    private Set<Role> roles;

    public User(int userId, String username, String password,String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email =email;
    }

    @Id
    @GenericGenerator(name = "identityGenerator", strategy = "identity")
    @GeneratedValue(generator = "identityGenerator")
    public int getUserId()
    {
        return userId;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "depId")
    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    @ManyToMany
    @JoinTable(name = "user_role_ref",
            joinColumns = @JoinColumn(name = "userId",referencedColumnName = "userId")
            ,inverseJoinColumns = @JoinColumn(name = "roleId",referencedColumnName = "roleId")
        )
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}