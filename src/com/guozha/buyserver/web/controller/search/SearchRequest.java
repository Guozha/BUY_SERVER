package com.guozha.buyserver.web.controller.search;

import com.guozha.buyserver.web.controller.CommonRequest;

public class SearchRequest extends CommonRequest{
    private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
