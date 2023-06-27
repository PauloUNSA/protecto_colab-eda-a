
package testavl;

import myExceptions.ExceptionNoFound;

class AVL<T extends Comparable<T>> {
    protected NodeAVL<T> root;
    private boolean height;

    public AVL() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(T x) throws ExceptionNoFound {
        this.root = insert(x, this.root);
        this.height = false;
    }

    private NodeAVL<T> insert(T x, NodeAVL<T> current) throws ExceptionNoFound {
        NodeAVL<T> res = current;
        if (current == null) {
            res = new NodeAVL<T>(x);
            this.height = true;
        } else {
            int resC = current.getData().compareTo(x);
            if (resC == 0) throw new ExceptionNoFound("Elemento ya se encuentra en el arbol");
            if (resC < 0) {//current.data es menor
                res.setRigth(insert(x, (NodeAVL<T>) current.getRigth()));
                if (this.height) {
                    switch (res.getBf()) {
                        case -1:
                            res.setBf(0);
                            this.height = false;
                            break;
                        case 0:
                            res.setBf(1);
                            break;
                        case 1:
                            //res.setBf(2);
                            res = balanceToLeft(res);
                            this.height = false;
                            break;
                    }
                }
            } else {
                res.setLeft(insert(x, (NodeAVL<T>) current.getLeft()));
                if (this.height) {
                    switch (res.getBf()) {
                        case 1: {
                            res.setBf(0);
                            this.height = false;
                            break;
                        }
                        case 0: {
                            res.setBf(-1);
                            break;
                        }
                        case -1: //res.setBf(2);
                            res = balanceToRigth(res);
                            this.height = false;
                            break;
                    }
                }
            }
        }
        return res;
    }

    private NodeAVL<T> balanceToLeft(NodeAVL<T> node) {
        NodeAVL<T> son = (NodeAVL<T>) node.getRigth();
        if (son.getBf() == 1) {
            node.setBf(0);
            son.setBf(0);
            node = rotateRSL(node);
        } else if (son.getBf() == -1) {
            NodeAVL<T> gSon = (NodeAVL<T>) son.getLeft();
            switch (gSon.getBf()) {
                case -1:
                    node.setBf(0);
                    son.setBf(0);
                    break;
                case 0:
                    node.setBf(-1);
                    son.setBf(1);
                    break;
                case 1:
                    node.setBf(-1);
                    son.setBf(0);
                    break;
            }
            gSon.setBf(0);

            node.setRigth(rotateRSR(son));
            node = rotateRSL(node);
        }
        return node;
    }

    private NodeAVL<T> balanceToRigth(NodeAVL<T> node) {
        NodeAVL<T> son = (NodeAVL<T>) node.getLeft();
        if (son.getBf() == -1) {
            node.setBf(0);
            son.setBf(0);
            node = rotateRSR(node);
        } else if (son.getBf() == 1) {
            NodeAVL<T> gSon = (NodeAVL<T>) son.getRigth();
            switch (gSon.getBf()) {
                case -1:
                    node.setBf(1);
                    son.setBf(0);
                    break;
                case 0:
                    node.setBf(0);
                    son.setBf(0);
                    break;
                case 1:
                    node.setBf(0);
                    son.setBf(-1);
                    break;
            }
            gSon.setBf(0);

            node.setLeft(rotateRSL(son));
            node = rotateRSR(node);
        }
        return node;
    }

    private NodeAVL<T> rotateRSL(NodeAVL<T> node) {
        NodeAVL<T> son = (NodeAVL<T>) node.getRigth();
        node.setRigth(son.getLeft());
        son.setLeft(node);

        return son;
    }

    private NodeAVL<T> rotateRSR(NodeAVL<T> node) {
        NodeAVL<T> son = (NodeAVL<T>) node.getLeft();
        node.setLeft(son.getRigth());
        son.setRigth(node);

        return son;
    }

    public NodeAVL<T> getMin() {
        return getMin(root);
    }

    private NodeAVL<T> getMin(NodeAVL<T> nodo) {
        if (nodo.getLeft() == null) return nodo;
        return getMin((NodeAVL<T>) nodo.getLeft());
    }

    public NodeAVL<T> getMax() {
        return this.root;
    }

    public NodeAVL<T> search(NodeAVL<T> nodo) {
        return search(nodo, root);
    }

    private NodeAVL<T> search(NodeAVL<T> nodo, NodeAVL<T> otro) {
        if (nodo.getData().compareTo(otro.getData()) == 0) return otro;
        else if (nodo.getData().compareTo(otro.getData()) > 0) {//nodo es mayor
            return search(nodo, (NodeAVL<T>) otro.getRigth());
        } else return search(nodo, (NodeAVL<T>) otro.getLeft());
    }

    public void inOrden() {
        if (isEmpty())
            System.out.println("Arbol esta vac�o ....");
        else {
            inOrden(this.root);
            System.out.println();
        }
    }

    private void inOrden(NodeAVL<T> current) {
        if (current.getLeft() != null)
            inOrden((NodeAVL<T>) current.getLeft());
        System.out.print(current + ", ");
        if (current.getRigth() != null)
            inOrden((NodeAVL<T>) current.getRigth());
    }

    public T getRoot() {
        return this.root.getData();
    }

}

