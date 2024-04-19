public class Program {
    public static void main(String[] args) {
        try {
            Maze maze = new Maze();

            maze.print();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }
    }
}
