package com.unibg.UnibgProjectFrontend.repository;

import com.unibg.UnibgProjectFrontend.entity.PrenotazioneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<PrenotazioneEntity,Integer> {

        public PrenotazioneEntity findByMailAndIdVolo(String idVolo,String mail);
        public List<PrenotazioneEntity> findByMail(String mail);

//        @Query("delete from PrenotazioneEntity p where p.")
//        void delete

}
