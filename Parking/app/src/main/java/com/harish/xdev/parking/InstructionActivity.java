package com.harish.xdev.parking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class InstructionActivity extends AppCompatActivity {

    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        web = (WebView) findViewById(R.id.web);
        web.loadUrl("file:///android_asset/instruction.html");

    }
}
