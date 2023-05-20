package org.withered.tyr.chords.parsers;// Generated from D:/Code2/TYRH/Device_Info/src/main\ChordGrammar.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ChordGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ChordGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ChordGrammarParser#progression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgression(ChordGrammarParser.ProgressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ChordGrammarParser#chord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChord(ChordGrammarParser.ChordContext ctx);
	/**
	 * Visit a parse tree produced by {@link ChordGrammarParser#main_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain_part(ChordGrammarParser.Main_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link ChordGrammarParser#additions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditions(ChordGrammarParser.AdditionsContext ctx);
}