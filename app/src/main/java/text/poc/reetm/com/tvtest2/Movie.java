package text.poc.reetm.com.tvtest2;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String title;
    private String subTitle;
    private String imgUrl;

    public Movie() {
    }

    public Movie(String title, String subTitle, String imgUrl) {
        this.title = title;
        this.subTitle = subTitle;
        this.imgUrl = imgUrl;
    }

    protected Movie(Parcel in) {
        title = in.readString();
        subTitle = in.readString();
        imgUrl = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(subTitle);
        parcel.writeString(imgUrl);
    }
}
