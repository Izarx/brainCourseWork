package org.brainacademy.dao;

import org.brainacademy.model.implementations.NetworkCard;
import org.brainacademy.model.implementations.UpsImpl;
import org.brainacademy.model.models.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NetworkCardRepository extends JpaRepository<NetworkCard, Long> {

    List<NetworkCard> findByModelId (SparePart model);

    NetworkCard findByUpsId (UpsImpl ups);

    List<NetworkCard> findByIsBroken (boolean isBroken);

    NetworkCard findBySerialNumber (String serialNumber);

    NetworkCard findByName (String name);

}
