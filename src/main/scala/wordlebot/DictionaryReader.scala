/*
 * Copyright (c) 2022 Eric Redekopp
 */
package wordlebot

import scala.io.Source
import scala.util.Using

object DictionaryReader {
    private val PATH_TO_WORDS = "/usr/share/dict/cracklib-small"

    def readWords(): List[Word] = readSystemWords()

    private def readSystemWords(): List[Word] = {
        // 4502 words
        def isValidWord(word: String): Boolean = word.matches("^[A-Za-z]{5}$")
        Using(Source.fromFile(PATH_TO_WORDS)) {
            source => source.getLines().filter(isValidWord).map(s => Word(s.toUpperCase)).toList
        }.get
    }

    private def readOfficialWords(): List[Word] = {
        // 10657 words
        // TODO modify the algorithm to handle such a large list. Causes HeapSpaceException now
        Source
                .fromInputStream(getClass.getResourceAsStream("/official_words.txt"))
                .bufferedReader()
                .readLine()
                .split(",")
                .map(s => Word(s.replaceAll("\\s+", "")))
                .toList
    }
}