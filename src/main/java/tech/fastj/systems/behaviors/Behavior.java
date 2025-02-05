package tech.fastj.systems.behaviors;

import tech.fastj.math.Pointf;

import tech.fastj.graphics.game.GameObject;

/**
 * Interface that allows for the addition of behaviors to {@code GameObject}s.
 * <p>
 * Behaviors go hand-in-hand with {@link GameObject}s. A {@code GameObject} can have as many references to the same
 * {@code Behavior} as you may want.
 *
 * @author Andrew Dey
 * @since 1.0.0
 */
public interface Behavior {

    /**
     * Gets an instance of {@code Behavior} that, when assigned to a {@code GameObject}, translates it by the specified
     * translation every {@link #fixedUpdate(GameObject)} call.
     *
     * @param translationModifier The {@code Pointf} value to be used for translation.
     * @return The newly created {@code Behavior}.
     */
    static Behavior simpleTranslation(Pointf translationModifier) {
        return new Behavior() {
            @Override
            public void init(GameObject gameObject) {
            }

            @Override
            public void fixedUpdate(GameObject gameObject) {
                gameObject.translate(translationModifier);
            }

            @Override
            public void update(GameObject gameObject) {
            }
        };
    }

    /**
     * Gets an instance of {@code Behavior} that, when assigned to a {@code GameObject}, rotates it by the specified
     * rotation every {@link #fixedUpdate(GameObject)} call.
     *
     * @param rotationModifier The float value to be used for rotation.
     * @return The newly created {@code Behavior}.
     */
    static Behavior simpleRotation(float rotationModifier) {
        return new Behavior() {
            @Override
            public void init(GameObject gameObject) {
            }

            @Override
            public void fixedUpdate(GameObject gameObject) {
                gameObject.rotate(rotationModifier);
            }

            @Override
            public void update(GameObject gameObject) {
            }
        };
    }

    /**
     * Gets an instance of {@code Behavior} that, when assigned to a {@code GameObject}, scales it by the specified
     * scale every {@link #fixedUpdate(GameObject)} call.
     *
     * @param scaleModifier The {@code Pointf} value to be used for scaling.
     * @return The newly created {@code Behavior}.
     */
    static Behavior simpleScale(Pointf scaleModifier) {
        return new Behavior() {
            @Override
            public void init(GameObject gameObject) {
            }

            @Override
            public void fixedUpdate(GameObject gameObject) {
                gameObject.scale(scaleModifier);
            }

            @Override
            public void update(GameObject gameObject) {
            }
        };
    }

    /**
     * Initializes the assigned {@code GameObject}.
     * <p>
     * This method is used for modifying anything about the GameObject(s) that this behavior is assigned to, before the
     * game is rendered. It is called after the parent {@code Scene} has completed its {@code load()} method.
     *
     * @param gameObject A GameObject that has been assigned this behavior.
     */
    void init(GameObject gameObject);

    /**
     * Updates the assigned {@code GameObject}.
     * <p>
     * This method is used to modify anything about the assigned {@code GameObject}, every time the assigned {@code
     * GameObject}'s containing {@code Scene} updates. It is called after the parent {@code Scene} has completed its
     * {@code fixedUpdate()} method.
     *
     * @param gameObject A GameObject that has been assigned this behavior.
     */
    void fixedUpdate(GameObject gameObject);

    /**
     * Updates the assigned {@code GameObject}.
     * <p>
     * This method is used to modify anything about the assigned {@code GameObject}, every time the assigned {@code
     * GameObject}'s containing {@code Scene} updates. It is called after the parent {@code Scene} has completed its
     * {@code update()} method.
     *
     * @param gameObject A GameObject that has been assigned this behavior.
     */
    void update(GameObject gameObject);

    /** Destroys any leftover memory in the {@code Behavior}. */
    default void destroy() {
    }
}
