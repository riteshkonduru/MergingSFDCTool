package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class LoginHours {
	 @JacksonXmlProperty(localName = "weekdayStart", isAttribute = true)
	    public String weekdayStart;
	    @JacksonXmlProperty(localName = "weekdayEnd")
	    public String weekdayEnd;



}
