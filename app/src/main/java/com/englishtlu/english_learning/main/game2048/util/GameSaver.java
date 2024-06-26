package com.englishtlu.english_learning.main.game2048.util;


import static com.englishtlu.english_learning.main.game2048.util.Constants.CAN_UNDO;
import static com.englishtlu.english_learning.main.game2048.util.Constants.GAME_STATE;
import static com.englishtlu.english_learning.main.game2048.util.Constants.HEIGHT;
import static com.englishtlu.english_learning.main.game2048.util.Constants.HIGH_SCORE;
import static com.englishtlu.english_learning.main.game2048.util.Constants.SCORE;
import static com.englishtlu.english_learning.main.game2048.util.Constants.UNDO_GAME_STATE;
import static com.englishtlu.english_learning.main.game2048.util.Constants.UNDO_GRID;
import static com.englishtlu.english_learning.main.game2048.util.Constants.UNDO_SCORE;
import static com.englishtlu.english_learning.main.game2048.util.Constants.WIDTH;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.englishtlu.english_learning.main.game2048.data.Tile;
import com.englishtlu.english_learning.main.game2048.ui.widget.G2048View;

public class GameSaver {

    public static void saveGame(Context context, G2048View view) {
        if (view == null) return;

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();

        Tile[][] field = view.game.grid.field;
        Tile[][] undoField = view.game.grid.undoField;

        editor.putInt(WIDTH, field.length);
        editor.putInt(HEIGHT, field.length);

        for (int xx = 0; xx < field.length; xx++) {
            for (int yy = 0; yy < field[0].length; yy++) {
                if (field[xx][yy] != null) {
                    editor.putInt(xx + " " + yy, field[xx][yy].getValue());
                } else {
                    editor.putInt(xx + " " + yy, 0);
                }

                if (undoField[xx][yy] != null) {
                    editor.putInt(UNDO_GRID + xx + " " + yy, undoField[xx][yy].getValue());
                } else {
                    editor.putInt(UNDO_GRID + xx + " " + yy, 0);
                }
            }
        }
        editor.putLong(SCORE, view.game.getScore());
        editor.putLong(HIGH_SCORE, view.game.getCurrentHighScore());
        editor.putLong(UNDO_SCORE, view.game.getLastScore());
        editor.putBoolean(CAN_UNDO, view.game.isCanUndo());
        editor.putInt(GAME_STATE, view.game.gameState);
        editor.putInt(UNDO_GAME_STATE, view.game.lastGameState);

        editor.apply();
    }

    public static void loadGame(Context context, G2048View view) {
        if (view == null) return;

        //Stopping all animations
        view.game.aGrid.cancelAnimations();

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);

        for (int xx = 0; xx < view.game.grid.field.length; xx++) {
            for (int yy = 0; yy < view.game.grid.field[0].length; yy++) {
                int value = settings.getInt(xx + " " + yy, -1);
                if (value > 0) {
                    view.game.grid.field[xx][yy] = new Tile(xx, yy, value);
                } else if (value == 0) {
                    view.game.grid.field[xx][yy] = null;
                }

                int undoValue = settings.getInt(UNDO_GRID + xx + " " + yy, -1);
                if (undoValue > 0) {
                    view.game.grid.undoField[xx][yy] = new Tile(xx, yy, undoValue);
                } else if (value == 0) {
                    view.game.grid.undoField[xx][yy] = null;
                }
            }
        }

        view.game.setScore(settings.getLong(SCORE, view.game.getScore()));
        view.game.setHighScore(settings.getLong(HIGH_SCORE, view.game.getCurrentHighScore()));
        view.game.setLastScore(settings.getLong(UNDO_SCORE, view.game.getLastScore()));
        view.game.setCanUndo(settings.getBoolean(CAN_UNDO, view.game.isCanUndo()));
        view.game.gameState = settings.getInt(GAME_STATE, view.game.gameState);
        view.game.lastGameState = settings.getInt(UNDO_GAME_STATE, view.game.lastGameState);
    }

}
