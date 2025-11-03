package org.finos.waltz.model.app_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return build applicationIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllApplicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplicationIds(Iterable); given one; then return build applicationIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllApplicationIds(Iterable)"})
  void testBuilderAddAllApplicationIds_givenOne_thenReturnBuildApplicationIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    ImmutableAppGroupBulkAddRequest buildResult = builderResult.addAllApplicationIds(elements).build();
    List<Long> applicationIdsResult = buildResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    List<Long> applicationIdsResult2 = builderResult.build().applicationIds();
    assertEquals(1, applicationIdsResult2.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertEquals(1L, applicationIdsResult2.get(0).longValue());
    List<Long> changeInitiativeIdsResult = buildResult.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    assertSame(changeInitiativeIdsResult, buildResult.unknownIdentifiers());
  }

  /**
   * Test Builder {@link Builder#addAllApplicationIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllApplicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplicationIds(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllApplicationIds(Iterable)"})
  void testBuilderAddAllApplicationIds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllApplicationIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllChangeInitiativeIds(Iterable)}.
   * <ul>
   *   <li>Then return build changeInitiativeIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChangeInitiativeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChangeInitiativeIds(Iterable); then return build changeInitiativeIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChangeInitiativeIds(Iterable)"})
  void testBuilderAddAllChangeInitiativeIds_thenReturnBuildChangeInitiativeIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    List<Long> changeInitiativeIdsResult = builderResult.addAllChangeInitiativeIds(elements)
        .build()
        .changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    List<Long> changeInitiativeIdsResult2 = builderResult.build().changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult2.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertEquals(1L, changeInitiativeIdsResult2.get(0).longValue());
  }

  /**
   * Test Builder {@link Builder#addAllChangeInitiativeIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllChangeInitiativeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllChangeInitiativeIds(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllChangeInitiativeIds(Iterable)"})
  void testBuilderAddAllChangeInitiativeIds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllChangeInitiativeIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllUnknownIdentifiers(Iterable)}.
   * <ul>
   *   <li>Then return build unknownIdentifiers size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllUnknownIdentifiers(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllUnknownIdentifiers(Iterable); then return build unknownIdentifiers size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllUnknownIdentifiers(Iterable)"})
  void testBuilderAddAllUnknownIdentifiers_thenReturnBuildUnknownIdentifiersSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    List<String> unknownIdentifiersResult = builderResult.addAllUnknownIdentifiers(elements)
        .build()
        .unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Elements", unknownIdentifiersResult.get(0));
    List<String> unknownIdentifiersResult2 = builderResult.build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult2.size());
    assertEquals("Elements", unknownIdentifiersResult2.get(0));
  }

  /**
   * Test Builder {@link Builder#addAllUnknownIdentifiers(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllUnknownIdentifiers(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllUnknownIdentifiers(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllUnknownIdentifiers(Iterable)"})
  void testBuilderAddAllUnknownIdentifiers_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllUnknownIdentifiers(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addApplicationIds(long)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addApplicationIds(long)}
   */
  @Test
  @DisplayName("Test Builder addApplicationIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Builder#addApplicationIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addApplicationIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Builder#addChangeInitiativeIds(long)}
   */
  @Test
  @DisplayName("Test Builder addChangeInitiativeIds(long) with 'element'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Builder#addChangeInitiativeIds(long[])}
   */
  @Test
  @DisplayName("Test Builder addChangeInitiativeIds(long[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addChangeInitiativeIds(long[])"})
  void testBuilderAddChangeInitiativeIdsWithElements() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act
    Builder actualAddChangeInitiativeIdsResult = builderResult.addChangeInitiativeIds(1L, -1L, 1L, -1L);

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
   * <p>
   * Method under test: {@link Builder#addUnknownIdentifiers(String)}
   */
  @Test
  @DisplayName("Test Builder addUnknownIdentifiers(String) with 'element'")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Builder#addUnknownIdentifiers(String[])}
   */
  @Test
  @DisplayName("Test Builder addUnknownIdentifiers(String[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return build applicationIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#applicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicationIds(Iterable); given one; then return build applicationIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationIds(Iterable)"})
  void testBuilderApplicationIds_givenOne_thenReturnBuildApplicationIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    ImmutableAppGroupBulkAddRequest buildResult = builderResult.applicationIds(elements).build();
    List<Long> applicationIdsResult = buildResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    List<Long> applicationIdsResult2 = builderResult.build().applicationIds();
    assertEquals(1, applicationIdsResult2.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertEquals(1L, applicationIdsResult2.get(0).longValue());
    List<Long> changeInitiativeIdsResult = buildResult.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    assertSame(changeInitiativeIdsResult, buildResult.unknownIdentifiers());
  }

  /**
   * Test Builder {@link Builder#applicationIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#applicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicationIds(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.applicationIds(Iterable)"})
  void testBuilderApplicationIds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppGroupBulkAddRequest Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableAppGroupBulkAddRequest.builder().build().applicationIds().isEmpty());
  }

  /**
   * Test Builder {@link Builder#changeInitiativeIds(Iterable)}.
   * <ul>
   *   <li>Then return build changeInitiativeIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#changeInitiativeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changeInitiativeIds(Iterable); then return build changeInitiativeIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changeInitiativeIds(Iterable)"})
  void testBuilderChangeInitiativeIds_thenReturnBuildChangeInitiativeIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act and Assert
    List<Long> changeInitiativeIdsResult = builderResult.changeInitiativeIds(elements).build().changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    List<Long> changeInitiativeIdsResult2 = builderResult.build().changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult2.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    assertEquals(1L, changeInitiativeIdsResult2.get(0).longValue());
  }

  /**
   * Test Builder {@link Builder#changeInitiativeIds(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#changeInitiativeIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder changeInitiativeIds(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.changeInitiativeIds(Iterable)"})
  void testBuilderChangeInitiativeIds_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeInitiativeIds(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(AppGroupBulkAddRequest)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>Then return build changeInitiativeIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupBulkAddRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupBulkAddRequest); given zero; then return build changeInitiativeIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupBulkAddRequest)"})
  void testBuilderFrom_givenZero_thenReturnBuildChangeInitiativeIdsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();
    Builder builderResult2 = ImmutableAppGroupBulkAddRequest.builder();
    builderResult2.addChangeInitiativeIds(0L);
    builderResult2.addApplicationIds(1L);
    ImmutableAppGroupBulkAddRequest instance = builderResult2.build();

    // Act and Assert
    ImmutableAppGroupBulkAddRequest buildResult = builderResult.from(instance).build();
    List<Long> changeInitiativeIdsResult = buildResult.changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(0L, changeInitiativeIdsResult.get(0).longValue());
    List<Long> applicationIdsResult = buildResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertTrue(buildResult.unknownIdentifiers().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(AppGroupBulkAddRequest)}.
   * <ul>
   *   <li>Then return build unknownIdentifiers is build changeInitiativeIds.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupBulkAddRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupBulkAddRequest); then return build unknownIdentifiers is build changeInitiativeIds")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupBulkAddRequest)"})
  void testBuilderFrom_thenReturnBuildUnknownIdentifiersIsBuildChangeInitiativeIds() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();
    Builder builderResult2 = ImmutableAppGroupBulkAddRequest.builder();
    builderResult2.addApplicationIds(1L);
    ImmutableAppGroupBulkAddRequest instance = builderResult2.build();

    // Act and Assert
    ImmutableAppGroupBulkAddRequest buildResult = builderResult.from(instance).build();
    List<Long> applicationIdsResult = buildResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    List<Long> changeInitiativeIdsResult = buildResult.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(changeInitiativeIdsResult, buildResult.unknownIdentifiers());
  }

  /**
   * Test Builder {@link Builder#from(AppGroupBulkAddRequest)}.
   * <ul>
   *   <li>Then return build unknownIdentifiers size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupBulkAddRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupBulkAddRequest); then return build unknownIdentifiers size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupBulkAddRequest)"})
  void testBuilderFrom_thenReturnBuildUnknownIdentifiersSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();
    Builder builderResult2 = ImmutableAppGroupBulkAddRequest.builder();
    builderResult2.addUnknownIdentifiers("applicationIds element");
    builderResult2.addApplicationIds(1L);
    ImmutableAppGroupBulkAddRequest instance = builderResult2.build();

    // Act and Assert
    ImmutableAppGroupBulkAddRequest buildResult = builderResult.from(instance).build();
    List<String> unknownIdentifiersResult = buildResult.unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("applicationIds element", unknownIdentifiersResult.get(0));
    List<Long> applicationIdsResult = buildResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    assertTrue(buildResult.changeInitiativeIds().isEmpty());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(AppGroupBulkAddRequest)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build applicationIds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(AppGroupBulkAddRequest)}
   */
  @Test
  @DisplayName("Test Builder from(AppGroupBulkAddRequest); when builder build; then return build applicationIds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(AppGroupBulkAddRequest)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildApplicationIdsEmpty() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();
    ImmutableAppGroupBulkAddRequest instance = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act and Assert
    ImmutableAppGroupBulkAddRequest buildResult = builderResult.from(instance).build();
    List<Long> applicationIdsResult = buildResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertEquals(instance, builderResult.build());
    assertSame(applicationIdsResult, buildResult.changeInitiativeIds());
    assertSame(applicationIdsResult, buildResult.unknownIdentifiers());
  }

  /**
   * Test Builder {@link Builder#unknownIdentifiers(Iterable)}.
   * <ul>
   *   <li>Then return build unknownIdentifiers size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#unknownIdentifiers(Iterable)}
   */
  @Test
  @DisplayName("Test Builder unknownIdentifiers(Iterable); then return build unknownIdentifiers size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.unknownIdentifiers(Iterable)"})
  void testBuilderUnknownIdentifiers_thenReturnBuildUnknownIdentifiersSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    List<String> unknownIdentifiersResult = builderResult.unknownIdentifiers(elements).build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Elements", unknownIdentifiersResult.get(0));
    List<String> unknownIdentifiersResult2 = builderResult.build().unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult2.size());
    assertEquals("Elements", unknownIdentifiersResult2.get(0));
  }

  /**
   * Test Builder {@link Builder#unknownIdentifiers(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#unknownIdentifiers(Iterable)}
   */
  @Test
  @DisplayName("Test Builder unknownIdentifiers(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.unknownIdentifiers(Iterable)"})
  void testBuilderUnknownIdentifiers_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.unknownIdentifiers(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#copyOf(AppGroupBulkAddRequest)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return applicationIds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#copyOf(AppGroupBulkAddRequest)}
   */
  @Test
  @DisplayName("Test copyOf(AppGroupBulkAddRequest); when builder build; then return applicationIds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.copyOf(AppGroupBulkAddRequest)"})
  void testCopyOf_whenBuilderBuild_thenReturnApplicationIdsEmpty() {
    // Arrange
    ImmutableAppGroupBulkAddRequest instance = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act
    ImmutableAppGroupBulkAddRequest actualCopyOfResult = ImmutableAppGroupBulkAddRequest.copyOf(instance);

    // Assert
    List<Long> applicationIdsResult = actualCopyOfResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualCopyOfResult.changeInitiativeIds());
    assertSame(applicationIdsResult, actualCopyOfResult.unknownIdentifiers());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}, and {@link ImmutableAppGroupBulkAddRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   *   <li>{@link ImmutableAppGroupBulkAddRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
      "int ImmutableAppGroupBulkAddRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableAppGroupBulkAddRequest buildResult = ImmutableAppGroupBulkAddRequest.builder().build();
    ImmutableAppGroupBulkAddRequest buildResult2 = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}, and {@link ImmutableAppGroupBulkAddRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   *   <li>{@link ImmutableAppGroupBulkAddRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
      "int ImmutableAppGroupBulkAddRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableAppGroupBulkAddRequest buildResult = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
      "int ImmutableAppGroupBulkAddRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();
    builderResult.addApplicationIds(1L);
    ImmutableAppGroupBulkAddRequest buildResult = builderResult.build();
    ImmutableAppGroupBulkAddRequest buildResult2 = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
      "int ImmutableAppGroupBulkAddRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();
    builderResult.addChangeInitiativeIds(1L);
    ImmutableAppGroupBulkAddRequest buildResult = builderResult.build();
    ImmutableAppGroupBulkAddRequest buildResult2 = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
      "int ImmutableAppGroupBulkAddRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableAppGroupBulkAddRequest.builder();
    builderResult.addUnknownIdentifiers("Element");
    ImmutableAppGroupBulkAddRequest buildResult = builderResult.build();
    ImmutableAppGroupBulkAddRequest buildResult2 = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
      "int ImmutableAppGroupBulkAddRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableAppGroupBulkAddRequest buildResult = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableAppGroupBulkAddRequest.equals(Object)",
      "int ImmutableAppGroupBulkAddRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableAppGroupBulkAddRequest buildResult = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableAppGroupBulkAddRequest");
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code Json}.</li>
   *   <li>Then return unknownIdentifiers size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add 'Json'; then return unknownIdentifiers size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.fromJson(Json)"})
  void testFromJson_givenArrayListAddJson_thenReturnUnknownIdentifiersSizeIsOne() {
    // Arrange
    ArrayList<String> unknownIdentifiers = new ArrayList<>();
    unknownIdentifiers.add("Json");

    Json json = new Json();
    json.setApplicationIds(null);
    json.setChangeInitiativeIds(null);
    json.setUnknownIdentifiers(unknownIdentifiers);

    // Act and Assert
    List<String> unknownIdentifiersResult = ImmutableAppGroupBulkAddRequest.fromJson(json).unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Json", unknownIdentifiersResult.get(0));
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return applicationIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add one; then return applicationIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.fromJson(Json)"})
  void testFromJson_givenArrayListAddOne_thenReturnApplicationIdsSizeIsOne() {
    // Arrange
    ArrayList<Long> applicationIds = new ArrayList<>();
    applicationIds.add(1L);

    Json json = new Json();
    json.setApplicationIds(applicationIds);
    json.setChangeInitiativeIds(null);
    json.setUnknownIdentifiers(null);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult = ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertEquals(1L, applicationIdsResult.get(0).longValue());
    List<Long> changeInitiativeIdsResult = actualFromJsonResult.changeInitiativeIds();
    assertTrue(changeInitiativeIdsResult.isEmpty());
    assertSame(changeInitiativeIdsResult, actualFromJsonResult.unknownIdentifiers());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return changeInitiativeIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList() add one; then return changeInitiativeIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.fromJson(Json)"})
  void testFromJson_givenArrayListAddOne_thenReturnChangeInitiativeIdsSizeIsOne() {
    // Arrange
    ArrayList<Long> changeInitiativeIds = new ArrayList<>();
    changeInitiativeIds.add(1L);

    Json json = new Json();
    json.setApplicationIds(null);
    json.setChangeInitiativeIds(changeInitiativeIds);
    json.setUnknownIdentifiers(null);

    // Act and Assert
    List<Long> changeInitiativeIdsResult = ImmutableAppGroupBulkAddRequest.fromJson(json).changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}.
   * <ul>
   *   <li>Then return unknownIdentifiers is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return unknownIdentifiers is ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.fromJson(Json)"})
  void testFromJson_thenReturnUnknownIdentifiersIsArrayList() {
    // Arrange
    ArrayList<String> unknownIdentifiers = new ArrayList<>();
    unknownIdentifiers.add("unknownIdentifiers element");
    unknownIdentifiers.add("Json");

    Json json = new Json();
    json.setApplicationIds(null);
    json.setChangeInitiativeIds(null);
    json.setUnknownIdentifiers(unknownIdentifiers);

    // Act and Assert
    assertEquals(unknownIdentifiers, ImmutableAppGroupBulkAddRequest.fromJson(json).unknownIdentifiers());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor) UnknownIdentifiers is {@code null}.</li>
   *   <li>Then return applicationIds Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor) UnknownIdentifiers is 'null'; then return applicationIds Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.fromJson(Json)"})
  void testFromJson_whenJsonUnknownIdentifiersIsNull_thenReturnApplicationIdsEmpty() {
    // Arrange
    Json json = new Json();
    json.setApplicationIds(null);
    json.setChangeInitiativeIds(null);
    json.setUnknownIdentifiers(null);

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult = ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualFromJsonResult.changeInitiativeIds());
    assertSame(applicationIdsResult, actualFromJsonResult.unknownIdentifiers());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return changeInitiativeIds is {@link Json} (default constructor) {@link Json#unknownIdentifiers}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return changeInitiativeIds is Json (default constructor) unknownIdentifiers")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnChangeInitiativeIdsIsJsonUnknownIdentifiers() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableAppGroupBulkAddRequest actualFromJsonResult = ImmutableAppGroupBulkAddRequest.fromJson(json);

    // Assert
    List<String> stringList = json.unknownIdentifiers;
    assertSame(stringList, actualFromJsonResult.changeInitiativeIds());
    assertSame(stringList, actualFromJsonResult.unknownIdentifiers());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAppGroupBulkAddRequest#toString()}
   *   <li>{@link ImmutableAppGroupBulkAddRequest#applicationIds()}
   *   <li>{@link ImmutableAppGroupBulkAddRequest#changeInitiativeIds()}
   *   <li>{@link ImmutableAppGroupBulkAddRequest#unknownIdentifiers()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List ImmutableAppGroupBulkAddRequest.applicationIds()",
      "List ImmutableAppGroupBulkAddRequest.changeInitiativeIds()", "String ImmutableAppGroupBulkAddRequest.toString()",
      "List ImmutableAppGroupBulkAddRequest.unknownIdentifiers()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableAppGroupBulkAddRequest buildResult = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    List<Long> actualApplicationIdsResult = buildResult.applicationIds();
    List<Long> actualChangeInitiativeIdsResult = buildResult.changeInitiativeIds();
    List<String> actualUnknownIdentifiersResult = buildResult.unknownIdentifiers();

    // Assert
    assertEquals("AppGroupBulkAddRequest{applicationIds=[], changeInitiativeIds=[], unknownIdentifiers=[]}",
        actualToStringResult);
    assertTrue(actualApplicationIdsResult.isEmpty());
    assertSame(actualApplicationIdsResult, actualChangeInitiativeIdsResult);
    assertSame(actualApplicationIdsResult, actualUnknownIdentifiersResult);
  }

  /**
   * Test Json {@link Json#applicationIds()}.
   * <p>
   * Method under test: {@link Json#applicationIds()}
   */
  @Test
  @DisplayName("Test Json applicationIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.applicationIds()"})
  void testJsonApplicationIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).applicationIds());
  }

  /**
   * Test Json {@link Json#changeInitiativeIds()}.
   * <p>
   * Method under test: {@link Json#changeInitiativeIds()}
   */
  @Test
  @DisplayName("Test Json changeInitiativeIds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.changeInitiativeIds()"})
  void testJsonChangeInitiativeIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).changeInitiativeIds());
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
    assertTrue(actualJson.applicationIds.isEmpty());
    assertTrue(actualJson.changeInitiativeIds.isEmpty());
    assertTrue(actualJson.unknownIdentifiers.isEmpty());
  }

  /**
   * Test Json {@link Json#unknownIdentifiers()}.
   * <p>
   * Method under test: {@link Json#unknownIdentifiers()}
   */
  @Test
  @DisplayName("Test Json unknownIdentifiers()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.unknownIdentifiers()"})
  void testJsonUnknownIdentifiers() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).unknownIdentifiers());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#withApplicationIds(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return applicationIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#withApplicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test withApplicationIds(Iterable) with 'Iterable'; given one; then return applicationIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.withApplicationIds(Iterable)"})
  void testWithApplicationIdsWithIterable_givenOne_thenReturnApplicationIdsSizeIsOne() {
    // Arrange
    ImmutableAppGroupBulkAddRequest buildResult = ImmutableAppGroupBulkAddRequest.builder().build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAppGroupBulkAddRequest actualWithApplicationIdsResult = buildResult.withApplicationIds(elements);

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
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#withApplicationIds(long[])}
   */
  @Test
  @DisplayName("Test withApplicationIds(long[]) with 'long[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.withApplicationIds(long[])"})
  void testWithApplicationIdsWithLong() {
    // Arrange
    ImmutableAppGroupBulkAddRequest buildResult = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act
    ImmutableAppGroupBulkAddRequest actualWithApplicationIdsResult = buildResult.withApplicationIds(1L, -1L, 1L, -1L);

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
   * Test {@link ImmutableAppGroupBulkAddRequest#withChangeInitiativeIds(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then return changeInitiativeIds size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#withChangeInitiativeIds(Iterable)}
   */
  @Test
  @DisplayName("Test withChangeInitiativeIds(Iterable) with 'Iterable'; then return changeInitiativeIds size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.withChangeInitiativeIds(Iterable)"})
  void testWithChangeInitiativeIdsWithIterable_thenReturnChangeInitiativeIdsSizeIsOne() {
    // Arrange
    ImmutableAppGroupBulkAddRequest buildResult = ImmutableAppGroupBulkAddRequest.builder().build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableAppGroupBulkAddRequest actualWithChangeInitiativeIdsResult = buildResult.withChangeInitiativeIds(elements);

    // Assert
    List<Long> changeInitiativeIdsResult = actualWithChangeInitiativeIdsResult.changeInitiativeIds();
    assertEquals(1, changeInitiativeIdsResult.size());
    assertEquals(1L, changeInitiativeIdsResult.get(0).longValue());
    List<Long> applicationIdsResult = actualWithChangeInitiativeIdsResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualWithChangeInitiativeIdsResult.unknownIdentifiers());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#withChangeInitiativeIds(long[])} with {@code long[]}.
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#withChangeInitiativeIds(long[])}
   */
  @Test
  @DisplayName("Test withChangeInitiativeIds(long[]) with 'long[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.withChangeInitiativeIds(long[])"})
  void testWithChangeInitiativeIdsWithLong() {
    // Arrange
    ImmutableAppGroupBulkAddRequest buildResult = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act
    ImmutableAppGroupBulkAddRequest actualWithChangeInitiativeIdsResult = buildResult.withChangeInitiativeIds(1L, -1L,
        1L, -1L);

    // Assert
    List<Long> changeInitiativeIdsResult = actualWithChangeInitiativeIdsResult.changeInitiativeIds();
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
   * Test {@link ImmutableAppGroupBulkAddRequest#withUnknownIdentifiers(Iterable)} with {@code Iterable}.
   * <ul>
   *   <li>Then return unknownIdentifiers size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#withUnknownIdentifiers(Iterable)}
   */
  @Test
  @DisplayName("Test withUnknownIdentifiers(Iterable) with 'Iterable'; then return unknownIdentifiers size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.withUnknownIdentifiers(Iterable)"})
  void testWithUnknownIdentifiersWithIterable_thenReturnUnknownIdentifiersSizeIsOne() {
    // Arrange
    ImmutableAppGroupBulkAddRequest buildResult = ImmutableAppGroupBulkAddRequest.builder().build();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act
    ImmutableAppGroupBulkAddRequest actualWithUnknownIdentifiersResult = buildResult.withUnknownIdentifiers(elements);

    // Assert
    List<String> unknownIdentifiersResult = actualWithUnknownIdentifiersResult.unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Elements", unknownIdentifiersResult.get(0));
    List<Long> applicationIdsResult = actualWithUnknownIdentifiersResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualWithUnknownIdentifiersResult.changeInitiativeIds());
  }

  /**
   * Test {@link ImmutableAppGroupBulkAddRequest#withUnknownIdentifiers(String[])} with {@code String[]}.
   * <p>
   * Method under test: {@link ImmutableAppGroupBulkAddRequest#withUnknownIdentifiers(String[])}
   */
  @Test
  @DisplayName("Test withUnknownIdentifiers(String[]) with 'String[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableAppGroupBulkAddRequest ImmutableAppGroupBulkAddRequest.withUnknownIdentifiers(String[])"})
  void testWithUnknownIdentifiersWithString() {
    // Arrange
    ImmutableAppGroupBulkAddRequest buildResult = ImmutableAppGroupBulkAddRequest.builder().build();

    // Act
    ImmutableAppGroupBulkAddRequest actualWithUnknownIdentifiersResult = buildResult.withUnknownIdentifiers("Elements");

    // Assert
    List<String> unknownIdentifiersResult = actualWithUnknownIdentifiersResult.unknownIdentifiers();
    assertEquals(1, unknownIdentifiersResult.size());
    assertEquals("Elements", unknownIdentifiersResult.get(0));
    List<Long> applicationIdsResult = actualWithUnknownIdentifiersResult.applicationIds();
    assertTrue(applicationIdsResult.isEmpty());
    assertSame(applicationIdsResult, actualWithUnknownIdentifiersResult.changeInitiativeIds());
  }
}
