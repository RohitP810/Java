/**
 * @file App.java
 * @author Rohit Prabhakaran
 * @version 1.0
 * @date 2023-04-16
 */
//_________________

import java.util.*;
import java.io.File;  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import java.io.*;

//Class for Reading functions
class excelRead{
    //Details of each individuals
    public static void getCustomerDetails(String filePath, double customerID) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));  
        XSSFWorkbook wb = new XSSFWorkbook(fis);   
        XSSFSheet sheet = wb.getSheetAt(0);  
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();  
        DataFormatter formatter = new DataFormatter();
        for (Row row: sheet) {    
            Cell cell = row.getCell(0);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && cell.getNumericCellValue() == customerID) {
                for (Cell cell2: row) {  
                    switch(formulaEvaluator.evaluateInCell(cell2).getCellType()) {  
                        case Cell.CELL_TYPE_NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell2)) {
                                System.out.print(formatter.formatCellValue(cell2) + "\t\t");
                            } else {
                                System.out.print(formatter.formatCellValue(cell2) + "\t\t\t");
                            }
                            break;
                        case Cell.CELL_TYPE_STRING:   
                            System.out.print(cell2.getStringCellValue() + "\t\t");  
                            break;
                        default:
                            System.out.print("\t\t");
                    }  
                }
                break;
            }  
        }  
        System.out.println();
    }    
    //!Details of each individuals

    //All data in excel sheet
    public static void showAllData(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        DataFormatter formatter = new DataFormatter();
        for (Row row : sheet) {
            for (Cell cell : row) {
                switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.print(formatter.formatCellValue(cell) + "\t\t");
                        } else {
                            System.out.print(formatter.formatCellValue(cell) + "\t\t\t");
                        }
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;
                    default:
                        System.out.print("\t\t");
                }
            }
            System.out.println();
        }
    }
    //!All data in excel sheet
}
//!Class for Reading functions

