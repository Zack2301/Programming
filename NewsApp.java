package shop;

import java.io.File;

public class NewsApp
  extends Apps
{
  private static int NewsCount;
  
  public static int getNewsCount()
  {
    if (NewsCount == 0) {
      return 1;
    }
    return NewsCount;
  }
  
  public static void setNewsCount(int newsCount)
  {
    NewsCount = newsCount;
  }
  
  public NewsApp(String name, String description, int price, String devel)
  {
    super(name, description, price);
    Storage stor = new Storage();
    File news = new File("C:\\appsfolder/news.txt");
    NewsCount = stor.numOfSpecificApp(news);
    this.dev.setName(devel);
  }
  
  public NewsApp(String name, String description, int appsAvailable, int popularity, int price, int newsApp, String devel)
  {
    super(name, description, appsAvailable, popularity, price);
    NewsCount = newsApp;
    this.dev.setName(devel);
  }
}