package com.cardillsports.vithushan.cardillsportsandroid.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vithushan on 7/18/16.
 */
public class Creator implements Parcelable {
    public String userPicture;
    public String name;

    protected Creator(Parcel in) {
        userPicture = in.readString();
        name = in.readString();
    }

    public static final Creator<com.cardillsports.vithushan.cardillsportsandroid.models.Creator> CREATOR = new Creator<com.cardillsports.vithushan.cardillsportsandroid.models.Creator>() {
        @Override
        public com.cardillsports.vithushan.cardillsportsandroid.models.Creator createFromParcel(Parcel in) {
            return new com.cardillsports.vithushan.cardillsportsandroid.models.Creator(in);
        }

        @Override
        public com.cardillsports.vithushan.cardillsportsandroid.models.Creator[] newArray(int size) {
            return new com.cardillsports.vithushan.cardillsportsandroid.models.Creator[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userPicture);
        parcel.writeString(name);
    }
}
