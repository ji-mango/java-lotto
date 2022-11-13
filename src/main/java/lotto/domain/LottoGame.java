package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private List<Lotto> lotteries = new ArrayList<>();
    private int lottoCount;
    private List<Integer> lottoResults = Arrays.asList(0, 0, 0, 0, 0, 0, 0);
    private int bonusResult = 0;

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int countLotto(int cost) {
        lottoCount = cost / 1000;

        return lottoCount;
    }

    public List<Lotto> createRandomLotto() {
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotteries.add(new Lotto(lottoNumber));
        }

        return lotteries;
    }

    public void compareEachLotto(WinningLotto winningLotto) {
        for (Lotto lottery:lotteries) {
            int result = winningLotto.compareLotto(lottery);

            setLottoResults(result);
            setBonusResult(winningLotto, lottery, result);
        }

        System.out.println(lottoResults);
        System.out.println(bonusResult);
    }

    private void setLottoResults(int result) {
        int count = lottoResults.get(result);

        count++;
        lottoResults.set(result, count);
    }

    private void setBonusResult(WinningLotto winningLotto, Lotto lotto, int result) {
        if (winningLotto.isBonusInLotto(lotto) && result == 5) {
            bonusResult++;
        }
    }
}
