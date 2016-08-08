package com.rayaxe.artisty.domain.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {

	public String name;
	public String id;
	public String type;
	public String href;
	public String uri;
	public int popularity = -1;
	public Followers followers;
	public List<String> genres;
	public List<Image> images;
//	public String[] external_urls;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public Followers getFollowers() {
		return followers;
	}

	public void setFollowers(Followers followers) {
		this.followers = followers;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Artist{" +
				"followers=" + followers +
				", name='" + name + '\'' +
				", id='" + id + '\'' +
				", type='" + type + '\'' +
				", href='" + href + '\'' +
				", uri='" + uri + '\'' +
				", popularity=" + popularity +
				'}';
	}

}
