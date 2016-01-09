package simufiles;

public class FileAtt {

    int nbpersonne;

    /**
     * Constructeur, affecte une taille maximum et cr�� une file vide
     *
     */
    public FileAtt() {
        nbpersonne = 0;
    }

    public void ajoutClient() {
        nbpersonne++;
    }

    public int departClient() {
        nbpersonne--;
        return nbpersonne;
    }

    /**
     * Renvoie le nombre de personnes dans la file
     *
     * @return
     */
    public int getNbPersonnes() {
        return nbpersonne;
    }

}
