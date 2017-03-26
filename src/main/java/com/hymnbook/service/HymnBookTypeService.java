package com.hymnbook.service;

import java.util.List;

import com.hymnbook.model.HymnBookType;

public interface HymnBookTypeService {
	
	HymnBookType getHymnBookByName(String name);
	
	List<HymnBookType> getAllHymnBook();

}
