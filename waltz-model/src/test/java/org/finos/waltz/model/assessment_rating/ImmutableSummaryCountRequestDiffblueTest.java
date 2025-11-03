package org.finos.waltz.model.assessment_rating;

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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.assessment_rating.ImmutableSummaryCountRequest.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableSummaryCountRequest.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSummaryCountRequestDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDefinitionIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDefinitionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDefinitionIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDefinitionIds(Iterable)"})
  void testBuilderAddAllDefinitionIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableSummaryCountRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDefinitionIds(elements));
  }

  /**
   * Test Builder {@link Builder#addAllDefinitionIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDefinitionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDefinitionIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDefinitionIds(Iterable)"})
  void testBuilderAddAllDefinitionIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSummaryCountRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDefinitionIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addDefinitionIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addDefinitionIds(long)}
   */
  @Test
  @DisplayName("Test Builder addDefinitionIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDefinitionIds(long)"})
  void testBuilderAddDefinitionIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableSummaryCountRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDefinitionIds(1L));
  }

  /**
   * Test Builder {@link Builder#addDefinitionIds(long[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addDefinitionIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addDefinitionIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDefinitionIds(long[])"})
  void testBuilderAddDefinitionIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableSummaryCountRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDefinitionIds(1L, -2L, 1L, -2L));
  }

  /**
   * Test Builder {@link Builder#definitionIds(Iterable)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#definitionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder definitionIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.definitionIds(Iterable)"})
  void testBuilderDefinitionIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableSummaryCountRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.definitionIds(elements));
  }

  /**
   * Test Builder {@link Builder#definitionIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#definitionIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder definitionIds(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.definitionIds(Iterable)"})
  void testBuilderDefinitionIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableSummaryCountRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definitionIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(SummaryCountRequest)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add minus two.</li>
   *   <li>Then return build definitionIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SummaryCountRequest)}
   */
  @Test
  @DisplayName("Test Builder from(SummaryCountRequest); given HashSet() add minus two; then return build definitionIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SummaryCountRequest)"})
  void testBuilderFrom_givenHashSetAddMinusTwo_thenReturnBuildDefinitionIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSummaryCountRequest.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    SummaryCountRequest instance = mock(SummaryCountRequest.class);
    when(instance.definitionIds()).thenReturn(resultLongSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionIds();
    verify(instance).idSelectionOptions();
    Set<Long> definitionIdsResult = actualFromResult.build().definitionIds();
    assertEquals(1, definitionIdsResult.size());
    Set<Long> definitionIdsResult2 = builderResult.build().definitionIds();
    assertEquals(1, definitionIdsResult2.size());
    assertTrue(definitionIdsResult.contains(-2L));
    assertTrue(definitionIdsResult2.contains(-2L));
  }

  /**
   * Test Builder {@link Builder#from(SummaryCountRequest)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then return build definitionIds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SummaryCountRequest)}
   */
  @Test
  @DisplayName("Test Builder from(SummaryCountRequest); given HashSet(); then return build definitionIds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SummaryCountRequest)"})
  void testBuilderFrom_givenHashSet_thenReturnBuildDefinitionIdsEmpty() {
    // Arrange
    Builder builderResult = ImmutableSummaryCountRequest.builder();
    SummaryCountRequest instance = mock(SummaryCountRequest.class);
    when(instance.definitionIds()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionIds();
    verify(instance).idSelectionOptions();
    assertTrue(actualFromResult.build().definitionIds().isEmpty());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SummaryCountRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SummaryCountRequest)}
   */
  @Test
  @DisplayName("Test Builder from(SummaryCountRequest); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SummaryCountRequest)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSummaryCountRequest.builder();
    SummaryCountRequest instance = mock(SummaryCountRequest.class);
    when(instance.definitionIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).definitionIds();
    verify(instance).idSelectionOptions();
  }

  /**
   * Test Builder {@link Builder#idSelectionOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>When {@link IdSelectionOptions}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder idSelectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.idSelectionOptions(IdSelectionOptions)"})
  void testBuilderIdSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSummaryCountRequest.builder();
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);

    // Act and Assert
    assertSame(builderResult, builderResult.idSelectionOptions(idSelectionOptions));
    assertSame(idSelectionOptions, builderResult.build().idSelectionOptions());
  }

  /**
   * Test Json {@link Json#definitionIds()}.
   * <p>
   * Method under test: {@link Json#definitionIds()}
   */
  @Test
  @DisplayName("Test Json definitionIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.definitionIds()"})
  void testJsonDefinitionIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).definitionIds());
  }

  /**
   * Test Json {@link Json#idSelectionOptions()}.
   * <p>
   * Method under test: {@link Json#idSelectionOptions()}
   */
  @Test
  @DisplayName("Test Json idSelectionOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions Json.idSelectionOptions()"})
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).idSelectionOptions());
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
    assertNull(actualJson.idSelectionOptions);
    assertTrue(actualJson.definitionIds.isEmpty());
  }
}
