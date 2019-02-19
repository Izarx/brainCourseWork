package org.brainacademy.dao;

import org.brainacademy.model.upses.Ups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UpsRepository extends JpaRepository<Ups, Long> {

    Ups findByName(String name);

    List<Ups> findByType (String type);

}
