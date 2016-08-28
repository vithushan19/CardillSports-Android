package com.cardillsports.vithushan.cardillsportsandroid.service;

import com.cardillsports.vithushan.cardillsportsandroid.models.CardillContent;
import com.cardillsports.vithushan.cardillsportsandroid.models.CreatorModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by vithushan on 7/18/16.
 */
public interface CardillSportsClient {
    @GET("/api/content")
    Call<List<CardillContent>> content();

    @GET("/api/podcasts")
    Call<List<CardillContent>> podcasts();

    @GET("/api/creators")
    Call<List<CreatorModel>> creators();
}
