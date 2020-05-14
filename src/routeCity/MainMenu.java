package routeCity;

import java.awt.*;
import java.util.ArrayList;

public class MainMenu {

    private View view = new View();

    private ArrayList<Node> allNodes = new ArrayList<>();
    private boolean gpsPressed = false;

    Color green = new Color(46, 171, 77);
    Color orange = new Color(204, 151, 59);

    public void menu(ArrayList<Node> allNode){
        allNodes.addAll(allNode);
        view.setUpFrame();
        addActionListeners();
    }

    //Add all needed action listeners at the start of the program.
    public void addActionListeners(){

        view.nodeAButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive();
            } else {
                view.nodeAButton.setBackground(orange);
                findAdjacentNodes(0);
            }
        });

        view.nodeBButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive();
            } else {
                view.nodeBButton.setBackground(orange);
                findAdjacentNodes(1);
            }
        });

        view.nodeCButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive();
            } else {
                view.nodeCButton.setBackground(orange);
                findAdjacentNodes(2);
            }
        });

        view.nodeDButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive();
            } else {
                view.nodeDButton.setBackground(orange);
                findAdjacentNodes(3);
            }
        });

        view.nodeEButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive();
            } else {
                view.nodeEButton.setBackground(orange);
                findAdjacentNodes(4);
            }
        });

        view.nodeFButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive();
            } else {
                view.nodeFButton.setBackground(orange);
                findAdjacentNodes(5);
            }
        });

        view.nodeGButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive();
            } else {
                view.nodeGButton.setBackground(orange);
                findAdjacentNodes(6);
            }
        });

        view.nodeHButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive();
            } else {
                view.nodeHButton.setBackground(orange);
                findAdjacentNodes(7);
            }
        });

        view.nodeIButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive();
            } else {
                view.nodeIButton.setBackground(orange);
                findAdjacentNodes(8);
            }
        });

        view.nodeJButton.addActionListener(e->{
            resetViewButtons();
            if (gpsPressed){
                gpsActive();
            } else {
                view.nodeJButton.setBackground(orange);
                findAdjacentNodes(9);
            }
        });
    }

    //Checks which nodes the selected node is connected with.
    private void findAdjacentNodes(int node){
        for (Node allNode : allNodes) {
            if (allNodes.get(node).adjacentNodes.containsKey(allNode)) {
                String test = allNode.name;
                changeButton(test,node);
            }
        }
    }

    //Changes the color and text on the buttons when pressed.
    private void changeButton(String name, int fromNode){
        switch (name) {
            case "A":
                view.nodeAButton.setBackground(green);
                view.nodeAButton.setText("Node A ("+getDistance(fromNode,0)+")");
                break;
            case "B":
                view.nodeBButton.setBackground(green);
                view.nodeBButton.setText("Node B ("+getDistance(fromNode,1)+")");
                break;
            case "C":
                view.nodeCButton.setBackground(green);
                view.nodeCButton.setText("Node C ("+getDistance(fromNode,2)+")");
                break;
            case "D":
                view.nodeDButton.setBackground(green);
                view.nodeDButton.setText("Node D ("+getDistance(fromNode,3)+")");
                break;
            case "E":
                view.nodeEButton.setBackground(green);
                view.nodeEButton.setText("Node E ("+getDistance(fromNode,4)+")");
                break;
            case "F":
                view.nodeFButton.setBackground(green);
                view.nodeFButton.setText("Node F ("+getDistance(fromNode,5)+")");
                break;
            case "G":
                view.nodeGButton.setBackground(green);
                view.nodeGButton.setText("Node G ("+getDistance(fromNode,6)+")");
                break;
            case "H":
                view.nodeHButton.setBackground(green);
                view.nodeHButton.setText("Node H ("+getDistance(fromNode,7)+")");
                break;
            case "I":
                view.nodeIButton.setBackground(green);
                view.nodeIButton.setText("Node I ("+getDistance(fromNode,8)+")");
                break;
            case "J":
                view.nodeJButton.setBackground(green);
                view.nodeJButton.setText("Node J ("+getDistance(fromNode,9)+")");
                break;
        }
    }

    //Get the distance between two nodes
    int getDistance(int nodeFrom, int nodeTo){
        return allNodes.get(nodeFrom).adjacentNodes.get(allNodes.get(nodeTo));
    }

    private void gpsActive(){
        resetViewButtons();
        System.out.println("Select two roads");
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