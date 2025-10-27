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
			
			
	        if (!jsonDataObject.has("image")) continue;  // extracting the image URL
	        String productImage = jsonDataObject.getJSONObject("image").optString("url", "N/A");    // if url not present fill it with value as "N/A"

	        
			if (!jsonDataObject.has("name")) continue;  // basically means if the JSON Object with 'name' is present or not in the 'data' JSON Object
			String productName = jsonDataObject.getJSONObject("name").optString("text", "");    // if not present we can fill the value as empty string("")
			

			String productOriginalMrpPrice = "";
			if (jsonDataObject.has("mrp")) 	// basically means if the JSON Object with 'mrp' is present or not in the 'data' JSON Object
				productOriginalMrpPrice = jsonDataObject.getJSONObject("mrp").optString("text", "N/A");
			
			
			String productNormalMrpPrice = "";
			if (jsonDataObject.has("normal_price"))		// basically means if the JSON Object with 'normal_price' is present or not in the 'data' JSON Object
				productNormalMrpPrice = jsonDataObject.getJSONObject("normal_price").optString("text", "N/A");
			
			
	        String productBrand = "";
	        if (jsonDataObject.has("brand_name"))     // basically means if the JSON Object with 'brand_name' is present or not in the 'data' JSON Object
	            productBrand = jsonDataObject.getJSONObject("brand_name").optString("text", "N/A");
			
			
			String productCategory = "";
			if (jsonIterateObject.has("tracking")) 		// basically means if the JSON Object with 'tracking' is present or not in the 'response' JSON Object
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
