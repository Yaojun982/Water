package com.example.water;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private EditText month;

    private EditText month1;
    private EditText next1;
    private Button button;
    private Switch sw;
    float fee = 0.0f;
    boolean isNext=false;
    private String tag;
    private View cities;

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("TAG","onStop");
        month1 = findViewById(R.id.month);
        button = findViewById(R.id.button);
        cities = findViewById(R.id.spinner);
        Switch sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.type);
                text.setText(isChecked?getString(R.string.every_other_month):getString(R.string.monthly));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {

            private float fee;

            @Override
            public void onClick(View v) {
                {
                    String monthstring = month1.getText().toString();
                    if (!TextUtils.isEmpty(monthstring)) {
                        if (!isNext) {
                            float degree = Float.parseFloat(monthstring);
                            float fee = 0;
                           if (degree >= 1 && degree <= 10){
                               fee = (degree * 7.35f) + 0;
                           } else if (degree >= 11 && degree <=30);
                           fee = (degree*9.45f) - 21;
                        }else if ( degree >= 21 && degree <= 40);
                            fee = (degree*12.45) -42;{


                        Intent
                        } intent = new Intent(MainActivity.this,ResultActivity.class);
                        intent.putExtra(getString(R.string.Extract_fee), MainActivity.this.fee);
                        startActivity(intent);
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("month")
                                .setMessage(getString(R.string.fee)+ MainActivity.this.fee)
                                .setPositiveButton(R.string.ok,null)
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
        //Spinner
        Spinner cities

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG","onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TAG"," onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG","onPause");
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
