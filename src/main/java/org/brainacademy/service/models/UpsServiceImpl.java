package org.brainacademy.service.models;

import org.brainacademy.dao.UpsRepository;
import org.brainacademy.model.models.ModelEquipment;
import org.brainacademy.model.models.Ups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UpsServiceImpl implements UpsService {

    @Autowired
    UpsRepository upsRepository;

    @Override
    public List<ModelEquipment> getList() {
        return upsRepository.findAll().stream().filter(s -> s instanceof Ups).collect(Collectors.toList());
    }

    @Override
    public List<String> getListByName() {
        return upsRepository.findAll().stream().map(Ups::getName).collect(Collectors.toList());
    }

    @Override
    public List<ModelEquipment> getByType(String type) {
        return upsRepository.findAll().stream().filter(s -> s.getType().name().equals(type)).collect(Collectors.toList());
    }

    @Override
    public Ups getByName(String name) {
        return upsRepository.findByName(name);
    }

    @Override
    public ModelEquipment save(ModelEquipment modelEquipment) {
        return upsRepository.save( (Ups) modelEquipment);
    }
}
