package com.example.naveen.recycviewprt.webservices;

import com.example.naveen.recycviewprt.model.RecycleList;
import com.example.naveen.recycviewprt.model.SampleList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiStories {
    String AUTH="Authkey:8ERjkil82VGonjt7EH4GKVE580fbPcNLal7I";



    @Headers(AUTH)
    @GET("api.php?&mod=posts&method=getPostsList&format=json")
    Call<RecycleList> getList();

    @GET("cehAhUdVCG?indent=2")
    Call<SampleList> getSampleList();
}
