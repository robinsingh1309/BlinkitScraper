package BlinkitScraper;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;


public class BlinkitWebScraping {

	public String getTemplateJSONDataForUCategoryURL(String blinkitUrl) throws IOException {
		
		String payLoadBody = "{\"template_version\":9}";

		Response response = Jsoup.connect(blinkitUrl)
		        .header("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36")
		        .header("accept", "application/json, text/plain, */*")
		        .header("accept-encoding", "identity")
		        .header("referer", "https://blinkit.com/")
		        .header("access_token", null)
		        .header("app_client", "consumer_web")
		        .header("app_version", "52434332")
		        .header("accept-language", "en-GB,en-US;q=0.9,en;q=0.8,hi;q=0.7")
		        .header("auth_key", "c761ec3633c22afad934fb17a66385c1c06c5472b4898b866b7306186d0bb477")
		        .header("content-type", "application/json")
		        .header("cookie", "gr_1_deviceId=b4181f98-82fa-462d-9842-2b7f53faca2f; gr_1_locality=1849; _gcl_au=1.1.1930654523.1757061830; _fbp=fb.1.1757061830577.73306942684545675; gr_1_lat=28.465204; gr_1_lon=77.06159; gr_1_landmark=undefined; city=Chennai; _gid=GA1.2.770892309.1757305308; __cf_bm=kbSEieHGx8CgHow.Qpoy4isK75Bm7Vnpe78.rfbua80-1757390550-1.0.1.1-Wo21ApKpg9yuPIrWyB8UHPbVwx1oES._dyaBdfVaTIdK6Qk0FNgjnCedHXjEuhFj72pfHCDKmN3zsbW_IWFQROrttxC67UvLttiIqnxBdOA; __cfruid=0bed5eb6b3a63f7d7b5fe57b42196a476a1494fb-1757390550; _cfuvid=UYtkzli8MSokGoV3Dlmq6nCsYORR0y8soVLcyboKUts-1757390550628-0.0.1.1-604800000; _gat_UA-85989319-1=1; _ga=GA1.1.517309689.1757061830; _ga_DDJ0134H6Z=GS2.2.s1757390553$o5$g0$t1757390553$j60$l0$h0; _ga_JSMJG966C7=GS2.1.s1757390552$o5$g0$t1757390561$j51$l0$h0")
		        .header("lat", "28.465204")
		        .header("lon", "77.06159")
		        .header("Device_id", "b4181f98-82fa-462d-9842-2b7f53faca2f")
		        .header("platform", "desktop_web")
		        .data("payload", payLoadBody)      
		        .timeout(15000)
		        .method(Connection.Method.GET)
		        .ignoreContentType(true)
		        .execute();

		return response.body();

		
	}
	
	public String getJSONData(String blinkitUrl) throws IOException 
	{
//		String payLoadBody = "{\"applied_filters\":null,\"is_sr_rail_visible\":false,\"is_subsequent_page\":false,\"postback_meta\":{\"primary_results_group_ids\":[778210,642275,2231588,784426,784428,784432,554064,784434,1913779,1921941,1287446,777847,647641,717214,1005951],\"primary_results_product_ids\":[373664,129,697856,406721,406724,19397,299078,128,368777,138,612119,279951,476529,496306,437239,95769,466203]},\"processed_product_ids\":null,\"processed_rails\":{\"aspirational_card_rail\":{\"total_count\":0,\"processed_count\":5,\"processed_product_ids\":[]},\"attribute_rail\":{\"total_count\":0,\"processed_count\":4,\"processed_product_ids\":[]},\"brand_rail\":{\"total_count\":0,\"processed_count\":1,\"processed_product_ids\":[]},\"dc_rail\":{\"total_count\":0,\"processed_count\":1,\"processed_product_ids\":[]},\"priority_dc_rail\":{\"total_count\":0,\"processed_count\":1,\"processed_product_ids\":[]}},\"product_ids\":null,\"shown_product_count\":15,\"sort\":\"\"}";

		Response response = Jsoup.connect(blinkitUrl)
		        .header("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36")
		        .header("accept", "application/json, text/plain, */*")
		        .header("accept-encoding", "identity")
		        .header("referer", "https://blinkit.com/")
		        .header("access_token", null)
		        .header("app_client", "consumer_web")
		        .header("app_version", "52434332")
		        .header("accept-language", "en-GB,en-US;q=0.9,en;q=0.8,hi;q=0.7")
		        .header("auth_key", "c761ec3633c22afad934fb17a66385c1c06c5472b4898b866b7306186d0bb477")
		        .header("content-type", "application/json")
		        .header("cookie", "gr_1_deviceId=b4181f98-82fa-462d-9842-2b7f53faca2f; gr_1_locality=1849; _gcl_au=1.1.1930654523.1757061830; _fbp=fb.1.1757061830577.73306942684545675; gr_1_lat=28.465204; gr_1_lon=77.06159; gr_1_landmark=undefined; city=Chennai; _gid=GA1.2.770892309.1757305308; __cf_bm=kbSEieHGx8CgHow.Qpoy4isK75Bm7Vnpe78.rfbua80-1757390550-1.0.1.1-Wo21ApKpg9yuPIrWyB8UHPbVwx1oES._dyaBdfVaTIdK6Qk0FNgjnCedHXjEuhFj72pfHCDKmN3zsbW_IWFQROrttxC67UvLttiIqnxBdOA; __cfruid=0bed5eb6b3a63f7d7b5fe57b42196a476a1494fb-1757390550; _cfuvid=UYtkzli8MSokGoV3Dlmq6nCsYORR0y8soVLcyboKUts-1757390550628-0.0.1.1-604800000; _gat_UA-85989319-1=1; _ga=GA1.1.517309689.1757061830; _ga_DDJ0134H6Z=GS2.2.s1757390553$o5$g0$t1757390553$j60$l0$h0; _ga_JSMJG966C7=GS2.1.s1757390552$o5$g0$t1757390561$j51$l0$h0")
		        .header("lat", "28.465204")
		        .header("lon", "77.06159")
		        .header("Device_id", "b4181f98-82fa-462d-9842-2b7f53faca2f")
		        .header("platform", "desktop_web")
//		        .data("payload", payLoadBody)
		        .timeout(15000)
		        .method(Connection.Method.POST)
				.ignoreContentType(true)
				.execute();

		return response.body();
	}

}
