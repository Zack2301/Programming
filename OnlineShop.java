
package shop;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineShop 
{
Scanner keyboard = new Scanner(System.in);
private ArrayList<Apps> App = new ArrayList<Apps>();
private ArrayList<Account>Acc = new ArrayList<Account>();

private Storage storage = new Storage();
private Account accounts = new Account(); 
private File sport = new File("C:\\appsfolder/sports.txt");
private String sportPath = "C:\\appsfolder/sports.txt";
private File news = new File("C:\\appsfolder/news.txt");
private String newsPath = "C:\\appsfolder/news.txt";
private File games = new File("C:\\appsfolder/games.txt");
private String gamesPath = "C:\\appsfolder/games.txt";

private File developer = new File("C:\\accountfolder/developer.txt");
private String developerPath = ("C:\\accountfolder/developer.txt");
private File normal = new File("C:\\accountfolder/normal.txt");
private String normalPath = ("C:\\accountfolder/normal.txt");
private File student = new File("C:\\accountfolder/student.txt");
private String studentPath = ("C:\\accountfolder/student.txt");
private File academic = new File("C:\\accountfolder/academic.txt");
private String academicPath = ("C:\\accountfolder/academic.txt");

public OnlineShop() throws IOException
{
	char check, ignore;
   for(;;){
	   do{
		 displayMenu();
		 check = (char)System.in.read(); 
		 do{
			ignore = (char) System.in.read();
		 }while(ignore !='\n');
	     }while (!isValid(check));
	   
            if (check == 'q'){System.out.println("Quitting...");
            return;}
	   else{
	   check(check);
	   
	   }
   }
}

public void check(int check) throws IOException{
	
	switch(check){
	case '0':
        addNewApp();
	break;
	case '1':
		System.out.println("Choose which category your app is in ");
		System.out.println("1.Sports");
		System.out.println("2.News");
		System.out.println("3.Games");
		int choose;
		do {
		
			choose = keyboard.nextInt();
			switch(choose){
		case 1: 
		editApp(sportPath);
		break;
		case 2:
		editApp(newsPath);
		break;
		case 3:
		editApp(gamesPath);
		break;
		default:System.out.println("You have entered wrong number.Try again.. ");
		}
		}while(!(choose > 0 && choose < 4));
		
	break;
	case '2':
		listApps();
	break;
	case '3':
		 searchApp(); 
	break;
	case '4':
		deleteApps();
	break;
	case '5':
		addNewAccount();
	break;
	case '6':
                System.out.println("Select An Account");
		System.out.println("1.Normal Account");
		System.out.println("2.Academic Account");
		System.out.println("3.Student Account");
                System.out.println("4.Developer Account");
                
		do {
		      choose = keyboard.nextInt();
			switch(choose){
		case 1: 
		editAccount(normalPath);
		break;
		case 2:
		editAccount(academicPath);
		break;
		case 3:
		editAccount(studentPath);
		break;
                case 4:
                editAccount(developerPath);
		break;
		default:System.out.println("You have entered wrong number.Try again.. ");
		}
		}while(!(choose > 0 && choose < 5));

	break;   
	case '7':
		listAccounts();
	break;
	case '8':
		searchAccounts();
	break;
	case '9':
		deleteAccounts();
	break;
        case'b':
            buyApp();
            break;
        case 't':
            totalApps();
            case'r':
                retrieveTransactions();
	
	}
}	

boolean isValid(int ch){
	
	if(ch < '0' | ch > '9' & ch!='b' & ch!='q' & ch!='t' & ch!='r')return false;
	else return true;
}


public void displayMenu()
{
  System.out.println("Apps Options ");
  System.out.println("   0.Add new App ");
  System.out.println("   1.Edit App ");
  System.out.println("   2.List all Apps ");
  System.out.println("   3.Search App");
  System.out.println("   4.Delete App ");
  System.out.println("Account Options");
  System.out.println("   5.Add new Account");
  System.out.println("   6.Edit Account ");
  System.out.println("   7.List Accounts ");
  System.out.println("   8.Search Account ");
  System.out.println("   9.Delete Account");
    System.out.println("Type b to buy app: ");
        System.out.println("Type r to Retrieve transaction data : ");

    System.out.println("Type t to check total apps purchased and total free: ");

  System.out.println("Type q to Quit menu: ");
 

 
}


public void addNewApp()
 {
	int category;
	String appName;
	String description;
	int price;
	do {
  System.out.println("Choose category ");
  System.out.println("1.Sports ");
  System.out.println("2.News");
  System.out.println("3.Games");
  category = keyboard.nextInt();
	}while(!(category > 0 && category < 4));
  System.out.println("Type App name ");
  appName = keyboard.next();
  System.out.println("Write App description");
  description = keyboard.next();
  System.out.println("Enter App price ");
  price = keyboard.nextInt();
  System.out.println("Write developer name");
  String developer = keyboard.next();
 
if(category == 1){
	  SportsApp sp = new SportsApp(appName,description,price,developer);
	  storage.storeAppDetails(sp,sport,sportPath);
  }else if(category==2){
	  NewsApp np = new NewsApp(appName,description,price,developer);
	  storage.storeAppDetails(np, news, newsPath);
  }else if(category==3){
	  GamesApp ga = new GamesApp(appName,description,price,developer);
	  storage.storeAppDetails(ga, games, gamesPath);
  }
  System.out.println("App details stored succesfully");
  }


 public void editApp(String path)
 {
 int i=1;
 
  if(path.equals("C:\\appsfolder/sports.txt")){
	  App = storage.retrieveAppDetails(sport,sportPath);
	  
	 for(Apps app:App){

	  System.out.print(i+" Name of the App: " + app.getNameOfApp()+", ");
	  System.out.print("Total of Apps available: " + storage.numTotalApps()+", ");
	  System.out.print("Description of the App: " + app.getAppDescription()+", ");
	  System.out.print("App popularity: " + app.getAppPopularity()+", ");
	  System.out.print("Price of the App: " + app.getAppPrice()+", ");
	  System.out.print("Sport Apps available: " + storage.numOfSpecificApp(sport) +" .");
	  System.out.println("Developer of the App" +app.dev.getName());
          System.out.println("\n");
	  i++;
	 }
	  System.out.println("Enter the name of App to edit");
	  String choise=keyboard.next();
	  System.out.println("Enter new Name " );
	  String newName=keyboard.next();
	  System.out.println("Enter new Description ");
	  String newDes=keyboard.next();
	  System.out.println("Enter new price ");
	  int newPrice = keyboard.nextInt();
	  
	  File tempFile = new File(sport.getAbsolutePath()+".tmp");
	  try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true)))
		
	  {
	  for(Apps app:App){
		 if(app.getNameOfApp().equals(choise)){
		    		app.setNameOfApp(newName);
		    		app.setAppDescription(newDes);
		    		app.setAppPrice(newPrice);
		    	  }
		    	      writer.write(app.getNameOfApp());
			      writer.write(".");
			      writer.write(Integer.toString(storage.numTotalApps()));
			      writer.write(".");
			      writer.write(app.getAppDescription());
			      writer.write(".");
			      writer.write(Integer.toString(app.getAppPopularity()));
			      writer.write(".");
			      writer.write(Integer.toString(app.getAppPrice()));
			      writer.write(".");
			      writer.write(Integer.toString(storage.numOfSpecificApp(sport)));
                              writer.write(".");
                              writer.write(app.dev.getName());
			      writer.newLine();
			      writer.flush();  		    	 
  }
	  writer.close();
	  sport.delete();
	   tempFile.renameTo(sport);
	   System.out.println("App was succesfully edited.");
	  }
	   catch (IOException e) {
	System.err.println("Error " + e.getMessage()); 
	} 
   }else if(path.equals("C:\\appsfolder/news.txt")){
	      App = storage.retrieveAppDetails(news,newsPath);
	  for(Apps app:App){
		  System.out.print(i+" Name of the App: " + app.getNameOfApp()+", ");
		  System.out.print("Total of Apps available: " + storage.numTotalApps()+", ");
		  System.out.print("Description of the App: " + app.getAppDescription()+", ");
		  System.out.print("App popularity: " + app.getAppPopularity()+", ");
		  System.out.print("Price of the App: " + app.getAppPrice()+", ");
		  System.out.print("News Apps available: " + storage.numOfSpecificApp(news) +" .");
		  System.out.println("Developer of the App" +app.dev.getName());
                  System.out.println("\n");
		  i++;
	  }System.out.println("Enter the name of App to edit");
	  String choise=keyboard.next();
	  System.out.println("Enter new Name " );
	  String newName=keyboard.next();
	  System.out.println("Enter new Description ");
	  String newDes=keyboard.next();
	  System.out.println("Enter new price ");
	  int newPrice = keyboard.nextInt();
	  
	  File tempFile = new File(news.getAbsolutePath()+".tmp");
	  try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true)))
		
	  {
	  for(Apps app:App){
		 if(app.getNameOfApp().equals(choise)){
		    		app.setNameOfApp(newName);
		    		app.setAppDescription(newDes);
		    		app.setAppPrice(newPrice);
		    	  }
		    	 writer.write(app.getNameOfApp());
			      writer.write(".");
			      writer.write(Integer.toString(storage.numTotalApps()));
			      writer.write(".");
			      writer.write(app.getAppDescription());
			      writer.write(".");
			      writer.write(Integer.toString(app.getAppPopularity()));
			      writer.write(".");
			      writer.write(Integer.toString(app.getAppPrice()));
			      writer.write(".");
			      writer.write(Integer.toString(storage.numOfSpecificApp(news)));
			      writer.write(".");
                              writer.write(app.dev.getName());
                              writer.newLine();
			      writer.flush();	 
       }
	  writer.close();
	  news.delete();
	   tempFile.renameTo(news);
	   System.out.println("App was succesfully edited.");
	  }
          catch (IOException e) {
		    	System.err.println("Error " + e.getMessage()); 
                       }
	
	  }else if(path.equals("C:\\appsfolder/games.txt")){
		  for(Apps app:App){
			  App = storage.retrieveAppDetails(games,gamesPath);
			  System.out.print(i+" Name of the App: " + app.getNameOfApp()+", ");
			  System.out.print("Total of Apps available: " + storage.numTotalApps()+", ");
			  System.out.print("Description of the App: " + app.getAppDescription()+", ");
			  System.out.print("App popularity: " + app.getAppPopularity()+", ");
			  System.out.print("Price of the App: " + app.getAppPrice()+", ");
			  System.out.print("Games Apps available: " + storage.numOfSpecificApp(games) +" .");
			  System.out.println("Developer of the App" +app.dev.getName());
                          System.out.println("\n");
			  i++;
		  }
		  System.out.println("Enter the name of App to edit");
		  String choise=keyboard.next();
		  System.out.println("Enter new Name " );
		  String newName=keyboard.next();
		  System.out.println("Enter new Description ");
		  String newDes=keyboard.next();
		  System.out.println("Enter new price ");
		  int newPrice = keyboard.nextInt();
		  
		  File tempFile = new File(games.getAbsolutePath()+".tmp");
		  try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true)))
			
		  {
		  for(Apps app:App){
			 if(app.getNameOfApp().equals(choise)){
			    		app.setNameOfApp(newName);
			    		app.setAppDescription(newDes);
			    		app.setAppPrice(newPrice);
			    	  }
			    	 writer.write(app.getNameOfApp());
				      writer.write(".");
				      writer.write(Integer.toString(storage.numTotalApps()));
				      writer.write(".");
				      writer.write(app.getAppDescription());
				      writer.write(".");
				      writer.write(Integer.toString(app.getAppPopularity()));
				      writer.write(".");
				      writer.write(Integer.toString(app.getAppPrice()));
				      writer.write(".");
				      writer.write(Integer.toString(storage.numOfSpecificApp(games)));
				      writer.write(".");
                                      writer.write(app.dev.getName());
                                      
                                      writer.newLine();
				      writer.flush();  
	  }
		  writer.close();
		  games.delete();
		   tempFile.renameTo(games);
		   System.out.println("App was succesfully edited.");
		  }
		   catch (IOException e) {
		  System.err.println("Error " + e.getMessage()); 
	}	
  }
 }
 public void listApps(){
	 
	 App = storage.retrieveAppDetails(sport,sportPath);
	 int i=1;
	 
	 for(Apps app:App){

	  System.out.print(i+" Name of the App: " + app.getNameOfApp()+", ");
	  System.out.print("Total of Apps available: " + storage.numTotalApps()+", ");
	  System.out.print("Description of the App: " + app.getAppDescription()+", ");
	  System.out.print("App popularity: " + app.getAppPopularity()+", ");
	  System.out.print("Price of the App: " + app.getAppPrice()+", ");
	  System.out.print("Sport Apps available: " + storage.numOfSpecificApp(sport) +" .");
          System.out.println("Developer of the App " +app.dev.getName());
	  System.out.println("\n");
	  i++;
	 }
	 App = storage.retrieveAppDetails(news,newsPath);
	 for(Apps app:App){

		  System.out.print(i+" Name of the App: " + app.getNameOfApp()+", ");
		  System.out.print("Total of Apps available: " + storage.numTotalApps()+", ");
		  System.out.print("Description of the App: " + app.getAppDescription()+", ");
		  System.out.print("App popularity: " + app.getAppPopularity()+", ");
		  System.out.print("Price of the App: " + app.getAppPrice()+", ");
		  System.out.print("News Apps available: " + storage.numOfSpecificApp(news) +" .");
		  System.out.println("Developer of the App " +app.dev.getName());
                  
                  System.out.println("\n");
		  i++;
		 }
	 App = storage.retrieveAppDetails(games,gamesPath);
	 for(Apps app:App){

		  System.out.print(i+" Name of the App: " + app.getNameOfApp()+", ");
		  System.out.print("Total of Apps available: " + storage.numTotalApps()+", ");
		  System.out.print("Description of the App: " + app.getAppDescription()+", ");
		  System.out.print("App popularity: " + app.getAppPopularity()+", ");
		  System.out.print("Price of the App: " + app.getAppPrice()+", ");
		  System.out.print("Games Apps available: " + storage.numOfSpecificApp(games) +" .");
		  System.out.println("Developer of the App " +app.dev.getName());
                 
                  System.out.println("\n");
		  i++;
		 }
	 }

