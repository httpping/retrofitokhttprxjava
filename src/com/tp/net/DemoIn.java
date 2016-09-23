package com.tp.net;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface DemoIn {

	
	 @GET("get")
	 Observable<String> getT(@Query("q") String query,@QueryMap HashMap<String, String> params);
	 
	 @POST("post")
	 Observable<String> postT(@QueryMap HashMap<String, String> params);
	 
	 
	 @POST("post")
	 Observable<String> postFrom(@Body RequestBody params);
	 
	 
	 @POST("post")
	 Observable<CustomBean> postFromGson(@Body RequestBody params);
	 
	 
	 
	 
	 @POST("post")
	 Observable<String> uploadFile(@Body MultipartBody params);
	
 
}
