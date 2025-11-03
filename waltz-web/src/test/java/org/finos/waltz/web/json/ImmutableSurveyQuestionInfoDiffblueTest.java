package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.waltz.model.survey.SurveyQuestion;
import org.finos.waltz.model.survey.SurveyQuestionDropdownEntry;
import org.finos.waltz.web.json.ImmutableSurveyQuestionInfo.Builder;
import org.finos.waltz.web.json.ImmutableSurveyQuestionInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyQuestionInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDropdownEntries(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDropdownEntries(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDropdownEntries(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDropdownEntries(Iterable)"})
  void testBuilderAddAllDropdownEntries_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDropdownEntries(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addDropdownEntries(SurveyQuestionDropdownEntry)} with {@code element}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDropdownEntries(SurveyQuestionDropdownEntry)}
   */
  @Test
  @DisplayName("Test Builder addDropdownEntries(SurveyQuestionDropdownEntry) with 'element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDropdownEntries(SurveyQuestionDropdownEntry)"})
  void testBuilderAddDropdownEntriesWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDropdownEntries(mock(SurveyQuestionDropdownEntry.class)));
  }

  /**
   * Test Builder {@link Builder#addDropdownEntries(SurveyQuestionDropdownEntry[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDropdownEntries(SurveyQuestionDropdownEntry[])}
   */
  @Test
  @DisplayName("Test Builder addDropdownEntries(SurveyQuestionDropdownEntry[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDropdownEntries(SurveyQuestionDropdownEntry[])"})
  void testBuilderAddDropdownEntriesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDropdownEntries(mock(SurveyQuestionDropdownEntry.class)));
  }

  /**
   * Test Builder {@link Builder#dropdownEntries(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#dropdownEntries(Iterable)}
   */
  @Test
  @DisplayName("Test Builder dropdownEntries(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.dropdownEntries(Iterable)"})
  void testBuilderDropdownEntries_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.dropdownEntries(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionInfo)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return build dropdownEntries Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionInfo); given ArrayList(); then return build dropdownEntries Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionInfo)"})
  void testBuilderFrom_givenArrayList_thenReturnBuildDropdownEntriesEmpty() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();
    SurveyQuestionInfo instance = mock(SurveyQuestionInfo.class);
    when(instance.dropdownEntries()).thenReturn(new ArrayList<>());
    when(instance.question()).thenReturn(mock(SurveyQuestion.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dropdownEntries();
    verify(instance).question();
    assertTrue(actualFromResult.build().dropdownEntries().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionInfo)}.
   * <ul>
   *   <li>Then return build dropdownEntries size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionInfo); then return build dropdownEntries size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionInfo)"})
  void testBuilderFrom_thenReturnBuildDropdownEntriesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();

    ArrayList<SurveyQuestionDropdownEntry> surveyQuestionDropdownEntryList = new ArrayList<>();
    surveyQuestionDropdownEntryList.add(mock(SurveyQuestionDropdownEntry.class));
    SurveyQuestionInfo instance = mock(SurveyQuestionInfo.class);
    when(instance.dropdownEntries()).thenReturn(surveyQuestionDropdownEntryList);
    when(instance.question()).thenReturn(mock(SurveyQuestion.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).dropdownEntries();
    verify(instance).question();
    assertEquals(1, actualFromResult.build().dropdownEntries().size());
    assertEquals(1, builderResult.build().dropdownEntries().size());
  }

  /**
   * Test Builder {@link Builder#from(SurveyQuestionInfo)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyQuestionInfo)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyQuestionInfo); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyQuestionInfo)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();
    SurveyQuestionInfo instance = mock(SurveyQuestionInfo.class);
    when(instance.dropdownEntries()).thenThrow(new IllegalStateException("instance"));
    when(instance.question()).thenReturn(mock(SurveyQuestion.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).dropdownEntries();
    verify(instance).question();
  }

  /**
   * Test Builder {@link Builder#question(SurveyQuestion)}.
   * <ul>
   *   <li>When {@link SurveyQuestion}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#question(SurveyQuestion)}
   */
  @Test
  @DisplayName("Test Builder question(SurveyQuestion); when SurveyQuestion; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.question(SurveyQuestion)"})
  void testBuilderQuestion_whenSurveyQuestion_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyQuestionInfo.builder();
    SurveyQuestion question = mock(SurveyQuestion.class);

    // Act and Assert
    assertSame(builderResult, builderResult.question(question));
    assertSame(question, builderResult.build().question());
  }

  /**
   * Test Json {@link Json#dropdownEntries()}.
   * <p>
   * Method under test: {@link Json#dropdownEntries()}
   */
  @Test
  @DisplayName("Test Json dropdownEntries()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List Json.dropdownEntries()"})
  void testJsonDropdownEntries() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).dropdownEntries());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.question);
    assertTrue(actualJson.dropdownEntries.isEmpty());
  }

  /**
   * Test Json {@link Json#question()}.
   * <p>
   * Method under test: {@link Json#question()}
   */
  @Test
  @DisplayName("Test Json question()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyQuestion Json.question()"})
  void testJsonQuestion() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).question());
  }
}
