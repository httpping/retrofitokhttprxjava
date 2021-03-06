package com.tp.net;
 

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Converter;
import retrofit2.Retrofit;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public final class GsonConverterFactory extends Converter.Factory {
  /**
   * Create an instance using a default {@link Gson} instance for conversion. Encoding to JSON and
   * decoding from JSON (when no charset is specified by a header) will use UTF-8.
   */
  public static GsonConverterFactory create() {
    return create(new Gson());
  }

  /**
   * Create an instance using {@code gson} for conversion. Encoding to JSON and
   * decoding from JSON (when no charset is specified by a header) will use UTF-8.
   */
  public static GsonConverterFactory create(Gson gson) {
    return new GsonConverterFactory(gson);
  }

  private final Gson gson;

  private GsonConverterFactory(Gson gson) {
    if (gson == null) throw new NullPointerException("gson == null");
    this.gson = gson;
  }

  @Override
  public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
      Retrofit retrofit) {
    TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
    return new GsonResponseBodyConverter<>(gson, adapter);
  }

  @Override
  public Converter<?, RequestBody> requestBodyConverter(Type type,
      Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
    TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
    return new GsonRequestBodyConverter<>(gson, adapter);
  }
  
  
  final static class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
	  private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
	  private static final Charset UTF_8 = Charset.forName("UTF-8");

	  private final Gson gson;
	  private final TypeAdapter<T> adapter;

	  GsonRequestBodyConverter(Gson gson, TypeAdapter<T> adapter) {
	    this.gson = gson;
	    this.adapter = adapter;
	  }

	  @Override public RequestBody convert(T value) throws IOException {
	    Buffer buffer = new Buffer();
	    Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
	    JsonWriter jsonWriter = new JsonWriter(writer);// gson.newJsonWriter(writer);
	    adapter.write(jsonWriter, value);
	    jsonWriter.close();
	    return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
	  }
	}

  final static class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
	  private final Gson gson;
	  private final TypeAdapter<T> adapter;

	  GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
	    this.gson = gson;
	    this.adapter = adapter;
	  }

	  @Override public T convert(ResponseBody value) throws IOException {
	    JsonReader jsonReader = new JsonReader(value.charStream());//  gson.newJsonReader(value.string());
	    try {
	      return adapter.read(jsonReader);
	    } finally {
	      value.close();
	    }
	  }
	}

}
