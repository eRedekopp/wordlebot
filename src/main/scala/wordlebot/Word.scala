/*
 * Copyright (c) 2022 Eric Redekopp
 */
package wordlebot

import WordMatch.CharMatches.{CharMatch, GREEN, GREY, YELLOW}

case class Word(word: String) {
    def getMatch(guessWord: Word): WordMatch = {
        WordMatch(
            this,
            Range(0, word.length).map(i =>
                    if (this.word(i) == guessWord.word(i))
                        GREEN
                    else if (this.word.contains(guessWord.word(i)))
                        YELLOW
                    else
                        GREY
            ).toList
        )
    }
}
