package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TabVisibilities {
	
	 @JacksonXmlProperty(localName = "visibility", isAttribute = false)
	    public String visibility;
	 @JacksonXmlProperty(localName = "tab", isAttribute = false)
	    public String tab;


}
