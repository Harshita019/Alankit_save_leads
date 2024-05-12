package com.example.alankit_leads;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    EditText euserid, epass;
    Button elogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        euserid = findViewById(R.id.etuserid);
        epass = findViewById(R.id.etpass);
        elogin = findViewById(R.id.etlogin);

        elogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String struserid = euserid.getText().toString();
                String strpass = epass.getText().toString();

                Date date = Calendar.getInstance().getTime();
                DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

                String strdate = formatter.format(date);

                RestrofitInstance.getInstance().apiInterface.UserDetail(struserid, strpass, strdate).enqueue(new Callback<UserResponse>() {

                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                        UserResponse data1 = response.body();

                        Log.d("LTAG", "\n onResponse: " + data1.rescode + "\n onMessage: " + data1.Message + "\n onStatus: " + data1.Status);

                        if(data1.rescode.equals("1")){
                            Log.d("MYTAG", "onResponse: "+"Success");
                            Toast.makeText(Login.this, "Success", Toast.LENGTH_SHORT).show();
                            clearloginData();
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            startActivity(intent);
                        }

                        else{
                            Log.d("MYTAG", "onResponse: "+"failed");
                            Toast.makeText(Login.this, "Failed", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Log.d("MYTAG", "onFailure: "+t.getMessage());

                        Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    private void clearloginData() {
        euserid.getText().clear();
        epass.getText().clear();
    }
}