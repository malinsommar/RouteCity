package routeCity;

import java.util.ArrayList;

public class StringCity {

    private ArrayList<String> allRoutes = new ArrayList();
    private ArrayList<String> possibleRoutes = new ArrayList();
    private ArrayList<String> finalRoutes = new ArrayList<>();
    private String endGoal = "J";

    StringCity(){
        System.out.println();
        stringRoads();
        GPS("A", 9);
        shortestPath();
        System.exit(0);
    }


    //make first roads to nodes
    void stringRoads(){

        //  1-A 2-B 3-C 4-D 5-E 6-F 7-G 8-H 9-I 10-J
        for (int i = 0; i < 10; i++) {
            char from = (char)(i + 65);
            char to =  (char)(int)((Math.random()*10)+65);
            if (from==to){i--; continue;} //road to itself, restart
            char distance = (char)(int)((Math.random()*10)+48);
            char[] node = {from,to,distance};

            String full = String.copyValueOf(node);
            allRoutes.add(full);
        }

        for (int i = 0; i < 10; i++) {
            char[] node = {allRoutes.get(i).charAt(1),allRoutes.get(i).charAt(0),allRoutes.get(i).charAt(2)};
            String full = String.copyValueOf(node);
            allRoutes.add(full);
        }

        for (int i = 0; i < allRoutes.size(); i++) {
            if (i == 10) System.out.println("----------------------");
            System.out.println(allRoutes.get(i));
        }
    }





    //find path

    void GPS(String letter, int forbidden){


        //find way from A to J
        for (int i = 0; i < 10; i++) {
            
            if ((allRoutes.get(i).contains(String.valueOf(allRoutes.get(forbidden).charAt(0)))) && (allRoutes.get(i).contains(String.valueOf(allRoutes.get(forbidden).charAt(1))))){
                System.out.println("continued at " + allRoutes.get(i) + " forbidden letter is: " + allRoutes.get(forbidden));
                continue;
            }

            if (allRoutes.get(i).contains(letter)){
                possibleRoutes.add(allRoutes.get(i));

                if (allRoutes.get(i).contains(endGoal)){
                    System.out.println("full route found at" + allRoutes.get(i));
                    finalRoutes.addAll(possibleRoutes);
                    //System.exit(0);
                }
                else{
                    char letterToSend; //space ascii value = 32

                    //uses the other letter in the string
                        if (allRoutes.get(i).charAt(0) == letter.charAt(0)) {
                            letterToSend = allRoutes.get(i).charAt(1);
                        }
                        else{
                            letterToSend = allRoutes.get(i).charAt(0);
                        }
                    System.out.println("trying to go by " + allRoutes.get(i));
                    GPS(String.valueOf(letterToSend), i);
                }
                possibleRoutes.remove(possibleRoutes.size()-1);
            }
        }
    }

    private void shortestPath(){
        int distance = 1000;
        int currentMeasure = 0;
        System.out.println("finalroute is " + finalRoutes.size());
        for (int i = 0; i < finalRoutes.size(); i++) {
            System.out.println(finalRoutes.get(i));
            currentMeasure += finalRoutes.get(i).charAt(2)-48;

            if (finalRoutes.get(i).contains(endGoal)){
                if (currentMeasure < distance) {
                    distance = currentMeasure;
                }
                    currentMeasure = 0;
            }
        }
        if (distance == 0) System.out.println(" no route found");
        else System.out.println("the shortest path is " + distance);
    }
}
