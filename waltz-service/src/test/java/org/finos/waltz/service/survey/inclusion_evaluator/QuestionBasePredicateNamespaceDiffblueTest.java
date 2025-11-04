package org.finos.waltz.service.survey.inclusion_evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlException;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.JexlInfo;
import org.apache.commons.jexl3.internal.Engine;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionFieldType;
import org.finos.waltz.model.survey.SurveyQuestionResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {QuestionBasePredicateNamespace.class})
@ExtendWith(SpringExtension.class)
class QuestionBasePredicateNamespaceDiffblueTest {
  @Autowired
  private QuestionBasePredicateNamespace questionBasePredicateNamespace;

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#isChecked(String)}
   */
  @Test
  void testIsChecked() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);

    // Act
    boolean actualIsCheckedResult = (new QuestionBasePredicateNamespace(questions, new HashMap<>())).isChecked("42");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    assertFalse(actualIsCheckedResult);
  }

  /**
   * Method under test:
   * {@link QuestionBasePredicateNamespace#isChecked(String, boolean)}
   */
  @Test
  void testIsChecked2() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);

    // Act
    boolean actualIsCheckedResult = (new QuestionBasePredicateNamespace(questions, new HashMap<>())).isChecked("42",
        true);

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    assertTrue(actualIsCheckedResult);
  }

  /**
   * Method under test:
   * {@link QuestionBasePredicateNamespace#isChecked(String, boolean)}
   */
  @Test
  void testIsChecked3() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);

    // Act
    boolean actualIsCheckedResult = (new QuestionBasePredicateNamespace(questions, new HashMap<>())).isChecked("42",
        false);

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    assertFalse(actualIsCheckedResult);
  }

  /**
   * Method under test:
   * {@link QuestionBasePredicateNamespace#QuestionBasePredicateNamespace(List, Map)}
   */
  @Test
  void testNewQuestionBasePredicateNamespace() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);

    // Act
    new QuestionBasePredicateNamespace(questions, new HashMap<>());

    // Assert
    verify(surveyQuestion).externalId();
  }

  /**
   * Method under test:
   * {@link QuestionBasePredicateNamespace#QuestionBasePredicateNamespace(List, Map)}
   */
  @Test
  void testNewQuestionBasePredicateNamespace2() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult);
    SurveyQuestion surveyQuestion2 = mock(SurveyQuestion.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyQuestion2.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion2);
    questions.add(surveyQuestion);

    // Act
    new QuestionBasePredicateNamespace(questions, new HashMap<>());

    // Assert
    verify(surveyQuestion2).externalId();
    verify(surveyQuestion).externalId();
  }

  /**
   * Method under test:
   * {@link QuestionBasePredicateNamespace#QuestionBasePredicateNamespace(List, Map)}
   */
  @Test
  void testNewQuestionBasePredicateNamespace3() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.externalId()).thenReturn(ofResult);
    SurveyQuestion surveyQuestion2 = mock(SurveyQuestion.class);
    Optional<String> ofResult2 = Optional.of("foo");
    when(surveyQuestion2.externalId()).thenReturn(ofResult2);
    SurveyQuestion surveyQuestion3 = mock(SurveyQuestion.class);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestion3.externalId()).thenReturn(ofResult3);
    SurveyQuestion surveyQuestion4 = mock(SurveyQuestion.class);
    Optional<String> ofResult4 = Optional.of("foo");
    when(surveyQuestion4.externalId()).thenReturn(ofResult4);
    SurveyQuestion surveyQuestion5 = mock(SurveyQuestion.class);
    Optional<String> ofResult5 = Optional.of("foo");
    when(surveyQuestion5.externalId()).thenReturn(ofResult5);
    SurveyQuestion surveyQuestion6 = mock(SurveyQuestion.class);
    Optional<String> ofResult6 = Optional.of("foo");
    when(surveyQuestion6.externalId()).thenReturn(ofResult6);
    SurveyQuestion surveyQuestion7 = mock(SurveyQuestion.class);
    Optional<String> ofResult7 = Optional.of("foo");
    when(surveyQuestion7.externalId()).thenReturn(ofResult7);
    SurveyQuestion surveyQuestion8 = mock(SurveyQuestion.class);
    Optional<String> ofResult8 = Optional.of("foo");
    when(surveyQuestion8.externalId()).thenReturn(ofResult8);
    SurveyQuestion surveyQuestion9 = mock(SurveyQuestion.class);
    Optional<String> ofResult9 = Optional.of("foo");
    when(surveyQuestion9.externalId()).thenReturn(ofResult9);
    SurveyQuestion surveyQuestion10 = mock(SurveyQuestion.class);
    Optional<String> ofResult10 = Optional.of("foo");
    when(surveyQuestion10.externalId()).thenReturn(ofResult10);
    SurveyQuestion surveyQuestion11 = mock(SurveyQuestion.class);
    Optional<String> ofResult11 = Optional.of("foo");
    when(surveyQuestion11.externalId()).thenReturn(ofResult11);
    SurveyQuestion surveyQuestion12 = mock(SurveyQuestion.class);
    Optional<String> ofResult12 = Optional.of("foo");
    when(surveyQuestion12.externalId()).thenReturn(ofResult12);
    SurveyQuestion surveyQuestion13 = mock(SurveyQuestion.class);
    Optional<String> ofResult13 = Optional.of("foo");
    when(surveyQuestion13.externalId()).thenReturn(ofResult13);
    SurveyQuestion surveyQuestion14 = mock(SurveyQuestion.class);
    Optional<String> ofResult14 = Optional.of("foo");
    when(surveyQuestion14.externalId()).thenReturn(ofResult14);
    SurveyQuestion surveyQuestion15 = mock(SurveyQuestion.class);
    Optional<String> ofResult15 = Optional.of("foo");
    when(surveyQuestion15.externalId()).thenReturn(ofResult15);
    SurveyQuestion surveyQuestion16 = mock(SurveyQuestion.class);
    Optional<String> ofResult16 = Optional.of("foo");
    when(surveyQuestion16.externalId()).thenReturn(ofResult16);
    SurveyQuestion surveyQuestion17 = mock(SurveyQuestion.class);
    Optional<String> ofResult17 = Optional.of("foo");
    when(surveyQuestion17.externalId()).thenReturn(ofResult17);
    SurveyQuestion surveyQuestion18 = mock(SurveyQuestion.class);
    Optional<String> ofResult18 = Optional.of("foo");
    when(surveyQuestion18.externalId()).thenReturn(ofResult18);
    SurveyQuestion surveyQuestion19 = mock(SurveyQuestion.class);
    Optional<String> ofResult19 = Optional.of("foo");
    when(surveyQuestion19.externalId()).thenReturn(ofResult19);
    SurveyQuestion surveyQuestion20 = mock(SurveyQuestion.class);
    Optional<String> ofResult20 = Optional.of("foo");
    when(surveyQuestion20.externalId()).thenReturn(ofResult20);
    SurveyQuestion surveyQuestion21 = mock(SurveyQuestion.class);
    Optional<String> ofResult21 = Optional.of("foo");
    when(surveyQuestion21.externalId()).thenReturn(ofResult21);
    SurveyQuestion surveyQuestion22 = mock(SurveyQuestion.class);
    Optional<String> ofResult22 = Optional.of("foo");
    when(surveyQuestion22.externalId()).thenReturn(ofResult22);
    SurveyQuestion surveyQuestion23 = mock(SurveyQuestion.class);
    Optional<String> ofResult23 = Optional.of("foo");
    when(surveyQuestion23.externalId()).thenReturn(ofResult23);
    SurveyQuestion surveyQuestion24 = mock(SurveyQuestion.class);
    Optional<String> ofResult24 = Optional.of("foo");
    when(surveyQuestion24.externalId()).thenReturn(ofResult24);
    SurveyQuestion surveyQuestion25 = mock(SurveyQuestion.class);
    Optional<String> ofResult25 = Optional.of("foo");
    when(surveyQuestion25.externalId()).thenReturn(ofResult25);
    SurveyQuestion surveyQuestion26 = mock(SurveyQuestion.class);
    Optional<String> ofResult26 = Optional.of("foo");
    when(surveyQuestion26.externalId()).thenReturn(ofResult26);
    SurveyQuestion surveyQuestion27 = mock(SurveyQuestion.class);
    Optional<String> ofResult27 = Optional.of("foo");
    when(surveyQuestion27.externalId()).thenReturn(ofResult27);
    SurveyQuestion surveyQuestion28 = mock(SurveyQuestion.class);
    Optional<String> ofResult28 = Optional.of("foo");
    when(surveyQuestion28.externalId()).thenReturn(ofResult28);
    SurveyQuestion surveyQuestion29 = mock(SurveyQuestion.class);
    Optional<String> ofResult29 = Optional.of("foo");
    when(surveyQuestion29.externalId()).thenReturn(ofResult29);
    SurveyQuestion surveyQuestion30 = mock(SurveyQuestion.class);
    Optional<String> ofResult30 = Optional.of("foo");
    when(surveyQuestion30.externalId()).thenReturn(ofResult30);
    SurveyQuestion surveyQuestion31 = mock(SurveyQuestion.class);
    Optional<String> ofResult31 = Optional.of("foo");
    when(surveyQuestion31.externalId()).thenReturn(ofResult31);
    SurveyQuestion surveyQuestion32 = mock(SurveyQuestion.class);
    Optional<String> ofResult32 = Optional.of("foo");
    when(surveyQuestion32.externalId()).thenReturn(ofResult32);
    SurveyQuestion surveyQuestion33 = mock(SurveyQuestion.class);
    Optional<String> ofResult33 = Optional.of("foo");
    when(surveyQuestion33.externalId()).thenReturn(ofResult33);
    SurveyQuestion surveyQuestion34 = mock(SurveyQuestion.class);
    Optional<String> ofResult34 = Optional.of("foo");
    when(surveyQuestion34.externalId()).thenReturn(ofResult34);
    SurveyQuestion surveyQuestion35 = mock(SurveyQuestion.class);
    Optional<String> ofResult35 = Optional.of("foo");
    when(surveyQuestion35.externalId()).thenReturn(ofResult35);
    SurveyQuestion surveyQuestion36 = mock(SurveyQuestion.class);
    Optional<String> ofResult36 = Optional.of("foo");
    when(surveyQuestion36.externalId()).thenReturn(ofResult36);
    SurveyQuestion surveyQuestion37 = mock(SurveyQuestion.class);
    Optional<String> ofResult37 = Optional.of("foo");
    when(surveyQuestion37.externalId()).thenReturn(ofResult37);
    SurveyQuestion surveyQuestion38 = mock(SurveyQuestion.class);
    Optional<String> ofResult38 = Optional.of("foo");
    when(surveyQuestion38.externalId()).thenReturn(ofResult38);
    SurveyQuestion surveyQuestion39 = mock(SurveyQuestion.class);
    Optional<String> ofResult39 = Optional.of("foo");
    when(surveyQuestion39.externalId()).thenReturn(ofResult39);
    SurveyQuestion surveyQuestion40 = mock(SurveyQuestion.class);
    Optional<String> ofResult40 = Optional.of("foo");
    when(surveyQuestion40.externalId()).thenReturn(ofResult40);
    SurveyQuestion surveyQuestion41 = mock(SurveyQuestion.class);
    Optional<String> ofResult41 = Optional.of("foo");
    when(surveyQuestion41.externalId()).thenReturn(ofResult41);
    SurveyQuestion surveyQuestion42 = mock(SurveyQuestion.class);
    Optional<String> ofResult42 = Optional.of("foo");
    when(surveyQuestion42.externalId()).thenReturn(ofResult42);
    SurveyQuestion surveyQuestion43 = mock(SurveyQuestion.class);
    Optional<String> ofResult43 = Optional.of("foo");
    when(surveyQuestion43.externalId()).thenReturn(ofResult43);
    SurveyQuestion surveyQuestion44 = mock(SurveyQuestion.class);
    Optional<String> ofResult44 = Optional.of("foo");
    when(surveyQuestion44.externalId()).thenReturn(ofResult44);
    SurveyQuestion surveyQuestion45 = mock(SurveyQuestion.class);
    Optional<String> ofResult45 = Optional.of("foo");
    when(surveyQuestion45.externalId()).thenReturn(ofResult45);
    SurveyQuestion surveyQuestion46 = mock(SurveyQuestion.class);
    Optional<String> ofResult46 = Optional.of("foo");
    when(surveyQuestion46.externalId()).thenReturn(ofResult46);
    SurveyQuestion surveyQuestion47 = mock(SurveyQuestion.class);
    Optional<String> ofResult47 = Optional.of("foo");
    when(surveyQuestion47.externalId()).thenReturn(ofResult47);
    SurveyQuestion surveyQuestion48 = mock(SurveyQuestion.class);
    Optional<String> ofResult48 = Optional.of("foo");
    when(surveyQuestion48.externalId()).thenReturn(ofResult48);
    SurveyQuestion surveyQuestion49 = mock(SurveyQuestion.class);
    Optional<String> ofResult49 = Optional.of("foo");
    when(surveyQuestion49.externalId()).thenReturn(ofResult49);
    SurveyQuestion surveyQuestion50 = mock(SurveyQuestion.class);
    Optional<String> ofResult50 = Optional.of("foo");
    when(surveyQuestion50.externalId()).thenReturn(ofResult50);
    SurveyQuestion surveyQuestion51 = mock(SurveyQuestion.class);
    Optional<String> ofResult51 = Optional.of("foo");
    when(surveyQuestion51.externalId()).thenReturn(ofResult51);
    SurveyQuestion surveyQuestion52 = mock(SurveyQuestion.class);
    Optional<String> ofResult52 = Optional.of("foo");
    when(surveyQuestion52.externalId()).thenReturn(ofResult52);
    SurveyQuestion surveyQuestion53 = mock(SurveyQuestion.class);
    Optional<String> ofResult53 = Optional.of("foo");
    when(surveyQuestion53.externalId()).thenReturn(ofResult53);
    SurveyQuestion surveyQuestion54 = mock(SurveyQuestion.class);
    Optional<String> ofResult54 = Optional.of("foo");
    when(surveyQuestion54.externalId()).thenReturn(ofResult54);
    SurveyQuestion surveyQuestion55 = mock(SurveyQuestion.class);
    Optional<String> ofResult55 = Optional.of("foo");
    when(surveyQuestion55.externalId()).thenReturn(ofResult55);
    SurveyQuestion surveyQuestion56 = mock(SurveyQuestion.class);
    Optional<String> ofResult56 = Optional.of("foo");
    when(surveyQuestion56.externalId()).thenReturn(ofResult56);
    SurveyQuestion surveyQuestion57 = mock(SurveyQuestion.class);
    Optional<String> ofResult57 = Optional.of("foo");
    when(surveyQuestion57.externalId()).thenReturn(ofResult57);
    SurveyQuestion surveyQuestion58 = mock(SurveyQuestion.class);
    Optional<String> ofResult58 = Optional.of("foo");
    when(surveyQuestion58.externalId()).thenReturn(ofResult58);
    SurveyQuestion surveyQuestion59 = mock(SurveyQuestion.class);
    Optional<String> ofResult59 = Optional.of("foo");
    when(surveyQuestion59.externalId()).thenReturn(ofResult59);
    SurveyQuestion surveyQuestion60 = mock(SurveyQuestion.class);
    Optional<String> ofResult60 = Optional.of("foo");
    when(surveyQuestion60.externalId()).thenReturn(ofResult60);
    SurveyQuestion surveyQuestion61 = mock(SurveyQuestion.class);
    Optional<String> ofResult61 = Optional.of("foo");
    when(surveyQuestion61.externalId()).thenReturn(ofResult61);
    SurveyQuestion surveyQuestion62 = mock(SurveyQuestion.class);
    Optional<String> ofResult62 = Optional.of("foo");
    when(surveyQuestion62.externalId()).thenReturn(ofResult62);
    SurveyQuestion surveyQuestion63 = mock(SurveyQuestion.class);
    Optional<String> ofResult63 = Optional.of("foo");
    when(surveyQuestion63.externalId()).thenReturn(ofResult63);
    SurveyQuestion surveyQuestion64 = mock(SurveyQuestion.class);
    Optional<String> ofResult64 = Optional.of("foo");
    when(surveyQuestion64.externalId()).thenReturn(ofResult64);
    SurveyQuestion surveyQuestion65 = mock(SurveyQuestion.class);
    Optional<String> ofResult65 = Optional.of("foo");
    when(surveyQuestion65.externalId()).thenReturn(ofResult65);
    SurveyQuestion surveyQuestion66 = mock(SurveyQuestion.class);
    Optional<String> ofResult66 = Optional.of("foo");
    when(surveyQuestion66.externalId()).thenReturn(ofResult66);
    SurveyQuestion surveyQuestion67 = mock(SurveyQuestion.class);
    Optional<String> ofResult67 = Optional.of("foo");
    when(surveyQuestion67.externalId()).thenReturn(ofResult67);
    SurveyQuestion surveyQuestion68 = mock(SurveyQuestion.class);
    Optional<String> ofResult68 = Optional.of("foo");
    when(surveyQuestion68.externalId()).thenReturn(ofResult68);
    SurveyQuestion surveyQuestion69 = mock(SurveyQuestion.class);
    Optional<String> ofResult69 = Optional.of("foo");
    when(surveyQuestion69.externalId()).thenReturn(ofResult69);
    SurveyQuestion surveyQuestion70 = mock(SurveyQuestion.class);
    Optional<String> ofResult70 = Optional.of("foo");
    when(surveyQuestion70.externalId()).thenReturn(ofResult70);
    SurveyQuestion surveyQuestion71 = mock(SurveyQuestion.class);
    Optional<String> ofResult71 = Optional.of("foo");
    when(surveyQuestion71.externalId()).thenReturn(ofResult71);
    SurveyQuestion surveyQuestion72 = mock(SurveyQuestion.class);
    Optional<String> ofResult72 = Optional.of("foo");
    when(surveyQuestion72.externalId()).thenReturn(ofResult72);
    SurveyQuestion surveyQuestion73 = mock(SurveyQuestion.class);
    Optional<String> ofResult73 = Optional.of("foo");
    when(surveyQuestion73.externalId()).thenReturn(ofResult73);
    SurveyQuestion surveyQuestion74 = mock(SurveyQuestion.class);
    Optional<String> ofResult74 = Optional.of("foo");
    when(surveyQuestion74.externalId()).thenReturn(ofResult74);
    SurveyQuestion surveyQuestion75 = mock(SurveyQuestion.class);
    Optional<String> ofResult75 = Optional.of("foo");
    when(surveyQuestion75.externalId()).thenReturn(ofResult75);
    SurveyQuestion surveyQuestion76 = mock(SurveyQuestion.class);
    Optional<String> ofResult76 = Optional.of("foo");
    when(surveyQuestion76.externalId()).thenReturn(ofResult76);
    SurveyQuestion surveyQuestion77 = mock(SurveyQuestion.class);
    Optional<String> ofResult77 = Optional.of("foo");
    when(surveyQuestion77.externalId()).thenReturn(ofResult77);
    SurveyQuestion surveyQuestion78 = mock(SurveyQuestion.class);
    Optional<String> ofResult78 = Optional.of("foo");
    when(surveyQuestion78.externalId()).thenReturn(ofResult78);
    SurveyQuestion surveyQuestion79 = mock(SurveyQuestion.class);
    Optional<String> emptyResult = Optional.empty();
    when(surveyQuestion79.externalId()).thenReturn(emptyResult);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion79);
    questions.add(surveyQuestion78);
    questions.add(surveyQuestion77);
    questions.add(surveyQuestion76);
    questions.add(surveyQuestion75);
    questions.add(surveyQuestion74);
    questions.add(surveyQuestion73);
    questions.add(surveyQuestion72);
    questions.add(surveyQuestion71);
    questions.add(surveyQuestion70);
    questions.add(surveyQuestion69);
    questions.add(surveyQuestion68);
    questions.add(surveyQuestion67);
    questions.add(surveyQuestion66);
    questions.add(surveyQuestion65);
    questions.add(surveyQuestion64);
    questions.add(surveyQuestion63);
    questions.add(surveyQuestion62);
    questions.add(surveyQuestion61);
    questions.add(surveyQuestion60);
    questions.add(surveyQuestion59);
    questions.add(surveyQuestion58);
    questions.add(surveyQuestion57);
    questions.add(surveyQuestion56);
    questions.add(surveyQuestion55);
    questions.add(surveyQuestion54);
    questions.add(surveyQuestion53);
    questions.add(surveyQuestion52);
    questions.add(surveyQuestion51);
    questions.add(surveyQuestion50);
    questions.add(surveyQuestion49);
    questions.add(surveyQuestion48);
    questions.add(surveyQuestion47);
    questions.add(surveyQuestion46);
    questions.add(surveyQuestion45);
    questions.add(surveyQuestion44);
    questions.add(surveyQuestion43);
    questions.add(surveyQuestion42);
    questions.add(surveyQuestion41);
    questions.add(surveyQuestion40);
    questions.add(surveyQuestion39);
    questions.add(surveyQuestion38);
    questions.add(surveyQuestion37);
    questions.add(surveyQuestion36);
    questions.add(surveyQuestion35);
    questions.add(surveyQuestion34);
    questions.add(surveyQuestion33);
    questions.add(surveyQuestion32);
    questions.add(surveyQuestion31);
    questions.add(surveyQuestion30);
    questions.add(surveyQuestion29);
    questions.add(surveyQuestion28);
    questions.add(surveyQuestion27);
    questions.add(surveyQuestion26);
    questions.add(surveyQuestion25);
    questions.add(surveyQuestion24);
    questions.add(surveyQuestion23);
    questions.add(surveyQuestion22);
    questions.add(surveyQuestion21);
    questions.add(surveyQuestion20);
    questions.add(surveyQuestion19);
    questions.add(surveyQuestion18);
    questions.add(surveyQuestion17);
    questions.add(surveyQuestion16);
    questions.add(surveyQuestion15);
    questions.add(surveyQuestion14);
    questions.add(surveyQuestion13);
    questions.add(surveyQuestion12);
    questions.add(surveyQuestion11);
    questions.add(surveyQuestion10);
    questions.add(surveyQuestion9);
    questions.add(surveyQuestion8);
    questions.add(surveyQuestion7);
    questions.add(surveyQuestion6);
    questions.add(surveyQuestion5);
    questions.add(surveyQuestion4);
    questions.add(surveyQuestion3);
    questions.add(surveyQuestion2);
    questions.add(surveyQuestion);

    // Act
    new QuestionBasePredicateNamespace(questions, new HashMap<>());

    // Assert
    verify(surveyQuestion79).externalId();
    verify(surveyQuestion78).externalId();
    verify(surveyQuestion77).externalId();
    verify(surveyQuestion76).externalId();
    verify(surveyQuestion75).externalId();
    verify(surveyQuestion74).externalId();
    verify(surveyQuestion73).externalId();
    verify(surveyQuestion72).externalId();
    verify(surveyQuestion71).externalId();
    verify(surveyQuestion70).externalId();
    verify(surveyQuestion69).externalId();
    verify(surveyQuestion68).externalId();
    verify(surveyQuestion67).externalId();
    verify(surveyQuestion66).externalId();
    verify(surveyQuestion65).externalId();
    verify(surveyQuestion64).externalId();
    verify(surveyQuestion63).externalId();
    verify(surveyQuestion62).externalId();
    verify(surveyQuestion61).externalId();
    verify(surveyQuestion60).externalId();
    verify(surveyQuestion59).externalId();
    verify(surveyQuestion58).externalId();
    verify(surveyQuestion57).externalId();
    verify(surveyQuestion56).externalId();
    verify(surveyQuestion55).externalId();
    verify(surveyQuestion54).externalId();
    verify(surveyQuestion53).externalId();
    verify(surveyQuestion52).externalId();
    verify(surveyQuestion51).externalId();
    verify(surveyQuestion50).externalId();
    verify(surveyQuestion49).externalId();
    verify(surveyQuestion48).externalId();
    verify(surveyQuestion47).externalId();
    verify(surveyQuestion46).externalId();
    verify(surveyQuestion45).externalId();
    verify(surveyQuestion44).externalId();
    verify(surveyQuestion43).externalId();
    verify(surveyQuestion42).externalId();
    verify(surveyQuestion41).externalId();
    verify(surveyQuestion40).externalId();
    verify(surveyQuestion39).externalId();
    verify(surveyQuestion38).externalId();
    verify(surveyQuestion37).externalId();
    verify(surveyQuestion36).externalId();
    verify(surveyQuestion35).externalId();
    verify(surveyQuestion34).externalId();
    verify(surveyQuestion33).externalId();
    verify(surveyQuestion32).externalId();
    verify(surveyQuestion31).externalId();
    verify(surveyQuestion30).externalId();
    verify(surveyQuestion29).externalId();
    verify(surveyQuestion28).externalId();
    verify(surveyQuestion27).externalId();
    verify(surveyQuestion26).externalId();
    verify(surveyQuestion25).externalId();
    verify(surveyQuestion24).externalId();
    verify(surveyQuestion23).externalId();
    verify(surveyQuestion22).externalId();
    verify(surveyQuestion21).externalId();
    verify(surveyQuestion20).externalId();
    verify(surveyQuestion19).externalId();
    verify(surveyQuestion18).externalId();
    verify(surveyQuestion17).externalId();
    verify(surveyQuestion16).externalId();
    verify(surveyQuestion15).externalId();
    verify(surveyQuestion14).externalId();
    verify(surveyQuestion13).externalId();
    verify(surveyQuestion12).externalId();
    verify(surveyQuestion11).externalId();
    verify(surveyQuestion10).externalId();
    verify(surveyQuestion9).externalId();
    verify(surveyQuestion8).externalId();
    verify(surveyQuestion7).externalId();
    verify(surveyQuestion6).externalId();
    verify(surveyQuestion5).externalId();
    verify(surveyQuestion4).externalId();
    verify(surveyQuestion3).externalId();
    verify(surveyQuestion2).externalId();
    verify(surveyQuestion).externalId();
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#numberValue(String)}
   */
  @Test
  void testNumberValue() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);

    // Act
    double actualNumberValueResult = (new QuestionBasePredicateNamespace(questions, new HashMap<>())).numberValue("42");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    assertEquals(0.0d, actualNumberValueResult);
  }

  /**
   * Method under test:
   * {@link QuestionBasePredicateNamespace#numberValue(String, double)}
   */
  @Test
  void testNumberValue2() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);

    // Act
    double actualNumberValueResult = (new QuestionBasePredicateNamespace(questions, new HashMap<>())).numberValue("42",
        10.0d);

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    assertEquals(10.0d, actualNumberValueResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#ditto(String)}
   */
  @Test
  void testDitto() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> emptyResult = Optional.empty();
    when(surveyQuestion.inclusionPredicate()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);

    // Act
    boolean actualDittoResult = (new QuestionBasePredicateNamespace(questions, new HashMap<>())).ditto("42");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).inclusionPredicate();
    assertTrue(actualDittoResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#ditto(String)}
   */
  @Test
  void testDitto2() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);

    QuestionBasePredicateNamespace questionBasePredicateNamespace = new QuestionBasePredicateNamespace(questions,
        new HashMap<>());
    questionBasePredicateNamespace.usingEvaluator(new Engine());

    // Act and Assert
    assertThrows(JexlException.Variable.class, () -> questionBasePredicateNamespace.ditto("42"));
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).inclusionPredicate();
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#ditto(String)}
   */
  @Test
  void testDitto3() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("42");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);

    QuestionBasePredicateNamespace questionBasePredicateNamespace = new QuestionBasePredicateNamespace(questions,
        new HashMap<>());
    questionBasePredicateNamespace.usingEvaluator(new Engine());

    // Act
    boolean actualDittoResult = questionBasePredicateNamespace.ditto("42");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).inclusionPredicate();
    assertFalse(actualDittoResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#ditto(String)}
   */
  @Test
  void testDitto4() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<String> ofResult = Optional.of("foo");
    when(surveyQuestion.inclusionPredicate()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    JexlExpression jexlExpression = mock(JexlExpression.class);
    when(jexlExpression.evaluate(Mockito.<JexlContext>any())).thenReturn("Evaluate");
    JexlEngine jexl = mock(JexlEngine.class);
    when(jexl.createExpression(Mockito.<JexlInfo>any(), Mockito.<String>any())).thenReturn(jexlExpression);

    QuestionBasePredicateNamespace questionBasePredicateNamespace = new QuestionBasePredicateNamespace(questions,
        new HashMap<>());
    questionBasePredicateNamespace.usingEvaluator(jexl);

    // Act
    boolean actualDittoResult = questionBasePredicateNamespace.ditto("42");

    // Assert
    verify(jexl).createExpression(isNull(), eq("foo"));
    verify(jexlExpression).evaluate(isA(JexlContext.class));
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).inclusionPredicate();
    assertFalse(actualDittoResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String)}
   */
  @Test
  void testVal() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);

    // Act
    Object actualValResult = (new QuestionBasePredicateNamespace(questions, new HashMap<>())).val("42");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    assertNull(actualValResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String)}
   */
  @Test
  void testVal2() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    Optional<EntityReference> ofResult3 = Optional.of(mock(EntityReference.class));
    when(surveyQuestionResponse.entityResponse()).thenReturn(ofResult3);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).entityResponse();
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String)}
   */
  @Test
  void testVal3() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.BOOLEAN);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(surveyQuestionResponse.booleanResponse()).thenReturn(ofResult3);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).booleanResponse();
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String)}
   */
  @Test
  void testVal4() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.DATE);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    Optional<LocalDate> ofResult4 = Optional.of(ofResult3);
    when(surveyQuestionResponse.dateResponse()).thenReturn(ofResult4);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    Object actualValResult = (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).dateResponse();
    assertEquals("1970-01-01", actualValResult.toString());
    assertSame(ofResult3, actualValResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String)}
   */
  @Test
  void testVal5() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.DROPDOWN);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestionResponse.stringResponse()).thenReturn(ofResult3);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    Object actualValResult = (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).stringResponse();
    assertEquals("foo", actualValResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String)}
   */
  @Test
  void testVal6() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.DROPDOWN_MULTI_SELECT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    ArrayList<String> stringList = new ArrayList<>();
    Optional<List<String>> ofResult3 = Optional.of(stringList);
    when(surveyQuestionResponse.listResponse()).thenReturn(ofResult3);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    Object actualValResult = (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).listResponse();
    assertTrue(actualValResult instanceof List);
    assertTrue(((List<Object>) actualValResult).isEmpty());
    assertSame(stringList, actualValResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String)}
   */
  @Test
  void testVal7() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.LEGAL_ENTITY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    Optional<List<EntityReference>> ofResult3 = Optional.of(entityReferenceList);
    when(surveyQuestionResponse.entityListResponse()).thenReturn(ofResult3);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    Object actualValResult = (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).entityListResponse();
    assertTrue(actualValResult instanceof List);
    assertTrue(((List<Object>) actualValResult).isEmpty());
    assertSame(entityReferenceList, actualValResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String)}
   */
  @Test
  void testVal8() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.NUMBER);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    Optional<Double> ofResult3 = Optional.<Double>of(10.0d);
    when(surveyQuestionResponse.numberResponse()).thenReturn(ofResult3);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    Object actualValResult = (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).numberResponse();
    assertEquals(10.0d, ((Double) actualValResult).doubleValue());
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String, Object)}
   */
  @Test
  void testVal9() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);

    // Act
    Object actualValResult = (new QuestionBasePredicateNamespace(questions, new HashMap<>())).val("42",
        "Default Value");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    assertEquals("Default Value", actualValResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String, Object)}
   */
  @Test
  void testVal10() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.APPLICATION);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    Optional<EntityReference> ofResult3 = Optional.of(mock(EntityReference.class));
    when(surveyQuestionResponse.entityResponse()).thenReturn(ofResult3);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42", "Default Value");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).entityResponse();
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String, Object)}
   */
  @Test
  void testVal11() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.BOOLEAN);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    Optional<Boolean> ofResult3 = Optional.of(true);
    when(surveyQuestionResponse.booleanResponse()).thenReturn(ofResult3);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42", "Default Value");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).booleanResponse();
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String, Object)}
   */
  @Test
  void testVal12() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.DATE);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    Optional<LocalDate> ofResult4 = Optional.of(ofResult3);
    when(surveyQuestionResponse.dateResponse()).thenReturn(ofResult4);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    Object actualValResult = (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42",
        "Default Value");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).dateResponse();
    assertEquals("1970-01-01", actualValResult.toString());
    assertSame(ofResult3, actualValResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String, Object)}
   */
  @Test
  void testVal13() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.DROPDOWN);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    Optional<String> ofResult3 = Optional.of("foo");
    when(surveyQuestionResponse.stringResponse()).thenReturn(ofResult3);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    Object actualValResult = (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42",
        "Default Value");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).stringResponse();
    assertEquals("foo", actualValResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String, Object)}
   */
  @Test
  void testVal14() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.DROPDOWN_MULTI_SELECT);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    ArrayList<String> stringList = new ArrayList<>();
    Optional<List<String>> ofResult3 = Optional.of(stringList);
    when(surveyQuestionResponse.listResponse()).thenReturn(ofResult3);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    Object actualValResult = (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42",
        "Default Value");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).listResponse();
    assertTrue(actualValResult instanceof List);
    assertTrue(((List<Object>) actualValResult).isEmpty());
    assertSame(stringList, actualValResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String, Object)}
   */
  @Test
  void testVal15() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.LEGAL_ENTITY);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    Optional<List<EntityReference>> ofResult3 = Optional.of(entityReferenceList);
    when(surveyQuestionResponse.entityListResponse()).thenReturn(ofResult3);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    Object actualValResult = (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42",
        "Default Value");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).entityListResponse();
    assertTrue(actualValResult instanceof List);
    assertTrue(((List<Object>) actualValResult).isEmpty());
    assertSame(entityReferenceList, actualValResult);
  }

  /**
   * Method under test: {@link QuestionBasePredicateNamespace#val(String, Object)}
   */
  @Test
  void testVal16() {
    // Arrange
    SurveyQuestion surveyQuestion = mock(SurveyQuestion.class);
    when(surveyQuestion.fieldType()).thenReturn(SurveyQuestionFieldType.NUMBER);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(surveyQuestion.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("42");
    when(surveyQuestion.externalId()).thenReturn(ofResult2);

    ArrayList<SurveyQuestion> questions = new ArrayList<>();
    questions.add(surveyQuestion);
    SurveyQuestionResponse surveyQuestionResponse = mock(SurveyQuestionResponse.class);
    Optional<Double> ofResult3 = Optional.<Double>of(10.0d);
    when(surveyQuestionResponse.numberResponse()).thenReturn(ofResult3);

    HashMap<Long, SurveyQuestionResponse> responsesByQuestionId = new HashMap<>();
    responsesByQuestionId.put(1L, surveyQuestionResponse);
    responsesByQuestionId.putAll(new HashMap<>());

    // Act
    Object actualValResult = (new QuestionBasePredicateNamespace(questions, responsesByQuestionId)).val("42",
        "Default Value");

    // Assert
    verify(surveyQuestion).externalId();
    verify(surveyQuestion).id();
    verify(surveyQuestion).fieldType();
    verify(surveyQuestionResponse).numberResponse();
    assertEquals(10.0d, ((Double) actualValResult).doubleValue());
  }
}
