package com.mgUnicorn.eh.models;

public class DiseaseModel {

    String imageUrl,name,treatment;

    DiseaseModel(){

    }

    public DiseaseModel(String imageUrl, String name, String treatment) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.treatment = treatment;
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

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
}
