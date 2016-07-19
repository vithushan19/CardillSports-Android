package com.cardillsports.vithushan.cardillsportsandroid;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by vithushan on 7/18/16.
 */
public class ArticleItem implements Parcelable{
    public String Paragraph;
    public String Type;

    protected ArticleItem(Parcel in) {
        Paragraph = in.readString();
        Type = in.readString();
    }

    public static final Creator<ArticleItem> CREATOR = new Creator<ArticleItem>() {
        @Override
        public ArticleItem createFromParcel(Parcel in) {
            return new ArticleItem(in);
        }

        @Override
        public ArticleItem[] newArray(int size) {
            return new ArticleItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Paragraph);
        parcel.writeString(Type);
    }
}
