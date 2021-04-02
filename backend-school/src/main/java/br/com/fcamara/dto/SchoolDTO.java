package br.com.fcamara.dto;

import br.com.fcamara.entity.SchoolEntity;
import br.com.fcamara.entity.enums.SchoolCategoryEnum;
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
public class SchoolDTO implements Serializable {

  private Long id;
  private String name;
  private SchoolCategoryEnum category;
  private Integer totalStudentsNeedingHelp;
//  private AddressDTO address;
//  private Set<StudentDTO> students = new HashSet<>();

  public SchoolDTO (SchoolEntity entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.category = entity.getCategory();
    this.totalStudentsNeedingHelp = entity.getTotalStudentsNeedingHelp();
  }
}
