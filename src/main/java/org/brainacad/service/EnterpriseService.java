package org.brainacad.service;


import org.brainacad.model.Enterprise;

import java.util.List;

/**
 * Interface for cooperation with Enterprise repository
 */


public interface EnterpriseService {

    List<Enterprise> getList();

    Enterprise getByName(String name);

    Enterprise save(Enterprise enterprise);
}
