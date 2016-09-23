package com.tp.net;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import android.text.TextUtils;

import com.tp.net.VpRequestParams.FileWrapper;

public class VPNetWork {
	public static final String tag = "VPNetWork";
	public static final   MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

	public static final String BASE_URL ="https://httpbin.org/";

	private static DemoIn mDemoIn;
	private static OkHttpClient okHttpClient;
	//private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

	public static DemoIn getDemoIn() {
		if (mDemoIn == null) {
			
			okHttpClient = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor()).build();
			
			Retrofit retrofit = new Retrofit.Builder().client(okHttpClient)
					.baseUrl(BASE_URL)
				//	.addConverterFactory(StringConverterFactory.create())
					.addConverterFactory(GsonConverterFactory.create())
					.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
					.build();
			mDemoIn = retrofit.create(DemoIn.class);
		}
		return mDemoIn;
	}

	
	static class  LoggingInterceptor implements Interceptor {
		  @Override public Response intercept(Interceptor.Chain chain) throws IOException {
		    Request request = chain.request();

		    long t1 = System.nanoTime();
		    NetLog.d("log",String.format("Sending request %s on %s%n%s",
		        request.url(), chain.connection(), request.headers()));
		    
		    RequestBody rbBody = request.body();
		    //rbBody.
		    
		    Response response = chain.proceed(request);
		    long t2 = System.nanoTime();
		    NetLog.d("log",String.format("Received response for %s in %.1fms%n%s",
		        response.request().url(), (t2 - t1) / 1e6d, response.headers()));

		    return response;
		  }
		}
	
	 
	
	
	/**
	 * 请求参数
	 * @param params
	 * @return
	 */
	public static RequestBody createRequestBody(VpRequestParams params){
		NetLog.d("request", "params : " + params);
		if (TextUtils.isEmpty(params.jsonParams)) { // Form表单
			okhttp3.FormBody.Builder builder = new FormBody.Builder();
			// add 参数
			for (ConcurrentHashMap.Entry<String, String> entry : params.urlParams.entrySet()) {// 增加url params
				builder.add(entry.getKey(), entry.getValue());
			}
			return builder.build();
		}else { // body text
			return RequestBody.create(JSON_TYPE, params.jsonParams);
		}
	}
	/**
	 * 文件上传
	 * @param params
	 * @return
	 */
	public static MultipartBody createFileRequestBody(VpRequestParams params){
		NetLog.d("request", "params:" + params);
		Builder builder = new MultipartBody.Builder();
		//add 参数
		 for (ConcurrentHashMap.Entry<String, String> entry : params.urlParams.entrySet()) {//增加url params
			 builder.addFormDataPart(entry.getKey(), entry.getValue());
		 }
		 for (ConcurrentHashMap.Entry<String, FileWrapper> entry : params.fileParams.entrySet()) {//增加url file
			 builder.addFormDataPart(entry.getKey(), entry.getValue().customFileName,
			            RequestBody.create(MediaType.parse(entry.getValue().contentType), entry.getValue().file));
		 }
		builder.setType(MultipartBody.FORM);
		
		MultipartBody requestBody = builder.build();
		return requestBody;
	}
	
	
	public static Observable<String> request(final Observable<String> observable) {
		final HashMap<String, String> params = new HashMap<String, String>();
		params.put("name", "tanping");
		params.put("pass", "123456");
		return VPNetWork.getDemoIn().getT("login", params)
				.subscribeOn(Schedulers.io())
				.flatMap(new Func1<String, Observable<String>>() {

					@Override
					public Observable<String> call(String paramT) {
//						if (true) {
//							int a = 1/0;
//						}
						return observable;
					}
				});
	}

	 
	
}