//Class for Writing functions
class excelWrite{
    //Function to delete a customer
    public static void deleteCustomer(String filePath, int customerId) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        int rowId = -1;
        for (Row row : sheet) {
            Cell cell = row.getCell(0);
    
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && cell.getNumericCellValue() == customerId) {
                rowId = row.getRowNum();
                break;
            }
        }
        if (rowId == -1) {
            System.out.println("No such customer found!");
            return;
        }
        sheet.removeRow(sheet.getRow(rowId));
        FileOutputStream fos = new FileOutputStream(new File(filePath));
        wb.write(fos);
        fos.close();
        System.out.println("Customer deleted successfully!");
    }
    //!Function to delete a customer

    //Function to create a new customer
    public static void createNewCustomer(String filePath) throws IOException {
        Scanner in = new Scanner(System.in);
        String CName = "";
        System.out.print("Enter Name of the customer: ");
        CName = in.nextLine();
        System.out.println(CName);
        FileInputStream fis = new FileInputStream(new File(filePath));
        String Phone = "";
        System.out.println("Enter Phone number: ");
        Phone = in.nextLine();
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        Row lastRow = sheet.getRow(lastRowNum);
        Cell lastCell = lastRow.getCell(0);
        double newCustomerId = lastCell.getNumericCellValue() + 1;
        Row newRow = sheet.createRow(lastRowNum + 1);
        Cell idCell = newRow.createCell(0);
        idCell.setCellValue(newCustomerId);
        Cell nameCell = newRow.createCell(1);
        nameCell.setCellValue(CName);
        Cell preReadingCell = newRow.createCell(2);
        preReadingCell.setCellValue(0);
        Cell currReadingCell = newRow.createCell(3);
        currReadingCell.setCellValue(0);
        Cell paymentStatusCell = newRow.createCell(4);
        paymentStatusCell.setCellValue("Pending");
        Cell phoneCell = newRow.createCell(5);
        phoneCell.setCellValue(Phone);
        Cell dueDateCell = newRow.createCell(6);
        dueDateCell.setCellValue("");
        FileOutputStream fos = new FileOutputStream(new File(filePath));
        wb.write(fos);
        fos.close();
        System.out.println("New customer added with ID: " + newCustomerId);
    }
    //!Function to create a new customer

    //Function to add due dates
    public static void addCurrentDateToColumn(String filePath, double customerID) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
    
        int dueDateColumnIndex = -1;
        Row headerRow = sheet.getRow(0);
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell headerCell = headerRow.getCell(i);
            if (headerCell.getStringCellValue().equals("DueDate")) {
                dueDateColumnIndex = headerCell.getColumnIndex();
                break;
            }
        }
    
        if (dueDateColumnIndex == -1) {
            System.out.println("Column named DueDate not found in the Excel file.");
            return;
        }
    
        boolean customerFound = false;
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
    
            Cell customerIDCell = row.getCell(0);
            if (customerIDCell != null && customerIDCell.getCellTypeEnum() == CellType.NUMERIC
                && customerIDCell.getNumericCellValue() == customerID){
    
                Date currentDate = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currentDate);
                calendar.add(Calendar.DAY_OF_YEAR, 30);
                Date dueDate = calendar.getTime();
    
                Cell dueDateCell = row.createCell(dueDateColumnIndex);
                dueDateCell.setCellValue(dueDate);
    
                CellStyle dateStyle = wb.createCellStyle();
                CreationHelper createHelper = wb.getCreationHelper();
                dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
                dueDateCell.setCellStyle(dateStyle);
    
                customerFound = true;
                break;
            }
        }
    
        FileOutputStream fos = new FileOutputStream(filePath);
        wb.write(fos);
        wb.close();
        fos.close();
    
        if (customerFound) {
            System.out.println("Due date added successfully to the Excel file for customer ID " + customerID + ".");
        } else {
            System.out.println("Customer ID " + customerID + " not found in the Excel file.");
        }
    }
    //!Function to add due dates

    //Function to add currReadings
    public static void addCurrReadingToColumn(String filePath, double customerID, double currReading) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
    
        int currReadingColumnIndex = -1;
        Row headerRow = sheet.getRow(0);
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell headerCell = headerRow.getCell(i);
            if (headerCell.getStringCellValue().equals("CurrReading")) {
                currReadingColumnIndex = headerCell.getColumnIndex();
                break;
            }
        }
    
        if (currReadingColumnIndex == -1) {
            System.out.println("Column named CurrReading not found in the Excel file.");
            return;
        }
    
        boolean customerFound = false;
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
    
            Cell customerIDCell = row.getCell(0);
            if (customerIDCell != null && customerIDCell.getCellTypeEnum() == CellType.NUMERIC
                && customerIDCell.getNumericCellValue() == customerID){
                Cell currReadingCell = row.createCell(currReadingColumnIndex);
                currReadingCell.setCellValue(currReading);
    
                Cell paymentStatusCell = row.getCell(4);
                paymentStatusCell.setCellValue("Pending");
    
                customerFound = true;
                break;
            }
        }
    
        FileOutputStream fos = new FileOutputStream(filePath);
        wb.write(fos);
        wb.close();
        fos.close();
    
        if (customerFound) {
            System.out.println("Current reading added successfully to the Excel file for customer ID " + customerID + ".");
        } else {
            System.out.println("Customer ID " + customerID + " not found in the Excel file.");
        }
    }    
    //!Function to add currReadings

    //Funtion to complete transaction
    public static void payBill(XSSFSheet sheet, int rowId) {
        Row row = sheet.getRow(rowId);
        Cell preReadingCell = row.getCell(2);
        Cell currReadingCell = row.getCell(3);
        Cell dueDateCell = row.getCell(6);
        Cell paymentStatusCell = row.getCell(4);
    
        preReadingCell.setCellValue(currReadingCell.getNumericCellValue());
        currReadingCell.setCellValue(0);
        dueDateCell.setCellValue("");
        paymentStatusCell.setCellValue("Done");
    
        System.out.println("Transaction successful!");
    }
    //Funtion to complete transaction
}
//!Class for Writing functions

