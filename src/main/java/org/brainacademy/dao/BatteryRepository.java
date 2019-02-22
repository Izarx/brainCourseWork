package org.brainacademy.dao;

import org.brainacademy.model.implementations.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryRepository extends JpaRepository<Battery, Long> {
}
