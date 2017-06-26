package com.codenation.vivediabetes.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Oscar Vargas
 * @since 18/06/17.
 */

public class Procedure implements Parcelable {
    private Integer orderNo;
    private String description;

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.orderNo);
        dest.writeString(this.description);
    }

    public Procedure() {
    }

    private Procedure(Parcel in) {
        this.orderNo = (Integer) in.readValue(Integer.class.getClassLoader());
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Procedure> CREATOR = new Parcelable.Creator<Procedure>() {
        @Override
        public Procedure createFromParcel(Parcel source) {
            return new Procedure(source);
        }

        @Override
        public Procedure[] newArray(int size) {
            return new Procedure[size];
        }
    };
}
