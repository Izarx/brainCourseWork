package org.brainacad.dao;

import org.brainacad.model.Ups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpsRepository extends JpaRepository<Ups, Long> {

    Ups findByName(String name);

}
