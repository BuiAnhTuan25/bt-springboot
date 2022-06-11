package com.example.demoimportexcel.importexcel;

import com.example.demoimportexcel.model.Student;
import com.example.demoimportexcel.service.StudentService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ImportExcel {

    @Autowired
    StudentService studentService;

    public List<Student> ImportStudentFromExcel(MultipartFile files) throws IOException {
            List<Student> students = new ArrayList<>();

            XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
            XSSFSheet worksheet = workbook.getSheetAt(0);
            for (int index = 4; index < worksheet.getPhysicalNumberOfRows(); index++) {
                if (index > 4) {
                    XSSFRow row = worksheet.getRow(index);
                    Student student = new Student();
                    student.setId(Long.parseLong(getCellValue(row, 0)));
                    student.setPrimary_school(getCellValue(row, 1));
                    student.setDistrict(getCellValue(row, 2));
                    student.setStudent_id(getCellValue(row, 3));
                    student.setClassroom(getCellValue(row, 4));
                    student.setName(getCellValue(row, 5));

                    SimpleDateFormat DateFor = new SimpleDateFormat("yyyy/MM/dd");
                    String dateString=getCellValue(row, 8)+"/"+getCellValue(row, 7)+"/"+getCellValue(row, 6);
                    try{
                        Date date=DateFor.parse(dateString);
                        student.setBirthday(date);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    student.setGender(getCellValue(row, 9));
                    student.setBirthplace(getCellValue(row, 10));
                    student.setEthnic(getCellValue(row, 11));
                    student.setAddress(getCellValue(row, 12));
                    student.setPhone_number(getCellValue(row, 13));
                    student.setPoint1(!getCellValue(row, 14).isEmpty()?Integer.parseInt(getCellValue(row, 14)):0);
                    student.setPoint2(!getCellValue(row, 15).isEmpty()?Integer.parseInt(getCellValue(row, 15)):0);
                    student.setPoint3(!getCellValue(row, 16).isEmpty()?Integer.parseInt(getCellValue(row, 16)):0);
                    student.setPoint4(!getCellValue(row, 17).isEmpty()?Integer.parseInt(getCellValue(row, 17)):0);
                    student.setPoint5(!getCellValue(row, 18).isEmpty()?Integer.parseInt(getCellValue(row, 18)):0);
                    student.setTotal_point5year(!getCellValue(row, 19).isEmpty()?Integer.parseInt(getCellValue(row, 19)):0);
                    student.setPriority_point(!getCellValue(row, 20).isEmpty()?Integer.parseInt(getCellValue(row, 20)):0);
                    student.setTotal_point(!getCellValue(row, 21).isEmpty()?Integer.parseInt(getCellValue(row, 21)):0);
                    student.setNote(getCellValue(row, 22));
                    students.add(student);
                }
            }
            return students;
    }
        private static String getCellValue(Row row, int cellNo) {
            DataFormatter formatter = new DataFormatter();
            Cell cell = row.getCell(cellNo);
            return formatter.formatCellValue(cell);
        }
}