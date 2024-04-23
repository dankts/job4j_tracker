package ru.job4j.tracker;

public class StubOutput implements Output {
    private final StringBuilder buf = new StringBuilder();

    @Override
    public void println(Object obj) {
        if (obj != null) {
            buf.append(obj);
        } else {
            buf.append("null");
        }
        buf.append(System.lineSeparator());
    }

    @Override
    public String toString() {
        return buf.toString();
    }
}
