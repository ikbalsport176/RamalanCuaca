
package develop.software.RamalanCuaca.modelforcast;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Main implements Serializable, Parcelable
{

    @SerializedName("temp")
    @Expose
    private Double temp;
    @SerializedName("feels_like")
    @Expose
    private Double feelsLike;
    @SerializedName("temp_min")
    @Expose
    private Double tempMin;
    @SerializedName("temp_max")
    @Expose
    private Double tempMax;
    @SerializedName("pressure")
    @Expose
    private Double pressure;
    @SerializedName("sea_level")
    @Expose
    private Double seaLevel;
    @SerializedName("grnd_level")
    @Expose
    private Double grndLevel;
    @SerializedName("humidity")
    @Expose
    private Double humidity;
    @SerializedName("temp_kf")
    @Expose
    private Double tempKf;
    public final static Creator<Main> CREATOR = new Creator<Main>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Main createFromParcel(Parcel in) {
            return new Main(in);
        }

        public Main[] newArray(int size) {
            return (new Main[size]);
        }

    }
    ;
    private final static long serialVersionUID = 132390895420633691L;

    protected Main(Parcel in) {
        this.temp = ((Double) in.readValue((Double.class.getClassLoader())));
        this.feelsLike = ((Double) in.readValue((Double.class.getClassLoader())));
        this.tempMin = ((Double) in.readValue((Double.class.getClassLoader())));
        this.tempMax = ((Double) in.readValue((Double.class.getClassLoader())));
        this.pressure = ((Double) in.readValue((Double.class.getClassLoader())));
        this.seaLevel = ((Double) in.readValue((Double.class.getClassLoader())));
        this.grndLevel = ((Double) in.readValue((Double.class.getClassLoader())));
        this.humidity = ((Double) in.readValue((Double.class.getClassLoader())));
        this.tempKf = ((Double) in.readValue((Double.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Main() {
    }

    /**
     * 
     * @param feelsLike
     * @param tempMax
     * @param temp
     * @param seaLevel
     * @param humidity
     * @param pressure
     * @param tempKf
     * @param grndLevel
     * @param tempMin
     */
    public Main(Double temp, Double feelsLike, Double tempMin, Double tempMax, Double pressure, Double seaLevel, Double grndLevel, Double humidity, Double tempKf) {
        super();
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.seaLevel = seaLevel;
        this.grndLevel = grndLevel;
        this.humidity = humidity;
        this.tempKf = tempKf;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Double getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(Double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getTempKf() {
        return tempKf;
    }

    public void setTempKf(Double tempKf) {
        this.tempKf = tempKf;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(temp);
        dest.writeValue(feelsLike);
        dest.writeValue(tempMin);
        dest.writeValue(tempMax);
        dest.writeValue(pressure);
        dest.writeValue(seaLevel);
        dest.writeValue(grndLevel);
        dest.writeValue(humidity);
        dest.writeValue(tempKf);
    }

    public int describeContents() {
        return  0;
    }

}
