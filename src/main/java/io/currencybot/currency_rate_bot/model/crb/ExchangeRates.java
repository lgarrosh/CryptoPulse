package io.currencybot.currency_rate_bot.model.crb;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeRates {
	
	@JsonProperty("Date")
    private String date;

    @JsonProperty("PreviousDate")
    private String previousDate;

    @JsonProperty("PreviousURL")
    private String previousURL;

    @JsonProperty("Timestamp")
    private String timestamp;

    @JsonProperty("Valute")
    private Map<String, Currency> valute;
    
    
    public ExchangeRates() {}


	public ExchangeRates(String date, String previousDate, String previousURL, String timestamp,
			Map<String, Currency> valute) {
		super();
		this.date = date;
		this.previousDate = previousDate;
		this.previousURL = previousURL;
		this.timestamp = timestamp;
		this.valute = valute;
	}


	public String getDate() {
		return date;
	}


	public String getPreviousDate() {
		return previousDate;
	}


	public String getPreviousURL() {
		return previousURL;
	}


	public String getTimestamp() {
		return timestamp;
	}


	public Map<String, Currency> getValute() {
		return valute;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setPreviousDate(String previousDate) {
		this.previousDate = previousDate;
	}


	public void setPreviousURL(String previousURL) {
		this.previousURL = previousURL;
	}


	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	public void setValute(Map<String, Currency> valute) {
		this.valute = valute;
	}

	@Override
	public String toString() {
		return "ExchangeRates [date=" + date + ",\n previousDate=" + previousDate + ",\n previousURL=" + previousURL
				+ ",\n timestamp=" + timestamp + ",\n valute=" + valute + "]";
	}
    
    
}
