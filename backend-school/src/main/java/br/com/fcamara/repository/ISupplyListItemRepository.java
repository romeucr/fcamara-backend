package br.com.fcamara.repository;

import br.com.fcamara.entity.StudentEntity;
import br.com.fcamara.entity.SupplyListItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISupplyListItemRepository extends JpaRepository<SupplyListItemEntity, Long> {

  @Modifying
  @Query(value = "DELETE FROM TB_SUPPLY_LIST_ITEM i WHERE i.supply_list_id = :id",
         nativeQuery = true)
  void deleteSupplyListItemBySupplyListId(@Param("id") Long id);
}