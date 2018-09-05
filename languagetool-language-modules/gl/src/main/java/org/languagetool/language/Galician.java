/* LanguageTool, a natural language style checker 
 * Copyright (C) 2007 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.language;

import org.languagetool.Language;
import org.languagetool.LanguageMaintainedState;
import org.languagetool.rules.*;
import org.languagetool.rules.gl.*;
import org.languagetool.synthesis.Synthesizer;
import org.languagetool.synthesis.gl.GalicianSynthesizer;
import org.languagetool.rules.spelling.hunspell.HunspellRule;
import org.languagetool.tagging.Tagger;
import org.languagetool.tagging.disambiguation.Disambiguator;
import org.languagetool.tagging.disambiguation.gl.GalicianHybridDisambiguator;
import org.languagetool.tagging.gl.GalicianTagger;
import org.languagetool.tokenizers.SRXSentenceTokenizer;
import org.languagetool.tokenizers.SentenceTokenizer;
import org.languagetool.tokenizers.Tokenizer;
import org.languagetool.tokenizers.gl.GalicianWordTokenizer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Galician extends Language {

  private Tagger tagger;
  private Tokenizer wordTokenizer;
  private SentenceTokenizer sentenceTokenizer;
  private Synthesizer synthesizer;
  private Disambiguator disambiguator;

  @Override
  public SentenceTokenizer getSentenceTokenizer() {
    if (sentenceTokenizer == null) {
      sentenceTokenizer = new SRXSentenceTokenizer(this);
    }
    return sentenceTokenizer;
  }
  
  @Override
  public String getName() {
    return "Galician";
  }

  @Override
  public String getShortCode() {
    return "gl";
  }

  @Override
  public String[] getCountries() {
    return new String[]{"ES"};
  }
  
  @Override
  public Tagger getTagger() {
    if (tagger == null) {
      tagger = new GalicianTagger();
    }
    return tagger;
  }

  @Override
  public Tokenizer getWordTokenizer() {
    if (wordTokenizer == null) {
      wordTokenizer = new GalicianWordTokenizer();
    }
    return wordTokenizer;
  }

  @Override
  public Synthesizer getSynthesizer() {
    if (synthesizer == null) {
      synthesizer = new GalicianSynthesizer();
    }
    return synthesizer;
  }
  
  @Override
  public Disambiguator getDisambiguator() {
    if (disambiguator == null) {
      disambiguator = new GalicianHybridDisambiguator();
    }
    return disambiguator;
  }

  @Override
  public LanguageMaintainedState getMaintainedState() {
    return LanguageMaintainedState.ActivelyMaintained;
  }

  @Override
  public Contributor[] getMaintainers() {
    return new Contributor[] {
            new Contributor("Susana Sotelo Docío"),
            new Contributor("Tiago F. Santos (4.0)", "https://github.com/TiagoSantos81")
    };
  }

  @Override
  public List<Rule> getRelevantRules(ResourceBundle messages) throws IOException {
    return Arrays.asList(
            new CommaWhitespaceRule(messages,
                Example.wrong("Tomamos café<marker> ,</marker> queixo, bolachas e uvas."),
                Example.fixed("Tomamos café<marker>,</marker> queixo, bolachas e uvas.")),
            new DoublePunctuationRule(messages),
            new GenericUnpairedBracketsRule(messages,
                    Arrays.asList("[", "(", "{", "“", "«", "»", "‘", "\"", "'"),
                    Arrays.asList("]", ")", "}", "”", "»", "«", "’", "\"", "'")),
            new HunspellRule(messages, this),
            new UppercaseSentenceStartRule(messages, this,
                Example.wrong("Esta casa é vella. <marker>foi</marker> construida en 1950."),
                Example.fixed("Esta casa é vella. <marker>Foi</marker> construida en 1950.")),
            new MultipleWhitespaceRule(messages, this),
            new LongSentenceRule(messages, true),
            new SentenceWhitespaceRule(messages),
            new WhiteSpaceBeforeParagraphEnd(messages),
            new WhiteSpaceAtBeginOfParagraph(messages),
            new EmptyLineRule(messages),
            new ParagraphRepeatBeginningRule(messages),
            new PunctuationMarkAtParagraphEnd(messages),
            // Specific to Galician:
            new SimpleReplaceRule(messages),
            new CastWordsRule(messages),
            new GalicianRedundancyRule(messages),
            new GalicianWordinessRule(messages),
            new GalicianBarbarismsRule(messages),
            new GalicianWikipediaRule(messages)
    );
  }

  @Override
  public int getPriorityForId(String id) {
    switch (id) {
      // case "FRAGMENT_TWO_ARTICLES":     return 50;
      case "DEGREE_MINUTES_SECONDS":    return 30;
      // case "INTERJECTIONS_PUNTUATION":  return 20;
      // case "CONFUSION_POR":             return 10;
      // case "HOMOPHONE_AS_CARD":         return  5;
      // case "TODOS_FOLLOWED_BY_NOUN_PLURAL":    return  3;
      // case "TODOS_FOLLOWED_BY_NOUN_SINGULAR":  return  2;
      case "UNPAIRED_BRACKETS":         return -5;
      // case "PROFANITY":                 return -6;
      case "GL_BARBARISM_REPLACE":      return -10;
      case "GL_SIMPLE_REPLACE":         return -11;
      case "GL_REDUNDANCY_REPLACE":     return -12;
      case "GL_WORDINESS_REPLACE":      return -13;
      // case "GL_CLICHE_REPLACE":         return -17;
      // case "CHILDISH_LANGUAGE":         return -25;
      // case "ARCHAISMS":                 return -26;
      // case "INFORMALITIES":             return -27;
      // case "PUFFERY":                   return -30;
      // case "BIASED_OPINION_WORDS":      return -31;
      // case "WEAK_WORDS":                return -32;
      // case "PT_AGREEMENT_REPLACE":      return -35;
      case "GL_WIKIPEDIA_COMMON_ERRORS":return -45;
      case "HUNSPELL_RULE":             return -50;
      // case "NO_VERB":                   return -52;
      // case "CRASE_CONFUSION":           return -55;
      // case "FINAL_STOPS":               return -75;
      // case "T-V_DISTINCTION":           return -100;
      // case "T-V_DISTINCTION_ALL":       return -101;
      case "REPEATED_WORDS":            return -210;
      case "REPEATED_WORDS_3X":         return -211;
      case "TOO_LONG_SENTENCE_20":      return -997;
      case "TOO_LONG_SENTENCE_25":      return -998;
      case "TOO_LONG_SENTENCE_30":      return -999;
      case "TOO_LONG_SENTENCE_35":      return -1000;
      case "TOO_LONG_SENTENCE_40":      return -1001;
      case "TOO_LONG_SENTENCE_45":      return -1002;
      case "TOO_LONG_SENTENCE_50":      return -1003;
      case "TOO_LONG_SENTENCE_60":      return -1004;
      // case "CACOPHONY":                 return -2000;
    }
    return 0;
  }
}