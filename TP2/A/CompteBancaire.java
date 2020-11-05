public class CompteBancaire{

    public int solde = 200;

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public void retirer(int solde){
        this.solde = this.solde - solde;
    }
}