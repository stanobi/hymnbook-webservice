package com.hymnbook.service;

import com.hymnbook.model.HymnBookType;
import com.hymnbook.model.Notification;

public interface NotificationService {
	
	Notification getNotification(HymnBookType bookType);

}
