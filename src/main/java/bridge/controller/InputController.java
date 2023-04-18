package bridge.controller;

import bridge.view.InputView;

public class InputController {

    private final InputView inputView = new InputView();

    public int inputSize() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputSize();
        }
    }

    public String readMoving() {
        try {
            String move = inputView.readMoving();
            return move;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    public String readGameCommand() {
        try {
            String restart = inputView.readGameCommand();
            return restart;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }
}
