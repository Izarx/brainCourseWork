package org.brainacademy.service.implementations;

import org.brainacademy.dao.NetworkCardRepository;
import org.brainacademy.model.implementations.NetworkCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of Network Card Service interface to work with repository of Network Cards
 */

@Service
public class NetworkCardServiceImpl implements NetworkCardService {

    @Autowired
    private NetworkCardRepository networkCardRepository;

    @Override
    public NetworkCard getById(final Long id)
    {
        return networkCardRepository.findById(id).orElse(null);
    }

    @Override
    public List<NetworkCard> getList() {
        return networkCardRepository.findAll();
    }

    @Override
    public NetworkCard getBySerialNumber(String serialNumber) {
        return networkCardRepository.findBySerialNumber(serialNumber);
    }

    @Override
    public List<NetworkCard> getListByIsBroken(boolean isBroken) {
        return networkCardRepository.findByIsBroken(isBroken);
    }

    @Override
    public NetworkCard save(NetworkCard equipmentImplementation) {
        return networkCardRepository.save(equipmentImplementation);
    }

    @Override
    public void deleteById(final Long id)
    {
        networkCardRepository.deleteById(id);
    }

    @Override
    public NetworkCard getByName(String name) {
        return networkCardRepository.findByName(name);
    }
}
