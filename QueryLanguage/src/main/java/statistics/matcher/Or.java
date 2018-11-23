package statistics.matcher;

import statistics.Player;

public class Or implements Matcher {

    private Matcher[] matchers;

    public Or(Matcher... matchers) {
        this.matchers = matchers;
        System.out.println(this.matchers.length);
    }

    @Override
    public boolean matches(Player p) {
        int counter =0;
        for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                counter++;
            }
        }
        if(counter!=0)return true;
        else return false;
    }
}