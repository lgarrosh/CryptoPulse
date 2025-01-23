package io.currencybot.currency_rate_bot.model.crb;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Currency {
	
    @JsonProperty("ID") 
    public String iD;
    
    @JsonProperty("NumCode") 
    public String numCode;
    
    @JsonProperty("CharCode") 
    public String charCode;
    
    @JsonProperty("Nominal") 
    public int nominal;
    
    @JsonProperty("Name") 
    public String name;
    
    @JsonProperty("Value") 
    public double value;
    
    @JsonProperty("Previous") 
    public double previous;

    
	public Currency() {
		super();
	}

	public Currency(String iD, String numCode, String charCode, int nominal, String name, double value,
			double previous) {
		super();
		this.iD = iD;
		this.numCode = numCode;
		this.charCode = charCode;
		this.nominal = nominal;
		this.name = name;
		this.value = value;
		this.previous = previous;
	}

	public String getiD() {
		return iD;
	}

	public String getNumCode() {
		return numCode;
	}

	public String getCharCode() {
		return charCode;
	}

	public int getNominal() {
		return nominal;
	}

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}

	public double getPrevious() {
		return previous;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}

	public void setCharCode(String charCode) {
		this.charCode = charCode;
	}

	public void setNominal(int nominal) {
		this.nominal = nominal;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setPrevious(double previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return "Currency [iD=" + iD + ", numCode=" + numCode + ", charCode=" + charCode + ", nominal=" + nominal
				+ ", name=" + name + ", value=" + value + ", previous=" + previous + "]";
	}
}
