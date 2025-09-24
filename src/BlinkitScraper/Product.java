package BlinkitScraper;

public class Product {
	
	private final String product_name;
	private final String product_category;
	private final String product_original_mrp;
	private final String product_normal_mrp;
	
	public Product(String product_name, String product_category, String product_original_mrp, String product_normal_mrp) {
		this.product_name = product_name;
		this.product_category = product_category;
		this.product_original_mrp = product_original_mrp;
		this.product_normal_mrp = product_normal_mrp;
	}

	public String getProduct_name() {
		return product_name;
	}
	
	public String getProduct_category() {
		return product_category;
	}
	
	public String getProduct_original_mrp() {
		return product_original_mrp;
	}
	
	public String getProduct_normal_mrp() {
		return product_normal_mrp;
	}

}
