package helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import model.Tokenizer;

public class GeneralHelpers {
    
    static Scanner myScanner = new Scanner(System.in);

    public static ArrayList<String> getUserInput(){

        myScanner.useDelimiter(";");
        String userInput = myScanner.next();
        ArrayList<String> splitedUserInput = Tokenizer.tokenizeUserInput(userInput);
         return splitedUserInput;

    }

    public static void createTable(ArrayList<String> splittedQuery){

        if (splittedQuery.size() < 5) {
            
            System.out.println("Llave, escribe bien mlp");
            return;

        }
        
        String fileName = splittedQuery.get(2) + ".cvs";
        String path = "src/myTables/";
        File directory = new File(path);

        try {
            
            File myTable = new File(directory+"\\"+fileName);
            new File(myTable.getParent()).mkdirs();
            if (myTable.createNewFile()) {

                String headers = "";

                for(int i = 3; i<splittedQuery.size(); i = i+2){


                        if (i == splittedQuery.size() - 2) {
                            
                            headers = headers + splittedQuery.get(i);

                            
                        }else{

                            headers = headers + splittedQuery.get(i) + ",";

                        }



                }

                FileWriter writer = new FileWriter(myTable);
                writer.write(headers);
                writer.close();
                //To do: Create properties

                System.out.println("Your table has been created succesfully!");
                getUserInput();
                
            }else{

                System.out.println("An error has ocurred while creating your table");
                getUserInput();


            }

          
        
        } catch (Exception e) {
            e.printStackTrace();
        }

                
        

        //trabajar aqui
        
    }

    
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }




    public static void closeProgram(){

        myScanner.close();
        
    }

    public static void listAbles(){

        String path = "src/myTables/";
        File directory = new File(path);

        File[] fileDirectory = directory.listFiles();
        

       for (int i = 0; i < fileDirectory.length; i++) {

            System.out.println(fileDirectory[i].getName());
        
       }

    }


    public static void insertInfo(String nameofTable){
    
        String path = "src/myTables/";
        File directory = new File(path);
        
        File[] fileDirectory = directory.listFiles();
        

        for (int i = 0; i < fileDirectory.length; i++) {
 
             if(fileDirectory[i].getName().equalsIgnoreCase(nameofTable + ".cvs")){ 

                try{  
                
                    FileWriter writer = new FileWriter("src/myTables/" + nameofTable + ".cvs", true);
                    writer.write("\n");
                    writer.write("IT WORKED");
                    writer.close();
                    
                }catch(IOException e){


                }

            }else{  

            //system print error that did not find

            }
         
        }
 
    }

  

}