public void searchApp() 
 {
	System.out.println("Enter the name of the App to search.");
 Apps apps = null;
  String choise=keyboard.next();
  App = storage.retrieveAppDetails(sport,sportPath);
	 
	 for(Apps app:App){

	 if(app.getNameOfApp().equals(choise)){
		 apps=app;
		 System.out.print(" Name of the App: " + app.getNameOfApp()+", ");
		  System.out.print("Total of Apps available: " + storage.numTotalApps()+", ");
		  System.out.print("Description of the App: " + app.getAppDescription()+", ");
		  System.out.print("App popularity: " + app.getAppPopularity()+", ");
		  System.out.print("Price of the App: " + app.getAppPrice()+", ");
		  System.out.print("Sport Apps available: " + storage.numOfSpecificApp(sport) +" .");
		  System.out.println("Developer of the App " +app.dev.getName());
                  System.out.println("\n");
	 }
	 
	 }
	 App = storage.retrieveAppDetails(news,newsPath);
	 for(Apps app:App){
		 if(app.getNameOfApp().equals(choise)){
		  apps=app;
		  System.out.print(" Name of the App: " + app.getNameOfApp()+", ");
		  System.out.print("Total of Apps available: " + storage.numTotalApps()+", ");
		  System.out.print("Description of the App: " + app.getAppDescription()+", ");
		  System.out.print("App popularity: " + app.getAppPopularity()+", ");
		  System.out.print("Price of the App: " + app.getAppPrice()+", ");
		  System.out.print("News Apps available: " + storage.numOfSpecificApp(news) +" .");
		  System.out.println("Developer of the App " +app.dev.getName());
                  System.out.println("\n");
		 }
		 }
	 App = storage.retrieveAppDetails(games,gamesPath);
	 for(Apps app:App){
		 if(app.getNameOfApp().equals(choise)){
		  apps=app;
		  System.out.print(" Name of the App: " + app.getNameOfApp()+", ");
		  System.out.print("Total of Apps available: " + storage.numTotalApps()+", ");
		  System.out.print("Description of the App: " + app.getAppDescription()+", ");
		  System.out.print("App popularity: " + app.getAppPopularity()+", ");
		  System.out.print("Price of the App: " + app.getAppPrice()+", ");
		  System.out.print("Games Apps available: " + storage.numOfSpecificApp(games) +" .");
		  System.out.println("Developer of the App " +app.dev.getName());
                  System.out.println("\n");
		 
		 }
	 }
	if(apps==null){
		System.out.println("No App found with such a name");
	} 

   }

