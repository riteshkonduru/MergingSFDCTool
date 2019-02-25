package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PageAccesses {
	
    @JacksonXmlProperty(localName = "apexPage", isAttribute = false)
    public String apexPage;
    @JacksonXmlProperty(localName = "enabled")
    public String enabled;
    public PageAccesses() {
    }
    public PageAccesses(String apexPage, String enabled) {
        this.apexPage = apexPage;
        this.enabled = enabled;

    }
	@Override
	public String toString() {
		return "PageAccesses [apexPage=" + apexPage + ", enabled=" + enabled + "]";
	}
    

}
