package com.hymnbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="verses", uniqueConstraints={@UniqueConstraint(columnNames={"chapter_id", "number"})})
public class Verse extends SuperTable{
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="chapter_id")
	private Chapter chapter;
	
	@Column(name="number")
	private String number;
	
	@Column(name="english_verse", columnDefinition="TEXT COMMENT 'hymn book verse in english language'")
	private String englishVerse;
	
	@Column(name="efik_verse", columnDefinition="TEXT COMMENT 'hymn book verse in efik language'")
	private String efikVerse;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public String getEnglishVerse() {
		return englishVerse;
	}

	public void setEnglishVerse(String englishVerse) {
		this.englishVerse = englishVerse;
	}

	public String getEfikVerse() {
		return efikVerse;
	}

	public void setEfikVerse(String efikVerse) {
		this.efikVerse = efikVerse;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Verse [chapter=");
		builder.append(chapter);
		builder.append(", number=");
		builder.append(number);
		builder.append(", englishVerse=");
		builder.append(englishVerse);
		builder.append(", efikVerse=");
		builder.append(efikVerse);
		builder.append(", now=");
		builder.append(now);
		builder.append(", id=");
		builder.append(id);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", updatedAt=");
		builder.append(updatedAt);
		builder.append("]");
		return builder.toString();
	}
	
}
