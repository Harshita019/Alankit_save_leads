package com.example.alankit_leads;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static String api = "http://alankit.net/AlankitUniverseapi/api/Leadsave/";

    TextInputEditText ename, eemail, emobile, ecompany, edesignation, estate, eaddress;

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ename = findViewById(R.id.etname);
        eemail = findViewById(R.id.etemail);
        emobile = findViewById(R.id.etmobile);
        ecompany = findViewById(R.id.etcompany);
        edesignation = findViewById(R.id.etdesignation);
        estate = findViewById(R.id.etstate);
        eaddress = findViewById(R.id.etaddress);

        submit = findViewById(R.id.etsubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

            private void clearData() {
                ename.getText().clear();
                eemail.getText().clear();
                emobile.getText().clear();
                ecompany.getText().clear();
                edesignation.getText().clear();
                estate.getText().clear();
                eaddress.getText().clear();
            }

            private void saveData() {

                String strname = ename.getText().toString();
                String stremail = eemail.getText().toString();
                String strmobile = emobile.getText().toString();
                String strcompany = ecompany.getText().toString();
                String strdesignation = edesignation.getText().toString();
                String strstate = estate.getText().toString();
                String straddress = eaddress.getText().toString();

                String NamePattern = "^[a-zA-z]+([\\s][a-zA-Z]+)*$";
                String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (strname.length() == 0 && stremail.length() == 0 && strmobile.length() == 0 && strcompany.length() == 0) {
                    Toast.makeText(MainActivity.this, "Please enter your Name, Email, Mobile, & Company", Toast.LENGTH_LONG).show();
                } else if (!strname.matches(NamePattern)) {
                    Toast.makeText(getApplicationContext(), "Please enter your valid Name", Toast.LENGTH_SHORT).show();
                } else if (strname.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter your Name", Toast.LENGTH_SHORT).show();
                } else if (stremail.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter your Email ID", Toast.LENGTH_SHORT).show();
                } else if (!stremail.matches(EmailPattern)) {
                    Toast.makeText(getApplicationContext(), "Please enter valid Email ID", Toast.LENGTH_SHORT).show();
                } else if (strmobile.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter your Mobile Number", Toast.LENGTH_SHORT).show();
                } else if (!(strmobile.length() == 10)) {
                    Toast.makeText(getApplicationContext(), "Please enter valid Mobile Number", Toast.LENGTH_SHORT).show();
                } else if (strcompany.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please enter valid Company Name", Toast.LENGTH_SHORT).show();
                } else {
                    RestrofitInstance.getInstance().apiInterface.getUser(strname, stremail, strmobile, strcompany, strdesignation, strstate, straddress).enqueue(new Callback<Post>() {
                        @Override
                        public void onResponse(Call<Post> call, Response<Post> response) {

                            String url = response.raw().request().method();
                            Post data = response.body();
                            clearData();
                            Log.d("RTAG", "request url: " + url);

                            Log.d("RTAG", "onResponse: " + data.Rescode + "\n" + data.Message + "\n" + data.Status);
                            if (data.Rescode == "1")
                            {
                                Toast.makeText(MainActivity.this, data.Message, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, data.Message, Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Post> call, Throwable t) {
                            clearData();
                            Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    });
                }
            }



    }





