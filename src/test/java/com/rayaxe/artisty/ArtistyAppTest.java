package com.rayaxe.artisty;

import com.rayaxe.artisty.domain.residentadvisor.DJ;
import com.rayaxe.artisty.services.MeltClient;
import com.rayaxe.artisty.services.ResidentAdvisorClient;
import com.rayaxe.artisty.services.SpotifyClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ArtistyApp.class)
public class ArtistyAppTest {

	private final static boolean DEBUG = false;

	@Resource
	MeltClient meltClient;

	@Resource
	SpotifyClient spotifyClient;

	@Resource
	ResidentAdvisorClient residentAdvisorClient;

	@Test
	public void testFindArtists() throws Exception {
		List<com.rayaxe.artisty.domain.Artist> artists = new ArrayList<>();

		int i = 0;
		for (com.rayaxe.artisty.domain.Artist artist : meltClient.getArtists()) {

			// Spotify
			List<com.rayaxe.artisty.domain.spotify.Artist> result = spotifyClient.searchArtist(artist.getName());
			if (result.size() > 0) {

				// TODO Melt! name and Spotify name should match!
				artist.setArtist(result.get(0));

				// I am not a robot
				Thread.sleep(250);
			}

			// Resident Advisor
			Optional<DJ> dj = residentAdvisorClient.matchDJ(artist);
			dj.ifPresent(d -> artist.setDJ(d));

			// Add artist to result
			artists.add(artist);

			// DEBUG
			i++;
			if (DEBUG && i==5) {
				break;
			}
		}

		// Print as CSV
		System.out.println(com.rayaxe.artisty.domain.Artist.getCsvHeader());
		artists.forEach(a -> System.out.println(a.getCsvRow()));

//		artists.stream()
//			.sorted((a1, a2) -> Integer.compare(a2.getFollowers().getTotal(), a1.getFollowers().getTotal()))
//			.collect(Collectors.toList())
//			.forEach(System.out::println);
	}

}
