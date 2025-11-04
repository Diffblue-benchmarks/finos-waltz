package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionDropdownEntry;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionInfoDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo.Builder#addAllDropdownEntries(Iterable)}
   */
  @Test
  void testBuilderAddAllDropdownEntries() {
    // Arrange
    ImmutableSurveyQuestionInfo.Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDropdownEntries(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo.Builder#addDropdownEntries(SurveyQuestionDropdownEntry)}
   */
  @Test
  void testBuilderAddDropdownEntries() {
    // Arrange
    ImmutableSurveyQuestionInfo.Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDropdownEntries(mock(SurveyQuestionDropdownEntry.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo.Builder#addDropdownEntries(SurveyQuestionDropdownEntry[])}
   */
  @Test
  void testBuilderAddDropdownEntries2() {
    // Arrange
    ImmutableSurveyQuestionInfo.Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDropdownEntries(mock(SurveyQuestionDropdownEntry.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo.Builder#dropdownEntries(Iterable)}
   */
  @Test
  void testBuilderDropdownEntries() {
    // Arrange
    ImmutableSurveyQuestionInfo.Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dropdownEntries(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo.Builder#from(SurveyQuestionInfo)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyQuestionInfo.Builder builderResult = ImmutableSurveyQuestionInfo.builder();
    SurveyQuestionInfo instance = mock(SurveyQuestionInfo.class);
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    when(instance.question()).thenReturn(mock(SurveyQuestion.class));

    // Act
    ImmutableSurveyQuestionInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dropdownEntries();
    verify(instance).question();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo.Builder#from(SurveyQuestionInfo)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyQuestionInfo.Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    ArrayList<SurveyQuestionDropdownEntry> surveyQuestionDropdownEntryList = new ArrayList<>();
    surveyQuestionDropdownEntryList.add(mock(SurveyQuestionDropdownEntry.class));
    SurveyQuestionInfo instance = mock(SurveyQuestionInfo.class);
    when(instance.dropdownEntries()).thenReturn(surveyQuestionDropdownEntryList);
    when(instance.question()).thenReturn(mock(SurveyQuestion.class));

    // Act
    ImmutableSurveyQuestionInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dropdownEntries();
    verify(instance).question();
    assertEquals(1, builderResult.build().dropdownEntries().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo.Builder#from(SurveyQuestionInfo)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyQuestionInfo.Builder builderResult = ImmutableSurveyQuestionInfo.builder();
    SurveyQuestionInfo instance = mock(SurveyQuestionInfo.class);
    when(instance.dropdownEntries()).thenThrow(new IllegalStateException("instance"));
    when(instance.question()).thenReturn(mock(SurveyQuestion.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dropdownEntries();
    verify(instance).question();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo.Builder#question(SurveyQuestion)}
   */
  @Test
  void testBuilderQuestion() {
    // Arrange
    ImmutableSurveyQuestionInfo.Builder builderResult = ImmutableSurveyQuestionInfo.builder();
    SurveyQuestion question = mock(SurveyQuestion.class);

    // Act and Assert
    assertSame(builderResult, builderResult.question(question));
    assertSame(question, builderResult.build().question());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo#copyOf(SurveyQuestionInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyQuestionInfo instance = mock(SurveyQuestionInfo.class);
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    when(instance.question()).thenReturn(mock(SurveyQuestion.class));

    // Act
    ImmutableSurveyQuestionInfo actualCopyOfResult = ImmutableSurveyQuestionInfo.copyOf(instance);

    // Assert
    verify(instance).dropdownEntries();
    verify(instance).question();
    assertTrue(actualCopyOfResult.dropdownEntries().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo#copyOf(SurveyQuestionInfo)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<SurveyQuestionDropdownEntry> surveyQuestionDropdownEntryList = new ArrayList<>();
    surveyQuestionDropdownEntryList.add(mock(SurveyQuestionDropdownEntry.class));
    SurveyQuestionInfo instance = mock(SurveyQuestionInfo.class);
    when(instance.dropdownEntries()).thenReturn(surveyQuestionDropdownEntryList);
    when(instance.question()).thenReturn(mock(SurveyQuestion.class));

    // Act
    ImmutableSurveyQuestionInfo actualCopyOfResult = ImmutableSurveyQuestionInfo.copyOf(instance);

    // Assert
    verify(instance).dropdownEntries();
    verify(instance).question();
    assertEquals(1, actualCopyOfResult.dropdownEntries().size());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo#copyOf(SurveyQuestionInfo)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<SurveyQuestionDropdownEntry> surveyQuestionDropdownEntryList = new ArrayList<>();
    surveyQuestionDropdownEntryList.add(mock(SurveyQuestionDropdownEntry.class));
    surveyQuestionDropdownEntryList.add(mock(SurveyQuestionDropdownEntry.class));
    SurveyQuestionInfo instance = mock(SurveyQuestionInfo.class);
    when(instance.dropdownEntries()).thenReturn(surveyQuestionDropdownEntryList);
    when(instance.question()).thenReturn(mock(SurveyQuestion.class));

    // Act
    ImmutableSurveyQuestionInfo actualCopyOfResult = ImmutableSurveyQuestionInfo.copyOf(instance);

    // Assert
    verify(instance).dropdownEntries();
    verify(instance).question();
    assertEquals(surveyQuestionDropdownEntryList, actualCopyOfResult.dropdownEntries());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo#fromJson(ImmutableSurveyQuestionInfo.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyQuestionInfo.Json json = new ImmutableSurveyQuestionInfo.Json();
    json.setQuestion(mock(SurveyQuestion.class));

    // Act
    ImmutableSurveyQuestionInfo actualFromJsonResult = ImmutableSurveyQuestionInfo.fromJson(json);

    // Assert
    List<SurveyQuestionDropdownEntry> dropdownEntriesResult = actualFromJsonResult.dropdownEntries();
    assertTrue(dropdownEntriesResult.isEmpty());
    assertSame(json.dropdownEntries, dropdownEntriesResult);
    SurveyQuestion expectedQuestionResult = json.question;
    assertSame(expectedQuestionResult, actualFromJsonResult.question());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyQuestionInfo#fromJson(ImmutableSurveyQuestionInfo.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<SurveyQuestionDropdownEntry> dropdownEntries = new ArrayList<>();
    dropdownEntries.add(mock(SurveyQuestionDropdownEntry.class));

    ImmutableSurveyQuestionInfo.Json json = new ImmutableSurveyQuestionInfo.Json();
    json.setQuestion(mock(SurveyQuestion.class));
    json.setDropdownEntries(dropdownEntries);

    // Act
    ImmutableSurveyQuestionInfo actualFromJsonResult = ImmutableSurveyQuestionInfo.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.dropdownEntries().size());
    SurveyQuestion expectedQuestionResult = json.question;
    assertSame(expectedQuestionResult, actualFromJsonResult.question());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionInfo.Json#dropdownEntries()}
   */
  @Test
  void testJsonDropdownEntries() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionInfo.Json()).dropdownEntries());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyQuestionInfo.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyQuestionInfo.Json actualJson = new ImmutableSurveyQuestionInfo.Json();

    // Assert
    assertNull(actualJson.question);
    assertTrue(actualJson.dropdownEntries.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableSurveyQuestionInfo.Json#question()}
   */
  @Test
  void testJsonQuestion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyQuestionInfo.Json()).question());
  }
}
