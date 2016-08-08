package com.rayaxe.artisty.services;

import com.rayaxe.artisty.domain.residentadvisor.DJ;
import com.rayaxe.artisty.domain.Artist;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResidentAdvisorClient {

	public static final String url = "https://www.residentadvisor.net";

	Map<String, DJ> djs = new HashMap();

	@PostConstruct
	public void init() throws IOException {
		initDJs();
		updateRanks();
	}

	private void initDJs() throws IOException {
		Document doc = Jsoup.connect(url + "/dj.aspx").get();
		doc.getElementsByClass("content").first()
				.select("div.fl")
				.select("span:has(a)")
				.forEach(span -> span.select("a")
						.forEach(a -> djs.put(a.text().toLowerCase(), new DJ(a.text(), a.attr("href")))));
	}

	private void updateRanks() throws IOException {
		// Map with field `href` as key
		Map<String, DJ> tmp = djs.values().stream().collect(Collectors.toMap(v -> v.getHref(), v -> v));

		Document doc = Jsoup.connect(url + "/dj-100.aspx").get();
		doc.getElementsByClass("content").first()
				.select("ul.polls").first()
				.select("ul")
				.forEach(ul -> Optional.of(tmp.get(ul.select("a").first().attr("href")))
						.ifPresent(dj -> dj.setRank(Integer.parseInt(ul.select("li.number").first().text().replaceAll("\\D+","")))));
	}

	private void updateFavourites(DJ dj) {
		Document doc = null;
		try {
			doc = Jsoup.connect(url + dj.getHref()).get();
		} catch (IOException e) {
			System.out.println(e);
		}
		int favourites = Integer.parseInt(doc.getElementById("MembersFavouriteCount").text().replaceAll("\\D+",""));
		dj.setFavourites(favourites);
	}

	public Optional<DJ> matchDJ(Artist artist) {
		String key = "" + artist.getName();
		Optional<DJ> o = Optional.ofNullable(djs.get(key.toLowerCase()));
		o.ifPresent(dj -> updateFavourites(dj));

		return o;
	}

}
