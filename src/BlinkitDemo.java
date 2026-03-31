import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BlinkitScraper.BlinkitPagination;
import BlinkitScraper.Product;

public class BlinkitDemo {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Processed Starting");
		
		BlinkitPagination paginatedInfo = new BlinkitPagination();

		List<List<Product>> productItemLists = paginatedInfo.getInfoFromEveryPageUrl();

		String filePath = "/home/robin/eclipse-workspace/BlinkitScraper/src/csv_data/blinkit_product_bean.xlsx";

		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		for (List<Product> products : productItemLists) {
			
		    for (Product item : products) {
		        
		        String categoryName = item.getProduct_category();

		        XSSFSheet sheet = workbook.getSheet(categoryName);
		        
		        if (sheet == null) {
		        	
		            sheet = workbook.createSheet(categoryName);

		            XSSFRow headerRow = sheet.createRow(0);

		            headerRow.createCell(0).setCellValue("Product_Type");
		            headerRow.createCell(1).setCellValue("Name");
		            headerRow.createCell(2).setCellValue("Description");
	                headerRow.createCell(3).setCellValue("Image_URL");
	                headerRow.createCell(4).setCellValue("Brand");
//		            headerRow.createCell(5).setCellValue("Original MRP");
//		            headerRow.createCell(6).setCellValue("Blinkit MRP");

		        }

		        // Finding the next empty row
		        int rowNum = sheet.getLastRowNum() + 1;

		        // Write in row
		        XSSFRow row = sheet.createRow(rowNum);
		        
		        row.createCell(0).setCellValue(item.getProduct_category());
		        row.createCell(1).setCellValue(item.getProduct_name());
		        row.createCell(2).setCellValue("N/A");
		        row.createCell(3).setCellValue(item.getProduct_image());
		        row.createCell(4).setCellValue(item.getProduct_brand());
//		        row.createCell(5).setCellValue(item.getProduct_original_mrp());
//		        row.createCell(6).setCellValue(item.getProduct_normal_mrp());
                
		    }
		}

		try (FileOutputStream out = new FileOutputStream(filePath)) {
		    workbook.write(out);
		}

		workbook.close();

		System.out.println("Processed finished");
	}

}
