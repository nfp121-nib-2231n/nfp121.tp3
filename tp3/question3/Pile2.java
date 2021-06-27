package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    /** par délégation : utilisation de la class Stack */
    private Stack<T> stk;
    /** la capacité de la pile */
    private int capacite;

    /** Création d'une pile.
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille){
        if(taille<=0){
            taille=CAPACITE_PAR_DEFAUT;
        }
        capacite=taille;
        stk=new Stack<T>();
    }

    public Pile2(){
       this(0);
    }

    public void empiler(T o) throws PilePleineException{
        if (estPleine())
            throw new PilePleineException();
        stk.push(o);
    }

    public T depiler() throws PileVideException{
        if (estVide())
            throw new PileVideException();
        return stk.pop();
    }

    public T sommet() throws PileVideException{
        if(estVide())
            throw new PileVideException();
        return stk.peek();
    }
    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return stk.empty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return taille()==capacite();
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
        //return stk.toString();
        String s="[";
        for(int i=taille()-1;i>=0;i--)
        {
            
            if(i==taille()-1){
                    s+=stk.get(i)+"";
                
            }else{
                
                    s+=", "+stk.get(i);
                
            }
        }
        System.out.println(s+"]");
        return s+ "]";
    }

    public boolean equals(Object o) {
        Pile2 p=(Pile2) o;
        if(taille()==p.taille())
        {
            if(capacite()==p.capacite())
            {
                 while (estVide() == false)
                    {
                        try{
                        if (sommet() == p.sommet())
                        {
                            try{
                            depiler();
                            p.depiler();
                            }catch(PileVideException e)
                            {
                                e.printStackTrace();
                            }
                        }
                        else
                        {
                            return false;
                        }
                        }catch(PileVideException e)
                        {
                            e.printStackTrace();
                        }
                    }
                return true;
            }
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        return capacite;
    }


    

} // Pile2