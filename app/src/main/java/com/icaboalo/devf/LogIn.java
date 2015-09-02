package com.icaboalo.devf;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LogIn extends ActionBarActivity {
    EditText mCommercialInput, mUsernameInput, mPasswordInput;
    Button mLoginButton;
    TextView mNeedUsername, mNeedPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mCommercialInput = (EditText) findViewById(R.id.commercial_establishment_input);
        mUsernameInput   = (EditText) findViewById(R.id.username_input);
        mPasswordInput   = (EditText) findViewById(R.id.password_input);
        mLoginButton     = (Button) findViewById(R.id.login_button);
        mNeedUsername    = (TextView) findViewById(R.id.need_username);
        mNeedPassword    = (TextView) findViewById(R.id.need_password);

        mNeedUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogIn.this, "Username requested check you e-mail", Toast.LENGTH_SHORT).show();
            }
        });
        mNeedPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogIn.this, "Password requested check your e-mail", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
