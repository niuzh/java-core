package v1.ch12;

public class Pair<T> {
	private T first;
	private T second;
	public Pair() {
		setFirst(null);
		setSecond(null);
	}
	public Pair(T first,T second){
		this.setFirst(first);
		this.setSecond(second);
	}
	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public T getSecond() {
		return second;
	}
	public void setSecond(T second) {
		this.second = second;
	}
}
