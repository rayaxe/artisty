package com.rayaxe.artisty;

import com.rayaxe.artisty.services.SpotifyClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ArtistyApp.class)
public class SpotifyClientTest {

	@Resource
	SpotifyClient spotifyClient;

	@Test
	public void testGetArtist() throws Exception {
		System.out.println(spotifyClient.getArtist("5wJK4kQAkVGjqM9x46KQOC"));
	}

	@Test
	public void testSearchArtist() throws Exception {
		spotifyClient.searchArtist("Solomun").forEach(System.out::println);
	}

}
