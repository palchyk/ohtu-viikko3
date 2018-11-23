package statistics.matcher;

import java.util.ArrayDeque;
import java.util.Deque;

public class Querybuilder {

    Deque<Matcher> matchers = new ArrayDeque<Matcher>();

    public Matcher build() {
        if (matchers.size() > 1) {
            Matcher[] m = new Matcher[matchers.size()];
            for (int i = 0; i < m.length; i++) {
                m[i] = matchers.pop();

            }
            return new And(m);
        } else {

            return matchers.peek();
        }
    }

    public Querybuilder oneOf(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }

    public Querybuilder playsIn(String s) {
        matchers.add(new PlaysIn(s));
        return this;
    }

    public Querybuilder hasAtLeast(int i, String s) {
        matchers.add(new HasAtLeast(i, s));
        return this;
    }

    public Querybuilder hasFewerThan(int i, String s) {
        matchers.add(new HasFewerThan(i, s));
        return this;
    }

}
