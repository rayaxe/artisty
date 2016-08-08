package com.rayaxe.artisty;

import com.rayaxe.artisty.domain.residentadvisor.DJ;
import com.rayaxe.artisty.domain.Artist;
import com.rayaxe.artisty.services.ResidentAdvisorClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ArtistyApp.class)
public class ResidentAdvisorClientTest {

	@Resource
	ResidentAdvisorClient residentAdvisorClient;

	@Test
	public void testGetDJs100() throws IOException {
		Artist artist = new Artist("Dixon", "");
		Optional<DJ> dj = residentAdvisorClient.matchDJ(artist);
		System.out.println(dj.get());
	}

}
