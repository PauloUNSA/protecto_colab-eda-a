class AVL<T extends Comparable<T>>{
    protected NodeAVL<T> root;
    public AVL() { this.root = null; }
    //public void insert(T x);
    //public void remove(T x);
    /*protected NodeAVL<T> rotateSR(NodeAVL<T> node){
        NodeAVL<T> h = node.getLeft();
        node.getLeft() = h.getRigth();
        h.getRigth() = node;
        node = h;
        return node;
    }
    protected NodeAVL<T> rotateSL(NodeAVL<T> node){
        NodeAVL<T> h = node.right;
        node.right = h.left;
        h.left = node;
        node = h;
        return node;
    }*/
}

