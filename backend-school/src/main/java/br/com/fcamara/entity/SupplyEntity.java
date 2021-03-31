package br.com.fcamara.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_supply")
public class SupplyEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Double avgPrice;
  private String unity;

  @OneToMany(mappedBy = "id.supply")
  private Set<SupplyListItemEntity> supplies = new HashSet<>();

  //retornando em uma lista os pedidos de um determinado produto
  public List<SupplyListEntity> getSupplyList() {
    List<SupplyListEntity> list = new ArrayList<>();
    for (SupplyListItemEntity x : supplies) {
      list.add(x.getSupplyListEntity());
    }
    return list;
  }
}
