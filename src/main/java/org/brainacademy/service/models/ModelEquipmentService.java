package org.brainacademy.service.models;

import org.brainacademy.model.models.ModelEquipment;

import java.util.List;

public interface ModelEquipmentService<T extends ModelEquipment, S> {

    List<T> getList();

    List<String> getListOfNames(List<T> list);

    T getByName(String name);

    T getById(Long id);

    T save (T modelEquipment);

    void deleteById(Long id);

    List<String> getTypes();

    List<T> getListByType (S s);
}
