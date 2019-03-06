package org.brainacademy.service.models;

import org.brainacademy.dao.UpsRepository;
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
    public List<Ups> getList() {
        return upsRepository.findAll();
    }

    @Override
    public List<String> getListByName() {
        return upsRepository.findAll().stream().map(Ups::getName).collect(Collectors.toList());
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
}
