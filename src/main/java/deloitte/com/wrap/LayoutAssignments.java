package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class LayoutAssignments {
	
	 @JacksonXmlProperty(localName = "layout")
	    public String layout;
	    @JacksonXmlProperty(localName = "recordType")
	    public String recordType;
	   
}