public void deleteApps()
{
    System.err.println("Enter App name to delete:");
    String name=keyboard.next();
    boolean found=false;
    App = storage.retrieveAppDetails(sport,sportPath);
    for(Apps app:App){
    	if(name.equals(app.getNameOfApp())){
    			found=true;}
    	if(!(name.equals(app.getNameOfApp()))){
    		File tempFile = new File(sport.getAbsolutePath()+".tmp");
    		  try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true))){
    			{
    			  writer.write(app.getNameOfApp());
   			      writer.write(".");
   			      writer.write(Integer.toString(storage.numTotalApps()));
   			      writer.write(".");
   			      writer.write(app.getAppDescription());
   			      writer.write(".");
   			      writer.write(Integer.toString(app.getAppPopularity()));
   			      writer.write(".");
   			      writer.write(Integer.toString(app.getAppPrice()));
   			      writer.write(".");
   			      writer.write(Integer.toString(storage.numOfSpecificApp(sport)));
                              writer.write(".");
                              writer.write(app.dev.getName());
   			      writer.newLine();
   			      writer.flush();  
   		    }
   	  writer.close();
   	  sport.delete();
   	   tempFile.renameTo(sport);
   	  
    		  
    		  } catch (IOException e) {
				System.out.println("No such file exists");
			}
    	}
    }
    App = storage.retrieveAppDetails(news,newsPath);
    for(Apps app:App){
    	if(name.equals(app.getNameOfApp())){
			found=true;}
    	if(!(name.equals(app.getNameOfApp()))){
    		File tempFile = new File(news.getAbsolutePath()+".tmp");
    		  try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true))){
    			{
    			  writer.write(app.getNameOfApp());
   			      writer.write(".");
   			      writer.write(Integer.toString(storage.numTotalApps()));
   			      writer.write(".");
   			      writer.write(app.getAppDescription());
   			      writer.write(".");
   			      writer.write(Integer.toString(app.getAppPopularity()));
   			      writer.write(".");
   			      writer.write(Integer.toString(app.getAppPrice()));
   			      writer.write(".");
   			      writer.write(Integer.toString(storage.numOfSpecificApp(news)));
   			      
                              writer.write(".");
                              writer.write(app.dev.getName());writer.newLine();
   			      writer.flush();  
   		    }
   	  writer.close();
   	  news.delete();
   	   tempFile.renameTo(news);
   	   
    		  
    		  } catch (IOException e) {
				System.out.println("No such file exists");
			}
    	}
    }
    App = storage.retrieveAppDetails(games,gamesPath);
    for(Apps app:App){
    	if(name.equals(app.getNameOfApp())){
			found=true;}
    	if(!(name.equals(app.getNameOfApp()))){
    		File tempFile = new File(games.getAbsolutePath()+".tmp");
    		  try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true))){
    			{
    			  writer.write(app.getNameOfApp());
   			      writer.write(".");
   			      writer.write(Integer.toString(storage.numTotalApps()));
   			      writer.write(".");
   			      writer.write(app.getAppDescription());
   			      writer.write(".");
   			      writer.write(Integer.toString(app.getAppPopularity()));
   			      writer.write(".");
   			      writer.write(Integer.toString(app.getAppPrice()));
   			      writer.write(".");
   			      writer.write(Integer.toString(storage.numOfSpecificApp(games)));
   			      writer.write(".");
                              writer.write(app.dev.getName());
                              writer.newLine();
   			      writer.flush();  
   		    }
   	  writer.close();
   	  games.delete();
   	   tempFile.renameTo(games);
   	   
    		  
    		  } catch (IOException e) {
				System.out.println("No such file exists");
			}
    	}
    }
   if(found) System.out.println("App was succesfully deleted.");
   else System.out.println("No such App was found");
}


