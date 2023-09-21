package org.nhnacademy.minju.classes;

public class PairOfDice {
    private int dice1;
    private int dice2;
    private int count = 0;

    public void roll() {
        this.dice1 = (int) (Math.random() * 6) + 1;
        this.dice2 = (int) (Math.random() * 6) + 1;
        this.count++;
    }

    public int getDiceSum() {
        return dice1 + dice2;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Total count is " + count;
    }
}