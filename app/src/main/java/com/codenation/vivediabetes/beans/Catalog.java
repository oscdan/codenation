package com.codenation.vivediabetes.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Oscar Vargas
 * @since 18/06/17.
 */

public class Catalog implements Parcelable {
    private Integer id;
    private Integer type;
    private Integer idtype;
    private String name;
    private Integer visible;
    private Integer orderNo;

    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Catalog() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeValue(this.type);
        dest.writeValue(this.idtype);
        dest.writeString(this.name);
        dest.writeValue(this.visible);
        dest.writeValue(this.orderNo);
    }

    private Catalog(Parcel in) {
        this.id = in.readInt();
        this.type = in.readInt();
        this.idtype = in.readInt();
        this.name = in.readString();
        this.visible = in.readInt();
        this.orderNo = in.readInt();
    }

    public static final Creator<Catalog> CREATOR = new Creator<Catalog>() {
        @Override
        public Catalog createFromParcel(Parcel source) {
            return new Catalog(source);
        }

        @Override
        public Catalog[] newArray(int size) {
            return new Catalog[size];
        }
    };

    @Override
    public String toString() {
        return this.getName();
    }
}
