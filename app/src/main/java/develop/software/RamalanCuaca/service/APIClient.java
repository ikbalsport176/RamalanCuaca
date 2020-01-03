package develop.software.RamalanCuaca.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 1/10/2018.
 */

public class APIClient {


   public static String BASE_URL ="https://api.openweathermap.org/data/2.5/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
/*
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("X-Api-Key", APIClient.API_KEY).build();
                return chain.proceed(newRequest);
            }
        };

*/
       // HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
       // interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
       // OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        OkHttpClient client = new OkHttpClient.Builder().build();
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(String.class, new StringConverter());
        gb.serializeNulls();
       // gb.excludeFieldsWithoutExposeAnnotation();
        Gson gson = gb.create();


        retrofit = new Retrofit.Builder()
                .baseUrl(APIClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))

                .client(client)
                .build();



        return retrofit;
    }

}
