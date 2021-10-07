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
package cz.upce.fei.skodaj.bpalp.hw01;

import java.util.Scanner;

/**
 * Class which provides functionality of first homework
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
        Scanner scanner = new Scanner(System.in);
        
        
        // Load inputs
        float priceWithoutVAT = 0;
        System.out.println("Cena (bez DPH):");
        priceWithoutVAT = scanner.nextFloat();
        
        boolean alcoholic = false;
        String input;
        do
        {
            System.out.println("Alkoholicke [ano | ne]?");
            input = scanner.next();
        }
        while (!(input.toLowerCase().equals("ano") || input.toLowerCase().equals("ne")));
        if (input.toLowerCase().equals("ano")) alcoholic = true;
        
        String type;
        do
        {
            System.out.println("Druh [tocene | lahvove | plech ]:");
            type = scanner.next();
        }        
        while ( !(type.toLowerCase().equals("tocene") || type.toLowerCase().equals("lahvove") || type.toLowerCase().equals("plech")) );
        
        String place;
        do
        {
            System.out.println("V provozovne [ano | ne]?");
            place = scanner.next();
        }
        while (!(place.toLowerCase().equals("ano") || place.toLowerCase().equals("no")));
        place = (place.toLowerCase().equals("ano") ? "provozovna" : "s sebou");
        
        // Compute output
        float priceWithVAT = 0;
        if (type.toLowerCase().equals("tocene"))
        {
            priceWithVAT = priceWithoutVAT * 1.1f;
        }
        else if (alcoholic == false && place.toLowerCase().equals("provozovna") && (type.toLowerCase().equals("lahvove") || type.toLowerCase().equals("plech")))
        {
            priceWithVAT = priceWithoutVAT * 1.1f;
        }
        else if (alcoholic == false && type.toLowerCase().equals("tocene") && place.toLowerCase().equals("s sebou"))
        {
            priceWithVAT = priceWithoutVAT * 1.15f;
        }
        else if (alcoholic == true && type.toLowerCase().equals("tocene") && place.toLowerCase().equals("s sebou"))
        {
            priceWithVAT = priceWithoutVAT * 1.21f;
        }
        else if (alcoholic == true && (type.toLowerCase().equals("lahvove") || type.toLowerCase().equals("plech")) && place.toLowerCase().equals("provozovna"))
        {
            priceWithVAT = priceWithoutVAT * 1.21f;
        }
        System.out.printf("Cena piva (%s, %s, %s): %.2f Kč", (alcoholic ? "alkoholické": "nealkoholické"), type.toLowerCase(), place.toLowerCase(), priceWithVAT);
        
    }
}
