package routeCity;

import java.util.ArrayList;

public class NodeCity {

        private ArrayList<Node> possibleRoutes = new ArrayList();
        private ArrayList<Node> finalRoutes = new ArrayList<>();

        //int start = din start node
        int goal = 9;

        NodeCity(ArrayList<Node> allNodes){
            System.out.println("entering node-city");
            GPS(0, goal, allNodes);
            shortestPath(allNodes);
            System.exit(0);
        }





        //find path

        void GPS(int node, int forbidden, ArrayList<Node> allNodes){

            //find way from A to J
            for (int i = 0; i < allNodes.size(); i++) {

                if (i == forbidden){
                    continue;
                }

                if (allNodes.get(node).adjacentNodes.containsKey(allNodes.get(i))){
                    possibleRoutes.add(allNodes.get(node));

                    if (allNodes.get(node).adjacentNodes.containsKey(allNodes.get(goal))){
                        finalRoutes.addAll(possibleRoutes);
                        //System.exit(0);
                    }
                    else{
                        System.out.println("trying to go by " + (char)(i + 65));
                        GPS(i, node, allNodes);
                    }
                    possibleRoutes.remove(possibleRoutes.size()-1);
                }
            }
        }


        private void shortestPath(ArrayList<Node> allNodes){
            int distance = 1000;
            int currentMeasure = 0;
            System.out.println("finalroute is " + finalRoutes.size());
            for (int i = 0; i < finalRoutes.size()-1; i++) {
                System.out.println(finalRoutes.get(i));
                currentMeasure += finalRoutes.get(i).adjacentNodes.get(finalRoutes.get(i+1));

                if (finalRoutes.get(i).adjacentNodes.containsKey(goal)){
                    if (currentMeasure < distance) {
                        distance = currentMeasure;
                    }
                    currentMeasure = 0;
                    System.out.println("------");
                }
            }
            if (distance == 1000) System.out.println(" no route found");
            else System.out.println("the shortest path is " + distance);
        }
    }
