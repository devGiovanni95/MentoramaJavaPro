package br.com.sistema.hospitalar.controller;

import br.com.sistema.hospitalar.entities.PacienteEntity;
import br.com.sistema.hospitalar.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/pacientes")
public class PacienteController {


    @Autowired
    private PacienteRepository pacienteRepository;

    @GetMapping
    public ResponseEntity<List<PacienteEntity>> findAll() {
       List<PacienteEntity> lista = pacienteRepository.findAll();
        return ResponseEntity.ok().body(lista);
    }
//
//    @GetMapping
//    @RequestMapping
//    public List<PacienteEntity> findAll() {
//                List<PacienteEntity> list = pacienteRepository.findAll();
//        return list;
//    }


//
//    @Autowired
//    private final PacienteRepository pacienteRepository;
//
//
//    public PacienteController(PacienteRepository pacienteRepository) {
//        this.pacienteRepository = pacienteRepository;
//    }
//
//    @GetMapping
//    public List<PacienteEntity> findAll(){
//        return this.pacienteRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public PacienteEntity findyById(@PathVariable("id") final  Long id){
//        return this.pacienteRepository.findById(id).orElse(null);
//    }
//
//    @PostMapping
//    public void createNew(@RequestBody final PacienteEntity paciente){
//        this.pacienteRepository.save(paciente);
//    }
//
//    @PutMapping
//    public void update(@RequestBody final PacienteEntity pacienteEntity){
//        this.pacienteRepository.save(pacienteEntity);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") final Long id){
//        this.pacienteRepository.deleteById(id);
//    }


}
