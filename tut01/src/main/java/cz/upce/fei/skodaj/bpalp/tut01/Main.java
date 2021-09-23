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
package cz.upce.fei.skodaj.bpalp.tut01;


import java.util.Scanner;
/**
 * Main class of whole program
 * @author Jiri Skoda <jiri.skoda@student.upce.cz>
 */
public class Main {
    
    /**
     * Main function of whole program
     * @param args Arguments of program
     */
    public static void main(String[] args) {
        System.out.println("Hello world!"); //Wtf? Why i have to write hello world again?
        
        int sideA = 6;
        int sideB = 5;
        int area;             
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter side A: ");
        sideA = scanner.nextInt();       
        System.out.println("Enter side B: ");
        sideB = scanner.nextInt();
        
        area = sideA * sideB;
        System.out.println("Area: " + area);
        int perimeter = 2 * (sideA + sideB);
        System.out.println("Perimeter: " + perimeter);
    }
}
