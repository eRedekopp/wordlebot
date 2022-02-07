/*
 * Copyright (c) 2022 Eric Redekopp
 */
package wordlebot

import scala.annotation.tailrec

object WordleBotTask {

    private val SOLUTION_SPACE_THRESHOLD = 8

    @tailrec
    def playWordle(allWords: List[Word], matchGetter: MatchGetter, solutionSpace: List[Word]): Unit = {
        def getBestGuess = {
            if (solutionSpace.size <= SOLUTION_SPACE_THRESHOLD) {
                solutionSpace
                        .map(w => MatchHistogram(w, solutionSpace))
                        .reduce((a, b) => if (a.entropy > b.entropy) a else b)
            }
            else {
                allWords
                        .map(w => MatchHistogram(w, solutionSpace))
                        .reduce((a, b) => if (a.entropy > b.entropy) a else b)
            }
        }

        val bestGuess = getBestGuess
        val guessMatch = matchGetter.getMatch(bestGuess)
        if (!guessMatch.isPerfectMatch) {
            println("No match! " + guessMatch)
            playWordle(
                allWords,
                matchGetter,
                bestGuess.matches(guessMatch.matchHash())
                        .filter(m => m.word != bestGuess.guessWord)
                        .map(m => m.word)
            )
        }
        else {
            println("Matched! " + guessMatch)
        }
    }
}
