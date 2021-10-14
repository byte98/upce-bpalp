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
package cz.upce.fei.skodaj.bpalp.tut04;

/**
 * Main class of fourth tutorial
 * @author Jiri Skoda <jiri.skoda@student.upce.cz>
 */
public class Main {
    
    /**
     * Main function of program
     * @param args Arguments of program
     */
    public static void main(String[] args)
    {
        // ****** TODAYS TOPIC: CYCLES ******
        
        boolean repeat = false;
        
        // While cycle
        while (repeat)
        {
            System.out.println("Something in while");
        }
        
        // Do-while cycle
        do
        {
            System.out.println("Something in do-while");
        }
        while (repeat);
        
        // For cycle
        for (int i = 1; i <= 5; i++)
        {
            System.out.println(i);
        }
        
        // While as for
        int j = 1;
        while (j <= 5)
        {
            System.out.println(j);
            j++;
        }
        
        // Break
        for (int i = 0; i < 10; i++)
        {
            if (i == 3)
            {
                System.out.println("break");
                break;
            }
            System.out.println(i);
        }
        
        // Continue
        for (int i = 0; i < 10; i++)
        {
            if (i == 3)
            {
                System.out.println("continue");
                continue;
            }
            System.out.println(i);
        }
        
        
        // Real numbers preceision
        float Ff = 0.1f;
        float Fsum = 0;
        
        for (int i = 0; i < 10; i++)
        {
            Fsum += Ff;
        }
        System.out.printf("sum = %1.15f\n", Fsum);
        
        int Isum = 0;
        for (int i = 0; i <= 101; i++)
        {
            Isum += i;
        }
        System.out.println("sum = " + Isum);
        
        // Power calculator
        double a = 10;
        int n = -2;
        double result = 1;
        if (n == 0)
        {
            result = 1;
        }
        else if (n > 0)
        {
            for (int i = 0; i < n; i++)
            {
                result *= a;
            }
        }
        else if (n < 0)
        {
            for (int i = 0; i < -n; i++)
            {
                result /= a;
            }
        }
        System.out.printf("%.4f over %d equals %.4f %n", a, n, result);
        
        // Greatest common diviser GCD(A, B)
        int A = 12;
        int B = 20;
        System.out.print("Greatest common diviser of " + A + " and " + B + " is ");  
        
        int R = 0;
        if (A > 0 && B > 0)
        {
            while (B > 0)
            {
                R = A % B;
                A = B;
                B = R;
            }
        }
             
        System.out.println(A);
    }
}
