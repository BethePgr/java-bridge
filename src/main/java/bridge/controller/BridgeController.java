package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Arrays;
import java.util.List;

public class BridgeController {

    InputController inputView = new InputController();
    OutputView outputView = new OutputView();
    BridgeGameService bridgeGameService = new BridgeGameService();

    public void run(){
        int size = inputView.inputSize();
        List<String> bridge = bridgeGameService.initBridge(size);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        List<List<String>> gameProgress = bridgeGameService.initGameProgress();
        while(checkX(gameProgress) && gameProgress.get(0).size() <bridge.size()){
            String input = inputView.readMoving();
            outputView.printMap(bridgeGame,input,gameProgress);
        }
        if(!checkX(gameProgress)){
            String input = inputView.readGameCommand();
        }
        System.out.println("최종 게임 결과");
        outputView.printMapNoInput(gameProgress);
    }

    private boolean checkX(List<List<String>> gameProgress){
        boolean flag1 = gameProgress.get(0).stream().allMatch(str -> !str.contains("X"));
        boolean flag2 = gameProgress.get(1).stream().allMatch(str -> !str.contains("X"));
        return flag1 && flag2;
    }


}
