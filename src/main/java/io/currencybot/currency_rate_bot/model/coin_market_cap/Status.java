package io.currencybot.currency_rate_bot.model.coin_market_cap;

public class Status {
	
	private String timestamp;
	
	private Integer error_code;
	
	private String error_message;
	
	private Integer elapsed;
	 
	private Integer credit_count;
	 
	private String notice;
	
	public Status() {}

	public String getTimestamp() {
		return timestamp;
	}

	public Integer getError_code() {
		return error_code;
	}

	public String getError_message() {
		return error_message;
	}

	public Integer getElapsed() {
		return elapsed;
	}

	public Integer getCredit_count() {
		return credit_count;
	}

	public String getNotice() {
		return notice;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public void setError_code(Integer inerror_code) {
		error_code = inerror_code;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public void setElapsed(Integer elapsed) {
		this.elapsed = elapsed;
	}

	public void setCredit_count(Integer credit_count) {
		this.credit_count = credit_count;
	}

	public void setNotice(String notic) {
		this.notice = notic;
	}

	@Override
	public String toString() {
		return "Status [timestamp=" + timestamp + ", Inerror_code=" + error_code + ", error_message=" + error_message
				+ ", elapsed=" + elapsed + ", credit_count=" + credit_count + ", notic=" + notice + "]";
	}
	
}
