package org.brainacademy.dao;

import org.brainacademy.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

    Enterprise findByName(String name);

}
