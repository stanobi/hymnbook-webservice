package com.hymnbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="hymn_book_types")
public class HymnBookType extends SuperTable {

	@Column(name="name", columnDefinition="VARCHAR(250) COMMENT 'The name of the hymn book eg Efik , Catholic '")
	private String name;
	
	@Column(name="totalChapters")
	private int totalChapters;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalChapters() {
		return totalChapters;
	}

	public void setTotalChapters(int totalChapters) {
		this.totalChapters = totalChapters;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HymnBookType [name=");
		builder.append(name);
		builder.append(", totalChapters=");
		builder.append(totalChapters);
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
