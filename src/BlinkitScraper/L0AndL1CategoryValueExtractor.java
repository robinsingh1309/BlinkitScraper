package BlinkitScraper;

import java.util.ArrayList;
import java.util.List;

public class L0AndL1CategoryValueExtractor {

	public static List<String> getQueryParams(String url) {
		    
		List<String> params = new ArrayList<>();
		
		String[] urlParts = url.split("\\?");
		
		if (urlParts.length > 1) {
		    
			String query = urlParts[1];
		    
			for (String param : query.split("&")) {
		        
				String[] pair = param.split("=");
		        String key = pair[0];
		        String value = "";
		        
		        if (pair.length > 1) {
		            value = pair[1];
		        }
		        
		        // in this way my list will now store only l0_cat & l1_cat ONLY
		        params.add(key);
		        params.add(value);
		        
		    }
		}

		return params;
		}

}
