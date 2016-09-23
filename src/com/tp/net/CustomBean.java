package com.tp.net;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;


public class CustomBean  extends VpBaseBean{

	public String url;
	public String origin;
	
	@SerializedName("json")
	public JsonObject mujson;
    //public FormBean form;

	
}
