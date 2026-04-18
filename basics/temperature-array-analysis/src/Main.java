// This program performs analysis on an array of temperature values.
// It calculates the maximum, minimum, and average temperatures,
// counts how many values are above the average, and prints the array in reverse order.

void main() {

    double[] temperatures = {55.5, 11.1, 44.4, 33.3};

    double max = temperatures[0];
    double min = temperatures[0];
    double total = temperatures[0];

    for (int i = 1; i < temperatures.length; i++) {

        if (temperatures[i] > max) {
            max = temperatures[i];
        }

        if (temperatures[i] < min) {
            min = temperatures[i];
        }

        total += temperatures[i];
    }

    double average = total / temperatures.length;

    IO.println("Highest temperature : " + max);
    IO.println("Lowest temperature : " + min);
    IO.println("Average temperature : " + average);

    int count = 0;

    for (int i = 0; i < temperatures.length; i++) {
        if (temperatures[i] > average) {
            count++;
            IO.println("Temperature above average : " + temperatures[i]);
        }
    }

    IO.println("Number of values above average : " + count);

    for (int i = temperatures.length - 1; i >= 0; i--) {
        IO.print(temperatures[i] + " | ");
    }
}