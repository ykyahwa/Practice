package com.tistory.ykyahwa.practice.lotto_live;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

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

        Set<Integer> lottoGame = makeDummyLotto(22,11,44,33,1,45);

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


    @Test
    public void 맞춘_갯수_확인() {

        Set<Integer> result = makeDummyLotto(1,2,3,4,5,6);

        assertEquals(6, lottoMachine.checkCount(makeDummyLotto(1,2,3,4,5,6), result));
        assertEquals(5, lottoMachine.checkCount(makeDummyLotto(1,2,3,4,5,7), result));
        assertEquals(4, lottoMachine.checkCount(makeDummyLotto(1,2,3,4,8,7), result));
        assertEquals(3, lottoMachine.checkCount(makeDummyLotto(1,2,3,10,8,7), result));
        assertEquals(2, lottoMachine.checkCount(makeDummyLotto(1,2,33,10,8,7), result));
        assertEquals(1, lottoMachine.checkCount(makeDummyLotto(1,45,33,10,8,7), result));
        assertEquals(0, lottoMachine.checkCount(makeDummyLotto(11,45,33,10,8,7), result));
    }

    @Test
    public void 등수확인() {

        assertEquals(1, lottoMachine.getGrade(6));
        assertEquals(2, lottoMachine.getGrade(5));
        assertEquals(3, lottoMachine.getGrade(4));
        assertEquals(4, lottoMachine.getGrade(3));
        assertEquals(5, lottoMachine.getGrade(2));
        assertEquals(6, lottoMachine.getGrade(1));
        assertEquals(7, lottoMachine.getGrade(0));
    }

    private Set<Integer> makeDummyLotto(int... numbers) {
        Set<Integer> result = new HashSet<>();
        for (int number: numbers) {
            result.add(number);
        }
        return result;
    }
}
