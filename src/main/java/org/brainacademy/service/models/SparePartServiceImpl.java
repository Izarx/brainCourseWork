package org.brainacademy.service.models;

import org.brainacademy.dao.SpareRepository;
import org.brainacademy.model.models.SparePart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SparePartServiceImpl implements SparePartService {

    @Autowired
    SpareRepository spareRepository;

    @Override
    public List<SparePart> getList() {
        return spareRepository.findAll();
    }

    @Override
    public List<SparePart> getByType(String type) {
        return spareRepository.findByType(type.toUpperCase());
    }

    @Override
    public SparePart getByName(String name) {
        return spareRepository.findByName(name);
    }

    @Override
    public SparePart save(SparePart part) {
        return spareRepository.save(part);
    }
}
