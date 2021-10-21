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
package cz.upce.fei.skodaj.bpalp.hw03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main class representing third homework
 * Assignment: program to test if number is prime number
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
        // Load input
        int input;
        Scanner scanner = new Scanner(System.in);
        do
        {
            System.out.println("Zadejte prirozene cislo: ");
            input = scanner.nextInt();
        }
        while (input < 0);
        
        // Prepare Sieve of Eratosthenes 
        boolean[] isPrime = new boolean[(int)Math.ceil(Math.sqrt(input))];
        Arrays.fill(isPrime, true);
        for (int i = 0; i < isPrime.length; i++)
        {
            if (i < 2)
            {
                isPrime[i] = false;
            }
            else if (isPrime[i] == true)
            {
                for (int j = i + i; j < isPrime.length; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }
        
        // Check, whether input is prime number;
        boolean result = true;
        for (int i = 2; i < isPrime.length; i++)
        {
            if (isPrime[i] == true && input % i == 0)
            {
                result = false;
                break;
            }
        }
        
        // Inform user about result
        System.out.printf("Cislo %d %s prvocislo.\n", input, (result == true ? "je" : "neni"));
        
    }
}
