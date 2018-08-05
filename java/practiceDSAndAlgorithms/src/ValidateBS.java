public class ValidateBS {

    class Node {
        int data;
        Node left;
        Node right;
    }

    public boolean checkBST(Node root){
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

     public boolean check(Node n, int min, int max){
        if(n == null){
            return true;
        }
        if(n.data < min || n.data >= max){
            return false;
        }
        return check(n.left, min, n.data) && check(n.right, n.data, max);
     }
}