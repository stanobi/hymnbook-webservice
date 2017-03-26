package com.hymnbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hymnbook.model.Chapter;
import com.hymnbook.model.HymnBookType;
import com.hymnbook.repo.ChapterRepository;
import com.hymnbook.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService {

	private ChapterRepository chapterRepo;
	private static final Logger logger = LoggerFactory.getLogger(ChapterServiceImpl.class);

	@Autowired
	public ChapterServiceImpl(ChapterRepository chapterRepo) {
		this.chapterRepo = chapterRepo;
	}

	@Override
	public Chapter getChapterByNumber(String number, HymnBookType bookTypeId) {
		try {
			if (bookTypeId != null) {
				logger.info("Getting the chapter by number : {}", number);
				return chapterRepo.findChapterByNumber(number, bookTypeId.getId());
			}else{
				logger.info("bookType is NULL");
			}
		} catch (Exception e) {
			logger.error("Unable to get chapter by number : {} from booktype : {}",number, bookTypeId, e);
		}

		return null;
	}
	
	@Override
	public Chapter getChapterByTopic(String topic, HymnBookType bookTypeId) {
		try {
			if (bookTypeId != null) {
				logger.info("Getting the chapter by topic : {}", topic);
				return chapterRepo.findChapterByNumber(topic, bookTypeId.getId());
			}else{
				logger.info("bookType is NULL");
			}
		} catch (Exception e) {
			logger.error("Unable to get chapter by topic : {} from booktype : {}",topic, bookTypeId, e);
		}

		return null;
	}

	@Override
	public List<Chapter> getAllChapters(HymnBookType bookTypeId) {
		try {
			
			if(bookTypeId != null){
				logger.info("Getting All chapters");
				return chapterRepo.findAllChapter(bookTypeId.getId());
			}else{
				logger.info("booktype is NULL");
			}

		} catch (Exception e) {
			logger.error("Unable to get all chapters", e);
		}

		return new ArrayList<>();
	}

}
