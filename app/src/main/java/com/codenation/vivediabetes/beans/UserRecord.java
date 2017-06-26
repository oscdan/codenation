package com.codenation.vivediabetes.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * @author Oscar Vargas
 * @since 18/06/17.
 */

public class UserRecord implements Parcelable {
    private Integer diabetesType;
    private Date diagnosticDate;
    private Integer treatment;
    private Integer farmaco;
    private Integer insulinUnits;
    private Doctor doctor;

    public Integer getDiabetesType() {
        return diabetesType;
    }

    public void setDiabetesType(Integer diabetesType) {
        this.diabetesType = diabetesType;
    }

    public Date getDiagnosticDate() {
        return diagnosticDate;
    }

    public void setDiagnosticDate(Date diagnosticDate) {
        this.diagnosticDate = diagnosticDate;
    }

    public Integer getTreatment() {
        return treatment;
    }

    public void setTreatment(Integer treatment) {
        this.treatment = treatment;
    }

    public Integer getFarmaco() {
        return farmaco;
    }

    public void setFarmaco(Integer farmaco) {
        this.farmaco = farmaco;
    }

    public Integer getInsulinUnits() {
        return insulinUnits;
    }

    public void setInsulinUnits(Integer insulinUnits) {
        this.insulinUnits = insulinUnits;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.diabetesType);
        dest.writeLong(this.diagnosticDate != null ? this.diagnosticDate.getTime() : -1);
        dest.writeValue(this.treatment);
        dest.writeValue(this.farmaco);
        dest.writeValue(this.insulinUnits);
        dest.writeParcelable(this.doctor, flags);
    }

    public UserRecord() {
    }

    public UserRecord(Parcel in) {
        this.diabetesType = (Integer) in.readValue(Integer.class.getClassLoader());
        long tmpDiagnosticDate = in.readLong();
        this.diagnosticDate = tmpDiagnosticDate == -1 ? null : new Date(tmpDiagnosticDate);
        this.treatment = (Integer) in.readValue(Integer.class.getClassLoader());
        this.farmaco = (Integer) in.readValue(Integer.class.getClassLoader());
        this.insulinUnits = (Integer) in.readValue(Integer.class.getClassLoader());
        this.doctor = in.readParcelable(Doctor.class.getClassLoader());
    }

    public static final Parcelable.Creator<UserRecord> CREATOR = new Parcelable.Creator<UserRecord>() {
        @Override
        public UserRecord createFromParcel(Parcel source) {
            return new UserRecord(source);
        }

        @Override
        public UserRecord[] newArray(int size) {
            return new UserRecord[size];
        }
    };
}
