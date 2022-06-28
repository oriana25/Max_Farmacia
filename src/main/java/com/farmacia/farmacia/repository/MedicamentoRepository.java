package com.farmacia.farmacia.repository;

import com.farmacia.farmacia.models.Farmacia;
import com.farmacia.farmacia.models.Medicamento;
import com.farmacia.farmacia.models.reportes.MedicamentoByName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedicamentoRepository extends CrudRepository<Medicamento, Integer> {

    @Query(value = "select fa.nombre as nombre, fa.descuento as descuento , me.nombre as medicamento, me.precio as precio from farmacia fa inner join medicamento me on fa.id=me.farmacia_id where me.nombre like %:name% ", nativeQuery = true)
    List<MedicamentoByName> getMedicamentoByName(@Param("name") String nombre);
}
