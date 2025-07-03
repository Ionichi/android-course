package com.ionichi.login;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MahasiswaViewHolder extends RecyclerView.ViewHolder {
    public ImageView _genderImageView;
    public TextView _genderTextView, _jurusanTextView, _nameTextView, _nimTextView, _noTextView;

    public MahasiswaViewHolder(@NonNull View itemView) {
        super(itemView);

        _genderImageView = itemView.findViewById(R.id.genderImageView);
        _genderTextView = itemView.findViewById(R.id.genderTextView);
        _jurusanTextView = itemView.findViewById(R.id.jurusanTextView);
        _nameTextView = itemView.findViewById(R.id.nameTextView);
        _nimTextView = itemView.findViewById(R.id.nimTextView);
        _noTextView = itemView.findViewById(R.id.noTextView);
    }
}
