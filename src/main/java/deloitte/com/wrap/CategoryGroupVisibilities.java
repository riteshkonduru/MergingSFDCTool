package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CategoryGroupVisibilities {
	 @JacksonXmlProperty(localName = "dataCategoryGroup", isAttribute = true)
	    public String dataCategoryGroup;
	    @JacksonXmlProperty(localName = "visibility")
	    public String visibility;
	    @JacksonXmlProperty(localName = "dataCategories")
	    public String dataCategories;
	    //public String[] dataCategories;
	    
}
