package br.com.fcamara.repository;

import br.com.fcamara.entity.SchoolEntity;
import br.com.fcamara.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStateRepository extends JpaRepository<StateEntity, Long> {

  public Optional<StateEntity> findByAcronymIgnoreCase(String acronym);
}
