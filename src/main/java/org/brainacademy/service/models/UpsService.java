package org.brainacademy.service.models;

import org.brainacademy.model.models.Ups;

import java.util.List;

/**
 * Interface to cooperate with repository of UPSes
 */

public interface UpsService extends ModelEquipmentService {

    List<Ups> getList();

    List<Ups> getByType(String type);

    Ups getByName(String name);

    Ups save(Ups model);

}
