package com.example.naveen.recycviewprt.multimediarecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.Toast;
import com.example.naveen.recycviewprt.R;
import com.example.naveen.recycviewprt.model.SampleList;
import com.example.naveen.recycviewprt.multimediarecycler.business.MultiMediaAdapter;
import com.example.naveen.recycviewprt.webservices.ApiClient;
import com.example.naveen.recycviewprt.webservices.ApiStories;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MultiMediaRecycler extends AppCompatActivity {
    RecyclerView recyclerView;
    MultiMediaAdapter multiMediaAdapter;
    private List<SampleList.Data> recycleLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multimediarecycler);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        initialize();
    }

    private void initialize() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        callApi();
//        multiMediaAdapter=new MultiMediaAdapter(this);
    }

    private void callApi() {
        ApiStories apiStories = ApiClient.getRetrofit().create(ApiStories.class);

        Call<SampleList> recycleListCall = apiStories.getSampleList();
        recycleListCall.enqueue(new Callback<SampleList>() {
            @Override
            public void onResponse(Call<SampleList> call, Response<SampleList> response) {
                SampleList recycleLists = response.body();
                setAdapter(recycleLists);
            }

            @Override
            public void onFailure(Call<SampleList> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getLocalizedMessage() + "ERROR", Toast.LENGTH_LONG).show();
            }
        });


    }

    private void setAdapter(SampleList recycleList) {
        recycleLists = recycleList.data;
        multiMediaAdapter = new MultiMediaAdapter(this, recycleLists,recyclerView);
        recyclerView.setAdapter(multiMediaAdapter);
       // Toast.makeText(getApplicationContext(),  "SUCCESS", Toast.LENGTH_LONG).show();
    }

    public void setFragment(){

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.multimediamenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
