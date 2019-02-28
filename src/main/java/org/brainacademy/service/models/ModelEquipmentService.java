package org.brainacademy.service.models;

import org.brainacademy.model.models.ModelEquipment;

import java.util.List;

public interface ModelEquipmentService {

    List<ModelEquipment> getList();

    List<String> getListByName();

    ModelEquipment getByName(String name);

    List<ModelEquipment> getByType(String type);

    ModelEquipment save (ModelEquipment modelEquipment);
}
