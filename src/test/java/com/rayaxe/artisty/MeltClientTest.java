package com.rayaxe.artisty;

import com.rayaxe.artisty.services.MeltClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ArtistyApp.class)
public class MeltClientTest {

	@Resource
	MeltClient meltClient;

	@Test
	public void testGetArtists() throws IOException {
		meltClient.getArtists();
	}

}
