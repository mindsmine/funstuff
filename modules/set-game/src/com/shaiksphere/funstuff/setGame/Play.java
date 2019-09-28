/*
Copyright 2008-present Shaiksphere, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.shaiksphere.funstuff.setGame;

import com.shaiksphere.funstuff.setGame.holder.Card;

import java.util.ArrayList;

public final class Play {
    private static final ArrayList<Card> DECK = Game.generateDeck();

    public static void main(String args[]) {
        ArrayList<Card> NEW_DEAL = Game.dealFrom(DECK);

        System.out.println("DEAL FOR THIS ROUND");
        System.out.println("-------------------");

        printCardList(NEW_DEAL);

        System.out.println();
        System.out.println();

        ArrayList<ArrayList<Card>> ALL_SETS = Game.getAllSets(NEW_DEAL);

        System.out.println("TOTAL SETS = " + ALL_SETS.size());
        System.out.println("------------");

        int i = 1;

        for (ArrayList<Card> SET : ALL_SETS) {
            System.out.println();
            System.out.println("SET " + i++);

            printCardList(SET, "\t");
        }
    }

    private static void printCardList(ArrayList<Card> cards) {
        printCardList(cards, "");
    }

    private static void printCardList(ArrayList<Card> cards, String prefix) {
        final String formatString = prefix + "Card " + getNumberDisplayFormat(cards.size()) + " : %s";

        int i = 1;

        for (Card card : cards) {
            System.out.println(String.format(
                    formatString,
                    i++,
                    card
            ));
        }
    }

    private static String getNumberDisplayFormat(int number) {
        return "%" + getNumOfDigits(number) + "d";
    }

    private static int getNumOfDigits(int number) {
        return (int)Math.log10(Math.abs(number)) + 1;
    }
}
