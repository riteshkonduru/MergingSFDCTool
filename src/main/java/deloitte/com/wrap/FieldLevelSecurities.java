package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FieldLevelSecurities {
	
	 @JacksonXmlProperty(localName = "field")
	    public String field;
	    @JacksonXmlProperty(localName = "editable")
	    public boolean editable;
	    @JacksonXmlProperty(localName = "hidden")
	    public boolean hidden;
	    @JacksonXmlProperty(localName = "readable")
	    public boolean readable;


}
