package br.com.fcamara.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_supply_list")
public class SupplyListEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Double listTotalValue;

  @OneToMany(mappedBy = "id.supplyList")
  private Set<SupplyListItemEntity> supplies = new HashSet<>();

  @OneToOne
  @JoinColumn(name = "student_id")
  private StudentEntity student;
}
