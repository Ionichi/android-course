package com.ionichi.recyclerviewa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {
    private Context _context;
    private List<CountryModel> _countryModelList;

    public CountryAdapter(Context _context, List<CountryModel> _countryModelList) {
        this._context = _context;
        this._countryModelList = _countryModelList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.layout_country, parent, false);
        return new CountryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        CountryModel cm = _countryModelList.get(position);
        Picasso.with(_context).load(cm.getUrl()).into(holder._imageView);
        holder._nameTextView.setText(cm.getName());
        holder._descriptionTextView.setText(cm.getDescription());
    }

    @Override
    public int getItemCount() {
        return (_countryModelList != null) ? _countryModelList.size() : 0;
    }
}
