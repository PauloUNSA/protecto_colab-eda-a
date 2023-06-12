package eda_lab4_ej1;

public interface TDAList <E>{
    public void InserFist(E x);
    public void InserLast(E x);
    public void remove(E x);
    public int lenght();
    public boolean IsEmpty();
}
