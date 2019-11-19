package com.example.water;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        float fee = intent.getFloatExtra("FEE",-1);
        Log.d("ResultActivity", fee+"");
        TextView feeText = findViewById(R.id.fee);
        feeText.setText( fee + "");
        int n = (int)(fee + 0.05f);
                feeText.setText(n + " ");
    }
}
