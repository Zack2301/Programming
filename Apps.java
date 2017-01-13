package shop;

public class Apps
{
  protected static int numOfAppsAvailable;
  private String nameOfApp;
  private String appDescription;
  private int appPopularity = 0;
  private boolean isFree;
  private int appPrice = 0;
  protected DeveloperAccount dev = new DeveloperAccount();

    public DeveloperAccount getDev() {
        return dev;
    }

    public void setDev(DeveloperAccount dev) {
        this.dev = dev;
    }
  public Apps(String name, String description, int price)
  {
    setNameOfApp(name);
    setNumOfAppsAvailable();
    setAppDescription(description);
    setAppPrice(price);
    Storage stor = new Storage();
    numOfAppsAvailable = stor.numTotalApps();
  }
  
  public Apps(String name, String description, int appsAvailable, int popularity, int price)
  {
    setNameOfApp(name);
    setAppDescription(description);
    setAppPopularity(popularity);
    setAppPrice(price);
    numOfAppsAvailable = appsAvailable;
  }
  
  public Apps() {}
  
  public static int getNumOfAppsAvailable()
  {
    return numOfAppsAvailable;
  }
  
  public void setNumOfAppsAvailable()
  {
    numOfAppsAvailable += 1;
  }
  
  public String getNameOfApp()
  {
    return this.nameOfApp;
  }
  
  public void setNameOfApp(String nameOfApp)
  {
    this.nameOfApp = nameOfApp;
  }
  
  public String getAppDescription()
  {
    return this.appDescription;
  }
  
  public void setAppDescription(String appDescription)
  {
    this.appDescription = appDescription;
  }
  
  public int getAppPopularity()
  {
    return this.appPopularity;
  }
  
  public void setAppPopularity(int appPopularity)
  {
    this.appPopularity = appPopularity;
  }
  
  public boolean isFree()
  {
    return this.isFree;
  }
  
  public void setFree()
  {
    if (this.appPrice != 0) {
      this.isFree = false;
    } else {
      this.isFree = true;
    }
  }
  
  public int getAppPrice()
  {
    return this.appPrice;
  }
  
  public void setAppPrice(int appPrice)
  {
    this.appPrice = appPrice;
  }
}