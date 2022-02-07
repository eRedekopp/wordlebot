/*
 * Copyright (c) 2022 Eric Redekopp
 */
package wordlebot

import wordlebot.WordMatch.CharMatches.{CharMatch, GREEN}

object WordMatch {
    object CharMatches extends Enumeration {
        type CharMatch = Value
        val GREY: CharMatches.Value = Value("_")
        val YELLOW: CharMatches.Value = Value("o")
        val GREEN: CharMatches.Value = Value("X")
    }
}

case class WordMatch(word: Word, matches: List[CharMatch]) {
    def matchHash(): Int = {
        matches.map(m => m.toString).toString().hashCode
    }

    override def toString: String = {
        matches.toArray.mkString("Match(", "", ")")
    }

    def isPerfectMatch: Boolean = !matches.exists(m => m != GREEN)
}
