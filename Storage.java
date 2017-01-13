package shop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Storage {
	String fileLine;
	File sport = new File("C:\\appsfolder/sports.txt");
	File news = new File("C:\\appsfolder/news.txt");
	File games = new File("C:\\appsfolder/games.txt");
        File developer = new File("C:\\accountfolder/developer.txt");
        File normal = new File("C:\\accountfolder/normal.txt");
        File student = new File("C:\\accountfolder/student.txt");
        File academic = new File("C:\\accountfolder/academic.txt");
        
	public int numOfSpecificApp(File fileName){
		int num=0;
		if(fileName.exists()){
		try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
		  {
			while((br.readLine())!= null){
			
			num++;
			}
		  } catch (IOException e) {
			num=0; 
		}
		}
		return num;
	} 
        
        public int numOfSpecificAccount(File fileName){
		int totalNum=0;
		if(fileName.exists()){
		try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
		  {
			while((br.readLine())!= null){
			
			totalNum++;
			}
		  } catch (IOException e) {
			totalNum=0; 
		}
		}
		return totalNum;
	} 
	
	public int numTotalApps(){
		
		int num = numOfSpecificApp(sport)+numOfSpecificApp(news)+numOfSpecificApp(games);
		return num;
	}
        
        public int totalNumCustomers()
        {
            int totalNum = numOfSpecificAccount(normal)+numOfSpecificAccount(academic)+numOfSpecificAccount(student)+numOfSpecificAccount(developer);
            return totalNum;
        }
        
        
	
	public void storeAppDetails(Apps temp,File fileName,String path){
	try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true)))
		  {
		      
		      bw.write(temp.getNameOfApp());
		      bw.write(".");
		      bw.write(Integer.toString(Apps.getNumOfAppsAvailable()));
		      bw.write(".");
		      bw.write(temp.getAppDescription());
		      bw.write(".");
		      bw.write(Integer.toString(temp.getAppPopularity()));
		      bw.write(".");
		      bw.write(Integer.toString(temp.getAppPrice()));
		      bw.write(".");
		      if((path.equals("C:\\appsfolder/sports.txt"))){
		    	 
		    	  bw.write(Integer.toString(SportsApp.getSportsAppCount()));
		    	  }
		      else if(path.equals("C:\\appsfolder/news.txt")){
		    	  bw.write(Integer.toString(NewsApp.getNewsCount()));
		      }else if(path.equals("C:\\appsfolder/games.txt")){
		    	  bw.write(Integer.toString(GamesApp.getGamesCount()));
		      }
                      bw.write(".");
                      bw.write(temp.getDev().getName());
		     
		      bw.newLine();
		      bw.flush();
		     
		  }
		   catch(IOException e)
		          {
		          System.err.println("Creating files..."); 
		          }
}
        
        public void storeAccountDetails(Account acc,File fileName,String path){
	try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true)))
		  {
		      
		      bw.write(Integer.toString(acc.getId()));
		      bw.write(".");
		      bw.write(acc.getName());
		      bw.write(".");
		      bw.write(acc.getAddress());
		      bw.write(".");
		      bw.write(acc.getProfession());

                      bw.write(".");
                      bw.write(Integer.toString(acc.getFreeAppsUsed()));
                      bw.write(".");
                      bw.write(Integer.toString(acc.getPurchasedAppUsed()));
		     
		      bw.newLine();
		      bw.flush();
		     
		  }
		   catch(IOException e)
		          {
		          System.err.println("Creating files..."); 
		          }
        }
        
	public ArrayList<Apps> retrieveAppDetails(File fileName,String path){ 
		String[]temp = new String[7];
		ArrayList<Apps>app=new ArrayList<Apps>();
		
		String name;
		int numOfApps;
		String des;
		int popularity;
		int price;
		int i=0;
		int specificApp;
		String dev;
	try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
	
		  {
		    while((fileLine = br.readLine()) != null)
		    {
		    	
		    	temp = fileLine.split("\\.");
		    	
		    	name = temp[0];
		        numOfApps = Integer.parseInt(temp[1]);	        
		        des = temp[2];
		        popularity = Integer.parseInt(temp[3]);
		        price = Integer.parseInt(temp[4]);
		        specificApp = Integer.parseInt(temp[5]);
                        dev=temp[6];
		        if(path.equals("C:\\appsfolder/sports.txt")){
		        	SportsApp tApp = new SportsApp(name,des,numOfApps,popularity,price,specificApp,dev);
		        	app.add(i,tApp);
			        i++;
		        }else if(path.equals("C:\\appsfolder/news.txt")){
		        	NewsApp tApp = new NewsApp(name,des,numOfApps,popularity,price,specificApp,dev);
		        	app.add(i,tApp);
			        i++;
			      }else if(path.equals("C:\\appsfolder/games.txt")){
			    	  GamesApp tApp = new GamesApp(name,des,numOfApps,popularity,price,specificApp,dev);
			        	app.add(i,tApp);
				        i++;
			      }
		    }
		  }
		   catch(IOException e)
		   {
                    //System.err.println("No Apps exists in choosen file,enter number 0 and add some apps first.");
		   }
        
	return app;
	}
        
        public ArrayList<Account> retrieveAccountDetails(File fileName,String path){ 
		String[]acc = new String[5];
		ArrayList<Account> accounts =new ArrayList<Account>();
		
                int id;
		String name;
		String add;
                String profession;
		int i=0;
                int freeApps;
                int purchasedApps;
		
	try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
	
		  {
		    while((fileLine = br.readLine()) != null)
		    {
		    	
		    	acc = fileLine.split("\\.");
		    	
		    	id = Integer.parseInt(acc[0]);
		        name = acc[1];	        
		        add = acc[2];
		        profession = acc[3];
                        freeApps=Integer.parseInt(acc[4]);
                        purchasedApps=Integer.parseInt(acc[5]);
                       
                   
                        
                         if(path.equals("C:\\accountfolder/normal.txt")){
                             
		        	NormalAccount aAcc = new NormalAccount(id,name, add, profession,freeApps,purchasedApps);
		        	accounts.add(i,aAcc);
			        i++;
		              }else if(path.equals("C:\\accountfolder/academic.txt")){
			    	  AcademicAccount aAcc = new AcademicAccount(id, name, add, profession,freeApps,purchasedApps);
			       accounts.add(i,aAcc);
			        i++;
			      }else if(path.equals("C:\\accountfolder/student.txt")){
		        	StudentAccount aAcc = new StudentAccount(id, name, add, profession,freeApps,purchasedApps);
		        	accounts.add(i,aAcc);
			        i++;
			      }
                              else if(path.equals("C:\\accountfolder/developer.txt")){
                                 DeveloperAccount aAcc = new DeveloperAccount(id, name, add, profession,freeApps,purchasedApps); 
                                 accounts.add(i,aAcc);
                                 i++;
                              }	   
		        }
		  } 
		   catch(IOException e)
		   {
                       //System.err.println("No Accounts exists in choosen file, select 0 and to add some accounts first.");
		   }
	           return accounts;
	}
        public void storeGetApp(GetApp get){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\accountfolder/totalApps.txt")))
		  {
                     bw.write(Integer.toString(get.getNumberOfFree()));
                     bw.write(Integer.toString(get.getNumberOfPurchase()));
                  } catch (IOException ex) {
                Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void storeTransaction(int num,String app,double price){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\accountfolder/transaction.txt",true)))
		  {
                     bw.write(Integer.toString(num));
                     bw.write(".");
                     bw.write(app);
                     bw.write(".");
                     bw.write(Double.toString(price));
                      bw.newLine();
		      bw.flush();
                  } catch (IOException ex) {
                Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public ArrayList<String> retrieveTransactions(){
            ArrayList<String> list=new ArrayList();
            String[] acc=new String[3];
            int i=0;
            try(BufferedReader br = new BufferedReader(new FileReader("C:\\accountfolder/transaction.txt")))
	
		  {
		    while((fileLine = br.readLine()) != null)
		    {
		    	
		    	acc = fileLine.split("\\.");
                        list.add("Number of Account "+ acc[0]+" App name "+acc[1]+ "Price paid "+ acc[2]);
                        i++;
                    }
                  }catch (IOException ex) {
                Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
            }
	return list;	    	
        }
}
