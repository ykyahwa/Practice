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

    public int checkCount(Set<Integer> myLotto, Set<Integer> result) {
        int checkCount = 0;
        for (int myNumber: myLotto) {
            if (result.contains(myNumber)) checkCount++;
        }

        return checkCount;
    }

    public int getGrade(int checkCount) {

        switch (checkCount) {
            case 6 : return 1;
            case 5 : return 2;
            case 4 : return 3;
            case 3 : return 4;
            case 2 : return 5;
            case 1 : return 6;
            case 0 : return 7;
            default: throw new IllegalArgumentException("0~6 사이 입력하세요");
        }
    }
}
