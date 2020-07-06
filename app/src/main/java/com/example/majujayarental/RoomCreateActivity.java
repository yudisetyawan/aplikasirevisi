package com.example.majujayarental;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static androidx.room.Room.databaseBuilder;

public class RoomCreateActivity extends AppCompatActivity {
    private AppDatabase db = databaseBuilder(getApplicationContext(),
            AppDatabase.class, "mobildb").build();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        final EditText Enamapeminjam   = findViewById(R.id.Enamapeminjam);
        final EditText Etanggalpinjam   = findViewById(R.id.Etanggalpinjam);
        final EditText Etanggalkembali  = findViewById(R.id.Etanggalkembali);
        final EditText Enamamobil  = findViewById(R.id.Enamamobil);
        Button btSubmit         = findViewById(R.id.btsubmit);

        final stok_mobil stok_mobil = (stok_mobil) getIntent().getSerializableExtra("data");

        if(stok_mobil!=null){
            Enamapeminjam.setText(stok_mobil.getnamapeminjam());
            Etanggalpinjam.setText(stok_mobil.gettanggalpinjam());
            Etanggalkembali.setText(stok_mobil.gettanggalkembali());
            Enamamobil.setText(stok_mobil.getnamamobil());
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    stok_mobil.setnamapeminjam(Enamapeminjam.getText().toString());
                    stok_mobil.settanggalpinjam(Etanggalpinjam.getText().toString());
                    stok_mobil.settanggalkembali(Etanggalkembali.getText().toString());
                    stok_mobil.setnamamobil(Enamamobil.getText().toString());
                    updatestok_mobil(stok_mobil);
                }
            });
        }else{
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    stok_mobil s = new stok_mobil();
                    s.setnamapeminjam(Enamapeminjam.getText().toString());
                    s.settanggalpinjam(Etanggalpinjam.getText().toString());
                    s.settanggalkembali(Etanggalkembali.getText().toString());
                    insertData(s);
                }
            });
        }
    }


    private void updatestok_mobil(final stok_mobil stok_mobil) {
        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.mobilDAO().updatenopol(stok_mobil);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(RoomCreateActivity.this, "status row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }



    private void insertData(final stok_mobil stok_mobil){

        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.mobilDAO().insertnopol(stok_mobil);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(RoomCreateActivity.this, "status row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    public static Intent getActIntent(Activity activity) {

        return new Intent(activity, RoomCreateActivity.class);
    }
}
