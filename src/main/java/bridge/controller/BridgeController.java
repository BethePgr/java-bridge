package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import java.util.Arrays;
import java.util.List;

public class BridgeController {

    InputController inputView = new InputController();
    BridgeGameService bridgeGameService = new BridgeGameService();

    public void run(){
        int size = inputView.inputSize();
        List<String> bridge = bridgeGameService.initBridge(size);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        List<List<String>> gameProgress = bridgeGameService.initGameProgress();
        while(checkX(gameProgress)){
            String input = inputView.readMoving();
            System.out.println(bridgeGame.move(input,gameProgress));
        }
    }

    private boolean checkX(List<List<String>> gameProgress){
        boolean flag1 = gameProgress.get(0).stream().allMatch(str -> !str.contains("X"));
        boolean flag2 = gameProgress.get(1).stream().allMatch(str -> !str.contains("X"));
        return flag1 && flag2;
    }
}
