package nodes;

public class NodeC extends Nodes{

    boolean twoRoads;
    int[] connectedNodes = new int[3];


    @Override
    public boolean twoOrTheeRoads(){

        return true;
    }

    @Override
    public void setConnectedRoads(boolean twoRoads){

    }

    @Override
    public int[] getConnectedRoads(){
        return connectedNodes;
    }
}