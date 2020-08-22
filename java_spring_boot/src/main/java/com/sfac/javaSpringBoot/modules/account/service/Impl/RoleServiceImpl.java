package com.sfac.javaSpringBoot.modules.account.service.Impl;

import com.sfac.javaSpringBoot.modules.account.dao.RoleDao;
import com.sfac.javaSpringBoot.modules.account.entity.Role;
import com.sfac.javaSpringBoot.modules.account.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/22
 * Time: 15:02
 * Description: No Description
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getRoles() {
        return Optional.ofNullable(roleDao.getRoles()).orElse(Collections.emptyList());
    }
}
