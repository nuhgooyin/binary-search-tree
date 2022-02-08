/**
 * Binary Tree Example Extended (Recursive)
 * 
 * @author Dan Nguyen
 * @course ICS4U
 * @date 2022/01/12
 */
public class BinaryTree {
  boolean empty = true;
  int data = 0;
  BinaryTree left = null;
  BinaryTree right = null;

  /**
   * Constructor
   * 
   * @param key
   */
  public BinaryTree() {
    this.data = 0;
    this.empty = true;
  }

  /**
   * Constructor
   * 
   * @param key
   */
  public BinaryTree(int key) {
    this.data = key;
    this.empty = false;
  }

  /**
   * Add a node to the tree
   * 
   * @param key
   */
  public void add(int key) {
    // Is the tree empty
    if (this.empty) {
      this.data = key;
      this.empty = false;
    } else if (key < data) {
      // Goes on the left side
      if (this.left == null) {
        this.left = new BinaryTree(key);
      } else {
        this.left.add(key);
      }
    } else {
      // Goes on the right side
      if (this.right == null) {
        this.right = new BinaryTree(key);
      } else {
        this.right.add(key);
      }
    }
  }

  /**
   * Inorder traversal prints nodes in sorted order
   */
  public String inOrderTraversal() {
    String result = "";

    // Check is it empty
    if (this.empty) {
      result = "Tree is empty";
    } else {
      // Left, Node, Right
      if (this.left != null) {
        result += this.left.inOrderTraversal();
      }
      result += this.data + " ";
      if (this.right != null) {
        result += this.right.inOrderTraversal();
      }
    }
    return result;
  }

  /**
   * Reverse order traversal prints nodes in reversed sorted order
   *
   * @return String result
   */
  public String reverseOrderTraversal() {
    String result = "";

    // Check is it empty
    if (this.empty) {
      result = "Tree is empty";
    } else {
      // Right, Node, Left
      if (this.right != null) {
        result += this.right.inOrderTraversal();
      }
      result += this.data + " ";
      if (this.left != null) {
        result += this.left.inOrderTraversal();
      }
    }
    return result;
  }

  /**
   * Count how many instances are in the tree
   * 
   * @param int key
   * @return int counter
   */
  public int countInstance(int key) {

    // Declare variable
    int counter = 0;

    // The tree is not empty
    if (this.empty != true) {

      // Is this the node?
      if (this.data == key) {

        // Increment
        counter++;

        // If right node exists
        if (this.right != null) {

          // Recursively keep counting to the right
          counter += this.right.countInstance(key);
        }
      }

      // Determine whether to recursively count the right or left side
      else if (this.data > key && this.left != null) {
        counter += this.left.countInstance(key);
      } else if (this.data < key && this.right != null) {
        counter += this.right.countInstance(key);
      }
    }
    return counter;
  }

  /**
   * Find the maximum value in subtree
   * 
   * @return int maxVal
   */
  public int findMaxVal() {

    // Declare variable
    BinaryTree node = this;

    // While there are nodes to the right
    while (node.right != null) {

      // Move to right node
      node = node.right;
    }
    return node.data;
  }

  /**
   * Remove nodes from tree
   * 
   * @param int key
   * @return boolean
   */
  public boolean remove(int key) {
    boolean result = false;

    // The node is not empty
    if (this.empty != true) {

      // Immediate node is the key?
      if (this.data == key) {

        // 2 child case
        if (this.right != null && this.left != null) {

          // Find maximum value in left subtree
          int maxVal = this.left.findMaxVal();

          // Set data
          this.data = maxVal;

          // Recursively remove the data set
          this.left.remove(maxVal);
        }

        // 1 child case true
        else if (this.right != null || this.left != null) {
          result = true;
        }

        // Leaf case set empty
        else {
          this.empty = true;
        }
      }

      // Determine whether to recursively remove from the right or left side
      else if (this.data > key && this.left != null) {
        this.left.remove(key);

        // One child case?
        if (this.left.remove(key) == true) {

          // Is it on the left or right side?
          if (this.left.left != null) {

            // Reassign pointer
            this.left = this.left.left;

          } else if (this.left.right != null) {

            // Reassign pointer
            this.left = this.left.right;
          }
        }

      } else if (this.data < key && this.right != null) {
        this.right.remove(key);

        // One child case?
        if (this.right.remove(key) == true) {

          // Is it on the left or right side?
          if (this.right.right != null) {

            // Reassign pointer
            this.right = this.right.right;

          } else if (this.right.left != null) {

            // Reassign pointer
            this.right = this.right.left;
          }
        }
      }

      // Make sure there are no empty nodes on either side
      if (this.left != null && this.left.empty == true) {
        this.left = null;
      } else if (this.right != null && this.right.empty == true) {
        this.right = null;
      }
    }
    return result;
  }

  /**
   * Get the data of this node
   * 
   * @return int this.data
   */
  public int getData() {
    return this.data;
  }

  /**
   * Locate a value
   * 
   * @param key
   * @return BinaryTree result
   */
  public BinaryTree find(int key) {
    BinaryTree result = null;

    if (this.empty != true) {
      // Is this the node?
      if (this.data == key) {
        result = this;
      } else if (this.data > key && this.left != null) {
        // Search the left
        result = this.left.find(key);
      } else if (this.data < key && this.right != null) {
        // Search the right
        result = this.right.find(key);
      }
    }
    return result;
  }
}
