package BlinkitScraper;

import java.util.List;

public class Pair {

	private List<Product> data;
	private String nxtURL;
	
	public Pair(List<Product> data, String nxtURL) {
		
		this.data = data;
		this.nxtURL = nxtURL;
	}

	public List<Product> getData() {
		return data;
	}

	public String getNxtURL() {
		return nxtURL;
	}
	
}
