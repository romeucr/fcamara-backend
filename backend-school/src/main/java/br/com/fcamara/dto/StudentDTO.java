package br.com.fcamara.dto;

import br.com.fcamara.entity.enums.EducationLevelEnum;
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
public class StudentDTO implements Serializable {

  private Long id;
  private String name;
  private Integer age;
  private EducationLevelEnum educationLevel;
  private Integer educationLevelGrade;
  private String cpf;
  private SupplyListDTO supplyListId;
  private SchoolDTO school;
  private UserDTO responsible;
  private UserDTO donor;
}
