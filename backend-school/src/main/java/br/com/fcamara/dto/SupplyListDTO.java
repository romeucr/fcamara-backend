package br.com.fcamara.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class SupplyListDTO implements Serializable {

  private Long Id;
  private Double listTotalValue;
  private Set<SupplyListItemDTO> supplies = new HashSet<>();
  private StudentDTO student;
}
