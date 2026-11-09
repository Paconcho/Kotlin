package com.ejercicios.ejercicio05;

public class Fotos {
	int albumId;
	int id;
	String title;
	String url;
	String thumbnaiUrl;

	public Fotos(int albumId, int id, String title, String url, String thumbnaiUrl) {
		super();
		this.albumId = albumId;
		this.id = id;
		this.title = title;
		this.url = url;
		this.thumbnaiUrl = thumbnaiUrl;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnaiUrl() {
		return thumbnaiUrl;
	}

	public void setThumbnaiUrl(String thumbnaiUrl) {
		this.thumbnaiUrl = thumbnaiUrl;
	}

}
