package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ApplicationVisibilities {
	 @JacksonXmlProperty(localName = "application", isAttribute = true)
	    public String application;
	    @JacksonXmlProperty(localName = "default")//this is from xml tag
	    public boolean defaultTag;//TODO this is for json element
	    @JacksonXmlProperty(localName = "visible")
	    public boolean visible;
		public ApplicationVisibilities() {
			
		}
		public ApplicationVisibilities(String application, boolean defaultTag, boolean visible) {
			
			this.application = application;
			this.defaultTag = defaultTag;
			this.visible = visible;
		}
		@Override
		public String toString() {
			return "ApplicationVisibilities [application=" + application + ", defaultTag=" + defaultTag + ", visible="
					+ visible + "]";
		}
}
