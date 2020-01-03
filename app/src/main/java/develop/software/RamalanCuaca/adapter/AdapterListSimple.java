package develop.software.RamalanCuaca.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import develop.software.RamalanCuaca.modelforcast.List;
import develop.software.ramalancuaca.R;


public class AdapterListSimple extends RecyclerView.Adapter<AdapterListSimple.ViewHolder> {




    java.util.List<List> data;
    Context context;
    String lokasi;


    public AdapterListSimple(Context context, java.util.List<List> data, String lokasi){


        this.lokasi = lokasi;
        this.data = data;
        this.context = context;

    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view ;

            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather_by_location, parent, false);


        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

//
        holder.txtLokasi.setText(lokasi);
        holder.txtCuaca.setText(data.get(position).getWeather().get(0).getDescription());
        holder.txtSuhu.setText(new DecimalFormat("##.##").format(data.get(position).getMain().getTemp()-273.15));
        holder.txtTanggal.setText(data.get(position).getDtTxt());

        String image = "http://openweathermap.org/img/wn/"+ data.get(position).getWeather().get(0).getIcon()+"@2x.png";
        Picasso.get().load(image).into(holder.image);







    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder  {
        public TextView txtSuhu,txtLokasi,txtCuaca,txtTanggal;
        public ImageView image;
        public LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            txtLokasi = (TextView) itemView.findViewById(R.id.txtLokasi);
            txtSuhu = (TextView) itemView.findViewById(R.id.txtSuhu);
            txtCuaca = (TextView) itemView.findViewById(R.id.txtCuaca);
            txtTanggal = (TextView) itemView.findViewById(R.id.txtTanggal);

            image = (ImageView)itemView.findViewById(R.id.image);
            parentLayout = (LinearLayout)itemView.findViewById(R.id.parentLayout);

        }

    }


}
