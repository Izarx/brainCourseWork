package org.brainacad.dao;

import org.brainacad.model.UpsImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UpsImplRepository extends JpaRepository<UpsImpl, Long> {

    List<UpsImpl> findByUpsId (Long upsId);

    List<UpsImpl> findByEnterpriseIg (Long enterpiseId);
}
