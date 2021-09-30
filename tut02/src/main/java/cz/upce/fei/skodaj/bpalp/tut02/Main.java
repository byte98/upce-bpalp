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
package cz.upce.fei.skodaj.bpalp.tut02;

/**
 * Class representing content of the second tutorial
 * @author Jiri Skoda <jiri.skoda@student.upce.cz>
 */
public class Main {
    
    /**
     * Main function of the program
     * @param args Arguments of the program
     */
    public static void main(String[] args)
    {
        /*
        int a = 1,b = 2,c = 3;
        System.out.println((a + b) * c);
        
        int i = 1;
        int j;
        
        j = i++;
        System.out.println(i);
        System.out.println(j);
        */

        /*
        int a = 3;
        int b = 2;
        double c = (double) a / (double) b;
        System.out.println(c);
        
        a = a + 5;
        a += 5;
        */
        int year = 2021;
        boolean isLeapYear = false;
        
        /*
        if (year <= 1854)
        {
            isLeapYear = false;
        }
        else
        {
            if (year % 4 == 0)
            {
                if (year % 100 == 0)
                {
                    if (year % 400 == 0)
                    {
                        isLeapYear = true;
                    }
                    else
                    {
                        isLeapYear = false;
                    }
                }
                isLeapYear = true;
            }
            else
            {
                isLeapYear = false;
            }
        }
        
        System.out.println("Year " + year + (isLeapYear ? " is leap year." : " is not leap year."));
        */
          
        /*
        if (year > 1854 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
        {
            isLeapYear = true;
        }
        else
        {
            isLeapYear = false;
        }
        */
        
        isLeapYear = (year > 1854 && year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? true : false;
        System.out.println("Year " + year + (isLeapYear ? " is leap year." : " is not leap year."));
        
        int weekDay = 6;
        switch (weekDay)
        {
            case 6: System.out.println("weekend"); break;
            case 7: System.out.println("weekend"); break;
            default: System.out.println("work day"); break;
        }
    }
}
