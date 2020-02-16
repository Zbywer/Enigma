package file.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileUtilTest {
    private final int NUMBER_OF_LINES = 2;
    private final String PATH_TO_FILE = this.getClass().getResource("/filesUtils/test.txt").getPath();
    private final String FIRST_LINE = "Ala ma kota, kot ma Ale";

    @Test
    protected void testIfNumberOfLineAreEquals() {
        //wywołujemy metodę
        System.out.println(PATH_TO_FILE);
        String fileContent = FileTool.getFileContent(PATH_TO_FILE);
        String[] split = fileContent.split("\n");
        Assertions.assertEquals(NUMBER_OF_LINES, split.length);
    }
    @Test
    protected void firstLineContentTest(){

        String fileContent = FileTool.getFileContent(PATH_TO_FILE);
        String[] split = fileContent.split("\n");
       Assertions.assertEquals(FIRST_LINE, split[0]);
    }

    @Test
    protected void howDoesSplitWork() {
        String textToSplit = "ananas";
        String[] split = textToSplit.split("a");
        for (String s : split) {
            System.out.println(s);
        }
    }
}