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
package cz.upce.fei.skodaj.bpalp.tut05;

import java.util.Arrays;

/**
 * Class representing main content of fifth tutorial
 * @author Jiri Skoda <jiri.skoda@student.upce.cz>
 */
public class Main
{
    /**
     * Main function of program
     * @param args Arguments of program
     */
    public static void main(String[] args)
    {
        int[] array;
        int[] array2 = {1, 3, 5, 4};
        array = new int[20];
        System.out.println(array.length);
        
        // Fill array with random numbers
        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int)(Math.random() * 100);
        }
        
        // Print content of array
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
        
        // Arrays package
        //Arrays.sort(array);
        int position = Arrays.binarySearch(array, 10);
        System.out.println(position);
        
        // Custom sorting algorithm
        int tmp;
        for (int a = 0; a < array.length; a++)
        {
            for (int b = a + 1; b < array.length; b++)
            {
                if (array[a] > array[b])
                {
                    tmp = array[a];
                    array[a] = array[b];
                    array[b] = tmp;
                }
            }
        }
        
        // Print content of array
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
        
    }
}
