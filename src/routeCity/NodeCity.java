package routeCity;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class NodeCity {

        //int start = din start node
        int goal = 9;

        NodeCity(ArrayList<Node> allNodes){
            ArrayList<Node> possibleRoutes = new ArrayList();
            ArrayList<Node[]> foundRoutes = new ArrayList<>();

            System.out.println("entering node-city");
            shortestPath(allNodes,GPS(0,allNodes,foundRoutes,possibleRoutes));
        }

        ArrayList<Node[]> GPS(int node, ArrayList<Node> allNodes, ArrayList<Node[]> foundRoutes, ArrayList<Node> possibleRoutes){

            boolean willBreak = false;

            //find way from A to J
            for (int i = 0; i < allNodes.size(); i++) {

                for (int j = 0; j < possibleRoutes.size(); j++) {
                    if (possibleRoutes.get(j) == allNodes.get(i)) {
                        willBreak = true;
                    }
                }

                if (willBreak){
                    willBreak = false;
                    continue;
                }

                if (allNodes.get(node).adjacentNodes.containsKey(allNodes.get(i))){
                    possibleRoutes.add(allNodes.get(node));

                    if (allNodes.get(node).adjacentNodes.containsKey(allNodes.get(goal))){

                        //Node[] test = new Node[possibleRoutes.size()];
                        foundRoutes.add(new Node[possibleRoutes.size()]);
                        for (int j = 0; j < possibleRoutes.size(); j++) {
                            foundRoutes.get(foundRoutes.size()-1)[j] = possibleRoutes.get(j);
                        }
                        //foundRoutes.add(possibleRoutes);
                    }
                    else{
                        System.out.println("trying to go by " + (char)(i + 65));
                        GPS(i, allNodes,foundRoutes,possibleRoutes);
                    }
                    possibleRoutes.remove(possibleRoutes.size()-1);
                }
            }
            return foundRoutes;
        }


        private void shortestPath(ArrayList<Node> allNodes,ArrayList<Node[]> foundRoutes){

            int distance = 1000;
            int currentMeasure = 0;
            System.out.println(foundRoutes.size() + " routes were found");
            System.out.println(foundRoutes.get(0).length);
            for (int i = 0; i < foundRoutes.size(); i++) {

                System.out.println("arraylist " + i);

                System.out.println(foundRoutes.get(i).length);

                for (int j = 0; j < foundRoutes.get(i).length-1; j++) {
                    currentMeasure += foundRoutes.get(i)[j].adjacentNodes.get(foundRoutes.get(i)[j+1]);
                    System.out.println(currentMeasure);

                    if (foundRoutes.get(i)[j+1].adjacentNodes.containsKey(allNodes.get(goal))){
                        if (currentMeasure < distance) {
                            distance = currentMeasure;
                        }
                        currentMeasure = 0;
                        System.out.println("------");
                    }
                }
                }



                /*
                if (finalRoutes.get(i).equals(allNodes.get(goal)) && i == 0){
                    break;
                }
                System.out.println(finalRoutes.get(i));
                System.out.println(finalRoutes.get(i).adjacentNodes.get(finalRoutes.get(i+1)));
                currentMeasure += finalRoutes.get(i).adjacentNodes.get(finalRoutes.get(i+1));

                if (finalRoutes.get(i+1).adjacentNodes.containsKey(allNodes.get(goal))){
                    if (currentMeasure < distance) {
                        distance = currentMeasure;
                    }
                    currentMeasure = 0;
                    System.out.println("------");
                    i++;
                }
            }

                 */
            if (distance == 1000) System.out.println(" no route found");
            else System.out.println("the shortest path is " + distance);
        }
    }
