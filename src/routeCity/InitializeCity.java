package routeCity;

import java.util.ArrayList;

public class InitializeCity {

    ArrayList<Node> allNodes = new ArrayList<>();

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

    private void manualBuild(){
        addNodesToArray();

        addRoad(nodeA,nodeD);
        addRoad(nodeA,nodeI);
        addRoad(nodeB,nodeC);
        addRoad(nodeB,nodeF);
        addRoad(nodeB,nodeJ);
        addRoad(nodeC,nodeI);
        addRoad(nodeC,nodeH);
        addRoad(nodeD,nodeF);
        addRoad(nodeE,nodeG);
        addRoad(nodeE,nodeH);
        addRoad(nodeF,nodeJ);
        addRoad(nodeG,nodeI);
    }

    //Checks if road already exists, if not add new road
    private void addRoad(Node from, Node destination){
        if (from.adjacentNodes.containsKey(destination)){
            System.out.println("Road already exists");
        }
        else if (from.threeRoads || destination.threeRoads){
            System.out.println("One of the nodes already has 3 connected roads.");
        } else {
            System.out.println("Road Added");
            from.addDestination(destination);
            destination.addDestination(from);

            countRoads(from);
            countRoads(destination);
        }
    }

    //Count roads connected to node
    private void countRoads(Node node){
        System.out.println("start");
        int roads = 0;
        for (Node allNode : allNodes) {
            System.out.println(node.adjacentNodes.containsKey(allNode));
            if (node.adjacentNodes.containsKey(allNode)) {
                roads++;
            }
        }
        if (roads==3){
            node.threeRoads = true;
        }
    }

    //Returns a random number that represents a node.
    private int getRandomNode(){
        return (int)(Math.random()*10);
    }

    //Add all nodes to array.
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