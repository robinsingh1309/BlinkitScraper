package BlinkitScraper;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class BlinkitCategoryUrlGeneratorFactory {
	
	public static List<String> generateDeeplinkUri(String jsonResponse)
	{
		
	    List<String> categoriesProductUrl = new ArrayList<>();
        
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray objectsJsonArray = jsonObject.getJSONArray("objects");

        for (int j = 0; j < objectsJsonArray.length(); j++) {
        	
            JSONObject currentObject = objectsJsonArray.getJSONObject(j);

            // Case 1: "data" contains "items"
            if (currentObject.has("data")) {
            	
                JSONObject dataJsonObject = currentObject.getJSONObject("data");
                
                if (dataJsonObject.has("items")) {
                	
                    JSONArray itemsJsonArray = dataJsonObject.getJSONArray("items");
                    
                    for (int i = 0; i < itemsJsonArray.length(); i++) {
                    	
                        JSONObject currentJsonObject = itemsJsonArray.getJSONObject(i);
                        
                        if (currentJsonObject.has("deeplink")) {
                        	
                        	String deeplink = currentJsonObject.getString("deeplink");
                            categoriesProductUrl.add(deeplink);
                        
                        }
                    }
                }
            }
            
        }
		
		return categoriesProductUrl;
	}

}
