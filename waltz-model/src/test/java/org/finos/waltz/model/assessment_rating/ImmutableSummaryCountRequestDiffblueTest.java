package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.IdSelectionOptions;
import org.junit.jupiter.api.Test;

class ImmutableSummaryCountRequestDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest.Builder#addAllDefinitionIds(Iterable)}
   */
  @Test
  void testBuilderAddAllDefinitionIds() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDefinitionIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest.Builder#addAllDefinitionIds(Iterable)}
   */
  @Test
  void testBuilderAddAllDefinitionIds2() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDefinitionIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest.Builder#addDefinitionIds(long)}
   */
  @Test
  void testBuilderAddDefinitionIds() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDefinitionIds(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest.Builder#addDefinitionIds(long[])}
   */
  @Test
  void testBuilderAddDefinitionIds2() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addDefinitionIds(1L, -2L, 1L, -2L));
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest.Builder#definitionIds(Iterable)}
   */
  @Test
  void testBuilderDefinitionIds() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.definitionIds(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest.Builder#definitionIds(Iterable)}
   */
  @Test
  void testBuilderDefinitionIds2() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.definitionIds(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest.Builder#from(SummaryCountRequest)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();
    SummaryCountRequest instance = mock(SummaryCountRequest.class);
    when(instance.definitionIds()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableSummaryCountRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionIds();
    verify(instance).idSelectionOptions();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest.Builder#from(SummaryCountRequest)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    SummaryCountRequest instance = mock(SummaryCountRequest.class);
    when(instance.definitionIds()).thenReturn(resultLongSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableSummaryCountRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).definitionIds();
    verify(instance).idSelectionOptions();
    Set<Long> definitionIdsResult = builderResult.build().definitionIds();
    assertEquals(1, definitionIdsResult.size());
    assertTrue(definitionIdsResult.contains(-2L));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest.Builder#from(SummaryCountRequest)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();
    SummaryCountRequest instance = mock(SummaryCountRequest.class);
    when(instance.definitionIds()).thenThrow(new IllegalStateException("instance"));
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).definitionIds();
    verify(instance).idSelectionOptions();
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest.Builder#idSelectionOptions(IdSelectionOptions)}
   */
  @Test
  void testBuilderIdSelectionOptions() {
    // Arrange
    ImmutableSummaryCountRequest.Builder builderResult = ImmutableSummaryCountRequest.builder();
    IdSelectionOptions idSelectionOptions = mock(IdSelectionOptions.class);

    // Act and Assert
    assertSame(builderResult, builderResult.idSelectionOptions(idSelectionOptions));
    assertSame(idSelectionOptions, builderResult.build().idSelectionOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest#copyOf(SummaryCountRequest)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SummaryCountRequest instance = mock(SummaryCountRequest.class);
    when(instance.definitionIds()).thenReturn(new HashSet<>());
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableSummaryCountRequest actualCopyOfResult = ImmutableSummaryCountRequest.copyOf(instance);

    // Assert
    verify(instance).definitionIds();
    verify(instance).idSelectionOptions();
    assertTrue(actualCopyOfResult.definitionIds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest#copyOf(SummaryCountRequest)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);
    SummaryCountRequest instance = mock(SummaryCountRequest.class);
    when(instance.definitionIds()).thenReturn(resultLongSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableSummaryCountRequest actualCopyOfResult = ImmutableSummaryCountRequest.copyOf(instance);

    // Assert
    verify(instance).definitionIds();
    verify(instance).idSelectionOptions();
    Set<Long> definitionIdsResult = actualCopyOfResult.definitionIds();
    assertEquals(1, definitionIdsResult.size());
    assertTrue(definitionIdsResult.contains(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest#copyOf(SummaryCountRequest)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(-2L);
    resultLongSet.add(1L);
    SummaryCountRequest instance = mock(SummaryCountRequest.class);
    when(instance.definitionIds()).thenReturn(resultLongSet);
    when(instance.idSelectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    ImmutableSummaryCountRequest actualCopyOfResult = ImmutableSummaryCountRequest.copyOf(instance);

    // Assert
    verify(instance).definitionIds();
    verify(instance).idSelectionOptions();
    assertEquals(resultLongSet, actualCopyOfResult.definitionIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest#fromJson(ImmutableSummaryCountRequest.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSummaryCountRequest.Json json = new ImmutableSummaryCountRequest.Json();
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));

    // Act
    ImmutableSummaryCountRequest actualFromJsonResult = ImmutableSummaryCountRequest.fromJson(json);

    // Assert
    Set<Long> definitionIdsResult = actualFromJsonResult.definitionIds();
    assertTrue(definitionIdsResult.isEmpty());
    assertSame(json.definitionIds, definitionIdsResult);
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest#fromJson(ImmutableSummaryCountRequest.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<Long> definitionIds = new LinkedHashSet<>();
    definitionIds.add(1L);

    ImmutableSummaryCountRequest.Json json = new ImmutableSummaryCountRequest.Json();
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));
    json.setDefinitionIds(definitionIds);

    // Act
    ImmutableSummaryCountRequest actualFromJsonResult = ImmutableSummaryCountRequest.fromJson(json);

    // Assert
    Set<Long> definitionIdsResult = actualFromJsonResult.definitionIds();
    assertEquals(1, definitionIdsResult.size());
    assertTrue(definitionIdsResult.contains(1L));
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest#fromJson(ImmutableSummaryCountRequest.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<Long> definitionIds = new LinkedHashSet<>();
    definitionIds.add(-2L);
    definitionIds.add(1L);

    ImmutableSummaryCountRequest.Json json = new ImmutableSummaryCountRequest.Json();
    json.setIdSelectionOptions(mock(IdSelectionOptions.class));
    json.setDefinitionIds(definitionIds);

    // Act
    ImmutableSummaryCountRequest actualFromJsonResult = ImmutableSummaryCountRequest.fromJson(json);

    // Assert
    assertEquals(definitionIds, actualFromJsonResult.definitionIds());
    IdSelectionOptions expectedIdSelectionOptionsResult = json.idSelectionOptions;
    assertSame(expectedIdSelectionOptionsResult, actualFromJsonResult.idSelectionOptions());
  }

  /**
   * Method under test: {@link ImmutableSummaryCountRequest.Json#definitionIds()}
   */
  @Test
  void testJsonDefinitionIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSummaryCountRequest.Json()).definitionIds());
  }

  /**
   * Method under test:
   * {@link ImmutableSummaryCountRequest.Json#idSelectionOptions()}
   */
  @Test
  void testJsonIdSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSummaryCountRequest.Json()).idSelectionOptions());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSummaryCountRequest.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSummaryCountRequest.Json actualJson = new ImmutableSummaryCountRequest.Json();

    // Assert
    assertNull(actualJson.idSelectionOptions);
    assertTrue(actualJson.definitionIds.isEmpty());
  }
}
