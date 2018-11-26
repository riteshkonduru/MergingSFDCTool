package deloitte.com.sfdcTool;

import java.util.Set;
/*
 * This Wrapper class is useful to hold meta-data Types like ClassAccess,PageAccess,userPermissions etc for profile.
 * 
 * */
public class MetadataRecWrapToUpdate {
	private String name;
	private Set<ProfileElements> metadataRecSet;
	private Set<ProfileElements> metadataRecSetToRemove;

	public String getNameType() {
		return name;
	}
	public void setNameType(String name) {
		this.name = name;
	}
	public Set<ProfileElements> getMetadataRecSet() {
		return metadataRecSet;
	}
	public void setMetadataRecSet(Set<ProfileElements> metadataRecSet) {
		this.metadataRecSet = metadataRecSet;
	}
	public Set<ProfileElements> getMetadataRecSetToRemove() {
		return metadataRecSetToRemove;
	}
	public void setMetadataRecSetToRemove(Set<ProfileElements> metadataRecSetToRemove) {
		this.metadataRecSetToRemove = metadataRecSetToRemove; 
	}

	@Override
	public String toString() {
		return "NameType:: Name=" + this.name  + " metadataRecSet=" + this.metadataRecSet +" metadataRecSetToRemove=" + this.metadataRecSetToRemove ;
	}

}
