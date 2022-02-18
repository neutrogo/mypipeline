package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestSimpleResource {

    Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    // @Expose == @Expose (deserialize = true)
    @Expose String resourceType;
    @SerializedName("given")
    @Expose String firstName;
    @SerializedName("family")
    @Expose String familyName;
    @SerializedName("value")
    @Expose String phone;
    @SerializedName("use")
    @Expose String phonetype;

    // keep in mind []telecom may NOT be a phone, check for this
}
