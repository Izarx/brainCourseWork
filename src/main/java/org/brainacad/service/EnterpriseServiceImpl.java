package org.brainacad.service;

import org.brainacad.dao.EnterprisesRepository;
import org.brainacad.model.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    EnterprisesRepository enterprisesRepository;

    @Override
    public List<Enterprise> getList() {
        return enterprisesRepository.findAll();
    }

    @Override
    public Enterprise getByName(String name) {
        return enterprisesRepository.findByName(name);
    }

    @Override
    public Enterprise save(Enterprise enterprise) {
        return enterprisesRepository.save(enterprise);
    }
}
