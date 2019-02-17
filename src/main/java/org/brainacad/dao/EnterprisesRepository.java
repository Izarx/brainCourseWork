package org.brainacad.dao;

import org.brainacad.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterprisesRepository extends JpaRepository<Enterprise, Long> {

    Enterprise findByName(String name);

}
