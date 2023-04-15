package bridge.controller;

import bridge.view.InputView;

public class InputController {

    private final InputView inputView = new InputView();

    public int inputSize(){
        try{
            int bridgeSize = inputView.readBridgeSize();
            return bridgeSize;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputSize();
        }
    }

}
