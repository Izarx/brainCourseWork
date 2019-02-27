package org.brainacademy.dao;

import org.brainacademy.model.implementations.EquipmentImplementation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImplementationRepository extends JpaRepository<EquipmentImplementation, Long> {
}
