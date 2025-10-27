package BlinkitScraper;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;


public class BlinkitWebScraping {

	public String getTemplateJSONDataForUCategoryURL(String blinkitUrl) throws IOException {
		
//		String payLoadBody = "{\"template_version\":9}";

		Response response = Jsoup.connect(blinkitUrl)
		        .header("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/141.0.0.0 Safari/537.36")
		        .header("accept", "application/json, text/plain, */*")
		        .header("accept-encoding", "identity")
		        .header("referer", "https://blinkit.com/")
//		        .header("access_token", null)
		        .header("app_client", "consumer_web")
		        .header("app_version", "52434332")
		        .header("accept-language", "en-US,en;q=0.9")
		        .header("auth_key", "c761ec3633c22afad934fb17a66385c1c06c5472b4898b866b7306186d0bb477")
		        .header("content-type", "application/json")
		        .header("cookie", "gr_1_deviceId=b81c121e-8af2-47f4-a5c6-791d90769165; _gcl_au=1.1.2085071079.1761196390; _fbp=fb.1.1761196390117.42851817848102344; gr_1_lat=12.986279; gr_1_lon=80.2432487; gr_1_locality=Chennai; __cfruid=0a3c8c6be7b26866dfbb0695214b359a41daa815-1761543377; _cfuvid=JS_Ycmctb2JF.4.86erCc1UulV_AO.YqyiE9GVrnYGo-1761543377159-0.0.1.1-604800000; gr_1_landmark=undefined; _gcl_aw=GCL.1761543386.CjwKCAjwjffHBhBuEiwAKMb8pFnUxTLb771yA-_56ktocQGrzN4rbhs0X_eVPV8WQqeFYms_Wd7_qBoCMGcQAvD_BwE; _gcl_gs=2.1.k1$i1761543384$u260607710; _gid=GA1.2.1562251806.1761543386; _gac_UA-85989319-1=1.1761543386.CjwKCAjwjffHBhBuEiwAKMb8pFnUxTLb771yA-_56ktocQGrzN4rbhs0X_eVPV8WQqeFYms_Wd7_qBoCMGcQAvD_BwE; city=Chennai; __cf_bm=dUQKMH_anPn_nrMBnG1WBEWARSLxxHujmnGykgnbZ1o-1761556097-1.0.1.1-22EdmV9hsvj3ATl9T8YOot4OVRzv3OqQtCEqpPlXhGPyWluxyE6sp6ecXWiGVBu2HQPJSNpiyM.x33RfzS_yq_242LOxFGDptldCDPxNh14; _gat_UA-85989319-1=1; _ga=GA1.1.2068992834.1761196390; _ga_DDJ0134H6Z=GS2.2.s1761556100$o3$g0$t1761556100$j60$l0$h0; _ga_JSMJG966C7=GS2.1.s1761556098$o3$g0$t1761556107$j51$l0$h0")
		        .header("lat", "12.986279")
		        .header("lon", "80.2432487")
		        .header("Device_id", "349c24baad0a5598")
		        .header("platform", "desktop_web")
//		        .data("payload", payLoadBody)      
		        .timeout(60000)
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
//		        .header("access_token", null)
		        .header("app_client", "consumer_web")
		        .header("app_version", "1010101010")
		        .header("accept-language", "en-US,en;q=0.9")
		        .header("auth_key", "c761ec3633c22afad934fb17a66385c1c06c5472b4898b866b7306186d0bb477")
		        .header("content-type", "application/json")
		        .header("cookie", "gr_1_deviceId=b81c121e-8af2-47f4-a5c6-791d90769165; _gcl_au=1.1.2085071079.1761196390; _fbp=fb.1.1761196390117.42851817848102344; gr_1_lat=12.986279; gr_1_lon=80.2432487; gr_1_locality=Chennai; __cfruid=0a3c8c6be7b26866dfbb0695214b359a41daa815-1761543377; _cfuvid=JS_Ycmctb2JF.4.86erCc1UulV_AO.YqyiE9GVrnYGo-1761543377159-0.0.1.1-604800000; gr_1_landmark=undefined; _gcl_aw=GCL.1761543386.CjwKCAjwjffHBhBuEiwAKMb8pFnUxTLb771yA-_56ktocQGrzN4rbhs0X_eVPV8WQqeFYms_Wd7_qBoCMGcQAvD_BwE; _gcl_gs=2.1.k1$i1761543384$u260607710; _gid=GA1.2.1562251806.1761543386; _gac_UA-85989319-1=1.1761543386.CjwKCAjwjffHBhBuEiwAKMb8pFnUxTLb771yA-_56ktocQGrzN4rbhs0X_eVPV8WQqeFYms_Wd7_qBoCMGcQAvD_BwE; city=Chennai; __cf_bm=dUQKMH_anPn_nrMBnG1WBEWARSLxxHujmnGykgnbZ1o-1761556097-1.0.1.1-22EdmV9hsvj3ATl9T8YOot4OVRzv3OqQtCEqpPlXhGPyWluxyE6sp6ecXWiGVBu2HQPJSNpiyM.x33RfzS_yq_242LOxFGDptldCDPxNh14; _gat_UA-85989319-1=1; _ga=GA1.1.2068992834.1761196390; _ga_DDJ0134H6Z=GS2.2.s1761556100$o3$g0$t1761556100$j60$l0$h0; _ga_JSMJG966C7=GS2.1.s1761556098$o3$g0$t1761556107$j51$l0$h0")
		        .header("lat", "12.986279")
		        .header("lon", "80.2432487")
		        .header("Device_id", "349c24baad0a5598")
		        .header("platform", "desktop_web")
//		        .data("payload", payLoadBody)
		        .timeout(60000)
		        .method(Connection.Method.POST)
				.ignoreContentType(true)
				.execute();

		return response.body();
	}

}
