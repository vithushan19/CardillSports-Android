package com.cardillsports.vithushan.cardillsportsandroid;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vithushan on 7/18/16.
 */
public class CreatorModel implements Parcelable {
    public String firstName;
    public String lastName;
    public String userPicture;

    protected CreatorModel(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        userPicture = in.readString();
    }

    public static final Creator<CreatorModel> CREATOR = new Creator<CreatorModel>() {
        @Override
        public CreatorModel createFromParcel(Parcel in) {
            return new CreatorModel(in);
        }

        @Override
        public CreatorModel[] newArray(int size) {
            return new CreatorModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(userPicture);
    }
}
