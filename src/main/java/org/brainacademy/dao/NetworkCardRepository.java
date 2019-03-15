package org.brainacademy.dao;

import org.brainacademy.model.implementations.NetworkCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NetworkCardRepository extends JpaRepository<NetworkCard, Long> {

    List<NetworkCard> findBySparePartId (Long sparePartId);

    NetworkCard findByUpsId (Long upsId);

    List<NetworkCard> findByIsBroken (boolean isBroken);

    NetworkCard findBySerialNumber (String serialNumber);

    NetworkCard findByName (String name);

}
