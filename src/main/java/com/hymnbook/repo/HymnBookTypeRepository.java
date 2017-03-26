package com.hymnbook.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hymnbook.model.HymnBookType;

@Transactional
public interface HymnBookTypeRepository extends JpaRepository<HymnBookType, Long> {
	
	@Query(value="SELECT * FROM hymn_book_types h WHERE h.name = :name and h.deleted = false",nativeQuery=true)
	HymnBookType findHymnBookByName(@Param("name") String name);
	
	@Query(value="SELECT * FROM hymn_book_types h WHERE h.deleted = false",nativeQuery=true)
	List<HymnBookType> findAllHymnBook();

}
