package ladder;

import ladder.domain.Ladder;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        int width = inputView.readName().size();
        int height = inputView.readHeight();

        Ladder ladder = new Ladder(width, height);
        ladder.row();

        OutputView outputView = new OutputView();
//        for (int i = 0; i < height; i++) {
//            outputView.print(ladder.status(i));
//        }
        outputView.print(ladder);
    }
}