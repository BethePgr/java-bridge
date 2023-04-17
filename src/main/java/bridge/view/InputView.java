package bridge.view;


import camp.nextstep.edu.missionutils.Console;
import java.sql.SQLOutput;

public class InputView {

    private static String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static String INPUT_ERROR_MESSAGE = "[ERROR] 3과 20사이의 숫자를 입력해주세요.";
    private static String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static String MOVE_ERROR = "[ERROR] U 혹은 D만 입력 가능합니다.";
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
        String input = Console.readLine();
        checkBridgeSize(input);
        System.out.println();
        return Integer.parseInt(input);
    }

    private void checkBridgeSize(String input){
        if(validateNumber(input)){
            if(between3And20(input)){
                return;
            }
        }
        throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
    }

    private boolean between3And20(String input){
        boolean flag = false;
        int num = Integer.parseInt(input);
        if(num>=3 && num<=20){
            flag = true;
        }
        return flag;
    }

    private boolean validateNumber(String input){
        for(char x : input.toCharArray()){
            if(!Character.isDigit(x)){
                return false;
            }
        }
        return true;
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_MESSAGE);
        String input = Console.readLine();
        validateInputMove(input);
        return input;
    }

    private void validateInputMove(String input) {
        if(input.equals("U") || input.equals("D")){
            return;
        }
        throw new IllegalArgumentException(MOVE_ERROR);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
