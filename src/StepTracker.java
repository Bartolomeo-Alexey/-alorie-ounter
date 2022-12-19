public class StepTracker {

    int dailyStepsGoal = 10000;//цель шагов на день
    int[][] stepsYear = new int[12][30];

    StepTracker() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 29; j++) {
                stepsYear[i][j] = 0;
            }
        }

        //добавил тестовых данных за Март
//        stepsYear[2][0] = 1000;
//        stepsYear[2][1] = 2000;
//        stepsYear[2][2] = 3000;
//        stepsYear[2][3] = 4000;
//        stepsYear[2][4] = 12000;
//        stepsYear[2][5] = 13000;
//        stepsYear[2][6] = 4000;
//        stepsYear[2][7] = 5000;
//        stepsYear[2][8] = 13000;
//        stepsYear[2][9] = 14000;
//        stepsYear[2][10] = 15000;
//        stepsYear[2][11] = 16000;
//        stepsYear[2][12] = 2000;
    }


    public void stepsInput(int monthEdit, int dayEdit, int stepsAmount) {
        stepsYear[monthEdit - 1][dayEdit - 1] = stepsAmount;
        System.out.println("New value successfully saved.");
        System.out.println("For " + dayEdit + "th day of the " + monthEdit + "d month you did " + stepsAmount + " steps");
    }


    public void changeDailyGoal(int newGoal) {
        dailyStepsGoal = newGoal;
        System.out.println("Your new goal is equal to " + dailyStepsGoal + " steps in a day");
    }


    public void printStats(int statMonth) {
        System.out.println("Your statistic:");
        printSteps(statMonth);
        System.out.println("Total amount = " + monthTotalAmt(statMonth) + " steps");
        System.out.println("Maximum amount for a day = " + monthMaxAmt(statMonth) + " steps");
        System.out.println("Average amount = " + monthAverageAmt(statMonth) + " steps");
        System.out.println("Distance = " + monthDistance(statMonth) + " km");
        System.out.println("Burned " + burnedCalories(statMonth) + " kilocalories");
        System.out.println("Best streak = " + bestStreak(statMonth) + " days");
    }


    public void printSteps(int statMonth) {
        //печатает шаги за месяц так:   1 день: 3000, 2 день: 2000, ..., 30 день: 10000
        for (int i = 0; i < 29; i++) {
            System.out.print((i + 1) + " день: " + stepsYear[statMonth][i] + ", ");
        }
        System.out.println();
    }


    public int monthTotalAmt(int statMonth) {
        int monthTotalAmt = 0;
        for (int i = 0; i < 29; i++) {
            monthTotalAmt += stepsYear[statMonth][i];
        }
        return monthTotalAmt;
    }


    public int monthMaxAmt(int statMonth) {
        int monthMaxAmt = 0;
        for (int i = 0; i < 29; i++) {
            if (monthMaxAmt < stepsYear[statMonth][i]) {
                monthMaxAmt = stepsYear[statMonth][i];
            }
        }
        return monthMaxAmt;
    }


    public double monthAverageAmt(int statMonth) {
        return monthTotalAmt(statMonth) / 30.0;
    }


    public double monthDistance(int statMonth) {
        //Пройденное расстояние за месяц в киллометрах. Один шаг равен 0.75 м
        return monthTotalAmt(statMonth) * 0.75 / 1000;
    }


    public double burnedCalories(int statMonth) {
        //количество сожженных калорий. 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий
        return monthTotalAmt(statMonth) * 50.0 / 1000;
    }

    public int bestStreak(int statMonth) {
        //Лучшая серия: максимальное количество подряд идущх дней,
        // в течение которых количество шагов за день было равно или выше целевого
        int bestStreak = 0;
        int tempStreak = 0;

        for (int i = 0; i < 29; i++) {

            if (stepsYear[statMonth][i] >= dailyStepsGoal) {
                tempStreak = tempStreak + 1;
            } else
                tempStreak = 0;
            if (tempStreak > bestStreak)
                bestStreak = tempStreak;
        }
        return bestStreak;
    }

}
