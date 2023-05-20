package org.withered.tyr.chords.parsers;// Generated from D:/Code2/TYRH/Device_Info/src/main\ChordGrammar.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ChordGrammarParser}.
 */
public interface ChordGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ChordGrammarParser#progression}.
	 * @param ctx the parse tree
	 */
	void enterProgression(ChordGrammarParser.ProgressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChordGrammarParser#progression}.
	 * @param ctx the parse tree
	 */
	void exitProgression(ChordGrammarParser.ProgressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ChordGrammarParser#chord}.
	 * @param ctx the parse tree
	 */
	void enterChord(ChordGrammarParser.ChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChordGrammarParser#chord}.
	 * @param ctx the parse tree
	 */
	void exitChord(ChordGrammarParser.ChordContext ctx);
	/**
	 * Enter a parse tree produced by {@link ChordGrammarParser#main_part}.
	 * @param ctx the parse tree
	 */
	void enterMain_part(ChordGrammarParser.Main_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChordGrammarParser#main_part}.
	 * @param ctx the parse tree
	 */
	void exitMain_part(ChordGrammarParser.Main_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link ChordGrammarParser#additions}.
	 * @param ctx the parse tree
	 */
	void enterAdditions(ChordGrammarParser.AdditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ChordGrammarParser#additions}.
	 * @param ctx the parse tree
	 */
	void exitAdditions(ChordGrammarParser.AdditionsContext ctx);
}