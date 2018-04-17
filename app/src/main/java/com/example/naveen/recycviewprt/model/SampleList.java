package com.example.naveen.recycviewprt.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SampleList {
    @SerializedName("data")
    public List<Data> data;

    public static class Data {
        @SerializedName("Url")
        public String Url;
        @SerializedName("Type")
        public String Type;
        @SerializedName("id")
        public int id;
    }
}
