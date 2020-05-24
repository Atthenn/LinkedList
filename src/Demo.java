import sun.plugin.javascript.navig.Link;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToView = new LinkedList<String>();
        addInOrder(placesToView,"Sydney");
        addInOrder(placesToView,"Melbourne");
        addInOrder(placesToView,"Brisbane");
        addInOrder(placesToView,"Perth");
        addInOrder(placesToView,"Adeliade");
        addInOrder(placesToView,"Darvin");
        printList(placesToView);
        addInOrder(placesToView,"Alice Spring");
        addInOrder(placesToView,"Darvin");

        printList(placesToView);

        visit(placesToView);

//        placesToView.add("Sydney");
//        placesToView.add("Melbourne");
//        placesToView.add("Brisbane");
//        placesToView.add("Perth");
//        placesToView.add("Adeliade");
//        placesToView.add("Darvin");

//        printList(placesToView);
//        placesToView.add(1,"Alice Spring");
//        printList(placesToView);
//        placesToView.remove(4);
//        printList(placesToView);


    }

    private static void printList(LinkedList<String> linkedList) {

        Iterator<String> i = linkedList.iterator();
        while(i.hasNext()){
            System.out.println("Now visiting " + i.next());

        }
        System.out.println("===============================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList,String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0 ){
                System.out.println(newCity + " is already included ");
                return false;
            }else if (comparison > 0){
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }else if (comparison < 0){

            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward =true;
        ListIterator<String> listIterator = cities.listIterator();
        if(cities.isEmpty()){
            System.out.println("No cities in the itenary");
            return;
        }else{
            System.out.println("Now Visiting " + listIterator.next());
            printMenu();
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Holiday over");
                    break;

                case 1:
                    if(!goingForward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now visiting " + listIterator.next());
                    }else{
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now visiting " + listIterator.previous());
                    }else{
                        System.out.println("we are at the start of the list");
                        goingForward =  true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }

        }


    }

    private static void printMenu() {
        System.out.println("Available actions :\n press");
        System.out.println("0 - to quit\n" +
               "1 - go to next city\n"+
                "2 - go to previous city\n"+
                "3 - print menu options");

    }
}
