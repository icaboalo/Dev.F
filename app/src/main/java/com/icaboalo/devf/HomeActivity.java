package com.icaboalo.devf;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class HomeActivity extends ActionBarActivity {

    EditText mUsernameInput, mPasswordInput;
    TextView mPasswordForgot;
    Button mLogInButton, mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mUsernameInput  = (EditText) findViewById(R.id.username_input);
        mPasswordInput  = (EditText) findViewById(R.id.password_input);
        mPasswordForgot = (TextView) findViewById(R.id.password_forgot);
        mLogInButton    = (Button)   findViewById(R.id.login_button);
        mRegisterButton = (Button)   findViewById(R.id.register_button);

        mLogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUsernameInput.getText().toString().trim().length() < 4
                        && mPasswordInput.getText().toString().trim().length() < 6) {
                    mUsernameInput.setError(getResources().getString(R.string.username_input_error));
                    mPasswordInput.setError(getResources().getString(R.string.password_input_error));
                } else Toast.makeText(HomeActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomeActivity.this);
                alertDialog.setTitle("Congrats...")
                        .setMessage("You've have successfully signed in")
                        .setCancelable(false)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .create().show();

            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegister = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(goToRegister);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
