package com.integration.iris.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import com.integration.iris.entity.InsuranceRawData;
import com.integration.iris.entity.VesselRawData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static java.lang.Long.valueOf;

public class InsurancePolicyService {
private static List<String> insurancePolicyColumnName = Arrays.asList("IRIS Insurance Policy No","vesselName", "Insurance Policy Name","Policy Start Date","Policy End Date");
private static List<InsuranceRawData> insuranceRawDataList = new ArrayList<>();
    private static List<VesselRawData> vesselRawDataList = new ArrayList<>();


    public static void readIrisRawData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\AGC054\\Downloads\\IRIS_InsurancePolicy_Container_RawData (2).xlsx");
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

        int firstRow = hssfSheet.getFirstRowNum();
        int lastRowNum = hssfSheet.getLastRowNum();
        for (int index = firstRow + 1; index <= lastRowNum; index++) {
            Row row = hssfSheet.getRow(index);
            String vesselName = row.getCell(1).toString();
            String insuranceType = row.getCell(3).toString();
            Date insurancePolicyStartDate = row.getCell(4).getDateCellValue();
            Date insurancePolicyEndDate = row.getCell(5).getDateCellValue();
            if (insurancePolicyEndDate == null) {
                insurancePolicyEndDate = new Date(Long.MAX_VALUE);

            }
            String insurancePolicyName = row.getCell(9).toString();
            InsuranceRawData insuranceRawData = new InsuranceRawData(valueOf(index), vesselName, insuranceType, insurancePolicyStartDate, insurancePolicyEndDate, insurancePolicyName);
            insuranceRawDataList.add(insuranceRawData);
        }
    }

    public static void readVesselDataFromExcel() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\AGC054\\Downloads\\vessel.xlsx");
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);

        int firstRow = hssfSheet.getFirstRowNum();

        int lastRowNum = hssfSheet.getLastRowNum();
        for (int index = firstRow + 1; index <= lastRowNum; index++) {
            Row row = hssfSheet.getRow(index);
            String vesselName = row.getCell(1).toString();
            String name = new CellAddress(index,2).toString();
            String insuranceType = row.getCell(3).toString();
            Date insurancePolicyStartDate = row.getCell(4).getDateCellValue();
            Date insurancePolicyEndDate = row.getCell(5).getDateCellValue();
            if (insurancePolicyEndDate == null) {
                insurancePolicyEndDate = new Date(Long.MAX_VALUE);

            }
            String insurancePolicyName = row.getCell(9).toString();
            InsuranceRawData insuranceRawData = new InsuranceRawData(valueOf(index), vesselName, insuranceType, insurancePolicyStartDate, insurancePolicyEndDate, insurancePolicyName);
            insuranceRawDataList.add(insuranceRawData);
        }
    }

    private static void writeInsurancePolicyToExcel() throws IOException {
        String fileName ="C:\\Users\\AGC054\\Downloads\\OUTPUT_IRIS_InsurancePolicy.xls";
        XSSFWorkbook hssfWorkbook = new XSSFWorkbook();
        XSSFSheet hssfSheet = hssfWorkbook.createSheet("Insurance Polidy");
        Row row = hssfSheet.createRow(0);
        int columnIndex =0;
        for(String columnName:insurancePolicyColumnName){
            row.createCell(columnIndex).setCellValue(columnName);
            columnIndex++;
        }

        int rowIndex =1;
        for(InsuranceRawData insuranceRawData:insuranceRawDataList){
            Row rowToInsert = hssfSheet.createRow(rowIndex);
            rowToInsert.createCell(0).setCellValue(insuranceRawData.getInsuranceId());
            rowToInsert.createCell(1).setCellValue(insuranceRawData.getVesselName());
            rowToInsert.createCell(2).setCellValue(insuranceRawData.getInsurancePolicyName());
            rowToInsert.createCell(3).setCellValue(insuranceRawData.getInsurancePolicyStartDate());
            rowToInsert.createCell(4).setCellValue(insuranceRawData.getInsurancePolicyEndDate());
            rowIndex++;
        }

        FileOutputStream fileOut = new FileOutputStream(fileName);
        hssfWorkbook.write(fileOut);
        fileOut.close();


    }

    public static void main(String[] args) {
        try {
       //     readIrisRawData();
         //   writeInsurancePolicyToExcel();
            readVesselDataFromExcel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    private InsuranceRawData getInsurancePolicyLine(List<InsuranceRawData> insuranceRawDataList, String vesselName, Date insuranceClaimDate) {
     Optional<InsuranceRawData> insuranceRawDataOnFilter =   insuranceRawDataList.stream().filter(insuranceRawData -> insuranceRawData.getVesselName().equals(vesselName)).
                filter(insuranceRawData -> insuranceRawData.getInsurancePolicyEndDate().toInstant().isAfter(insuranceClaimDate.toInstant())
                        && insuranceRawData.getInsurancePolicyEndDate().toInstant().isBefore(insuranceClaimDate.toInstant())).findFirst();
     return insuranceRawDataOnFilter.get();
    }
}
