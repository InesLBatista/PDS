enum Direction {
    RIGHT(0, 1, "Right"),
    DOWN_RIGHT(1, 1, "DownRight"),
    DOWN(1, 0, "Down"),
    DOWN_LEFT(1, -1, "DownLeft"),
    LEFT(0, -1, "Left"),
    UP_LEFT(-1, -1, "UpLeft"),
    UP(-1, 0, "Up"),
    UP_RIGHT(-1, 1, "UpRight");

    private final int dx;
    private final int dy;
    private final String name;

    Direction(int dx, int dy, String name) {
        this.dx = dx;
        this.dy = dy;
        this.name = name;
    }

    public int getDx() { return dx; }
    public int getDy() { return dy; }
    public String getName() { return name; }
}