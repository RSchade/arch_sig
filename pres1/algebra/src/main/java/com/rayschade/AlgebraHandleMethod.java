package com.rayschade;

public abstract class AlgebraHandleMethod {
    protected abstract String collectRawString() throws Exception;
    protected abstract String parse(String raw);
    protected abstract void handleOutput(String parsed);

    public void handle() {
        try {
            String raw = collectRawString();
            String parsed = parse(raw);
            handleOutput(parsed);
        } catch(Exception e) {
            System.out.println("Error :(");
            e.printStackTrace();
        }
    }
}
