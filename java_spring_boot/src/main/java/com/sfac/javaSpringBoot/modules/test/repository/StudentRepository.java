package com.sfac.javaSpringBoot.modules.test.repository;

import com.sfac.javaSpringBoot.modules.test.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/12
 * Time: 20:21
 * Description: No Description
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByStudentName(String studentName);

    List<Student> findByStudentNameLike(String studentName);

    List<Student> findTop2ByStudentNameLike(String studentName);

    //hql查询
    //@Query(value = "select s from Student s where s.studentName = ?1 and s.studentCard.cardId =?2 ")
    //@Query(value = "select s from Student s where s.studentName =: studentName " + "and s.studentCard.cardId = :cardId")
    @Query(value = "select s from Student s where s.studentName = :studentName " + "and s.studentCard.cardId = :cardId")
    List<Student> getStudentsByParams(@Param("studentName") String studentName,
                                      @Param("cardId") int cardId);
}
