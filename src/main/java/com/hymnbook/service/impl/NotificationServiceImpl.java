package com.hymnbook.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hymnbook.model.HymnBookType;
import com.hymnbook.model.Notification;
import com.hymnbook.repo.NotificationRepository;
import com.hymnbook.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	private NotificationRepository notificationRepo;
	private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);
	
	@Autowired
	public NotificationServiceImpl(NotificationRepository notificationRepo) {
		this.notificationRepo = notificationRepo;
	}
	
	@Override
	public Notification getNotification(HymnBookType bookType) {
		try {
			if(bookType != null){
				logger.info("Getting Notification");
				return notificationRepo.getNotification(bookType.getId());
			}else{
				logger.info("book Type is Null");
			}
		} catch (Exception e) {
			logger.error("Unable to get notification for : {} ", bookType, e);
		}
		
		return null;
	}

}
