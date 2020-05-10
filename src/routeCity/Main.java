package routeCity;

public class Main {
    public static void main(String[] args) {
        InitializeCity initializeCity = new InitializeCity();
        initializeCity.initializeNodes();

        MainMenu mainMenu = new MainMenu();
        mainMenu.menu();



        //System.out.println("hey");
        //new StringCity();
        //StringCity stringcity = new StringCity();
        //stringcity.stringRoads();
    }
}
