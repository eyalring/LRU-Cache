package cache;
public class DataHolder {
    private String name;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    int index;

    public DataHolder(String name) {
        this.name = name;
    }

    public String getName() {
         return this.name;
    }
}
