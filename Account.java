package shop;

public class Account
{
  private int accountid;
  protected String accountName;
  private String address;
  private String profession;
  protected int freeAppsUsed = 0;
  protected int purchasedAppUsed = 0;
  
  public int getFreeAppsUsed()
  {
    return this.freeAppsUsed;
  }
  
  public void setFreeAppsUsed(int freeAppsUsed)
  {
    this.freeAppsUsed = freeAppsUsed;
  }
  
  public int getPurchasedAppUsed()
  {
    return this.purchasedAppUsed;
  }
  
  public void setPurchasedAppUsed(int purchasedAppUsed)
  {
    this.purchasedAppUsed = purchasedAppUsed;
  }
  
  public Account(int id, String name, String address, String profession)
  {
    setId(id);
    setName(name);
    setAddress(address);
    setProfession(profession);
  }
  
  public Account() {}
  
  public void setId(int accountId)
  {
    this.accountid = accountId;
  }
  
  public void setName(String accountName)
  {
    this.accountName = accountName;
  }
  
  public int getId()
  {
    return this.accountid;
  }
  
  public String getName()
  {
    return this.accountName;
  }
  
  public void setAddress(String address)
  {
    this.address = address;
  }
  
  public String getAddress()
  {
    return this.address;
  }
  
  public void setProfession(String profession)
  {
    this.profession = profession;
  }
  
  public String getProfession()
  {
    return this.profession;
  }
}
