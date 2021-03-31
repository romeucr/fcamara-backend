package br.com.fcamara.entity.PK;

import br.com.fcamara.entity.SupplyEntity;
import br.com.fcamara.entity.SupplyListEntity;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class SupplyListItemPK implements Serializable {

  @ManyToOne
  @JoinColumn(name = "supply_list_id")
  private SupplyListEntity supplyList;

  @ManyToOne
  @JoinColumn(name = "supply_id")
  private SupplyEntity supply;

}
