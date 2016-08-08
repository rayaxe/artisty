package com.rayaxe.artisty.domain.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artists {

	public ArtistsResult artists;

	public ArtistsResult getArtists() {
		return artists;
	}

	public void setArtists(ArtistsResult artists) {
		this.artists = artists;
	}

	@Override
	public String toString() {
		return "Artists{" +
				"artists=" + artists +
				'}';
	}
}
