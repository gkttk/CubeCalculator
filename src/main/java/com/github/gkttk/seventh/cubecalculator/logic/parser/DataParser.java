package com.github.gkttk.seventh.cubecalculator.logic.parser;


import com.github.gkttk.seventh.cubecalculator.logic.exception.DataParserException;

/**
 * Common interface for parsers.
 * @param <T> return value
 * @param <E> given value
 */
public interface DataParser<T,E> {

    T parse(E data) throws DataParserException;
}
