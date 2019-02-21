package org.brainacademy.service.models;

import org.brainacademy.model.models.SparePart;

import java.util.List;

/**
 * Interface to cooperate with repository of Spare Parts
 */

public interface SparePartService {

    List<SparePart> getList();

    List<SparePart> getByType(String type);

    SparePart getByName(String name);

    SparePart save (SparePart part);
}
