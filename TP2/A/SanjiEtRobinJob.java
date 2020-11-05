public class SanjiEtRobinJob implements Runnable {
    private CompteBanque compte = CompteBanque();
    @Override
    public void run(){
        for(int x = 0; x < 10; x++){
            demandeRetrait(100);
            if(compte.getSolde()<0){
                System.out.println("Decouvert...!");
            }
        }
    }

    public synchronized void demandeRetrait(int montantRetrait) {
        String nom = Thread.currentThread().getName();
        if (compte.getSolde() >= montantRetrait) {
            System.out.println(nom + "est sur le point de retirer.");
            try {
                Thread.sleep(500);
                System.out.println(nom + "est endormi");
            }
            catch (InterruptedException e) {
                  e.printStackTrace();
            }
            System.out.println(nom + "est reveille");
            compte.retirer(montantRetrait);
            System.out.println(nom + "a completer le retrait");
        } else {
            System.out.println(nom + "na pas assez d'argent");
        }
        System.out.println("Solde courant: " + compte.getSolde() + " Dh");
    }

}
