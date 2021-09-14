package com.example.task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button b_check;
    private EditText editText;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_check = findViewById(R.id.button_1);
        editText = findViewById(R.id.editText);
        result = findViewById(R.id.result);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String[] split = editText.getText().toString().split("\\.");
                    int day = Integer.parseInt(split[0]);
                    int month = Integer.parseInt(split[1]);
                    int year = Integer.parseInt(split[2]);
                    if (day <= 31 && month <= 12) {
                        if(month == 2 && day > 29){
                            throw new Exception();
                        } else if(year >= 1946 && 1964 >= year) {
                            result.setText("бэби-бумер");
                        } else if (year >= 1965 && 1980 >= year) {
                            result.setText("поколение Х");
                        } else if (year >= 1981 && 1996 >= year) {
                            result.setText("поколение Y или миллениалы");
                        } else if (year >= 1997 && 2012 >= year) {
                            result.setText("поколение Z или зумеры");
                        } else {
                            throw new Exception();
                        }
                    }else{
                        throw new Exception();
                    }
                } catch (Exception e) {
                    result.setText("Неверно набранная дата");
                }
            }
        };
        b_check.setOnClickListener(onClickListener);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("date", editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editText.setText(savedInstanceState.getString("date"));
    }
}