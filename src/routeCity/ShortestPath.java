package routeCity;

import java.util.ArrayList;

public class ShortestPath {

        public Node[] getShortestPath(ArrayList<Node> allNodes,Node start, Node goal){
            ArrayList<Node> possibleRoutes = new ArrayList();
            ArrayList<Node[]> foundRoutes = new ArrayList<>();

            return shortestPath(GPS(start,allNodes,foundRoutes,possibleRoutes, goal),goal);
        }

        private ArrayList<Node[]> GPS(Node node, ArrayList<Node> allNodes, ArrayList<Node[]> foundRoutes, ArrayList<Node> possibleRoutes, Node goal){

            boolean willBreak = false;

            //find way from A to J
            for (int i = 0; i < allNodes.size(); i++) {

                for (Node possibleRoute : possibleRoutes) {
                    if (possibleRoute == allNodes.get(i)) {
                        willBreak = true;
                        break;
                    }
                }
                if (willBreak){
                    willBreak = false;
                    continue;
                }
                if (node.adjacentNodes.containsKey(allNodes.get(i))){
                    possibleRoutes.add(node);
                    if (node.adjacentNodes.containsKey(goal)){
                        foundRoutes.add(new Node[possibleRoutes.size()+1]);
                        for (int j = 0; j < possibleRoutes.size(); j++) {
                            foundRoutes.get(foundRoutes.size()-1)[j] = possibleRoutes.get(j);
                        }
                        foundRoutes.get(foundRoutes.size()-1)[foundRoutes.get(foundRoutes.size()-1).length-1] = goal;
                    }
                    else{
                        GPS(allNodes.get(i), allNodes,foundRoutes,possibleRoutes, goal);
                    }
                    possibleRoutes.remove(possibleRoutes.size()-1);
                }
            }
            return foundRoutes;
        }

        private Node[] shortestPath(ArrayList<Node[]> foundRoutes, Node goal){
            int distance = 101;
            int currentMeasure = 0;
            Node[] returnArr = new Node[0];
            for (int i = 0; i < foundRoutes.size(); i++) {

                for (int j = 0; j < foundRoutes.get(i).length-1; j++) {
                    currentMeasure += foundRoutes.get(i)[j].adjacentNodes.get(foundRoutes.get(i)[j+1]);

                    if (foundRoutes.get(i)[j+1].adjacentNodes.containsKey(goal)){
                        if (currentMeasure < distance) {
                            distance = currentMeasure;
                            returnArr = foundRoutes.get(i);
                        }
                        currentMeasure = 0;
                    }
                }
                }
            if (distance == 1000) System.out.println(" no route found");
            else System.out.println("the shortest path is " + distance);
            return returnArr;
        }
    }