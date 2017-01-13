package shop;

import java.io.File;

public class SportsApp
  extends Apps
{
  private static int sportsAppCount;
  
  public static int getSportsAppCount()
  {
    if (sportsAppCount == 0) {
      return 1;
    }
    return sportsAppCount;
  }
  
  public static void setSportsAppCount(int sportsAppCount)
  {
    sportsAppCount = sportsAppCount;
  }
  
  public SportsApp() {}
  
  public SportsApp(String name, String description, int price, String devel)
  {
    super(name, description, price);
    Storage stor = new Storage();
    File sport = new File("C:\\appsfolder/sports.txt");
    sportsAppCount = stor.numOfSpecificApp(sport);
    this.dev.setName(devel);
  }
  
  public SportsApp(String name, String description, int appsAvailable, int popularity, int price, int sportApps, String devel)
  {
    super(name, description, appsAvailable, popularity, price);
    sportsAppCount = sportApps;
    this.dev.setName(devel);
  }
}

