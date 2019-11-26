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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.time.Month;

public class MainActivity extends AppCompatActivity {
    private EditText month;

    private EditText month1;
    private EditText next1;
    private Button button;
    private Switch sw;
    float fee = 0.0f;
    boolean isNext=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        month1 = findViewById(R.id.month);
        button = findViewById(R.id.button);
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
                        }else if ( degree)


                        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                        intent.putExtra(getString(R.string.Extract_fee),fee);
                        startActivity(intent);
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("month")
                                .setMessage(getString(R.string.fee)+fee)
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
