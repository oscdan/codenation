package com.codenation.vivediabetes.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Oscar Vargas
 * @since 18/06/17.
 */

public class NutritionalInfo implements Parcelable {
    private Integer id;
    private String name;
    private Double qty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeValue(this.qty);
    }

    public NutritionalInfo() {
    }

    protected NutritionalInfo(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.qty = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Parcelable.Creator<NutritionalInfo> CREATOR = new Parcelable.Creator<NutritionalInfo>() {
        @Override
        public NutritionalInfo createFromParcel(Parcel source) {
            return new NutritionalInfo(source);
        }

        @Override
        public NutritionalInfo[] newArray(int size) {
            return new NutritionalInfo[size];
        }
    };
}