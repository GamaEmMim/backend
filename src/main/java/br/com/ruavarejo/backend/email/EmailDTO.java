package br.com.ruavarejo.backend.email;

public class EmailDTO {
	private String From;
	
	private String To;
	
	private String Subject;
	
	private String ReplyTo;
	
	private String HtmlBody;
	
	public EmailDTO(){
	}

	public String getFrom() {
		return From;
	}

	public void setFrom(String from) {
		From = from;
	}

	public String getTo() {
		return To;
	}

	public void setTo(String to) {
		To = to;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getReplyTo() {
		return ReplyTo;
	}

	public void setReplyTo(String replyTo) {
		ReplyTo = replyTo;
	}

	public String getHtmlBody() {
		return HtmlBody;
	}

	public void setHtmlBody(String htmlBody) {
		HtmlBody = htmlBody;
	}
	
	
}
