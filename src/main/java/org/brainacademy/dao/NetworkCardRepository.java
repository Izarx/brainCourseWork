package org.brainacademy.dao;

import org.brainacademy.model.implementations.NetworkCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NetworkCardRepository extends JpaRepository<NetworkCard, Long> {
}
