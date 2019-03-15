package org.brainacademy.service;


import org.brainacademy.model.Enterprise;

import java.util.List;

/**
 * Interface for cooperation with Enterprise repository
 */


public interface EnterpriseService {

    List<Enterprise> getList();

    List<String> getListOfNames();

    public Enterprise getEnterpriseById(Long id);

    Enterprise getByName(String name);

    Enterprise getById(Long id);

    Enterprise save(Enterprise enterprise);

    void deleteById(Long id);
}
