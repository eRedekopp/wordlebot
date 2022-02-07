/*
 * Copyright (c) 2022 Eric Redekopp
 */
package wordlebot

case class MatchHistogram(guessWord: Word, solutionSpace: List[Word]) {
    private val totalWords: Int = solutionSpace.size

    val matches: Map[Int, List[WordMatch]] =
        solutionSpace
            .map(queryWord => queryWord.getMatch(guessWord))
            .foldLeft(Map[Int, List[WordMatch]]()) {
                (map, wordMatch) => {
                    map.updated(
                        wordMatch.matchHash(), map.getOrElse(wordMatch.matchHash(), List()).appended(wordMatch)
                    )
                }
            }

    val entropy: Double =
        matches.map(kv => {
            val px = kv._2.size.toDouble / totalWords
            px * Math.log(1.0 / px)
        }).sum

}
