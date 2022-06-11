package com.example.demoimportexcel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String primary_school;
    private String district;
    private String student_id;
    private String classroom;
    private String name;
    private Date birthday;
    private String gender;
    private String birthplace;
    private String ethnic;
    private String address;
    private String phone_number;
    private int point1;
    private int point2;
    private int point3;
    private int point4;
    private int point5;
    private int total_point5year;
    private int priority_point;
    private int total_point;
    private String note;
}
