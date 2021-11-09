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
package cz.upce.fei.skodaj.bpalp.tut06;

/**
 * Class representing game field in Hero game
 * @author Jiri Skoda <jiri.skoda@student.upce.cz>
 */
public class GameField
{
    /**
     * Type of game field
     */
    private GameFieldType type;
    
    /**
     * Character which will be displayed in output
     */
    private char displayChar;
    
    /**
     * Description of game field
     */
    private String description;
    
    /**
     * Creates new game field on map
     * @param type Type of game field
     */
    public GameField(GameFieldType type)
    {
        this.setType(type);       
    }
    
    /**
     * Sets type of game field
     * @param type New type of game field
     */
    public void setType(GameFieldType type)
    {
        switch (type)
        {
            case BORDER:
                this.displayChar = '#'; 
                this.description = "Border";
                break;
            case MEADOW:
                this.displayChar = ' ';
                this.description = "Meadow";
                break;
            case FOREST:
                this.displayChar = '|';
                this.description = "Forest";
                break;
            case RIVER:
                this.displayChar = '~';
                this.description = "River";
                break;
            case BRIDGE:
                this.displayChar = '=';
                this.description = "Bridge";
                break;
        }
    }
    
    /**
     * Gets type of game field
     * @return Type of game field
     */
    public GameFieldType getType()
    {
        return this.type;
    }
    
    /**
     * Sets new character for game field
     * @param displayChar New character for game field
     */
    public void setDisplayChar(char displayChar)
    {
        this.displayChar = displayChar;
    }
    
    /**
     * Gets character for game field
     * @return Game field character 
     */
    public char getDisplayChar()
    {
        return this.displayChar;
    }
    
    /**
     * Sets description of game field
     * @param desc New description of game field
     */
    public void setDescription(String desc)
    {
        this.description = desc;
    }
    
    /**
     * Gets description of game field
     * @return Description of game field
     */
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     * Gets, whether game field is permeable for player
     * @return <code>TRUE</code> if game field is permeable for player, <code>FALSE</code> otherwise
     */
    public boolean isPermeable()
    {
        boolean reti = false;
        switch (this.type)
        {
            case BORDER: reti = false; break;
            case MEADOW: reti = true; break;
            case FOREST: reti = false; break;
            case RIVER: reti = false; break;
            case BRIDGE: reti = true; break;
        }
        return reti;
    }
}