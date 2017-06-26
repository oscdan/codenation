package com.codenation.vivediabetes.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * @author Oscar Vargas
 * @since 18/06/17.
 */

public class UserGlucosa implements Parcelable {
    private Integer id;
    private Date registerDate;
    private Integer glucosa;
    private Integer session;
    private Integer period;
    private Integer result;
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getGlucosa() {
        return glucosa;
    }

    public void setGlucosa(Integer glucosa) {
        this.glucosa = glucosa;
    }

    public Integer getSession() {
        return session;
    }

    public void setSession(Integer session) {
        this.session = session;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeLong(this.registerDate != null ? this.registerDate.getTime() : -1);
        dest.writeValue(this.glucosa);
        dest.writeValue(this.session);
        dest.writeValue(this.period);
        dest.writeValue(this.result);
        dest.writeString(this.comment);
    }

    public UserGlucosa() {
    }

    protected UserGlucosa(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        long tmpRegisterDate = in.readLong();
        this.registerDate = tmpRegisterDate == -1 ? null : new Date(tmpRegisterDate);
        this.glucosa = (Integer) in.readValue(Integer.class.getClassLoader());
        this.session = (Integer) in.readValue(Integer.class.getClassLoader());
        this.period = (Integer) in.readValue(Integer.class.getClassLoader());
        this.result = (Integer) in.readValue(Integer.class.getClassLoader());
        this.comment = in.readString();
    }

    public static final Parcelable.Creator<UserGlucosa> CREATOR = new Parcelable.Creator<UserGlucosa>() {
        @Override
        public UserGlucosa createFromParcel(Parcel source) {
            return new UserGlucosa(source);
        }

        @Override
        public UserGlucosa[] newArray(int size) {
            return new UserGlucosa[size];
        }
    };
}
