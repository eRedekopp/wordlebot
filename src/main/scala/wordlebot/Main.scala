/*
 * Copyright (c) 2022 Eric Redekopp
 */
package wordlebot

object Main extends App {
    val words = DictionaryReader.readWords()
    println("Starting!")
    WordleBotTask.playWordle(words, CliMatchGetter, words)
}