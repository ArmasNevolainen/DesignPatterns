import java.util.Scanner;

public class Game {

    public static void main (String[] args){
        Game game = new Game();
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose map: 1.City  2. Wilderness");
        int choice = sc.nextInt();

        Map map = game.createMap(choice);
        map.display();
    }

    public Map createMap(int type){
        int rows = 10;
        int columns = 20;

        if (type == 1){
            return new CityMap(rows, columns);
        }
        else {
            return new WildernessMap(rows, columns);
        }

    }


}
