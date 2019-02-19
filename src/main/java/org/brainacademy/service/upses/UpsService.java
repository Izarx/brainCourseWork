package org.brainacademy.service.upses;

import org.brainacademy.model.upses.Ups;
import org.brainacademy.model.upses.UpsTypes;

import java.util.List;

/**
 * Interface to cooperate with repository of UPSes
 */

public interface UpsService {

    List<Ups> getList();

    List<Ups> getByType(UpsTypes type);

    Ups getByName(String name);

    Ups save(Ups ups);

}
