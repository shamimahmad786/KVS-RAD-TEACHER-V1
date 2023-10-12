package com.example.MOERADTEACHER.common.uneecops.master.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.MOERADTEACHER.common.uneecops.master.eo.CategoryEo;
import com.example.MOERADTEACHER.common.uneecops.master.eo.RegionEo;
import com.example.MOERADTEACHER.common.uneecops.master.vo.CategoryMasterResVo;

@Repository
public interface CategoryMasterRepository extends JpaRepository<CategoryEo, Integer> {

	@Query("Select new com.example.MOERADTEACHER.common.uneecops.master.vo.CategoryMasterResVo"
			+ "(c.id, c.categoryName, c.isActive) from CategoryEo c where c.isActive = :status order by c.categoryName")
	List<CategoryMasterResVo> findCategoryNameAndId(@Param("status") Boolean status);

	@Query("Select new com.example.MOERADTEACHER.common.uneecops.master.vo.CategoryMasterResVo"
			+ "(c.id, c.categoryName, c.isActive) from CategoryEo c order by c.createdDate desc")
	List<CategoryMasterResVo> findListOfCategories();

	Optional<CategoryEo> findById(Integer id);

	List<CategoryEo> findAllByCategoryName(String categoryName);
	CategoryEo findCategoryNameById(Integer categoryId);

}
