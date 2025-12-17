class WordGrid {
    private final char[][] grid;
    private final int size;
    
    public WordGrid(int size) {
        this.size = size;
        this.grid = new char[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '_';
            }
        }
    }
    
    public char[][] getGrid() {
        return grid;
    }
    
    public int getSize() {
        return size;
    }
}