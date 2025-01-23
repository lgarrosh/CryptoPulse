package io.currencybot.currency_rate_bot.model.coin_market_cap;

import java.util.Map;

public class RequestedCryptocurrency {
	
	/*
	 * Уникальный идентификатор CoinMarketCap для этой криптовалюты.
	 */
	private Integer id;
	
	private String name;
	 
	private String symbol;
	 
	private String slug;
	
	/*
	 * 1, если у этой криптовалюты есть хотя бы 1 активный рынок, который в данный момент отслеживается платформой, в противном случае 0. Значение 1 аналогично
	 */
	private Integer is_active;
	
	/*
	 * 
	 */
	private Integer is_fiat;
	
	/*
	 * Рейтинг CoinMarketCap криптовалюты по рыночной капитализации.
	 */
	private Integer cmc_rank;
	
	/*
	 * Количество активных торговых пар, доступных для данной криптовалюты на поддерживаемых биржах. 
	 */
	private Integer num_market_pairs;
	
	/*
	 * Приблизительное количество монет, находящихся в обращении для данной криптовалюты.
	 */
	private Double circulating_supply;
	
	/*
	 * Приблизительное общее количество монет, имеющихся в наличии на данный момент (за вычетом любых монет, которые были достоверно сожжены).
	 */
	private Double total_supply;
	
	private Double market_cap_by_total_supply;

	private Double max_supply;

	/*
	 * Временная метка (ISO 8601), когда эта криптовалюта была добавлена на CoinMarketCap.
	 */
	private String date_added;
	
	private String last_updated;

	private Double self_reported_circulating_supply;

	private Double self_reported_market_cap;
	 
	private Map<String, MarketQuote> quote;

	public RequestedCryptocurrency() {
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getSlug() {
		return slug;
	}

	public Integer getIs_active() {
		return is_active;
	}

	public Integer getIs_fiat() {
		return is_fiat;
	}

	public Integer getCmc_rank() {
		return cmc_rank;
	}

	public Integer getNum_market_pairs() {
		return num_market_pairs;
	}

	public Double getCirculating_supply() {
		return circulating_supply;
	}

	public Double getTotal_supply() {
		return total_supply;
	}

	public Double getMarket_cap_by_total_supply() {
		return market_cap_by_total_supply;
	}

	public Double getMax_supply() {
		return max_supply;
	}

	public String getDate_added() {
		return date_added;
	}

	public String getLast_updated() {
		return last_updated;
	}

	public Double getSelf_reported_circulating_supply() {
		return self_reported_circulating_supply;
	}

	public Double getSelf_reported_market_cap() {
		return self_reported_market_cap;
	}

	public Map<String, MarketQuote> getQuote() {
		return quote;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public void setIs_active(Integer is_active) {
		this.is_active = is_active;
	}

	public void setIs_fiat(Integer is_fiat) {
		this.is_fiat = is_fiat;
	}

	public void setCmc_rank(Integer cmc_rank) {
		this.cmc_rank = cmc_rank;
	}

	public void setNum_market_pairs(Integer num_market_pairs) {
		this.num_market_pairs = num_market_pairs;
	}

	public void setCirculating_supply(Double circulating_supply) {
		this.circulating_supply = circulating_supply;
	}

	public void setTotal_supply(Double total_supply) {
		this.total_supply = total_supply;
	}

	public void setMarket_cap_by_total_supply(Double market_cap_by_total_supply) {
		this.market_cap_by_total_supply = market_cap_by_total_supply;
	}

	public void setMax_supply(Double max_supply) {
		this.max_supply = max_supply;
	}

	public void setDate_added(String date_added) {
		this.date_added = date_added;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}

	public void setSelf_reported_circulating_supply(Double self_reported_circulating_supply) {
		this.self_reported_circulating_supply = self_reported_circulating_supply;
	}

	public void setSelf_reported_market_cap(Double self_reported_market_cap) {
		this.self_reported_market_cap = self_reported_market_cap;
	}

	public void setQuote(Map<String, MarketQuote> quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "RequestedCryptocurrency [id=" + id + ", name=" + name + ", symbol=" + symbol + ", slug=" + slug
				+ ", quote=" + quote + "]";
	}
	
}