public void addNewAccount() throws IOException
{
    int type;
    
    int accountid;
    String accountName;
    String address;
    String profession;
    
    do{
        System.out.println("Select Account ");
        System.out.println("1.Developer ");
        System.out.println("2.Normal ");
        System.out.println("3.Student ");
        System.out.println("4.Academic ");
        type = keyboard.nextInt();
    }while(!(type > 0 && type < 5));
    

  System.out.println("Type An Account number ");
  accountid = keyboard.nextInt();
  System.out.println("Enter An Account Name ");
  accountName = keyboard.next();
  System.out.println("Enter An Address ");
  address = keyboard.next();
  System.out.println("Enter A Profession ");
  profession = keyboard.next();
   
  switch(type){
      case 1: DeveloperAccount da = new DeveloperAccount(accountid, accountName, address, profession);
              storage.storeAccountDetails(da, developer, developerPath);
              break;
           
      case 2: NormalAccount na = new NormalAccount(accountid, accountName, address, profession);
               storage.storeAccountDetails(na, normal, normalPath);
               break;
               
      case 3: StudentAccount sa = new StudentAccount(accountid, accountName, address, profession);
               storage.storeAccountDetails(sa, student, studentPath);
               break;
               
      case 4: AcademicAccount aa = new AcademicAccount(accountid, accountName, address, profession);
               storage.storeAccountDetails(aa, academic, academicPath);
               break;
      default:
              System.err.println("Number Entered is not Valid!!. Please try Again");
            }
             System.out.println("Account Details are successfully stored !");
     }


public void editAccount(String path)throws IOException{
    
   // int i = 1;
     if(path.equals("C:\\accountfolder/normal.txt")){
       Acc = storage.retrieveAccountDetails(normal, normalPath);
       for(Account acc: Acc){
          System.out.print(" Account Number: " + acc.getId()+", ");
          System.out.print(" Account Name: " + acc.getName()+", ");
          System.out.print("Account Address: " + acc.getAddress()+", ");
          System.out.print("Account Profession: " + acc.getProfession()+", ");
          System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
          System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
	  System.out.println("\n");
	  //i++;   
       }
          System.out.println("Enter the number of Account to edit");
	  int newid=keyboard.nextInt();
	  System.out.println("Enter new Account Name " );
	  String newName=keyboard.next();
          System.out.println("Enter new Address " );
	  String newAddress=keyboard.next();
          System.out.println("Enter new Profession " );
	  String newProfession=keyboard.next();
          
         File newFile = new File(normal.getAbsolutePath()+ ".tmp");
         try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile,true)))	
	  {
	  for(Account acc: Acc){
		 if(acc.getId()== newid){
		    		acc.setId(newid);
		    		acc.setName(newName);
                                acc.setAddress(newAddress);
		    		acc.setProfession(newProfession);
		    	
		    	  }
		    	      writer.write(Integer.toString(acc.getId()));
			      writer.write(".");
			      writer.write(acc.getName());
			      writer.write(".");
                              writer.write(acc.getAddress());
			      writer.write(".");
			      writer.write(acc.getProfession());
                              writer.write(".");
                              writer.write(Integer.toString(acc.getFreeAppsUsed()));
                              writer.write(".");
                              writer.write(Integer.toString(acc.getFreeAppsUsed()));
			      writer.newLine();
			      writer.flush();  		    	 
          }
	  writer.close();   
          normal.delete();
	  newFile.renameTo(normal);
	  System.out.println("App was succesfully edited.");
	  }
	   catch (IOException e) {
	    System.err.println("Error " + e.getMessage()); 
	    }
     }
     else if(path.equals("C:\\accountfolder/academic.txt")){
       Acc = storage.retrieveAccountDetails(academic, academicPath);
       for(Account acc: Acc){
          System.out.print(" Account Number: " + acc.getId()+", ");
          System.out.print(" Account Name: " + acc.getName()+", ");
	  System.out.print("Account Address: " + acc.getAddress()+", ");
          System.out.print("Account Profession: " + acc.getProfession()+", ");
          System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                  System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
	  System.out.println("\n");
	 // i++;   
       }
          System.out.println("Enter the number of Account to edit");
	  int newid=keyboard.nextInt();
	  System.out.println("Enter new Account Name " );
	  String newName=keyboard.next();
	  System.out.println("Enter new Address " );
	  String newAddress=keyboard.next();
          System.out.println("Enter new Profession " );
	  String newProfession=keyboard.next();
          
         File newFile = new File(academic.getAbsolutePath()+ ".tmp");
         try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile,true)))	
	  {
	  for(Account acc: Acc){
		 if(acc.getId()== newid){
		    		acc.setId(newid);
		    		acc.setName(newName);
                                acc.setAddress(newAddress);
		    		acc.setProfession(newProfession);
		    		
		    	  }
		    	      writer.write(Integer.toString(acc.getId()));
			      writer.write(".");
			      writer.write(acc.getName());
			      writer.write(".");
			      writer.write(acc.getAddress());
                              writer.write(".");
			      writer.write(acc.getProfession());
                              writer.write(".");
                              writer.write(Integer.toString(acc.getFreeAppsUsed()));
                              writer.write(".");
                              writer.write(Integer.toString(acc.getFreeAppsUsed()));
			      writer.newLine();
			      writer.flush();  		    	 
          }
	  writer.close();   
          academic.delete();
	  newFile.renameTo(academic);
	  System.out.println("Account was succesfully edited.");
	  }
	   catch (IOException e) {
	    System.err.println("Error " + e.getMessage()); 
	    }
         
     }else if(path.equals("C:\\accountfolder/student.txt")){
       Acc = storage.retrieveAccountDetails(student, studentPath);
       for(Account acc: Acc){
          System.out.print(" Account Number: " + acc.getId()+", ");
          System.out.print(" Account Name: " + acc.getName()+", ");
	  System.out.print("Account Address: " + acc.getAddress()+", ");
          System.out.print("Account Profession: " + acc.getProfession()+", ");
          System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                  System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
	  System.out.println("\n");
	  //i++;   
       }
          System.out.println("Enter the number of Account to edit");
	  int newid=keyboard.nextInt();
	  System.out.println("Enter new Account Name " );
	  String newName=keyboard.next();
	  System.out.println("Enter new Address " );
	  String newAddress=keyboard.next();
          System.out.println("Enter new Profession " );
	  String newProfession=keyboard.next();
          
         File newFile = new File(student.getAbsolutePath()+ ".tmp");
         try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile,true)))	
	  {
	  for(Account acc: Acc){
		 if(acc.getId()== newid){
		    		acc.setId(newid);
		    		acc.setName(newName);
                                acc.setAddress(newAddress);
		    		acc.setProfession(newProfession);
		    		
		    	  }
		    	      writer.write(Integer.toString(acc.getId()));
			      writer.write(".");
			      writer.write(acc.getName());
			      writer.write(".");
			      writer.write(acc.getAddress());
                              writer.write(".");
			      writer.write(acc.getProfession());
                              writer.write(".");
                              writer.write(Integer.toString(acc.getFreeAppsUsed()));
                              writer.write(".");
                              writer.write(Integer.toString(acc.getFreeAppsUsed()));
			      writer.newLine();
			      writer.flush();  		    	 
          }
	  writer.close();   
          student.delete();
	  newFile.renameTo(student);
	  System.out.println("Account was succesfully edited.");
	  }
	   catch (IOException e) {
	    System.err.println("Error " + e.getMessage()); 
	    }
         
     }else if(path.equals("C:\\accountfolder/developer.txt")){
       Acc = storage.retrieveAccountDetails(developer, developerPath);
       for(Account acc: Acc){
          System.out.print(" Account Number: " + acc.getId()+", ");
          System.out.print(" Account Name: " + acc.getName()+", ");
	  System.out.print("Account Address: " + acc.getAddress()+", ");
          System.out.print("Account Profession: " + acc.getProfession()+", ");
          System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                  System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
	  System.out.println("\n");
	  //i++;   
       }
          System.out.println("Enter the number of Account to edit");
	  int newid=keyboard.nextInt();
	  System.out.println("Enter new Account Name " );
	  String newName=keyboard.next();
	  System.out.println("Enter new Address " );
	  String newAddress=keyboard.next();
          System.out.println("Enter new Profession " );
	  String newProfession=keyboard.next();
          
         File newFile = new File(academic.getAbsolutePath()+ ".tmp");
         try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile,true)))	
	  {
	  for(Account acc: Acc){
		 if(acc.getId()== newid){
		    		acc.setId(newid);
		    		acc.setName(newName);
                                acc.setAddress(newAddress);
		    		acc.setProfession(newProfession);
		    		
		    	  }
		    	      writer.write(Integer.toString(acc.getId()));
			      writer.write(".");
			      writer.write(acc.getName());
			      writer.write(".");
			      writer.write(acc.getAddress());
                              writer.write(".");
			      writer.write(acc.getProfession());
                              writer.write(".");
                              writer.write(Integer.toString(acc.getFreeAppsUsed()));
                              writer.write(".");
                              writer.write(Integer.toString(acc.getFreeAppsUsed()));
			      writer.newLine();
			      writer.flush();  		    	 
          }
	  writer.close();   
          academic.delete();
	  newFile.renameTo(academic);
	  System.out.println("Account was succesfully edited.");
	  }
	   catch (IOException e) {
	    System.err.println("Error " + e.getMessage()); 
	    }
     }
}

