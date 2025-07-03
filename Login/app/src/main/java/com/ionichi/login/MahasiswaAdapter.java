package com.ionichi.login;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaViewHolder> {
    private List<MahasiswaModel> _mahasiswaModelList;

    public MahasiswaAdapter(List<MahasiswaModel> _mahasiswaModelList) {
        this._mahasiswaModelList = _mahasiswaModelList;
    }

    public void filter(List<MahasiswaModel> filteredList) {
        this._mahasiswaModelList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.list_mahasiswa, parent, false);

        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        int no = position + 1;
        holder._noTextView.setText(no + ". ");

        MahasiswaModel mm = _mahasiswaModelList.get(position);

        holder._genderImageView.setImageResource(R.drawable.boy);
        if (mm.getJenisKelamin().toLowerCase().equals("perempuan")) {
            holder._genderImageView.setImageResource(R.drawable.girl);
        }

        holder._nimTextView.setText(mm.getNIM());
        holder._nameTextView.setText(mm.getNama());
        holder._genderTextView.setText(mm.getJenisKelamin());

        String jurusan = mm.getJP();
        jurusan = jurusan.substring(0, 2); // hanya mengambil 2 karakter depan
        holder._jurusanTextView.setText(jurusan);

        if (jurusan.equals("TI")) {
            holder._jurusanTextView.setBackgroundColor(Color.BLUE);
        } else if (jurusan.equals("SI")) {
            holder._jurusanTextView.setBackgroundColor(Color.RED);
        } else {
            holder._jurusanTextView.setBackgroundColor(Color.GRAY);
        }
    }

    @Override
    public int getItemCount() {
        return (_mahasiswaModelList != null) ? _mahasiswaModelList.size() : 0;
    }
}
