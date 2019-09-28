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

import com.shaiksphere.funstuff.setGame.helper.Fill;
import com.shaiksphere.funstuff.setGame.helper.Shape;
import com.shaiksphere.funstuff.setGame.helper.Colour;

import com.shaiksphere.funstuff.setGame.holder.Card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

import static java.util.Arrays.asList;

final public class Game {
    public static ArrayList<Card> generateDeck() {
        ArrayList<Card> deck = new ArrayList<>(81);

        for (Colour colour : Colour.values()) {
            for (Fill fill : Fill.values()) {
                for (Shape shape : Shape.values()) {
                    for (int i = 1; i <= 3; i++) {
                        deck.add(new Card(colour, fill, shape, i));
                    }
                }
            }
        }

        return deck;
    }

    public static ArrayList<Card> dealFrom(ArrayList<Card> deck) {
        ArrayList<Card> deal = new ArrayList<>(12);

        for (Integer c : getRandomUniqueNumbers()) {
            deal.add(deck.get(c));
        }

        return deal;
    }

    public static ArrayList<ArrayList<Card>> getAllSets(ArrayList<Card> deal) {
        ArrayList<ArrayList<Card>> allSets = new ArrayList<>();

        int size = deal.size();

        for (int i = 0; i < size; i++) {
            Card card1 = deal.get(i);

            for (int j = i + 1; j < size; j++) {
                Card card2 = deal.get(j);

                for (int k = j + 1; k < size; k++) {
                    Card card3 = deal.get(k);

                    if (isASet(card1, card2, card3)) {
                        allSets.add(new ArrayList<>(asList(card1, card2, card3)));
                    }
                }
            }
        }

        return allSets;
    }

    private static boolean isASet(Card card1, Card card2, Card card3) {
        return  isASet(card1.getColour().ordinal(), card2.getColour().ordinal(), card3.getColour().ordinal()) ||
                isASet(card1.getFill().ordinal(), card2.getFill().ordinal(), card3.getFill().ordinal()) ||
                isASet(card1.getShape().ordinal(), card2.getShape().ordinal(), card3.getShape().ordinal()) ||
                isASet(card1.getNumber(), card2.getNumber(), card3.getNumber());
    }

    private static boolean isASet(int card1, int card2, int card3) {
        return (card1 == card2 && card2 == card3) || (card1 != card2 && card1 != card3 && card2 != card3);
    }

    private static Integer[] getRandomUniqueNumbers() {
        HashSet<Integer> hashSet = new HashSet<>(12);

        Random random = new Random();

        while (hashSet.size() < 12) {
            hashSet.add(random.nextInt(81));
        }

        return hashSet.toArray(new Integer[12]);
    }
}
