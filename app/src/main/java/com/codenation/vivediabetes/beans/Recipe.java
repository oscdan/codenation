package com.codenation.vivediabetes.beans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * @author Oscar Vargas
 * @since 18/06/17.
 */

public class Recipe implements Parcelable {
    private Integer id;
    private String name;
    private String url;
    private Integer prepareTime;
    private Integer comensales;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<NutritionalInfo> nutritionalInfo;
    private ArrayList<Procedure> procedure;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getPrepareTime() {
        return prepareTime;
    }

    public void setPrepareTime(Integer prepareTime) {
        this.prepareTime = prepareTime;
    }

    public Integer getComensales() {
        return comensales;
    }

    public void setComensales(Integer comensales) {
        this.comensales = comensales;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<NutritionalInfo> getNutritionalInfo() {
        return nutritionalInfo;
    }

    public void setNutritionalInfo(ArrayList<NutritionalInfo> nutritionalInfo) {
        this.nutritionalInfo = nutritionalInfo;
    }

    public ArrayList<Procedure> getProcedure() {
        return procedure;
    }

    public void setProcedure(ArrayList<Procedure> procedure) {
        this.procedure = procedure;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeString(this.url);
        dest.writeValue(this.prepareTime);
        dest.writeValue(this.comensales);
        dest.writeTypedList(this.ingredients);
        dest.writeTypedList(this.nutritionalInfo);
        dest.writeTypedList(this.procedure);
    }

    public Recipe() {
    }

    protected Recipe(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.url = in.readString();
        this.prepareTime = (Integer) in.readValue(Integer.class.getClassLoader());
        this.comensales = (Integer) in.readValue(Integer.class.getClassLoader());
        this.ingredients = in.createTypedArrayList(Ingredient.CREATOR);
        this.nutritionalInfo = in.createTypedArrayList(NutritionalInfo.CREATOR);
        this.procedure = in.createTypedArrayList(Procedure.CREATOR);
    }

    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel source) {
            return new Recipe(source);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}
