package org.brainacademy.service.implementations;

import org.brainacademy.model.implementations.Battery;

import java.util.List;

public interface BatteryService extends ImplementationService{

    List<Battery> getByYear(int year);

}
