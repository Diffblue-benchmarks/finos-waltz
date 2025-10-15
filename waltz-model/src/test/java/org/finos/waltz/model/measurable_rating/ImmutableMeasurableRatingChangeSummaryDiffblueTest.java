package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.measurable_rating.ImmutableMeasurableRatingChangeSummary.Builder;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableRatingChangeSummaryDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#currentRatingNameAndCode(Tuple2)}
   *   <li>{@link Builder#desiredRatingNameAndCode(Tuple2)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingChangeSummary Builder.build()",
    "Builder Builder.currentRatingNameAndCode(Tuple2)",
    "Builder Builder.desiredRatingNameAndCode(Tuple2)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableMeasurableRatingChangeSummary.builder();
    Tuple2<String, String> currentRatingNameAndCode = new Tuple2<>("V1", "V2");
    Builder actualCurrentRatingNameAndCodeResult =
        actualBuilderResult.currentRatingNameAndCode(currentRatingNameAndCode);
    Tuple2<String, String> desiredRatingNameAndCode = new Tuple2<>("V1", "V2");
    Builder actualDesiredRatingNameAndCodeResult =
        actualCurrentRatingNameAndCodeResult.desiredRatingNameAndCode(desiredRatingNameAndCode);
    ImmutableEntityReference entityRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualEntityRefResult = actualDesiredRatingNameAndCodeResult.entityRef(entityRef);
    ImmutableEntityReference measurableCategoryRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualMeasurableCategoryRefResult =
        actualEntityRefResult.measurableCategoryRef(measurableCategoryRef);
    ImmutableEntityReference measurableRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableMeasurableRatingChangeSummary actualImmutableMeasurableRatingChangeSummary =
        actualMeasurableCategoryRefResult.measurableRef(measurableRef).build();

    // Assert
    assertSame(
        currentRatingNameAndCode,
        actualImmutableMeasurableRatingChangeSummary.currentRatingNameAndCode());
    assertSame(
        desiredRatingNameAndCode,
        actualImmutableMeasurableRatingChangeSummary.desiredRatingNameAndCode());
    assertSame(entityRef, actualImmutableMeasurableRatingChangeSummary.entityRef());
    assertSame(
        measurableCategoryRef,
        actualImmutableMeasurableRatingChangeSummary.measurableCategoryRef());
    assertSame(measurableRef, actualImmutableMeasurableRatingChangeSummary.measurableRef());
  }

  /**
   * Test Builder {@link Builder#entityRef(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityRef(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityRef(EntityReference)"})
  void testBuilderEntityRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    // Act
    Builder actualEntityRefResult = builderResult.entityRef(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualEntityRefResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingChangeSummary)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingChangeSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingChangeSummary)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder builderResult2 = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult2.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary instance =
        measurableCategoryRefResult
            .measurableRef(
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
    ImmutableMeasurableRatingChangeSummary actualImmutableMeasurableRatingChangeSummary =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableRatingChangeSummary);
    ImmutableMeasurableRatingChangeSummary actualImmutableMeasurableRatingChangeSummary2 =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingChangeSummary2);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingChangeSummary)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingChangeSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingChangeSummary)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        ImmutableMeasurableRatingChangeSummary.builder().currentRatingNameAndCode(null);

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary instance =
        measurableCategoryRefResult
            .measurableRef(
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
    ImmutableMeasurableRatingChangeSummary actualImmutableMeasurableRatingChangeSummary =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableRatingChangeSummary);
    ImmutableMeasurableRatingChangeSummary actualImmutableMeasurableRatingChangeSummary2 =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingChangeSummary2);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingChangeSummary)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingChangeSummary)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingChangeSummary)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingChangeSummary)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder builderResult2 = ImmutableMeasurableRatingChangeSummary.builder();

    Builder desiredRatingNameAndCodeResult =
        builderResult2
            .currentRatingNameAndCode(new Tuple2<>("V1", "V2"))
            .desiredRatingNameAndCode(null);

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary instance =
        measurableCategoryRefResult
            .measurableRef(
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
    ImmutableMeasurableRatingChangeSummary actualImmutableMeasurableRatingChangeSummary =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableMeasurableRatingChangeSummary);
    ImmutableMeasurableRatingChangeSummary actualImmutableMeasurableRatingChangeSummary2 =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableRatingChangeSummary2);
  }

  /**
   * Test Builder {@link Builder#measurableCategoryRef(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurableCategoryRef(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder measurableCategoryRef(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableCategoryRef(EntityReference)"})
  void testBuilderMeasurableCategoryRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    // Act
    Builder actualMeasurableCategoryRefResult =
        builderResult.measurableCategoryRef(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualMeasurableCategoryRefResult);
  }

  /**
   * Test Builder {@link Builder#measurableRef(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#measurableRef(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder measurableRef(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableRef(EntityReference)"})
  void testBuilderMeasurableRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    // Act
    Builder actualMeasurableRefResult = builderResult.measurableRef(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualMeasurableRefResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingChangeSummary#copyOf(MeasurableRatingChangeSummary)}.
   *
   * <ul>
   *   <li>Then entityRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingChangeSummary#copyOf(MeasurableRatingChangeSummary)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableRatingChangeSummary); then entityRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingChangeSummary ImmutableMeasurableRatingChangeSummary.copyOf(MeasurableRatingChangeSummary)"
  })
  void testCopyOf_thenEntityRefReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    Tuple2<String, String> currentRatingNameAndCode = new Tuple2<>("V1", "V2");

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(currentRatingNameAndCode);
    Tuple2<String, String> desiredRatingNameAndCode = new Tuple2<>("V1", "V2");

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(desiredRatingNameAndCode);

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary instance =
        measurableCategoryRefResult
            .measurableRef(
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
    ImmutableMeasurableRatingChangeSummary actualCopyOfResult =
        ImmutableMeasurableRatingChangeSummary.copyOf(instance);

    // Assert
    EntityReference entityRefResult2 = actualCopyOfResult.entityRef();
    assertTrue(entityRefResult2 instanceof ImmutableEntityReference);
    EntityReference measurableCategoryRefResult2 = actualCopyOfResult.measurableCategoryRef();
    assertTrue(measurableCategoryRefResult2 instanceof ImmutableEntityReference);
    EntityReference measurableRefResult = actualCopyOfResult.measurableRef();
    assertTrue(measurableRefResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", entityRefResult2.description());
    assertEquals(1L, entityRefResult2.id());
    assertEquals(EntityKind.ALL, entityRefResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityRefResult2.entityLifecycleStatus());
    assertEquals(entityRefResult2, measurableCategoryRefResult2);
    assertEquals(entityRefResult2, measurableRefResult);
    assertSame(currentRatingNameAndCode, actualCopyOfResult.currentRatingNameAndCode());
    assertSame(desiredRatingNameAndCode, actualCopyOfResult.desiredRatingNameAndCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}, and {@link
   * ImmutableMeasurableRatingChangeSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingChangeSummary.equals(Object)",
    "int ImmutableMeasurableRatingChangeSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult2 =
        builderResult2.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult2 =
        currentRatingNameAndCodeResult2.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult2 =
        desiredRatingNameAndCodeResult2.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult2 =
        entityRefResult2.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary2 =
        measurableCategoryRefResult2
            .measurableRef(
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
    assertEquals(immutableMeasurableRatingChangeSummary, immutableMeasurableRatingChangeSummary2);
    assertEquals(
        immutableMeasurableRatingChangeSummary.hashCode(),
        immutableMeasurableRatingChangeSummary2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}, and {@link
   * ImmutableMeasurableRatingChangeSummary#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#equals(Object)}
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingChangeSummary.equals(Object)",
    "int ImmutableMeasurableRatingChangeSummary.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
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
    assertEquals(immutableMeasurableRatingChangeSummary, immutableMeasurableRatingChangeSummary);
    int expectedHashCodeResult = immutableMeasurableRatingChangeSummary.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableRatingChangeSummary.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingChangeSummary.equals(Object)",
    "int ImmutableMeasurableRatingChangeSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("42", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult2 =
        builderResult2.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult2 =
        currentRatingNameAndCodeResult2.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult2 =
        desiredRatingNameAndCodeResult2.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult2 =
        entityRefResult2.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingChangeSummary,
        measurableCategoryRefResult2
            .measurableRef(
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
   * Test {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingChangeSummary.equals(Object)",
    "int ImmutableMeasurableRatingChangeSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("42", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult2 =
        builderResult2.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult2 =
        currentRatingNameAndCodeResult2.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult2 =
        desiredRatingNameAndCodeResult2.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult2 =
        entityRefResult2.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingChangeSummary,
        measurableCategoryRefResult2
            .measurableRef(
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
   * Test {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingChangeSummary.equals(Object)",
    "int ImmutableMeasurableRatingChangeSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult2 =
        builderResult2.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult2 =
        currentRatingNameAndCodeResult2.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult2 =
        desiredRatingNameAndCodeResult2.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult2 =
        entityRefResult2.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingChangeSummary,
        measurableCategoryRefResult2
            .measurableRef(
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
   * Test {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingChangeSummary.equals(Object)",
    "int ImmutableMeasurableRatingChangeSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult2 =
        builderResult2.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult2 =
        currentRatingNameAndCodeResult2.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult2 =
        desiredRatingNameAndCodeResult2.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult2 =
        entityRefResult2.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingChangeSummary,
        measurableCategoryRefResult2
            .measurableRef(
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
   * Test {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingChangeSummary.equals(Object)",
    "int ImmutableMeasurableRatingChangeSummary.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult2 =
        builderResult2.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult2 =
        currentRatingNameAndCodeResult2.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult2 =
        desiredRatingNameAndCodeResult2.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult2 =
        entityRefResult2.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableMeasurableRatingChangeSummary,
        measurableCategoryRefResult2
            .measurableRef(
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
   * Test {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingChangeSummary.equals(Object)",
    "int ImmutableMeasurableRatingChangeSummary.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        measurableCategoryRefResult
            .measurableRef(
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
   * Test {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableRatingChangeSummary#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableRatingChangeSummary.equals(Object)",
    "int ImmutableMeasurableRatingChangeSummary.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        measurableCategoryRefResult
            .measurableRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableMeasurableRatingChangeSummary");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#toString()}
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#currentRatingNameAndCode()}
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#desiredRatingNameAndCode()}
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#entityRef()}
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#measurableCategoryRef()}
   *   <li>{@link ImmutableMeasurableRatingChangeSummary#measurableRef()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Tuple2 ImmutableMeasurableRatingChangeSummary.currentRatingNameAndCode()",
    "Tuple2 ImmutableMeasurableRatingChangeSummary.desiredRatingNameAndCode()",
    "EntityReference ImmutableMeasurableRatingChangeSummary.entityRef()",
    "EntityReference ImmutableMeasurableRatingChangeSummary.measurableCategoryRef()",
    "EntityReference ImmutableMeasurableRatingChangeSummary.measurableRef()",
    "String ImmutableMeasurableRatingChangeSummary.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();
    Tuple2<String, String> currentRatingNameAndCode = new Tuple2<>("V1", "V2");

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(currentRatingNameAndCode);
    Tuple2<String, String> desiredRatingNameAndCode = new Tuple2<>("V1", "V2");

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(desiredRatingNameAndCode);

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
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
    String actualToStringResult = immutableMeasurableRatingChangeSummary.toString();
    Tuple2<String, String> actualCurrentRatingNameAndCodeResult =
        immutableMeasurableRatingChangeSummary.currentRatingNameAndCode();
    Tuple2<String, String> actualDesiredRatingNameAndCodeResult =
        immutableMeasurableRatingChangeSummary.desiredRatingNameAndCode();
    EntityReference actualEntityRefResult = immutableMeasurableRatingChangeSummary.entityRef();
    EntityReference actualMeasurableCategoryRefResult =
        immutableMeasurableRatingChangeSummary.measurableCategoryRef();
    EntityReference actualMeasurableRefResult =
        immutableMeasurableRatingChangeSummary.measurableRef();

    // Assert
    assertTrue(actualEntityRefResult instanceof ImmutableEntityReference);
    assertTrue(actualMeasurableCategoryRefResult instanceof ImmutableEntityReference);
    assertTrue(actualMeasurableRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "MeasurableRatingChangeSummary{entityRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " measurableRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, measurableCategoryRef"
            + "=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, currentRatingNameAndCode=(V1, V2),"
            + " desiredRatingNameAndCode=(V1, V2)}",
        actualToStringResult);
    assertEquals(actualEntityRefResult, actualMeasurableCategoryRefResult);
    assertEquals(actualEntityRefResult, actualMeasurableRefResult);
    assertSame(currentRatingNameAndCode, actualCurrentRatingNameAndCodeResult);
    assertSame(desiredRatingNameAndCode, actualDesiredRatingNameAndCodeResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingChangeSummary#withCurrentRatingNameAndCode(Tuple2)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingChangeSummary#withCurrentRatingNameAndCode(Tuple2)}
   */
  @Test
  @DisplayName("Test withCurrentRatingNameAndCode(Tuple2)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingChangeSummary ImmutableMeasurableRatingChangeSummary.withCurrentRatingNameAndCode(Tuple2)"
  })
  void testWithCurrentRatingNameAndCode() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
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
    ImmutableMeasurableRatingChangeSummary actualWithCurrentRatingNameAndCodeResult =
        immutableMeasurableRatingChangeSummary.withCurrentRatingNameAndCode(
            new Tuple2<>("V1", "V2"));

    // Assert
    assertEquals(immutableMeasurableRatingChangeSummary, actualWithCurrentRatingNameAndCodeResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingChangeSummary#withDesiredRatingNameAndCode(Tuple2)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingChangeSummary#withDesiredRatingNameAndCode(Tuple2)}
   */
  @Test
  @DisplayName("Test withDesiredRatingNameAndCode(Tuple2)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingChangeSummary ImmutableMeasurableRatingChangeSummary.withDesiredRatingNameAndCode(Tuple2)"
  })
  void testWithDesiredRatingNameAndCode() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
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
    ImmutableMeasurableRatingChangeSummary actualWithDesiredRatingNameAndCodeResult =
        immutableMeasurableRatingChangeSummary.withDesiredRatingNameAndCode(
            new Tuple2<>("V1", "V2"));

    // Assert
    assertEquals(immutableMeasurableRatingChangeSummary, actualWithDesiredRatingNameAndCodeResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingChangeSummary#withEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingChangeSummary#withEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingChangeSummary ImmutableMeasurableRatingChangeSummary.withEntityRef(EntityReference)"
  })
  void testWithEntityRef() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
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
    ImmutableMeasurableRatingChangeSummary actualWithEntityRefResult =
        immutableMeasurableRatingChangeSummary.withEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableMeasurableRatingChangeSummary, actualWithEntityRefResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingChangeSummary#withMeasurableCategoryRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingChangeSummary#withMeasurableCategoryRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withMeasurableCategoryRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingChangeSummary ImmutableMeasurableRatingChangeSummary.withMeasurableCategoryRef(EntityReference)"
  })
  void testWithMeasurableCategoryRef() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
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
    ImmutableMeasurableRatingChangeSummary actualWithMeasurableCategoryRefResult =
        immutableMeasurableRatingChangeSummary.withMeasurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableMeasurableRatingChangeSummary, actualWithMeasurableCategoryRefResult);
  }

  /**
   * Test {@link ImmutableMeasurableRatingChangeSummary#withMeasurableRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableRatingChangeSummary#withMeasurableRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withMeasurableRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableRatingChangeSummary ImmutableMeasurableRatingChangeSummary.withMeasurableRef(EntityReference)"
  })
  void testWithMeasurableRef() {
    // Arrange
    Builder builderResult = ImmutableMeasurableRatingChangeSummary.builder();

    Builder currentRatingNameAndCodeResult =
        builderResult.currentRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder desiredRatingNameAndCodeResult =
        currentRatingNameAndCodeResult.desiredRatingNameAndCode(new Tuple2<>("V1", "V2"));

    Builder entityRefResult =
        desiredRatingNameAndCodeResult.entityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder measurableCategoryRefResult =
        entityRefResult.measurableCategoryRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableMeasurableRatingChangeSummary immutableMeasurableRatingChangeSummary =
        measurableCategoryRefResult
            .measurableRef(
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
    ImmutableMeasurableRatingChangeSummary actualWithMeasurableRefResult =
        immutableMeasurableRatingChangeSummary.withMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableMeasurableRatingChangeSummary, actualWithMeasurableRefResult);
  }
}
