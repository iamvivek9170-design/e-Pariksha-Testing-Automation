package utils;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataUtils {

    public static User getFirstUserByRole(String roleName) {

        String path = "src/test/resources/testdata/users.xlsx";
        DataFormatter formatter = new DataFormatter();

        try (FileInputStream file = new FileInputStream(path);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            //  Skip Header Row
            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();

                if (row == null) continue;

                String role = formatter.formatCellValue(row.getCell(0));
                String username = formatter.formatCellValue(row.getCell(1));
                String password = formatter.formatCellValue(row.getCell(2));

                if (role.equalsIgnoreCase(roleName)) {
                    return new User(role, username, password);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Excel reading failed: " + e.getMessage(), e);
        }

        throw new RuntimeException("No user found for role: " + roleName);
    }

    public static User getUserByRoleAndIndex(String roleName, int index) {

        if (index <= 0) {
            throw new IllegalArgumentException("Index must start from 1");
        }

        String path = "src/test/resources/testdata/users.xlsx";
        DataFormatter formatter = new DataFormatter();
        int count = 0;

        try (FileInputStream file = new FileInputStream(path);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();

                if (row == null) continue;

                String role = formatter.formatCellValue(row.getCell(0));
                String username = formatter.formatCellValue(row.getCell(1));
                String password = formatter.formatCellValue(row.getCell(2));

                if (role.equalsIgnoreCase(roleName)) {
 
                    count++;

                    if (count == index) {
                        return new User(role, username, password);
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Excel reading failed: " + e.getMessage(), e);
        }

        throw new RuntimeException("Invalid index " + index + " for role: " + roleName);
    }
//public static void main(String[] args) {
//	
//	System.out.println("jjijijijj");
//	System.out.println(getFirstUserByRole("admin"));
//	
//	
//	
//	
//}
}


