package routeCity;

import java.util.ArrayList;

public class InitializeCity {

    //TODO fixa simons checkIfConnected()
    public MainMenu mainMenu = new MainMenu();

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

    boolean[] loopedNodes = {false,false,false,false,false,false,false,false,false,false};
    int nodesTrue = 0;

    void initializeNodes(){
        ArrayList<Node> allNodes = new ArrayList<>();
        mainMenu.menu(createAllRoads(addNodesToArray(allNodes)));
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
        if (!checkIfConnected(0,allNodes)){
            System.out.println("Not connected");
            //allNodes.replaceAll((UnaryOperator<Node>) replaceRoad(allNodes));
        } else
            System.out.println("Everything is connected");
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
}



  /*  //Searches for a node with mor
    public ArrayList<Node> replaceRoad(ArrayList<Node> allNodes){
        int roadMax = 0, roadMin = 0;

        while (allNodes.get(roadMax).maxRoads){
            roadMax++;
        }

        while (allNodes.get(roadMax).minRoads){
            roadMin++;
        }

        for (Node allNode : allNodes) {
            if (allNode.adjacentNodes.containsKey(allNodes.get(roadMax))) {
                //Remove roads
                allNode.adjacentNodes.remove(allNodes.get(roadMax));
                allNodes.get(roadMax).adjacentNodes.remove(allNode);
                //Count deleted nodes roads
                countRoadsSetStatus(allNodes.get(roadMax));
                countRoadsSetStatus(allNode);
                //Add new road
                addRoad(allNodes.get(roadMin),allNodes.get(roadMax));
            }
        }
        return allNodes;
    }*/

   /* public boolean checkIfConnected(ArrayList<Node> allNodes){
        ArrayList<Node> checkAllNodes = new ArrayList<>();
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
    }*/