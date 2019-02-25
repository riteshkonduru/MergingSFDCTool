package deloitte.com.wrap;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public final class ClassAccesses {
    @JacksonXmlProperty(localName = "apexClass")
    public String apexClass;
    @JacksonXmlProperty(localName = "enabled")
    public String enabled;
    public ClassAccesses() {
    }
    public ClassAccesses(String apexClass, String enabled) {
        this.apexClass = apexClass;
        this.enabled = enabled;
    }
	@Override
	public String toString() {
		return "ClassAccesses [apexClass=" + apexClass + ", enabled=" + enabled + "]";
	}
}
