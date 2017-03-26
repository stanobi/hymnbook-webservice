package com.hymnbook.service;

import java.util.List;

import com.hymnbook.model.Chapter;
import com.hymnbook.model.HymnBookType;

public interface ChapterService {
	
	Chapter getChapterByNumber(String number, HymnBookType bookTypeId);
	
	Chapter getChapterByTopic(String topic, HymnBookType bookTypeId);
	
	List<Chapter> getAllChapters(HymnBookType bookTypeId);
	
}
