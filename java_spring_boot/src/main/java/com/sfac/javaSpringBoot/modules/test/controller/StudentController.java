package com.sfac.javaSpringBoot.modules.test.controller;

import com.sfac.javaSpringBoot.modules.common.vo.Result;
import com.sfac.javaSpringBoot.modules.common.vo.SearchVo;
import com.sfac.javaSpringBoot.modules.test.entity.Student;
import com.sfac.javaSpringBoot.modules.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/12
 * Time: 20:25
 * Description: No Description
 */
@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 127.0.0.1/api/student -----post
     * {"studentName":"hujiang1","studentCard":{"cardId":"1"}}
     * @param student
     * @return
     */
    @PostMapping(value = "student" ,consumes = "application/json")
    public Result<Student> insertStudent(@RequestBody Student student){
        return studentService.insertStudent(student);
    }

    /**
     * 127.0.0.1/api/student/1 ------get
     * @param studentId
     * @return
     */
    @GetMapping("/student/{studentId}")
    public Student getStudentByStudentId(@PathVariable int studentId) {
        return studentService.getStudentByStudentId(studentId);
    }

    /**
     * 127.0.0.1/api/students -----post
     *{"currentPage":"1","pageSize":"5","keyWord":"hu","orderBy":"studentName","sort":"desc"}
     * @param searchVo
     * @return
     */
    @PostMapping(value = "/students",consumes = "application/json")
    public Page<Student> getStudentBysearchvo(@RequestBody SearchVo searchVo) {
        return studentService.getStudentBysearchvo(searchVo);
    }

    /**
     * 127.0.0.1/api/students  ------get
     * @return
     */
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

}
