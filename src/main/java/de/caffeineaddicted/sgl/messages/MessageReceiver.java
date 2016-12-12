package de.caffeineaddicted.sgl.messages;

/**
 * @author Malte Heinzelmann
 */
public interface MessageReceiver<T extends Message> {
    void receiveMessage(T message);
}
