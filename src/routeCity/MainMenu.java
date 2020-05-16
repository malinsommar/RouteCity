package routeCity;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu {

    private View view = new View();

    //private ArrayList<Node> allNodes = new ArrayList<>();
    private boolean gpsPressed = false, firstNodeSaved= false;

    private Node fromNode, destinationNode;

    private Color green = new Color(46, 171, 77);
    private Color orange = new Color(204, 151, 59);

    public void menu(ArrayList<Node> allNode){
        view.setUpFrame();
        addActionListeners(allNode);
    }

    //Add all needed action listeners at the start of the program.
    public void addActionListeners(ArrayList<Node> allNodes){

        view.nodeAButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive(allNodes.get(0),allNodes);
            } else {
                view.nodeAButton.setBackground(orange);
                findAdjacentNodes(0,allNodes);
            }
        });

        view.nodeBButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive(allNodes.get(1),allNodes);
            } else {
                view.nodeBButton.setBackground(orange);
                findAdjacentNodes(1,allNodes);
            }
        });

        view.nodeCButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive(allNodes.get(2),allNodes);
            } else {
                view.nodeCButton.setBackground(orange);
                findAdjacentNodes(2,allNodes);
            }
        });

        view.nodeDButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive(allNodes.get(3),allNodes);
            } else {
                view.nodeDButton.setBackground(orange);
                findAdjacentNodes(3,allNodes);
            }
        });

        view.nodeEButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive(allNodes.get(4),allNodes);
            } else {
                view.nodeEButton.setBackground(orange);
                findAdjacentNodes(4,allNodes);
            }
        });

        view.nodeFButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive(allNodes.get(5),allNodes);
            } else {
                view.nodeFButton.setBackground(orange);
                findAdjacentNodes(5,allNodes);
            }
        });

        view.nodeGButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive(allNodes.get(6),allNodes);
            } else {
                view.nodeGButton.setBackground(orange);
                findAdjacentNodes(6,allNodes);
            }
        });

        view.nodeHButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive(allNodes.get(7),allNodes);
            } else {
                view.nodeHButton.setBackground(orange);
                findAdjacentNodes(7,allNodes);
            }
        });

        view.nodeIButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive(allNodes.get(8),allNodes);
            } else {
                view.nodeIButton.setBackground(orange);
                findAdjacentNodes(8,allNodes);
            }
        });

        view.nodeJButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive(allNodes.get(9),allNodes);
            } else {
                view.nodeJButton.setBackground(orange);
                findAdjacentNodes(9,allNodes);
            }
        });

        view.searchShortestPathButton.addActionListener(e->{
            gpsPressed = true;
            resetViewButtons();
            System.out.println("Chose 2 nodes");
        });
    }

    //Checks which nodes the selected node is connected with.
    private void findAdjacentNodes(int node, ArrayList<Node> allNodes){
        for (Node allNode : allNodes) {
            if (allNodes.get(node).adjacentNodes.containsKey(allNode)) {
                String test = allNode.name;
                changeButton(test,node,allNodes);
            }
        }
    }

    //Changes the color and text on the buttons when pressed.
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

    //Get the distance between two nodes
    int getDistance(int nodeFrom, int nodeTo, ArrayList<Node> allNodes){
        return allNodes.get(nodeFrom).adjacentNodes.get(allNodes.get(nodeTo));
    }

    private void gpsActive(Node node, ArrayList<Node> allNodes){
        if (!firstNodeSaved){
            fromNode = node;
            firstNodeSaved = true;
        }else {
            destinationNode = node;
            firstNodeSaved = false;
            NodeCity nodeCity = new NodeCity();
            Node[] test = nodeCity.getShortestPath(allNodes,fromNode,destinationNode);
            for (int i = 0; i < test.length; i++) {
                System.out.println(test[i].name);
            }
            firstNodeSaved = false;
        }
        gpsPressed = false;
    }

    //Reset view to original look.
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