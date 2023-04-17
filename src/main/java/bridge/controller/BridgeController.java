package bridge.controller;

import bridge.BridgeGame;
import bridge.service.BridgeGameService;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

    InputController inputView = new InputController();
    OutputView outputView = new OutputView();
    BridgeGameService bridgeGameService = new BridgeGameService();
    List<List<String>> progress = bridgeGameService.initGameProgress();
    String str="R";

   public void run() {
       int size = inputView.inputSize();
       List<String> bridge = bridgeGameService.initBridge(size);
       BridgeGame bridgeGame = new BridgeGame(bridge);
       repeatMoving(size,bridgeGame);
       while(!checkX(progress)){
           str = inputView.readGameCommand();
           if(str.equals("R")){
               progress = bridgeGameService.initGameProgress();
               repeatMoving(size,bridgeGame);
           }
           if(str.equals("Q")){
               break;
           }
       }
        outputView.printResult(progress,str,bridgeGameService);
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

    //x가 하나도 없을시에만 true
    private boolean checkX(List<List<String>> gameProgress){
        boolean flag1 = gameProgress.get(0).stream().allMatch(str -> !str.contains("X"));
        boolean flag2 = gameProgress.get(1).stream().allMatch(str -> !str.contains("X"));
        return flag1 && flag2;
    }

}
