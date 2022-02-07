package com.gb.base_1728_lesson_6;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {
    private int imageIndex;
    private String cityName;

    protected City(Parcel in) {
        imageIndex = in.readInt();
        cityName = in.readString();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public City(String cityName, int imageIndex) {
        this.cityName = cityName;
        this.imageIndex = imageIndex;
    }

    public int getImageIndex() {
        return imageIndex;
    }

    public void setImageIndex(int imageIndex) {
        this.imageIndex = imageIndex;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageIndex);
        parcel.writeString(cityName);
    }
}
