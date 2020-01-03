package develop.software.RamalanCuaca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONObject;

import develop.software.RamalanCuaca.adapter.AdapterListSimple;
import develop.software.RamalanCuaca.modelforcast.ForcastWeatherModel;
import develop.software.RamalanCuaca.service.APIClient;
import develop.software.RamalanCuaca.service.APIInterfacesRest;
import develop.software.ramalancuaca.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForcastByCity extends AppCompatActivity {

    EditText txtCari;
    ImageButton btnCari;
    RecyclerView lstCuaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forcast_by_city);
        setTitle("Forcast By City");


        txtCari = findViewById(R.id.isiCari);
        btnCari = findViewById(R.id.btnCari);
        lstCuaca = findViewById(R.id.listCuaca);

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callForcastByCity(txtCari.getText().toString());



            }
        });

      


    }

    APIInterfacesRest apiInterface;
    ProgressDialog progressDialog;
    public void callForcastByCity(String kota){

        apiInterface = APIClient.getClient().create(APIInterfacesRest.class);
        progressDialog = new ProgressDialog(ForcastByCity.this);
        progressDialog.setTitle("Loading");
        progressDialog.show();
        Call<ForcastWeatherModel> call3 = apiInterface.getForcastByCity(kota,"6c57819f3114a6213bf6a1a0290c4f2c");
        call3.enqueue(new Callback<ForcastWeatherModel>() {
            @Override
            public void onResponse(Call<ForcastWeatherModel> call, Response<ForcastWeatherModel> response) {
                progressDialog.dismiss();
                ForcastWeatherModel dataWeather = response.body();
                //Toast.makeText(LoginActivity.this,userList.getToken().toString(),Toast.LENGTH_LONG).show();
                if (dataWeather !=null) {

                    // txtKota.setText(dataWeather.getName());
                    // txtTemperature.setText(new DecimalFormat("##.##").format(dataWeather.getMain().getTemp()-273.15));


                    AdapterListSimple adapter = new AdapterListSimple(ForcastByCity.this,dataWeather.getList(),dataWeather.getCity().getName());

                    lstCuaca.setLayoutManager(new LinearLayoutManager(ForcastByCity.this));
                    lstCuaca.setItemAnimator(new DefaultItemAnimator());
                    lstCuaca.setAdapter(adapter);




                }else{

                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(ForcastByCity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(ForcastByCity.this, e.getMessage(), Toast.LENGTH_LONG).show();
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
