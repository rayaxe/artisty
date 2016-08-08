package com.rayaxe.artisty.services;

import com.rayaxe.artisty.domain.spotify.Artist;
import com.rayaxe.artisty.domain.spotify.Artists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.List;

@Service
public class SpotifyClient {

	@Autowired
	RestTemplate restTemplate;

	public final static String url = "https://api.spotify.com/v1/search?q={name}&type=artist";

	public Artist getArtist(String id) {
		URI uri = URI.create("https://api.spotify.com/v1/artists/" + id);
		return restTemplate.getForObject(uri, Artist.class);
	}

	public List<Artist> searchArtist(String name) {
		URI uri = new UriTemplate(url).expand(name);
		Artists artists = restTemplate.getForObject(uri, Artists.class);
		return artists.getArtists().getItems();
	}

}
