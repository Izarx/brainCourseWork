package org.brainacademy.service.models;

import org.brainacademy.dao.SpareRepository;
import org.brainacademy.model.models.ModelEquipment;
import org.brainacademy.model.models.SparePart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SparePartServiceImpl implements SparePartService {

    @Autowired
    SpareRepository spareRepository;

    @Override
    public List<ModelEquipment> getList() {
        return spareRepository.findAll().stream().filter(s -> s instanceof SparePart).collect(Collectors.toList());
    }

    @Override
    public List<String> getListByName() {
        return spareRepository.findAll().stream().map(SparePart::getName).collect(Collectors.toList());
    }

    @Override
    public List<ModelEquipment> getByType(String type) {
        return spareRepository.findAll().stream().filter(s -> s.getType().name().equals(type)).collect(Collectors.toList());
    }

    @Override
    public SparePart getByName(String name) {
        return spareRepository.findByName(name);
    }

    @Override
    public ModelEquipment save(ModelEquipment part) {
        return spareRepository.save((SparePart) part);
    }
}
