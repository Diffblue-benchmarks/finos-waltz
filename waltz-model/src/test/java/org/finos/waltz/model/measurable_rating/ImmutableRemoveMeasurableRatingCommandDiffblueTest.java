package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.measurable_rating.ImmutableRemoveMeasurableRatingCommand.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableRemoveMeasurableRatingCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRemoveMeasurableRatingCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRemoveMeasurableRatingCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableRemoveMeasurableRatingCommand.builder();
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualEntityReferenceResult = actualBuilderResult.entityReference(entityReference);
    ImmutableUserTimestamp lastUpdate =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    ImmutableRemoveMeasurableRatingCommand actualImmutableRemoveMeasurableRatingCommand =
        actualEntityReferenceResult.lastUpdate(lastUpdate).measurableId(1L).build();

    // Assert
    assertEquals(1L, actualImmutableRemoveMeasurableRatingCommand.measurableId());
    assertSame(entityReference, actualImmutableRemoveMeasurableRatingCommand.entityReference());
    assertSame(lastUpdate, actualImmutableRemoveMeasurableRatingCommand.lastUpdate());
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingCommand)} with {@code
   * MeasurableRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingCommand) with 'MeasurableRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingCommand)"})
  void testBuilderFromWithMeasurableRatingCommand() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder builderResult2 = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult2.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRemoveMeasurableRatingCommand instance =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((MeasurableRatingCommand) instance);

    // Assert
    ImmutableRemoveMeasurableRatingCommand actualImmutableRemoveMeasurableRatingCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableRemoveMeasurableRatingCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingCommand)} with {@code
   * MeasurableRatingCommand}.
   *
   * <ul>
   *   <li>Then builder build measurableId is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MeasurableRatingCommand) with 'MeasurableRatingCommand'; then builder build measurableId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingCommand)"})
  void testBuilderFromWithMeasurableRatingCommand_thenBuilderBuildMeasurableIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    ImmutableSaveMeasurableRatingCommand.Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    ImmutableSaveMeasurableRatingCommand.Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);

    // Act
    Builder actualFromResult =
        builderResult.from(
            isPrimaryResult
                .lastUpdate(
                    ImmutableUserTimestamp.builder()
                        .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .by("By")
                        .build())
                .measurableId(1L)
                .previousRating('A')
                .provenance("Provenance")
                .rating('A')
                .build());

    // Assert
    assertEquals(1L, builderResult.build().measurableId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RemoveMeasurableRatingCommand)} with {@code
   * RemoveMeasurableRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(RemoveMeasurableRatingCommand) with 'RemoveMeasurableRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RemoveMeasurableRatingCommand)"})
  void testBuilderFromWithRemoveMeasurableRatingCommand() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder builderResult2 = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult2.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRemoveMeasurableRatingCommand instance =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRemoveMeasurableRatingCommand actualImmutableRemoveMeasurableRatingCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableRemoveMeasurableRatingCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdate(UserTimestamp)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#lastUpdate(UserTimestamp)}
   */
  @Test
  @DisplayName("Test Builder lastUpdate(UserTimestamp); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdate(UserTimestamp)"})
  void testBuilderLastUpdate_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    // Act
    Builder actualLastUpdateResult =
        builderResult.lastUpdate(
            ImmutableUserTimestamp.builder()
                .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                .by("By")
                .build());

    // Assert
    assertSame(builderResult, actualLastUpdateResult);
  }

  /**
   * Test Builder {@link Builder#measurableId(long)}.
   *
   * <p>Method under test: {@link Builder#measurableId(long)}
   */
  @Test
  @DisplayName("Test Builder measurableId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.measurableId(long)"})
  void testBuilderMeasurableId() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    // Act
    Builder actualMeasurableIdResult = builderResult.measurableId(1L);

    // Assert
    assertSame(builderResult, actualMeasurableIdResult);
  }

  /**
   * Test {@link ImmutableRemoveMeasurableRatingCommand#copyOf(RemoveMeasurableRatingCommand)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableRemoveMeasurableRatingCommand#copyOf(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(RemoveMeasurableRatingCommand); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveMeasurableRatingCommand ImmutableRemoveMeasurableRatingCommand.copyOf(RemoveMeasurableRatingCommand)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableRemoveMeasurableRatingCommand instance =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder().at(ofResult.atStartOfDay()).by("By").build())
            .measurableId(1L)
            .build();

    // Act
    ImmutableRemoveMeasurableRatingCommand actualCopyOfResult =
        ImmutableRemoveMeasurableRatingCommand.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult2 = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult2 instanceof ImmutableEntityReference);
    UserTimestamp lastUpdateResult = actualCopyOfResult.lastUpdate();
    assertTrue(lastUpdateResult instanceof ImmutableUserTimestamp);
    LocalDateTime atResult = lastUpdateResult.at();
    assertEquals("00:00", atResult.toLocalTime().toString());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(lastUpdateResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    LocalDate toLocalDateResult = atResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("By", lastUpdateResult.by());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult2.description());
    assertEquals(1L, entityReferenceResult2.id());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertEquals(EntityKind.ALL, entityReferenceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult2.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}, and {@link
   * ImmutableRemoveMeasurableRatingCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}
   *   <li>{@link ImmutableRemoveMeasurableRatingCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveMeasurableRatingCommand.equals(Object)",
    "int ImmutableRemoveMeasurableRatingCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRemoveMeasurableRatingCommand immutableRemoveMeasurableRatingCommand =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build();

    Builder builderResult2 = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult2 =
        builderResult2.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRemoveMeasurableRatingCommand immutableRemoveMeasurableRatingCommand2 =
        entityReferenceResult2
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableRemoveMeasurableRatingCommand, immutableRemoveMeasurableRatingCommand2);
    assertEquals(
        immutableRemoveMeasurableRatingCommand.hashCode(),
        immutableRemoveMeasurableRatingCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}, and {@link
   * ImmutableRemoveMeasurableRatingCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}
   *   <li>{@link ImmutableRemoveMeasurableRatingCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveMeasurableRatingCommand.equals(Object)",
    "int ImmutableRemoveMeasurableRatingCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRemoveMeasurableRatingCommand immutableRemoveMeasurableRatingCommand =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableRemoveMeasurableRatingCommand, immutableRemoveMeasurableRatingCommand);
    int expectedHashCodeResult = immutableRemoveMeasurableRatingCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableRemoveMeasurableRatingCommand.hashCode());
  }

  /**
   * Test {@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveMeasurableRatingCommand.equals(Object)",
    "int ImmutableRemoveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRemoveMeasurableRatingCommand immutableRemoveMeasurableRatingCommand =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build();

    Builder builderResult2 = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult2 =
        builderResult2.entityReference(
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
        immutableRemoveMeasurableRatingCommand,
        entityReferenceResult2
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveMeasurableRatingCommand.equals(Object)",
    "int ImmutableRemoveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRemoveMeasurableRatingCommand immutableRemoveMeasurableRatingCommand =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.now().atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build();

    Builder builderResult2 = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult2 =
        builderResult2.entityReference(
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
        immutableRemoveMeasurableRatingCommand,
        entityReferenceResult2
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveMeasurableRatingCommand.equals(Object)",
    "int ImmutableRemoveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRemoveMeasurableRatingCommand immutableRemoveMeasurableRatingCommand =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(2L)
            .build();

    Builder builderResult2 = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult2 =
        builderResult2.entityReference(
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
        immutableRemoveMeasurableRatingCommand,
        entityReferenceResult2
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveMeasurableRatingCommand.equals(Object)",
    "int ImmutableRemoveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
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
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRemoveMeasurableRatingCommand.equals(Object)",
    "int ImmutableRemoveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
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
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build(),
        "Different type to ImmutableRemoveMeasurableRatingCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRemoveMeasurableRatingCommand#toString()}
   *   <li>{@link ImmutableRemoveMeasurableRatingCommand#entityReference()}
   *   <li>{@link ImmutableRemoveMeasurableRatingCommand#lastUpdate()}
   *   <li>{@link ImmutableRemoveMeasurableRatingCommand#measurableId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableRemoveMeasurableRatingCommand.entityReference()",
    "UserTimestamp ImmutableRemoveMeasurableRatingCommand.lastUpdate()",
    "long ImmutableRemoveMeasurableRatingCommand.measurableId()",
    "String ImmutableRemoveMeasurableRatingCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRemoveMeasurableRatingCommand immutableRemoveMeasurableRatingCommand =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build();

    // Act
    String actualToStringResult = immutableRemoveMeasurableRatingCommand.toString();
    EntityReference actualEntityReferenceResult =
        immutableRemoveMeasurableRatingCommand.entityReference();
    UserTimestamp actualLastUpdateResult = immutableRemoveMeasurableRatingCommand.lastUpdate();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualLastUpdateResult instanceof ImmutableUserTimestamp);
    assertEquals(
        "RemoveMeasurableRatingCommand{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " measurableId=1, lastUpdate=UserTimestamp{at=1970-01-01T00:00, by=By, atTimestamp=1970-01-01"
            + " 00:00:00.0}}",
        actualToStringResult);
    assertEquals(1L, immutableRemoveMeasurableRatingCommand.measurableId());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setLastUpdate(UserTimestamp)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setLastUpdate(UserTimestamp)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    actualJson.setLastUpdate(
        ImmutableUserTimestamp.builder().at(ofResult.atStartOfDay()).by("By").build());

    // Assert
    EntityReference entityReference = actualJson.entityReference;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    UserTimestamp userTimestamp = actualJson.lastUpdate;
    assertTrue(userTimestamp instanceof ImmutableUserTimestamp);
    LocalDateTime atResult = userTimestamp.at();
    assertEquals("00:00", atResult.toLocalTime().toString());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(userTimestamp.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    LocalDate toLocalDateResult = atResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("By", userTimestamp.by());
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(0L, actualJson.measurableId);
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertFalse(actualJson.measurableIdIsSet);
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test Json {@link Json#lastUpdate()}.
   *
   * <p>Method under test: {@link Json#lastUpdate()}
   */
  @Test
  @DisplayName("Test Json lastUpdate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserTimestamp Json.lastUpdate()"})
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdate());
  }

  /**
   * Test Json {@link Json#measurableId()}.
   *
   * <p>Method under test: {@link Json#measurableId()}
   */
  @Test
  @DisplayName("Test Json measurableId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.measurableId()"})
  void testJsonMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().measurableId());
  }

  /**
   * Test Json {@link Json#setMeasurableId(long)}.
   *
   * <p>Method under test: {@link Json#setMeasurableId(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setMeasurableId(long)"})
  void testJsonSetMeasurableId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMeasurableId(1L);

    // Assert
    assertEquals(1L, json.measurableId);
    assertTrue(json.measurableIdIsSet);
  }

  /**
   * Test {@link ImmutableRemoveMeasurableRatingCommand#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableRemoveMeasurableRatingCommand#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveMeasurableRatingCommand ImmutableRemoveMeasurableRatingCommand.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRemoveMeasurableRatingCommand immutableRemoveMeasurableRatingCommand =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build();

    // Act
    ImmutableRemoveMeasurableRatingCommand actualWithEntityReferenceResult =
        immutableRemoveMeasurableRatingCommand.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableRemoveMeasurableRatingCommand, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableRemoveMeasurableRatingCommand#withLastUpdate(UserTimestamp)}.
   *
   * <p>Method under test: {@link
   * ImmutableRemoveMeasurableRatingCommand#withLastUpdate(UserTimestamp)}
   */
  @Test
  @DisplayName("Test withLastUpdate(UserTimestamp)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveMeasurableRatingCommand ImmutableRemoveMeasurableRatingCommand.withLastUpdate(UserTimestamp)"
  })
  void testWithLastUpdate() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRemoveMeasurableRatingCommand immutableRemoveMeasurableRatingCommand =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .build();

    // Act
    ImmutableRemoveMeasurableRatingCommand actualWithLastUpdateResult =
        immutableRemoveMeasurableRatingCommand.withLastUpdate(
            ImmutableUserTimestamp.builder()
                .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                .by("By")
                .build());

    // Assert
    assertEquals(immutableRemoveMeasurableRatingCommand, actualWithLastUpdateResult);
  }

  /**
   * Test {@link ImmutableRemoveMeasurableRatingCommand#withMeasurableId(long)}.
   *
   * <p>Method under test: {@link ImmutableRemoveMeasurableRatingCommand#withMeasurableId(long)}
   */
  @Test
  @DisplayName("Test withMeasurableId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveMeasurableRatingCommand ImmutableRemoveMeasurableRatingCommand.withMeasurableId(long)"
  })
  void testWithMeasurableId() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableRemoveMeasurableRatingCommand immutableRemoveMeasurableRatingCommand =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(42L)
            .build();

    // Act
    ImmutableRemoveMeasurableRatingCommand actualWithMeasurableIdResult =
        immutableRemoveMeasurableRatingCommand.withMeasurableId(42L);

    // Assert
    assertSame(immutableRemoveMeasurableRatingCommand, actualWithMeasurableIdResult);
  }

  /**
   * Test {@link ImmutableRemoveMeasurableRatingCommand#withMeasurableId(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRemoveMeasurableRatingCommand#withMeasurableId(long)}
   */
  @Test
  @DisplayName("Test withMeasurableId(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRemoveMeasurableRatingCommand ImmutableRemoveMeasurableRatingCommand.withMeasurableId(long)"
  })
  void testWithMeasurableId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    Builder entityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableRemoveMeasurableRatingCommand actualWithMeasurableIdResult =
        entityReferenceResult
            .lastUpdate(
                ImmutableUserTimestamp.builder().at(ofResult.atStartOfDay()).by("By").build())
            .measurableId(1L)
            .build()
            .withMeasurableId(42L);

    // Assert
    EntityReference entityReferenceResult2 = actualWithMeasurableIdResult.entityReference();
    assertTrue(entityReferenceResult2 instanceof ImmutableEntityReference);
    UserTimestamp lastUpdateResult = actualWithMeasurableIdResult.lastUpdate();
    assertTrue(lastUpdateResult instanceof ImmutableUserTimestamp);
    LocalDateTime atResult = lastUpdateResult.at();
    assertEquals("00:00", atResult.toLocalTime().toString());
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(lastUpdateResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    LocalDate toLocalDateResult = atResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("By", lastUpdateResult.by());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult2.description());
    assertEquals(1L, entityReferenceResult2.id());
    assertEquals(42L, actualWithMeasurableIdResult.measurableId());
    assertEquals(EntityKind.ALL, entityReferenceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult2.entityLifecycleStatus());
    assertSame(ofResult, toLocalDateResult);
  }
}
