package com.tistory.ykyahwa.practice.lotto1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class LottoTest {

    @Test
    public void 범위_1_45_번호_가져오기() {
        LottoMachine lottoMachine = new LottoMachine();

        for (int i = 0; i < 100; i++) {
            int number = lottoMachine.getRandomLottoNumber();
//            System.out.println(number);
            assertThat(isLottoNumber(number), is(true));
        }
    }

    @Test
    public void 중복체크() {
        LottoMachine lottoMachine = new LottoMachine();

        int[] numbers = new int[]{2,3,55,4,5,6};
        int addNumber = 1;

        assertThat(lottoMachine.hasDuplication(numbers, addNumber), is(false));
    }

    @Test
    public void 정렬() {
        int[] numbers = new int[]{2,44,33,4,1,6};

        LottoMachine lottoMachine = new LottoMachine();
        int[] sortNumbers = lottoMachine.sort(numbers);

        int preNumber = 0;
        for (int number: sortNumbers) {

            System.out.println(number);

            if (number < preNumber) fail("정렬실패");

            preNumber = number;
        }
    }

    @Test
    public void 로또_1게임_번호_가져오기() {
        LottoMachine lottoMachine = new LottoMachine();

        int[] lottoAGame = lottoMachine.getLottoAGame();

        assertThat(lottoAGame.length, is(6));

        for (int i1 : lottoAGame) {
            System.out.println(i1);
            assertThat(isLottoNumber(i1), is(true));
        }
    }

    @Test
    public void 맞춘갯수확인() {
        int[] result = new int[]{44,33,22,11,7,34};
        int[] myLotto = new int[]{33,2,3,44,5,8};

        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine.getLottoCheckCount(result, myLotto), is(2));
    }

    @Test
    public void 등수확인() {

        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine.getGrade(6), is(1));
        assertThat(lottoMachine.getGrade(5), is(2));
        assertThat(lottoMachine.getGrade(4), is(3));
        assertThat(lottoMachine.getGrade(3), is(4));
        assertThat(lottoMachine.getGrade(2), is(0));
    }

    private boolean isLottoNumber(int number) {
        return number >= 1 && number <= 45;
    }

}
