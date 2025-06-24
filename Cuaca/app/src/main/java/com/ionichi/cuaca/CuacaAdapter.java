package com.ionichi.cuaca;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CuacaAdapter extends RecyclerView.Adapter<CuacaViewHolder> {
    private List<ListModel> listModels;
    private RootModel rm;

    public CuacaAdapter(RootModel rm) {
        this.rm = rm;

        listModels = rm.getListModels();
    }

    @NonNull
    @Override
    public CuacaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cuaca, parent, false);
        return new CuacaViewHolder(view);
    }

    private double toCelcius(double kelvin) {
        return kelvin - 272.15;
    }

    public String formatNumber (double number, String format) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(number);
    }

    @Override
    public void onBindViewHolder(@NonNull CuacaViewHolder holder, int position) {
        ListModel lm = listModels.get(position);
        CuacaModel cm = lm.getCuacaModelList().get(0);
        MainModel mm = lm.getMainModel();

        String temperature = formatNumber(toCelcius(mm.getTemp_min()), "###.##") + "°C - " + formatNumber(toCelcius(mm.getTemp_max()), "###.##") + "°C";

        switch (cm.getIcon()) {
            case "01d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_01d);
                break;
            case "01n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_01n);
                break;
            case "02d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_02d);
                break;
            case "02n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_02n);
                break;
            case "03d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_03d);
                break;
            case "03n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_03n);
                break;
            case "04d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_04d);
                break;
            case "04n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_04n);
                break;
            case "09d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_09d);
                break;
            case "09n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_09n);
                break;
            case "10d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_10d);
                break;
            case "10n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_10n);
                break;
            case "11d":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_11d);
                break;
            case "11n":
                holder.cuacaImageView.setImageResource(R.mipmap.ic_11n);
                break;
        }

        String dateTimeWIB = formatWib(lm.getDt_txt());

        holder.nameTextView.setText(cm.getMain());
        holder.descriptionTextView.setText(cm.getDescription());
        holder.dateTimeTextView.setText(dateTimeWIB);
        holder.tempTextView.setText(temperature);
    }

    @Override
    public int getItemCount() {
        return (listModels != null) ? listModels.size() : 0;
    }

    private String formatWib(String dateTimeGMT_string) {
        Date dateTimeGMT = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            dateTimeGMT = sdf.parse(dateTimeGMT_string);
        } catch (ParseException e) {
            Log.e("*ionichi*", e.getMessage());
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTimeGMT);
        calendar.add(Calendar.HOUR_OF_DAY, 7);

        Date dateTimeWIB = calendar.getTime();

        String dateTimeWIB_string = sdf.format(dateTimeWIB);
        dateTimeWIB_string = dateTimeWIB_string.replace("00:00", "00 WIB");

        return dateTimeWIB_string;
    }
}
