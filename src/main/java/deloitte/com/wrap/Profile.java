package deloitte.com.wrap;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Profile") public final class Profile {
	
	@JacksonXmlElementWrapper(localName = "classAccesses", useWrapping = false)
	public List<ClassAccesses> classAccesses; //Need
	
	@JacksonXmlElementWrapper(localName = "pageAccesses", useWrapping = false)
	public List<PageAccesses> pageAccesses; //Need
	
	@JacksonXmlElementWrapper(localName = "userPermissions", useWrapping = false)
	public List<UserPermissions> userPermissions; //Need
	
	//@JacksonXmlProperty(localName = "custom", isAttribute = false)
	//public boolean custom; 
	
	//@JacksonXmlProperty(localName = "userLicense", isAttribute = false)
	//public String userLicense; 
	
	//@JacksonXmlProperty(localName = "fullName", isAttribute = false)
	//public String fullName; 
	
	//@JacksonXmlProperty(localName = "description", isAttribute = false)
	//public String description; 
	
	@JacksonXmlElementWrapper(localName = "tabVisibilities", useWrapping = false)
	public List<TabVisibilities> tabVisibilities; //Need
	
	@JacksonXmlElementWrapper(localName = "recordTypeVisibilities", useWrapping = false)
	public List<RecordTypeVisibilities> recordTypeVisibilities; //Need
	
	//@JacksonXmlElementWrapper(localName = "profileActionOverrides", useWrapping = false)
	//public List<ProfileActionOverrides> profileActionOverrides;
	
	@JacksonXmlElementWrapper(localName = "objectPermissions", useWrapping = false)
	public List<ObjectPermissions> objectPermissions;//Need
	
	//@JacksonXmlElementWrapper(localName = "loginIpRanges", useWrapping = false)
	//public List<LoginIpRanges> loginIpRanges;
	
	//@JacksonXmlElementWrapper(localName = "loginHours", useWrapping = false)
	//public List<LoginHours> loginHours;
	
	@JacksonXmlElementWrapper(localName = "layoutAssignments", useWrapping = false)
	public List<LayoutAssignments> layoutAssignments;//Need
	
	@JacksonXmlElementWrapper(localName = "fieldPermissions", useWrapping = false)
	public List<FieldPermissions> fieldPermissions;//Need
	
	@JacksonXmlElementWrapper(localName = "fieldLevelSecurities", useWrapping = false)
	public List<FieldLevelSecurities> fieldLevelSecurities;//Need
	
	//@JacksonXmlElementWrapper(localName = "externalDataSourceAccesses", useWrapping = false)
	//public List<ExternalDataSourceAccesses> externalDataSourceAccesses;
	
	@JacksonXmlElementWrapper(localName = "customPermissions", useWrapping = false)
	public List<CustomPermissions> customPermissions;//Need
	

	//@JacksonXmlElementWrapper(localName = "categoryGroupVisibilities", useWrapping = false)
	//public List<CategoryGroupVisibilities> categoryGroupVisibilities;
	
	//@JacksonXmlElementWrapper(localName = "applicationVisibilities", useWrapping = false)
	//public List<ApplicationVisibilities> applicationVisibilities;

	public Profile() {

	}

	public Profile(List<ClassAccesses> classAccesses, List<PageAccesses> pageAccesses,
			List<UserPermissions> userPermissions, List<TabVisibilities> tabVisibilities,
			List<RecordTypeVisibilities> recordTypeVisibilities, List<ObjectPermissions> objectPermissions,
			List<LayoutAssignments> layoutAssignments, List<FieldPermissions> fieldPermissions,
			List<FieldLevelSecurities> fieldLevelSecurities, List<CustomPermissions> customPermissions) {
		super();
		this.classAccesses = classAccesses;
		this.pageAccesses = pageAccesses;
		this.userPermissions = userPermissions;
		this.tabVisibilities = tabVisibilities;
		this.recordTypeVisibilities = recordTypeVisibilities;
		this.objectPermissions = objectPermissions;
		this.layoutAssignments = layoutAssignments;
		this.fieldPermissions = fieldPermissions;
		this.fieldLevelSecurities = fieldLevelSecurities;
		this.customPermissions = customPermissions;
	}

	public List<ClassAccesses> getClassAccesses() {
		return classAccesses;
	}

	public void setClassAccesses(List<ClassAccesses> classAccesses) {
		this.classAccesses = classAccesses;
	}

	public List<PageAccesses> getPageAccesses() {
		return pageAccesses;
	}

	public void setPageAccesses(List<PageAccesses> pageAccesses) {
		this.pageAccesses = pageAccesses;
	}

	public List<UserPermissions> getUserPermissions() {
		return userPermissions;
	}

	public void setUserPermissions(List<UserPermissions> userPermissions) {
		this.userPermissions = userPermissions;
	}

	public List<TabVisibilities> getTabVisibilities() {
		return tabVisibilities;
	}

	public void setTabVisibilities(List<TabVisibilities> tabVisibilities) {
		this.tabVisibilities = tabVisibilities;
	}

	public List<RecordTypeVisibilities> getRecordTypeVisibilities() {
		return recordTypeVisibilities;
	}

	public void setRecordTypeVisibilities(List<RecordTypeVisibilities> recordTypeVisibilities) {
		this.recordTypeVisibilities = recordTypeVisibilities;
	}

	public List<ObjectPermissions> getObjectPermissions() {
		return objectPermissions;
	}

	public void setObjectPermissions(List<ObjectPermissions> objectPermissions) {
		this.objectPermissions = objectPermissions;
	}

	public List<LayoutAssignments> getLayoutAssignments() {
		return layoutAssignments;
	}

	public void setLayoutAssignments(List<LayoutAssignments> layoutAssignments) {
		this.layoutAssignments = layoutAssignments;
	}

	public List<FieldPermissions> getFieldPermissions() {
		return fieldPermissions;
	}

	public void setFieldPermissions(List<FieldPermissions> fieldPermissions) {
		this.fieldPermissions = fieldPermissions;
	}

	public List<FieldLevelSecurities> getFieldLevelSecurities() {
		return fieldLevelSecurities;
	}

	public void setFieldLevelSecurities(List<FieldLevelSecurities> fieldLevelSecurities) {
		this.fieldLevelSecurities = fieldLevelSecurities;
	}

	public List<CustomPermissions> getCustomPermissions() {
		return customPermissions;
	}

	public void setCustomPermissions(List<CustomPermissions> customPermissions) {
		this.customPermissions = customPermissions;
	}

	@Override
	public String toString() {
		return "Profile [classAccesses=" + classAccesses + ", pageAccesses=" + pageAccesses + ", userPermissions="
				+ userPermissions + ", tabVisibilities=" + tabVisibilities + ", recordTypeVisibilities="
				+ recordTypeVisibilities + ", objectPermissions=" + objectPermissions + ", layoutAssignments="
				+ layoutAssignments + ", fieldPermissions=" + fieldPermissions + ", fieldLevelSecurities="
				+ fieldLevelSecurities + ", customPermissions=" + customPermissions + "]";
	}	
}
