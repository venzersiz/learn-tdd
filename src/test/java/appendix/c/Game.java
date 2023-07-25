package appendix.c;

public class Game {

    private GameNumGen generator;

    public Game(GameNumGen generator) {
        this.generator = generator;
    }

    public void init(GameLevel level) {
        generator.generate(level);
    }
}
