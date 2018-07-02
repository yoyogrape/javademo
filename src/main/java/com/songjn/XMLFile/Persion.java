package com.songjn.XMLFile;

/**
 * @author songjn
 * @create 2018-06-20 21:35
 * @desc xml文件的解析
 **/
public class Persion {
    private String contactid;
    private String name;
    private int age;
    private String telephone;
    private String email;
    private String qq;

    public String getContactid() {
        return contactid;
    }

    public void setContactid(String contactid) {
        this.contactid = contactid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "contactid=" + contactid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                '}';
    }
}
