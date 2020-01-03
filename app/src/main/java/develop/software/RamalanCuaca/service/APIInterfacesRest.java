package develop.software.RamalanCuaca.service;

/**
 * Created by user on 1/10/2018.
 */












import develop.software.RamalanCuaca.modelforcast.ForcastWeatherModel;
import develop.software.RamalanCuaca.model.WeatherModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anupamchugh on 09/01/17.
 */

 public interface APIInterfacesRest {


   @GET("forecast")
   Call<ForcastWeatherModel> getForcastByCity(@Query("q") String q, @Query("appid") String appid);

    @GET("forecast")
    Call<ForcastWeatherModel> getForecastBasedLocation(@Query("lat") Double lat, @Query("lon") Double lon, @Query("appid") String appid);


    @GET("weather")
    Call<WeatherModel> getWeather(@Query("q") String q, @Query("appid") String appid);

    @GET("weather")
    Call<WeatherModel> getWeatherBasedLocation(@Query("lat") Double lat,@Query("lon") Double lon, @Query("appid") String appid);




  /*@GET("weather")
    Call<WeatherModel> getWeather(@Query("q") String q, @Query("appid") String appid);

   // @GET("weather")
    Call<WeatherModel> getWeatherBasedLocation(@Query("lat") Double lat, @Query("lon") Double lon, @Query("appid") String appid);


   */

/*
    @GET("users")
    Call<com.juaracoding.absensi.model.reqres.User> getUserReqres(@Query("page") String page);

    @GET("posts")
    Call<List<Post>> getPost();

    @GET("comments")
    Call<List<Comment>> getComment(@Query("postId") String postId);*/



   /* @FormUrlEncoded
    @POST("api/user/login")
    Call<Authentication> getAuthentication(@Field("username") String username, @Field("password") String password);

    @GET("api/user_mobile/all")
    Call<Authentication> getUser(@Query("username_k") String user);

   @GET("api/komplain/ticket")
   Call<KomplainModel> getTicket(@Query("username") String username);

    @FormUrlEncoded
    @POST("api/komplain/add")
    Call<UpdateKomplain> addKomplain(@Field("username_komplain") String username, @Field("kode_edc") String kode_edc, @Field("masalah") String masalah, @Field("notes_komplain") String notes);

    @GET("api/edc_problem/all")
    Call<MasalahEdcModel> getEDCProblem();
*//*
    @GET("api/dataorder/all")
    Call<ModelOrder> getOrder(@Query("username") String user);



/*
            @Part MultipartBody.Part img1,
           @Part MultipartBody.Part img2,
           @Part MultipartBody.Part img3,
 *//*

   @Multipart
   @POST("api/dataorder/update")
   Call<Komplain> updateData(

           @Part("pod_date") RequestBody podate,
           @Part("status") RequestBody status,
           @Part("lat") RequestBody lat,
           @Part("lon") RequestBody lon,
           @Part("poddate") RequestBody poddate,
           @Part("recievedate") RequestBody recievedate,
           @Part("id") RequestBody id,
           @Part MultipartBody.Part img1


   );


   @Multipart
   @POST("api/komplain/update")
   Call<UpdateKomplain> sendImage(
           @Part("id") RequestBody id,
           @Part("username_penanganan") RequestBody username_komplain,
           @Part("hasil_penanganan") RequestBody masalah,
           @Part("tanggal_penanganan") RequestBody kode_edc,
           @Part("notes_penanganan") RequestBody notes_komplain,
           @Part("status") RequestBody status,
           @Part MultipartBody.Part img1


   );*/

}

