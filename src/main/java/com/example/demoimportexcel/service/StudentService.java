package com.example.demoimportexcel.service;

import com.example.demoimportexcel.model.Student;
import com.example.demoimportexcel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public void saveAll(List<Student> students) {
        studentRepository.saveAll(students);
    }
    public List<Student> findByNameAndStudentId(String name,String studentId){
        return studentRepository.findByNameAndStudentId(name,studentId);
    }
    public List<Student> findByStudentId(String studentId){
        return studentRepository.findByStudentId(studentId);
    }
    public List<Student> findByName(String name,List<Student> students){
        List<Student> listStudent =new ArrayList<>();
       students.forEach(s->{
           if(s.getName().toUpperCase().contains(name.toUpperCase())){
           listStudent.add(s);
           }
       });
        return listStudent.isEmpty()?students:listStudent;
    }
}
