package org.brainacademy.service;

import org.brainacademy.dao.EnterpriseRepository;
import org.brainacademy.model.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    EnterpriseRepository enterpriseRepository;

    @Override
    public List<Enterprise> getList() {
        return enterpriseRepository.findAll();
    }

    @Override
    public Enterprise getByName(String name) {
        return enterpriseRepository.findByName(name);
    }

    @Override
    public Enterprise save(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }
}
