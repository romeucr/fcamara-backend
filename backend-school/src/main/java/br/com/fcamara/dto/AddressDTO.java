package br.com.fcamara.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class AddressDTO implements Serializable {

  private Long id;
  private String street;
  private Integer number;
  private String complement;
  private String neighbourhood;
  private String zipCode;
  private Double latitude;
  private Double longitude;
  private CityDTO city;
  private SchoolDTO school;
  private UserDTO user;
}
