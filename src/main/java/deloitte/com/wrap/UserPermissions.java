package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class UserPermissions {
	
	 @JacksonXmlProperty(localName = "name", isAttribute = false)
	    public String name;
	    @JacksonXmlProperty(localName = "enabled")
	    public String enabled;
	    public UserPermissions() {
	    }
	    public UserPermissions(String name, String enabled) {
	        this.name = name;
	        this.enabled = enabled;

	    }
		@Override
		public String toString() {
			return "UserPermissions [name=" + name + ", enabled=" + enabled + "]";
		}
	    

}
