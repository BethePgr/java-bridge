package bridge.service;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameService {
    private final BridgeMaker bridgeMaker;

    public BridgeGameService(){
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public List<String> initBridge(int size){
        return bridgeMaker.makeBridge(size);
    }
    public List<List<String>> initGameProgress(){
        List<List<String>> gameProgress = new ArrayList<>();
        gameProgress.add(new ArrayList<>());
        gameProgress.add(new ArrayList<>());
        return gameProgress;
    }

    public List<List<String>> moveService(String input, List<List<String>> gameProgress,BridgeGame bridgeGame){
        bridgeGame.move(input,gameProgress);
        return gameProgress;
    }
}
