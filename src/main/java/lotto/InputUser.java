package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputUser {
    private String inputMoney;
    private Integer lottoMoney;
    private List<Integer> WinningNumbers;
    public Integer inputLottoMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        inputMoney = camp.nextstep.edu.missionutils.Console.readLine();
        validateInputMoneyIsInteger(inputMoney);
        lottoMoney = Integer.parseInt(inputMoney);
        validateMoneyIsMultipleOfThousand(lottoMoney);
        return Integer.parseInt(inputMoney);
    }
    public List<Integer> inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputRawWinningNumber = camp.nextstep.edu.missionutils.Console.readLine();
        List<String> splitRawWinningNumbers = Arrays.asList(inputRawWinningNumber.split(","));
        validateSplitInputRawWinningNumberByOverSize(splitRawWinningNumbers);
        validateInputWinningNumberIsInteger(splitRawWinningNumbers);
        return convertStringToInteger(splitRawWinningNumbers);
    }

    private List<Integer> convertStringToInteger(List<String> splitRawWinningNumbers) {
        WinningNumbers = new ArrayList<>();
        for (String WinningNumber : splitRawWinningNumbers) {
            WinningNumbers.add(Integer.parseInt(WinningNumber));
        }
        return WinningNumbers;
    }

    private void validateInputMoneyIsInteger(String inputMoney){
        try {
            Integer.parseInt(inputMoney);
        }catch (NumberFormatException e){
            throw new NumberFormatException("[ERROR] 구입 금액은 숫자를 입력해야 합니다.");
        }
    }
    private void validateMoneyIsMultipleOfThousand(Integer lottoMoney){
        if (lottoMoney % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private void validateSplitInputRawWinningNumberByOverSize(List<String> splitRawWinningNumber){
        if (splitRawWinningNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해야 합니다.");
        }
    }
    private void validateInputWinningNumberIsInteger(List<String> splitRawWinningNumbers){
        try {
            for (String WinningNumber : splitRawWinningNumbers) {
                Integer.parseInt(WinningNumber);
            }
        }catch (NumberFormatException e){
            throw new NumberFormatException("[ERROR] 당첨 번호는 숫자를 입력해야 합니다.");
        }
    }
}
