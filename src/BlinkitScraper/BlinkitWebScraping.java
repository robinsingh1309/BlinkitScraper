package BlinkitScraper;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;


public class BlinkitWebScraping {

	public String getTemplateJSONDataForUCategoryURL(String blinkitUrl) throws IOException {
		
		Response response = Jsoup.connect(blinkitUrl)
		        .header("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/141.0.0.0 Safari/537.36")
		        .header("accept", "application/json, text/plain, */*")
		        .header("accept-encoding", "identity")
		        .header("referer", "https://blinkit.com/")
		        .header("app_client", "consumer_web")
		        .header("app_version", "52434332")
		        .header("accept-language", "en-US,en;q=0.9")
		        .header("auth_key", "c761ec3633c22afad934fb17a66385c1c06c5472b4898b866b7306186d0bb477")
		        .header("content-type", "application/json")
		        .header("cookie", "gr_1_deviceId=b81c121e-8af2-47f4-a5c6-791d90769165; _gcl_au=1.1.2085071079.1761196390; _fbp=fb.1.1761196390117.42851817848102344; gr_1_lat=12.986279; gr_1_lon=80.2432487; gr_1_locality=Chennai; gr_1_landmark=undefined; _gcl_aw=GCL.1761543386.CjwKCAjwjffHBhBuEiwAKMb8pFnUxTLb771yA-_56ktocQGrzN4rbhs0X_eVPV8WQqeFYms_Wd7_qBoCMGcQAvD_BwE; _gcl_gs=2.1.k1$i1761543384$u260607710; _gac_UA-85989319-1=1.1761543386.CjwKCAjwjffHBhBuEiwAKMb8pFnUxTLb771yA-_56ktocQGrzN4rbhs0X_eVPV8WQqeFYms_Wd7_qBoCMGcQAvD_BwE; city=Chennai; __cf_bm=57TkMfHV0xBi1hrkJgB0QwVgFgkWJ7U9q2jtULrmQ2s-1761732612-1.0.1.1-7eEkfu.XCWGhRMLYKxxPTbTIEfhrXOI4G5oh9Mv5MVtwhyPLTP.A_uhlKkir54YuVsDiTVMn37m8f9qRyo2z7H6mh_07ruqJlvFTRpcKYVw; __cfruid=723cb4f4b6a428d41ed1f0c81670ef079fe08c6b-1761732612; _cfuvid=XyCR2WC_WDS_y9FcUvTn_PK_Q9FtE7rUNtOr8jfJeEw-1761732612361-0.0.1.1-604800000; _gid=GA1.2.47255975.1761732614; _gat_UA-85989319-1=1; _ga=GA1.2.2068992834.1761196390; _ga_DDJ0134H6Z=GS2.2.s1761732614$o4$g1$t1761732658$j16$l0$h0; _ga_JSMJG966C7=GS2.1.s1761732614$o4$g1$t1761732658$j16$l0$h0")
		        .header("lat", "12.986279")
		        .header("lon", "80.2432487")
		        .header("Device_id", "349c24baad0a5598")
		        .header("platform", "desktop_web")    
		        .timeout(120000)
		        .method(Connection.Method.GET)
		        .ignoreContentType(true)
		        .execute();

		return response.body();

		
	}
	
	public String getJSONData(String blinkitUrl) throws IOException 
	{
	    
		Response response = Jsoup.connect(blinkitUrl)
		        .header("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/140.0.0.0 Safari/537.36")
		        .header("accept", "application/json, text/plain, */*")
		        .header("accept-encoding", "identity")
		        .header("referer", "https://blinkit.com/")
		        .header("app_client", "consumer_web")
		        .header("app_version", "1010101010")
		        .header("accept-language", "en-US,en;q=0.9")
		        .header("auth_key", "c761ec3633c22afad934fb17a66385c1c06c5472b4898b866b7306186d0bb477")
		        .header("content-type", "application/json")
                .header("cookie", "gr_1_deviceId=b81c121e-8af2-47f4-a5c6-791d90769165; _gcl_au=1.1.2085071079.1761196390; _fbp=fb.1.1761196390117.42851817848102344; gr_1_lat=12.986279; gr_1_lon=80.2432487; gr_1_locality=Chennai; gr_1_landmark=undefined; _gcl_aw=GCL.1761543386.CjwKCAjwjffHBhBuEiwAKMb8pFnUxTLb771yA-_56ktocQGrzN4rbhs0X_eVPV8WQqeFYms_Wd7_qBoCMGcQAvD_BwE; _gcl_gs=2.1.k1$i1761543384$u260607710; _gac_UA-85989319-1=1.1761543386.CjwKCAjwjffHBhBuEiwAKMb8pFnUxTLb771yA-_56ktocQGrzN4rbhs0X_eVPV8WQqeFYms_Wd7_qBoCMGcQAvD_BwE; city=Chennai; __cf_bm=57TkMfHV0xBi1hrkJgB0QwVgFgkWJ7U9q2jtULrmQ2s-1761732612-1.0.1.1-7eEkfu.XCWGhRMLYKxxPTbTIEfhrXOI4G5oh9Mv5MVtwhyPLTP.A_uhlKkir54YuVsDiTVMn37m8f9qRyo2z7H6mh_07ruqJlvFTRpcKYVw; __cfruid=723cb4f4b6a428d41ed1f0c81670ef079fe08c6b-1761732612; _cfuvid=XyCR2WC_WDS_y9FcUvTn_PK_Q9FtE7rUNtOr8jfJeEw-1761732612361-0.0.1.1-604800000; _gid=GA1.2.47255975.1761732614; _gat_UA-85989319-1=1; _ga=GA1.2.2068992834.1761196390; _ga_DDJ0134H6Z=GS2.2.s1761732614$o4$g1$t1761732658$j16$l0$h0; _ga_JSMJG966C7=GS2.1.s1761732614$o4$g1$t1761732658$j16$l0$h0")
                .header("lat", "12.986279")
                .header("lon", "80.2432487")
                .header("Device_id", "349c24baad0a5598")
		        .header("platform", "desktop_web")
		        .timeout(120000)
		        .method(Connection.Method.POST)
				.ignoreContentType(true)
				.execute();

		return response.body();
	}

}
