package br.com.fcamara.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String street;
  private Integer number;
  private String complement;
  private String neighbourhood;
  private String zipCode;

  @ManyToOne
  @JoinColumn(name = "city_id")
  private CityEntity city;

  @OneToOne(mappedBy = "address")
  private SchoolEntity school;
}
