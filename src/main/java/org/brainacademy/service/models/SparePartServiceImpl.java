package org.brainacademy.service.models;

import org.brainacademy.dao.SpareRepository;
import org.brainacademy.model.models.SparePart;
import org.brainacademy.model.models.SparePartType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of common service interface ModelEquipmentService. This implementation communicate with repository
 * of spare parts and has identifier "sparePart".
 */

@Service("sparePart")
public class SparePartServiceImpl implements ModelEquipmentService<SparePart, SparePartType> {

    @Autowired
    SpareRepository spareRepository;

    @Override
    public List<SparePart> getList() {
        return spareRepository.findAll();
    }

    @Override
    public List<String> getListOfNames(final List<SparePart> list)
    {
        return list.stream().map(SparePart::getName).collect(Collectors.toList());
    }

    @Override
    public SparePart getByName(String name) {
        return spareRepository.findByName(name);
    }

    @Override
    public SparePart getById(final Long id)
    {
        return spareRepository.findById(id).orElse(null);
    }

    @Override
    public SparePart save(SparePart part) {
        return spareRepository.save(part);
    }

    @Override
    public void deleteById(final Long id)
    {
        spareRepository.deleteById(id);
    }

    @Override
    public List<String> getTypes()
    {
        return Arrays.stream(SparePartType.values()).map(SparePartType::name).collect(Collectors.toList());
    }

    @Override
    public List<SparePart> getListByType(final SparePartType sparePartType)
    {
        return getList().stream().filter(s -> s.getType().equals(sparePartType)).collect(Collectors.toList());
    }
}
