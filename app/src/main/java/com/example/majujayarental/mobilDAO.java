package com.example.majujayarental;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

public interface mobilDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertnopol(stok_mobil stok_mobil);


    @Update
    int updatenopol(stok_mobil stok_mobil);

    @Delete
    int deletenopol(stok_mobil stok_mobil);
    @Query("SELECT * FROM smobil")
    stok_mobil[] selectAllBarangs();

    @Query("SELECT * FROM smobil WHERE nopol = :id LIMIT 1")
    stok_mobil selectstok_mobilDetail(int id);


}