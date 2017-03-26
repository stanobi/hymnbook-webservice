package com.hymnbook.controller.efik;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hymnbook.model.HymnBookRequest;
import com.hymnbook.model.HymnBookType;
import com.hymnbook.model.Verse;
import com.hymnbook.service.HymnBookTypeService;
import com.hymnbook.service.VerseService;

@RestController
@RequestMapping(value="/hymnbook")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private HymnBookTypeService bookTypeService;
	private VerseService verseService;
	
	@Autowired
	public HomeController(HymnBookTypeService bookTypeService,
			VerseService verseService) {
		
		this.bookTypeService = bookTypeService;
		this.verseService = verseService;
		
	}
	
	@RequestMapping(value="/verses", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Verse> getVerses(@RequestBody HymnBookRequest request){
		
		logger.info("Just Getting the Verses for request : {}", request);
		HymnBookType bookType = bookTypeService.getHymnBookByName(request.getHymnBookName());
		
		if(bookType != null){
			logger.info("Just found the booktype : {}", bookType);
			logger.info("Fetching the verses for chapter : {} for booktype : {}", request.getHymnBookNumber(), bookType);
			return verseService.getVersesByNumber(request.getHymnBookNumber(), bookType);
		}else{
			logger.info("booktype is NULL");
		}
		
		return new ArrayList<>();
	}

}
