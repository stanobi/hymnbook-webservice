package com.hymnbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="chapters", uniqueConstraints={@UniqueConstraint(columnNames={"book_type_id", "number"})})
public class Chapter extends SuperTable {
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="book_type_id")
	private HymnBookType bookType;
	
	@Column(name="topic")
	private String topic;
	
	@Column(name="number")
	private String number;

	public HymnBookType getBookType() {
		return bookType;
	}

	public void setBookType(HymnBookType bookType) {
		this.bookType = bookType;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Chapter [bookType=");
		builder.append(bookType);
		builder.append(", topic=");
		builder.append(topic);
		builder.append(", number=");
		builder.append(number);
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
