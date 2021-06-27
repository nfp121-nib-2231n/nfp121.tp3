package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if(taille<=0){
            taille=CAPACITE_PAR_DEFAUT;
        }
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        return depiler();
    }

    public int capacite() {
        return zone.length;
    }

    public int taille() {
        System.out.print(ptr);
        return ptr;
    }

    public boolean estVide() {
        return ptr == 0;
    }

    public boolean estPleine() {
        return ptr == zone.length;
    }

    public boolean equals(Object o) {
        int i=0;
        Pile p=(Pile) o;
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

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}