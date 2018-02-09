package com.example.shakil.androidhttppostfcm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shakil.androidhttppostfcm.Common.Common;
import com.example.shakil.androidhttppostfcm.Model.MyResponse;
import com.example.shakil.androidhttppostfcm.Model.Notification;
import com.example.shakil.androidhttppostfcm.Model.Sender;
import com.example.shakil.androidhttppostfcm.Remote.APIService;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText edtTitle, edtContent;
    Button btnSendData;

    APIService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Common.currentToken = FirebaseInstanceId.getInstance().getToken();

        mService = Common.getFCMClient();

        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);
        btnSendData = findViewById(R.id.btnSendData);


        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send Request
                Notification notification = new Notification(edtTitle.getText().toString(), edtContent.getText().toString());
                Sender sender = new Sender(Common.currentToken, notification);
                mService.sendNotification(sender).enqueue(new Callback<MyResponse>() {
                    @Override
                    public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                        if (response.body().success == 1){
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MyResponse> call, Throwable t) {
                        Log.e("ERROR",t.getMessage());
                    }
                });

            }
        });
    }
}
