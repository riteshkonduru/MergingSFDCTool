package deloitte.com.sfdcTool;
public class Profile
{
    private UserPermissions userPermissions;

    private PageAccesses pageAccesses;

    private ClassAccesses classAccesses;

    public UserPermissions getUserPermissions ()
    {
        return userPermissions;
    }

    public void setUserPermissions (UserPermissions userPermissions)
    {
        this.userPermissions = userPermissions;
    }

    public PageAccesses getPageAccesses ()
    {
        return pageAccesses;
    }

    public void setPageAccesses (PageAccesses pageAccesses)
    {
        this.pageAccesses = pageAccesses;
    }

    public ClassAccesses getClassAccesses ()
    {
        return classAccesses;
    }

    public void setClassAccesses (ClassAccesses classAccesses)
    {
        this.classAccesses = classAccesses;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [userPermissions = "+userPermissions+", pageAccesses = "+pageAccesses+", classAccesses = "+classAccesses+"]";
    }
}