package com.desafiolatam.test.DTO;

public class PoemaDTO {
	private String title;
	private String content;
	private PoetaDTO poet;
	public PoetaDTO getPoet() {
		return poet;
	}
	public void setPoet(PoetaDTO poet) {
		this.poet = poet;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
