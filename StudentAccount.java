package shop;

public class StudentAccount extends CustomerAccount
{
  private static int studentCount;
  private static final int discount = 25;
  
  public StudentAccount(int id, String name, String address, String profession)
  {
    super(id, name, address, profession);
  }
  
  public StudentAccount(int id, String name, String address, String profession, int freeAppsUsed, int purchasedAppsUsed)
  {
    super(id, name, address, profession);
    this.freeAppsUsed = freeAppsUsed;
    this.purchasedAppUsed = purchasedAppsUsed;
  }
  
  public StudentAccount() {}
  
  public StudentAccount(int id, String name, String address, String profession, int studentCount)
  {
    super(id, name, address, profession);
    
    studentCount = studentCount;
  }
  
  public static int getDiscount()
  {
    return 25;
  }
  
  public void setStudentCount(int studentCount)
  {
    studentCount = studentCount;
  }
  
  public static int getStudentCount()
  {
    if (studentCount == 0) {
      return 1;
    }
    return studentCount;
  }
}
