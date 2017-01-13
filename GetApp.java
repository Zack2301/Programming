package shop;



public class GetApp
{
  protected static int totalNumberAppsPurchased = 0;
  protected static int totalNumberAppsFree = 0;
  Storage stor = new Storage();
  Apps apps = new Apps();
  
  public GetApp(int numbersFree, int numberBought)
  {
    totalNumberAppsFree = numbersFree;
    totalNumberAppsPurchased = numberBought;
  }
  
  public void setNumberOfPurchase(int payableApps)
  {
    totalNumberAppsPurchased = payableApps;
  }
  
  public int getNumberOfPurchase()
  {
    return totalNumberAppsPurchased;
  }
  
  public void setNumberOfFree(int freeApps)
  {
    totalNumberAppsFree = freeApps;
  }
  
  public int getNumberOfFree()
  {
    return totalNumberAppsFree;
  }
  
  
  
  
  }

