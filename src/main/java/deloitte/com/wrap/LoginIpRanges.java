package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class LoginIpRanges {
	 @JacksonXmlProperty(localName = "description", isAttribute = true)
	    public String description;
	    @JacksonXmlProperty(localName = "endAddress")
	    public String endAddress;
	    @JacksonXmlProperty(localName = "startAddress")
	    public String startAddress;

}
