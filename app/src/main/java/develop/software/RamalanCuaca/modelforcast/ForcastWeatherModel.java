
package develop.software.RamalanCuaca.modelforcast;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ForcastWeatherModel implements Serializable, Parcelable
{

    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Double message;
    @SerializedName("cnt")
    @Expose
    private Double cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<List> list = null;
    @SerializedName("city")
    @Expose
    private City city;
    public final static Creator<ForcastWeatherModel> CREATOR = new Creator<ForcastWeatherModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ForcastWeatherModel createFromParcel(Parcel in) {
            return new ForcastWeatherModel(in);
        }

        public ForcastWeatherModel[] newArray(int size) {
            return (new ForcastWeatherModel[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1498670793271159682L;

    protected ForcastWeatherModel(Parcel in) {
        this.cod = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((Double) in.readValue((Double.class.getClassLoader())));
        this.cnt = ((Double) in.readValue((Double.class.getClassLoader())));
        in.readList(this.list, (List.class.getClassLoader()));
        this.city = ((City) in.readValue((City.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ForcastWeatherModel() {
    }

    /**
     * 
     * @param city
     * @param cnt
     * @param cod
     * @param message
     * @param list
     */
    public ForcastWeatherModel(String cod, Double message, Double cnt, java.util.List<List> list, City city) {
        super();
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public Double getCnt() {
        return cnt;
    }

    public void setCnt(Double cnt) {
        this.cnt = cnt;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(cod);
        dest.writeValue(message);
        dest.writeValue(cnt);
        dest.writeList(list);
        dest.writeValue(city);
    }

    public int describeContents() {
        return  0;
    }

}
