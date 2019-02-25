package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ProfileActionOverrides {
	
	 @JacksonXmlProperty(localName = "actionName", isAttribute = true)
	    public String actionName;
	    @JacksonXmlProperty(localName = "content")
	    public String content;
	    @JacksonXmlProperty(localName = "formFactor")
	    public String formFactor;
	    @JacksonXmlProperty(localName = "pageOrSobjectType")
	    public String pageOrSobjectType;
	    @JacksonXmlProperty(localName = "recordType")
	    public String recordType;
	    @JacksonXmlProperty(localName = "type")
	    public String type;

}
