package com.example.retrofitokrxtest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;

import com.tp.net.CustomBean;
import com.tp.net.NetLog;
import com.tp.net.VPNetWork;
import com.tp.net.VpRequestParams;


public class MainActivity extends Activity {
	public static final String tag = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final HashMap<String, String> params = new HashMap<String, String>();
        params.put("name", "tanp post");
        params.put("age", "谭平sssssdf");
        params.put("sex", 1+"");
        params.put("中文key", "中文value");
        
      //  VPNetWork.getDemoIn().getT("gettp",params).subscribeOn(Schedulers.io()).subscribe(resultObserver);
        
        
      //  VPNetWork.getDemoIn().postT(params).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(resultObserver);
//        
//        VPNetWork.getDemoIn().getT("gettp",params).subscribeOn(Schedulers.io()).flatMap(new Func1<String, Observable<String>>() {
//
//			@Override
//			public Observable<String> call(String paramT) {
//				NetLog.d(tag, "token " + Thread.currentThread().getName() +" " +paramT);
//				return VPNetWork.getDemoIn().postT(params);
//			}
//		}).observeOn(AndroidSchedulers.mainThread()).flatMap(new Func1<String, Observable<String>>() {
//
//			@Override
//			public Observable<String> call(String paramT) {
//				NetLog.d(tag, "two " + Thread.currentThread().getName() +" " +paramT);
//				int a = 1/0;
//				return Observable.just(paramT);
//			}
//		}).observeOn(AndroidSchedulers.mainThread()).subscribe(resultObserver);
        
        
        
	 NetLog.d(tag, "xxx  " + Thread.currentThread().getName() +" " );
//      VPNetWork.getDemoIn().getT("gettp",params).subscribeOn(Schedulers.io()).doOnSubscribe(new Action0() {
//		
//		@Override
//		public void call() {
//			NetLog.d(tag, "doOnSubscribe " + Thread.currentThread().getName() +" " );
//
//		}
//      }).subscribeOn(Schedulers.computation()).flatMap(new Func1<String, Observable<String>>() {
//
//			@Override
//			public Observable<String> call(String paramT) {
//				NetLog.d(tag, "token " + Thread.currentThread().getName() +" " +paramT);
//				return VPNetWork.getDemoIn().postT(params);
//			}
//		}).observeOn(AndroidSchedulers.mainThread()).map(new Func1<String, Integer>() {
//
//			@Override
//			public Integer call(String paramT) {
//				NetLog.d(tag, "two " + Thread.currentThread().getName() +" " +paramT);
//				return null;
//			}
//
//			 
//		}).observeOn(Schedulers.io()).map(new Func1<Integer, String>() {
//
//			@Override
//			public String call(Integer paramT) {
//				NetLog.d(tag, "three " + Thread.currentThread().getName() +" " +paramT);
//				return "multibale :" + paramT;
//			}
//		})
//		.observeOn(AndroidSchedulers.mainThread()).subscribe(resultObserver);
//        
    
//	 try {
//		postFileTest();
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
      
     
//	 
//	 Observable.just("one","two").subscribeOn(Schedulers.io()).filter(new Func1<String, Boolean>() {
//
//		@Override
//		public Boolean call(String arg0) {
//			if (TextUtils.isEmpty(arg0) || arg0.equals("one")) {
//				//return false;
//			}
//			return true;
//		}
//	}).flatMap(new Func1<String, Observable<String>>() {
//
//		@Override
//		public Observable<String> call(String arg0) {
//			arg0 = "map:" + arg0;
//			return Observable.just(arg0);
//		}
//	}).observeOn(AndroidSchedulers.mainThread()).subscribe(resultObserver);
//	 
//	 
//	 Observable.create(new OnSubscribe<String>() {
//
//		@Override
//		public void call(Subscriber<? super String> subscriber) {
//			subscriber.onNext("one");
//			subscriber.onNext("2");
//		}
//	}).subscribeOn(Schedulers.newThread())
//	.observeOn(AndroidSchedulers.mainThread()).subscribe(resultObserver);
//	 
//      
     // VPNetWork.request(VPNetWork.getDemoIn().postT(params)).observeOn(AndroidSchedulers.mainThread()).subscribe(resultObserver);
      
        
      
//      Observable.just("123").doOnSubscribe(new Action0() {
//		
//		@Override
//		public void call() {
//			
//		}
//	}).lift(new Observable.Operator<Integer, String>() {
//
//          @Override
//          public Subscriber<? super String> call(final Subscriber<? super Integer> subscriber) {
//              return new Subscriber<String>() {
//                  @Override
//                  public void onCompleted() {
//                	  NetLog.i("Z-MainActivity", "onCompleted: ");
//                      subscriber.onCompleted();
//                  }
//
//                  @Override
//                  public void onError(Throwable e) {
//                	  NetLog.e("Z-MainActivity", "onError: " + e.getMessage());
//                      subscriber.onError(e);
//                  }
//
//                  @Override
//                  public void onNext(String s) {
//                	  NetLog.i("Z-MainActivity", "onNext: s:" + s);
//                      int value = Integer.valueOf(s) * 2; //转化为Integer类型的值并乘以2
//                      subscriber.onNext(value);
//                  }
//              };
//          }
//      }).subscribe(new Subscriber<Integer>() {
//          @Override
//          public void onNext(Integer integer) {
//              NetLog.i("Z-MainActivity", "onNext: END:" + integer);
//          }
//
//		@Override
//		public void onCompleted() {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onError(Throwable paramThrowable) {
//			// TODO Auto-generated method stub
//			
//		}
//      });
//      
  
