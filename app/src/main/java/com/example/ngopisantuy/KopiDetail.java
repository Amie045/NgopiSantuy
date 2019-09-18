package com.example.ngopisantuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class KopiDetail extends AppCompatActivity {
    private TextView textTitle, detail;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kopi_detail);
        textTitle = findViewById(R.id.title);
        detail = findViewById(R.id.text);
        imageView = findViewById(R.id.image);

        Kopi kopi = getIntent().getParcelableExtra("kopi");


        textTitle.setText(kopi.getName());
        imageView.setImageResource(kopi.getPhoto());
        detail.setText(kopi.getDetail());


    }
}
