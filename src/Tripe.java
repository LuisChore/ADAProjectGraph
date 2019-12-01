
class Triple implements Comparable {
    Double _first;
    Integer _second, _third;

    public Triple(Double f, Integer s, Integer t) {
        _first = f;
        _second = s;
        _third = t;
    }

    public int compareTo(Object o) {
        if (!this.first().equals(((Triple)o).first())){

            Integer a =  this.first().intValue();
            Integer b =  ((Triple)o).first().intValue();
            return a - b;
        }

        else if (!this.second().equals(((Triple)o).second()))
            return this.second() - ((Triple)o).second();
        else
            return this.third() - ((Triple)o).third();
    }

    Double first() { return _first; }
    Integer second() { return _second; }
    Integer third() { return _third; }

    public String toString() { return first() + " " + second() + " " + third(); }
}