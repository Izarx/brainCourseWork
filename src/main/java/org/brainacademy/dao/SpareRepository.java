package org.brainacademy.dao;

import org.brainacademy.model.models.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpareRepository extends JpaRepository<SparePart, Long> {

    SparePart findByName (String name);

    List<SparePart> findByType (String type);

}
