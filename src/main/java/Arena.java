import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import javax.swing.*;
import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private Arena arena;
    private Screen screen;

    public Arena(int width, int height){
        this.width = width;
        this.height = height;


    }


    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(4, 5), 'X');
    }
    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }
    private void draw(Screen screen) throws IOException {
        this.screen.clear();
        arena.draw(this.screen);
        this.screen.refresh();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    public void moveHero(Position position) {
        if (canHeroMove(position)) {
            hero.setPosition(position);
        }
    }

    public boolean canHeroMove(Position position) {
        int newX = position.getX();
        int newY = position.getY();

        return newX >= 0 && newX < width && newY >= 0 && newY < height;
    }

}


