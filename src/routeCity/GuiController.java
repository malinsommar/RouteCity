package routeCity;

import java.awt.*;
import java.util.ArrayList;

class GuiController {

    private View view = new View();
    private boolean gpsPressed = false, firstNodeSaved= false;
    private Node fromNode;
    private Color green = new Color(46, 171, 77);
    private Color orange = new Color(204, 151, 59);

    /**
     * This method uses needed method to set up the GUI.
     * @param allNode All nodes and their saved data.
     */
    void menu(ArrayList<Node> allNode){
        view.setUpFrame();
        addActionListeners(allNode);
        System.out.println("Welcome to Route City!\nTo check a nodes connections, simply press a node.\nChosen node will turn orange, the connected nodes will turn green and show a number that represents the distance between the nodes.\nTo find the shortest path between two nodes, press the button in the lower left corner and then select two nodes. ");
    }

    /**
     * Adds all needed action listeners at the start of the program.
     * @param allNodes All nodes and their saved data.
     */
    private void addActionListeners(ArrayList<Node> allNodes){

        view.nodeAButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                view.nodeAButton.setBackground(orange);
                gpsActive(allNodes.get(0),allNodes);
            } else {
                findAdjacentNodes(0,allNodes);
                view.nodeAButton.setBackground(orange);
            }
        });

        view.nodeBButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                view.nodeBButton.setBackground(orange);
                gpsActive(allNodes.get(1),allNodes);
            } else {
                findAdjacentNodes(1,allNodes);
                view.nodeBButton.setBackground(orange);
            }
        });

        view.nodeCButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                view.nodeCButton.setBackground(orange);
                gpsActive(allNodes.get(2),allNodes);
            } else {
                findAdjacentNodes(2,allNodes);
                view.nodeCButton.setBackground(orange);
            }
        });

        view.nodeDButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                view.nodeDButton.setBackground(orange);
                gpsActive(allNodes.get(3),allNodes);
            } else {
                findAdjacentNodes(3,allNodes);
                view.nodeDButton.setBackground(orange);
            }
        });

        view.nodeEButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                view.nodeEButton.setBackground(orange);
                gpsActive(allNodes.get(4),allNodes);
            } else {
                findAdjacentNodes(4,allNodes);
                view.nodeEButton.setBackground(orange);
            }
        });

        view.nodeFButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                view.nodeFButton.setBackground(orange);
                gpsActive(allNodes.get(5),allNodes);
            } else {
                findAdjacentNodes(5,allNodes);
                view.nodeFButton.setBackground(orange);
            }
        });

        view.nodeGButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                view.nodeGButton.setBackground(orange);
                gpsActive(allNodes.get(6),allNodes);
            } else {
                findAdjacentNodes(6,allNodes);
                view.nodeGButton.setBackground(orange);
            }
        });

        view.nodeHButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                view.nodeHButton.setBackground(orange);
                gpsActive(allNodes.get(7),allNodes);
            } else {
                findAdjacentNodes(7,allNodes);
                view.nodeHButton.setBackground(orange);
            }
        });

        view.nodeIButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                view.nodeIButton.setBackground(orange);
                gpsActive(allNodes.get(8),allNodes);
            } else {
                view.nodeIButton.setBackground(orange);
                findAdjacentNodes(8,allNodes);
                view.nodeIButton.setBackground(orange);
            }
        });

        view.nodeJButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                view.nodeJButton.setBackground(orange);
                gpsActive(allNodes.get(9),allNodes);
            } else {
                view.nodeJButton.setBackground(orange);
                findAdjacentNodes(9,allNodes);
                view.nodeJButton.setBackground(orange);
            }
        });

        view.searchShortestPathButton.addActionListener(e->{
            gpsPressed = true;
            resetViewButtons();
        });
    }

    /**
     * Sends all of the connected nodes to changeButton().
     * @param node The node to search for connected nodes.
     * @param allNodes All nodes and their saved data.
     */
    private void findAdjacentNodes(int node, ArrayList<Node> allNodes){
        for (Node allNode : allNodes) {
            if (allNodes.get(node).adjacentNodes.containsKey(allNode)) {
                String test = allNode.getName();
                changeButton(test,node,allNodes);
            }
        }
    }

    /**
     * Changes the color and distance text on the buttons. Which button depends on the fromNode.
     * @param name Name of the node.
     * @param fromNode The selected node.
     * @param allNodes All nodes and their saved data.
     */
    private void changeButton(String name, int fromNode, ArrayList<Node> allNodes){
        switch (name) {
            case "A":
                view.nodeAButton.setBackground(green);
                view.nodeAButton.setText("Node A ("+getDistance(fromNode,0,allNodes)+")");
                break;
            case "B":
                view.nodeBButton.setBackground(green);
                view.nodeBButton.setText("Node B ("+getDistance(fromNode,1,allNodes)+")");
                break;
            case "C":
                view.nodeCButton.setBackground(green);
                view.nodeCButton.setText("Node C ("+getDistance(fromNode,2,allNodes)+")");
                break;
            case "D":
                view.nodeDButton.setBackground(green);
                view.nodeDButton.setText("Node D ("+getDistance(fromNode,3,allNodes)+")");
                break;
            case "E":
                view.nodeEButton.setBackground(green);
                view.nodeEButton.setText("Node E ("+getDistance(fromNode,4,allNodes)+")");
                break;
            case "F":
                view.nodeFButton.setBackground(green);
                view.nodeFButton.setText("Node F ("+getDistance(fromNode,5,allNodes)+")");
                break;
            case "G":
                view.nodeGButton.setBackground(green);
                view.nodeGButton.setText("Node G ("+getDistance(fromNode,6,allNodes)+")");
                break;
            case "H":
                view.nodeHButton.setBackground(green);
                view.nodeHButton.setText("Node H ("+getDistance(fromNode,7,allNodes)+")");
                break;
            case "I":
                view.nodeIButton.setBackground(green);
                view.nodeIButton.setText("Node I ("+getDistance(fromNode,8,allNodes)+")");
                break;
            case "J":
                view.nodeJButton.setBackground(green);
                view.nodeJButton.setText("Node J ("+getDistance(fromNode,9,allNodes)+")");
                break;
        }
    }

    /**
     * Get the distance between the first and second node.
     * @param nodeFrom First node.
     * @param nodeTo Second node.
     * @param allNodes All nodes and their saved data.
     * @return The distance between the first and second node.
     */
    private int getDistance(int nodeFrom, int nodeTo, ArrayList<Node> allNodes){
        return allNodes.get(nodeFrom).adjacentNodes.get(allNodes.get(nodeTo));
    }

    /**
     * Updates the gui when shortest path is pressed. First time the method is used it updates the global fromNode with node.
     * The next time it uses the ShortestPath class to get and print out the shortest path between the chosen nodes.
     * @param node The chosen node.
     * @param allNodes All nodes and their saved data.
     */
    private void gpsActive(Node node, ArrayList<Node> allNodes){
        if (!firstNodeSaved){
            fromNode = node;
            firstNodeSaved = true;
        }else {

            ShortestPath nodeCity = new ShortestPath();
            StringBuilder nodeNames = new StringBuilder();
            int totalDistance = 0;
            Node[] shortestPath = nodeCity.getShortestPath(allNodes,fromNode, node);

            for (int i = 0; i < shortestPath.length; i++) {
                if (i == shortestPath.length-1){
                    nodeNames.append(shortestPath[i].getName());
                }else {
                    nodeNames.append(shortestPath[i].getName()).append(" (").append(shortestPath[i].adjacentNodes.get(shortestPath[i + 1])).append(") ");
                    totalDistance += shortestPath[i].adjacentNodes.get(shortestPath[i+1]);
                }
            }
            view.shortestLabel.setText("Shortest path from "+fromNode.getName()+" to "+ node.getName()+":");
            view.shortestPath.setText(String.valueOf(nodeNames));
            view.totalDistanceLabel.setText("Total distance: "+totalDistance);
            view.shortestPath.setVisible(true);
            view.totalDistanceLabel.setVisible(true);
            view.shortestLabel.setVisible(true);
            firstNodeSaved = false;
            gpsPressed = false;
            resetViewButtons();
        }
    }

    /**
     * Reset panel to original look.
     */
    private void resetViewButtons(){
        view.nodeAButton.setBackground(Color.white);
        view.nodeAButton.setText("Node A");
        view.nodeBButton.setBackground(Color.white);
        view.nodeBButton.setText("Node B");
        view.nodeCButton.setBackground(Color.white);
        view.nodeCButton.setText("Node C");
        view.nodeDButton.setBackground(Color.white);
        view.nodeDButton.setText("Node D");
        view.nodeEButton.setBackground(Color.white);
        view.nodeEButton.setText("Node E");
        view.nodeFButton.setBackground(Color.white);
        view.nodeFButton.setText("Node F");
        view.nodeGButton.setBackground(Color.white);
        view.nodeGButton.setText("Node G");
        view.nodeHButton.setBackground(Color.white);
        view.nodeHButton.setText("Node H");
        view.nodeIButton.setBackground(Color.white);
        view.nodeIButton.setText("Node I");
        view.nodeJButton.setBackground(Color.white);
        view.nodeJButton.setText("Node J");
    }
}