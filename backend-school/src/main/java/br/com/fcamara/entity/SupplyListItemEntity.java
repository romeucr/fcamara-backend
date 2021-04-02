package br.com.fcamara.entity;

import br.com.fcamara.entity.PK.SupplyListItemPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_supply_list_item")
public class SupplyListItemEntity implements Serializable {

  //a chave privada é uma chave composta. Para isso foi criada a classe SupplyListItemPK que contém as duas
  //chaves extrangeiras
  @EmbeddedId
  private SupplyListItemPK id = new SupplyListItemPK();

  private Integer quantity;
  private Double price;

  public SupplyListItemEntity(SupplyEntity supply, SupplyListEntity supplyList, Integer quantity, Double price) {
    id.setSupplyList(supplyList);
    id.setSupply(supply);
    this.quantity = quantity;
    this.price = price;
  }

  public SupplyEntity getSupplyEntity() {
    return id.getSupply();
  }

  public SupplyListEntity getSupplyListEntity() {
    return id.getSupplyList();
  }
}
