package com.gb.base_1728_lesson_6;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {
    private int index;

    public City(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static Creator<City> getCREATOR() {
        return CREATOR;
    }

    protected City(Parcel in) {
        index = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(index);
    }
}
