package com.example.akshay.sharedpreferences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedPreferenceConfig preferenceConfig;
    private EditText etUserName,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);

        if (preferenceConfig.readLoginStatus()){
            startActivity(new Intent(this,SuccessActivity.class));
            finish();
        }
    }

    public void loginUser(View view) {
        String userName = etUserName.getText().toString();
        String userPassword = etPassword.getText().toString();



        if (userName.equals(getResources().getString(R.string.user_name)) &&
                userPassword.equals(getResources().getString(R.string.user_password))){

            startActivity(new Intent(this,SuccessActivity.class));
            preferenceConfig.writeLoginStatus(true);

            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT).show();
            etUserName.setText("");
            etPassword.setText("");
        }
    }
}
