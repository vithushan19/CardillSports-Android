package com.cardillsports.vithushan.cardillsportsandroid.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by vithushan on 7/18/16.
 */
public class CardillContent implements Parcelable{
    public String _id;
    public String Name;
    public String ImageLink;
    public CreatorModelId Owner;
    public List<ArticleItem> ArticleItems;
    public List<Comment> Comments;
    public float Rating;

    protected CardillContent(Parcel in) {
        _id = in.readString();
        Name = in.readString();
        ImageLink = in.readString();
        Owner = CreatorModelId.CREATOR.createFromParcel(in);
        ArticleItems = in.createTypedArrayList(ArticleItem.CREATOR);
        Rating = in.readFloat();
    }

    public static final Creator<CardillContent> CREATOR = new Creator<CardillContent>() {
        @Override
        public CardillContent createFromParcel(Parcel in) {
            return new CardillContent(in);
        }

        @Override
        public CardillContent[] newArray(int size) {
            return new CardillContent[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(_id);
        dest.writeString(Name);
        dest.writeString(ImageLink);
        Owner.writeToParcel(dest, i);
        dest.writeTypedList(ArticleItems);
        dest.writeTypedList(Comments);
        dest.writeFloat(Rating);
    }
}
