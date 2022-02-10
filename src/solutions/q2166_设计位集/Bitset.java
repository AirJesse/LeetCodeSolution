package solutions.q2166_设计位集;


public class Bitset {
    int[] bit;
    int version = 0;
    boolean flip = false;
    int count = 0;
    int stringVersion = 0;
    String s;

    public Bitset(int size) {
        bit = new int[size];
    }

    public void fix(int idx) {
        if ((bit[idx] == 0 && !flip) || (bit[idx] == 1 && flip)) {
            count++;
        }
        bit[idx] = flip ? 0 : 1;
        version++;
    }

    public void unfix(int idx) {
        if ((bit[idx] == 1 && !flip) || (bit[idx] == 0 && flip)) {
            count--;
        }
        bit[idx] = flip ? 1 : 0;
        version++;

    }

    public void flip() {
        flip = !flip;
        count = bit.length - count;
        version++;
    }

    public boolean all() {

        return count == bit.length;
    }

    public boolean one() {
        if (all()) {
            return true;
        }
        return count > 0;
    }

    public int count() {
        return count;
    }

    public String toString() {
        if (stringVersion == version && s != null) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : bit) {
            if (flip) {
                sb.append(i == 0 ? 1 : 0);
            } else {
                sb.append(i);
            }
        }
        s = sb.toString();
        stringVersion = version;

        return s;
    }
}
