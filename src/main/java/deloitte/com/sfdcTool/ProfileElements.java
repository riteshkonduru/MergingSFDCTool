package deloitte.com.sfdcTool;
/*
 * This Wrapper class is useful to hold meta-data Records for profile.
 * 
 * */
public class ProfileElements {

    private String name;
    private String enabled;
    private String preparedKey;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEnabled() {
        return enabled;
    }
    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }
    public String getPreparedKey() {
        return preparedKey;
    }
    public void setPreparedKey(String preparedKey) {
        this.preparedKey = preparedKey; //name-enabled
    }

    @Override
    public String toString() {
        return "Profile:: Name=" + this.name  + " Enabled=" + this.enabled +" PreparedKey=" + this.preparedKey ;
    }
    
}
