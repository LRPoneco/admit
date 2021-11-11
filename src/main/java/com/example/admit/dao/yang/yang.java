package com.example.admit.dao.yang;

import java.util.Date;

public class yang {
    public String ID;
    public Date birthday;
    public Date end;
    public String phone;

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getID() {
        return ID;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Date getEnd() {
        return end;
    }

    public String getPhone() {
        return phone;
    }
}
