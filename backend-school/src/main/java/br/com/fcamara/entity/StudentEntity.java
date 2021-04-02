package br.com.fcamara.entity;

import br.com.fcamara.entity.enums.EducationLevelEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_student")
public class StudentEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Integer age;
  private EducationLevelEnum educationLevel;
  private Integer educationLevelGrade;
  private String cpf;

  @OneToOne(mappedBy = "student")
  private SupplyListEntity supplyListId;

  @ManyToOne
  @JoinColumn(name = "school_id")
  private SchoolEntity school;

  @ManyToOne
  @JoinColumn(name = "responsible_id")
  private UserEntity responsible;

  @ManyToOne
  @JoinColumn(name = "donor_id")
  private UserEntity donor;


}
