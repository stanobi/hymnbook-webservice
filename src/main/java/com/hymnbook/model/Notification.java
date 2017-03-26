package com.hymnbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Notifications")
public class Notification extends SuperTable {
	
	@Column(name="message", columnDefinition="TEXT COMMENT 'This is the message to be displayed to user as notification'")
	private String message;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="book_type_id")
	private HymnBookType bookType;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HymnBookType getBookType() {
		return bookType;
	}
	
	public void setBookType(HymnBookType bookType) {
		this.bookType = bookType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notification [message=");
		builder.append(message);
		builder.append(", bookType=");
		builder.append(bookType);
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
