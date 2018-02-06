package islands;

import java.util.ArrayList;
import java.util.List;

class Main {

    private static int MAX_COLUMN;
    private static int MAX_ROW;
    private static List<Coords> lakesCoords = new ArrayList<Coords>();
    private static boolean islandDoesNotHaveLake = true;
    private static boolean isNotExtreme = true;

    static int findIslands(int row, int column, char[][] matrix) {
        MAX_COLUMN = column;
        MAX_ROW = row;

        findAndMarkLakes(matrix);

        int count = 0;
        for (int i = 0; i < MAX_ROW; i++)
            for (int j = 0; j < MAX_COLUMN; j++)
                if (matrix[i][j] == CellType.LAND.getValue()) {
                    dfs(matrix, i, j, CellType.ISLAND);

                    if (isNotExtreme && islandDoesNotHaveLake) {
                        count++;
                    }
                    islandDoesNotHaveLake = true;
                    isNotExtreme = true;

                }
        return count;
    }


    private static void findAndMarkLakes(char[][] matrix) {
        for (int i = 0; i < MAX_ROW; i++)
            for (int j = 0; j < MAX_COLUMN; j++) {
                if (matrix[i][j] == CellType.WATER.getValue()) {
                    dfs(matrix, i, j, CellType.LAKE);

                    if (!isNotExtreme) {
                        for (Coords coords : lakesCoords) {
                            matrix[coords.getX()][coords.getY()] = CellType.OCEAN.getValue();
                        }
                    }
                    isNotExtreme = true;
                    lakesCoords.clear();
                }
            }
    }

    private static void dfs(char[][] matrix, int i, int j, CellType type) {
        if (type == CellType.ISLAND && matrix[i][j] == CellType.WATER.getValue()
                || type == CellType.LAKE && matrix[i][j] == CellType.LAND.getValue()) {
            return;
        }

        if (type == CellType.ISLAND && matrix[i][j] == CellType.LAND.getValue()
                || type == CellType.LAKE && matrix[i][j] == CellType.WATER.getValue()) {

            Coords coords = new Coords(i, j);
            if (type == CellType.LAKE) {
                lakesCoords.add(coords);
            }

            matrix[i][j] = type.getValue();

            if (i == 0 || j == 0 || i == MAX_ROW - 1 || j == MAX_COLUMN - 1) {
                isNotExtreme = false;
            }

            if (i - 1 >= 0) {
                if ((matrix[i - 1][j] == CellType.LAKE.getValue()) && type == CellType.ISLAND) {
                    islandDoesNotHaveLake = false;
                }
                dfs(matrix, i - 1, j, type);
            }
            if (i + 1 < MAX_ROW) {
                if (matrix[i + 1][j] == CellType.LAKE.getValue() && type == CellType.ISLAND) {
                    islandDoesNotHaveLake = false;
                }
                dfs(matrix, i + 1, j, type);
            }
            if (j - 1 >= 0) {
                if (matrix[i][j - 1] == CellType.LAKE.getValue() && type == CellType.ISLAND) {
                    islandDoesNotHaveLake = false;
                }
                dfs(matrix, i, j - 1, type);
            }
            if (j + 1 < MAX_COLUMN) {
                if (matrix[i][j + 1] == CellType.LAKE.getValue() && type == CellType.ISLAND) {
                    islandDoesNotHaveLake = false;
                }
                dfs(matrix, i, j + 1, type);
            }
        }
    }
}