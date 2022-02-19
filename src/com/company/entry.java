package com.company;

import com.google.gson.annotations.SerializedName;

public class entry{

    resource resource;


    /*Gson gson = new GsonBuilder()
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
*/
    // keep in mind []telecom may NOT be a phone, check for this
}
