package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    @DisplayName("")
    void z() throws Exception{
        //given
        List<String> bridge = new ArrayList<>(List.of("U","D","U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        List<List<String>> gameProgress = new ArrayList<>();
        gameProgress.add(new ArrayList<>());
        gameProgress.add(new ArrayList<>());
        String input1 = "U";
        String input2 = "U";
        bridgeGame.move(input1,gameProgress);
        bridgeGame.move(input2,gameProgress);
        //when
        List<List<String>> expect = new ArrayList<>();
        expect.add(List.of(" O "," X "));
        expect.add(List.of("   ","   "));
        //then
        assertEquals(expect,gameProgress);
    }

}