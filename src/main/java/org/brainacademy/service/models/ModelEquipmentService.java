package org.brainacademy.service.models;

import org.brainacademy.model.models.ModelEquipment;

import java.util.List;

public interface ModelEquipmentService<T extends ModelEquipment> {

    List<T> getList();

    List<String> getListByName();

    T getByName(String name);

    T getById(Long id);

    T save (T modelEquipment);

    void deleteById(Long id);
}
