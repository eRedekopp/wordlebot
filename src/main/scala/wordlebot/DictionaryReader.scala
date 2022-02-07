/*
 * Copyright (c) 2022 Eric Redekopp
 */
package wordlebot

import scala.io.Source
import scala.util.Using

object DictionaryReader {
    private val PATH_TO_WORDS = "/usr/share/dict/cracklib-small"

    def readWords(): List[Word] = {
        def isValidWord(word: String): Boolean = word.matches("[A-Za-z]{5}")
        Using(Source.fromFile(PATH_TO_WORDS)) {
            source => source.getLines().filter(isValidWord).map(s => new Word(s)).toList
        }.get
    }
}
