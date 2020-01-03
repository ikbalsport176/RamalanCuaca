package develop.software.RamalanCuaca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.robin.locationgetter.EasyLocation;

import org.json.JSONObject;

import develop.software.RamalanCuaca.adapter.AdapterListSimple;
import develop.software.RamalanCuaca.modelforcast.ForcastWeatherModel;
import develop.software.RamalanCuaca.service.APIClient;
import develop.software.RamalanCuaca.service.APIInterfacesRest;
import develop.software.ramalancuaca.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForcastByLocation extends AppCompatActivity {


    RecyclerView lstForecast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forcast_by_location);

        lstForecast =findViewById(R.id.listForcastByLocation);

        new EasyLocation(ForcastByLocation.this, new EasyLocation.EasyLocationCallBack() {
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
    public void callWeatherBasedLocation(Double lat, Double lon ){

        apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        progressDialog = new ProgressDialog(ForcastByLocation.this);
        progressDialog.setTitle("Loading");
        progressDialog.show();
        Call<ForcastWeatherModel> call3 = apiInterface.getForecastBasedLocation(lat,lon,"6c57819f3114a6213bf6a1a0290c4f2c");
        call3.enqueue(new Callback<ForcastWeatherModel>() {
            @Override
            public void onResponse(Call<ForcastWeatherModel> call, Response<ForcastWeatherModel> response) {
                progressDialog.dismiss();
                ForcastWeatherModel dataWeather = response.body();

                if (dataWeather !=null) {



                    AdapterListSimple adapter = new AdapterListSimple(ForcastByLocation.this,dataWeather.getList(),dataWeather.getCity().getName());

                    lstForecast.setLayoutManager(new LinearLayoutManager(ForcastByLocation.this));
                    lstForecast.setItemAnimator(new DefaultItemAnimator());
                    lstForecast.setAdapter(adapter);




                }else{

                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(ForcastByLocation.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(ForcastByLocation.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<ForcastWeatherModel> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"Maaf koneksi bermasalah",Toast.LENGTH_LONG).show();
                call.cancel();
            }
        });




    }
}
