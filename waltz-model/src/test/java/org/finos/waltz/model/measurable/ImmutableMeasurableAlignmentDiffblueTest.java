package org.finos.waltz.model.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.measurable.ImmutableMeasurableAlignment.Builder;
import org.finos.waltz.model.measurable.ImmutableMeasurableAlignment.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableAlignmentDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplicationIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplicationIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllApplicationIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplicationIds(Iterable)"})
  void testBuilderAddAllApplicationIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualAddAllApplicationIdsResult = builderResult.addAllApplicationIds(elements);

    // Assert
    assertSame(builderResult, actualAddAllApplicationIdsResult);
  }

  /**
   * Test Builder {@link Builder#addAllApplicationIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplicationIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplicationIds(Iterable)"})
  void testBuilderAddAllApplicationIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act
    Builder actualAddAllApplicationIdsResult =
        builderResult.addAllApplicationIds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllApplicationIdsResult);
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
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act
    Builder actualAddApplicationIdsResult = builderResult.addApplicationIds(1L);

    // Assert
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
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act
    Builder actualAddApplicationIdsResult = builderResult.addApplicationIds(1L, -2L, 1L, -2L);

    // Assert
    assertSame(builderResult, actualAddApplicationIdsResult);
  }

  /**
   * Test Builder {@link Builder#applicationIds(Iterable)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicationIds(Iterable); given one; when LinkedHashSet() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationIds(Iterable)"})
  void testBuilderApplicationIds_givenOne_whenLinkedHashSetAddOne() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    Builder actualApplicationIdsResult = builderResult.applicationIds(elements);

    // Assert
    assertSame(builderResult, actualApplicationIdsResult);
  }

  /**
   * Test Builder {@link Builder#applicationIds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationIds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicationIds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationIds(Iterable)"})
  void testBuilderApplicationIds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

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
  @MethodsUnderTest({"ImmutableMeasurableAlignment Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurable measurable =
        ImmutableMeasurable.builder()
            .categoryId(1L)
            .concrete(true)
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .externalParentId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .organisationalUnitId(1L)
            .parentId(1L)
            .provenance("Provenance")
            .build();
    ImmutableMeasurableAlignment actualImmutableMeasurableAlignment =
        actualBuilderResult.measurable(measurable).build();

    // Assert
    assertTrue(actualImmutableMeasurableAlignment.applicationIds().isEmpty());
    assertSame(measurable, actualImmutableMeasurableAlignment.measurable());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableAlignment)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableAlignment)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableAlignment)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    Builder builderResult2 = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurableAlignment instance =
        builderResult2
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableAlignment actualImmutableMeasurableAlignment = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableAlignment);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableAlignment)}.
   *
   * <ul>
   *   <li>Given minus two.
   *   <li>When builder addApplicationIds minus two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(MeasurableAlignment)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MeasurableAlignment); given minus two; when builder addApplicationIds minus two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableAlignment)"})
  void testBuilderFrom_givenMinusTwo_whenBuilderAddApplicationIdsMinusTwo() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    Builder builderResult2 = ImmutableMeasurableAlignment.builder();
    builderResult2.addApplicationIds(-2L);
    ImmutableMeasurableAlignment instance =
        builderResult2
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableAlignment actualImmutableMeasurableAlignment = builderResult.build();
    assertEquals(instance, actualImmutableMeasurableAlignment);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#measurable(Measurable)}.
   *
   * <ul>
   *   <li>When {@link ImmutableMeasurable.Json} (default constructor).
   *   <li>Then builder build measurable is {@link ImmutableMeasurable.Json} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurable(Measurable)}
   */
  @Test
  @DisplayName(
      "Test Builder measurable(Measurable); when Json (default constructor); then builder build measurable is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurable(Measurable)"})
  void testBuilderMeasurable_whenJson_thenBuilderBuildMeasurableIsJson() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurable.Json measurable = new ImmutableMeasurable.Json();

    // Act
    Builder actualMeasurableResult = builderResult.measurable(measurable);

    // Assert
    assertSame(measurable, builderResult.build().measurable());
    assertSame(builderResult, actualMeasurableResult);
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#copyOf(MeasurableAlignment)}.
   *
   * <ul>
   *   <li>Then measurable return {@link ImmutableMeasurable}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableAlignment#copyOf(MeasurableAlignment)}
   */
  @Test
  @DisplayName("Test copyOf(MeasurableAlignment); then measurable return ImmutableMeasurable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableAlignment ImmutableMeasurableAlignment.copyOf(MeasurableAlignment)"
  })
  void testCopyOf_thenMeasurableReturnImmutableMeasurable() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurableAlignment instance =
        builderResult
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutableMeasurableAlignment actualCopyOfResult = ImmutableMeasurableAlignment.copyOf(instance);

    // Assert
    Measurable measurableResult = actualCopyOfResult.measurable();
    assertTrue(measurableResult instanceof ImmutableMeasurable);
    assertEquals("2020-03-01", measurableResult.lastUpdatedBy());
    assertEquals("Name", measurableResult.name());
    assertEquals("Provenance", measurableResult.provenance());
    assertEquals("The characteristics of someone or something", measurableResult.description());
    assertEquals(0, measurableResult.position());
    assertEquals(1L, measurableResult.organisationalUnitId().longValue());
    assertEquals(1L, measurableResult.categoryId());
    assertEquals(EntityKind.ALL, measurableResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, measurableResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.applicationIds().isEmpty());
    assertTrue(measurableResult.concrete());
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#equals(Object)}, and {@link
   * ImmutableMeasurableAlignment#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableAlignment#equals(Object)}
   *   <li>{@link ImmutableMeasurableAlignment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableAlignment.equals(Object)",
    "int ImmutableMeasurableAlignment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurableAlignment immutableMeasurableAlignment =
        builderResult
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurableAlignment immutableMeasurableAlignment2 =
        builderResult2
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableAlignment, immutableMeasurableAlignment2);
    assertEquals(immutableMeasurableAlignment.hashCode(), immutableMeasurableAlignment2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#equals(Object)}, and {@link
   * ImmutableMeasurableAlignment#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableAlignment#equals(Object)}
   *   <li>{@link ImmutableMeasurableAlignment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableAlignment.equals(Object)",
    "int ImmutableMeasurableAlignment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurableAlignment immutableMeasurableAlignment =
        builderResult
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableAlignment, immutableMeasurableAlignment);
    int expectedHashCodeResult = immutableMeasurableAlignment.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableAlignment.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableAlignment.equals(Object)",
    "int ImmutableMeasurableAlignment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();
    builderResult.addApplicationIds(1L);
    ImmutableMeasurableAlignment immutableMeasurableAlignment =
        builderResult
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableAlignment.builder();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableAlignment,
        builderResult2
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableAlignment.equals(Object)",
    "int ImmutableMeasurableAlignment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurableAlignment immutableMeasurableAlignment =
        builderResult
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(2L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableAlignment.builder();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableAlignment,
        builderResult2
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableAlignment.equals(Object)",
    "int ImmutableMeasurableAlignment.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableAlignment.equals(Object)",
    "int ImmutableMeasurableAlignment.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build(),
        "Different type to ImmutableMeasurableAlignment");
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) ApplicationIds is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableAlignment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) ApplicationIds is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableAlignment ImmutableMeasurableAlignment.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonApplicationIdsIsHashSet() {
    // Arrange
    Json json = new Json();
    ImmutableMeasurable.Json measurable = new ImmutableMeasurable.Json();
    json.setMeasurable(measurable);
    json.setApplicationIds(new HashSet<>());

    // Act
    ImmutableMeasurableAlignment actualFromJsonResult = ImmutableMeasurableAlignment.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.applicationIds().isEmpty());
    assertSame(measurable, actualFromJsonResult.measurable());
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add one.
   *   <li>Then return applicationIds size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableAlignment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given LinkedHashSet() add one; then return applicationIds size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableAlignment ImmutableMeasurableAlignment.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddOne_thenReturnApplicationIdsSizeIsOne() {
    // Arrange
    LinkedHashSet<Long> applicationIds = new LinkedHashSet<>();
    applicationIds.add(1L);

    Json json = new Json();
    json.setMeasurable(new ImmutableMeasurable.Json());
    json.setApplicationIds(applicationIds);

    // Act
    ImmutableMeasurableAlignment actualFromJsonResult = ImmutableMeasurableAlignment.fromJson(json);

    // Assert
    Set<Long> applicationIdsResult = actualFromJsonResult.applicationIds();
    assertEquals(1, applicationIdsResult.size());
    assertTrue(applicationIdsResult.contains(1L));
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return applicationIds is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableAlignment#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return applicationIds is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableAlignment ImmutableMeasurableAlignment.fromJson(Json)"})
  void testFromJson_thenReturnApplicationIdsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<Long> applicationIds = new LinkedHashSet<>();
    applicationIds.add(-1L);
    applicationIds.add(1L);

    Json json = new Json();
    json.setMeasurable(new ImmutableMeasurable.Json());
    json.setApplicationIds(applicationIds);

    // Act
    ImmutableMeasurableAlignment actualFromJsonResult = ImmutableMeasurableAlignment.fromJson(json);

    // Assert
    assertEquals(applicationIds, actualFromJsonResult.applicationIds());
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) ApplicationIds is {@code null}.
   *   <li>Then return applicationIds Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableAlignment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) ApplicationIds is 'null'; then return applicationIds Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableAlignment ImmutableMeasurableAlignment.fromJson(Json)"})
  void testFromJson_whenJsonApplicationIdsIsNull_thenReturnApplicationIdsEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableMeasurable.Json measurable = new ImmutableMeasurable.Json();
    json.setMeasurable(measurable);
    json.setApplicationIds(null);

    // Act
    ImmutableMeasurableAlignment actualFromJsonResult = ImmutableMeasurableAlignment.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.applicationIds().isEmpty());
    assertSame(measurable, actualFromJsonResult.measurable());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableAlignment#toString()}
   *   <li>{@link ImmutableMeasurableAlignment#applicationIds()}
   *   <li>{@link ImmutableMeasurableAlignment#measurable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableMeasurableAlignment.applicationIds()",
    "Measurable ImmutableMeasurableAlignment.measurable()",
    "String ImmutableMeasurableAlignment.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurableAlignment immutableMeasurableAlignment =
        builderResult
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableMeasurableAlignment.toString();
    Set<Long> actualApplicationIdsResult = immutableMeasurableAlignment.applicationIds();

    // Assert
    assertTrue(immutableMeasurableAlignment.measurable() instanceof ImmutableMeasurable);
    assertEquals(
        "MeasurableAlignment{measurable=Measurable{id=1, name=Name, parentId=1, externalId=42, entityLifecycleStatus"
            + "=ACTIVE, externalParentId=42, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01, provenance"
            + "=Provenance, position=0, categoryId=1, concrete=true, organisationalUnitId=1, kind=ALL}, applicationIds"
            + "=[]}",
        actualToStringResult);
    assertTrue(actualApplicationIdsResult.isEmpty());
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
  @MethodsUnderTest({"Set Json.applicationIds()"})
  void testJsonApplicationIds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applicationIds());
  }

  /**
   * Test Json {@link Json#measurable()}.
   *
   * <p>Method under test: {@link Json#measurable()}
   */
  @Test
  @DisplayName("Test Json measurable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Measurable Json.measurable()"})
  void testJsonMeasurable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurable());
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
    assertNull(actualJson.measurable);
    assertTrue(actualJson.applicationIds.isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#withApplicationIds(Iterable)} with {@code Iterable}.
   *
   * <ul>
   *   <li>Then measurable return {@link ImmutableMeasurable}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableAlignment#withApplicationIds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withApplicationIds(Iterable) with 'Iterable'; then measurable return ImmutableMeasurable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableAlignment ImmutableMeasurableAlignment.withApplicationIds(Iterable)"
  })
  void testWithApplicationIdsWithIterable_thenMeasurableReturnImmutableMeasurable() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurableAlignment immutableMeasurableAlignment =
        builderResult
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    LinkedHashSet<Long> elements = new LinkedHashSet<>();
    elements.add(1L);

    // Act
    ImmutableMeasurableAlignment actualWithApplicationIdsResult =
        immutableMeasurableAlignment.withApplicationIds(elements);

    // Assert
    Measurable measurableResult = actualWithApplicationIdsResult.measurable();
    assertTrue(measurableResult instanceof ImmutableMeasurable);
    assertEquals("2020-03-01", measurableResult.lastUpdatedBy());
    assertEquals("Name", measurableResult.name());
    assertEquals("Provenance", measurableResult.provenance());
    assertEquals("The characteristics of someone or something", measurableResult.description());
    assertEquals(0, measurableResult.position());
    assertEquals(1L, measurableResult.organisationalUnitId().longValue());
    assertEquals(1L, measurableResult.categoryId());
    assertEquals(EntityKind.ALL, measurableResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, measurableResult.entityLifecycleStatus());
    assertTrue(measurableResult.concrete());
    assertEquals(elements, actualWithApplicationIdsResult.applicationIds());
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#withApplicationIds(long[])} with {@code long[]}.
   *
   * <p>Method under test: {@link ImmutableMeasurableAlignment#withApplicationIds(long[])}
   */
  @Test
  @DisplayName("Test withApplicationIds(long[]) with 'long[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableAlignment ImmutableMeasurableAlignment.withApplicationIds(long[])"
  })
  void testWithApplicationIdsWithLong() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();

    // Act
    ImmutableMeasurableAlignment actualWithApplicationIdsResult =
        builderResult
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build()
            .withApplicationIds(1L, -1L, 1L, -1L);

    // Assert
    Measurable measurableResult = actualWithApplicationIdsResult.measurable();
    assertTrue(measurableResult instanceof ImmutableMeasurable);
    assertEquals("2020-03-01", measurableResult.lastUpdatedBy());
    assertEquals("Name", measurableResult.name());
    assertEquals("Provenance", measurableResult.provenance());
    assertEquals("The characteristics of someone or something", measurableResult.description());
    assertEquals(0, measurableResult.position());
    assertEquals(1L, measurableResult.organisationalUnitId().longValue());
    assertEquals(1L, measurableResult.categoryId());
    Set<Long> applicationIdsResult = actualWithApplicationIdsResult.applicationIds();
    assertEquals(2, applicationIdsResult.size());
    assertEquals(EntityKind.ALL, measurableResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, measurableResult.entityLifecycleStatus());
    assertTrue(applicationIdsResult.contains(-1L));
    assertTrue(applicationIdsResult.contains(1L));
    assertTrue(measurableResult.concrete());
  }

  /**
   * Test {@link ImmutableMeasurableAlignment#withMeasurable(Measurable)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableAlignment#withMeasurable(Measurable)}
   */
  @Test
  @DisplayName("Test withMeasurable(Measurable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableAlignment ImmutableMeasurableAlignment.withMeasurable(Measurable)"
  })
  void testWithMeasurable() {
    // Arrange
    Builder builderResult = ImmutableMeasurableAlignment.builder();
    ImmutableMeasurableAlignment immutableMeasurableAlignment =
        builderResult
            .measurable(
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build())
            .build();

    // Act
    ImmutableMeasurableAlignment actualWithMeasurableResult =
        immutableMeasurableAlignment.withMeasurable(
            ImmutableMeasurable.builder()
                .categoryId(1L)
                .concrete(true)
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .externalParentId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .organisationalUnitId(1L)
                .parentId(1L)
                .provenance("Provenance")
                .build());

    // Assert
    assertEquals(immutableMeasurableAlignment, actualWithMeasurableResult);
  }
}
