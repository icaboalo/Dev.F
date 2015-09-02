package com.icaboalo.devf;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class WhatSong extends ActionBarActivity {

    Spinner mMusicProviderSpinner, mIconSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_song);

        mMusicProviderSpinner = (Spinner) findViewById(R.id.music_provider_spinner);
        mIconSpinner = (Spinner) findViewById(R.id.icon_spinner);

        ArrayAdapter<CharSequence> musicProviderSpinnerAdapter = ArrayAdapter.createFromResource
                (WhatSong.this, R.array.music_providers, android.R.layout.simple_spinner_item);
        musicProviderSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMusicProviderSpinner.setAdapter(musicProviderSpinnerAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_what_son, menu);
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
