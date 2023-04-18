package bridge;

import java.util.List;


public class BridgeGame {

    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(String input, List<List<String>> gameProcess) {
        int index = gameProcess.get(0).size();
        if (bridge.get(index).equals(input)) {
            addInput(input, gameProcess);
        }
        if (!bridge.get(index).equals(input)) {
            addWrongInput(input, gameProcess);
        }
        return gameProcess;
    }

    private void addWrongInput(String input, List<List<String>> gameProcess) {
        if (input.equals("U")) {
            gameProcess.get(0).add(" X ");
            gameProcess.get(1).add("   ");
        }
        if (input.equals("D")) {
            gameProcess.get(0).add("   ");
            gameProcess.get(1).add(" X ");
        }
    }

    private void addInput(String input, List<List<String>> gameProcess) {
        if (input.equals("U")) {
            gameProcess.get(0).add(" O ");
            gameProcess.get(1).add("   ");
        }
        if (input.equals("D")) {
            gameProcess.get(0).add("   ");
            gameProcess.get(1).add(" O ");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String str) {
        if (str.equals("R")) {
            return true;
        }
        return false;
    }
}
