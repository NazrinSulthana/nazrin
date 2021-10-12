

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Urldatabase {
    private Map<String,Integer> urlStoreTable = new HashMap<>();
    public static void main(String[] args) {
        Urldatabase obj = new Urldatabase();
        obj.getUserInput();
    } 
    public void getUserInput() {
        try(Scanner scanner = new Scanner(System.in)){
            userInputLoop:
            while(true){
                String userCommand = scanner.nextLine();
                String[] wordArray = userCommand.split(" ");
                if(wordArray.length != 0) {
                    switch(wordArray[0]) {
                        case "storeurl": 
                            if(wordArray.length > 1 && wordArray[1] != null) {
                                urlStoreTable.put(wordArray[1], 0);
                            } else {
                                System.out.println("Enter any url parameter");
                            }
                            break;
                        case "get":
                            if(wordArray.length > 1 && wordArray[1] != null) {
                                Integer urlCount = urlStoreTable.get(wordArray[1]);
                                if(urlCount != null) {
                                    urlStoreTable.put(wordArray[1], ++urlCount);
                                    System.out.println(wordArray[1]);
                                } else {
                                    System.out.println("No such url exist");
                                }
                            } else {
                                System.out.println("Enter any url parameter");
                            }
                            break;
                        case "count":
                            if(wordArray.length > 1 && wordArray[1] != null) {
                                Integer urlCount = urlStoreTable.get(wordArray[1]);
                                if(urlCount != null) {
                                    System.out.println(urlCount);
                                } else {
                                    System.out.println("No such url exist");
                                }
                            } else {
                                System.out.println("Enter any url parameter");
                            }
                            break;
                        case "list":
                            System.out.println(urlStoreTable);break;
                        case "exit":
                            break userInputLoop;
                        default: 
                            System.out.println("Enter Proper Command");break;                           
                    }
                }
            }
        }
    }  
}