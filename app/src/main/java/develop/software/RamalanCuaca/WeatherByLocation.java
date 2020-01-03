package develop.software.RamalanCuaca;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.location.Location;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.robin.locationgetter.EasyLocation;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.text.DecimalFormat;

import develop.software.RamalanCuaca.model.WeatherModel;
import develop.software.RamalanCuaca.service.APIClient;
import develop.software.RamalanCuaca.service.APIInterfacesRest;
import develop.software.ramalancuaca.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherByLocation extends AppCompatActivity {

    TextView txtKota, txtTemp, txtSunrise, txtSunset, txtPresure, txtClaudiness, txtHumadity, txtGeocords, txtWind, txtCuaca;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_by_location);
        setTitle("Weather By Location");


        txtKota = findViewById(R.id.isiKota);
        txtTemp = findViewById(R.id.isiSuhu);
        txtClaudiness = findViewById(R.id.isiClaudiness);
        txtGeocords = findViewById(R.id.isiGeoCords);
        txtHumadity = findViewById(R.id.isiHumadity);
        txtPresure = findViewById(R.id.isiPresure);
        txtSunrise = findViewById(R.id.isiSunrise);
        txtSunset = findViewById(R.id.isiSunset);
        txtWind = findViewById(R.id.isiWind);
        image = findViewById(R.id.isiGambar);
        txtCuaca = findViewById(R.id.isiCuaca);




        new EasyLocation(WeatherByLocation.this, new EasyLocation.EasyLocationCallBack() {
            @Override
            public void permissionDenied() {

            }

            @Override
            public void locationSettingFailed() {

            }

            @Override
            public void getLocation(Location location) {

                callWeatherBasedLocation(location.getLatitude(),location.getLongitude());
            }
        });




    }
    APIInterfacesRest apiInterface;
    ProgressDialog progressDialog;

    public void callWeatherBasedLocation(Double lat, Double lon ) {

        apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        progressDialog = new ProgressDialog(WeatherByLocation.this);
        progressDialog.setTitle("Loading");
        progressDialog.show();
        Call<WeatherModel> call3 = apiInterface.getWeatherBasedLocation(lat, lon, "6c57819f3114a6213bf6a1a0290c4f2c");
        call3.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                progressDialog.dismiss();
                WeatherModel dataWeather = response.body();

                if (dataWeather != null) {



                    txtKota.setText(dataWeather.getName());
                    txtTemp.setText(new DecimalFormat("##.##").format(dataWeather.getMain().getTemp() - 273.15));
                    txtWind.setText(dataWeather.getWind().getDeg().toString() + "m/s");
                    txtHumadity.setText(dataWeather.getMain().getHumidity().toString() + "%");
                    txtPresure.setText(dataWeather.getMain().getPressure().toString());
                    txtGeocords.setText(dataWeather.getCoord().getLat().toString() + dataWeather.getCoord().getLon().toString());
                    txtClaudiness.setText(dataWeather.getClouds().getAll().toString());
                    txtCuaca.setText(dataWeather.getWeather().get(0).getDescription());
                    txtSunrise.setText(dataWeather.getSys().getSunrise().toString());
                    txtSunset.setText(dataWeather.getSys().getSunset().toString());





                } else {

                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(WeatherByLocation.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();



                    } catch (Exception e) {
                        Toast.makeText(WeatherByLocation.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            }


            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Maaf koneksi bermasalah", Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });


    }
}
