package com.hymnbook.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hymnbook.model.Verse;

@Transactional
public interface VerseRepository extends JpaRepository<Verse, Long> {
	
	@Query(value="SELECT * FROM verses v WHERE v.chapter_id = (SELECT c.id FROM chapters c WHERE c.number = :number and c.book_type_id = :bookTypeId and c.deleted = false) ", nativeQuery=true)
	List<Verse> findVerseByChapterNumber(@Param("number") String chapterNumber,@Param("bookTypeId")Long hymnBookId);

	@Query(value="SELECT * FROM verses v WHERE v.chapter_id = (SELECT c.id FROM chapters c WHERE c.topic = :topic and c.book_type_id = :bookTypeId and c.deleted = false) ", nativeQuery=true)
	List<Verse> findVerseByChapterTopic(@Param("topic") String chapterTopic,@Param("bookTypeId") Long hymnBookId);
	
	@Query(value="SELECT * FROM verses v WHERE v.chapter_id in (SELECT c.id FROM chapters c WHERE c.book_type_id = :bookTypeId and c.deleted = false) ", nativeQuery=true)
	List<Verse> findVerse(@Param("bookTypeId") Long hymnBookId);
	
}
