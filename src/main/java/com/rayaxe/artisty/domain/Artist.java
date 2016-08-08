package com.rayaxe.artisty.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rayaxe.artisty.domain.residentadvisor.DJ;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {

	public String name;
	public String day;

	// Spotify
	public com.rayaxe.artisty.domain.spotify.Artist artist;

	// Resident Advisor
	public DJ dj;

	public Artist(String name, String day) {
		this.name = name;
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public com.rayaxe.artisty.domain.spotify.Artist getArtist() {
		return artist;
	}

	public void setArtist(com.rayaxe.artisty.domain.spotify.Artist artist) {
		this.artist = artist;
	}

	public DJ getDJ() {
		return dj;
	}

	public void setDJ(DJ dj) {
		this.dj = dj;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{'");
		sb.append(name);

		if (artist != null) {
			sb.append("', popularity=");
			sb.append(artist.getPopularity());
			sb.append(", followers=");
			sb.append(artist.getFollowers().getTotal());
		}

		if (dj != null) {
			if (dj.getFavourites() > 0) {
				sb.append(", favourites=");
				sb.append(dj.getFavourites());
			}
			if (dj.getRank() > 0) {
				sb.append(", rank=");
				sb.append(dj.getRank());
			}
		}

		sb.append('}');

		return sb.toString();
	}

	public static String getCsvHeader() {
		return "Day;###;Name;Popularity;Followers;Favourites;Rank";
	}

	public String getCsvRow() {
		return new StringBuilder()
				.append(day).append(';')
				.append(getPrestige()).append(';')
				.append(name).append(';')
				.append(artist == null ? "-1" : artist.getPopularity()).append(';')
				.append(artist == null ? "-1" : artist.getFollowers().getTotal()).append(';')
				.append(dj == null ? "-1" : dj.getFavourites()).append(';')
				.append(dj == null ? "-1" : dj.getRank())
				.toString();
	}

	public String getPrestige() {
		int popularity = artist == null ? -1 : artist.getPopularity();
		int followers = artist == null ? -1 : artist.getFollowers().getTotal();
		int favourites = dj == null ? -1 : dj.getFavourites();
		int rank = dj == null ? -1 :  dj.getRank();

		if (artist == null && dj == null)
			return "E?";

		if (popularity > 60 || followers > 100000 || favourites > 10000 || rank > 0)
			return "A";

		if (popularity > 50 || followers > 30000 || favourites > 5000)
			return "B";

		if (popularity > 40 || followers > 10000 || favourites > 2500)
			return "C";

		return "D";
	}

}
