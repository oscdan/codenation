package com.codenation.vivediabetes.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * @author Oscar Vargas
 * @since 18/06/17.
 */

public class User implements Parcelable {
    private Integer hashid;
    private String email;
    private String fullname;
    private Integer gender;
    private Date bithdate;
    private Integer country;
    private Double weight;
    private Double height;
    private Integer physicalActivity;
    private Integer lifecycle;
    private Integer carbUnits;
    private UserRecord userRecord;

    public Integer getHashid() {
        return hashid;
    }

    public void setHashid(Integer hashid) {
        this.hashid = hashid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBithdate() {
        return bithdate;
    }

    public void setBithdate(Date bithdate) {
        this.bithdate = bithdate;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getPhysicalActivity() {
        return physicalActivity;
    }

    public void setPhysicalActivity(Integer physicalActivity) {
        this.physicalActivity = physicalActivity;
    }

    public Integer getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(Integer lifecycle) {
        this.lifecycle = lifecycle;
    }

    public Integer getCarbUnits() {
        return carbUnits;
    }

    public void setCarbUnits(Integer carbUnits) {
        this.carbUnits = carbUnits;
    }

    public UserRecord getUserRecord() {
        return userRecord;
    }

    public void setUserRecord(UserRecord userRecord) {
        this.userRecord = userRecord;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.hashid);
        dest.writeString(this.email);
        dest.writeString(this.fullname);
        dest.writeValue(this.gender);
        dest.writeLong(this.bithdate != null ? this.bithdate.getTime() : -1);
        dest.writeValue(this.country);
        dest.writeValue(this.weight);
        dest.writeValue(this.height);
        dest.writeValue(this.physicalActivity);
        dest.writeValue(this.lifecycle);
        dest.writeValue(this.carbUnits);
        dest.writeParcelable(this.userRecord, flags);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.hashid = (Integer) in.readValue(Integer.class.getClassLoader());
        this.email = in.readString();
        this.fullname = in.readString();
        this.gender = (Integer) in.readValue(Integer.class.getClassLoader());
        long tmpBithdate = in.readLong();
        this.bithdate = tmpBithdate == -1 ? null : new Date(tmpBithdate);
        this.country = (Integer) in.readValue(Integer.class.getClassLoader());
        this.weight = (Double) in.readValue(Double.class.getClassLoader());
        this.height = (Double) in.readValue(Double.class.getClassLoader());
        this.physicalActivity = (Integer) in.readValue(Integer.class.getClassLoader());
        this.lifecycle = (Integer) in.readValue(Integer.class.getClassLoader());
        this.carbUnits = (Integer) in.readValue(Integer.class.getClassLoader());
        this.userRecord = in.readParcelable(UserRecord.class.getClassLoader());
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
