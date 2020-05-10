package routeCity;

import java.util.ArrayList;

public class InitializeCity {

    //TODO Programmet krashar ibland när jag lade till att det inte kan gå från a-a

    ArrayList<Node> allNodes = new ArrayList<>();
    ArrayList<Node> checkAllNodes = new ArrayList<>();

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

    public ArrayList<Node> initializeNodes(){

        addNodesToArray();
        createAllRoads();

        return allNodes;
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
                    //System.out.println(tempArray.get(i).name + " removed");
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
                if (checkIfConnected()){
                    System.out.println("Everything is connected");
                    break;
                }else {
                    System.out.println("Not connected");
                    System.exit(0);
                }
            }
        }
    }

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

    void simon(int follow){
        for (int i = 0; i <  allNodes.get(follow).adjacentNodes.size(); i++) {
            if (!loopedNodes[follow]){
                nodesTrue++;
                loopedNodes[follow] = true;
                simon(allNodes.get(follow).adjacentNodes.get(allNodes.get(i)));
            }
        }
    }

    //Checks if road already exists, if not add new road
    private void addRoad(Node from, Node destination){
        if (from.adjacentNodes.containsKey(destination)){
            System.out.println("Road already exists");
        }
        else if (from.name.equals(destination.name)){
            System.out.println("Cant create road between the same node.");
        }
        else if (from.maxRoads || destination.maxRoads){
            System.out.println("One of the nodes already has 3 connected roads.");
        } else {
            int distance = (int)(Math.random()*10)+1;
            from.addDestination(destination,distance);
            destination.addDestination(from, distance);
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