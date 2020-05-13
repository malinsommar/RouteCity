package routeCity;

import java.util.ArrayList;

public class InitializeCity {

    ArrayList<Node> allNodes = new ArrayList<>();
    ArrayList<Node> checkAllNodes = new ArrayList<>();

    private Node nodeA = new Node("A");
    private Node nodeB = new Node("B");
    private Node nodeC = new Node("C");
    private Node nodeD = new Node("D");
    private Node nodeE = new Node("E");
    private Node nodeF = new Node("F");
    private Node nodeG = new Node("G");
    private Node nodeH = new Node("H");
    private Node nodeI = new Node("I");
    private Node nodeJ = new Node("J");

    boolean[] loopedNodes = {false,false,false,false,false,false,false,false,false,false};
    int nodesTrue = 0;

    public void testTest(){

        addNodesToArray();
        createAllRoads();

        System.out.println("__________________________________");
        for (int i = 0; i <allNodes.size() ; i++) {
            if (nodeA.adjacentNodes.containsKey(allNodes.get(i))){
                System.out.println(allNodes.get(i).name);
                System.out.println(nodeA.adjacentNodes.get(allNodes.get(i)));
            }
        }



        /*for (int i = 0; i < allNodes.size(); i++) {
            System.out.println("Node nr: "+(i+1)+" = "+allNodes.get(i).adjacentNodes.size());
        }*/
        //soutAllRoads();

    }

    private boolean checkIfConnected(int follow){

        System.out.println("ait bois lets do dis");
        nodesTrue++;
        loopedNodes[follow] = true;
        System.out.println((char)(follow + 65) + " has " + allNodes.get(follow).adjacentNodes.size() + " adjacent nodes ");
        for (int i = 0; i <  allNodes.size(); i++) {
            //if (!loopedNodes[follow]){
            System.out.println(allNodes.get(follow).adjacentNodes.get(allNodes.get(i)));
            if (allNodes.get(follow).adjacentNodes.get(allNodes.get(i)) != null && allNodes.get(follow).adjacentNodes.get(allNodes.get(i)) < 10) {
                if (!loopedNodes[allNodes.get(follow).adjacentNodes.get(allNodes.get(i))]) {
                    checkIfConnected(allNodes.get(follow).adjacentNodes.get(allNodes.get(i)));
                }
            }
        }
        if (nodesTrue == 10) {
            System.out.println("everything working, good job simon");
            return true;
        }
        else{
            System.out.println(nodesTrue + " nodes are true");
            System.out.println("how did this happen?");
            return false;
        }

        //return isConnected();
    }

    //delete later
    boolean isConnected(){
        for (int i = 0; i < loopedNodes.length; i++) {
            System.out.println(loopedNodes[i]);
            if (!loopedNodes[i]){
                return false;
            }
        }
        return true;
    }

    //temp
    private void soutAllRoads(){
        for (int i = 0; i <allNodes.size(); i++) {
            for (int j = 0; j < allNodes.size(); j++) {
                System.out.println("___________________________");
                System.out.println("Node "+(i+1)+" to node "+(j+1));
                System.out.println(allNodes.get(i).adjacentNodes.containsKey(allNodes.get(j)));
                System.out.println("___________________________");
            }
        }
    }

    private void createAllRoads(){
        ArrayList<Node> tempArray = new ArrayList<>(allNodes);
        boolean done = true;

        while(true) {
            done = true;
            for (Node allNode : tempArray) {
                addRoad(allNode, tempArray.get((int)(Math.random() * tempArray.size())));
            }
            //Check if node should be removed.
            for (int i = 0; i < tempArray.size(); i++) {
                if (tempArray.get(i).maxRoads) {
                    System.out.println(tempArray.get(i).name + " removed");
                    tempArray.remove(i);
                }
            }
            //Check if all nodes has at least 2 roads.
            for (Node allNode : tempArray) {
                if (!allNode.minRoads) {
                    done = false;
                    break;
                }
            }
            if (done){
                if (checkIfConnected(0)){
                    System.out.println("Everything is connected");
                    break;
                }else {
                    System.out.println("Not connected");
                    System.exit(0);
                }
            }
        }
    }

    /*
    private boolean checkIfConnected(){
        checkAllNodes.addAll(allNodes);

        for (int i = 0; i <allNodes.size(); i++) {
            if (nodeA.adjacentNodes.containsKey(allNodes.get(i))){
                checkAllNodes.remove(allNodes.get(i));
                for (int j = 0; j <allNodes.size(); j++) {
                    if (allNodes.get(i).adjacentNodes.containsKey(allNodes.get(j))){
                        checkAllNodes.remove(allNodes.get(j));
                        for (Node allNode : allNodes) {
                            checkAllNodes.remove(allNode);
                        }
                    }
                }
            }
        }
        return checkAllNodes.isEmpty();
    }
     */

    //Checks if road already exists, if not add new road
    private void addRoad(Node from, Node destination){
        if (from.adjacentNodes.containsKey(destination)){
            System.out.println("Road already exists");
        }
        else if (from.maxRoads || destination.maxRoads){
            System.out.println("One of the nodes already has 3 connected roads.");
        } else {
            from.addDestination(destination);
            destination.addDestination(from);
            System.out.println("Road Added");
            countRoadsSetStatus(from);
            countRoadsSetStatus(destination);
        }
    }

    //Counts the connected roads to the node and sets true on maximum/minimum roads if criteria is filled.
    private void countRoadsSetStatus(Node node){
        if (node.adjacentNodes.size() > 1){
            node.minRoads = true;
        }
        if (node.adjacentNodes.size()>2){
            node.maxRoads = true;
        }
    }

    private void addNodesToArray(){
        allNodes.add(nodeA);
        allNodes.add(nodeB);
        allNodes.add(nodeC);
        allNodes.add(nodeD);
        allNodes.add(nodeE);
        allNodes.add(nodeF);
        allNodes.add(nodeG);
        allNodes.add(nodeH);
        allNodes.add(nodeI);
        allNodes.add(nodeJ);
    }
}