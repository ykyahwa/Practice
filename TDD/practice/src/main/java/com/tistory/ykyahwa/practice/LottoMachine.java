package com.tistory.ykyahwa.practice;

import java.util.Arrays;

class LottoMachine {


    public int[] getLottoAGame() {

        final int LOTTO_PICK_NUMBER_COUNT = 6;

        int[] numbers = new int[LOTTO_PICK_NUMBER_COUNT];
        int index = 0;
        while (index < LOTTO_PICK_NUMBER_COUNT) {
            int number = getRandomLottoNumber();
            if (!hasDuplication(numbers, number)) {
                numbers[index] = number;
                index++;
            }
        }
        return numbers;
    }

    public int getRandomLottoNumber() {
        return (int) (Math.random() * 45 + 1);
    }


    public boolean hasDuplication(int[] numbers, int addNumber) {
        for (int num: numbers) {
            if (num == addNumber) return true;
        }
        return false;
    }

    public int[] sort(int[] numbers) {
        Arrays.sort(numbers);
        return numbers;
    }
}
