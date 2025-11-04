package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.application.ApplicationKind;
import org.junit.jupiter.api.Test;

class ImmutableSelectionFiltersDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSelectionFilters.Builder#addAllOmitApplicationKinds(Iterable)}
   */
  @Test
  void testBuilderAddAllOmitApplicationKinds() {
    // Arrange
    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    ImmutableSelectionFilters.Builder actualAddAllOmitApplicationKindsResult = builderResult
        .addAllOmitApplicationKinds(new ArrayList<>());

    // Assert
    assertTrue(actualAddAllOmitApplicationKindsResult.build().omitApplicationKinds().isEmpty());
    assertTrue(builderResult.build().omitApplicationKinds().isEmpty());
    assertSame(builderResult, actualAddAllOmitApplicationKindsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSelectionFilters.Builder#addAllOmitApplicationKinds(Iterable)}
   */
  @Test
  void testBuilderAddAllOmitApplicationKinds2() {
    // Arrange
    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act
    ImmutableSelectionFilters.Builder actualAddAllOmitApplicationKindsResult = builderResult
        .addAllOmitApplicationKinds(elements);

    // Assert
    Set<ApplicationKind> omitApplicationKindsResult = builderResult.build().omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertSame(builderResult, actualAddAllOmitApplicationKindsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSelectionFilters.Builder#addOmitApplicationKinds(ApplicationKind)}
   */
  @Test
  void testBuilderAddOmitApplicationKinds() {
    // Arrange
    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    ImmutableSelectionFilters.Builder actualAddOmitApplicationKindsResult = builderResult
        .addOmitApplicationKinds(ApplicationKind.IN_HOUSE);

    // Assert
    Set<ApplicationKind> omitApplicationKindsResult = actualAddOmitApplicationKindsResult.build()
        .omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    Set<ApplicationKind> omitApplicationKindsResult2 = builderResult.build().omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult2.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(omitApplicationKindsResult2.contains(ApplicationKind.IN_HOUSE));
    assertSame(builderResult, actualAddOmitApplicationKindsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSelectionFilters.Builder#addOmitApplicationKinds(ApplicationKind[])}
   */
  @Test
  void testBuilderAddOmitApplicationKinds2() {
    // Arrange
    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    ImmutableSelectionFilters.Builder actualAddOmitApplicationKindsResult = builderResult
        .addOmitApplicationKinds(ApplicationKind.IN_HOUSE);

    // Assert
    Set<ApplicationKind> omitApplicationKindsResult = actualAddOmitApplicationKindsResult.build()
        .omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    Set<ApplicationKind> omitApplicationKindsResult2 = builderResult.build().omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult2.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertTrue(omitApplicationKindsResult2.contains(ApplicationKind.IN_HOUSE));
    assertSame(builderResult, actualAddOmitApplicationKindsResult);
  }

  /**
   * Method under test: {@link ImmutableSelectionFilters.Builder#build()}
   */
  @Test
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableSelectionFilters.builder().build().omitApplicationKinds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSelectionFilters.Builder#from(SelectionFilters)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.from(SelectionFilters.NO_FILTERS));
  }

  /**
   * Method under test:
   * {@link ImmutableSelectionFilters.Builder#omitApplicationKinds(Iterable)}
   */
  @Test
  void testBuilderOmitApplicationKinds() {
    // Arrange
    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();

    // Act
    ImmutableSelectionFilters.Builder actualOmitApplicationKindsResult = builderResult
        .omitApplicationKinds(new ArrayList<>());

    // Assert
    assertTrue(actualOmitApplicationKindsResult.build().omitApplicationKinds().isEmpty());
    assertTrue(builderResult.build().omitApplicationKinds().isEmpty());
    assertSame(builderResult, actualOmitApplicationKindsResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSelectionFilters.Builder#omitApplicationKinds(Iterable)}
   */
  @Test
  void testBuilderOmitApplicationKinds2() {
    // Arrange
    ImmutableSelectionFilters.Builder builderResult = ImmutableSelectionFilters.builder();

    LinkedHashSet<ApplicationKind> elements = new LinkedHashSet<>();
    elements.add(ApplicationKind.IN_HOUSE);

    // Act
    ImmutableSelectionFilters.Builder actualOmitApplicationKindsResult = builderResult.omitApplicationKinds(elements);

    // Assert
    Set<ApplicationKind> omitApplicationKindsResult = builderResult.build().omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
    assertSame(builderResult, actualOmitApplicationKindsResult);
  }

  /**
   * Method under test: {@link ImmutableSelectionFilters#copyOf(SelectionFilters)}
   */
  @Test
  void testCopyOf() {
    // Arrange, Act and Assert
    assertTrue(ImmutableSelectionFilters.copyOf(SelectionFilters.NO_FILTERS).omitApplicationKinds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSelectionFilters#fromJson(ImmutableSelectionFilters.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange and Act
    ImmutableSelectionFilters actualFromJsonResult = ImmutableSelectionFilters
        .fromJson(new ImmutableSelectionFilters.Json());

    // Assert
    assertEquals(actualFromJsonResult.NO_FILTERS, actualFromJsonResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSelectionFilters#fromJson(ImmutableSelectionFilters.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ImmutableSelectionFilters.Json json = new ImmutableSelectionFilters.Json();
    json.setOmitApplicationKinds(null);

    // Act and Assert
    assertTrue(ImmutableSelectionFilters.fromJson(json).omitApplicationKinds().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSelectionFilters#fromJson(ImmutableSelectionFilters.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<ApplicationKind> omitApplicationKinds = new LinkedHashSet<>();
    omitApplicationKinds.add(ApplicationKind.IN_HOUSE);

    ImmutableSelectionFilters.Json json = new ImmutableSelectionFilters.Json();
    json.setOmitApplicationKinds(omitApplicationKinds);

    // Act and Assert
    Set<ApplicationKind> omitApplicationKindsResult = ImmutableSelectionFilters.fromJson(json).omitApplicationKinds();
    assertEquals(1, omitApplicationKindsResult.size());
    assertTrue(omitApplicationKindsResult.contains(ApplicationKind.IN_HOUSE));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSelectionFilters.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange, Act and Assert
    assertTrue((new ImmutableSelectionFilters.Json()).omitApplicationKinds.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSelectionFilters.Json#omitApplicationKinds()}
   */
  @Test
  void testJsonOmitApplicationKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSelectionFilters.Json()).omitApplicationKinds());
  }
}
