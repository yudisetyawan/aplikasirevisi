package com.example.majujayarental;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.room.Room.databaseBuilder;

public class adapter_rental_mobil extends RecyclerView.Adapter<adapter_rental_mobil.ViewHolder> {

    private ArrayList<stok_mobil> daftarmobil;
    private Context context;
    private AppDatabase db;

    public adapter_rental_mobil(ArrayList<stok_mobil> mobils, RoomReadActivity ctx) {

        daftarmobil = mobils;
        context = ctx;
;
    }
    class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Inisiasi View
         * Di tutorial ini kita hanya menggunakan data String untuk tiap item
         * dan juga view nya hanyalah satu TextView
         */
        TextView tvTitle;
        CardView cvMain;

        ViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tv_namamobil);
            cvMain = v.findViewById(R.id.cv_main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mobil, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String name = daftarmobil.get(position).getnamamobil();

        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Read detail data
                 */
                stok_mobil mobil = db.mobilDAO().selectstok_mobilDetail(daftarmobil.get(position).getnopol());
                context.startActivity(RoomReadSingleActivity.getActIntent((Activity) context).putExtra("data", mobil));
            }
        });
        holder.cvMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.view_dialog);
                dialog.setTitle("Pilih Stok");
                dialog.show();

                Button editButton = dialog.findViewById(R.id.bt_edit_data);
                Button delButton = dialog.findViewById(R.id.btdelete_data);


                editButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                onEditBarang(position);
                            }
                        }
                );

                //apabila tombol delete diklik
                delButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                onDeletenamapeminjam(position);
                            }
                        }
                );
                return true;
            }
        });
        holder.tvTitle.setText(name);
    }

    private void onDeletenamapeminjam(int position) {
            db.mobilDAO().deletenopol(daftarmobil.get(position));
            daftarmobil.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeRemoved(position, daftarmobil.size());
        }



    private void onEditBarang(int position){
        context.startActivity(RoomCreateActivity.getActIntent((Activity) context).putExtra("data", daftarmobil.get(position)));
    }

    @Override
    public int getItemCount() {

        return daftarmobil.size();
    }
}


