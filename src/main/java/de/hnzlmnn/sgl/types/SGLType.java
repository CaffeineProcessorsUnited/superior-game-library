/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.hnzlmnn.sgl.types;

import de.hnzlmnn.sgl.impl.exceptions.DataObjectIsNullException;

import java.util.*;

/**
 * @author Malte Heinzelmann
 */
public abstract class SGLType<T extends Object> extends SGLObject {
    private Integer id = System.identityHashCode(this);
    private T variable;
    private HashMap<String, SGLType<?>> references = new HashMap<String, SGLType<?>>();
    private ArrayList<SGLType<?>> referencedBy = new ArrayList<SGLType<?>>();
    private VarUpdater<T> updater = new VarUpdater<T>() {
        @Override
        public VarUpdaterData<T> update(SGLType<T> v) {
            return null;
        }
    };

    public SGLType() {
    }

    public SGLType(T data) {
        variable = data;
    }

    public abstract T cloneData();


    /**
     * Add a reference which calls us if the reference data changes
     *
     * @param name The name for the reference
     * @param v    The reference
     */
    public void ref(String name, SGLType<?> v) {
        if (references.containsKey(name)) {
            throw new DuplicateFormatFlagsException(name);
        }
        references.put(name, v);
        v.addRef(this);
    }


    /**
     * Returns a reference with the given name
     *
     * @param name The name for the reference
     */
    public SGLType<?> ref(String name) {
        return references.get(name);
    }

    /**
     * Returns a reference with the given name and casts it to given type
     *
     * @param name    The name for the reference
     * @param toClass The type to which we should try to cast to
     */
    public <T2> T2 ref(String name, Class<T2> toClass) {
        return ref(name).to(toClass);
    }


    /**
     * Adds a variable to the list of variables that reference us.
     * If out data changes tell all of them to update
     *
     * @param v The reference
     */
    protected void addRef(SGLType<?> v) {
        referencedBy.add(v);
    }

    /**
     * Returns the name of a reference or null if the reference isn't registered
     *
     * @param value The reference
     */
    protected String getRefName(SGLType<?> value) {
        String name = null;
        if (references.containsValue(value)) {
            Iterator it = references.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, SGLType<?>> pair = (Map.Entry) it.next();
                if (pair.getValue() == value) {
                    name = pair.getKey();
                    break;
                }
                it.remove(); // avoids a ConcurrentModificationException
            }
        }
        return name;
    }

    /**
     */
    public T get() {
        return variable;
    }

    /**
     * Is our data value null
     *
     * @return true is data is null
     * false is data is not null
     */
    public Boolean isNull() {
        return variable == null;
    }

    /**
     * Reassign our data with some new data
     *
     * @param data The data
     * @return The data
     */
    public T assign(T data) {
        variable = data;
        dataChanged(new ArrayList<SGLType<?>>());
        return isNull() ? null : get();
    }

    /**
     * Reassign our data with some new data
     *
     * @param b The data
     * @return Us
     */
    public SGLType<T> assign(SGLType<T> b) {
        assign(b.isNull() ? null : b.get());
        return this;
    }

    public String toString() {
        if (isNull()) {
            throw new DataObjectIsNullException();
        }
        return get().toString();
    }

    /**
     * Updates our data using our references
     */
    public void init() {
        refChanged(new ArrayList<SGLType<?>>());
    }

    /**
     * Casts us or our data to the given type
     *
     * @param toClass The type to which we should try to cast to
     * @return Us or our data as type or null if it isn't possible
     */
    public <T2> T2 to(Class<T2> toClass) {
        if (toClass.isInstance(this)) {
            return (T2) this;
        } else if (toClass.isInstance(get())) {
            return (T2) get();
        }
        return null;
    }

    /**
     * Signals all variables that reference us to update
     *
     * @param stack A stack with variables that were updated in this process already
     */
    public void dataChanged(ArrayList<SGLType<?>> stack) {
        if (!stack.contains(this)) {
            stack.add(this);
        }
        for (SGLType<?> ref : referencedBy) {
            ref.refChanged(stack);
        }
    }

    /**
     * Signals us to update ourself because a variable we reference has changed
     *
     * @param stack A stack with variables that were updated in this process already
     */
    public void refChanged(ArrayList<SGLType<?>> stack) {
        if (stack.contains(this)) {
            System.out.println("Loop detected while updating \""
                    + getClass().getName() + "\" = \"" + get()
                    + "\" because of \""
                    + getRefName(stack.get(stack.size() - 1)) + "\" = \"" + stack.get(stack.size() - 1).get() + "\"!");
            return;
        } else {
            stack.add(this);
        }
        VarUpdaterData<T> updateData = updater.update(this);
        if (updateData != null && (updateData.forceUpdate || updateData.data != get())) {
            assign(updateData.data);
            dataChanged(stack);
        }
    }

    /**
     * Sets the updater method which will be called if any reference changes
     *
     * @param updater The updater to be called on reference change
     */
    public void u(VarUpdater<T> updater) {
        this.updater = updater;
    }

}