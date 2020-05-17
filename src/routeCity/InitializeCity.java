package routeCity;

import java.util.ArrayList;

public class InitializeCity {

    private GuiController guiController = new GuiController();

    private boolean[] loopedNodes = {false,false,false,false,false,false,false,false,false,false};
    private int nodesTrue = 0;

    /**
     * Uses all methods needed to create the allNodes Arraylist which is needed throughout the entire program.
     * The method loops if the nodes don't connect correctly and retries to create the Arraylist.
     */
    void initializeNodes(){
         ArrayList<Node> allNodes = new ArrayList<>();

         while (true) {
             if (checkIfConnected(0,createAllRoads(addNodesToArray(allNodes)))){
                 guiController.menu(allNodes);
                 break;
             } else {
                 setLoopedNodes();
                 for (Node allNode : allNodes) {
                     allNode.adjacentNodes.clear();
                     allNode.setMaxRoads(false);
                     allNode.setMinRoads(false);
                 }
                 allNodes.clear();
             }
         }
    }

    /**
     * This method uses addRoad() to create roads/connections and adds them to the nodes in allNodes until all of the
     * nodes has at least 2 roads each.
     * @param allNodes All nodes and their saved data.
     * @return The completed allNodes Arraylist.
     */
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

    /**
     *
     * @param follow
     * @param allNodes
     * @return
     */
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

    /**
     * Checks if a road already exists within allNodes or if the road is impossible to make if not add the new road.
     * @param from From the node the road will start.
     * @param destination To the node the road will lead.
     * @return If the road can be added or not. This is now only used for test reasons.
     */
    public boolean addRoad(Node from, Node destination){
        if (from.adjacentNodes.containsKey(destination)||from.getName().equals(destination.getName())||from.isMaxRoads() || destination.isMaxRoads()){
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

    /**
     * Counts the connected roads to the node and sets true on maximum/minimum roads if criteria is filled.
     * @param node The node to check.
     */
    public void countRoadsSetStatus(Node node){
        if (node.adjacentNodes.size() < 2){
            node.setMinRoads(false);
            node.setMaxRoads(false);
        }
        if (node.adjacentNodes.size() > 1){
            node.setMinRoads(true);
            node.setMaxRoads(false);
        }
        if (node.adjacentNodes.size()>2){
            node.setMaxRoads(true);
        }
    }

    /**
     * Create all nodes and adds them to allNodes ArrayList.
     * @param allNodes All nodes and their saved data.
     * @return allNodes with the added nodes.
     */
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

    /**
     * Resets loopedNodes and nodesTrue if the nodes aren't connected the first time.
     */
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