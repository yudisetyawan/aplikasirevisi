package com.example.majujayarental;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class RoomReadSingleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        EditText Enamapeminjam = findViewById(R.id.Enamapeminjam);
        EditText Etanggalpinjam = findViewById(R.id.Etanggalpinjam);
        EditText Etanggalkembali = findViewById(R.id.Etanggalkembali);
        EditText Enamamobil = findViewById(R.id.Enamamobil);
        Button btSubmit = findViewById(R.id.btsubmit);

        Enamapeminjam.setEnabled(false);
        Etanggalpinjam.setEnabled(false);
        Etanggalkembali.setEnabled(false);
        Enamamobil.setEnabled(false);
        btSubmit.setVisibility(View.GONE);

        stok_mobil stok_mobil = (stok_mobil) getIntent().getSerializableExtra("data");
        if(stok_mobil!=null){
            Enamapeminjam.setText(stok_mobil.getnamapeminjam());
            Enamapeminjam.setText(stok_mobil.gettanggalpinjam());
            Etanggalkembali.setText(stok_mobil.gettanggalkembali());
            Enamamobil.setText(stok_mobil.getnamamobil());
        }

    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, RoomReadSingleActivity.class);
    }
}

