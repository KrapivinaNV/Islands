package islands;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IslandsTest {

    @Test(dataProvider = "findIslandsDataProvider")
    public void findIslands(int row, int column, char[][] matrix, int expected) {
        int countIslands = Main.findIslands(row, column, matrix);
        assertEquals(countIslands, expected);
    }

    @DataProvider
    private Object[][] findIslandsDataProvider() {
        return new Object[][]{
                {
                        7,
                        6,
                        new char[][]{
                                {'~', '~', '~', '~', '~', '~'},
                                {'~', '*', '~', '*', '*', '~'},
                                {'~', '*', '*', '*', '~', '~'},
                                {'~', '~', '~', '~', '~', '~'},
                                {'~', '*', '~', '~', '*', '~'},
                                {'~', '*', '*', '~', '*', '~'},
                                {'~', '~', '~', '~', '~', '~'}
                        },
                        3,
                },
                {
                        7,
                        5,
                        new char[][]{
                                {'~', '~', '~', '~', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '*', '~', '~', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '~', '~', '~', '~'}
                        },
                        1,
                },
                {
                        7,
                        5,
                        new char[][]{
                                {'~', '~', '~', '~', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '~', '~', '~', '~'}
                        },
                        0,
                },
                {
                        3,
                        3,
                        new char[][]{
                                {'~', '~', '~'},
                                {'~', '*', '~'},
                                {'~', '~', '~'},
                        },
                        1,
                },
                {
                        3,
                        3,
                        new char[][]{
                                {'~', '*', '~'},
                                {'~', '*', '~'},
                                {'~', '~', '~'},
                        },
                        0,
                },
                {
                        2,
                        2,
                        new char[][]{
                                {'~', '~'},
                                {'~', '*'}

                        },
                        0,
                },
                {
                        0,
                        0,
                        new char[][]{},
                        0,
                },
                {
                        7,
                        5,
                        new char[][]{
                                {'~', '~', '*', '~', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '~', '~', '~', '~'}
                        },
                        0,
                },
                {
                        7,
                        5,
                        new char[][]{
                                {'~', '~', '~', '~', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '~', '~', '~', '~'}
                        },
                        0,
                },
                {
                        7,
                        5,
                        new char[][]{
                                {'~', '~', '~', '~', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '~', '~', '~', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '~', '~', '~', '~'}
                        },
                        2,
                },
                {
                        7,
                        5,
                        new char[][]{
                                {'~', '~', '~', '~', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '~', '~', '~', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '~', '*', '~'},
                                {'~', '*', '*', '*', '~'},
                                {'~', '~', '~', '~', '~'}
                        },
                        3,
                }
        };
    }
}