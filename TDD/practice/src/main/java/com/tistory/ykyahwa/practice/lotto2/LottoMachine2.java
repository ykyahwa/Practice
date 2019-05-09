package com.tistory.ykyahwa.practice.lotto2;

import java.util.*;

class LottoMachine2 {
    public int getLottoNumber() {

        int i;
        while (true) {
//            i = (int) (Math.random() * 44 + 1);
            i = (int) (Math.random() * 100);


            if (isLottoNumber(i)) {
                System.out.println(i);
                return i;
            } else {
                System.out.println("else = " + i);

            }
        }
    }

    public boolean isLottoNumber(int number) {
        return number >= 1 && number <= 45;
    }

    public List<Integer> getLottoOneGame() {
        final HashSet<Integer> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(getLottoNumber());
        }
        return sort(lottoNumbers);
    }

    public List<Integer> sort(Set<Integer> numberSet) {
        List<Integer> sortedNumbers = new ArrayList<>(numberSet);

        Collections.sort(sortedNumbers);

        return sortedNumbers;
    }
}
