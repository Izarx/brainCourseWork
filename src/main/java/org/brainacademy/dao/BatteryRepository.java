package org.brainacademy.dao;

import org.brainacademy.model.implementations.Battery;
import org.brainacademy.model.implementations.UpsImpl;
import org.brainacademy.model.models.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BatteryRepository extends JpaRepository<Battery, Long> {

    Battery findBySerialNumber (String serialNumber);

    Battery findByModelId (SparePart model);

    Battery findByUpsId (UpsImpl ups);

    List<Battery> findByIsBroken(boolean isBroken);

}
