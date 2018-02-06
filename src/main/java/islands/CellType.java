package islands;

public enum CellType {
    LAND ('*'),
    WATER ('~'),
    ISLAND ('#'),
    LAKE ('%'),
    OCEAN('O');

    private char value;

    CellType(char c) {
        value = c;
    }
    char getValue(){
        return value;
    }
}
