package com.tistory.ykyahwa.practice;

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

    private boolean isLottoNumber(int number) {
        return number >= 1 && number <= 45;
    }

}
