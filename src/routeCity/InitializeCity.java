package routeCity;

import java.util.ArrayList;

public class InitializeCity {

    private MainMenu mainMenu = new MainMenu();

    private boolean[] loopedNodes = {false,false,false,false,false,false,false,false,false,false};
    private int nodesTrue = 0;

     void initializeNodes(){
         ArrayList<Node> allNodes = new ArrayList<>();

         while (true) {
             if (checkIfConnected(0,createAllRoads(addNodesToArray(allNodes)))){
                 System.out.println("Connected");
                 mainMenu.menu(allNodes);
                 break;
             } else {
                 System.out.println("Not connected");
                 setLoopedNodes();
                 for (Node allNode : allNodes) {
                     allNode.adjacentNodes.clear();
                     allNode.maxRoads = false;
                     allNode.minRoads = false;
                 }
                 allNodes.clear();
             }
         }
    }

    public ArrayList<Node> createAllRoads(ArrayList<Node> allNodes){
        boolean done;
        int stage = 0;

        while(true) {
            done = true;
            for (Node allNode : allNodes) {
                if (allNode.adjacentNodes.size() <= stage) {
                    addRoad(allNode, allNodes.get((int) (Math.random() * allNodes.size())));
                    done = false;
                }
            }
            if (done){
                if (stage == 0){
                    stage++;
                }else
                    break;
            }
        }
        return allNodes;
    }

    public boolean checkIfConnected(int follow, ArrayList<Node> allNodes){

        nodesTrue++;
        loopedNodes[follow] = true;
        for (int i = 0; i <  allNodes.size(); i++) {
            if (allNodes.get(follow).adjacentNodes.containsKey(allNodes.get(i))) {
                if (!loopedNodes[i]) {
                    checkIfConnected(i,allNodes);
                }
            }
        }
        return nodesTrue == 10;
    }

    //Checks if road already exists, if not add new road
    public boolean addRoad(Node from, Node destination){
        if (from.adjacentNodes.containsKey(destination)){
            //System.out.println("Road already exists");
            return false;
        }
        else if (from.name.equals(destination.name)){
            // System.out.println("Cant create road between the same node.");
            return false;
        }
        else if (from.maxRoads || destination.maxRoads){
            // System.out.println("One of the nodes already has 3 connected roads.");
            return false;
        } else {
            int distance = (int)(Math.random()*10)+1;
            from.addDestination(destination,distance);
            destination.addDestination(from, distance);
            countRoadsSetStatus(from);
            countRoadsSetStatus(destination);
            return true;
        }
    }

    //Counts the connected roads to the node and sets true on maximum/minimum roads if criteria is filled.
    public void countRoadsSetStatus(Node node){
        if (node.adjacentNodes.size() < 2){
            node.minRoads = false;
            node.maxRoads = false;
        }
        if (node.adjacentNodes.size() > 1){
            node.minRoads = true;
        }
        if (node.adjacentNodes.size()>2){
            node.maxRoads = true;
        }
    }

    public ArrayList<Node> addNodesToArray(ArrayList<Node> allNodes){
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");
        Node nodeJ = new Node("J");

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
        return allNodes;
    }

    private void setLoopedNodes(){
        nodesTrue = 0;

        loopedNodes[0] = false;
        loopedNodes[1] = false;
        loopedNodes[2] = false;
        loopedNodes[3] = false;
        loopedNodes[4] = false;
        loopedNodes[5] = false;
        loopedNodes[6] = false;
        loopedNodes[7] = false;
        loopedNodes[8] = false;
        loopedNodes[9] = false;
    }
}