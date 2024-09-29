package com.example.apinetworking;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apinetworking.models.UserData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

TextView TVInfo;
ApiInterface apiInterface;
UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TVInfo = findViewById(R.id.tvInfo);
        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);
        Call<UserData> call = apiInterface.getUserData();
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, ""+response.code(), Toast.LENGTH_SHORT).show();

                    userData = response.body();

                    TVInfo.append(userData.getData().getFirstName());
                    TVInfo.append(userData.getData().getLastName()+"\n");
                    TVInfo.append(userData.getData().getEmail()+"\n");
                }

            }

            @Override
            public void onFailure(Call<UserData> call, Throwable throwable) {
                
                Toast.makeText(getApplicationContext(), "Message"+throwable.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }
}