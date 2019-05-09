package com.tistory.ykyahwa.practice.lotto_live;

import java.util.*;

class LottoMachineLive {


    private int LOTTO_MIN_VALUE = 1;
    private int LOTTO_MAX_VALUE = 45;

    public boolean isLottoNumber(int number) {
        return number >= LOTTO_MIN_VALUE && number <= LOTTO_MAX_VALUE;
    }

    public int getRandomNumber() {
        return new Random().nextInt(LOTTO_MAX_VALUE) + LOTTO_MIN_VALUE;
    }


    public List<Integer> sort(Set<Integer> lottoGame) {
        List<Integer> list = new ArrayList<>(lottoGame);
        Collections.sort(list);
        return list;
    }

    public List<Integer> getGame() {
        Set<Integer> list = new HashSet<>();

        while (true) {
            list.add(getRandomNumber());
            if (list.size() == 6 ) break;
        }
        return sort(list);
    }

}
