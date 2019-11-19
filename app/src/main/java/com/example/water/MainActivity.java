package com.example.water;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.time.Month;

public class MainActivity extends AppCompatActivity {
    private EditText month;
    private EditText next;
    private EditText month1;
    private EditText next1;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        month1 = findViewById(R.id.month);
        next1 = findViewById(R.id.next);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    String monthstring = month1.getText().toString();
                    if (!TextUtils.isEmpty(monthstring)) {
                        float degree = Float.parseFloat(monthstring);
                        float fee = 0;
                        if (degree >= 1 && degree <= 10) {
                            fee = degree*7.35f;
                        }else{
                            if (degree >= 11 && degree <= 30) {
                                fee = degree*9.45f-21;
                            }else{
                                if (degree >= 31 && degree <= 50) {
                                    fee = degree*11.55f-84;
                                }
                            }
                        }

                        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                        intent.putExtra("FEE",fee);
                        startActivity(intent);
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("month")
                                .setMessage("Fee "+fee)
                                .setPositiveButton("OK",null)
                                .show();

                    }
                    String nextstring = next1.getText().toString();
                    if (!TextUtils.isEmpty(nextstring)) {
                        float degree = Float.parseFloat(nextstring);
                        float fee = 0;
                        if (degree >= 1 && degree <= 20) {
                            fee = degree*73.5f;
                        }else{
                            if (degree >= 21 && degree <= 60) {
                                fee = degree*9.45f-42;
                            }else{
                                if (degree >= 61 && degree <= 100) {
                                    fee = degree*11.55f-168;
                                }
                            }
                        }
                    }

                }
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void fee (){}






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
