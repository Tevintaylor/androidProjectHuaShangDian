package com.example.huashangdian.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.huashangdian.LogInClass;
import com.example.huashangdian.Preferences.SettingsActivity;
import com.example.huashangdian.R;

public class ProfileView extends AppCompatActivity{

    private String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_view);

        LinearLayout logout = findViewById(R.id.linearLogout);
        LinearLayout setting = findViewById(R.id.settings);

        TextView email = findViewById(R.id.useremail);
        TextView email2 = findViewById(R.id.useremail2);
        st=getIntent().getExtras().getString("username");
        email.setText(st);


        int ranNumber = generateRandomIntIntRange();
        email2.setText(st+String.valueOf(ranNumber)+"@yahoo.com");


//        TextView pass = findViewById(R.id.pass);

//        userName.setText(email.getText());
//        userEmail.setText(email.getText());



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settings();
            }
        });

    }
    public void Logout(){
        Intent intent = new Intent(this, LogInClass.class);
        startActivity(intent);
    }
    public void settings(){
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }

    public static int generateRandomIntIntRange() {
        double n = Math.random();
        long n3 = Math.round(Math.random()*1000);
        return (int) n3;
    }

}
