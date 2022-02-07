/*
 * Copyright (c) 2022 Eric Redekopp
 */
package wordlebot

case class KnownAnswerMatchGetter(answer: Word) extends MatchGetter {
    override def getMatch(wordResult: MatchHistogram): WordMatch = answer.getMatch(wordResult.guessWord)
}
