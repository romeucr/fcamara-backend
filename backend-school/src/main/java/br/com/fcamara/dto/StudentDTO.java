package br.com.fcamara.dto;

import br.com.fcamara.entity.StudentEntity;
import br.com.fcamara.entity.enums.EducationLevelEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class StudentDTO implements Serializable {

  private Long id;
  private String fullName;
  private Integer age;
  private EducationLevelEnum educationLevel;
  private Integer educationLevelGrade;
  private String cpf;
  private SchoolDTO school;
  private UserDTO responsible;
  private UserDTO donor;
  private Long supplyListId;

  public StudentDTO(StudentEntity entity) {
    this.id = entity.getId();
    this.fullName = entity.getName();
    this.age = entity.getAge();
    this.educationLevel = entity.getEducationLevel();
    this.educationLevelGrade = entity.getEducationLevelGrade();
    this.cpf = entity.getCpf();
    this.school = new SchoolDTO(entity.getSchool());
    this.responsible = new UserDTO(entity.getResponsible());
    this.donor = new UserDTO(entity.getDonor());
    this.supplyListId = entity.getSupplyList().getId();

  }
}
