package org.brainacademy.service.models;

import org.brainacademy.model.models.ModelEquipment;

import java.util.List;

public interface ModelEquipmentService {

    List<ModelEquipment> getList();

    List<String> getListByName();

    ModelEquipment getByName(String name);

    ModelEquipment getById(Long id);

    ModelEquipment save (ModelEquipment modelEquipment);

    void deleteById(Long id);
}
