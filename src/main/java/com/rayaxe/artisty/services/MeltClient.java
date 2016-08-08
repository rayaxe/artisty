package com.rayaxe.artisty.services;

import com.rayaxe.artisty.domain.Artist;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeltClient {

	public List<Artist> getArtists() throws IOException {
		List<Artist> artists = new ArrayList<>();
		Document doc = Jsoup.connect("http://www.meltfestival.de/").get();
		Element lineup = doc.getElementById("lineupgrid");

		String day = "";
		for (Element child : lineup.children()) {

			if (child.hasClass("festival-weekday")) {
				day = child.text().substring(0, 2);
				continue;
			}

			// TODO live and DJ-Set should get a higher rating
			String name = child.select("span").html().replace(" (live)", "").replace(" (DJ-Set)", "").replace("&amp;", "&");

			artists.add(new Artist(name, day));
		}

		return artists;
	}

}
