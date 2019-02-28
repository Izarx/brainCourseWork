package org.brainacademy.service.implementations;

import org.brainacademy.model.implementations.NetworkCard;

public interface NetworkCardService extends ImplementationService {

    NetworkCard getByName(String name);

}