//Class for All Transactions
class Transactions extends excelWrite{
    //Function for generating bill
    public static void generateBill(String filePath, int customerId) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
        int rowId = -1;
        for (Row row : sheet) {
            Cell cell = row.getCell(0);
    
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && cell.getNumericCellValue() == customerId) {
                rowId = row.getRowNum();
                break;
            }
        }
        if (rowId == -1) {
            System.out.println("No such customer found!");
            return;
        }
        Row row = sheet.getRow(rowId);
        Cell paymentStatusCell = row.getCell(4);
        String paymentStatus = formulaEvaluator.evaluate(paymentStatusCell).getStringValue();
        if (paymentStatus.equalsIgnoreCase("done")) {
            System.out.println("Payment has already been done!");
            return;
        }
        Cell preReadingCell = row.getCell(2);
        Cell currReadingCell = row.getCell(3);
        Cell dueDateCell = row.getCell(6);
        double preReading = preReadingCell.getNumericCellValue();
        double currReading = currReadingCell.getNumericCellValue();
        double units = currReading - preReading;
        double amount = units * 5.0;
        String name = formulaEvaluator.evaluate(row.getCell(1)).getStringValue();
        DataFormatter formatter = new DataFormatter();
        String phone = formatter.formatCellValue(row.getCell(5));
        String dueDate = formatter.formatCellValue(dueDateCell);
        System.out.println("\t\tBILL");
        System.out.println("Customer ID:        " + customerId);
        System.out.println("Name:               " + name);
        System.out.println("Phone:              " + phone);
        System.out.println("Previous Reading:   " + preReading);
        System.out.println("Current Reading:    " + currReading);
        System.out.println("Units consumed:     " + units);
        System.out.println("Amount to be paid:  " + amount);
        System.out.println("Due date:           " + dueDate);
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to pay now? (Y/N)");
        String input = scanner.next();
    
        if (input.equalsIgnoreCase("Y")) {
            payBill(sheet, rowId);
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            wb.write(fos);
            fos.close();
        }
    }
    //!Function for generating bill
}
//!Class for All Transactions

public class App {
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    public static void main(String args[]) throws IOException {
        
        //Variable Declarations
        excelRead xlRead = new excelRead();
        excelWrite xlWrite = new excelWrite();
        Transactions Trans = new Transactions();
        double customerID;
        Scanner in = new Scanner(System.in);
        String userName;
        String passWord;
        final String filePath = "C:\\Users\\msi\\Desktop\\java.xlsx";//change this 
        boolean Admin = true;
        //!Variable Declarations

        //Authentication
        System.out.println("Enter UserName : ");
        userName = in.nextLine();
        System.out.println("Enter Password : ");
        passWord = in.nextLine();
        clearScreen();
        if(!(passWord.equals("1245")&&userName.equals("Admin"))) 
        {
            throw new ArithmeticException("Invalid Credentials");
        }
        //!Authentication

        //UI
        while(Admin) 
        {
            //Menu
        	System.out.println("\n\t\t *Welcome* ");
        	System.out.println("1. Show all data");
        	System.out.println("2. History");
        	System.out.println("3. New Customer");
            System.out.println("4. New Readings");
            System.out.println("5. Dispatch Bill");
            System.out.println("6. Delete Customer");
        	System.out.println("7. Exit");
        	System.out.println("Choose any option: ");
            //!Menu

            //Menu functioning
            int option = in.nextInt();
            clearScreen();
        	switch(option) 
        	{
        		case 1: {   
                            xlRead.showAllData(filePath); 
                            break;
                        } 
                            
        		case 2:	{
                            System.out.println("\t\tHistory");
                            System.out.println("Enter the CustomerID: ");
                            customerID = in.nextDouble();
                            xlRead.getCustomerDetails(filePath, customerID);
                            break;
        				}
                case 3: {
                            System.out.println("\t\tNew Customer");
                            xlWrite.createNewCustomer(filePath);
                            break;
                        }
                case 4: {
                            System.out.println("\t\tNew Readings");
                            System.out.println("Enter Customer ID: ");
                            customerID = in.nextDouble();
                            xlRead.getCustomerDetails(filePath, customerID);
                            System.out.println("\nEnter the new Reading : ");
                            int Reading = in.nextInt();
                            xlWrite.addCurrReadingToColumn(filePath,customerID,Reading);
                            xlWrite.addCurrentDateToColumn(filePath, customerID);
                            break;
                        }
                case 5:{
                            System.out.println("\t\tGenerate Bill");
                            System.out.println("Enter Customer ID: ");
                            int customerId = in.nextInt();
                            Trans.generateBill(filePath, customerId);
                            break;
                       }
                case 6:{
                            System.out.println("\t\tDelete Customer");
                            System.out.println("Enter Customer ID: ");
                            int customerId = in.nextInt();
                            excelWrite.deleteCustomer(filePath, customerId);
                            break;
                       }
        		case 7: {
                            Admin = false;
                            System.out.println("Thank you!");
                            break;
                        }
        		default: System.out.print("Invalid option try again!");
        	}
            //!Menu functioning
            
            //Back to main menu or exit
            if(option<7)
            {
                System.out.println("Press 'b' to go back to menu or 'e' to exit");
                String back = in.next();
                if (!back.equalsIgnoreCase("b")) {
                    Admin = false; // Exit loop if user enters anything other than "b"
                }
                clearScreen();
            }
            //!Back to main menu or exit
        }
        //!UI
    }  
}

