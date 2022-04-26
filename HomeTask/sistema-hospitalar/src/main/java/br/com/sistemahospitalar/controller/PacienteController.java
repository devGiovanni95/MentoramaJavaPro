//package br.com.sistemahospitalar.controller;
//
//import br.com.sistemahospitalar.entities.PacienteEntity;
//import br.com.sistemahospitalar.repositories.PacienteRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/pacientes")
//public class PacienteController {
//
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
//
//
//}
