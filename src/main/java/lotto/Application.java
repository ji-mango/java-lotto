package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.User;
import lotto.domain.WinningLotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        User user = new User();

        System.out.println("구입금액을 입력해 주세요.");
        try {
            user.receiveCostInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        int lottoCost = user.getLottoCost();

        LottoGame lottoGame = new LottoGame();
        int lottoNumber = lottoGame.countLotto(lottoCost);
        System.out.println("\n"+lottoNumber+"개를 구매했습니다.");

        lottoGame.createRandomLotto();
        List<Lotto> lotteries = lottoGame.getLotteries();
        for (Lotto lotto:lotteries) {
            System.out.println(lotto.toString());
        }

        WinningLotto winningLotto = new WinningLotto();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        try {
            winningLotto.receiveWinningNumber();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");
        try {
            winningLotto.receiveBonusNumber();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n당첨 통계\n" +
                "---");
        lottoGame.compareEachLotto(winningLotto);
        lottoGame.setRateOfReturn();
        System.out.println(lottoGame.rankCountResult());
        System.out.println(lottoGame.profitRateResult());
    }
}
