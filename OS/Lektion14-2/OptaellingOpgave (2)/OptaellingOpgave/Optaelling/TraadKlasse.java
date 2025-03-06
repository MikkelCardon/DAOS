package Optaelling;

public class TraadKlasse extends Thread{
    int start;
    int slut;
    String[] stemmer;

    int[] tempStemmer;

    public TraadKlasse(int start, int slut, String[] stemmer) {
        this.start = start;
        this.slut = slut;
        this.stemmer = stemmer;
    }


    public void run(){
        String[] navn = Optaelling.getMuligeNavne();
        tempStemmer = new int[navn.length];

        for (int i = start; i < slut; i++) {
            for (int i1 = 0; i1 < navn.length; i1++) {
                if (navn[i1].equals(stemmer[i])){
                    tempStemmer[i1]++;
                    break;
                }
            }
        }
    }

    public int[] getOptaelling(){
        return tempStemmer;
    }
}
