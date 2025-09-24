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

//		BlinkitPagination paginatedInfo = new BlinkitPagination();
//
//		List<List<Product>> productItemLists = paginatedInfo.getInfoFromEveryPage();
//
//		String desiredRelativePath = "/home/robin/eclipse-workspace/Blinkit/src/blinkit_data.xlsx";
//		File blinkitDataFilePath = new File(desiredRelativePath);
//	    
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//		
//	    try	
//		{
//	    	SpreadsheetWriter writer = new XlsxWriter();
//	    	
//			for(List<Product> product : productItemLists) 
//			{
//				writer.addSheet(Product.class, product, "product");
//			}
//			
//			writer.write(outputStream);
//			
//		}catch (Exception e) {
//			System.out.println("Error occured while parsing the value to the File");
//		}
		
		
		System.out.println("Processed Starting");
		
		BlinkitPagination paginatedInfo = new BlinkitPagination();

		List<List<Product>> productItemLists = paginatedInfo.getInfoFromEveryPageUrl();

		String filePath = "/home/robin/eclipse-workspace/Blinkit/src/blinkit_data.xlsx";
		
		// Create workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		for (List<Product> products : productItemLists) {
			
		    for (Product item : products) {
		        
		        String categoryName = item.getProduct_category();

		        /**
		         * Create or Get the sheet
		         * This is important logic to create different sheet
		         */
		        XSSFSheet sheet = workbook.getSheet(categoryName);
		        
		        if (sheet == null) {
		        	
		            sheet = workbook.createSheet(categoryName);

		            XSSFRow headerRow = sheet.createRow(0);

		            headerRow.createCell(0).setCellValue("Product Name");
		            headerRow.createCell(1).setCellValue("Category");
		            headerRow.createCell(2).setCellValue("Original MRP");
		            headerRow.createCell(3).setCellValue("Blinkit MRP");
		        }

		        // Finding the next empty row
		        int rowNum = sheet.getLastRowNum() + 1;

		        // Write in row
		        XSSFRow row = sheet.createRow(rowNum);
		        
		        row.createCell(0).setCellValue(item.getProduct_name());
		        row.createCell(1).setCellValue(item.getProduct_category());
		        row.createCell(2).setCellValue(item.getProduct_original_mrp());
		        row.createCell(3).setCellValue(item.getProduct_normal_mrp());
		    }
		}

		try (FileOutputStream out = new FileOutputStream(filePath)) {
		    workbook.write(out);
		}

		workbook.close();

		System.out.println("Processed finished");
	}

}
