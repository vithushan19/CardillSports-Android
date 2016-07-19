package com.cardillsports.vithushan.cardillsportsandroid;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by vithushan on 7/18/16.
 */
public class Article implements Parcelable{
    public String _id;
    public String Name;
    public String ImageLink;
    public CreatorModel Owner;
    public List<ArticleItem> ArticleItems;
    public List<Comment> Comments;
    public float Rating;

    protected Article(Parcel in) {
        _id = in.readString();
        Name = in.readString();
        ImageLink = in.readString();
        Owner = CreatorModel.CREATOR.createFromParcel(in);
        ArticleItems = in.createTypedArrayList(ArticleItem.CREATOR);
        Rating = in.readFloat();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
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
