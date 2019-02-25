package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ObjectPermissions {
	
	 @JacksonXmlProperty(localName = "object")
	    public String object;
	    @JacksonXmlProperty(localName = "allowCreate")
	    public boolean allowCreate;
	    @JacksonXmlProperty(localName = "allowDelete")
	    public boolean allowDelete;
	    @JacksonXmlProperty(localName = "allowEdit")
	    public boolean allowEdit;
	    @JacksonXmlProperty(localName = "allowRead")
	    public boolean allowRead;
	    @JacksonXmlProperty(localName = "modifyAllRecords")
	    public boolean modifyAllRecords; 
	    @JacksonXmlProperty(localName = "viewAllRecords")
	    public boolean viewAllRecords;

}
