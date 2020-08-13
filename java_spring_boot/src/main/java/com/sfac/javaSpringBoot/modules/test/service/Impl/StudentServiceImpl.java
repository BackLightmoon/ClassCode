package com.sfac.javaSpringBoot.modules.test.service.Impl;

import com.sfac.javaSpringBoot.modules.common.vo.Result;
import com.sfac.javaSpringBoot.modules.common.vo.SearchVo;
import com.sfac.javaSpringBoot.modules.test.entity.Student;
import com.sfac.javaSpringBoot.modules.test.repository.StudentRepository;
import com.sfac.javaSpringBoot.modules.test.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/12
 * Time: 20:22
 * Description: No Description
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Result<Student> insertStudent(Student student) {
        student.setCreateDate(LocalDateTime.now());
        studentRepository.saveAndFlush(student);
        return new Result<>(Result.ResultStatus.SUCCESS.status,"Insert success",student);
    }

    @Override
    public Student getStudentByStudentId(int studentId) {
        //.get()吧泛型所代表的对象拿到
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Page<Student> getStudentBysearchvo(SearchVo searchVo) {
        //Direction枚举，只有两个方向
        Sort.Direction direction ="desc".equalsIgnoreCase(searchVo.getSort())
                ? Sort.Direction.DESC : Sort.Direction.ASC;
        //isblank 判断是否为空，类似于三目运算符
        Sort sort = new Sort(direction, StringUtils.isBlank(searchVo.getOrderBy()) ?
                "studentId" : searchVo.getOrderBy());
        //起始页为0，但是前端页面起始页为1，所以这里要减1
        Pageable pageable = PageRequest.of(
                searchVo.getCurrentPage()-1,searchVo.getPageSize(),sort);

        // build Example 对象
        // 如果 keyWord 为 null，则设置的 studentName 不参与查询条件
        Student student =new Student();
        student.setStudentName(searchVo.getKeyWord());
        ExampleMatcher matcher = ExampleMatcher.matching()
                // 全部模糊查询，即 %{studentName} %
                //.withMatcher("studentName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("studentName",match -> match.contains())
                // 忽略字段，即不管id是什么值都不加入查询条件
                .withIgnorePaths("studentId");
        Example<Student> example =Example.of(student,matcher);

        return studentRepository.findAll(example,pageable);
    }

    @Override
    public List<Student> getStudents() {
        Sort.Direction direction = Sort.Direction.DESC;
        Sort sort = new Sort(direction, "studentName");
        return studentRepository.findAll(sort);
    }
}
