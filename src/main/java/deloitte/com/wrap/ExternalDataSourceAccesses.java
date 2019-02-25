package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ExternalDataSourceAccesses {
	
	 @JacksonXmlProperty(localName = "externalDataSource", isAttribute = true)
	    public String externalDataSource;
	    @JacksonXmlProperty(localName = "enabled")
	    public boolean enabled;

}
