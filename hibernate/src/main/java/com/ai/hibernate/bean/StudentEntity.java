package com.ai.hibernate.bean;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student", schema = "hibernate", catalog = "")
public class StudentEntity {
    private String mSid;
    private String mSname;
    private Integer mGender;
    private Date mBirthday;
    private String mAddress;

    @Basic
    @Column(name = "sid")
    public String getSid() {
        return mSid;
    }

    public void setSid(String sid) {
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
    public Integer getGender() {
        return mGender;
    }

    public void setGender(Integer gender) {
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

        StudentEntity that = (StudentEntity) o;

        if (mSid != null ? !mSid.equals(that.mSid) : that.mSid != null) return false;
        if (mSname != null ? !mSname.equals(that.mSname) : that.mSname != null) return false;
        if (mGender != null ? !mGender.equals(that.mGender) : that.mGender != null) return false;
        if (mBirthday != null ? !mBirthday.equals(that.mBirthday) : that.mBirthday != null)
            return false;
        if (mAddress != null ? !mAddress.equals(that.mAddress) : that.mAddress != null)
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

    private String mId;

    @Id
    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }
}
