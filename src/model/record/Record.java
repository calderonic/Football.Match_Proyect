package model.record;

public abstract class Record {
    protected int id;

    public Record(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
