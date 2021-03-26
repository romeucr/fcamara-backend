package br.com.fcamara.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_state")
public class StateEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String acronym;

  @OneToMany(mappedBy = "state")
  private List<CityEntity> cities = new ArrayList<>();

  public StateEntity(Long id, String name, String acronym) {
    this.id = id;
    this.name = name;
    this.acronym = acronym;
  }
}
