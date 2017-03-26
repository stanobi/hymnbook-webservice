package com.hymnbook.model;

public class HymnBookRequest {
	
	private String hymnBookNumber;
	private String hymnBookName;

	public HymnBookRequest() {
	}

	public String getHymnBookNumber() {
		return hymnBookNumber;
	}

	public void setHymnBookNumber(String hymnBookNumber) {
		this.hymnBookNumber = hymnBookNumber;
	}

	public String getHymnBookName() {
		return hymnBookName;
	}

	public void setHymnBookName(String hymnBookName) {
		this.hymnBookName = hymnBookName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HymnBookRequest [hymnBookNumber=");
		builder.append(hymnBookNumber);
		builder.append(", hymnBookName=");
		builder.append(hymnBookName);
		builder.append("]");
		return builder.toString();
	}
	
	
}
