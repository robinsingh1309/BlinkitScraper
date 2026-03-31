package BlinkitScraper;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ExtractData {

	public static Pair getDataFromJSON(String responseBody)
	{
		String nextURLToPaginate = "";
		
		List<Product> productLists = new ArrayList<>();

		JSONObject jsonResponse = new JSONObject(responseBody);

		JSONObject responseObject = jsonResponse.getJSONObject("response");

        JSONArray snippetsJsonArray;
        
        if (responseObject.has("snippets")) 
        {
            Object snippetsObj = responseObject.get("snippets");
            
            if (snippetsObj instanceof JSONArray) 
            {
                snippetsJsonArray = (JSONArray) snippetsObj;
            
            } else if (snippetsObj instanceof JSONObject) 
            {
                snippetsJsonArray = new JSONArray();
                snippetsJsonArray.put((JSONObject) snippetsObj);
            
            } else 
            {
                snippetsJsonArray = new JSONArray(); // fallback empty
            }
        } 
        else 
        {
            snippetsJsonArray = new JSONArray(); // missing snippets
        }

		for (int i = 0; i < snippetsJsonArray.length(); i++) 
		{

			JSONObject jsonIterateObject = snippetsJsonArray.getJSONObject(i);
			
			if (!jsonIterateObject.has("data")) continue; 		// basically means if the JSON Object with 'data' is present or not
			JSONObject jsonDataObject = jsonIterateObject.getJSONObject("data");
			
			
	        if (!jsonDataObject.has("image")) continue;
	        String productImage = jsonDataObject.getJSONObject("image").optString("url", "");

	        
			if (!jsonDataObject.has("name")) continue;  
			String productName = jsonDataObject.getJSONObject("name").optString("text", "");
			

			String productOriginalMrpPrice = "";
			if (jsonDataObject.has("mrp"))
				productOriginalMrpPrice = jsonDataObject.getJSONObject("mrp").optString("text", "");
			
			
			String productNormalMrpPrice = "";
			if (jsonDataObject.has("normal_price"))
				productNormalMrpPrice = jsonDataObject.getJSONObject("normal_price").optString("text", "");
			
			
	        String productBrand = "";
	        if (jsonDataObject.has("brand_name"))
	            productBrand = jsonDataObject.getJSONObject("brand_name").optString("text", "");
			
			
			String productCategory = "";
			if (jsonIterateObject.has("tracking"))
			{
				JSONObject jsonTrackingObject = jsonIterateObject.getJSONObject("tracking");
				
				if (jsonTrackingObject.has("common_attributes")) {
					productCategory = jsonTrackingObject.getJSONObject("common_attributes").optString("l2_category", "");
				}
			}

			productLists.add(new Product(productName, productCategory, productOriginalMrpPrice, productNormalMrpPrice, productImage, productBrand));
			
		}
		
		JSONObject paginationObject = responseObject.optJSONObject("pagination");

		if (paginationObject != null) {
		    nextURLToPaginate = paginationObject.optString("next_url", null);

		    if (nextURLToPaginate != null && !nextURLToPaginate.isBlank()) {
		        nextURLToPaginate = "https://blinkit.com" + nextURLToPaginate;
		    }
		} else {
		    nextURLToPaginate = null; // no more pages
		}
		
		return new Pair(productLists, nextURLToPaginate);
	}
}
