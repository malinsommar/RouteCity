package routeCity;

import javax.swing.*;
import java.awt.*;

public class View {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel pathCity;
    JButton searchShortestPathButton,nodeAButton,nodeBButton,nodeCButton,nodeDButton,nodeEButton,nodeFButton,nodeGButton,nodeHButton,nodeIButton,nodeJButton;
    JLabel shortestLabel = new JLabel("Shortest path between * and *:");
    JLabel shortestPath = new JLabel("                                                  ");
    JLabel totalDistanceLabel = new JLabel("Total distance:     ");

    /**
     * Creates the JFrame and JPanel.
     */
    public void setUpFrame(){

        frame.setBounds(350,30,650,650);
        frame.setLayout(null);

        panel.setBounds(0,0,650,650);
        panel.setLayout(null);

        createButtonsAndLabels();

        frame.add(panel);
        panel.add(shortestPath);
        panel.add(totalDistanceLabel);
        panel.add(shortestLabel);
        panel.add(nodeAButton);
        panel.add(nodeBButton);
        panel.add(nodeCButton);
        panel.add(nodeDButton);
        panel.add(nodeEButton);
        panel.add(nodeFButton);
        panel.add(nodeGButton);
        panel.add(nodeHButton);
        panel.add(nodeIButton);
        panel.add(nodeJButton);
        panel.add(searchShortestPathButton);
        panel.add(pathCity);

        panel.setVisible(true);
        frame.setVisible(true);
    }

    /**
     * Creates the buttons and Labels needed for the panel.
     */
    private void createButtonsAndLabels(){

        shortestPath.setForeground(Color.black);
        Dimension size = shortestPath.getPreferredSize();
        shortestPath.setBounds(370, 530, size.width+100, size.height);

        shortestLabel.setForeground(Color.black);
        Dimension size2 = shortestLabel.getPreferredSize();
        shortestLabel.setBounds(370, 500, size2.width+100, size2.height);
        shortestLabel.setVisible(false);

        pathCity = new JLabel("Path City");
        pathCity.setForeground(Color.black);
        pathCity.setFont(new Font("serif", Font.PLAIN,30));
        Dimension size3 = pathCity.getPreferredSize();
        pathCity.setBounds(270, 5, size3.width+100, size3.height);

        totalDistanceLabel.setForeground(Color.black);
        Dimension size4 = totalDistanceLabel.getPreferredSize();
        totalDistanceLabel.setBounds(370, 560, size4.width+100, size4.height);
        totalDistanceLabel.setVisible(false);

        nodeAButton = new JButton("Node A");
        nodeAButton.setSize(100, 100);
        nodeAButton.setLocation(50, 50);
        nodeAButton.setBackground(Color.white);
        nodeAButton.setBorder(null);
        nodeAButton.setFocusPainted(false);

        nodeBButton = new JButton("Node B");
        nodeBButton.setSize(100, 100);
        nodeBButton.setLocation(200, 50);
        nodeBButton.setBackground(Color.white);
        nodeBButton.setBorder(null);
        nodeBButton.setFocusPainted(false);

        nodeCButton = new JButton("Node C");
        nodeCButton.setSize(100, 100);
        nodeCButton.setLocation(350, 50);
        nodeCButton.setBackground(Color.white);
        nodeCButton.setBorder(null);
        nodeCButton.setFocusPainted(false);

        nodeDButton = new JButton("Node D");
        nodeDButton.setSize(100, 100);
        nodeDButton.setLocation(500, 50);
        nodeDButton.setForeground(Color.black);
        nodeDButton.setBackground(Color.white);
        nodeDButton.setBorder(null);
        nodeDButton.setFocusPainted(false);

        nodeEButton = new JButton("Node E");
        nodeEButton.setSize(100, 100);
        nodeEButton.setLocation(50, 200);
        nodeEButton.setBackground(Color.white);
        nodeEButton.setBorder(null);
        nodeEButton.setFocusPainted(false);

        nodeFButton = new JButton("Node F");
        nodeFButton.setSize(100, 100);
        nodeFButton.setLocation(500, 200);
        nodeFButton.setBackground(Color.white);
        nodeFButton.setBorder(null);
        nodeFButton.setFocusPainted(false);

        nodeGButton = new JButton("Node G");
        nodeGButton.setSize(100, 100);
        nodeGButton.setLocation(50, 350);
        nodeGButton.setBackground(Color.white);
        nodeGButton.setBorder(null);
        nodeGButton.setFocusPainted(false);

        nodeHButton = new JButton("Node H");
        nodeHButton.setSize(100, 100);
        nodeHButton.setLocation(200, 350);
        nodeHButton.setBackground(Color.white);
        nodeHButton.setBorder(null);
        nodeHButton.setFocusPainted(false);

        nodeIButton = new JButton("Node I");
        nodeIButton.setSize(100, 100);
        nodeIButton.setLocation(350, 350);
        nodeIButton.setBackground(Color.white);
        nodeIButton.setBorder(null);
        nodeIButton.setFocusPainted(false);

        nodeJButton = new JButton("Node J");
        nodeJButton.setSize(100, 100);
        nodeJButton.setLocation(500, 350);
        nodeJButton.setBackground(Color.white);
        nodeJButton.setBorder(null);
        nodeJButton.setFocusPainted(false);

        searchShortestPathButton = new JButton("Search shortest path");
        searchShortestPathButton.setSize(200, 100);
        searchShortestPathButton.setLocation(30, 500);
        searchShortestPathButton.setBackground(Color.white);
        searchShortestPathButton.setBorder(null);
        searchShortestPathButton.setFocusPainted(false);
    }
}