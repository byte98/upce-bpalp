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
package cz.upce.fei.skodaj.bpalp.tut03;

/**
 * Main class of the program
 * @author Jiri Skoda <jiri.skoda@student.upce.cz>
 */
public class Main
{

    /**
     * Main function of the program
     * @param args The command line arguments
     */
    public static void main(String[] args)
    {
        int age = 25;
        String name = "John";
        String surname = "Doe";
        
        age++;
        name = "John";
        String name2 = "John";
        
        if (name.equals(name2))
        {
            System.out.println("Same");
        }
        else
        {
            System.out.println("Not same");
        }
        
        name = "   " + name + " DOE   ";
        System.out.println(name.toLowerCase());
        System.out.println(name);
        System.out.println(name.trim());
        System.out.println(name.toLowerCase().trim().substring(2, 5));
        
        double pi = Math.PI;
        System.out.println(String.valueOf(pi));
        
        // Quadratic equations calculator
        
        // Parts of equations in format:
        // ax^2 + bx + c = 0
        double a = 3;
        double b = 1;
        double c = -4;
        
        // Roots of equations
        double x, x1, x2, xR, xI;
        
        // Discriminant
        double d = Math.pow(b, 2) - (4 * a * c);
        
        if (d > 0)
        {
            x1 = ((-b) - Math.sqrt(d)) / (2 * a);
            x2 = ((-b) + Math.sqrt(d)) / (2 * a);
            
            System.out.printf("Roots of equation: %.2f, %.2f", x1, x2);
        }
        else if (d == 0)
        {
            x = (-2) / (2 * a);
            System.out.printf("Root of equation: %.2f", x);
        }
        else
        {
            xR = (-b) / (2 * a);
            xI = Math.sqrt(-d) / (2 * a);
            System.out.printf("Root of equation: %.2f + %.2fi", xR, xI);
        }
        
    }  
    
}
