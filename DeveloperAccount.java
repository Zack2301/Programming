package shop;

import java.io.IOException;

public class DeveloperAccount
  extends Account
{
  protected int numberOfAppsUploaded;
  private int developerApp;
  private static int developerCount;
  
  public DeveloperAccount(int id, String name, String address, String profession,int freeApps,int purchased)
  {
    super(id, name, address, profession);
    
    this.setFreeAppsUsed(freeApps);
    this.setPurchasedAppUsed(purchased);
  }
  
  public DeveloperAccount(int id, String name, String address, String profession)
  {
    super(id, name, address, profession);
    this.numberOfAppsUploaded = 0;
  }
  
  public DeveloperAccount() {}
  
  public void setDeveloperCount(int devCount)
  {
    developerCount = devCount;
  }
  
  public static int getDeveloperCount()
  {
    if (developerCount == 0) {
      return 1;
    }
    return developerCount;
  }
  
  public void setNumberDeveloperOfApp(int number)
  {
    this.developerApp = number;
  }
  
  public int getDeveloperAppsUploaded()
    throws IOException
  {
    if (this.developerApp > this.numberOfAppsUploaded)
    {
      this.numberOfAppsUploaded = this.developerApp;
      return this.numberOfAppsUploaded;
    }
    return 0;
  }
}