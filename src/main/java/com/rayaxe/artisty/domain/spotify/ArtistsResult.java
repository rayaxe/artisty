package com.rayaxe.artisty.domain.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistsResult {

	public String href;
	public List<Artist> items;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public List<Artist> getItems() {
		return items;
	}

	public void setItems(List<Artist> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ArtistsResult{" +
				"href='" + href + '\'' +
				", items=" + items +
				'}';
	}
}
