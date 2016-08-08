package com.rayaxe.artisty.domain.residentadvisor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DJ {

	public String name;
	public String href;
	public int rank = -1;
	public int favourites = -1;

	public DJ(String name, String href) {
		this.name = name;
		this.href = href;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getFavourites() {
		return favourites;
	}

	public void setFavourites(int favourites) {
		this.favourites = favourites;
	}

	@Override
	public String toString() {
		return "DJ{" +
				"name='" + name + '\'' +
				", href='" + href + '\'' +
				", rank=" + rank +
				", favourites=" + favourites +
				'}';
	}

}
