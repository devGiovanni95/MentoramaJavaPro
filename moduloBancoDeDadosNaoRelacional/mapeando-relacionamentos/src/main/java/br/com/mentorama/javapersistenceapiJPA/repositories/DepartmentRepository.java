package br.com.mentorama.javapersistenceapiJPA.repositories;

import br.com.mentorama.javapersistenceapiJPA.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
