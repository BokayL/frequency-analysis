
public class Zamenjava {
	private char črka;
    private char zamenjava;

    public Zamenjava(char zamenjava,char a ){
        this.črka=a;
        this.zamenjava=zamenjava;


    }

    public char getČrka() {
        return črka;
    }

    public void setČrka(char črka) {
        this.črka = črka;
    }

    public char getZamenjava() {
        return zamenjava;
    }

    public void setZamenjava(char zamenjava) {
        this.zamenjava = zamenjava;
    }


    public String toString(){

        return črka +"-"+ zamenjava +", ";

    }

}