	// postFrom();
//	 try {
//		postFileTest();
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	 
	 postGson();
    }
    
    
    
    public void postGson(){
     	VpRequestParams params = new VpRequestParams();
        params.put("name", "tanpxxx====post");
        params.put("age", "谭平sssssdf");
        params.put("sex", 1);
        params.put("中文key", "中文value");
        params.putJsonParams("{\"a\":100}");
        VPNetWork.getDemoIn().postFromGson(VPNetWork.createRequestBody(params)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<CustomBean>() {

			@Override
			public void onCompleted() {
	    		NetLog.d(tag, "onStart: " + Thread.currentThread().getName());

			}

			@Override
			public void onError(Throwable arg0) {
				arg0.printStackTrace();
				NetLog.d(tag, arg0 +"");
			}

			@Override
			public void onNext(CustomBean arg0) {
				NetLog.d(tag, arg0 +"" + arg0.url +" " + arg0.form.name +" " + arg0.form.age);
				NetLog.d(tag, arg0.mujson.toString());
			}
		}); 
        
      //  VPNetWork.getDemoIn().postFrom(VPNetWork.createRequestBody(params)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(resultObserver); 
	
    }
    
    public void postFrom(){
    	
    	VpRequestParams params = new VpRequestParams();
        params.put("name", "tanp post");
        params.put("age", "谭平sssssdf");
        params.put("sex", 1);
        params.put("中文key", "中文value");
        params.putJsonParams("{\"a\":100}");
        VPNetWork.getDemoIn().postFrom(VPNetWork.createRequestBody(params)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(resultObserver); 
    }
    
    
    public  void postFileTest() throws IOException{
    	String path ="/sdcard/loveu/s3.jpg";
    	path ="/sdcard/loveu/text3.txt";
    	
    	File file = new File(path);
    	file.createNewFile();
    	FileOutputStream fop = new FileOutputStream(file);
    	String content = "13334";
		// get the content in bytes
		byte[] contentInBytes = content.getBytes();

		fop.write(contentInBytes);
		fop.flush();
		fop.close();

    	
    	VpRequestParams params = new VpRequestParams();
        params.put("name", "tanp post");
        params.put("age", "谭平sssssdf");
        params.put("sex", 1);
        params.put("中文key", "中文value");
       // params.putJsonParams("{}");
		//params.put("file1", file);
		params.put("f1", file,"image/*","custom-name.txt");
		
		VPNetWork.getDemoIn().uploadFile(VPNetWork.createFileRequestBody(params)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(resultObserver);
    	
    }
    
    
    
    Observer<String> resultObserver = new Subscriber<String>() {
    	@Override
    	public void onStart() {
    		super.onStart();
    		NetLog.d(tag, "onStart: " + Thread.currentThread().getName());
    	}
    	
		@Override
		public void onCompleted() {
    		NetLog.d(tag, "onCompleted: " + Thread.currentThread().getName());

		}

		@Override
		public void onError(Throwable arg0) {
			// TODO Auto-generated method stub
			arg0.printStackTrace();
			NetLog.d(tag, arg0 +"");
		}

		@Override
		public void onNext(String arg0) {
			NetLog.d(tag, "onNext: " + Thread.currentThread().getName());
			NetLog.d(tag, arg0 +"");
		}
	};
 
}
