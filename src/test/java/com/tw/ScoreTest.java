package com.tw;

import org.junit.Test;

//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.junit.Assert.assertThat;

import static org.fest.assertions.api.Assertions.assertThat;

public class ScoreTest {
    @Test
    public void should_return_scores_for_different_subjects() throws Exception{
        Score score = new Score(75, 95, 80, 80);
        assertThat(score.getMathScore()).isEqualTo(75);
        assertThat(score.getChineseScore()).isEqualTo(95);
        assertThat(score.getEnglishScore()).isEqualTo(80);
        assertThat(score.getProgramScore()).isEqualTo(80);
//        assertThat( score.getMathScore(), equalTo(75) );
//        assertThat( score.getChineseScore(), equalTo(95) );
//        assertThat( score.getEnglishScore(), equalTo(80) );
//        assertThat( score.getProgramScore(), equalTo(80) );
    }
//
    @Test
    public void should_return_average_score_and_total_score() {
        Score score = new Score(75, 95, 80, 80);
        assertThat( score.getTotalScore()).isEqualTo(330);
        assertThat( score.getAverageScore()).isEqualTo(82.5);
    }
}
