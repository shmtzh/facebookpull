package com.roket.shmtzh.facebooker;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;



/**
 * Created by shmtzh on 8/28/16.
 */
public class FacebookPhotosModel {
    @SerializedName("data")
    List<FacebookPhotoModel> model = new ArrayList<>();

    public List<FacebookPhotoModel> getModel() {
        return model;
    }

    public void setModel(List<FacebookPhotoModel> model) {
        this.model = model;
    }
}
