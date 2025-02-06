package io.currencybot.currency_rate_bot.model.coin_market_cap;

import java.util.Map;

public class RequestQuoteData {
	
	/*
	 * Объект криптовалюты для каждого запрошенного.
	 */
	private Map<String, RequestedCryptocurrency> data;
	
	/*
	 * 	Стандартизированный объект состояния для вызовов API.
	 */
	private Status status;
	
	
	
	
	
	public RequestQuoteData() {}

	public RequestQuoteData(Map<String, RequestedCryptocurrency> data, Status status) {
		this.data = data;
		this.status = status;
	}

	public Map<String, RequestedCryptocurrency> getData() {
		return data;
	}

	public Status getStatus() {
		return status;
	}

	public void setData(Map<String, RequestedCryptocurrency> data) {
		this.data = data;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RequestQuoteData\n"
				+ "		[data = " + data + "/n		status = " + status + "]";
	}
	
}
