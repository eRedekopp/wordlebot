/*
 * Copyright (c) 2022 Eric Redekopp
 */
package wordlebot

trait MatchGetter {
    def getMatch(wordResult: MatchHistogram): WordMatch
}