package shop;

import java.io.File;

public class GamesApp extends Apps
{
  private static int gamesCount;
  
  public GamesApp(String name, String des, int numOfApps, int popularity, int price, int sportApps, String devel)
  {
    super(name, des, numOfApps, popularity, price);
    gamesCount = sportApps;
    this.dev.setName(devel);
  }
  
  public GamesApp(String name, String description, int price, String devel)
  {
    super(name, description, price);
    Storage stor = new Storage();
    File games = new File("C:\\appsfolder/games.txt");
    gamesCount = stor.numOfSpecificApp(games);
    this.dev.setName(devel);
  }
  
  public static int getGamesCount()
  {
    if (gamesCount == 0) {
      return 1;
    }
    return gamesCount;
  }
  
  public static void setGamesCount(int gamesCount)
  {
    gamesCount = gamesCount;
  }
}
