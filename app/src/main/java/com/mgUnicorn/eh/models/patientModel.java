package com.mgUnicorn.eh.models;

import android.content.Context;

public class patientModel {

    String imageUrl,name,number,date;

    Context context;

    patientModel(){}



    public patientModel(Context context){
        this.context=context;
    }


    public patientModel(String imageUrl, String name, String number, String date) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.number = number;
        this.date = date;

    }

    public patientModel( String name, String number, String date) {

        this.name = name;
        this.number = number;
        this.date = date;

    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
