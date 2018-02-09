package com.example.shakil.androidhttppostfcm.Remote;

import com.example.shakil.androidhttppostfcm.Model.MyResponse;
import com.example.shakil.androidhttppostfcm.Model.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Shakil on 2/7/2018.
 */

public interface APIService {
    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAto6wYfs:APA91bF8gq2sJgsXqPQAPH2XSH-dIBp8MoDifDVKHOUuepYrok1nwwiS0c2t2qhb8y-_ODiRxM-ukPEf4L2L4TNWZWfmnp7I8qN3tneBcIVKPg-osXVb70PjQGRtymG-iEp454G2qadP"
    })
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
