package com.example.admit.dao.admit;

public class admit {
    public String phone;
    public String password;
    public String name;
    public String sex;
    public String state;
    public String rank;
    public String admitID;
    public String Mail;

    public void setAdmitID(String admitID) {
        this.admitID = admitID;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getAdmitID() {
        return admitID;
    }

    public String getMail() {
        return Mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getState() {
        return state;
    }

    public String getRank() {
        return rank;
    }
}
