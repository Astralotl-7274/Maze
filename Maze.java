import java.util.ArrayList;
import java.util.Scanner;

public class Maze {
    ArrayList<Room> roomList = new ArrayList<Room>();
    Scanner scnr = new Scanner(System.in);

    Point startPoint = new Point(7, 7);
    Point endPoint = new Point(68, 22);
    Player player = new Player(startPoint.getX(), startPoint.getY());

    public Maze() throws Exception {
        roomList.add(new Room(new Point(5, 5), new Point(15, 15))); // first Room
        roomList.add(new Room(new Point(25, 7), new Point(40, 18))); // second Room
        roomList.add(new Room(new Point(4, 20), new Point(70, 23))); // third Room

        roomList.add(new Corridor(new Point(15, 8), new Point(25, 10))); // first Corridor
        roomList.add(new Corridor(new Point(19, 14), new Point(25, 16))); // second Corridor
        roomList.add(new Corridor(new Point(18, 15), new Point(20, 20))); // second Corridor
    }

    public void runGame() {
        while (true) {
            print();
            var input = scnr.next();
            if (input.equals("e")) {
                System.out.println("Exit Game");
                break;
            }
        }
    }

    public void print() {

        for (int y = 0; y < 24; y++) {
            System.out.println();
            for (int x = 0; x < 80; x++) {
                var isRoomWall = false;
                var isOpening = false;

                for (int i = 0; i < roomList.size(); i++) {
                    var room = roomList.get(i);
                    if (room.isWall(new Point(x, y))) {
                        isRoomWall = true;
                    }

                    if (room instanceof Corridor) {

                        Corridor corridor = (Corridor)room;
                        if (corridor.isOpening(new Point(x, y))) {
                            isOpening = true;
                        }
                        
                        if (corridor.isInside(new Point(x, y))) {
                            isOpening = true;
                        }
                    }
                }


                if (x == startPoint.getX() && y == startPoint.getY()) {
                    System.out.print('O');
                }
                else if (x == endPoint.getX() && y == endPoint.getY()) {
                    System.out.print('X');
                }
                else if (isRoomWall && !isOpening) {
                    System.out.print('#');
                    
                } else {
                    System.out.print('.');
                }
            }
        }
    }
}
