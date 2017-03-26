package com.hymnbook.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hymnbook.model.HymnBookType;
import com.hymnbook.repo.HymnBookTypeRepository;
import com.hymnbook.service.HymnBookTypeService;

@Service
public class HymnBookTypeServiceImpl implements HymnBookTypeService {
	
	private HymnBookTypeRepository hymnBookRepo;
	private static final Logger logger = LoggerFactory.getLogger(HymnBookTypeServiceImpl.class);
	
	@Autowired
	public HymnBookTypeServiceImpl(HymnBookTypeRepository hymnBookRepo) {
		this.hymnBookRepo = hymnBookRepo;
	}

	@Override
	public HymnBookType getHymnBookByName(String name) {
		try {
			return hymnBookRepo.findHymnBookByName(name);
		} catch (Exception e) {
			logger.error("Unable to get Hymnbook by name : {} ", name, e);
		}
		
		return null;
	}

	@Override
	public List<HymnBookType> getAllHymnBook() {
		try {
			return hymnBookRepo.findAllHymnBook();
		} catch (Exception e) {
			logger.error("Unable to get All Hymnbook ", e);
		}
		
		return new ArrayList<>();
	}

}
