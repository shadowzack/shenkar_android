package com.shenkar.battl.shenkar_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class gameActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.setContentView(new GameSurfaceHolder(this));
    }

    public boolean onSupportNavigateUp() {
        // onBackPressed();
        startActivity(new Intent(gameActivity.this, MainActivity.class));
        return true;

    }
    public void onBackPressed() {
        startActivity(new Intent(gameActivity.this, MainActivity.class));

    }
}