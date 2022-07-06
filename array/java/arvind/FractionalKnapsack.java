package arvind;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

public class FractionalKnapsack {

    private class Item {
        private int value;
        private int weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    public float maxValue(int weightOfKnapsack, int noOfItems, int[] values, int[] weights) {
        Item [] items = new Item[noOfItems];
        for (int i=0; i<noOfItems; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        Arrays.sort(items, (o1, o2) -> (o2.getValue()/ o2.getWeight()) - (o1.getValue()/ o1.getWeight()));

        float maxValue = 0.00f;

        for (int i=0; i<noOfItems; i++) {
            if (items[i].getWeight() <= weightOfKnapsack) {
                maxValue += items[i].getValue();
                weightOfKnapsack -= items[i].getWeight();
            } else {
                maxValue += (items[i].getValue() * ((float) weightOfKnapsack / (float) items[i].getWeight()));
                break;
            }
        }

        /*
        int i=0;
        while (weightOfKnapsack - items[i].getWeight() > 0) {
            maxValue += items[i].getValue();
            weightOfKnapsack -= items[i].getWeight();
            i++;
        }

        // add fractional part
        maxValue += items[i].getValue() * ((float)weightOfKnapsack / (float)items[i].getWeight());
        weightOfKnapsack = 0;*/

        NumberFormat formatter = new DecimalFormat("0.00");

        System.out.println(formatter.format(maxValue));

        return maxValue;
    }

    public static void main(String[] args) {
        FractionalKnapsack knapsack = new FractionalKnapsack();
        int weightOfKnapsack = 50;
        int noOfItems = 3;
        int[] values = new int[] {60, 100, 120};
        int[] weights = new int[] {10, 20, 30};

        float result = knapsack.maxValue(weightOfKnapsack, noOfItems, values, weights);
        System.out.println("Result is "+ result);
    }
}
