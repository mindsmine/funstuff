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

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {
    static private ArrayList<Card> DECK;

    @BeforeClass
    static public void beforeClass() {
        DECK = Game.generateDeck();
    }

    @Test
    public void generateDeckTest() {
        assertEquals(81, DECK.size());
    }

    @Test
    public void dealFromTest() {
        assertEquals(12, Game.dealFrom(DECK).size());
    }
}
