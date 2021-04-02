package br.com.fcamara.repository;

import br.com.fcamara.entity.CityEntity;
import br.com.fcamara.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<CityEntity, Long> {

}
