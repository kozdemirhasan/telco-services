package com.telco.operator.telcoservices.util;

import java.util.List;

public class RestListMessage<T> {

	int currentPage;
	long totalElements;
	int totalPages;
	List<T> content;

	public RestListMessage() {
	}

	public RestListMessage(int currentPage, int totalElements, int totalPages, List<T> content) {
		this.currentPage = currentPage;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.content = content;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "RestListMessage [currentPage=" + currentPage + ", totalElements=" + totalElements + ", totalPages="
				+ totalPages + ", content=" + content + "]";
	}
}
