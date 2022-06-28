package com.farmacia.farmacia.repository;

import com.farmacia.farmacia.models.Cliente;
import com.farmacia.farmacia.models.reportes.ClienteObraSocial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente,Integer> {

    @Query(value = "select concat (cl.nombre, \" \", cl.apellido) as nombreCompleto, cl.email as email, os.nombre as obraSocial from cliente as cl inner join  obra_social as os on os.id_cliente = cl.id",nativeQuery = true )
    List<ClienteObraSocial> getClienteByObraSocial();
}
