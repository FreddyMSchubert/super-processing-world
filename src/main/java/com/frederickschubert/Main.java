package com.frederickschubert;

import com.frederickschubert.object.GameObject;
import processing.core.PApplet;

import java.io.IOException;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main(Main.class.getName()); // launch processing
    }

    @Override
    public void settings() {
        size(500, 500);
    }

    @Override
    public void setup() {
        colorMode(HSB, 360, 100, 100);
        noStroke();
    }

    @Override
    public void draw() {
        background(255);

        // Face circle
        fill(55, 100, 100);
        ellipse(width / 2f, height / 2f, 380, 380);

        // Eyes
        fill(0);
        ellipse(width * 0.38f, height * 0.40f, 40, 60);
        ellipse(width * 0.62f, height * 0.40f, 40, 60);

        // Smile
        noFill();
        stroke(0);
        strokeWeight(12);
        float cx = width / 2f;
        float cy = height * 0.58f;
        arc(cx, cy, 260, 220, radians(20), radians(160));

        // draw game
        LevelDataLoader loader = null;
        try
        {
            loader = new LevelDataLoader("levels/test.lvl");
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        Game game = new Game(loader);
        for (GameObject obj : game.objects) {
            switch (obj.getClass().getSimpleName()) {
                case "PlayerGameObject" -> fill(0, 0, 100);
                case "WallGameObject" -> fill(0, 0, 0);
                default -> fill(255, 0, 0);
            }
            noStroke();
            rect(obj.x * 50, obj.y * 50, 50, 50);
        }
    }
}
