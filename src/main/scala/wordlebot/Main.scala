/*
 * Copyright (c) 2022 Eric Redekopp
 */
package wordlebot

object Main extends App {
    val words: List[Word] = DictionaryReader.readWords()
    printf("Starting! %d words in solution space%n", words.length)
    WordleBotTask.playWordle(words, CliMatchGetter, words)
}