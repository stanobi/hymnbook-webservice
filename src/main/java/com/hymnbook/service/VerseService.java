package com.hymnbook.service;

import java.util.List;

import com.hymnbook.model.HymnBookType;
import com.hymnbook.model.Verse;

public interface VerseService {
	
	List<Verse> getVersesByNumber(String chapterNumber, HymnBookType bookType);
	
	List<Verse> getVersesByTopic(String chapterNumber, HymnBookType bookType);
	
	List<Verse> getAllVerses(HymnBookType bookType);

}
