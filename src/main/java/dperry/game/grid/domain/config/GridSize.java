package dperry.game.grid.domain.config;

public enum GridSize {
    SMALL(8,8),
    MEDIUM(12,12),
    LARGE(16,16);

    private int rows;
    private int columns;

    GridSize(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
