package com.example.ngopisantuy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvKopi;
    private ArrayList<Kopi> list = new ArrayList<>();

    //MainActivity
    //adapter
    //detailactivity
    //pojo
    //pojodata
    //profil

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvKopi = findViewById(R.id.rv_kopi);
        rvKopi.setHasFixedSize(true);

        list.addAll(KopiData.getListData());
        rvKopi.setLayoutManager(new LinearLayoutManager(this));
        CardViewKopiAdapter cardViewHeroAdapter = new CardViewKopiAdapter(list);
        rvKopi.setAdapter(cardViewHeroAdapter);


    }

    //recyccleview

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode){
        switch (selectedMode){
            case R.id.action_about:
                Intent moveIntent = new Intent(MainActivity.this, About.class);
                startActivity(moveIntent);
                break;
                default:
                    break;
        }

    }
}
