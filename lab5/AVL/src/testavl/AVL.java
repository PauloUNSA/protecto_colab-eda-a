
package testavl;

import myExceptions.ExceptionNoFound;

class AVL<T extends Comparable<T>> {
    private NodeAVL<T> root;
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
    public void remove(T x) throws ExceptionNoFound {
    this.root = remove(x, this.root);
    this.height = false;
}

private NodeAVL<T> remove(T x, NodeAVL<T> current) throws ExceptionNoFound {
    NodeAVL<T> res = current;
    if (current == null) {
        throw new ExceptionNoFound("Elemento no encontrado en el árbol");
    } else {
        int resC = current.getData().compareTo(x);
        if (resC == 0) {
            if (current.getLeft() == null && current.getRigth()== null) {
                res = null;
                this.height = true;
            } else if (current.getLeft() == null) {
                res = (NodeAVL<T>) current.getRigth();
                this.height = true;
            } else if (current.getRigth() == null) {
                res = (NodeAVL<T>) current.getLeft();
                this.height = true;
            } else {
                NodeAVL<T> aux = getMin((NodeAVL<T>) current.getRigth());
                current.setData(aux.getData());
                current.setRigth(remove(aux.getData(), (NodeAVL<T>) current.getRigth()));
                this.height = true;
            }
        } else if (resC < 0) { // current.data es menor
            res.setRigth(remove(x, (NodeAVL<T>) current.getRigth()));
            if (this.height) {
                switch (res.getBf()) {
                    case -1:
                        res.setBf(0);
                        break;
                    case 0:
                        res.setBf(1);
                        this.height = false;
                        break;
                    case 1:
                        res = balanceToLeft(res);
                        break;
                }
            }
        } else {
            res.setLeft(remove(x, (NodeAVL<T>) current.getLeft()));
            if (this.height) {
                switch (res.getBf()) {
                    case 1:
                        res.setBf(0);
                        break;
                    case 0:
                        res.setBf(-1);
                        this.height = false;
                        break;
                    case -1:
                        res = balanceToRigth(res);
                        break;
                }
            }
        }
    }
    return res;
}

private NodeAVL<T> getMin(NodeAVL<T> node) {
    if (node.getLeft() == null)
        return node;
    return getMin((NodeAVL<T>) node.getLeft());
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
    

    public NodeAVL<T> getMax() {
    return getMax(root);
}

    private NodeAVL<T> getMax(NodeAVL<T> nodo) {
        if (nodo.getRigth() == null) {
            return nodo;
    }
        return getMax((NodeAVL<T>) nodo.getRigth());
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


 
    public T parent(T elemento) throws ExceptionNoFound {
    	NodeAVL<T> aux=root;
    	NodeAVL<T> padre;
    	if(isEmpty()) {
    		throw new ExceptionNoFound("Arbol vacío");
    	}
    	else if(elemento.compareTo(root.getData())==0) {
    		throw new ExceptionNoFound("Elemento ingresado es la raíz");
    	}
    	else {
    		while(aux!=null) {
        		if(aux.getLeft().getData().compareTo(elemento)==0||aux.getRigth().getData().compareTo(elemento)==0) {
        			return aux.getData();
        		}
        		else {
        			if(elemento.compareTo(aux.getData())==-1) {
        				aux=(NodeAVL<T>) aux.getLeft();
        			}
        			else {
        				aux=(NodeAVL<T>) aux.getRigth();
        			}
        		}
        	}
    	}
    	
    	throw new ExceptionNoFound("No se encontró el elemento");
    	
    	
    	
    }
    public String son(T elemento) throws ExceptionNoFound {
    	String hijos="";
    	NodeAVL<T> aux=search((NodeAVL<T>) new NodeAVL<T>(elemento));
    	if(aux.getLeft()==null&&aux.getRigth()==null) {
    		throw new ExceptionNoFound("El nodo no tiene hijos");
    	}
    	else {
    		if(aux.getLeft()!=null) {
    			hijos+="Left: "+aux.getLeft().getData()+" ";
    		}
    		if(aux.getRigth()!=null) {
    			hijos+="Rigth: "+aux.getRigth().getData();
    		}
    	}
    	
    	
    	
    	return hijos;
    }
}

