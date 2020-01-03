package develop.software.RamalanCuaca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import develop.software.ramalancuaca.R;

public class MainActivity extends AppCompatActivity {


    Button btnweaterlocation, btnweatherbycity, btnforcastbylocation, btnforcastbycity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnweaterlocation = findViewById(R.id.btnWeatherbylocation);
        btnweatherbycity = findViewById(R.id.btnWeatherbycity);
        btnforcastbylocation = findViewById(R.id.btnForcastbylocation);
        btnforcastbycity = findViewById(R.id.btnForcastbycity);

        btnweaterlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, WeatherByLocation.class);
                startActivity(pindah);

            }
        });

        btnweatherbycity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, WeatherByCity.class);
                startActivity(pindah);

            }
        });

        btnforcastbylocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, ForcastByLocation.class);
                startActivity(pindah);

            }
        });

        btnforcastbycity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this, ForcastByCity.class);
                startActivity(pindah);

            }
        });



    }
}
