package tech.fastj.examples.bullethell.scenes;

import tech.fastj.engine.FastJEngine;
import tech.fastj.math.Pointf;
import tech.fastj.math.Transform2D;
import tech.fastj.graphics.display.FastJCanvas;
import tech.fastj.graphics.game.Text2D;

import tech.fastj.systems.control.Scene;
import tech.fastj.systems.control.SceneManager;

import java.awt.Color;
import java.awt.Font;

import tech.fastj.examples.bullethell.util.SceneNames;

public class LoseScene extends Scene {

    private Text2D loseText;
    private Text2D deathInfo;

    public LoseScene() {
        super(SceneNames.LoseSceneName);
    }

    @Override
    public void load(FastJCanvas canvas) {
        GameScene gameScene = FastJEngine.<SceneManager>getLogicManager().getScene(SceneNames.GameSceneName);
        int waveNumber = gameScene.getWaveNumber();

        loseText = Text2D.create("You Lost...")
                .withFill(Color.red)
                .withFont(new Font("Consolas", Font.PLAIN, 96))
                .withTransform(new Pointf(300f, 375f), Transform2D.DefaultRotation, Transform2D.DefaultScale)
                .build();
        deathInfo = Text2D.create("You died on wave: " + waveNumber)
                .withFont(new Font("Consolas", Font.PLAIN, 16))
                .withTransform(new Pointf(500f, 400f), Transform2D.DefaultRotation, Transform2D.DefaultScale)
                .build();

        drawableManager.addGameObject(loseText);
        drawableManager.addGameObject(deathInfo);
    }

    @Override
    public void unload(FastJCanvas canvas) {
        loseText.destroy(this);
        deathInfo.destroy(this);
    }

    @Override
    public void fixedUpdate(FastJCanvas canvas) {
    }

    @Override
    public void update(FastJCanvas canvas) {
    }
}
