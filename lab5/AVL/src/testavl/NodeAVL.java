
package testavl;

class NodeAVL<T> extends Node<T> {
    protected int bf;
    public NodeAVL(T data, NodeAVL<T> left, NodeAVL<T> right){
        super(data, left, right);
        this.bf= 0;
    }
   public NodeAVL(T data){ 
        this(data,null, null);
   }
    public int getBf() {
        return bf;
    }

    public void setBf(int Bf) {
        this.bf = Bf;
    }
    public String toString() {
	return this.getData().toString() + "(" + this.bf + ")";
}
    
    
}
