package com.ionichi.recyclerviewa;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends RecyclerView.ViewHolder {

    public ImageView _imageView;
    public TextView _nameTextView;
    public TextView _descriptionTextView;

    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);

        _imageView = itemView.findViewById(R.id.imageView1);
        _nameTextView = itemView.findViewById(R.id.nameTextView);
        _descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
    }
}
