
package shop;

public class AcademicAccount extends CustomerAccount
{
  private static int academicCount;
  private static final int discount = 10;
  
  public AcademicAccount(int id, String name, String address, String profession)
  {
    super(id, name, address, profession);
  }
  
  public AcademicAccount(int id, String name, String address, String profession, int freeAppsUsed, int purchasedAppsUsed)
  {
    super(id, name, address, profession);
  
    this.freeAppsUsed = freeAppsUsed;
    this.purchasedAppUsed = purchasedAppsUsed;
  }
  
  public AcademicAccount(int id, String name, String address, String profession, int academicCount)
  {
    super(id, name, address, profession);
    
  }
  
  public AcademicAccount() {}
  
  public void setAcademicCount(int academicCount)
  {
    academicCount = academicCount;
  }
  
  public static int getAcademicCount()
  {
    if (academicCount == 0) {
      return 1;
    }
    return academicCount;
  }
  
  public static int getDiscount()
  {
    return 10;
  }
}