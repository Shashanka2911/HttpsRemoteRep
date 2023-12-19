import java.util.*;


public class lab3 {
        int data;
        lab3 left, right;
    
        public lab3(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    class PostPreInOrderInOneFlowRecursive {
  
        static void traverse(lab3 root, List<Integer> pre, List<Integer> post, List<Integer> in) {
           
            if (root == null) {
                return;
            }
    
            pre.add(root.data);
    
            traverse(root.left, pre, post, in);
            in.add(root.data);
            traverse(root.right, pre, post, in);
            post.add(root.data);
        }
        public static void main(String[] args) {
            lab3 root = new lab3(1);
            root.left = new lab3(2);
            root.right = new lab3(3);
            root.left.left = new lab3(4);
            root.left.right = new lab3(5);
            root.right.left = new lab3(6);
            root.right.right = new lab3(7);
            root.left.left.left = new lab3(8);
            root.left.left.left.right = new lab3(12);
            root.left.right.left = new lab3(9);
            root.right.right.left = new lab3(10);
            root.right.right.right = new lab3(11);
            List<Integer> pre = new ArrayList<Integer>();
            List<Integer> post = new ArrayList<Integer>();
            List<Integer> in = new ArrayList<Integer>();
            traverse(root, pre, post, in);
            System.out.print("Pre Order : ");
            for (int i : pre) {
                System.out.print(i + " ");
            }
    
            System.out.println();
            System.out.print("Post Order : ");
            for (int i : post) {
                System.out.print(i + " ");
            }
    
            System.out.println();
            System.out.print("In Order : ");
            for (int i : in) {
                System.out.print(i + " ");
            }
        }
    }
    

