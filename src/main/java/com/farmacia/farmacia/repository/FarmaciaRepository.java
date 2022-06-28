package com.farmacia.farmacia.repository;

import com.farmacia.farmacia.models.Farmacia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface FarmaciaRepository extends CrudRepository<Farmacia,Integer> {

//buscar farmacia por nombre

    @Query(value = "select * from farmacia where nombre like %:name% ", nativeQuery = true)
    List<Farmacia> getFarmaciaByName(@Param("name") String nombre);

    @Query(value = " select f.* from farmacia as f inner join obra_social as os on os.farmacia_id = f.id" +
            " inner join cliente as c on os.id_cliente = c.id " +
            " where c.id =:idCliente ", nativeQuery = true)
    List<Farmacia> getFarmaciaByCliente(@Param("idCliente") int idCliente);
}
