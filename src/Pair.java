public class Pair <X, Y> implements  Comparable<Pair>{
    X _first;
    Y _second;

    public Pair(X f, Y s) { _first = f; _second = s; }

    X first() { return _first; }
    Y second() { return _second; }

    void setFirst(X f) { _first = f; }
    void setSecond(Y s) { _second = s; }

    public int hashCode(){
        return (Integer)_first * 1000000007 + (int)_second;
    }

    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;
        Pair temp = (Pair<X,Y>) obj;
        if(this._first == temp._first && this._second == temp._second)
            return true;
        return false;

    }

    public int compareTo(Pair other){
        if((double)this.second() < (double)other.second())
            return 1;
        if((double)this.second() > (double)other.second())
            return -1;
        return 0;

    }
}
