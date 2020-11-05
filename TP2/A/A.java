public class A{

    public static void main(String[] args){

        SanjiEtRobinJob job = new SanjiEtRobinJob();
        System.out.println("Solde courant: " + job.compte.getSolde() + " Dh");

        Thread sanji = new Thread(job);
        sanji.setName("Sanji");
        Thread robine = new Thread(job);
        robine.setName("Robin");

        sanji.start();
        robine.start();
    }

}