public void listAccounts() throws IOException{
         
        Acc = storage.retrieveAccountDetails(normal,normalPath);
	int i=1;
	 
	for(Account acc : Acc){

	  System.out.print("Number of Account:"+acc.getId()+", ");
	  System.out.print("Name of Account:"+acc.getName()+", ");
	  System.out.print("Address of Account:"+ acc.getAddress()+", ");
	  System.out.print("Account Profession:"+ acc.getProfession()+", ");
          System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
          System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
          System.out.println("\n");  
	  i++;
	 }
        System.out.print("Number of Normal Customers: " + storage.numOfSpecificAccount(normal));
        System.out.println("\n"); 
        Acc = storage.retrieveAccountDetails(academic,academicPath);
	
	for(Account acc : Acc){
            
	  System.out.print(" Number of Account:"+ acc.getId()+", ");
	  System.out.print("Name of Account:"+ acc.getName() +", ");
	  System.out.print("Address of Account:"+ acc.getAddress()+", ");
	  System.out.print("Account Profession:"+ acc.getProfession()+", ");
	  
          System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                  System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
	  i++;
	 }
        System.out.println("Number of academic Customers: " + storage.numOfSpecificAccount(academic));
        Acc = storage.retrieveAccountDetails(student,studentPath);
	
	for(Account acc : Acc){
            
	  System.out.print(" Number of Account:"+ acc.getId()+", ");
	  System.out.print("Name of Account:"+ acc.getName()+", ");
	  System.out.print("Address of Account:"+ acc.getAddress()+", ");
	  System.out.print("Account Profession:"+ acc.getProfession()+", ");
          System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                  System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
	  System.out.println("\n");
	  i++;
	 }
       System.out.println("Number of Student Customers: " + storage.numOfSpecificAccount(student));
        Acc = storage.retrieveAccountDetails(developer,developerPath);
	
	for(Account acc : Acc){
            
	  System.out.print(" Number of Account:"+ acc.getId()+", ");
	  System.out.print("Name of Account:"+ acc.getName()+", ");
	  System.out.print("Address of Account:"+ acc.getAddress()+", ");
	  System.out.print("Account Profession:"+ acc.getProfession()+", ");
          System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                  System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
	  System.out.println("\n");
	  i++;
	 }
         System.out.println("Number of developer Customers: " + storage.numOfSpecificAccount(developer));
  
    }

