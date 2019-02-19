package org.brainacademy.dao;

import org.brainacademy.model.upses.UpsImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UpsImplRepository extends JpaRepository<UpsImpl, Long> {

    List<UpsImpl> findByUpsId (Long upsId);

    List<UpsImpl> findByEnterpriseId (Long enterpiseId);

    UpsImpl findByName (String name);

    UpsImpl findBySerialNumber (String serialNumber);

    List<UpsImpl> findByIsBroken (Boolean isBroken);
}
