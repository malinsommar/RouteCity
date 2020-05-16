package Test;

import org.junit.jupiter.api.Test;
import routeCity.InitializeCity;
import routeCity.Node;
import routeCity.NodeCity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NodeCityTest {

    @Test
    void getShortestPath() {
            NodeCity nodecity = new NodeCity();
            ArrayList<Node> allNodes = new ArrayList<>();
            Node[] allNode = new Node [3];

            //Node testnode1 = new Node("A");
            //Node testnode2 = new Node("B");
            //Node testnode3 = new Node("C");
            //testnode1.addDestination(testnode2,1);
            //testnode2.addDestination(testnode3,2);

        for (int i = 0; i < 3; i++) {
            allNodes.add(new Node(Character.toString((char)(65+i))));
            if (i>0)allNodes.get(i-1).addDestination(allNodes.get(i),i);

            allNode[i] = new Node(Character.toString((char)(65+i)));
            if (i>0)allNode[i-1].addDestination(allNode[i],i);
        }

        Node []recievedNodes = nodecity.getShortestPath(allNodes, allNodes.get(0), allNodes.get(2));

        for (int i = 0; i < recievedNodes.length; i++) {
            System.out.println("recieved nodes: " + recievedNodes[i].name);
            System.out.println("basic nodes: " +allNode[i].name);
        };

        System.out.println(recievedNodes.length);
        System.out.println(allNode.length);

        for (int i = 0; i < recievedNodes.length; i++) {
            assertEquals(recievedNodes[i].name, allNode[i].name);
        }
    }
}