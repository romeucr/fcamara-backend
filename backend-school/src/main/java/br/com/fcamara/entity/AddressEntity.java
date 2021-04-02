package br.com.fcamara.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
  private Double latitude;
  private Double longitude;

  @ManyToOne
  @JoinColumn(name = "city_id")
  private CityEntity city;

  @OneToOne(mappedBy = "address")
  private SchoolEntity school;

  @OneToOne(mappedBy = "address")
  private UserEntity user;
}
