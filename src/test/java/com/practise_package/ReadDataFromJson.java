package com.practise_package;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJson {
	public static void main(String[] args) throws Throwable, ParseException {
		FileReader filepth=new FileReader(".\\src\\test\\resources\\jasonRead.json");
		JSONParser jsonp = new JSONParser();//JSONPARSER SHOUL BE FROM JSON SIMPLE
		Object obj = jsonp.parse(filepth);
		JSONObject map = (JSONObject)obj;
	
		System.out.println( map.get("browser"));
		System.out.println(map.get("url"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		
	}

}
