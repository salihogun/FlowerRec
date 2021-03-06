package com.example.flowerrec;


import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.util.Base64;
import android.util.Log;


public class FlowerUtils {

	public String [] Plants = new String[]{"Daffodil","Snowdrop","Lily Valley","Bluebell","Crocus","Iris","Tiger Lilly","Tulip","Fritillary","Sunflower","Daisy","Dandelion","Cowslip","Buttercup","Windflower","Pansy","Collsfoot","Ende"};

	public static Hashtable<String, String> plantNameID = new Hashtable<String, String>();
	public static HashMap<String, String> pDes=new HashMap<String, String>();
	public static int retNumIm = 17;
	public static Model []values;

	public static FlowerRecImageContainer i1;

	private Activity activity;
	
	String TAG = "TEST";

	FlowerUtils(){
		//initPlantTable();
	}

	FlowerUtils(Activity activity){
		this.activity = activity;
		if(i1 == null){
		i1 = new FlowerRecImageContainer();
		}
		initPlantTable();
	}

	public static String encodeTobase64(Bitmap image)
	{
		Bitmap immagex=image;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();  
		immagex.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		byte[] b = baos.toByteArray();
		String imageEncoded = Base64.encodeToString(b,Base64.DEFAULT);

		Log.e("LOOK", imageEncoded);
		return imageEncoded;
	}

	public static Bitmap decodeBase64(String input) 
	{
		byte[] decodedByte = Base64.decode(input, 0);
		return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length); 
	}

	public static String getWithinTags(String matchString,String tag){

		final Pattern pattern = Pattern.compile("<"+tag+">(.+?)</"+tag+">");
		final Matcher matcher = pattern.matcher(matchString);
		try{
			matcher.find();
			return matcher.group(1);
		}
		catch(Exception e){
			
			return "An exception has occured within tags: "+e.toString();
		}
	}

	public String setWithinTags(String message,String tag){
		return "<"+tag+">"+message+"</"+tag+">";
	}

	public String defAttr(String attr){
		return "<BeesmartFile attr="+"\"" +attr +"\"" +">";
	}

	public void initPlantTable(){
		
		for(int i=0;i<retNumIm;i++){
			plantNameID.put(""+i,Plants[i]);
		}
		
		plantNameID.put("-1",Plants[retNumIm]);
		pDes.put(Plants[0], activity.getString(R.string.daffodil_des));
		pDes.put(Plants[1], activity.getString(R.string.snowdrop_des));
		pDes.put(Plants[2], activity.getString(R.string.lily_des));
		pDes.put(Plants[3], activity.getString(R.string.bluebell_des));
		
		pDes.put(Plants[4], activity.getString(R.string.crocus_des));
		pDes.put(Plants[5], activity.getString(R.string.iris_des));
		pDes.put(Plants[6], activity.getString(R.string.tiger_des));
		pDes.put(Plants[7], activity.getString(R.string.tulip_des));
		
		pDes.put(Plants[8], activity.getString(R.string.fritillary_des));
		pDes.put(Plants[9], activity.getString(R.string.sunflower_des));
		pDes.put(Plants[10], activity.getString(R.string.daisy_des));
		pDes.put(Plants[11], activity.getString(R.string.dandelion_des));
		
		pDes.put(Plants[12], activity.getString(R.string.cowslip_des));
		pDes.put(Plants[13], activity.getString(R.string.buttercup_des));
		pDes.put(Plants[14], activity.getString(R.string.windflower_des));
		pDes.put(Plants[15], activity.getString(R.string.pansy_des));
		
		pDes.put(Plants[16], activity.getString(R.string.collsfoot_des));	

	}
}