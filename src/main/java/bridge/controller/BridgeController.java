package bridge.controller;

import bridge.BridgeGame;
import bridge.service.BridgeGameService;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    private final InputController inputView;
    private final OutputView outputView;
    private final BridgeGameService bridgeGameService;
    private List<List<String>> progress;
    private String command;

    public BridgeController(){
        inputView = new InputController();
        outputView = new OutputView();
        bridgeGameService = new BridgeGameService();
        progress = bridgeGameService.initGameProgress();
        command = "R";
    }

   public void run() {
       int size = inputView.inputSize();
       List<String> bridge = bridgeGameService.initBridge(size);
       BridgeGame bridgeGame = new BridgeGame(bridge);
       repeatMoving(size,bridgeGame);
       repeatCommandAndMoving(size,bridgeGame);
       outputView.printResult(progress,command,bridgeGameService);
   }

   private void repeatCommandAndMoving(int size, BridgeGame bridgeGame){
       while(!checkX(progress)){
           command = inputView.readGameCommand();
           if (checkCommand(size, bridgeGame)) {
               break;
           }
       }
   }

    private boolean checkCommand(int size, BridgeGame bridgeGame) {
        if (bridgeGame.retry(command)){
            progress = bridgeGameService.initGameProgress();
            repeatMoving(size, bridgeGame);
        }
        if(!bridgeGame.retry(command)){
            return true;
        }
        return false;
    }

    private List<List<String>> repeatMoving(int size,BridgeGame bridgeGame){
       while (checkXAndSize(size, progress)) {
           String input = inputView.readMoving();
           outputView.printMap(bridgeGame, input, progress);
       }
       return progress;
   }

   private boolean checkXAndSize(int size, List<List<String>> progress){
       return checkX(progress) && progress.get(0).size()<size;
   }

    private boolean checkX(List<List<String>> gameProgress){
        boolean flag1 = gameProgress.get(0).stream().allMatch(str -> !str.contains("X"));
        boolean flag2 = gameProgress.get(1).stream().allMatch(str -> !str.contains("X"));
        return flag1 && flag2;
    }

}
