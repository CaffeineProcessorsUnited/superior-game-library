package de.hnzlmnn.sgl.types;

/**
 * @author Malte Heinzelmann
 */
public class VarUpdaterData<T extends Object> {
    public final T data;
    public final Boolean forceUpdate;

    public VarUpdaterData(T data) {
        this(data, false);
    }

    public VarUpdaterData(T data, Boolean forceUpdate) {
        this.data = data;
        this.forceUpdate = forceUpdate;
    }
}
