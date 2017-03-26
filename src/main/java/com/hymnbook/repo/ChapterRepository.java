package com.hymnbook.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hymnbook.model.Chapter;

@Transactional
public interface ChapterRepository extends JpaRepository<Chapter, Long> {
	
	@Query(value="SELECT * FROM chapters c WHERE c.number = :number and c.book_type_id = :bookTypeId and c.deleted = false",nativeQuery=true)
	Chapter findChapterByNumber(@Param("number") String number,@Param("bookTypeId") Long bookTypeId);
	
	@Query(value="SELECT * FROM chapters c WHERE c.topic = :topic and c.book_type_id = :bookTypeId and c.deleted = false",nativeQuery=true)
	Chapter findChapterByTopic(@Param("topic") String topic, @Param("bookTypeId") Long bookTypeId);

	@Query(value="SELECT * FROM chapters c WHERE c.topic = :topic and c.book_type_id = :bookTypeId and c.deleted = false",nativeQuery=true)
	List<Chapter> findAllChapter(@Param("bookTypeId") Long bookTypeId);
}
