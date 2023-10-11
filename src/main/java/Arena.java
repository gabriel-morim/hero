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

    private Screen screen;


    public Arena(int width, int height){
        this.width = width;
        this.height = height;
        hero = new Hero(width/2, height/2);

    }


    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(graphics);

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

    public boolean canHeroMove(Position position) {
       if (position.getY() < 0) return false;
       if (position.getX() < 0) return false;
       if (position.getY() < height - 1) return false;
       if (position.getX() < width - 1) return false;
       return true;
    }

    public void processKey(com.googlecode.lanterna.input.KeyStroke key) {
        System.out.println(key);
        String keyT = key.getKeyType().toString();
        switch (keyT) {
            case "ArrowUp":
                moveHero(hero.moveUp());
                break;
            case "ArrowDown":
                moveHero(hero.moveDown());
                break;
            case "ArrowLeft":
                moveHero(hero.moveLeft());
                break;
            case "ArrowRight":
                moveHero(hero.moveRight());
                break;
        }
    }
    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen.newTextGraphics());
        screen.refresh();
    }

}


