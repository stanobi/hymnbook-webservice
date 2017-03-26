package com.hymnbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hymnbook.model.HymnBookType;
import com.hymnbook.model.Verse;
import com.hymnbook.repo.VerseRepository;
import com.hymnbook.service.VerseService;

@Service
public class VerseServiceImpl implements VerseService {
	
	private VerseRepository verseRepo;
	private static final Logger logger = LoggerFactory.getLogger(VerseServiceImpl.class);
	
	@Autowired
	public VerseServiceImpl(VerseRepository verseRepo) {
		this.verseRepo = verseRepo;
	}

	@Override
	public List<Verse> getVersesByNumber(String chapterNumber, HymnBookType bookType) {
		try {
			if(bookType != null){
				logger.info("Getting Verse by chapter Number : {} for hymnbookId : {}", chapterNumber, bookType.getId());
				return verseRepo.findVerseByChapterNumber(chapterNumber, bookType.getId());
			}else{
				logger.info("Booktype is NULL");
			}
		} catch (Exception e) {
			logger.error("Unable to get verse by chapter number");
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<Verse> getVersesByTopic(String chapterTopic, HymnBookType bookType) {
		try {
			if(bookType != null){
				logger.info("Getting Verse by chapter topic : {} for hymnbookId : {}", chapterTopic, bookType.getId());
				return verseRepo.findVerseByChapterTopic(chapterTopic, bookType.getId());
			}else{
				logger.info("Booktype is NULL");
			}
		} catch (Exception e) {
			logger.error("Unable to get verse by chapter topic");
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<Verse> getAllVerses(HymnBookType bookType) {
		try {
			if(bookType != null){
				logger.info("Getting All Verses for hymnbookId : {}", bookType.getId());
				return verseRepo.findVerse(bookType.getId());
			}else{
				logger.info("Booktype is NULL");
			}
		} catch (Exception e) {
			logger.error("Unable to get All verses");
		}
		
		return new ArrayList<>();
	}

}
