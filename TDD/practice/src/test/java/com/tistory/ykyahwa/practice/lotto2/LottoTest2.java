package com.tistory.ykyahwa.practice.lotto2;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class LottoTest2 {
    /* 로또 번호 생성
      - 숫자 범위 확인
      - 1~45 랜덤 숫자
      - 6개 숫자
      - 정렬
     */

    @Test
    public void 숫자범위확인() {
        LottoMachine2 lottoMachine2 = new LottoMachine2();

        assertEquals(false, lottoMachine2.isLottoNumber(-1));
        assertEquals(true, lottoMachine2.isLottoNumber(1));
        assertEquals(false, lottoMachine2.isLottoNumber(0));
        assertEquals(true, lottoMachine2.isLottoNumber(30));
        assertEquals(true, lottoMachine2.isLottoNumber(45));
        assertEquals(false, lottoMachine2.isLottoNumber(46));
        assertEquals(false, lottoMachine2.isLottoNumber(100));
    }

    @Test
    public void 램덤숫자_1_45() {
        LottoMachine2 lottoMachine2 = new LottoMachine2();

        for (int i = 0; i < 1000; i++) {
            int lottoNumber = lottoMachine2.getLottoNumber();
//            System.out.println("lottoNumber = " + lottoNumber);
            assertTrue(lottoMachine2.isLottoNumber(lottoNumber));
        }
    }

    @Test
    public void 번호정렬() {
        LottoMachine2 lottoMachine2 = new LottoMachine2();


        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(40);
        numberSet.add(10);
        numberSet.add(33);
        numberSet.add(22);
        numberSet.add(66);

        List<Integer> numberList= lottoMachine2.sort(numberSet);

        int preNumber = 0;

        for (int number: numberList) {
            if (preNumber > number) fail("정렬실패");
            preNumber = number;
        }
    }

    @Test
    public void 로또한게임생성() {
        LottoMachine2 lottoMachine2 = new LottoMachine2();

        List<Integer> lottoOneGame = lottoMachine2.getLottoOneGame();
        System.out.println(lottoOneGame);

        assertEquals(6, lottoOneGame.size());

        int preNumber = 0;
        for (int number: lottoOneGame) {
            if (preNumber > number) fail("정렬실패");
            preNumber = number;
        }

    }
}
