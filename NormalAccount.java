package shop;

public class NormalAccount
  extends CustomerAccount
{
  private static int normalCustomerCount;
  
  public NormalAccount(int id, String name, String address, String profession)
  {
    super(id, name, address, profession);
  }
  
  public NormalAccount(int id, String name, String address, String profession, int freeAppsUsed, int purchasedAppsUsed)
  {
    super(id, name, address, profession);
    this.freeAppsUsed = freeAppsUsed;
    this.purchasedAppUsed = purchasedAppsUsed;
    
  }
  
  public NormalAccount(int id, String name, String address, String profession, int normalCount)
  {
    super(id, name, address, profession);
    normalCustomerCount = normalCount;
  }
  
  NormalAccount() {}
  
  public void setnormalCustomerCount(int normalCustomerCount)
  {
    normalCustomerCount = normalCustomerCount;
  }
  
  public static int getnormalCustomerCount()
  {
    if (normalCustomerCount == 0) {
      return 1;
    }
    return normalCustomerCount;
  }
}

