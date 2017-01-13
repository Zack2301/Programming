package shop;

import java.io.PrintStream;

public class CustomerAccount
  extends Account
{
  protected static int customerNumbers = 0;
  private Storage stor;
  
  public CustomerAccount(int id, String name, String address, String profession)
  {
    super(id, name, address, profession);
  }
  
  public CustomerAccount(int id, String name, String address, String profession, int freeAppsUsed, int purchasedAppsUsed)
  {
    super(id, name, address, profession);
    
    customerNumbers = this.stor.totalNumCustomers();
  }
  
  public CustomerAccount() {}
  
  public void calculateDiscount(int discount)
  {
    int percentage = 100;
    double total = discount / percentage;
    System.out.println("? " + total + " discount will be issued");
  }
}

