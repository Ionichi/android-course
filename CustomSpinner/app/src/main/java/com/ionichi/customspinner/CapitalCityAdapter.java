package com.ionichi.customspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class CapitalCityAdapter extends BaseAdapter {
    private Context _context;
    private List<String> _countryList;

    public CapitalCityAdapter(Context _context, List<String> _countryList) {
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
        convertView = inflater.inflate(R.layout.spinner_b, parent, false);

        String country = _countryList.get(position);

        TextView textViewCountry = convertView.findViewById(R.id.textView1);
        TextView textViewCity = convertView.findViewById(R.id.textViewCity);
        ImageView imageView = convertView.findViewById(R.id.imageView1);
        LinearLayout layoutCard = convertView.findViewById(R.id.layoutCard);

        textViewCountry.setText(country);

        switch (country) {
            case "Korea":
                imageView.setImageResource(R.drawable.korea);
                textViewCity.setText("Korea");
                layoutCard.setBackgroundColor(ContextCompat.getColor(_context, R.color.gradientPink));
                break;
            case "France":
                imageView.setImageResource(R.drawable.paris);
                textViewCity.setText("Paris");
                layoutCard.setBackgroundColor(ContextCompat.getColor(_context, R.color.gradientOrange));
                break;
            case "Indonesia":
                imageView.setImageResource(R.drawable.monas);
                textViewCity.setText("Jakarta");
                layoutCard.setBackgroundColor(ContextCompat.getColor(_context, R.color.gradientBlue));
                break;
            case "USA":
                imageView.setImageResource(R.drawable.liberty);
                textViewCity.setText("Washington, D.C.");
                layoutCard.setBackgroundColor(ContextCompat.getColor(_context, R.color.gray));
                break;
            case "England":
                imageView.setImageResource(R.drawable.bigben);
                textViewCity.setText("London");
                layoutCard.setBackgroundColor(ContextCompat.getColor(_context, R.color.gradientTeal));
                break;
        }

        return convertView;
    }
}
