package ladder.view;

import ladder.domain.*;

import java.util.List;

public class OutputView {


    public OutputView() {
    }

    public void print(LadderRow row) {
        System.out.println(ConsoleMessages.OUTPUT_LADDER.message());
        System.out.println(line(row));
    }


    public void print(Ladder ladder) {
        List<LadderRow> rows = ladder.status();
        for (int i = 0; i < rows.size(); i++) {
            System.out.println(line(rows.get(i)));
        }

    }

    public String line(LadderRow row) {
        List<Integer> info = row.status();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   ");
        for (int i = 0; i < info.size() - 1; i++) {
            stringBuilder.append("|");
            stringBuilder.append(mark(info.get(i)));

        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }


    private String mark(Integer number) {
        if (number == LadderRules.RIGHT.number()) {
            return "-----";
        }
        return "     ";
    }

    public String result(PlayerResult playerResult) {
        return playerResult.reward();

    }

    public String result(List<PlayerResult> playerResults) {
        StringBuilder stringBuilder = new StringBuilder();
        for (PlayerResult playerResult : playerResults) {
            stringBuilder.append(playerResult.name());
            stringBuilder.append(" : ");
            stringBuilder.append(playerResult.reward());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void print(PlayerResult playerResult) {
        System.out.println(result(playerResult));
    }

    public void print(Players players, Ladder ladder, LadderRewards ladderRewards) {
        System.out.println(ConsoleMessages.OUTPUT_LADDER.message());
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players.list()) {
            stringBuilder.append(String.format("%6s", player.name()));
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder.toString());
        print(ladder);
        stringBuilder.setLength(0);
        for (String reward : ladderRewards.reward()) {
            stringBuilder.append(String.format("%6s", reward));
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString());
    }
}
