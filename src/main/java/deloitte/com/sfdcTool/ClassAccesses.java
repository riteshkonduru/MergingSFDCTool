package deloitte.com.sfdcTool;
public class ClassAccesses
{
    private String enabled;

    private String apexClass;

    public String getEnabled ()
    {
        return enabled;
    }

    public void setEnabled (String enabled)
    {
        this.enabled = enabled;
    }

    public String getApexClass ()
    {
        return apexClass;
    }

    public void setApexClass (String apexClass)
    {
        this.apexClass = apexClass;
    }

    @Override
    public String toString()
    {
        return " [enabled = "+enabled+", apexClass = "+apexClass+"]";
    }
}
			
	