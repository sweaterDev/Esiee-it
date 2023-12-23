package starwars;
/*
@Author SebastienMercellus
@ Version 1.0
*/
public class Duet<T,U> {

	private T first;
    private U second;

    public Duet(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Duet{"+
                first.getClass().getSimpleName()+" : "+first+" "+
                second.getClass().getSimpleName()+" : "+second+
                '}';
    }
}

