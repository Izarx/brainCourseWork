package org.brainacademy.service;

import org.brainacademy.dao.EnterpriseRepository;
import org.brainacademy.model.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of Enterprise Service interface to work with repository of Enterprises
 */

@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    EnterpriseRepository enterpriseRepository;

    @Override
    public List<Enterprise> getList() {
        return enterpriseRepository.findAll();
    }

    @Override
    public List<String> getListOfNames() {
        return enterpriseRepository.findAll().stream().map(Enterprise::getName).collect(Collectors.toList());
    }

    @Override
    public Enterprise getEnterpriseById(Long id) {
        return enterpriseRepository.getOne(id);
    }

    @Override
    public Enterprise getByName(String name) {
        return enterpriseRepository.findByName(name);
    }

    @Override
    public Enterprise getById(final Long id)
    {
        return enterpriseRepository.findById(id).orElse(null);
    }

    @Override
    public Enterprise save(Enterprise enterprise) {
        return enterpriseRepository.save(enterprise);
    }

    @Override
    public void deleteById(final Long id)
    {
        enterpriseRepository.deleteById(id);
    }
}
