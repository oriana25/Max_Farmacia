package com.farmacia.farmacia.controller;
import com.farmacia.farmacia.models.Cliente;
import com.farmacia.farmacia.models.Farmacia;
import com.farmacia.farmacia.models.Medicamento;
import com.farmacia.farmacia.models.ObraSocial;
import com.farmacia.farmacia.models.reportes.ClienteObraSocial;
import com.farmacia.farmacia.models.reportes.MedicamentoByName;
import com.farmacia.farmacia.models.reportes.ObraSocialAdheridaPorFarmacia;
import com.farmacia.farmacia.repository.FarmaciaRepository;
import com.farmacia.farmacia.repository.MedicamentoRepository;
import com.farmacia.farmacia.repository.ObraSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.farmacia.farmacia.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/farmacia")
public class MainController {

    @Autowired
    private FarmaciaRepository farmaciaRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private ObraSocialRepository obraSocialRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping(path = "/farmacia/all")
    public @ResponseBody
    Iterable<Farmacia> getAllFarmacia() {
        return farmaciaRepository.findAll();
    }

    @GetMapping(path = "/farmacia/cliente/{idCliente}")
    public @ResponseBody
    Iterable<Farmacia> getAllFarmaciaByCliente(@PathVariable(name = "idCliente") int idCliente) {
        return farmaciaRepository.getFarmaciaByCliente(idCliente);
    }

    @GetMapping(path = "/cliente/all")
    public @ResponseBody
    Iterable<Cliente> getAllCliente() { return clienteRepository.findAll(); }

    @GetMapping(path = "/cliente/clientePorObraSocial")
    public @ResponseBody
    Iterable<ClienteObraSocial> getClienteByObraSocial() { return clienteRepository.getClienteByObraSocial(); }

    @GetMapping(path = "/obraSocial/obraSocialPorFarmacia")
    public @ResponseBody
    Iterable<ObraSocialAdheridaPorFarmacia> getFaramciaByObraSocial() { return obraSocialRepository.getObraSocialAdhByFarmacia(); }

    @GetMapping(path = "/obraSocial/all")
    public @ResponseBody
    Iterable<ObraSocial> getAllObraSocial() { return obraSocialRepository.findAll(); }

    @GetMapping(path = "/medicamento/all")
    public @ResponseBody
    Iterable<Medicamento> getAllMedicamento() { return medicamentoRepository.findAll(); }

    @GetMapping(path = "/farmacia/{id}")
    public @ResponseBody
    Optional<Farmacia> getFarmaciaById(@PathVariable("id") int id_f) {
        return farmaciaRepository.findById(id_f);
    }

    @GetMapping(path = "/farmacia/name/{farmacia}")
    public @ResponseBody
    List<Farmacia> getFarmaciaByName(@PathVariable("farmacia") String name) {
        return farmaciaRepository.getFarmaciaByName(name);
    }

    @GetMapping(path = "/medicamento/name/{medicamento}")
    public @ResponseBody
    List<MedicamentoByName> getMedicamentoByName(@PathVariable("medicamento") String name) {
        return medicamentoRepository.getMedicamentoByName(name);
    }

    @GetMapping(path = "/medicamento/{id}")
    public @ResponseBody
    Optional<Medicamento> getMedicamentoById(@PathVariable("id") int idM) {
        return medicamentoRepository.findById(idM);
    }

    @GetMapping(path = "/obraSocial/{id}")
    public @ResponseBody
    Optional<ObraSocial> getObraSocialById(@PathVariable("id") int id_os) {
        return obraSocialRepository.findById(id_os);
    }

    @GetMapping(path = "/cliente/{id}")
    public @ResponseBody
    Optional<Cliente> getClienteById(@PathVariable("id") int id_cl) {
        return clienteRepository.findById(id_cl);
    }

   @PostMapping(path = "/cliente/create",
            consumes = "application/json", produces = "application/json")
    public Cliente createCliente(@RequestBody Cliente newCliente) {
        return clienteRepository.save(newCliente);
    }

    @PostMapping(path = "/farmacia/create",
            consumes = "application/json", produces = "application/json")
    public Farmacia createFarmacia(@RequestBody Farmacia newFarmacia) {
        return farmaciaRepository.save(newFarmacia);
    }

    @PostMapping(path = "/medicamento/create",
            consumes = "application/json", produces = "application/json")
    public Medicamento createMedicamento(@RequestBody Medicamento newMedicamento) {
        return medicamentoRepository.save(newMedicamento);
    }

    @PostMapping(path = "/obraSocial/create",
            consumes = "application/json", produces = "application/json")
    public ObraSocial createObraSocial(@RequestBody ObraSocial newObraSocial) {
        return obraSocialRepository.save(newObraSocial);
    }

    @PutMapping(path = "/farmacia/update",
            consumes = "application/json", produces = "application/json")
    public Farmacia updateFarmacia(@RequestBody Farmacia updateFarmacia) {
        return farmaciaRepository.save(updateFarmacia);
    }

    @PutMapping(path = "/medicamento/update",
            consumes = "application/json", produces = "application/json")
    public Medicamento updateMedicamento(@RequestBody Medicamento updateMedicamento) {
        return medicamentoRepository.save(updateMedicamento);
    }

    @PutMapping(path = "/obraSocial/update",
            consumes = "application/json", produces = "application/json")
    public ObraSocial updateObraSocial(@RequestBody ObraSocial updateObraSocial) {
        return obraSocialRepository.save(updateObraSocial);
    }

    @PutMapping(path = "/cliente/update",
            consumes = "application/json", produces = "application/json")
    public Cliente updateCliente(@RequestBody Cliente updateCliente) {
        return clienteRepository.save(updateCliente);
    }

    @DeleteMapping(path = "/farmacia/delete/{id}")
    public @ResponseBody
    Iterable<Farmacia> deleteFarmaciaById(@PathVariable("id") int id_f) {
        try {
            farmaciaRepository.deleteById(id_f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return farmaciaRepository.findAll();
        }

    }

    @DeleteMapping(path = "/medicamento/delete/{id}")
    public @ResponseBody
    Iterable<Medicamento> deleteMedicamentoById(@PathVariable("id") int id_m) {
        try {
            medicamentoRepository.deleteById(id_m);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return medicamentoRepository.findAll();
        }

    }

    @DeleteMapping(path = "/cliente/delete/{id}")
    public @ResponseBody
    Iterable<Cliente> deleteClienteById(@PathVariable("id") int id_ct) {
        try {
            clienteRepository.deleteById(id_ct);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return clienteRepository.findAll();
        }

    }

    @DeleteMapping(path = "/obraSocial/delete/{id}")
    public @ResponseBody
    Iterable<ObraSocial> deleteObraSocialById(@PathVariable("id") int id_o) {
        try {
            obraSocialRepository.deleteById(id_o);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return obraSocialRepository.findAll();
        }

    }

}
