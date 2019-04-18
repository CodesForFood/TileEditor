package main.java;

import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import main.java.models.Tile;

public class JsonIO {
	
	public static Object[] mainArr;
		
	public static void initJsonIO() {
		JSONArray jArr = new JSONArray();		
		String basePath = Constants.resPath + "Base.json";
		
		File file = new File(basePath);			
		try {
			Object parse = new JSONParser().parse(new FileReader(file));
			
			jArr = (JSONArray)parse;			
			mainArr = jArr.toArray();
			Window.getComps().mainLB.setListData(getTop50FromBase());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}												
	}	
	
	public static JSONObject[] getTop50FromBase() {			
		JSONObject[] out = new JSONObject[50];  		
		for(int x = 0; x < 50; x++) {
			
			JSONObject obj = (JSONObject)mainArr[x];
			out[x] = obj;
		} 
		
		return out;		
	}		
	
	public static JSONObject[] get50ById(int id) {
		JSONObject[] out =  new JSONObject[50];
				
		int i = 0;
		for(int cap = id + 50; id < mainArr.length && id < cap; id++ ) {
			JSONObject obj = (JSONObject)mainArr[id];	
			out[i] = obj;
			i++;
		}		
		return out;
	}
	
	
	
	
	//Main Json Already seeded
	@Deprecated
	public static void seedBase() throws IOException {									
		JSONArray jArr =  new JSONArray();				
		for(int x = 0; x < 400; x++) {
			JSONObject obj = new JSONObject();			
			obj.put("Id", new Integer(x));
			obj.put("Name", "Blank");
			obj.put("Category", "Base");			
			jArr.add(obj);										
		}		
		String fullFile = Constants.resPath + "Base.json";
		File file = new File(fullFile);		
		if(file.createNewFile()) {
			Window.getComps().say("Created Base file");
			Writer write = new FileWriter(file);			
			write.write(jArr.toString());	
			write.close();			
		}
		else {
			Window.getComps().say("Could not create the file");
		}						
		
	}
	

}
