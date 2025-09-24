package BlinkitScraper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BlinkitPagination {

	private BlinkitWebScraping blinkitScraper;
//	private String urlToScrape = BlinkitScraperUrl.BLINKIT_URL.getValue();
	
	private String urlToScrapeFromEveryPage = BlinkitScraperUrl.BLINKIT_CATEGORY_URL.getValue();
	
	public BlinkitPagination() { blinkitScraper = new BlinkitWebScraping();}
	
	
	public List<List<Product>> getInfoFromEveryPageUrl() throws IOException {
		
	    List<String> categoriesProductUrl = new ArrayList<>();

        String jsonCategoryResponse = blinkitScraper.getTemplateJSONDataForUCategoryURL(urlToScrapeFromEveryPage);
        
        // separated the class to extract the deeplinks of different categories
        categoriesProductUrl = BlinkitCategoryUrlGeneratorFactory.generateDeeplinkUri(jsonCategoryResponse);
	    // System.out.println(categoriesProductUrl.toString());
        
        
        /**
         * Extracting the l0_cat and l1_cat values
         */
        List<List<String>> finalExtractedCategoryL0AndL1Value = new ArrayList<List<String>>();
        
        for(String url : categoriesProductUrl)
        {
        	// given the task to other class to give me the result
        	List<String> res = L0AndL1CategoryValueExtractor.getQueryParams(url);
        	
        	finalExtractedCategoryL0AndL1Value.add(res);
        }
        // Testing the values are giving or not
        // System.out.println(finalExtractedCategoryL0AndL1Value.toString());
        
        
        /**
         * Now this will be responsible for generating all the data from the different categories
         * and also it will follow the pagination process too to traverse to the next page
         * 
         * I made sure the request is not sent continuously, otherwise it will throw the HTTP status=429. And so to tackle that
         * introduced sleep() of around 2-5 seconds at every request and 1-3 seconds for every pagination
         */
        List<List<Product>> productResult = new ArrayList<>();
        
        for(List<String> valuesOfL0AndL1 : finalExtractedCategoryL0AndL1Value) 
        {
        	
        	String l0_value = valuesOfL0AndL1.get(1);    // extracting l0_cat value present in the valuesOfL0AndL1 list
        	String l1_value = valuesOfL0AndL1.get(3);    // extracting l1_cat value present in the valuesOfL0AndL1 list
        	
        	/**
        	 * Used the concept of String.format where i don't need to traverse the url fully 
        	 * just introduce the new value and that's it 
        	 * new url will be generated
        	 */
        	String urlToBeScrapped = String.format(BlinkitScraperUrl.BLINKIT_PRODUCT_URL.getValue(), l0_value, l1_value);
        	// to test whether the values are replaced or not
        	//System.out.println(urlToBeScrapped);
        	
        	
        	/**
        	 * The below method is for pagination logic
        	 */
			while (urlToBeScrapped != null && !urlToBeScrapped.isEmpty()) {
	
				String jsonResponseBody = blinkitScraper.getJSONData(urlToBeScrapped);
				
				Pair productItemsPageResult = ExtractData.getDataFromJSON(jsonResponseBody);
	
				productResult.add(productItemsPageResult.getData());
	
				urlToBeScrapped = productItemsPageResult.getNxtURL();
				
				try {
		            Thread.sleep(1000 + (long)(Math.random() * 2000));
		        } catch (InterruptedException e) {
		            Thread.currentThread().interrupt();
		        }
	
				// Breaking if there is no next page or the url is empty
				if (urlToBeScrapped == null || urlToBeScrapped.isEmpty()) {
					break;
				}
				
			}
			
			// Add random delay (2–5 seconds) before moving to next category
		    try {
		        Thread.sleep(2000 + (long)(Math.random() * 2000));
		    } catch (InterruptedException e) {
		        Thread.currentThread().interrupt();
		    }
	
        }
        
        return productResult;
        
	}
	
}
