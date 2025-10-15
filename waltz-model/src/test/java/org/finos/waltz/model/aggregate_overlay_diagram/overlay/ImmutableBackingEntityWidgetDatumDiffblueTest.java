package org.finos.waltz.model.aggregate_overlay_diagram.overlay;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableBackingEntityWidgetDatum.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.overlay.ImmutableBackingEntityWidgetDatum.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBackingEntityWidgetDatumDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllBackingEntityReferences(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllBackingEntityReferences(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllBackingEntityReferences(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllBackingEntityReferences(Iterable)"})
  void testBuilderAddAllBackingEntityReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act
    Builder actualAddAllBackingEntityReferencesResult =
        builderResult.addAllBackingEntityReferences(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllBackingEntityReferencesResult);
  }

  /**
   * Test Builder {@link Builder#addBackingEntityReferences(EntityReference)} with {@code element}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addBackingEntityReferences(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder addBackingEntityReferences(EntityReference) with 'element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addBackingEntityReferences(EntityReference)"})
  void testBuilderAddBackingEntityReferencesWithElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act
    Builder actualAddBackingEntityReferencesResult =
        builderResult.addBackingEntityReferences(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAddBackingEntityReferencesResult);
  }

  /**
   * Test Builder {@link Builder#addBackingEntityReferences(EntityReference[])} with {@code
   * elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addBackingEntityReferences(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test Builder addBackingEntityReferences(EntityReference[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addBackingEntityReferences(EntityReference[])"})
  void testBuilderAddBackingEntityReferencesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act
    Builder actualAddBackingEntityReferencesResult =
        builderResult.addBackingEntityReferences(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAddBackingEntityReferencesResult);
  }

  /**
   * Test Builder {@link Builder#backingEntityReferences(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#backingEntityReferences(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder backingEntityReferences(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.backingEntityReferences(Iterable)"})
  void testBuilderBackingEntityReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act
    Builder actualBackingEntityReferencesResult =
        builderResult.backingEntityReferences(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualBackingEntityReferencesResult);
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
  @MethodsUnderTest({"ImmutableBackingEntityWidgetDatum Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableBackingEntityWidgetDatum actualImmutableBackingEntityWidgetDatum =
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build();

    // Assert
    assertEquals("42", actualImmutableBackingEntityWidgetDatum.cellExternalId());
    assertTrue(actualImmutableBackingEntityWidgetDatum.backingEntityReferences().isEmpty());
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then builder build cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test Builder cellExternalId(String); when '42'; then builder build cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId_when42_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(BackingEntityWidgetDatum)} with {@code
   * BackingEntityWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(BackingEntityWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(BackingEntityWidgetDatum) with 'BackingEntityWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BackingEntityWidgetDatum)"})
  void testBuilderFromWithBackingEntityWidgetDatum() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();
    ImmutableBackingEntityWidgetDatum instance =
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBackingEntityWidgetDatum actualImmutableBackingEntityWidgetDatum =
        builderResult.build();
    assertEquals(instance, actualImmutableBackingEntityWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BackingEntityWidgetDatum)} with {@code
   * BackingEntityWidgetDatum}.
   *
   * <p>Method under test: {@link Builder#from(BackingEntityWidgetDatum)}
   */
  @Test
  @DisplayName("Test Builder from(BackingEntityWidgetDatum) with 'BackingEntityWidgetDatum'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BackingEntityWidgetDatum)"})
  void testBuilderFromWithBackingEntityWidgetDatum2() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    Builder builderResult2 = ImmutableBackingEntityWidgetDatum.builder();
    builderResult2.addBackingEntityReferences(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableBackingEntityWidgetDatum instance = builderResult2.cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBackingEntityWidgetDatum actualImmutableBackingEntityWidgetDatum =
        builderResult.build();
    assertEquals(instance, actualImmutableBackingEntityWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();
    ImmutableBackingEntityWidgetDatum instance =
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    Builder actualFromResult = builderResult.from((CellExternalIdProvider) instance);

    // Assert
    ImmutableBackingEntityWidgetDatum actualImmutableBackingEntityWidgetDatum =
        builderResult.build();
    assertEquals(instance, actualImmutableBackingEntityWidgetDatum);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(CellExternalIdProvider)} with {@code CellExternalIdProvider}.
   *
   * <ul>
   *   <li>Then builder build cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(CellExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(CellExternalIdProvider) with 'CellExternalIdProvider'; then builder build cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(CellExternalIdProvider)"})
  void testBuilderFromWithCellExternalIdProvider_thenBuilderBuildCellExternalIdIs42() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();

    CellExternalIdProvider instance = mock(CellExternalIdProvider.class);
    when(instance.cellExternalId()).thenReturn("42");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).cellExternalId();
    assertEquals("42", builderResult.build().cellExternalId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#copyOf(BackingEntityWidgetDatum)}.
   *
   * <ul>
   *   <li>When builder cellExternalId {@code 42} build.
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableBackingEntityWidgetDatum#copyOf(BackingEntityWidgetDatum)}
   */
  @Test
  @DisplayName(
      "Test copyOf(BackingEntityWidgetDatum); when builder cellExternalId '42' build; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetDatum ImmutableBackingEntityWidgetDatum.copyOf(BackingEntityWidgetDatum)"
  })
  void testCopyOf_whenBuilderCellExternalId42Build_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableBackingEntityWidgetDatum instance =
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableBackingEntityWidgetDatum actualCopyOfResult =
        ImmutableBackingEntityWidgetDatum.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertTrue(actualCopyOfResult.backingEntityReferences().isEmpty());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#equals(Object)}, and {@link
   * ImmutableBackingEntityWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBackingEntityWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableBackingEntityWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntityWidgetDatum.equals(Object)",
    "int ImmutableBackingEntityWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableBackingEntityWidgetDatum immutableBackingEntityWidgetDatum =
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build();
    ImmutableBackingEntityWidgetDatum immutableBackingEntityWidgetDatum2 =
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableBackingEntityWidgetDatum, immutableBackingEntityWidgetDatum2);
    assertEquals(
        immutableBackingEntityWidgetDatum.hashCode(),
        immutableBackingEntityWidgetDatum2.hashCode());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#equals(Object)}, and {@link
   * ImmutableBackingEntityWidgetDatum#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBackingEntityWidgetDatum#equals(Object)}
   *   <li>{@link ImmutableBackingEntityWidgetDatum#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntityWidgetDatum.equals(Object)",
    "int ImmutableBackingEntityWidgetDatum.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableBackingEntityWidgetDatum immutableBackingEntityWidgetDatum =
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build();

    // Act and Assert
    assertEquals(immutableBackingEntityWidgetDatum, immutableBackingEntityWidgetDatum);
    int expectedHashCodeResult = immutableBackingEntityWidgetDatum.hashCode();
    assertEquals(expectedHashCodeResult, immutableBackingEntityWidgetDatum.hashCode());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntityWidgetDatum.equals(Object)",
    "int ImmutableBackingEntityWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableBackingEntityWidgetDatum.builder();
    builderResult.addBackingEntityReferences(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableBackingEntityWidgetDatum immutableBackingEntityWidgetDatum =
        builderResult.cellExternalId("42").build();

    // Act and Assert
    assertNotEquals(
        immutableBackingEntityWidgetDatum,
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntityWidgetDatum.equals(Object)",
    "int ImmutableBackingEntityWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableBackingEntityWidgetDatum immutableBackingEntityWidgetDatum =
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("Cell External Id").build();

    // Act and Assert
    assertNotEquals(
        immutableBackingEntityWidgetDatum,
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntityWidgetDatum.equals(Object)",
    "int ImmutableBackingEntityWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build(), null);
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetDatum#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntityWidgetDatum.equals(Object)",
    "int ImmutableBackingEntityWidgetDatum.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build(),
        "Different type to ImmutableBackingEntityWidgetDatum");
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) BackingEntityReferences is {@link
   *       HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) BackingEntityReferences is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetDatum ImmutableBackingEntityWidgetDatum.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonBackingEntityReferencesIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setBackingEntityReferences(new HashSet<>());

    // Act
    ImmutableBackingEntityWidgetDatum actualFromJsonResult =
        ImmutableBackingEntityWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.backingEntityReferences().isEmpty());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return backingEntityReferences Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return backingEntityReferences Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetDatum ImmutableBackingEntityWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnBackingEntityReferencesEmpty() {
    // Arrange
    Json json = new Json();
    json.setCellExternalId("Json");
    json.setBackingEntityReferences(null);

    // Act
    ImmutableBackingEntityWidgetDatum actualFromJsonResult =
        ImmutableBackingEntityWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertTrue(actualFromJsonResult.backingEntityReferences().isEmpty());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return backingEntityReferences is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return backingEntityReferences is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetDatum ImmutableBackingEntityWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnBackingEntityReferencesIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<EntityReference> backingEntityReferences = new LinkedHashSet<>();
    backingEntityReferences.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    backingEntityReferences.add(mock(EntityReference.class));

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setBackingEntityReferences(backingEntityReferences);

    // Act
    ImmutableBackingEntityWidgetDatum actualFromJsonResult =
        ImmutableBackingEntityWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(backingEntityReferences, actualFromJsonResult.backingEntityReferences());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return backingEntityReferences size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetDatum#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return backingEntityReferences size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetDatum ImmutableBackingEntityWidgetDatum.fromJson(Json)"
  })
  void testFromJson_thenReturnBackingEntityReferencesSizeIsOne() {
    // Arrange
    LinkedHashSet<EntityReference> backingEntityReferences = new LinkedHashSet<>();
    backingEntityReferences.add(mock(EntityReference.class));

    Json json = new Json();
    json.setCellExternalId("Json");
    json.setBackingEntityReferences(backingEntityReferences);

    // Act
    ImmutableBackingEntityWidgetDatum actualFromJsonResult =
        ImmutableBackingEntityWidgetDatum.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals(1, actualFromJsonResult.backingEntityReferences().size());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBackingEntityWidgetDatum#toString()}
   *   <li>{@link ImmutableBackingEntityWidgetDatum#backingEntityReferences()}
   *   <li>{@link ImmutableBackingEntityWidgetDatum#cellExternalId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableBackingEntityWidgetDatum.backingEntityReferences()",
    "String ImmutableBackingEntityWidgetDatum.cellExternalId()",
    "String ImmutableBackingEntityWidgetDatum.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableBackingEntityWidgetDatum immutableBackingEntityWidgetDatum =
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    String actualToStringResult = immutableBackingEntityWidgetDatum.toString();
    Set<EntityReference> actualBackingEntityReferencesResult =
        immutableBackingEntityWidgetDatum.backingEntityReferences();

    // Assert
    assertEquals("42", immutableBackingEntityWidgetDatum.cellExternalId());
    assertEquals(
        "BackingEntityWidgetDatum{cellExternalId=42, backingEntityReferences=[]}",
        actualToStringResult);
    assertTrue(actualBackingEntityReferencesResult.isEmpty());
  }

  /**
   * Test Json {@link Json#backingEntityReferences()}.
   *
   * <p>Method under test: {@link Json#backingEntityReferences()}
   */
  @Test
  @DisplayName("Test Json backingEntityReferences()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.backingEntityReferences()"})
  void testJsonBackingEntityReferences() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().backingEntityReferences());
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   *
   * <p>Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cellExternalId());
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
    assertNull(actualJson.cellExternalId);
    assertTrue(actualJson.backingEntityReferences.isEmpty());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#withBackingEntityReferences(EntityReference[])}
   * with {@code EntityReference[]}.
   *
   * <p>Method under test: {@link
   * ImmutableBackingEntityWidgetDatum#withBackingEntityReferences(EntityReference[])}
   */
  @Test
  @DisplayName("Test withBackingEntityReferences(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetDatum ImmutableBackingEntityWidgetDatum.withBackingEntityReferences(EntityReference[])"
  })
  void testWithBackingEntityReferencesWithEntityReference() {
    // Arrange
    ImmutableBackingEntityWidgetDatum immutableBackingEntityWidgetDatum =
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableBackingEntityWidgetDatum actualWithBackingEntityReferencesResult =
        immutableBackingEntityWidgetDatum.withBackingEntityReferences(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals("42", actualWithBackingEntityReferencesResult.cellExternalId());
    assertEquals(1, actualWithBackingEntityReferencesResult.backingEntityReferences().size());
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return builder cellExternalId {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return builder cellExternalId '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetDatum ImmutableBackingEntityWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnBuilderCellExternalId42Build() {
    // Arrange
    ImmutableBackingEntityWidgetDatum immutableBackingEntityWidgetDatum =
        ImmutableBackingEntityWidgetDatum.builder().cellExternalId("42").build();

    // Act
    ImmutableBackingEntityWidgetDatum actualWithCellExternalIdResult =
        immutableBackingEntityWidgetDatum.withCellExternalId("42");

    // Assert
    assertSame(immutableBackingEntityWidgetDatum, actualWithCellExternalIdResult);
  }

  /**
   * Test {@link ImmutableBackingEntityWidgetDatum#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntityWidgetDatum#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntityWidgetDatum ImmutableBackingEntityWidgetDatum.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableBackingEntityWidgetDatum actualWithCellExternalIdResult =
        ImmutableBackingEntityWidgetDatum.builder()
            .cellExternalId("cellExternalId")
            .build()
            .withCellExternalId("42");

    // Assert
    assertEquals("42", actualWithCellExternalIdResult.cellExternalId());
    assertTrue(actualWithCellExternalIdResult.backingEntityReferences().isEmpty());
  }
}
