package bridge;

import bridge.controller.BridgeController;

public class Application {

    public static void main(String[] args) {
        BridgeController bc = new BridgeController();
        bc.run();
    }
}
