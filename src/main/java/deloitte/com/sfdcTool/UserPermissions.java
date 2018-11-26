package deloitte.com.sfdcTool;
public class UserPermissions
{
    private String enabled;

    private String name;

    public String getEnabled ()
    {
        return enabled;
    }

    public void setEnabled (String enabled)
    {
        this.enabled = enabled;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [enabled = "+enabled+", name = "+name+"]";
    }
}