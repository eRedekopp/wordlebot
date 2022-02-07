/*
 * Copyright (c) 2022 Eric Redekopp
 */
package wordlebot

import scala.io.StdIn.readLine
import WordMatch.CharMatches.{CharMatch, GREEN, GREY, YELLOW}

object CliMatchGetter extends MatchGetter {

    override def getMatch(wordResult: MatchHistogram): WordMatch = {
        def inputInvalid(input: String): Boolean = {
            !input.matches("^[Xo_]{5}$")
        }
        var input = ""
        while (inputInvalid(input)) {
            println("############")
            printf(
                "The best guess is %s with entropy %.8f. Solution space is %d %s%n",
                wordResult.guessWord, wordResult.entropy, wordResult.solutionSpace.size, wordResult.solutionSpace
            )
            println("Please enter the result as Xo_: ")
            input = readLine()
            println()
        }
        WordMatch(wordResult.guessWord, input.map(c => if (c == '_') GREY else if (c == 'o') YELLOW else GREEN).toList)
    }
}
