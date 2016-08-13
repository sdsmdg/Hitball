package com.sdsmdg.cycle.objects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.sdsmdg.cycle.chelpers.AssetLoader;
import com.sdsmdg.cycle.gameworld.GameWorld;

public class Board {

    private int score;
    private int highscore;
    private Vector2 position;
    private float width, height;
    private GlyphLayout glyphLayout;
    private GameWorld myWorld;
    private int screenWidth, screenHeight;

    public Board(GameWorld world, float width, float height, Vector2 position) {
        this.height = height;
        this.position = position;
        this.width = width;
        this.myWorld = world;

        screenWidth = myWorld.getScreenWidth();
        screenHeight = myWorld.getScreenHeight();

        glyphLayout = new GlyphLayout();
    }

    public void onDraw(SpriteBatch batch, ShapeRenderer renderer) {

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(34/255f, 126/255f, 200/255f, 1f);
        renderer.rect(
                position.x, position.y,
                width, height
        );
        renderer.end();

        batch.begin();

        drawText(String.valueOf(myWorld.getScore()),
                batch,
                position.x + width / 2, position.y + height / 2,
                AssetLoader.font80);

        drawText("Score",
                batch,
                position.x + width / 2, position.y + 40,
                AssetLoader.font80);

        drawText("Best Score",
                batch,
                position.x + width / 2, position.y + height - 60,
                AssetLoader.font40);

        drawText(String.valueOf(myWorld.getHighScore()),
                batch,
                position.x + width / 2, position.y + height - 30,
                AssetLoader.font40);

        batch.end();
    }

    private void drawText(String text, SpriteBatch batch, float x, float y, BitmapFont font) {
        glyphLayout.setText(font, text);
        float w = glyphLayout.width;
        float h = glyphLayout.height;
        font.draw(batch, text, x - w / 2, y - h / 2);
    }

}
