package com.songjn.JSONFile;

import java.util.Arrays;
import java.util.List;

/**
 * @author songjn
 * @create 2018-06-24 18:11
 * @desc json对应的类
 **/
public class Message {
private long id;
private String text;
private User user;
private List<Double> geo;


    public Message(long id, String text, User user, List<Double> geo) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", geo=" + geo +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Double> getGeo() {
        return geo;
    }

    public void setGeo(List<Double> geo) {
        this.geo = geo;
    }
}
