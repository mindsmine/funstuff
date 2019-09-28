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

package com.shaiksphere.funstuff.setGame.holder;

import com.shaiksphere.funstuff.setGame.helper.Shape;
import com.shaiksphere.funstuff.setGame.helper.Colour;
import com.shaiksphere.funstuff.setGame.helper.Fill;

public final class Card {
    private static int counter = 1;

    private final int uuid;
    private final Colour colour;
    private final Fill fill;
    private final Shape shape;
    private final int number;

    public Card(Colour colour, Fill fill, Shape shape, int number) {
        this.uuid = counter++;
        this.colour = colour;
        this.fill = fill;
        this.shape = shape;
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format(
                "Card(%-2d){colour=%-6s  fill=%-8s  shape=%-8s  number=%d}",
                uuid,
                colour,
                fill,
                shape,
                number
        );
    }

    public Colour getColour() {
        return colour;
    }

    public Fill getFill() {
        return fill;
    }

    public Shape getShape() {
        return shape;
    }

    public int getNumber() {
        return number;
    }
}
