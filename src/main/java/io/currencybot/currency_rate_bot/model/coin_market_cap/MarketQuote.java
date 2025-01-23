package io.currencybot.currency_rate_bot.model.coin_market_cap;

public class MarketQuote {
	
	private Double price;
	
	/*
	 * Откорректированный объем за 24 часа в указанной валюте.
	 */
	private Double volume_24h;
	
	/*
	 * изменение объема указанных валют за 24 часа.
	 */
	private Double volume_change_24h;
	
	/*
	 * Объем, о котором сообщается за 24 часа, в указанной валюте. Это поле возвращается только при запросе через параметр дополнительного запроса.
	 */
	private Double volume_24h_reported;
	
	/*
	 * Скорректированный объем за 7 дней в указанной валюте. Это поле возвращается только при запросе через параметр дополнительного запроса.
	 */
	private Double volume_7d;
	
	/*
	 * Отчетный объем за 7 дней в указанной валюте. Это поле возвращается только при запросе через параметр дополнительного запроса.
	 */
	private Double volume_7d_reported;
	
	/*
	 * Постоянный скорректированный объем за 30 дней в указанной валюте. Это поле возвращается только при запросе через параметр дополнительного запроса.
	 */
	private Double volume_30d;
	
	/*
	 * Объем, о котором сообщается за 30 дней, в указанной валюте. Это поле возвращается только при запросе через параметр дополнительного запроса.
	 */
	private Double volume_30d_reported;
	
	/*
	 * Рыночная капитализация в указанной валюте.
	 */
	private Double market_cap;
	
	private Double market_cap_dominance;
	
	private Double fully_diluted_market_cap;
	
	/*
	 * обмен за 1 час в указанной валюте.
	 */
	private Double percent_change_1h;
	
	/*
	 * обмен за 24 час в указанной валюте.
	 */
	private Double percent_change_24h;
	
	/*
	 * обмен за 7 дней в указанной валюте.
	 */
	private Double percent_change_7d;
	/*
	 * обмен за 30 дней в указанной валюте.
	 */
	private Double percent_change_30d;
	
	private String last_updated;

	public MarketQuote() {}

	public Double getPrice() {
		return price;
	}

	public Double getVolume_24h() {
		return volume_24h;
	}

	public Double getVolume_change_24h() {
		return volume_change_24h;
	}

	public Double getVolume_24h_reported() {
		return volume_24h_reported;
	}

	public Double getVolume_7d() {
		return volume_7d;
	}

	public Double getVolume_7d_reported() {
		return volume_7d_reported;
	}

	public Double getVolume_30d() {
		return volume_30d;
	}

	public Double getVolume_30d_reported() {
		return volume_30d_reported;
	}

	public Double getMarket_cap() {
		return market_cap;
	}

	public Double getMarket_cap_dominance() {
		return market_cap_dominance;
	}

	public Double getFully_diluted_market_cap() {
		return fully_diluted_market_cap;
	}

	public Double getPercent_change_1h() {
		return percent_change_1h;
	}

	public Double getPercent_change_24h() {
		return percent_change_24h;
	}

	public Double getPercent_change_7d() {
		return percent_change_7d;
	}

	public Double getPercent_change_30d() {
		return percent_change_30d;
	}

	public String getLast_updated() {
		return last_updated;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setVolume_24h(Double volume_24h) {
		this.volume_24h = volume_24h;
	}

	public void setVolume_change_24h(Double volume_change_24h) {
		this.volume_change_24h = volume_change_24h;
	}

	public void setVolume_24h_reported(Double volume_24h_reported) {
		this.volume_24h_reported = volume_24h_reported;
	}

	public void setVolume_7d(Double volume_7d) {
		this.volume_7d = volume_7d;
	}

	public void setVolume_7d_reported(Double volume_7d_reported) {
		this.volume_7d_reported = volume_7d_reported;
	}

	public void setVolume_30d(Double volume_30d) {
		this.volume_30d = volume_30d;
	}

	public void setVolume_30d_reported(Double volume_30d_reported) {
		this.volume_30d_reported = volume_30d_reported;
	}

	public void setMarket_cap(Double market_cap) {
		this.market_cap = market_cap;
	}

	public void setMarket_cap_dominance(Double market_cap_dominance) {
		this.market_cap_dominance = market_cap_dominance;
	}

	public void setFully_diluted_market_cap(Double fully_diluted_market_cap) {
		this.fully_diluted_market_cap = fully_diluted_market_cap;
	}

	public void setPercent_change_1h(Double percent_change_1h) {
		this.percent_change_1h = percent_change_1h;
	}

	public void setPercent_change_24h(Double percent_change_24h) {
		this.percent_change_24h = percent_change_24h;
	}

	public void setPercent_change_7d(Double percent_change_7d) {
		this.percent_change_7d = percent_change_7d;
	}

	public void setPercent_change_30d(Double percent_change_30d) {
		this.percent_change_30d = percent_change_30d;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}

	@Override
	public String toString() {
		return "MarketQuote [price=" + price + ", volume_24h=" + volume_24h + ", volume_7d=" + volume_7d
				+ ", volume_30d=" + volume_30d + "]";
	}
	
}
