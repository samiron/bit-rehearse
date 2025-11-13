package of.samiron.leetcode;

public class MinimumTimeToMakeRopeColorful {
  public int minCost(String colors, int[] neededTime) {

    int total = 0;

    for (int i = 0; i < neededTime.length; i++) {

      var time = neededTime[i];
      var color = colors.charAt(i);

      var timeSum = time;
      var maxTime = time;

      while (i + 1 < neededTime.length && color == colors.charAt(i + 1)) {
        i++;
        timeSum += neededTime[i];
        maxTime = Math.max(maxTime, neededTime[i]);
      }

      total += timeSum - maxTime;

    }

    return total;
  }

  record Input(String colors, int[] neededTime) {
  }

  public static void main(String[] args) {

    var inputs = new Input[]{
      new Input("aba", new int[]{1, 2, 3}),
      new Input("aaabbbabbbb", new int[]{3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1}),
      new Input("abaac", new int[]{1, 2, 3, 4, 5}),
      new Input("aabaa", new int[]{1, 2, 3, 4, 1}),
      new Input("aaaaa", new int[]{1, 2, 3, 4, 1})
    };

    var solver = new MinimumTimeToMakeRopeColorful();

    for (var input : inputs) {
      var result = solver.minCost(input.colors(), input.neededTime());
      System.out.println("colors: %s, neededTime: %s => result: %d".formatted(
        input.colors(),
        java.util.Arrays.toString(input.neededTime()),
        result
      ));
    }
  }


}
