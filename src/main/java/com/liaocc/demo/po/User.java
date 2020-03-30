package com.liaocc.demo.po;

import org.apache.ibatis.annotations.Many;

import javax.persistence.Id;
import java.util.List;

public class User {
    public Long id;
    public String username;
    private List<Blog> blogs;

    public List<Blog> getBlogs() {
        return blogs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", blogs=" + blogs +
                '}';
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
