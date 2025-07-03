package com.ionichi.login;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CuacaViewHolder extends RecyclerView.ViewHolder {
    public ImageView cuacaImageView;
    public TextView nameTextView, descriptionTextView, dateTimeTextView, tempTextView;

    public CuacaViewHolder(@NonNull View itemView) {
        super(itemView);

        cuacaImageView = itemView.findViewById(R.id.cuacaImageView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        dateTimeTextView = itemView.findViewById(R.id.dateTimeTextView);
        tempTextView = itemView.findViewById(R.id.tempTextView);
    }
}
