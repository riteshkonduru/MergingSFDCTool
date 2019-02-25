package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CustomPermissions {
	
	 @JacksonXmlProperty(localName = "name")
	    public String name;
	    @JacksonXmlProperty(localName = "enabled")
	    public boolean enabled;

}
