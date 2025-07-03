package com.ionichi.login;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CuacaAdapter extends RecyclerView.Adapter<CuacaViewHolder> {
    private List<CuacaListModel> listModels;
    private CuacaRootModel rm;

    public CuacaAdapter(CuacaRootModel rm) {
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
        CuacaListModel lm = listModels.get(position);
        CuacaWeatherModel cm = lm.getCuacaModelList().get(0);
        CuacaMainModel mm = lm.getMainModel();

        String temperature = formatNumber(toCelcius(mm.getTemp_min()), "###.##") + "°C - " + formatNumber(toCelcius(mm.getTemp_max()), "###.##") + "°C";

        String iconUrl = "https://openweathermap.org/img/wn/" + cm.getIcon() + "@2x.png";
        Picasso.with(holder.itemView.getContext()).load(iconUrl).into(holder.cuacaImageView);

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
