package com.novc21.esoftwarica;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditStudent extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    EditText etReName, etReAge, etReAddress;
    RadioGroup rgReGender;
    RadioButton rbReMale, rbReFemale, rbReOther;
    Button btnReSave;
    String name, address, gender;
    int age;
    public static int index;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .8));

        etReName = findViewById(R.id.etReName);
        etReAge = findViewById(R.id.etReAge);
        etReAddress = findViewById(R.id.etReAddress);
        btnReSave = findViewById(R.id.btnReSave);
        rgReGender = findViewById(R.id.rgReGender);
        rbReMale = findViewById(R.id.rbReMale);
        rbReOther = findViewById(R.id.rbReOther);
        rbReFemale = findViewById(R.id.rbReFemale);
        etReName.setText(MainActivity.studentsList.get(index).getName());
        etReAge.setText(MainActivity.studentsList.get(index).getAge() + "");
        etReAddress.setText(MainActivity.studentsList.get(index).getAddress());
        gender = MainActivity.studentsList.get(index).getGender();

}

