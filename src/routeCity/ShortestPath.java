package routeCity;

import java.util.ArrayList;

public class ShortestPath {

    /**
     *
     * @param allNodes all nodes and their saved data
     * @param start the starting/current node the program is looking at
     * @param goal the node the program is looking for a way to
     * @return returns the shortest path from the start to the goal
     */
        public Node[] getShortestPath(ArrayList<Node> allNodes,Node start, Node goal){

            if (start.adjacentNodes.containsKey(goal)){
                return new Node[]{start,goal};
            }

            ArrayList<Node> possibleRoutes = new ArrayList();
            ArrayList<Node[]> foundRoutes = new ArrayList<>();

            return shortestPath(GPS(start,allNodes,foundRoutes,possibleRoutes, goal),goal);
        }

    /**
     *
     * @param node the starting/current node the program is looking at
     * @param allNodes all nodes and their saved data
     * @param foundRoutes an arraylist of arrays that saves all path that lead from start to goal
     * @param possibleRoutes an arraylist of nodes to prevent it from going in circles and finds arrays to add to foundarrays
     * @param goal the node the method is looking for a path to
     * @return see foundroutes
     */
        public ArrayList<Node[]> GPS(Node node, ArrayList<Node> allNodes, ArrayList<Node[]> foundRoutes, ArrayList<Node> possibleRoutes, Node goal){

            boolean willBreak = false;

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

    /**
     * find the shortest path from start to goal from the arraylist sent in
     * @param foundRoutes an arraylist of arrays with all paths that lead from start to goal
     * @param goal the node at the end of every array
     * @return the array from foundroutes that was the shortest
     */
        public Node[] shortestPath(ArrayList<Node[]> foundRoutes, Node goal){
            int distance = 101;
            int currentMeasure = 0;
            Node[] returnArr = new Node[0];
            for (Node[] foundRoute : foundRoutes) {
                for (int j = 0; j < foundRoute.length - 1; j++) {
                    currentMeasure += foundRoute[j].adjacentNodes.get(foundRoute[j + 1]);
                    if (foundRoute[j + 1].adjacentNodes.containsKey(goal)) {
                        if (currentMeasure < distance) {
                            distance = currentMeasure;
                            returnArr = foundRoute;
                        }
                        currentMeasure = 0;
                    }
                }
            }
            if (distance == 101) System.out.println(" no route found");
            return returnArr;
        }
    }