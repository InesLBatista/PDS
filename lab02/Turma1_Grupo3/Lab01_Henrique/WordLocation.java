class WordLocation {
    private final String word;
    private final int startRow;
    private final int startCol;
    private final Direction direction;
    
    public WordLocation(String word, int startRow, int startCol, Direction direction) {
        this.word = word;
        this.startRow = startRow;
        this.startCol = startCol;
        this.direction = direction;
    }
    
    public String getWord() { return word; }
    public int getStartRow() { return startRow; }
    public int getStartCol() { return startCol; }
    public Direction getDirection() { return direction; }
    
    public int getEndRow() {
        return startRow + (direction.getDx() * (word.length() - 1));
    }
    
    public int getEndCol() {
        return startCol + (direction.getDy() * (word.length() - 1));
    }
}