/*
 * This  is part of superior-game-library and is distributed under the following license:
 *  "THE BEER-WARE LICENSE" (Revision 42):
 *  Malte Heinzelmann wrote this file.  As long as you retain this notice you can
 *  do whatever you want with this stuff. If we meet some day, and you think this
 *  stuff is worth it, you can buy me a beer in return.          malte@hnzlmnn.de
 */

package de.caffeineaddicted.sgl;

import de.caffeineaddicted.sgl.impl.exceptions.GameAlreadyInitializedException;
import de.caffeineaddicted.sgl.impl.exceptions.GameNotInitializedException;
import de.caffeineaddicted.sgl.interfaces.ApplicationConfigurationProvider;
import de.caffeineaddicted.sgl.interfaces.Provider;
import de.caffeineaddicted.sgl.messages.Message;
import de.caffeineaddicted.sgl.messages.MessageReceiver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Malte Heinzelmann
 */

public class SGL {

    private static SGLGame game = null;
    private static Map<Class<? extends Message>, ArrayList<MessageReceiver>> messageReceivers = new HashMap<Class<? extends Message>, ArrayList<MessageReceiver>>();

    public static SGLGame game() {
        if (game == null) {
            throw new GameNotInitializedException();
        }
        return game;
    }

    public static <T extends SGLGame> T game(Class<T> c) {
        if (game == null) {
            throw new GameNotInitializedException();
        }
        return c.cast(game);
    }

    public static <T extends SGLGame> void game(T g) {
        if (game != null) {
            throw new GameAlreadyInitializedException();
        }
        game = g;
    }

    public static <T> boolean provides(Class<T> key) {
        if (game == null) {
            throw new GameNotInitializedException();
        }
        return game.provides(key);
    }

    public static <T> T provide(Class<T> key) {
        if (game == null) {
            throw new GameNotInitializedException();
        }
        return game.provide(key);
    }

    public static void registerMessageReceiver(Class<? extends Message> messageType, MessageReceiver messageReceiver) {
        if (messageReceivers.get(messageType) == null) {
            messageReceivers.put(messageType, new ArrayList<MessageReceiver>());
        }
        messageReceivers.get(messageType).add(messageReceiver);
    }

    public static void message(Message message) {
        ArrayList<MessageReceiver> messageReceiverList = messageReceivers.get(message.getClass());
        if (messageReceiverList != null) {
            for (MessageReceiver messageReceiver : messageReceivers.get(message.getClass())) {
                if (messageReceiver != null) {
                    messageReceiver.receiveMessage(message);
                }
            }
        }
    }

    public static void config() {
        game().config();
    }

    public static void log(String message, String... sub) {
        game().log(message, sub);
    }

    public static void debug(String message, String... sub) {
        game().debug(message, sub);
    }

    public static void error(String message, String... sub) {
        game().error(message, sub);
    }

    public static void warn(String message, String... sub) {
        game().warn(message, sub);
    }

}