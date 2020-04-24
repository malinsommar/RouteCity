package routeCity;

import com.sun.jdi.CharValue;

public class StringCity {
    void stringRoads(){

        //  1-A 2-B 3-C 4-D 5-E 6-F 7-G 8-H 9-I 10-J

        //make first roads to nodes
        for (int i = 0; i < 10; i++) {
            char from = (char)i;
            char to =  (char)(int)((Math.random()*10)+65);
            char distance = (char)(int)((Math.random()*10));
            char[] node = {from,to,distance};
            System.out.println(node);
        }
    }
}
