package com.frederickschubert;

import com.frederickschubert.utils.TwodArray;
import com.frederickschubert.utils.Utils;

import java.io.IOException;

public class LevelDataLoader
{
    TwodArray<Character> levelData = new TwodArray<>();

    private void loadLevel(String levelName) throws IOException
    {
        String[] lines = Utils.readResourceFile(levelName).split("\n");

        for (int row = 0; row < lines.length; row++)
        {
            levelData.addRow();
            String line = lines[row];
            for (int col = 0; col < line.length(); col++)
            {
                levelData.addColumn(row, line.charAt(col));
            }
        }
    }

    private void printLevel()
    {
        if (levelData.getRowCount() == 0)
        {
            System.out.println("No level data loaded.");
            return;
        }

        for (int row = 0; row < levelData.getRowCount(); row++)
        {
            for (int col = 0; col < levelData.getColumnCount(); col++)
            {
                try
                {
                    System.out.print(levelData.get(row, col));
                }
                catch (IndexOutOfBoundsException e)
                {
                    System.out.print(' ');
                }

            }
            System.out.println();
        }
    }

    public LevelDataLoader(String levelName) throws IOException
    {
        loadLevel(levelName);
        printLevel();
    }
}
