package com.ionichi.customspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {
    private Context _context;
    private List<String> _countryList;

    public CountryAdapter(Context _context, List<String> _countryList) {
        this._context = _context;
        this._countryList = _countryList;
    }

    @Override
    public int getCount() {
         return (_countryList != null) ? _countryList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(_context);
        convertView = inflater.inflate(R.layout.spinner_a, null);

        TextView textView = convertView.findViewById(R.id.textView1);
        String country = _countryList.get(position);

        textView.setText(country);

        ImageView imageView = convertView.findViewById(R.id.imageView1);

        switch (country) {
            case "Albania":
                imageView.setImageResource(R.drawable.albania);
                break;
            case "Belgia":
                imageView.setImageResource(R.drawable.belgia);
                break;
            case "Hungary":
                imageView.setImageResource(R.drawable.hungary);
                break;
            case "Iran":
                imageView.setImageResource(R.drawable.iran);
                break;
            case "Slovenia":
                imageView.setImageResource(R.drawable.slovenia);
                break;
        }

        return convertView;
    }
}
