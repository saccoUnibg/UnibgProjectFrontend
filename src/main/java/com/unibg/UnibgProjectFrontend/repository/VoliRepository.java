package com.unibg.UnibgProjectFrontend.repository;


import com.unibg.UnibgProjectFrontend.entity.VoloEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface VoliRepository extends CrudRepository<VoloEntity,Integer> {
    List<VoloEntity> findByPartenzaAndArrivoIgnoreCaseAndData(String partenza, String arrivo, String data);

    List<VoloEntity> findByIdIn(Collection<Long> idList);
    VoloEntity findById(Long id);
}
