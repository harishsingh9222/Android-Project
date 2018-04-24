package com.harish.xdev.parking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.harish.xdev.parking.DB.DBLogin;
import com.harish.xdev.parking.Model.Login;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = SignupActivity.class.getName();

    TextView email;
    TextView password;
    Button btnsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email = (TextView) findViewById(R.id.edtName);
        password = (TextView) findViewById(R.id.edtPassword);
        btnsignup = (Button) findViewById(R.id.btnSignup);
        btnsignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Login login = new Login();
                login.setEmail(email.getText().toString());
                login.setPassword(password.getText().toString());

                DBLogin dbLogin = new DBLogin(SignupActivity.this);
                dbLogin.insertUser(login);
                dbLogin.getAllUser();

                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
    }


    public boolean validate() {
        if(password.getText().toString().length() != 0) {

        } else{
            password.setError("Enter Password");
        }
        return false;
    }

    public void Click(View view) {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }

}

