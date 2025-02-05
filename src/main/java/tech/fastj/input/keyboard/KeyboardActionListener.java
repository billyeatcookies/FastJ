package tech.fastj.input.keyboard;

import tech.fastj.input.keyboard.events.KeyboardActionEvent;
import tech.fastj.input.keyboard.events.KeyboardStateEvent;
import tech.fastj.input.keyboard.events.KeyboardTypedEvent;

import tech.fastj.gameloop.event.GameEventObserver;

import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * A keyboard action listener.
 *
 * <b>NOTE:</b> For use with a FastJ {@code Scene}, a keyboard action listener must be added to a
 * {@code Scene}'s list of keyboard action listeners.
 * <br>
 * If you are planning to implement this class into a separate usage, you may consider using the {@code InputManager}
 * class to store a list of keyboard action listeners. Then, have events from a class extending {@code KeyListener}
 * fired to that {@code InputManager}.
 *
 * @author Andrew Dey
 * @since 1.0.0
 */
public interface KeyboardActionListener extends GameEventObserver<KeyboardActionEvent> {

    /** Event called when a key is currently pressed, once per game update. */
    default void onKeyDown(Set<Keys> keysDown) {
    }

    /**
     * Event called when a key was recently pressed.
     *
     * @param keyboardStateEvent The key event generated by the recent key press.
     */
    default void onKeyRecentlyPressed(KeyboardStateEvent keyboardStateEvent) {
    }

    /**
     * Event called when a key was recently released.
     *
     * @param keyboardStateEvent The key event generated by the recent key release.
     */
    default void onKeyReleased(KeyboardStateEvent keyboardStateEvent) {
    }

    /**
     * Event called when a key was recently typed.
     *
     * @param keyboardTypedEvent The key event generated by the recent key type.
     */
    default void onKeyTyped(KeyboardTypedEvent keyboardTypedEvent) {
    }

    @Override
    default void eventReceived(KeyboardActionEvent keyboardActionEvent) {
        if (keyboardActionEvent.isConsumed()) {
            return;
        }

        switch (keyboardActionEvent.getRawEvent().getID()) {
            case KeyEvent.KEY_PRESSED: {
                onKeyRecentlyPressed((KeyboardStateEvent) keyboardActionEvent);
                break;
            }
            case KeyEvent.KEY_RELEASED: {
                onKeyReleased((KeyboardStateEvent) keyboardActionEvent);
                break;
            }
            case KeyEvent.KEY_TYPED: {
                onKeyTyped((KeyboardTypedEvent) keyboardActionEvent);
                break;
            }
        }
    }
}
