package org.brainacademy.service.models;

import org.brainacademy.dao.UpsRepository;
import org.brainacademy.model.models.Ups;
import org.brainacademy.model.models.UpsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of common service interface ModelEquipmentService. This implementation communicate with repository of UPS
 * and has identifier "ups".
 */

@Service("ups")
public class UpsServiceImpl implements ModelEquipmentService<Ups, UpsType> {

    @Autowired
    UpsRepository upsRepository;

    @Override
    public List<Ups> getList() {
        return upsRepository.findAll();
    }

    @Override
    public List<String> getListOfNames(final List<Ups> list) {
        return list.stream().map(Ups::getName).collect(Collectors.toList());
    }

    @Override
    public Ups getByName(String name) {
        return upsRepository.findByName(name);
    }

    @Override
    public Ups getById(final Long id)
    {
        return upsRepository.findById(id).orElse(null);
    }

    @Override
    public Ups save(Ups modelEquipment) {
        return upsRepository.save(modelEquipment);
    }

    @Override
    public void deleteById(final Long id)
    {
        upsRepository.deleteById(id);
    }

    @Override
    public List<String> getTypes()
    {
        return Arrays.stream(UpsType.values()).map(UpsType::name).collect(Collectors.toList());
    }

    @Override
    public List<Ups> getListByType (final UpsType type) {
        return getList().stream().filter(s -> s.getType().equals(type)).collect(Collectors.toList());
    }
}
