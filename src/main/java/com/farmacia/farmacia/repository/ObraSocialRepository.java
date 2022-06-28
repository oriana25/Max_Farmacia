package com.farmacia.farmacia.repository;

import com.farmacia.farmacia.models.ObraSocial;
import com.farmacia.farmacia.models.reportes.ObraSocialAdheridaPorFarmacia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ObraSocialRepository extends CrudRepository<ObraSocial,Integer> {

    @Query(value= "select fa.nombre as nombreDeFarmacia, os.nombre as obraSocialAdherida from farmacia fa inner join obra_social as os on fa.id=os.farmacia_id",nativeQuery = true)
    List<ObraSocialAdheridaPorFarmacia> getObraSocialAdhByFarmacia();
}
