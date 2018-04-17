package com.example.naveen.recycviewprt.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecycleList {

    @SerializedName("sitter")
    public Sitter sitter;

    public static class VideoThumb {
    }

    public static class Images {
        @SerializedName("url")
        public String url;
        @SerializedName("width")
        public int width;
        @SerializedName("height")
        public int height;
    }

    public static class Like_data {
        @SerializedName("totalLike")
        public String totalLike;
    }

    public static class Data {
        @SerializedName("id")
        public String id;
        @SerializedName("title")
        public String title;
        @SerializedName("description")
        public String description;
        @SerializedName("user_id")
        public String user_id;
        @SerializedName("post_date")
        public String post_date;
        @SerializedName("typeMode")
        public String typeMode;
        @SerializedName("videoThumb")
        public List<VideoThumb> videoThumb;
        @SerializedName("sourceMode")
        public String sourceMode;
        @SerializedName("videoMode")
        public String videoMode;
        @SerializedName("youtube_url")
        public String youtube_url;
        @SerializedName("images")
        public List<Images> images;
        @SerializedName("like_data")
        public List<Like_data> like_data;
        @SerializedName("userlikestatus")
        public String userlikestatus;
        @SerializedName("userReadstatus")
        public String userReadstatus;
    }

    public static class Response {
        @SerializedName("status")
        public String status;
        @SerializedName("status_code")
        public int status_code;
        @SerializedName("status_message")
        public String status_message;
        @SerializedName("data")
        public List<Data> data;
    }

    public static class Sitter {
        @SerializedName("response")
        public Response response;
    }
}
