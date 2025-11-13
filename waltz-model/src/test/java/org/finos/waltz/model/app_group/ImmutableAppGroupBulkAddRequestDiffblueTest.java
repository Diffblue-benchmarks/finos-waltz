package org.finos.waltz.model.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.finos.waltz.model.app_group.ImmutableAppGroupBulkAddRequest.Builder;
import org.finos.waltz.model.app_group.ImmutableAppGroupBulkAddRequest.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableAppGroupBulkAddRequestDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplicationIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return build applicationIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplicationIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllApplicationIds(Iterable); given one; then return build applicationIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplicationIds(Iterable)"})
  void testBuilderAddAllApplicationIds_givenOne_thenReturnBuildApplicationIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest =
        builderResult.addAllApplicationIds(elements).build();
    List<Long> applicationIdsResult = immutableAppGroupBulkAddRequest.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    List<Long> applicationIdsResult2 = builderResult.build().applicationIds();
    assertEquals(1, applicationIdsResult2.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertEquals(1L, applicationIdsResult2.get(0).longValue());
    List<Long> changeInitiativeIdsResult = immutableAppGroupBulkAddRequest.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    assertSame(changeInitiativeIdsResult, immutableAppGroupBulkAddRequest.unknownIdentifiers());
  }

  /**
   * Test Builder {@link Builder#addAllApplicationIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplicationIds(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplicationIds(Iterable)"})
  void testBuilderAddAllApplicationIds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualAddAllApplicationIdsResult =
        builderResult.addAllApplicationIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllApplicationIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllChangeInitiativeIds(Iterable)}.
   *
   * <ul>
   *   <li>Then return build changeInitiativeIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChangeInitiativeIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllChangeInitiativeIds(Iterable); then return build changeInitiativeIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChangeInitiativeIds(Iterable)"})
  void testBuilderAddAllChangeInitiativeIds_thenReturnBuildChangeInitiativeIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    List<Long> changeInitiativeIdsResult =
        builderResult.addAllChangeInitiativeIds(elements).build().changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    List<Long> changeInitiativeIdsResult2 = builderResult.build().changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult2.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertEquals(1L, changeInitiativeIdsResult2.get(0).longValue());
  }

  /**
   * Test Builder {@link Builder#addAllChangeInitiativeIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllChangeInitiativeIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllChangeInitiativeIds(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllChangeInitiativeIds(Iterable)"})
  void testBuilderAddAllChangeInitiativeIds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualAddAllChangeInitiativeIdsResult =
        builderResult.addAllChangeInitiativeIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllChangeInitiativeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllUnknownIdentifiers(Iterable)}.
   *
   * <ul>
   *   <li>Then return build unknownIdentifiers size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllUnknownIdentifiers(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllUnknownIdentifiers(Iterable); then return build unknownIdentifiers size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllUnknownIdentifiers(Iterable)"})
  void testBuilderAddAllUnknownIdentifiers_thenReturnBuildUnknownIdentifiersSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    List<String> unknownIdentifiersResult =
        builderResult.addAllUnknownIdentifiers(elements).build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Elements", unknownIdentifiersResult.get(0));
    List<String> unknownIdentifiersResult2 = builderResult.build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult2.size());
    assertEquals("Elements", unknownIdentifiersResult2.get(0));
  }

  /**
   * Test Builder {@link Builder#addAllUnknownIdentifiers(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllUnknownIdentifiers(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllUnknownIdentifiers(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllUnknownIdentifiers(Iterable)"})
  void testBuilderAddAllUnknownIdentifiers_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualAddAllUnknownIdentifiersResult =
        builderResult.addAllUnknownIdentifiers(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllUnknownIdentifiersResult);
  }

  /**
   * Test Builder {@link Builder#addApplicationIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addApplicationIds(long)}
   */
  @Test
  @DisplayName("Test Builder addApplicationIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplicationIds(long)"})
  void testBuilderAddApplicationIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualAddApplicationIdsResult = builderResult.addApplicationIds(1L);

    // Assert
    List<Long> applicationIdsResult = builderResult.build().applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertSame(builderResult, actualAddApplicationIdsResult);
  }

  /**
   * Test Builder {@link Builder#addApplicationIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addApplicationIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addApplicationIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplicationIds(long[])"})
  void testBuilderAddApplicationIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualAddApplicationIdsResult = builderResult.addApplicationIds(1L, -1L, 1L, -1L);

    // Assert
    List<Long> applicationIdsResult = builderResult.build().applicationIds();
    assertEquals(4, applicationIdsResult.size());
    assertEquals(-1L, applicationIdsResult.get(1).longValue());
    assertEquals(-1L, applicationIdsResult.get(3).longValue());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertEquals(1L, applicationIdsResult.get(2).longValue());
    assertSame(builderResult, actualAddApplicationIdsResult);
  }

  /**
   * Test Builder {@link Builder#addChangeInitiativeIds(long)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addChangeInitiativeIds(long)}
   */
  @Test
  @DisplayName("Test Builder addChangeInitiativeIds(long) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChangeInitiativeIds(long)"})
  void testBuilderAddChangeInitiativeIdsWithElement() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualAddChangeInitiativeIdsResult = builderResult.addChangeInitiativeIds(1L);

    // Assert
    List<Long> changeInitiativeIdsResult = builderResult.build().changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertSame(builderResult, actualAddChangeInitiativeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addChangeInitiativeIds(long[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addChangeInitiativeIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addChangeInitiativeIds(long[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addChangeInitiativeIds(long[])"})
  void testBuilderAddChangeInitiativeIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualAddChangeInitiativeIdsResult =
        builderResult.addChangeInitiativeIds(1L, -1L, 1L, -1L);

    // Assert
    List<Long> changeInitiativeIdsResult = builderResult.build().changeInitiativeIds();
    assertEquals(4, changeInitiativeIdsResult.size());
    assertEquals(-1L, changeInitiativeIdsResult.get(1).longValue());
    assertEquals(-1L, changeInitiativeIdsResult.get(3).longValue());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertEquals(1L, changeInitiativeIdsResult.get(2).longValue());
    assertSame(builderResult, actualAddChangeInitiativeIdsResult);
  }

  /**
   * Test Builder {@link Builder#addUnknownIdentifiers(String)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addUnknownIdentifiers(String)}
   */
  @Test
  @DisplayName("Test Builder addUnknownIdentifiers(String) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addUnknownIdentifiers(String)"})
  void testBuilderAddUnknownIdentifiersWithElement() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualAddUnknownIdentifiersResult = builderResult.addUnknownIdentifiers("Element");

    // Assert
    List<String> unknownIdentifiersResult = builderResult.build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Element", unknownIdentifiersResult.get(0));
    assertSame(builderResult, actualAddUnknownIdentifiersResult);
  }

  /**
   * Test Builder {@link Builder#addUnknownIdentifiers(String[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addUnknownIdentifiers(String[])}
   */
  @Test
  @DisplayName("Test Builder addUnknownIdentifiers(String[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addUnknownIdentifiers(String[])"})
  void testBuilderAddUnknownIdentifiersWithElements() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualAddUnknownIdentifiersResult = builderResult.addUnknownIdentifiers("Elements");

    // Assert
    List<String> unknownIdentifiersResult = builderResult.build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Elements", unknownIdentifiersResult.get(0));
    assertSame(builderResult, actualAddUnknownIdentifiersResult);
  }

  /**
   * Test Builder {@link Builder#applicationIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return build applicationIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder applicationIds(Iterable); given one; then return build applicationIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationIds(Iterable)"})
  void testBuilderApplicationIds_givenOne_thenReturnBuildApplicationIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest =
        builderResult.applicationIds(elements).build();
    List<Long> applicationIdsResult = immutableAppGroupBulkAddRequest.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    List<Long> applicationIdsResult2 = builderResult.build().applicationIds();
    assertEquals(1, applicationIdsResult2.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertEquals(1L, applicationIdsResult2.get(0).longValue());
    List<Long> changeInitiativeIdsResult = immutableAppGroupBulkAddRequest.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    assertSame(changeInitiativeIdsResult, immutableAppGroupBulkAddRequest.unknownIdentifiers());
  }

  /**
   * Test Builder {@link Builder#applicationIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicationIds(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationIds(Iterable)"})
  void testBuilderApplicationIds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualApplicationIdsResult = builderResult.applicationIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualApplicationIdsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableAppGroupBulkAddRequest Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAppGroupBulkAddRequest.builder().build().applicationIds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#changeInitiativeIds(Iterable)}.
   *
   * <ul>
   *   <li>Then return build changeInitiativeIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#changeInitiativeIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder changeInitiativeIds(Iterable); then return build changeInitiativeIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeInitiativeIds(Iterable)"})
  void testBuilderChangeInitiativeIds_thenReturnBuildChangeInitiativeIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    List<Long> changeInitiativeIdsResult =
        builderResult.changeInitiativeIds(elements).build().changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    List<Long> changeInitiativeIdsResult2 = builderResult.build().changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult2.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertEquals(1L, changeInitiativeIdsResult2.get(0).longValue());
  }

  /**
   * Test Builder {@link Builder#changeInitiativeIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#changeInitiativeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changeInitiativeIds(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.changeInitiativeIds(Iterable)"})
  void testBuilderChangeInitiativeIds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualChangeInitiativeIdsResult = builderResult.changeInitiativeIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualChangeInitiativeIdsResult);
  }

  /**
   * Test Builder {@link Builder#from(AppGroupBulkAddRequest)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>Then return build changeInitiativeIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AppGroupBulkAddRequest)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AppGroupBulkAddRequest); given zero; then return build changeInitiativeIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppGroupBulkAddRequest)"})
  void testBuilderFrom_givenZero_thenReturnBuildChangeInitiativeIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    Builder builderResult2 = ImmutableAppGroupBulkAddRequest.builder();
    builderResult2.addChangeInitiativeIds(0L);
    builderResult2.addApplicationIds(1L);
    ImmutableAppGroupBulkAddRequest instance = builderResult2.build();

    // Act and Assert
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest =
        builderResult.from(instance).build();
    List<Long> changeInitiativeIdsResult = immutableAppGroupBulkAddRequest.changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(0L, changeInitiativeIdsResult.get(0).longValue());
    List<Long> applicationIdsResult = immutableAppGroupBulkAddRequest.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertTrue(immutableAppGroupBulkAddRequest.unknownIdentifiers().isEmpty());
    ImmutableAppGroupBulkAddRequest actualImmutableAppGroupBulkAddRequest = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupBulkAddRequest);
  }

  /**
   * Test Builder {@link Builder#from(AppGroupBulkAddRequest)}.
   *
   * <ul>
   *   <li>Then return build unknownIdentifiers is build changeInitiativeIds.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AppGroupBulkAddRequest)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AppGroupBulkAddRequest); then return build unknownIdentifiers is build changeInitiativeIds")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppGroupBulkAddRequest)"})
  void testBuilderFrom_thenReturnBuildUnknownIdentifiersIsBuildChangeInitiativeIds() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    Builder builderResult2 = ImmutableAppGroupBulkAddRequest.builder();
    builderResult2.addApplicationIds(1L);
    ImmutableAppGroupBulkAddRequest instance = builderResult2.build();

    // Act and Assert
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest =
        builderResult.from(instance).build();
    List<Long> applicationIdsResult = immutableAppGroupBulkAddRequest.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    List<Long> changeInitiativeIdsResult = immutableAppGroupBulkAddRequest.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    ImmutableAppGroupBulkAddRequest actualImmutableAppGroupBulkAddRequest = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupBulkAddRequest);
    assertSame(changeInitiativeIdsResult, immutableAppGroupBulkAddRequest.unknownIdentifiers());
  }

  /**
   * Test Builder {@link Builder#from(AppGroupBulkAddRequest)}.
   *
   * <ul>
   *   <li>Then return build unknownIdentifiers size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AppGroupBulkAddRequest)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AppGroupBulkAddRequest); then return build unknownIdentifiers size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppGroupBulkAddRequest)"})
  void testBuilderFrom_thenReturnBuildUnknownIdentifiersSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    Builder builderResult2 = ImmutableAppGroupBulkAddRequest.builder();
    builderResult2.addUnknownIdentifiers("applicationIds element");
    builderResult2.addApplicationIds(1L);
    ImmutableAppGroupBulkAddRequest instance = builderResult2.build();

    // Act and Assert
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest =
        builderResult.from(instance).build();
    List<String> unknownIdentifiersResult = immutableAppGroupBulkAddRequest.unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("applicationIds element", unknownIdentifiersResult.get(0));
    List<Long> applicationIdsResult = immutableAppGroupBulkAddRequest.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertTrue(immutableAppGroupBulkAddRequest.changeInitiativeIds().isEmpty());
    ImmutableAppGroupBulkAddRequest actualImmutableAppGroupBulkAddRequest = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupBulkAddRequest);
  }

  /**
   * Test Builder {@link Builder#from(AppGroupBulkAddRequest)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return build applicationIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(AppGroupBulkAddRequest)}
   */
  @Test
  @DisplayName(
      "Test Builder from(AppGroupBulkAddRequest); when builder build; then return build applicationIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(AppGroupBulkAddRequest)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildApplicationIdsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();
    ImmutableAppGroupBulkAddRequest instance = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act and Assert
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest =
        builderResult.from(instance).build();
    List<Long> applicationIdsResult = immutableAppGroupBulkAddRequest.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    ImmutableAppGroupBulkAddRequest actualImmutableAppGroupBulkAddRequest = builderResult.build();
    assertEquals(instance, actualImmutableAppGroupBulkAddRequest);
    assertSame(applicationIdsResult, immutableAppGroupBulkAddRequest.changeInitiativeIds());
    assertSame(applicationIdsResult, immutableAppGroupBulkAddRequest.unknownIdentifiers());
  }

  /**
   * Test Builder {@link Builder#unknownIdentifiers(Iterable)}.
   *
   * <ul>
   *   <li>Then return build unknownIdentifiers size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#unknownIdentifiers(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder unknownIdentifiers(Iterable); then return build unknownIdentifiers size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.unknownIdentifiers(Iterable)"})
  void testBuilderUnknownIdentifiers_thenReturnBuildUnknownIdentifiersSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    List<String> unknownIdentifiersResult =
        builderResult.unknownIdentifiers(elements).build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Elements", unknownIdentifiersResult.get(0));
    List<String> unknownIdentifiersResult2 = builderResult.build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult2.size());
    assertEquals("Elements", unknownIdentifiersResult2.get(0));
  }

  /**
   * Test Builder {@link Builder#unknownIdentifiers(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#unknownIdentifiers(Iterable)}
   */
  @Test
  @DisplayName("Test Builder unknownIdentifiers(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.unknownIdentifiers(Iterable)"})
  void testBuilderUnknownIdentifiers_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualUnknownIdentifiersResult = builderResult.unknownIdentifiers(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualUnknownIdentifiersResult);
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#copyOf(AppGroupBulkAddRequest)}.
   *
   * <ul>
   *   <li>When builder build.
   *   <li>Then return applicationIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#copyOf(AppGroupBulkAddRequest)}
   */
  @Test
  @DisplayName(
      "Test copyOf(AppGroupBulkAddRequest); when builder build; then return applicationIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.copyOf(AppGroupBulkAddRequest)"
  })
  void testCopyOf_whenBuilderBuild_thenReturnApplicationIdsEmpty() {
    // Arrange
    ImmutableAppGroupBulkAddRequest instance = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act
    ImmutableAppGroupBulkAddRequest actualCopyOfResult =
        ImmutableAppGroupBulkAddRequest.copyOf(instance);

    // Assert
    List<Long> applicationIdsResult = actualCopyOfResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualCopyOfResult.changeInitiativeIds());
    assertSame(applicationIdsResult, actualCopyOfResult.unknownIdentifiers());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}, and {@link
   * ImmutableAppGroupBulkAddRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   *   <li>{@link ImmutableAppGroupBulkAddRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
    "int ImmutableAppGroupBulkAddRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest =
        ImmutableAppGroupBulkAddRequest.builder().build();
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest2 =
        ImmutableAppGroupBulkAddRequest.builder().build();

    // Act and Assert
    assertEquals(immutableAppGroupBulkAddRequest, immutableAppGroupBulkAddRequest2);
    assertEquals(
        immutableAppGroupBulkAddRequest.hashCode(), immutableAppGroupBulkAddRequest2.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}, and {@link
   * ImmutableAppGroupBulkAddRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   *   <li>{@link ImmutableAppGroupBulkAddRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
    "int ImmutableAppGroupBulkAddRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest =
        ImmutableAppGroupBulkAddRequest.builder().build();

    // Act and Assert
    assertEquals(immutableAppGroupBulkAddRequest, immutableAppGroupBulkAddRequest);
    int expectedHashCodeResult = immutableAppGroupBulkAddRequest.hashCode();
    assertEquals(expectedHashCodeResult, immutableAppGroupBulkAddRequest.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
    "int ImmutableAppGroupBulkAddRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();
    builderResult.addApplicationIds(1L);

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableAppGroupBulkAddRequest.builder().build());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
    "int ImmutableAppGroupBulkAddRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();
    builderResult.addChangeInitiativeIds(1L);

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableAppGroupBulkAddRequest.builder().build());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
    "int ImmutableAppGroupBulkAddRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();
    builderResult.addUnknownIdentifiers("Element");

    // Act and Assert
    assertNotEquals(builderResult.build(), ImmutableAppGroupBulkAddRequest.builder().build());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
    "int ImmutableAppGroupBulkAddRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableAppGroupBulkAddRequest.builder().build(), null);
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
    "int ImmutableAppGroupBulkAddRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableAppGroupBulkAddRequest.builder().build(),
        "Different type to ImmutableAppGroupBulkAddRequest");
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Json}.
   *   <li>Then return applicationIds is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add 'Json'; then return applicationIds is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnApplicationIdsIsArrayList() {
    // Arrange
    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);
    applicationIds.add(1L);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);

    ArrayList<String> unknownIdentifiers = new ArrayList<>();
    unknownIdentifiers.add("Json");

    Json json = new Json();
    json.setApplicationIds(applicationIds);
    json.setChangeInitiativeIds(changeInitiativeIds);
    json.setUnknownIdentifiers(unknownIdentifiers);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult =
        ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<String> unknownIdentifiersResult = actualFromJsonResult.unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Json", unknownIdentifiersResult.get(0));
    List<Long> changeInitiativeIdsResult = actualFromJsonResult.changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertEquals(applicationIds, actualFromJsonResult.applicationIds());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Json}.
   *   <li>Then return applicationIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add 'Json'; then return applicationIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnApplicationIdsSizeIsOne() {
    // Arrange
    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);

    ArrayList<String> unknownIdentifiers = new ArrayList<>();
    unknownIdentifiers.add("Json");

    Json json = new Json();
    json.setApplicationIds(applicationIds);
    json.setChangeInitiativeIds(changeInitiativeIds);
    json.setUnknownIdentifiers(unknownIdentifiers);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult =
        ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<String> unknownIdentifiersResult = actualFromJsonResult.unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Json", unknownIdentifiersResult.get(0));
    List<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    List<Long> changeInitiativeIdsResult = actualFromJsonResult.changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return changeInitiativeIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return changeInitiativeIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.fromJson(Json)"
  })
  void testFromJson_thenReturnChangeInitiativeIdsEmpty() {
    // Arrange
    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    ArrayList<String> unknownIdentifiers = new ArrayList<>();
    unknownIdentifiers.add("Json");

    Json json = new Json();
    json.setApplicationIds(applicationIds);
    json.setChangeInitiativeIds(null);
    json.setUnknownIdentifiers(unknownIdentifiers);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult =
        ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<String> unknownIdentifiersResult = actualFromJsonResult.unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Json", unknownIdentifiersResult.get(0));
    List<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertTrue(actualFromJsonResult.changeInitiativeIds().isEmpty());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ApplicationIds is {@code null}.
   *   <li>Then return applicationIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ApplicationIds is 'null'; then return applicationIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.fromJson(Json)"
  })
  void testFromJson_whenJsonApplicationIdsIsNull_thenReturnApplicationIdsEmpty() {
    // Arrange
    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);

    ArrayList<String> unknownIdentifiers = new ArrayList<>();
    unknownIdentifiers.add("Json");

    Json json = new Json();
    json.setApplicationIds(null);
    json.setChangeInitiativeIds(changeInitiativeIds);
    json.setUnknownIdentifiers(unknownIdentifiers);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult =
        ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<String> unknownIdentifiersResult = actualFromJsonResult.unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Json", unknownIdentifiersResult.get(0));
    List<Long> changeInitiativeIdsResult = actualFromJsonResult.changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertTrue(actualFromJsonResult.applicationIds().isEmpty());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) UnknownIdentifiers is {@code null}.
   *   <li>Then return unknownIdentifiers Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) UnknownIdentifiers is 'null'; then return unknownIdentifiers Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.fromJson(Json)"
  })
  void testFromJson_whenJsonUnknownIdentifiersIsNull_thenReturnUnknownIdentifiersEmpty() {
    // Arrange
    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);

    Json json = new Json();
    json.setApplicationIds(applicationIds);
    json.setChangeInitiativeIds(changeInitiativeIds);
    json.setUnknownIdentifiers(null);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult =
        ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    List<Long> changeInitiativeIdsResult = actualFromJsonResult.changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertTrue(actualFromJsonResult.unknownIdentifiers().isEmpty());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor).
   *   <li>Then return changeInitiativeIds is {@link Json} (default constructor) {@link
   *       Json#unknownIdentifiers}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor); then return changeInitiativeIds is Json (default constructor) unknownIdentifiers")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.fromJson(Json)"
  })
  void testFromJson_whenJson_thenReturnChangeInitiativeIdsIsJsonUnknownIdentifiers() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult =
        ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<String> stringList = json.unknownIdentifiers;
    assertSame(stringList, actualFromJsonResult.changeInitiativeIds());
    assertSame(stringList, actualFromJsonResult.unknownIdentifiers());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableAppGroupBulkAddRequest#toString()}
   *   <li>{@link ImmutableAppGroupBulkAddRequest#applicationIds()}
   *   <li>{@link ImmutableAppGroupBulkAddRequest#changeInitiativeIds()}
   *   <li>{@link ImmutableAppGroupBulkAddRequest#unknownIdentifiers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableAppGroupBulkAddRequest.applicationIds()",
    "List ImmutableAppGroupBulkAddRequest.changeInitiativeIds()",
    "String ImmutableAppGroupBulkAddRequest.toString()",
    "List ImmutableAppGroupBulkAddRequest.unknownIdentifiers()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest =
        ImmutableAppGroupBulkAddRequest.builder().build();

    // Act
    String actualToStringResult = immutableAppGroupBulkAddRequest.toString();
    List<Long> actualApplicationIdsResult = immutableAppGroupBulkAddRequest.applicationIds();
    List<Long> actualChangeInitiativeIdsResult =
        immutableAppGroupBulkAddRequest.changeInitiativeIds();
    List<String> actualUnknownIdentifiersResult =
        immutableAppGroupBulkAddRequest.unknownIdentifiers();

    // Assert
    assertEquals(
        "AppGroupBulkAddRequest{applicationIds=[], changeInitiativeIds=[], unknownIdentifiers=[]}",
        actualToStringResult);
    assertTrue(actualApplicationIdsResult.isEmpty());
    assertSame(actualApplicationIdsResult, actualChangeInitiativeIdsResult);
    assertSame(actualApplicationIdsResult, actualUnknownIdentifiersResult);
  }

  /**
   * Test Json {@link Json#applicationIds()}.
   *
   * <p>Method under test: {@link Json#applicationIds()}
   */
  @Test
  @DisplayName("Test Json applicationIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.applicationIds()"})
  void testJsonApplicationIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applicationIds());
  }

  /**
   * Test Json {@link Json#changeInitiativeIds()}.
   *
   * <p>Method under test: {@link Json#changeInitiativeIds()}
   */
  @Test
  @DisplayName("Test Json changeInitiativeIds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.changeInitiativeIds()"})
  void testJsonChangeInitiativeIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().changeInitiativeIds());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertTrue(actualJson.applicationIds.isEmpty());
    assertTrue(actualJson.changeInitiativeIds.isEmpty());
    assertTrue(actualJson.unknownIdentifiers.isEmpty());
  }

  /**
   * Test Json {@link Json#unknownIdentifiers()}.
   *
   * <p>Method under test: {@link Json#unknownIdentifiers()}
   */
  @Test
  @DisplayName("Test Json unknownIdentifiers()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.unknownIdentifiers()"})
  void testJsonUnknownIdentifiers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().unknownIdentifiers());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#withApplicationIds(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return applicationIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#withApplicationIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withApplicationIds(Iterable) with 'Iterable'; given one; then return applicationIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.withApplicationIds(Iterable)"
  })
  void testWithApplicationIdsWithIterable_givenOne_thenReturnApplicationIdsSizeIsOne() {
    // Arrange
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest =
        ImmutableAppGroupBulkAddRequest.builder().build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAppGroupBulkAddRequest actualWithApplicationIdsResult =
        immutableAppGroupBulkAddRequest.withApplicationIds(elements);

    // Assert
    List<Long> applicationIdsResult = actualWithApplicationIdsResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    List<Long> changeInitiativeIdsResult = actualWithApplicationIdsResult.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    assertSame(changeInitiativeIdsResult, actualWithApplicationIdsResult.unknownIdentifiers());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#withApplicationIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#withApplicationIds(long[])}
   */
  @Test
  @DisplayName("Test withApplicationIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.withApplicationIds(long[])"
  })
  void testWithApplicationIdsWithLong() {
    // Arrange and Act
    ImmutableAppGroupBulkAddRequest actualWithApplicationIdsResult =
        ImmutableAppGroupBulkAddRequest.builder().build().withApplicationIds(1L, -1L, 1L, -1L);

    // Assert
    List<Long> applicationIdsResult = actualWithApplicationIdsResult.applicationIds();
    assertEquals(4, applicationIdsResult.size());
    assertEquals(-1L, applicationIdsResult.get(1).longValue());
    assertEquals(-1L, applicationIdsResult.get(3).longValue());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertEquals(1L, applicationIdsResult.get(2).longValue());
    List<Long> changeInitiativeIdsResult = actualWithApplicationIdsResult.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    assertSame(changeInitiativeIdsResult, actualWithApplicationIdsResult.unknownIdentifiers());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#withChangeInitiativeIds(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Then return changeInitiativeIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#withChangeInitiativeIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withChangeInitiativeIds(Iterable) with 'Iterable'; then return changeInitiativeIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.withChangeInitiativeIds(Iterable)"
  })
  void testWithChangeInitiativeIdsWithIterable_thenReturnChangeInitiativeIdsSizeIsOne() {
    // Arrange
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest =
        ImmutableAppGroupBulkAddRequest.builder().build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAppGroupBulkAddRequest actualWithChangeInitiativeIdsResult =
        immutableAppGroupBulkAddRequest.withChangeInitiativeIds(elements);

    // Assert
    List<Long> changeInitiativeIdsResult =
        actualWithChangeInitiativeIdsResult.changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    List<Long> applicationIdsResult = actualWithChangeInitiativeIdsResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualWithChangeInitiativeIdsResult.unknownIdentifiers());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#withChangeInitiativeIds(long[])} with {@code
   * long[]}.
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#withChangeInitiativeIds(long[])}
   */
  @Test
  @DisplayName("Test withChangeInitiativeIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.withChangeInitiativeIds(long[])"
  })
  void testWithChangeInitiativeIdsWithLong() {
    // Arrange and Act
    ImmutableAppGroupBulkAddRequest actualWithChangeInitiativeIdsResult =
        ImmutableAppGroupBulkAddRequest.builder().build().withChangeInitiativeIds(1L, -1L, 1L, -1L);

    // Assert
    List<Long> changeInitiativeIdsResult =
        actualWithChangeInitiativeIdsResult.changeInitiativeIds();
    assertEquals(4, changeInitiativeIdsResult.size());
    assertEquals(-1L, changeInitiativeIdsResult.get(1).longValue());
    assertEquals(-1L, changeInitiativeIdsResult.get(3).longValue());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertEquals(1L, changeInitiativeIdsResult.get(2).longValue());
    List<Long> applicationIdsResult = actualWithChangeInitiativeIdsResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualWithChangeInitiativeIdsResult.unknownIdentifiers());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#withUnknownIdentifiers(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Then return unknownIdentifiers size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#withUnknownIdentifiers(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withUnknownIdentifiers(Iterable) with 'Iterable'; then return unknownIdentifiers size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.withUnknownIdentifiers(Iterable)"
  })
  void testWithUnknownIdentifiersWithIterable_thenReturnUnknownIdentifiersSizeIsOne() {
    // Arrange
    ImmutableAppGroupBulkAddRequest immutableAppGroupBulkAddRequest =
        ImmutableAppGroupBulkAddRequest.builder().build();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableAppGroupBulkAddRequest actualWithUnknownIdentifiersResult =
        immutableAppGroupBulkAddRequest.withUnknownIdentifiers(elements);

    // Assert
    List<String> unknownIdentifiersResult = actualWithUnknownIdentifiersResult.unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Elements", unknownIdentifiersResult.get(0));
    List<Long> applicationIdsResult = actualWithUnknownIdentifiersResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualWithUnknownIdentifiersResult.changeInitiativeIds());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#withUnknownIdentifiers(String[])} with {@code
   * String[]}.
   *
   * <p>Method under test: {@link ImmutableAppGroupBulkAddRequest#withUnknownIdentifiers(String[])}
   */
  @Test
  @DisplayName("Test withUnknownIdentifiers(String[]) with 'String[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.withUnknownIdentifiers(String[])"
  })
  void testWithUnknownIdentifiersWithString() {
    // Arrange and Act
    ImmutableAppGroupBulkAddRequest actualWithUnknownIdentifiersResult =
        ImmutableAppGroupBulkAddRequest.builder().build().withUnknownIdentifiers("Elements");

    // Assert
    List<String> unknownIdentifiersResult = actualWithUnknownIdentifiersResult.unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Elements", unknownIdentifiersResult.get(0));
    List<Long> applicationIdsResult = actualWithUnknownIdentifiersResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualWithUnknownIdentifiersResult.changeInitiativeIds());
  }
}
