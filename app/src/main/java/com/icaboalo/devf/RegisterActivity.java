package com.icaboalo.devf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends ActionBarActivity {
    Toolbar  mToolbar;
    EditText mFirstNameInput, mLastNameInput, mPasswordInput, mPasswordConfirmationInput;
    TextView mPasswordStrength, mPasswordRepetition;
    Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mFirstNameInput = (EditText) findViewById(R.id.first_name_input);
        mLastNameInput  = (EditText) findViewById(R.id.last_name_input);
        mPasswordInput  = (EditText) findViewById(R.id.password_input);
        mPasswordConfirmationInput = (EditText) findViewById(R.id.password_input_confirmation);

        mPasswordStrength   = (TextView) findViewById(R.id.password_strength);
        mPasswordRepetition = (TextView) findViewById(R.id.password_repetition);

        mRegisterButton = (Button) findViewById(R.id.register_button);

        mPasswordInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int password = mPasswordInput.getText().length();
                if (password <= 4){
                    mPasswordStrength.setText(getResources().getString(R.string.password_strength_weak));
                    mPasswordStrength.setTextColor(getResources().getColor(R.color.red));
                }
                if (password > 4){
                    mPasswordStrength.setText(getResources().getString(R.string.password_strength_intermediate));
                    mPasswordStrength.setTextColor(getResources().getColor(R.color.orange));
                }
                if (password >= 8){
                    mPasswordStrength.setText(getResources().getString(R.string.password_strength_strong));
                    mPasswordStrength.setTextColor(getResources().getColor(R.color.green));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mPasswordConfirmationInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password = mPasswordInput.getText().toString();
                String passwordRepetition = mPasswordConfirmationInput.getText().toString();
                if (password.equals(passwordRepetition)){
                    mPasswordRepetition.setText(getResources().getString(R.string.password_repetition_match));
                    mPasswordRepetition.setTextColor(getResources().getColor(R.color.green));
                }else {
                    mPasswordRepetition.setText(getResources().getString(R.string.password_repetition_not_match));
                    mPasswordRepetition.setTextColor(getResources().getColor(R.color.red));
                    mPasswordRepetition.setTextSize(27);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFirstNameInput.getText().toString().trim().length() > 4
                        && mLastNameInput.getText().toString().trim().length() > 4
                        && mPasswordStrength.getText().toString().equals(getResources().getString(R.string.password_strength_intermediate))
                        && mPasswordRepetition.getText().toString().equals(getResources().getString(R.string.password_repetition_match))){
                    Toast.makeText(RegisterActivity.this, "Successful you are registered!", Toast.LENGTH_SHORT).show();
                }else{
                    mFirstNameInput.setError(getString(R.string.first_name_input_error));
                    mLastNameInput.setError(getString(R.string.last_name_input_error));
                    mPasswordInput.setError("Password must be at least 6 characters");
                    mPasswordConfirmationInput.setError(getString(R.string.password_confirmation_input_error));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
        if (id == android.R.id.home){
            Intent gotoLogin = new Intent(RegisterActivity.this, HomeActivity.class);
            startActivity(gotoLogin);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
