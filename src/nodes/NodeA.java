package nodes;

public class NodeA extends Nodes {

    boolean twoRoads;
    int roadOne;
    int roadTwo;
    int roadThree;


    @Override
    public boolean twoOrTheeRoads(){
        int ran = (int)(Math.random()*2);
        return ran != 0;
    }

    @Override
    public void setConnectedRoads(boolean twoRoads){

    }

    @Override
    public int[] getConnectedRoads(){
        return connectedNodes;
    }
}