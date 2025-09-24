package BlinkitScraper;

public enum BlinkitScraperUrl {

	BLINKIT_PRODUCT_URL("https://blinkit.com/v1/layout/listing_widgets?offset=15&limit=15&exclude_combos=false&l0_cat=%s&l1_cat=%s&last_snippet_type=product_card_snippet_type_2&last_widget_type=product_container&oos_visibility=true&page_index=1&total_entities_processed=1&total_pagination_items=59"),

	BLINKIT_CATEGORY_URL("https://blinkit.com/feed/?template_version=9");
	
	private final String value;
	
	BlinkitScraperUrl(String url) {
		this.value = url;
	}

	public String getValue() {
		return value;
	}
	
}