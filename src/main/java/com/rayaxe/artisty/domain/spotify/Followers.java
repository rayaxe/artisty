package com.rayaxe.artisty.domain.spotify;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Followers {

	public String href;
	public int total = -1;

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Followers{" +
				"href='" + href + '\'' +
				", total=" + total +
				'}';
	}
}
