package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
    
    private int capacite;
    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        if(taille<=0)
            taille=CAPACITE_PAR_DEFAUT;
        capacite=taille;
        v=new Vector<Object>(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        v.add(o);
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return v.remove(taille()-1);
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return v.get(taille()-1);
        
    }

    public int taille() {
        return v.size();
    }

    public int capacite() {
        return capacite;
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
        return taille()==capacite();
    }

    public String toString() {
        return v.toString();
    }

    public boolean equals(Object o) {
        Pile3 p=(Pile3) o;
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

}
