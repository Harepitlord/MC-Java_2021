package level3.construction;

public class house extends building {
    private int noBed;
    private int noBaths;

    public house() {
        noBaths = 0;
        noBed = 0;
    }

    public int getNoBaths() {
        return noBaths;
    }

    public int getNoBed() {
        return noBed;
    }

    public void setNoBed(int noBed) {
        this.noBed = noBed;
    }

    public void setNoBaths(int noBaths) {
        this.noBaths = noBaths;
    }

    @Override
    public String toString() {
        return "noBed=" + noBed + ", noBaths=" + noBaths;
    }
}
