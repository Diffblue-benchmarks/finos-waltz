package org.finos.waltz.model.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.measurable.ImmutableMeasurableCategoryAlignment.Builder;
import org.finos.waltz.model.measurable.ImmutableMeasurableCategoryAlignment.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableCategoryAlignmentDiffblueTest {
  /**
   * Test Builder {@link Builder#addAlignments(MeasurableAlignment)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableMeasurableAlignment.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAlignments(MeasurableAlignment)}
   */
  @Test
  @DisplayName(
      "Test Builder addAlignments(MeasurableAlignment) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAlignments(MeasurableAlignment)"})
  void testBuilderAddAlignmentsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act
    Builder actualAddAlignmentsResult =
        builderResult.addAlignments(new ImmutableMeasurableAlignment.Json());

    // Assert
    assertSame(builderResult, actualAddAlignmentsResult);
  }

  /**
   * Test Builder {@link Builder#addAlignments(MeasurableAlignment[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableMeasurableAlignment.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAlignments(MeasurableAlignment[])}
   */
  @Test
  @DisplayName(
      "Test Builder addAlignments(MeasurableAlignment[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAlignments(MeasurableAlignment[])"})
  void testBuilderAddAlignmentsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act
    Builder actualAddAlignmentsResult =
        builderResult.addAlignments(new ImmutableMeasurableAlignment.Json());

    // Assert
    assertSame(builderResult, actualAddAlignmentsResult);
  }

  /**
   * Test Builder {@link Builder#addAllAlignments(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllAlignments(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAlignments(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllAlignments(Iterable)"})
  void testBuilderAddAllAlignments_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act
    Builder actualAddAllAlignmentsResult = builderResult.addAllAlignments(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllAlignmentsResult);
  }

  /**
   * Test Builder {@link Builder#alignments(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#alignments(Iterable)}
   */
  @Test
  @DisplayName("Test Builder alignments(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.alignments(Iterable)"})
  void testBuilderAlignments_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act
    Builder actualAlignmentsResult = builderResult.alignments(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAlignmentsResult);
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
  @MethodsUnderTest({"ImmutableMeasurableCategoryAlignment Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableMeasurableCategoryAlignment.builder();
    ImmutableEntityReference categoryReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableMeasurableCategoryAlignment actualImmutableMeasurableCategoryAlignment =
        actualBuilderResult.categoryReference(categoryReference).build();

    // Assert
    assertTrue(actualImmutableMeasurableCategoryAlignment.alignments().isEmpty());
    assertSame(categoryReference, actualImmutableMeasurableCategoryAlignment.categoryReference());
  }

  /**
   * Test Builder {@link Builder#categoryReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#categoryReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder categoryReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.categoryReference(EntityReference)"})
  void testBuilderCategoryReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    EntityReference categoryReference = mock(EntityReference.class);

    // Act
    Builder actualCategoryReferenceResult = builderResult.categoryReference(categoryReference);

    // Assert
    assertSame(builderResult, actualCategoryReferenceResult);
    assertSame(categoryReference, builderResult.build().categoryReference());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableCategoryAlignment)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableCategoryAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableCategoryAlignment)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableCategoryAlignment)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    Builder builderResult2 = ImmutableMeasurableCategoryAlignment.builder();
    ImmutableMeasurableCategoryAlignment instance =
        builderResult2
            .categoryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableMeasurableCategoryAlignment actualImmutableMeasurableCategoryAlignment =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableCategoryAlignment);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableMeasurableCategoryAlignment#copyOf(MeasurableCategoryAlignment)}.
   *
   * <ul>
   *   <li>Then categoryReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableCategoryAlignment#copyOf(MeasurableCategoryAlignment)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableCategoryAlignment); then categoryReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategoryAlignment ImmutableMeasurableCategoryAlignment.copyOf(MeasurableCategoryAlignment)"
  })
  void testCopyOf_thenCategoryReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    ImmutableMeasurableCategoryAlignment instance =
        builderResult
            .categoryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableMeasurableCategoryAlignment actualCopyOfResult =
        ImmutableMeasurableCategoryAlignment.copyOf(instance);

    // Assert
    EntityReference categoryReferenceResult = actualCopyOfResult.categoryReference();
    assertTrue(categoryReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", categoryReferenceResult.description());
    assertEquals(1L, categoryReferenceResult.id());
    assertEquals(EntityKind.ALL, categoryReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, categoryReferenceResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.alignments().isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryAlignment#equals(Object)}, and {@link
   * ImmutableMeasurableCategoryAlignment#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableCategoryAlignment#equals(Object)}
   *   <li>{@link ImmutableMeasurableCategoryAlignment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategoryAlignment.equals(Object)",
    "int ImmutableMeasurableCategoryAlignment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    ImmutableMeasurableCategoryAlignment immutableMeasurableCategoryAlignment =
        builderResult
            .categoryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableCategoryAlignment.builder();
    ImmutableMeasurableCategoryAlignment immutableMeasurableCategoryAlignment2 =
        builderResult2
            .categoryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableCategoryAlignment, immutableMeasurableCategoryAlignment2);
    assertEquals(
        immutableMeasurableCategoryAlignment.hashCode(),
        immutableMeasurableCategoryAlignment2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryAlignment#equals(Object)}, and {@link
   * ImmutableMeasurableCategoryAlignment#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableCategoryAlignment#equals(Object)}
   *   <li>{@link ImmutableMeasurableCategoryAlignment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategoryAlignment.equals(Object)",
    "int ImmutableMeasurableCategoryAlignment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    ImmutableMeasurableCategoryAlignment immutableMeasurableCategoryAlignment =
        builderResult
            .categoryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableMeasurableCategoryAlignment, immutableMeasurableCategoryAlignment);
    int expectedHashCodeResult = immutableMeasurableCategoryAlignment.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableCategoryAlignment.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategoryAlignment.equals(Object)",
    "int ImmutableMeasurableCategoryAlignment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    ImmutableMeasurableAlignment.Builder builderResult2 = ImmutableMeasurableAlignment.builder();
    builderResult.addAlignments(
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
    ImmutableMeasurableCategoryAlignment immutableMeasurableCategoryAlignment =
        builderResult
            .categoryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult3 = ImmutableMeasurableCategoryAlignment.builder();

    // Act and Assert
    assertNotEquals(
        immutableMeasurableCategoryAlignment,
        builderResult3
            .categoryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategoryAlignment.equals(Object)",
    "int ImmutableMeasurableCategoryAlignment.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .categoryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableMeasurableCategoryAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableCategoryAlignment.equals(Object)",
    "int ImmutableMeasurableCategoryAlignment.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .categoryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableMeasurableCategoryAlignment");
  }

  /**
   * Test {@link ImmutableMeasurableCategoryAlignment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) Alignments is {@link HashSet#HashSet()}.
   *   <li>Then return alignments Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryAlignment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) Alignments is HashSet(); then return alignments Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategoryAlignment ImmutableMeasurableCategoryAlignment.fromJson(Json)"
  })
  void testFromJson_givenHashSet_whenJsonAlignmentsIsHashSet_thenReturnAlignmentsEmpty() {
    // Arrange
    Json json = new Json();
    json.setCategoryReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAlignments(new HashSet<>());

    // Act
    ImmutableMeasurableCategoryAlignment actualFromJsonResult =
        ImmutableMeasurableCategoryAlignment.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.alignments().isEmpty());
    EntityReference expectedCategoryReferenceResult = json.categoryReference;
    assertSame(expectedCategoryReferenceResult, actualFromJsonResult.categoryReference());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryAlignment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return alignments is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryAlignment#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return alignments is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategoryAlignment ImmutableMeasurableCategoryAlignment.fromJson(Json)"
  })
  void testFromJson_thenReturnAlignmentsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<MeasurableAlignment> alignments = new LinkedHashSet<>();

    ImmutableMeasurableAlignment.Builder builderResult = ImmutableMeasurableAlignment.builder();
    alignments.add(
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
            .build());

    ImmutableMeasurableAlignment.Builder builderResult2 = ImmutableMeasurableAlignment.builder();
    alignments.add(
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

    Json json = new Json();
    json.setCategoryReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAlignments(alignments);

    // Act
    ImmutableMeasurableCategoryAlignment actualFromJsonResult =
        ImmutableMeasurableCategoryAlignment.fromJson(json);

    // Assert
    assertEquals(alignments, actualFromJsonResult.alignments());
    EntityReference expectedCategoryReferenceResult = json.categoryReference;
    assertSame(expectedCategoryReferenceResult, actualFromJsonResult.categoryReference());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryAlignment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return alignments size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryAlignment#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return alignments size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategoryAlignment ImmutableMeasurableCategoryAlignment.fromJson(Json)"
  })
  void testFromJson_thenReturnAlignmentsSizeIsOne() {
    // Arrange
    LinkedHashSet<MeasurableAlignment> alignments = new LinkedHashSet<>();

    ImmutableMeasurableAlignment.Builder builderResult = ImmutableMeasurableAlignment.builder();
    alignments.add(
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
            .build());

    Json json = new Json();
    json.setCategoryReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAlignments(alignments);

    // Act
    ImmutableMeasurableCategoryAlignment actualFromJsonResult =
        ImmutableMeasurableCategoryAlignment.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.alignments().size());
    EntityReference expectedCategoryReferenceResult = json.categoryReference;
    assertSame(expectedCategoryReferenceResult, actualFromJsonResult.categoryReference());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryAlignment#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) Alignments is {@code null}.
   *   <li>Then return alignments Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableCategoryAlignment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) Alignments is 'null'; then return alignments Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategoryAlignment ImmutableMeasurableCategoryAlignment.fromJson(Json)"
  })
  void testFromJson_whenJsonAlignmentsIsNull_thenReturnAlignmentsEmpty() {
    // Arrange
    Json json = new Json();
    json.setCategoryReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setAlignments(null);

    // Act
    ImmutableMeasurableCategoryAlignment actualFromJsonResult =
        ImmutableMeasurableCategoryAlignment.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.alignments().isEmpty());
    EntityReference expectedCategoryReferenceResult = json.categoryReference;
    assertSame(expectedCategoryReferenceResult, actualFromJsonResult.categoryReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableCategoryAlignment#toString()}
   *   <li>{@link ImmutableMeasurableCategoryAlignment#alignments()}
   *   <li>{@link ImmutableMeasurableCategoryAlignment#categoryReference()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableMeasurableCategoryAlignment.alignments()",
    "EntityReference ImmutableMeasurableCategoryAlignment.categoryReference()",
    "String ImmutableMeasurableCategoryAlignment.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    ImmutableMeasurableCategoryAlignment immutableMeasurableCategoryAlignment =
        builderResult
            .categoryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableMeasurableCategoryAlignment.toString();
    Set<MeasurableAlignment> actualAlignmentsResult =
        immutableMeasurableCategoryAlignment.alignments();

    // Assert
    assertTrue(
        immutableMeasurableCategoryAlignment.categoryReference()
            instanceof ImmutableEntityReference);
    assertEquals(
        "MeasurableCategoryAlignment{categoryReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " alignments=[]}",
        actualToStringResult);
    assertTrue(actualAlignmentsResult.isEmpty());
  }

  /**
   * Test Json {@link Json#alignments()}.
   *
   * <p>Method under test: {@link Json#alignments()}
   */
  @Test
  @DisplayName("Test Json alignments()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.alignments()"})
  void testJsonAlignments() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().alignments());
  }

  /**
   * Test Json {@link Json#categoryReference()}.
   *
   * <p>Method under test: {@link Json#categoryReference()}
   */
  @Test
  @DisplayName("Test Json categoryReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.categoryReference()"})
  void testJsonCategoryReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().categoryReference());
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
    assertNull(actualJson.categoryReference);
    assertTrue(actualJson.alignments.isEmpty());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryAlignment#withAlignments(MeasurableAlignment[])} with
   * {@code MeasurableAlignment[]}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableCategoryAlignment#withAlignments(MeasurableAlignment[])}
   */
  @Test
  @DisplayName("Test withAlignments(MeasurableAlignment[]) with 'MeasurableAlignment[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategoryAlignment ImmutableMeasurableCategoryAlignment.withAlignments(MeasurableAlignment[])"
  })
  void testWithAlignmentsWithMeasurableAlignment() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    ImmutableMeasurableCategoryAlignment immutableMeasurableCategoryAlignment =
        builderResult
            .categoryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    ImmutableMeasurableAlignment.Builder builderResult2 = ImmutableMeasurableAlignment.builder();

    // Act
    ImmutableMeasurableCategoryAlignment actualWithAlignmentsResult =
        immutableMeasurableCategoryAlignment.withAlignments(
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

    // Assert
    EntityReference categoryReferenceResult = actualWithAlignmentsResult.categoryReference();
    assertTrue(categoryReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", categoryReferenceResult.description());
    assertEquals(1, actualWithAlignmentsResult.alignments().size());
    assertEquals(1L, categoryReferenceResult.id());
    assertEquals(EntityKind.ALL, categoryReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, categoryReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableMeasurableCategoryAlignment#withCategoryReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableCategoryAlignment#withCategoryReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withCategoryReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableCategoryAlignment ImmutableMeasurableCategoryAlignment.withCategoryReference(EntityReference)"
  })
  void testWithCategoryReference() {
    // Arrange
    Builder builderResult = ImmutableMeasurableCategoryAlignment.builder();
    ImmutableMeasurableCategoryAlignment immutableMeasurableCategoryAlignment =
        builderResult
            .categoryReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableMeasurableCategoryAlignment actualWithCategoryReferenceResult =
        immutableMeasurableCategoryAlignment.withCategoryReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableMeasurableCategoryAlignment, actualWithCategoryReferenceResult);
  }
}
