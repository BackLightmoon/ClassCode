package com.sfac.javaSpringBoot.modules.test.repository;

import com.sfac.javaSpringBoot.modules.test.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/12
 * Time: 20:02
 * Description: No Description
 */
@Repository
public interface CardRepository extends JpaRepository<Card,Integer> {

}
