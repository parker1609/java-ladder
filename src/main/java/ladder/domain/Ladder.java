package ladder.domain;

import ladder.view.ConsoleMessages;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_WIDTH = 2;
    private static final int MIN_HEIGHT = 1;

    private final int width;
    private final int height;
    private List<LadderRow> rows = new ArrayList<>();

    public Ladder(final int width, final int height) {
        valid(width, height);
        this.width = width;
        this.height = height;
        make();
    }

    public Ladder(final int width, final int height, RandomGenerator randomGenerator) {
        valid(width, height);
        this.width = width;
        this.height = height;
        make(randomGenerator);
    }

    private void valid(int width, int height) {
        if (width < MIN_WIDTH || height < MIN_HEIGHT) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_LADDER_RANGE.message());
        }
    }

    private void make() {
        RandomGenerator randomGenerator = new RandomGenerator();
        make(randomGenerator);
    }

    private void make(RandomGenerator randomGenerator) {
        for (int i = 0; i < this.height; i++) {
            rows.add(new LadderRow(this.width, randomGenerator).getRow());
        }
    }

    public Ladder(int width, String inputHeight) {
        int height;
        try {
            height = Integer.parseInt(inputHeight);
            valid(width, height);
            this.width = width;
            this.height = height;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_NUMBER_FORMAT.message());
        }
    }

    LadderRow status(int index) {
        return rows.get(index);
    }

    public List<LadderRow> status() {
        return rows;
    }
}
