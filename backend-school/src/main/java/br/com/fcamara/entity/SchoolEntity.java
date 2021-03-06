package br.com.fcamara.entity;

import br.com.fcamara.entity.enums.SchoolCategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tb_school")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private SchoolCategoryEnum category;
  private Integer totalStudentsNeedingHelp;

  @OneToOne
  @JoinColumn(name = "address_id")
  private AddressEntity address;

}
