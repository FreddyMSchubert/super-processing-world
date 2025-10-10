package com.frederickschubert;

import com.frederickschubert.object.GameObject;
import com.frederickschubert.object.PlayerGameObject;
import com.frederickschubert.object.WallGameObject;

import java.util.ArrayList;

public class Game
{
    public ArrayList<GameObject> objects = new ArrayList<>();

    public Game(LevelDataLoader loadedLevel)
    {
        for (int y = 0; y < loadedLevel.levelData.getRowCount(); y++)
        {
            for (int x = 0; x < loadedLevel.levelData.getColumnCount(); x++)
            {
                char objectChar;
                try {
                    objectChar = loadedLevel.levelData.get(y, x);
                } catch (IndexOutOfBoundsException e)
                {
                    continue;
                }

                switch (objectChar)
                {
                    case 'p' -> objects.add(new PlayerGameObject(x, y));
                    case '#' -> objects.add(new WallGameObject(x, y));
                }
            }
        }
    }
}
