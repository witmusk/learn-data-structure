package com.witmusk.datastructure;

public class BinaryTree<T> {
    public Node<T> root;

    public static class Node<T> {
        public T data;
        public Node<T> left;
        public Node<T> right;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> left, Node<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void preOrderTraverse2() {
        if (this.root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        String detail = "";
        Node node = this.root;
        while (node != null || stack.size() > 0) {
            while (node != null) { //一直向左并将沿途节点访问（打印）后压入堆栈
                System.out.print(node.data + " ");
                stack.push(node);
                detail = detail + "\npush " + node.data;
                node = node.left;
            }
            if (stack.size() > 0) {
                node = stack.pop();//节点弹出堆栈
                detail = detail + "\npop and visit " + node.data;
                node = node.right;//转向右子树
            }
        }
        System.out.println(detail);
    }

    public void preOrderTraverse() {
        if (this.root == null) {
            return;
        }
        doPreOrderTraverse(this.root);
    }

    private void doPreOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        doPreOrderTraverse(node.left);
        doPreOrderTraverse(node.right);
    }

    public void inOrderTraverse2() {
        if (this.root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = this.root;
        String detail = "";
        while (node != null || stack.size() > 0) {
            while (node != null) { //一直向左并将沿途节点压入堆栈
                stack.push(node);
                detail = detail + "\npush " + node.data;
                node = node.left;
            }
            if (stack.size() > 0) {
                node = stack.pop(); //节点弹出堆栈
                System.out.print(node.data + " ");//（访问） 打印结点
                detail = detail + "\npop and visit " + node.data;
                node = node.right;//转向右子树
            }
        }
        System.out.println(detail);
    }

    public void inOrderTraverse3() {
        if (this.root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = this.root;
        String detail = "";
        while (node != null || stack.size() > 0) {
           if(node!=null){
               stack.push(node);
               detail = detail + "\npush " + node.data;
               node = node.left;
           }else {
               node = stack.pop();
               detail = detail + "\npop and visit " + node.data;
               System.out.print(node.data+" ");
               node = node.right;
           }
        }
        System.out.println(detail);
    }

    public void inOrderTraverse() {
        if (this.root == null) {
            return;
        }
        doInOrderTraverse(this.root);
    }

    private void doInOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        doInOrderTraverse(node.left);
        System.out.print(node.data + " ");
        doInOrderTraverse(node.right);
    }

    public void postOrderTraverse() {
        if (this.root == null) {
            return;
        }
        doPostOrderTraverse(this.root);
    }

    private void doPostOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        doPostOrderTraverse(node.left);
        doPostOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrderTraverse() {
        if (this.root == null) {
            return;
        }
        DoubleLinkedList<Node> queue = new DoubleLinkedList<>();
        queue.addLast(root);
        Node last = root;
        Node nextLast = root;
        while (queue.size() > 0) {
            Node node = queue.removeFirst();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.addLast(node.left);
                nextLast = node.left;
            }
            if (node.right != null) {
                queue.addLast(node.right);
                nextLast = node.right;
            }
            if (node == last) {
                System.out.println();
                last = nextLast;
            }
        }
    }

    public static void main(String[] args) {
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String> f = new Node<>("F");
        Node<String> g = new Node<>("G");
        Node<String> h = new Node<>("H");
        Node<String> i = new Node<>("I");
        Node<String> j = new Node<>("J");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        f.right = j;

        BinaryTree<String> tree = new BinaryTree<>();
        tree.root = a;
        System.out.println("前序遍历： ");
        tree.preOrderTraverse();
        System.out.println();
        tree.preOrderTraverse2();

        System.out.println();
        System.out.println("中序遍历： ");
        tree.inOrderTraverse();
        System.out.println();
        tree.inOrderTraverse2();
        System.out.println();
        tree.inOrderTraverse3();

        System.out.println();
        System.out.println("后序遍历： ");
        tree.postOrderTraverse();

        System.out.println();
        System.out.println("层序遍历： ");
        tree.levelOrderTraverse();
    }
}
