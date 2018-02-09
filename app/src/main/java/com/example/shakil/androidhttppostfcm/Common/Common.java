package com.example.shakil.androidhttppostfcm.Common;

import com.example.shakil.androidhttppostfcm.Remote.APIService;
import com.example.shakil.androidhttppostfcm.Remote.RetrofitClient;

/**
 * Created by Shakil on 2/6/2018.
 */

public class Common {
    public static String currentToken = "";

    private static String baseUrl = "https://fcm.googleapis.com/";

    public static APIService getFCMClient(){
        return RetrofitClient.getClient(baseUrl).create(APIService.class);
    }
}
