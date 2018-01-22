package com.ai.hibernate.bean;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Student {
    private Integer mSid;
    private String mSname;
    private String mGender;
    private Date mBirthday;
    private String mAddress;

    @Basic
    @Column(name = "sid")
    public Integer getSid() {
        return mSid;
    }

    public void setSid(Integer sid) {
        mSid = sid;
    }

    @Basic
    @Column(name = "sname")
    public String getSname() {
        return mSname;
    }

    public void setSname(String sname) {
        mSname = sname;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        mGender = gender;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return mBirthday;
    }

    public void setBirthday(Date birthday) {
        mBirthday = birthday;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (mSid != null ? !mSid.equals(student.mSid) : student.mSid != null) return false;
        if (mSname != null ? !mSname.equals(student.mSname) : student.mSname != null) return false;
        if (mGender != null ? !mGender.equals(student.mGender) : student.mGender != null)
            return false;
        if (mBirthday != null ? !mBirthday.equals(student.mBirthday) : student.mBirthday != null)
            return false;
        if (mAddress != null ? !mAddress.equals(student.mAddress) : student.mAddress != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mSid != null ? mSid.hashCode() : 0;
        result = 31 * result + (mSname != null ? mSname.hashCode() : 0);
        result = 31 * result + (mGender != null ? mGender.hashCode() : 0);
        result = 31 * result + (mBirthday != null ? mBirthday.hashCode() : 0);
        result = 31 * result + (mAddress != null ? mAddress.hashCode() : 0);
        return result;
    }


    public Student(Integer sid, String sname, String gender, Date birthday, String address) {
        mSid = sid;
        mSname = sname;
        mGender = gender;
        mBirthday = birthday;
        mAddress = address;
    }

    public Student(){}
}
