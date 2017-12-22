package edu.vero.easyclass.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "serviceLevel", discriminatorType = DiscriminatorType.STRING)
public class User
{

    private int userId;

    private String username;

    private String password;

    private Department department;

    @Id
    @GenericGenerator(name = "increment",strategy = "increment")
    @GeneratedValue(generator = "increment")
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
}