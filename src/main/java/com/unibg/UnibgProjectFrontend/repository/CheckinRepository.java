package com.unibg.UnibgProjectFrontend.repository;


import com.unibg.UnibgProjectFrontend.entity.CheckinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@EnableJpaRepositories
@Repository
public interface CheckinRepository extends JpaRepository<CheckinEntity,Integer> {
    @Transactional
    public void deleteByIdPrenotazione(String idPrenotazione);


}
