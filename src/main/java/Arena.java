import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;



public class Arena {
    int height = 20;
    int width = 20;
    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }
    private void draw() throws IOException {
        Screen.clear();
        arena.draw(screen);
        screen.refresh();
    }

    public Arena(int height, int width) {


    }
}


