import java.util.*;

/**
 * Binary Tree Example Extended (Recursive)
 * 
 * @author Dan Nguyen
 * @course ICS4U
 * @date 2022/01/12
 */
class Main {
  public static void main(String[] args) {
    // Create a tree
    BinaryTree theTree = new BinaryTree();

    // Add a bunch of random data
    // Random rand = new Random();
    // System.out.print("Adding: ");
    // for (int i = 0; i < 20; i++) {
    //   int num = rand.nextInt(10);
    //   System.out.print(num + " ");
    //   theTree.add(num);
    // }
    // System.out.println();

    // Add fixed following data in array
    int[] numbers = { 54, 100, 50, 25, 55, 54, 54, 57, 56, 60, 54, 150, 125, 175 };
    System.out.print("Adding: ");
    for (int i = 0; i <= numbers.length - 1; i++) {
      theTree.add(numbers[i]);
      System.out.print(numbers[i] + " ");
    }
    System.out.println();

    // Let's find something
    // System.out.println("Find");
    // BinaryTree node = theTree.find(3);
    // if (node == null) {
    //   System.out.println("Not found");
    // } else {
    //   System.out.println("Found:" + node.getData());
    // }

    // Show the data in the tree
    System.out.println(theTree.inOrderTraversal());
    System.out.println(theTree.reverseOrderTraversal());

    // Count how many instances are in the tree
    System.out.println("Count: " + theTree.countInstance(54));

    // Remove certain data from the tree
    System.out.println(theTree.inOrderTraversal());
    theTree.remove(55);
    System.out.println(theTree.inOrderTraversal());
  }
}
