package com.hymnbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hymnbook.model.Notification;

@Transactional
public interface NotificationRepository extends JpaRepository<Notification, Long> {
	
	@Query(value="SELECT * FROM Notifications n WHERE n.book_type_id = :hymnbookId and n.deleted = false ", nativeQuery=true)
	Notification getNotification(@Param("hymnbookId") Long hymnbookId);

}
