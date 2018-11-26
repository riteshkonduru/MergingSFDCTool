package deloitte.com.sfdcTool;
public class PageAccesses
{
    private String apexPage;

    private String enabled;

    public String getApexPage ()
    {
        return apexPage;
    }

    public void setApexPage (String apexPage)
    {
        this.apexPage = apexPage;
    }

    public String getEnabled ()
    {
        return enabled;
    }

    public void setEnabled (String enabled)
    {
        this.enabled = enabled;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [apexPage = "+apexPage+", enabled = "+enabled+"]";
    }
}