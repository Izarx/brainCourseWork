package org.brainacademy.service.implementations;

import org.brainacademy.dao.NetworkCardRepository;
import org.brainacademy.model.implementations.NetworkCard;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NetworkCardServiceImpl implements NetworkCardService {

    @Autowired
    private NetworkCardRepository networkCardRepository;

    @Override
    public NetworkCard getById(final Long id)
    {
        return null;
    }

    @Override
    public List<NetworkCard> getList() {
        return null;
    }

    @Override
    public NetworkCard getBySerialNumber(String serialNumber) {
        return null;
    }

    @Override
    public List<NetworkCard> getListByIsBroken(boolean isBroken) {
        return null;
    }

    @Override
    public NetworkCard save(NetworkCard equipmentImplementation) {
        return null;
    }

    @Override
    public void deleteById(final Long id)
    {

    }

    @Override
    public NetworkCard getByName(String name) {
        return null;
    }
}
