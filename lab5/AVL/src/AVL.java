class AVL<T extends Comparable<T>>{
    protected NodeAVL<T> root;
    public AVL(){
        this.root = null;
    }
    //public void insert(T x);
    //public void remove(T x);
    protected NodeAVL<T> rotateSR(NodeAVL<T> node){
        NodeAVL<T> h =  (NodeAVL<T>) node.getRigth();
        node.setLeft(h.getRigth());
        h.setRigth(node);
        node = h;
        return node;
    }
    protected NodeAVL<T> rotateSL(NodeAVL<T> node){
        NodeAVL<T> h = (NodeAVL<T>) node.getRigth();
        node.setRigth(h.getLeft()); 
        h.setLeft(node);
        node = h;
        return node;
    }
    public NodeAVL<T> getMin(){
        return getMin(root);
    }
    private NodeAVL<T> getMin(NodeAVL<T> nodo){
        if (nodo.getLeft()==null)return nodo;
        return getMin((NodeAVL<T>) nodo.getLeft());
    }
    public NodeAVL<T> getMax(){
        return this.root;
    }
    public NodeAVL<T> search(NodeAVL<T> nodo){
        return search(nodo,root);
    }
    private NodeAVL<T> search(NodeAVL<T> nodo,NodeAVL<T> otro){
        if (nodo.getData().compareTo(otro.getData())==0)return otro;
        else if (nodo.getData().compareTo(otro.getData())>0) {//nodo es mayor
            return search(nodo, (NodeAVL<T>) otro.getRigth());
        }else return search(nodo, (NodeAVL<T>) otro.getLeft());
    }

}

