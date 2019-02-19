package org.brainacademy.service.upses;

import org.brainacademy.dao.UpsRepository;
import org.brainacademy.model.upses.Ups;
import org.brainacademy.model.upses.UpsTypes;
import org.brainacademy.service.upses.UpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpsServiceImpl implements UpsService {

    @Autowired
    UpsRepository upsRepository;

    @Override
    public List<Ups> getList() {
        return upsRepository.findAll();
    }

    @Override
    public List<Ups> getByType(UpsTypes type) {
        return upsRepository.findByType(type.name());
    }

    @Override
    public Ups getByName(String name) {
        return upsRepository.findByName(name);
    }


    @Override
    public Ups save(Ups ups) {
        return upsRepository.save(ups);
    }
}
