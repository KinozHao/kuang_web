package com.entity;

/**
 * @author kinoz
 * @Date 2022/7/11 - 16:55
 * @apiNote
 */
public class User {
    private Long id;
    private String name;
    private String password;
    private Float money;

    public User() {
    }

    public User(Long id, String name, String password, Float money) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.money = money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Float getMoney() {
        return money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