public void searchAccounts() throws IOException{
    
    System.out.println("Enter the Account Number to search.");
    Account accs = null;
    int number =keyboard.nextInt();
    Acc = storage.retrieveAccountDetails(normal,normalPath); 
    
    for(Account acc: Acc){

	 if(acc.getId()== number){
		 accs =acc;
                  System.out.print(" Number of Account:" + acc.getId()+", ");
		  System.out.print(" Name of Account:"+ acc.getName()+", ");
		  System.out.print("Account Address:"+acc.getAddress()+", ");
		  System.out.print("Account Profession:" + acc.getProfession()+", ");
                  System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                  System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
		  System.out.println("\n");
         } 
      }
    Acc = storage.retrieveAccountDetails(academic, academicPath); 
    for(Account acc: Acc){

	 if(acc.getId()== number){
		 accs =acc;
                  System.out.print("Account Number:" + acc.getId()+", ");
		  System.out.print(" Name of Account:" + acc.getName()+", ");
		  System.out.print("Account Address:" + acc.getAddress()+", ");
		  System.out.print("Account Profession:" + acc.getProfession()+", ");
		 System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                  System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
                  System.out.println("\n");
         } 
    }
    Acc = storage.retrieveAccountDetails(student, studentPath); 
    for(Account acc: Acc){

	 if(acc.getId()== number){
		 accs =acc;
                System.out.print("Account Number:" + acc.getId()+", ");
	        System.out.print(" Name of Account:" + acc.getName()+", ");
		System.out.print("Account Address:" + acc.getAddress()+", ");
		System.out.print("Account Profession:" + acc.getProfession()+", ");
		System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
                System.out.println("\n");
         } 
    }
    Acc = storage.retrieveAccountDetails(developer, developerPath); 
    for(Account acc: Acc){

	 if(acc.getId()== number){
		 accs =acc;
                 System.out.print("Account Number: " + acc.getId()+", ");
		 System.out.print(" Name of Account: " + acc.getName()+", ");
		 System.out.print("Account Address: " + acc.getAddress()+", ");
		 System.out.print("Account Profession:" + acc.getProfession()+", ");
		 System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                 System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
                 System.out.println("\n");
         } 
     }
     if(accs == null){
     System.out.println("Name Entered Not Valid");
    } 
  }

 public void deleteAccounts(){
    System.err.println("Enter Account name to delete:");
    String accountname=keyboard.next(); 
    boolean found = false;
    
    Acc = storage.retrieveAccountDetails(normal, normalPath);
    for(Account acc: Acc){
    	if(accountname.equals(acc.getName())){
    			found=true;}
    	if(!(accountname.equals(acc.getName()))){
    		File newFile = new File(normal.getAbsolutePath()+".tmp");
    		  try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile,true))){
    			{
    			     writer.write(Integer.toString(acc.getId()));
   			     writer.write(".");
   			     writer.write(acc.getName());
   			     writer.write(".");
                             writer.write(acc.getAddress());
   			     writer.write(".");
   			     writer.write(acc.getProfession());
   			     writer.write(".");
                             writer.write(Integer.toString(acc.getFreeAppsUsed()));
                             writer.write(".");
                             writer.write(Integer.toString(acc.getPurchasedAppUsed()));
                             
                            
   			     writer.newLine();
   			     writer.flush();  
   		    }
                    writer.close();
                    normal.delete();
                    newFile.renameTo(normal);
   	  
    		  
    		  } catch (IOException e) {
				System.out.println("No such file exists");
			}
    	}
    }
    Acc = storage.retrieveAccountDetails(academic, academicPath);
    for(Account acc: Acc){
    	if(accountname.equals(acc.getName())){
    			found=true;}
    	if(!(accountname.equals(acc.getName()))){
    		File newFile = new File(academic.getAbsolutePath()+".tmp");
    		  try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile,true))){
    			{
    			     writer.write(Integer.toString(acc.getId()));
   			     writer.write(".");
   			     writer.write(acc.getName());
   			     writer.write(".");
                             writer.write(acc.getAddress());
   			     writer.write(".");
   			     writer.write(acc.getProfession());
                             writer.write(".");
                             writer.write(Integer.toString(acc.getFreeAppsUsed()));
                             writer.write(".");
                             writer.write(Integer.toString(acc.getPurchasedAppUsed()));
                             
   			     writer.newLine();
   			     writer.flush();  
   		    }
                    writer.close();
                    academic.delete();
                    newFile.renameTo(academic);
    		  } catch (IOException e) {
				System.out.println("No such file exists");
			}
    	}
    }
    
   Acc = storage.retrieveAccountDetails(student, studentPath);
    for(Account acc: Acc){
    	if(accountname.equals(acc.getName())){
    			found=true;}
    	if(!(accountname.equals(acc.getName()))){
    		File newFile = new File(student.getAbsolutePath()+".tmp");
    		  try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile,true))){
    			{
    			     writer.write(Integer.toString(acc.getId()));
   			     writer.write(".");
   			     writer.write(acc.getName());
   			     writer.write(".");
                             writer.write(acc.getAddress());
   			     writer.write(".");
   			     writer.write(acc.getProfession());
                             writer.write(".");
                            writer.write(Integer.toString(acc.getFreeAppsUsed()));
                             writer.write(".");
                             writer.write(Integer.toString(acc.getPurchasedAppUsed()));
                             
   			     writer.newLine();
   			     writer.flush();  
   		    }
                    writer.close();
                    student.delete();
                    newFile.renameTo(student);
   	  
    		  
    		  } catch (IOException e) {
				System.out.println("No such file exists");
			}
    	}
    }
    Acc = storage.retrieveAccountDetails(developer, developerPath);
    for(Account acc: Acc){
    	if(accountname.equals(acc.getName())){
    			found=true;}
    	if(!(accountname.equals(acc.getName()))){
    		File newFile = new File(developer.getAbsolutePath()+".tmp");
    		  try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile,true))){
    			{
    			     writer.write(Integer.toString(acc.getId()));
   			     writer.write(".");
   			     writer.write(acc.getName());
   			     writer.write(".");
                             writer.write(acc.getAddress());
   			     writer.write(".");
   			     writer.write(acc.getProfession());
                             writer.write(".");
                             writer.write(Integer.toString(acc.getFreeAppsUsed()));
                             writer.write(".");
                             writer.write(Integer.toString(acc.getPurchasedAppUsed()));
                            
   			     writer.newLine();
   			     writer.flush();  
   		    }
                    writer.close();
                    developer.delete();
                    newFile.renameTo(developer); 
    		  } catch (IOException e)
                     {
	             System.out.println("No such file exists");
                     }
                }
            }
          
            if(found){
            System.out.println("Account was succesfully deleted.");
            System.out.println("Total Number of customers" +storage.totalNumCustomers());
        }else System.out.println("No such Account was found");              
      }
  public void totalApps()
  {
    int totalFree = 0;
    int totalBought = 0;
    this.Acc = this.storage.retrieveAccountDetails(this.normal, this.normalPath);
    for (Account acc : this.Acc)
    {
      totalFree += acc.freeAppsUsed;
      totalBought += acc.purchasedAppUsed;
    }
    this.Acc = this.storage.retrieveAccountDetails(this.student, this.studentPath);
    for (Account acc : this.Acc)
    {
      totalFree += acc.freeAppsUsed;
      totalBought += acc.purchasedAppUsed;
    }
    this.Acc = this.storage.retrieveAccountDetails(this.academic, this.academicPath);
    for (Account acc : this.Acc)
    {
      totalFree += acc.freeAppsUsed;
      totalBought += acc.purchasedAppUsed;
    }
    GetApp get = new GetApp(totalFree, totalBought);
    this.storage.storeGetApp(get);
    System.out.println("Total Apps used for Free -- " + totalFree);
    System.out.println("Total Apps purchased-- " + totalBought);
  }
  public void buyApp() throws IOException{
  System.out.println("Select App to buy :");
   listApps();
   double price=0;
   int discount=0;
   System.out.println("Enter app name to buy :");
   String appName=keyboard.next();
   App = storage.retrieveAppDetails(sport,sportPath);
   Apps apps=null;
   boolean free=false;
      boolean empty=false;

	 for(Apps app:App){

	 if(app.getNameOfApp().equals(appName)){
		 apps=app;
		 System.out.print(" Name of the App: " + app.getNameOfApp()+", ");
		  System.out.print("Total of Apps available: " + storage.numTotalApps()+", ");
		  System.out.print("Description of the App: " + app.getAppDescription()+", ");
		  System.out.print("App popularity: " + app.getAppPopularity()+", ");
		  System.out.print("Price of the App: " + app.getAppPrice()+", ");
		  System.out.print("Sport Apps available: " + storage.numOfSpecificApp(sport) +" .");
		  System.out.println("Developer of the App " +app.dev.getName());
                  app.setAppPopularity(app.getAppPopularity()+1);
                  price=app.getAppPrice();
                  if(app.getAppPrice()!=0){free=false;
                  }else{ free=true;
                          }
                  
                  System.out.println("\n");
	 }
	
	 }
          File tempFile = new File(sport.getAbsolutePath()+".tmp");
	  try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile,true)))
		
	  {
	  for(Apps app:App){
		 
		    	      writer.write(app.getNameOfApp());
			      writer.write(".");
			      writer.write(Integer.toString(storage.numTotalApps()));
			      writer.write(".");
			      writer.write(app.getAppDescription());
			      writer.write(".");
			      writer.write(Integer.toString(app.getAppPopularity()));
			      writer.write(".");
			      writer.write(Integer.toString(app.getAppPrice()));
			      writer.write(".");
			      writer.write(Integer.toString(storage.numOfSpecificApp(sport)));
                              writer.write(".");
                              writer.write(app.dev.getName());
			      writer.newLine();
			      writer.flush();  		    	 
  }
	  writer.close();
	  sport.delete();
	   tempFile.renameTo(sport);
	   
	  }
	   catch (IOException e) {
	System.err.println("Error " + e.getMessage()); 
	} 
         
	 App = storage.retrieveAppDetails(news,newsPath);
	 for(Apps app:App){
		 if(app.getNameOfApp().equals(appName)){
		  apps=app;
		  System.out.print(" Name of the App: " + app.getNameOfApp()+", ");
		  System.out.print("Total of Apps available: " + storage.numTotalApps()+", ");
		  System.out.print("Description of the App: " + app.getAppDescription()+", ");
		  System.out.print("App popularity: " + app.getAppPopularity()+", ");
		  System.out.print("Price of the App: " + app.getAppPrice()+", ");
		  System.out.print("News Apps available: " + storage.numOfSpecificApp(news) +" .");
		  System.out.println("Developer of the App" +app.dev.getName());
                  app.setAppPopularity(app.getAppPopularity()+1);
                  price=app.getAppPrice();
                  if(app.getAppPrice()!=0){free=false;
                  }else{ free=true;
                          }
		 }
		 }
         File tempFile2 = new File(news.getAbsolutePath()+".tmp");
	  try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile2,true)))
		
	  {
	  for(Apps app:App){
		 
		    	      writer.write(app.getNameOfApp());
			      writer.write(".");
			      writer.write(Integer.toString(storage.numTotalApps()));
			      writer.write(".");
			      writer.write(app.getAppDescription());
			      writer.write(".");
			      writer.write(Integer.toString(app.getAppPopularity()));
			      writer.write(".");
			      writer.write(Integer.toString(app.getAppPrice()));
			      writer.write(".");
			      writer.write(Integer.toString(storage.numOfSpecificApp(news)));
                              writer.write(".");
                              writer.write(app.dev.getName());
			      writer.newLine();
			      writer.flush();  		    	 
  }
	  writer.close();
	  news.delete();
	   tempFile2.renameTo(news);
	   
	  }
	   catch (IOException e) {
	System.err.println("Error " + e.getMessage()); 
	} 
          
	 App = storage.retrieveAppDetails(games,gamesPath);
	 for(Apps app:App){
		 if(app.getNameOfApp().equals(appName)){
		  apps=app;
		  System.out.print(" Name of the App: " + app.getNameOfApp()+", ");
		  System.out.print("Total of Apps available: " + storage.numTotalApps()+", ");
		  System.out.print("Description of the App: " + app.getAppDescription()+", ");
		  System.out.print("App popularity: " + app.getAppPopularity()+", ");
		  System.out.print("Price of the App: " + app.getAppPrice()+", ");
		  System.out.print("Games Apps available: " + storage.numOfSpecificApp(games) +" .");
		  System.out.println("Developer of the App" +app.dev.getName());
                  app.setAppPopularity(app.getAppPopularity()+1);
                  price=app.getAppPrice();
                  if(app.getAppPrice()!=0){free=false;
                  }else{ free=true;
                          }
		 
		 }
	 }
          File tempFile3 = new File(games.getAbsolutePath()+".tmp");
	  try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile3,true)))
		
	  {
	  for(Apps app:App){
		 
		    	      writer.write(app.getNameOfApp());
			      writer.write(".");
			      writer.write(Integer.toString(storage.numTotalApps()));
			      writer.write(".");
			      writer.write(app.getAppDescription());
			      writer.write(".");
			      writer.write(Integer.toString(app.getAppPopularity()));
			      writer.write(".");
			      writer.write(Integer.toString(app.getAppPrice()));
			      writer.write(".");
			      writer.write(Integer.toString(storage.numOfSpecificApp(news)));
                              writer.write(".");
                              writer.write(app.dev.getName());
			      writer.newLine();
			      writer.flush();  		    	 
  }
	  writer.close();
	  games.delete();
	   tempFile3.renameTo(games);
	   
	  }
	   catch (IOException e) {
	System.err.println("Error " + e.getMessage()); 
	} 
	if(apps==null){
		System.out.println("No App found with such a name");
                return;
	} 
        System.out.println("Choose account : ");
        listAccounts();
        System.out.println("Type account number : ");
        int number=keyboard.nextInt();
        Acc = storage.retrieveAccountDetails(normal,normalPath); 
    Account accs=null;
    for(Account acc: Acc){

	 if(acc.getId()== number){
		 empty=true;
                  System.out.print(" Number of Account:" + acc.getId()+", ");
		  System.out.print(" Name of Account:"+ acc.getName()+", ");
		  System.out.print("Account Address:"+acc.getAddress()+", ");
		  System.out.print("Account Profession:" + acc.getProfession()+", ");
                  System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                  System.out.println("Purchased apps  "+ acc.getPurchasedAppUsed());
                  
                  if(free){acc.setFreeAppsUsed(acc.getFreeAppsUsed()+1);
                  }else{acc.setPurchasedAppUsed(acc.getPurchasedAppUsed()+1);
                  }
                  System.out.println("You have purchased the app");
		  
         } 
      }
    
    File newFile = new File(normal.getAbsolutePath()+".tmp");
    		  try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile,true))){
    		for(Account ac:Acc){	
    			     writer.write(Integer.toString(ac.getId()));
   			     writer.write(".");
   			     writer.write(ac.getName());
   			     writer.write(".");
                             writer.write(ac.getAddress());
   			     writer.write(".");
   			     writer.write(ac.getProfession());
   			     writer.write(".");
                             writer.write(Integer.toString(ac.getFreeAppsUsed()));
                             writer.write(".");
                             writer.write(Integer.toString(ac.getPurchasedAppUsed()));
                  
                            
   			     writer.newLine();
   			     writer.flush();  
   		    
                  } writer.close();
                    normal.delete();
                    newFile.renameTo(normal);
   	  
    		  
    		  } catch (IOException e) {
				System.out.println("No such file exists");
			}
    
    Acc = storage.retrieveAccountDetails(academic, academicPath); 
    for(Account acc: Acc){

	 if(acc.getId()== number){
		 empty=true;
                  System.out.print("Account Number:" + acc.getId()+", ");
		  System.out.print(" Name of Account:" + acc.getName()+", ");
		  System.out.print("Account Address:" + acc.getAddress()+", ");
		  System.out.print("Account Profession:" + acc.getProfession()+", ");
		 System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                  System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
                  discount=AcademicAccount.getDiscount();
                  if(free){acc.setFreeAppsUsed(acc.getFreeAppsUsed()+1);
                  }else{acc.setPurchasedAppUsed(acc.getPurchasedAppUsed()+1);
                  }
                   System.out.println("\n");
               double afterdisc= price-(price*0.25);
                
                System.out.println("You have purchased the app, with the 10% discount \n");
                System.out.println("price before discount "+ price+" Price after discount "+afterdisc );
                
               price=afterdisc;
               
         } 
    }
    
     
    File newFile1 = new File(normal.getAbsolutePath()+".tmp");
    		  try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile1,true))){
    			 for(Account ac1:Acc){
    			     writer.write(Integer.toString(ac1.getId()));
   			     writer.write(".");
   			     writer.write(ac1.getName());
   			     writer.write(".");
                             writer.write(ac1.getAddress());
   			     writer.write(".");
   			     writer.write(ac1.getProfession());
   			     writer.write(".");
                             writer.write(Integer.toString(ac1.getFreeAppsUsed()));
                             writer.write(".");
                             writer.write(Integer.toString(ac1.getPurchasedAppUsed()));
                             
                            
                         
                         writer.newLine();
   			   writer.flush();  
   		    
                      } writer.close();
                    academic.delete();
                    newFile1.renameTo(academic);
   	  
    		  
    		  } catch (IOException e) {
				System.out.println("No such file exists");
			}
                  
             
    Acc = storage.retrieveAccountDetails(student, studentPath); 
    for(Account acc: Acc){

	 if(acc.getId()== number){
		 empty=true;
                System.out.print("Account Number:" + acc.getId()+", ");
	        System.out.print(" Name of Account:" + acc.getName()+", ");
		System.out.print("Account Address:" + acc.getAddress()+", ");
		System.out.print("Account Profession:" + acc.getProfession()+", ");
		System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
                discount=StudentAccount.getDiscount();
                if(free){acc.setFreeAppsUsed(acc.getFreeAppsUsed()+1);
                  }else{acc.setPurchasedAppUsed(acc.getPurchasedAppUsed()+1);
                  }
                double afterdisc= price-(price*0.25);
                
                System.out.println("\n");
                System.out.println("You have purchased the app, with the 25% discount \n");
                System.out.println("Price before discount "+ price+" Price after discount " + afterdisc );
                price=afterdisc;
                

         } 
    }
    
     
    File newFile2 = new File(normal.getAbsolutePath()+".tmp");
    		  try(BufferedWriter writer = new BufferedWriter(new FileWriter(newFile2,true))){
    			for(Account ac2:Acc){
    			     writer.write(Integer.toString(ac2.getId()));
   			     writer.write(".");
   			     writer.write(ac2.getName());
   			     writer.write(".");
                             writer.write(ac2.getAddress());
   			     writer.write(".");
   			     writer.write(ac2.getProfession());
   			     writer.write(".");
                             writer.write(Integer.toString(ac2.getFreeAppsUsed()));
                             writer.write(".");
                             writer.write(Integer.toString(ac2.getPurchasedAppUsed()));
                             
                            
   			     writer.newLine();
   			     writer.flush();  
   		    
                        } writer.close();
                    student.delete();
                    newFile2.renameTo(student);
   	  
    		  
    		  } catch (IOException e) {
				System.out.println("No such file exists");
			}
                  
    Acc = storage.retrieveAccountDetails(developer, developerPath); 
    for(Account acc: Acc){

	 if(acc.getId()== number){
		 empty=true;
                 System.out.print("Account Number: " + acc.getId()+", ");
		 System.out.print(" Name of Account: " + acc.getName()+", ");
		 System.out.print("Account Address: " + acc.getAddress()+", ");
		 System.out.print("Account Profession:" + acc.getProfession()+", ");
		 System.out.print("Free apps used "+ acc.getFreeAppsUsed()+", ");
                 System.out.print("Purchased apps  "+ acc.getPurchasedAppUsed());
                 System.out.println("\n");
                  System.out.println("Developers cannot buy Apps ");

         } 
     }
    storeTransactions(number, appName,price);
     if(empty){
         System.out.println("You have purchased the app");
     }else{
     System.out.println("Name Entered Not Valid");
     
    } 
          

  }
     
public void storeTransactions(int accNum, String appName,double price){
storage.storeTransaction(accNum, appName,price);
}

  public void retrieveTransactions()
  {
   System.out.println("Transactions :");
    for (String a : this.storage.retrieveTransactions()) {
      System.out.println(a);
    }
  }
}
 





 
 
 









