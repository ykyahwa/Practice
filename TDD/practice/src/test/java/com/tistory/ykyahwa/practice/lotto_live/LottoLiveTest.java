package com.tistory.ykyahwa.practice.lotto_live;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class LottoLiveTest {
    /* 로또 한게임
      - 숫자 범위 체크 - 1~45
      - 랜덤 숫자
      - 정렬
      - 중복없이 정렬된 6개 숫자 리스트
     */
    /*
    2차
        맞춘 갯수 확인
        등수체크
     */

    private LottoMachineLive lottoMachine;
    @Before
    public void setUp() throws Exception {
        lottoMachine = new LottoMachineLive();
    }

    @Test
    public void 숫자범위체크_1부터_45() {

        assertEquals(lottoMachine.isLottoNumber(0), false);
        assertEquals(lottoMachine.isLottoNumber(1), true);
        assertEquals(lottoMachine.isLottoNumber(2), true);
        assertEquals(lottoMachine.isLottoNumber(30), true);
        assertEquals(lottoMachine.isLottoNumber(45), true);
        assertEquals(lottoMachine.isLottoNumber(46), false);
    }

    @Test
    public void 랜덤숫자_1부터_45() {

        Set<Integer> intSet = new HashSet<>();

        while (true) {
            int randomNumber = lottoMachine.getRandomNumber();

            intSet.add(randomNumber);
            assertTrue(lottoMachine.isLottoNumber(randomNumber));

            if (intSet.size() == 45) break;
        }

        assertTrue(intSet.size() == 45);
    }

    @Test
    public void 정렬() {

        Set<Integer> lottoGame = new HashSet<>();
        lottoGame.add(22);
        lottoGame.add(11);
        lottoGame.add(44);
        lottoGame.add(33);
        lottoGame.add(1);
        lottoGame.add(45);

        List<Integer> sortList = lottoMachine.sort(lottoGame);

        int preNumber = 0;
        for (int number: sortList) {
            if (preNumber > number) fail();
            preNumber = number;
        }
    }

    @Test
    public void 로또한게임_중복되지_않는_6개_숫자를_가져온다() {
        List<Integer> lottoGame = lottoMachine.getGame();

        assertEquals(6, lottoGame.size());
    }


}
