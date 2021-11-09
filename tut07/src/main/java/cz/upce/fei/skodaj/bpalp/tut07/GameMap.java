/*
 * Copyright (C) 2021 Jiri Skoda <jiri.skoda@student.upce.cz>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package cz.upce.fei.skodaj.bpalp.tut07;

/**
 * Class representing map for game
 * @author Jiri Skoda <jiri.skoda@student.upce.cz>
 */
public class GameMap
{
    /**
     * Width of game map
     */
    private int width = 10;
    
    /**
     * Height of game map
     */
    private int height = 10;
    
    /**
     * Count of forests which are on map
     */
    private final int countOfForests = 4;
    
    /**
     * Data of game map
     * first index: row (Y axis)
     * second index: column in row (X axis)
     */
    private GameField map[][];
    
    /**
     * Creates new game map
     */
    public GameMap()
    {
        this.generateGameMap();
    }
    
    /**
     * Creates new game map
     * @param width Width of game map
     * @param height Height of game map
     */
    public GameMap(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.generateGameMap();
    }
    
    /**
     * Generates random position on map on X axis
     * @return Random position on map on X axis
     */
    public int randomX()
    {
        return (int)(Math.random() * (this.width - 2) + 1);
    }
    
    /**
     * Generates random position on game map on Y axis
     * @return Random position on map on Y axis
     */
    public int randomY()
    {
        return (int)(Math.random() * (this.height - 2) + 1);
    }
    
    /**
     * Prints game map to standard output
     */
    public void print()
    {
        for (int i = 0; i < this.height; i++)
        {
            for (int j = 0; j < this.width; j++)
            {
                System.out.print(this.map[i][j].getDisplayChar() + " ");
            }
            System.out.println("");
        }
    }
    
    /**
     * Generates random game map
     */
    private void generateGameMap()
    {
        /**
         * Index of column containing river
         */
        int riverColumn;
        
        /**
         * Row on which bridge crosses river
         */
        int bridgeRow;
        
        int positionX, positionY;
        
        // Create empty 2 dimensional array
        this.map = new GameField[this.height][this.width];
    
        // Create borders
        for (int i = 0; i < this.height; i++)
        {
            for (int j = 0; j < this.width; j++)
            {
                if (i == 0 || j == 0 || i == (this.height - 1) || j == (this.width - 1))
                {
                    this.map[i][j] = new GameField(GameFieldType.BORDER);
                }
            }
        }
        
        // Create river on random column and bridge
        riverColumn = (int) (Math.random() * (this.width - 4) + 2);
        bridgeRow = (int) (Math.random() * (this.height - 2) + 1);
        for (int i = 1; i < this.height - 1; i++)
        {
            if (i == bridgeRow)
            {
                this.map[i][riverColumn] = new GameField(GameFieldType.BRIDGE);
            }
            else
            {
                this.map[i][riverColumn] = new GameField(GameFieldType.RIVER);
            }
        }
        
        // Generate forests
        int generatedForests = 0;
        while (generatedForests < this.countOfForests)
        {
            if (this.generateForest(this.randomX(), this.randomY()))
            {
                generatedForests++;
            }
        }
        
        // Fill remaining game fields with meadows
        for (int i = 0; i < this.height; i++)
        {
            for (int j = 0; j < this.width; j++)
            {
                if (this.map[i][j] == null)
                {
                    this.map[i][j] = new GameField(GameFieldType.MEADOW);
                }
            }
        }
    }
    
    /**
     * Generates forest on game map
     * @param x Position of forest on X axis of map
     * @param y Position of forest on Y axis of map
     * @return <code>TRUE</code> if forest has been generated, <code>FALSE</code> otherwise
     */
    private boolean generateForest(int x, int y)
    {
        boolean reti = false;
        if (this.map[x][y] == null)
        {
            reti = true;
            this.map[x][y] = new GameField(GameFieldType.FOREST);
            
            // Generate forest in surrounding
            if (y - 1 >= 0 && this.map[x][y - 1] == null) // NORTH
            {
                this.map[x][y - 1] = new GameField(GameFieldType.FOREST);
            }
            if (y + 1 < this.height && this.map[x][y + 1] == null) // SOUTH
            {
                this.map[x][y + 1] = new GameField(GameFieldType.FOREST);
            }
            if (x - 1 >= 0 && this.map[x - 1][y] == null) // WEST
            {
                this.map[x - 1][y] = new GameField(GameFieldType.FOREST);
            }
            if (x + 1 < this.width && this.map[x + 1][y] == null) // EAST
            {
                this.map[x + 1][y] = new GameField(GameFieldType.FOREST);
            }
        }
        return reti;
    }
}
