package com.example.majujayarental;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "smobil")
public class stok_mobil implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int nopol;

    @ColumnInfo(name = "nama_peminjam")
    public String namapeminjam;

    @ColumnInfo(name = "tanggal_pinjam")
    public String tanggalpinjam;

    @ColumnInfo(name = "tanggal_kembali")
    public String tanggalkembali;

    @ColumnInfo(name = "nama_mobil")
    public String namamobil;


        public int getnopol() {
            return nopol;
        }

        public void setnopolId(int nopol) {
            this.nopol = nopol;
        }

        public String getnamapeminjam() { return namapeminjam; }

        public void setnamapeminjam(String namapeminjam) {
            this.namapeminjam = namapeminjam;
        }

        public String gettanggalpinjam() { return tanggalpinjam; }

        public void settanggalpinjam(String tanggalpinjam) {
            this.tanggalpinjam = tanggalpinjam;
        }

        public String gettanggalkembali() {
            return tanggalkembali;
        }

        public void settanggalkembali(String tanggalkembali) {
            this.tanggalkembali = tanggalkembali;
        }

        public String getnamamobil() {
            return namamobil;
        }

        public void setnamamobil(String namamobil) {
            this.namamobil = namamobil;
        }
    }



