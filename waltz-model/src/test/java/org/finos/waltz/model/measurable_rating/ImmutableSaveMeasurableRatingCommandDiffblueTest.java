package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ImmutableUserTimestamp;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.measurable_rating.ImmutableSaveMeasurableRatingCommand.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableSaveMeasurableRatingCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSaveMeasurableRatingCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#isPrimary(Boolean)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.isPrimary(Boolean)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDescriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualIsPrimaryResult =
        actualDescriptionResult.entityReference(entityReference).isPrimary(true);
    ImmutableUserTimestamp lastUpdate =
        ImmutableUserTimestamp.builder()
            .at(LocalDate.of(1970, 1, 1).atStartOfDay())
            .by("By")
            .build();
    Builder actualPreviousRatingResult =
        actualIsPrimaryResult.lastUpdate(lastUpdate).measurableId(1L).previousRating('A');
    Optional<Character> previousRating = Optional.of('A');
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand =
        actualPreviousRatingResult
            .previousRating(previousRating)
            .provenance("Provenance")
            .rating('A')
            .build();

    // Assert
    assertEquals("Provenance", actualImmutableSaveMeasurableRatingCommand.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableSaveMeasurableRatingCommand.description());
    assertEquals('A', actualImmutableSaveMeasurableRatingCommand.rating());
    assertEquals(1L, actualImmutableSaveMeasurableRatingCommand.measurableId());
    assertTrue(actualImmutableSaveMeasurableRatingCommand.isPrimary());
    assertSame(entityReference, actualImmutableSaveMeasurableRatingCommand.entityReference());
    assertSame(lastUpdate, actualImmutableSaveMeasurableRatingCommand.lastUpdate());
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
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

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
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand =
        builderResult.from((MeasurableRatingCommand) instance).build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand);
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand2);
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
  void testBuilderFromWithMeasurableRatingCommand2() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    Builder descriptionResult = ImmutableSaveMeasurableRatingCommand.builder().description(null);

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand =
        builderResult.from((MeasurableRatingCommand) instance).build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand);
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand2);
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
  void testBuilderFromWithMeasurableRatingCommand3() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
            .isPrimary(null);
    ImmutableSaveMeasurableRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand =
        builderResult.from((MeasurableRatingCommand) instance).build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand);
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand2);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingCommand)} with {@code
   * MeasurableRatingCommand}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(MeasurableRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MeasurableRatingCommand) with 'MeasurableRatingCommand'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingCommand)"})
  void testBuilderFromWithMeasurableRatingCommand_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    ImmutableRemoveMeasurableRatingCommand.Builder builderResult2 =
        ImmutableRemoveMeasurableRatingCommand.builder();

    ImmutableRemoveMeasurableRatingCommand.Builder entityReferenceResult =
        builderResult2.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    Builder actualFromResult =
        builderResult.from(
            entityReferenceResult
                .lastUpdate(
                    ImmutableUserTimestamp.builder()
                        .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                        .by("By")
                        .build())
                .measurableId(1L)
                .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand);
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider2() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    Builder descriptionResult = ImmutableSaveMeasurableRatingCommand.builder().description(null);

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand);
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider3() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
            .isPrimary(null);
    ImmutableSaveMeasurableRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand);
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (ProvenanceProvider)
                ImmutableActor.builder()
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .isExternal(true)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SaveMeasurableRatingCommand)} with {@code
   * SaveMeasurableRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveMeasurableRatingCommand) with 'SaveMeasurableRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SaveMeasurableRatingCommand)"})
  void testBuilderFromWithSaveMeasurableRatingCommand() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand);
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand2);
  }

  /**
   * Test Builder {@link Builder#from(SaveMeasurableRatingCommand)} with {@code
   * SaveMeasurableRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveMeasurableRatingCommand) with 'SaveMeasurableRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SaveMeasurableRatingCommand)"})
  void testBuilderFromWithSaveMeasurableRatingCommand2() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    Builder descriptionResult = ImmutableSaveMeasurableRatingCommand.builder().description(null);

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand);
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand2);
  }

  /**
   * Test Builder {@link Builder#from(SaveMeasurableRatingCommand)} with {@code
   * SaveMeasurableRatingCommand}.
   *
   * <p>Method under test: {@link Builder#from(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(SaveMeasurableRatingCommand) with 'SaveMeasurableRatingCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(SaveMeasurableRatingCommand)"})
  void testBuilderFromWithSaveMeasurableRatingCommand3() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
            .isPrimary(null);
    ImmutableSaveMeasurableRatingCommand instance =
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
            .build();

    // Act and Assert
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand);
    ImmutableSaveMeasurableRatingCommand actualImmutableSaveMeasurableRatingCommand2 =
        builderResult.build();
    assertEquals(instance, actualImmutableSaveMeasurableRatingCommand2);
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
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

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
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act
    Builder actualMeasurableIdResult = builderResult.measurableId(1L);

    // Assert
    assertSame(builderResult, actualMeasurableIdResult);
  }

  /**
   * Test Builder {@link Builder#previousRating(char)} with {@code char}.
   *
   * <p>Method under test: {@link Builder#previousRating(char)}
   */
  @Test
  @DisplayName("Test Builder previousRating(char) with 'char'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.previousRating(char)"})
  void testBuilderPreviousRatingWithChar() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act
    Builder actualPreviousRatingResult = builderResult.previousRating('A');

    // Assert
    assertSame(builderResult, actualPreviousRatingResult);
  }

  /**
   * Test Builder {@link Builder#previousRating(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#previousRating(Optional)}
   */
  @Test
  @DisplayName("Test Builder previousRating(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.previousRating(Optional)"})
  void testBuilderPreviousRatingWithOptional() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();
    Optional<Character> previousRating = Optional.of('A');

    // Act
    Builder actualPreviousRatingResult = builderResult.previousRating(previousRating);

    // Assert
    assertSame(builderResult, actualPreviousRatingResult);
  }

  /**
   * Test Builder {@link Builder#rating(char)}.
   *
   * <p>Method under test: {@link Builder#rating(char)}
   */
  @Test
  @DisplayName("Test Builder rating(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rating(char)"})
  void testBuilderRating() {
    // Arrange
    Builder builderResult = ImmutableSaveMeasurableRatingCommand.builder();

    // Act
    Builder actualRatingResult = builderResult.rating('A');

    // Assert
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#copyOf(SaveMeasurableRatingCommand)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableSaveMeasurableRatingCommand#copyOf(SaveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(SaveMeasurableRatingCommand); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.copyOf(SaveMeasurableRatingCommand)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand instance =
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
            .build();

    // Act
    ImmutableSaveMeasurableRatingCommand actualCopyOfResult =
        ImmutableSaveMeasurableRatingCommand.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    UserTimestamp lastUpdateResult = actualCopyOfResult.lastUpdate();
    assertTrue(lastUpdateResult instanceof ImmutableUserTimestamp);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(lastUpdateResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    assertEquals("By", lastUpdateResult.by());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals('A', actualCopyOfResult.rating());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualCopyOfResult.measurableId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.isPrimary());
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}, and {@link
   * ImmutableSaveMeasurableRatingCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#equals(Object)}
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveMeasurableRatingCommand.equals(Object)",
    "int ImmutableSaveMeasurableRatingCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();

    Builder descriptionResult2 =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult2 =
        descriptionResult2
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand2 =
        isPrimaryResult2
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .previousRating('A')
            .provenance("Provenance")
            .rating('A')
            .build();

    // Act and Assert
    assertEquals(immutableSaveMeasurableRatingCommand, immutableSaveMeasurableRatingCommand2);
    assertEquals(
        immutableSaveMeasurableRatingCommand.hashCode(),
        immutableSaveMeasurableRatingCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}, and {@link
   * ImmutableSaveMeasurableRatingCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#equals(Object)}
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveMeasurableRatingCommand.equals(Object)",
    "int ImmutableSaveMeasurableRatingCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();

    // Act and Assert
    assertEquals(immutableSaveMeasurableRatingCommand, immutableSaveMeasurableRatingCommand);
    int expectedHashCodeResult = immutableSaveMeasurableRatingCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableSaveMeasurableRatingCommand.hashCode());
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveMeasurableRatingCommand.equals(Object)",
    "int ImmutableSaveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
        descriptionResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .isPrimary(true);
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();

    Builder descriptionResult2 =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult2 =
        descriptionResult2
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

    // Act and Assert
    assertNotEquals(
        immutableSaveMeasurableRatingCommand,
        isPrimaryResult2
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
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveMeasurableRatingCommand.equals(Object)",
    "int ImmutableSaveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
            .isPrimary(false);
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();

    Builder descriptionResult2 =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult2 =
        descriptionResult2
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

    // Act and Assert
    assertNotEquals(
        immutableSaveMeasurableRatingCommand,
        isPrimaryResult2
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
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveMeasurableRatingCommand.equals(Object)",
    "int ImmutableSaveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
        isPrimaryResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.now().atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .previousRating('A')
            .provenance("Provenance")
            .rating('A')
            .build();

    Builder descriptionResult2 =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult2 =
        descriptionResult2
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

    // Act and Assert
    assertNotEquals(
        immutableSaveMeasurableRatingCommand,
        isPrimaryResult2
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
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveMeasurableRatingCommand.equals(Object)",
    "int ImmutableSaveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
        isPrimaryResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(2L)
            .previousRating('A')
            .provenance("Provenance")
            .rating('A')
            .build();

    Builder descriptionResult2 =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult2 =
        descriptionResult2
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

    // Act and Assert
    assertNotEquals(
        immutableSaveMeasurableRatingCommand,
        isPrimaryResult2
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
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveMeasurableRatingCommand.equals(Object)",
    "int ImmutableSaveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
        isPrimaryResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .previousRating('\u0001')
            .provenance("Provenance")
            .rating('A')
            .build();

    Builder descriptionResult2 =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult2 =
        descriptionResult2
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

    // Act and Assert
    assertNotEquals(
        immutableSaveMeasurableRatingCommand,
        isPrimaryResult2
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
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveMeasurableRatingCommand.equals(Object)",
    "int ImmutableSaveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
        isPrimaryResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .previousRating('A')
            .provenance("By")
            .rating('A')
            .build();

    Builder descriptionResult2 =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult2 =
        descriptionResult2
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

    // Act and Assert
    assertNotEquals(
        immutableSaveMeasurableRatingCommand,
        isPrimaryResult2
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
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveMeasurableRatingCommand.equals(Object)",
    "int ImmutableSaveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
        isPrimaryResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .previousRating('A')
            .provenance("Provenance")
            .rating('\u0001')
            .build();

    Builder descriptionResult2 =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult2 =
        descriptionResult2
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

    // Act and Assert
    assertNotEquals(
        immutableSaveMeasurableRatingCommand,
        isPrimaryResult2
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
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveMeasurableRatingCommand.equals(Object)",
    "int ImmutableSaveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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

    // Act and Assert
    assertNotEquals(
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
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableSaveMeasurableRatingCommand.equals(Object)",
    "int ImmutableSaveMeasurableRatingCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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

    // Act and Assert
    assertNotEquals(
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
            .build(),
        "Different type to ImmutableSaveMeasurableRatingCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#description()}
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#entityReference()}
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#isPrimary()}
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#lastUpdate()}
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#measurableId()}
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#provenance()}
   *   <li>{@link ImmutableSaveMeasurableRatingCommand#rating()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableSaveMeasurableRatingCommand.description()",
    "EntityReference ImmutableSaveMeasurableRatingCommand.entityReference()",
    "Boolean ImmutableSaveMeasurableRatingCommand.isPrimary()",
    "UserTimestamp ImmutableSaveMeasurableRatingCommand.lastUpdate()",
    "long ImmutableSaveMeasurableRatingCommand.measurableId()",
    "String ImmutableSaveMeasurableRatingCommand.provenance()",
    "char ImmutableSaveMeasurableRatingCommand.rating()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();

    // Act
    String actualDescriptionResult = immutableSaveMeasurableRatingCommand.description();
    EntityReference actualEntityReferenceResult =
        immutableSaveMeasurableRatingCommand.entityReference();
    Boolean actualIsPrimaryResult = immutableSaveMeasurableRatingCommand.isPrimary();
    UserTimestamp actualLastUpdateResult = immutableSaveMeasurableRatingCommand.lastUpdate();
    long actualMeasurableIdResult = immutableSaveMeasurableRatingCommand.measurableId();
    String actualProvenanceResult = immutableSaveMeasurableRatingCommand.provenance();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualLastUpdateResult instanceof ImmutableUserTimestamp);
    assertEquals("Provenance", actualProvenanceResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals('A', immutableSaveMeasurableRatingCommand.rating());
    assertEquals(1L, actualMeasurableIdResult);
    assertTrue(actualIsPrimaryResult);
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
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
   * Test Json {@link Json#isPrimary()}.
   *
   * <p>Method under test: {@link Json#isPrimary()}
   */
  @Test
  @DisplayName("Test Json isPrimary()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean Json.isPrimary()"})
  void testJsonIsPrimary() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isPrimary());
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
    assertEquals('\u0000', actualJson.rating);
    assertNull(actualJson.isPrimary);
    assertNull(actualJson.description);
    assertNull(actualJson.provenance);
    assertNull(actualJson.entityReference);
    assertNull(actualJson.lastUpdate);
    assertEquals(0L, actualJson.measurableId);
    assertFalse(actualJson.previousRating.isPresent());
    assertFalse(actualJson.measurableIdIsSet);
    assertFalse(actualJson.ratingIsSet);
  }

  /**
   * Test Json {@link Json#previousRating()}.
   *
   * <p>Method under test: {@link Json#previousRating()}
   */
  @Test
  @DisplayName("Test Json previousRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.previousRating()"})
  void testJsonPreviousRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().previousRating());
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#rating()}.
   *
   * <p>Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"char Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rating());
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
   * Test Json {@link Json#setRating(char)}.
   *
   * <p>Method under test: {@link Json#setRating(char)}
   */
  @Test
  @DisplayName("Test Json setRating(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRating(char)"})
  void testJsonSetRating() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRating('A');

    // Assert
    assertEquals('A', json.rating);
    assertTrue(json.ratingIsSet);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#previousRating()}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#previousRating()}
   */
  @Test
  @DisplayName("Test previousRating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableSaveMeasurableRatingCommand.previousRating()"})
  void testPreviousRating() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    Optional<Character> actualPreviousRatingResult =
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
            .build()
            .previousRating();

    // Assert
    assertEquals('A', actualPreviousRatingResult.get().charValue());
    assertTrue(actualPreviousRatingResult.isPresent());
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSaveMeasurableRatingCommand.toString()"})
  void testToString() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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

    // Act and Assert
    assertEquals(
        "SaveMeasurableRatingCommand{provenance=Provenance, entityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, measurableId=1, lastUpdate=UserTimestamp{at=1970-01-01T00:00, by=By,"
            + " atTimestamp=1970-01-01 00:00:00.0}, rating=A, previousRating=A, isPrimary=true}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableSaveMeasurableRatingCommand.toString()"})
  void testToString2() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
            .isPrimary(null);

    // Act and Assert
    assertEquals(
        "SaveMeasurableRatingCommand{provenance=Provenance, entityReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, measurableId=1, lastUpdate=UserTimestamp{at=1970-01-01T00:00, by=By,"
            + " atTimestamp=1970-01-01 00:00:00.0}, rating=A, previousRating=A}",
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
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();

    // Act
    ImmutableSaveMeasurableRatingCommand actualWithDescriptionResult =
        immutableSaveMeasurableRatingCommand.withDescription("42");

    // Assert
    assertEquals(immutableSaveMeasurableRatingCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder descriptionResult = ImmutableSaveMeasurableRatingCommand.builder().description("42");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();

    // Act
    ImmutableSaveMeasurableRatingCommand actualWithDescriptionResult =
        immutableSaveMeasurableRatingCommand.withDescription("42");

    // Assert
    assertSame(immutableSaveMeasurableRatingCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableSaveMeasurableRatingCommand#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();

    // Act
    ImmutableSaveMeasurableRatingCommand actualWithEntityReferenceResult =
        immutableSaveMeasurableRatingCommand.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableSaveMeasurableRatingCommand, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withIsPrimary(Boolean)}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withIsPrimary(Boolean)}
   */
  @Test
  @DisplayName("Test withIsPrimary(Boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withIsPrimary(Boolean)"
  })
  void testWithIsPrimary() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();

    // Act
    ImmutableSaveMeasurableRatingCommand actualWithIsPrimaryResult =
        immutableSaveMeasurableRatingCommand.withIsPrimary(true);

    // Assert
    assertSame(immutableSaveMeasurableRatingCommand, actualWithIsPrimaryResult);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withIsPrimary(Boolean)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withIsPrimary(Boolean)}
   */
  @Test
  @DisplayName("Test withIsPrimary(Boolean); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withIsPrimary(Boolean)"
  })
  void testWithIsPrimary_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
            .isPrimary(false);

    // Act
    ImmutableSaveMeasurableRatingCommand actualWithIsPrimaryResult =
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
            .build()
            .withIsPrimary(true);

    // Assert
    EntityReference entityReferenceResult = actualWithIsPrimaryResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    UserTimestamp lastUpdateResult = actualWithIsPrimaryResult.lastUpdate();
    assertTrue(lastUpdateResult instanceof ImmutableUserTimestamp);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(lastUpdateResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    assertEquals("By", lastUpdateResult.by());
    assertEquals("Provenance", actualWithIsPrimaryResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithIsPrimaryResult.description());
    assertEquals('A', actualWithIsPrimaryResult.rating());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithIsPrimaryResult.measurableId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithIsPrimaryResult.isPrimary());
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withLastUpdate(UserTimestamp)}.
   *
   * <p>Method under test: {@link
   * ImmutableSaveMeasurableRatingCommand#withLastUpdate(UserTimestamp)}
   */
  @Test
  @DisplayName("Test withLastUpdate(UserTimestamp)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withLastUpdate(UserTimestamp)"
  })
  void testWithLastUpdate() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();

    // Act
    ImmutableSaveMeasurableRatingCommand actualWithLastUpdateResult =
        immutableSaveMeasurableRatingCommand.withLastUpdate(
            ImmutableUserTimestamp.builder()
                .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                .by("By")
                .build());

    // Assert
    assertEquals(immutableSaveMeasurableRatingCommand, actualWithLastUpdateResult);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withMeasurableId(long)}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withMeasurableId(long)}
   */
  @Test
  @DisplayName("Test withMeasurableId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withMeasurableId(long)"
  })
  void testWithMeasurableId() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
        isPrimaryResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(42L)
            .previousRating('A')
            .provenance("Provenance")
            .rating('A')
            .build();

    // Act
    ImmutableSaveMeasurableRatingCommand actualWithMeasurableIdResult =
        immutableSaveMeasurableRatingCommand.withMeasurableId(42L);

    // Assert
    assertSame(immutableSaveMeasurableRatingCommand, actualWithMeasurableIdResult);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withMeasurableId(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withMeasurableId(long)}
   */
  @Test
  @DisplayName("Test withMeasurableId(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withMeasurableId(long)"
  })
  void testWithMeasurableId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand actualWithMeasurableIdResult =
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
            .build()
            .withMeasurableId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithMeasurableIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    UserTimestamp lastUpdateResult = actualWithMeasurableIdResult.lastUpdate();
    assertTrue(lastUpdateResult instanceof ImmutableUserTimestamp);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(lastUpdateResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    assertEquals("By", lastUpdateResult.by());
    assertEquals("Provenance", actualWithMeasurableIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithMeasurableIdResult.description());
    assertEquals('A', actualWithMeasurableIdResult.rating());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithMeasurableIdResult.measurableId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithMeasurableIdResult.isPrimary());
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withPreviousRating(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withPreviousRating(Optional)}
   */
  @Test
  @DisplayName("Test withPreviousRating(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withPreviousRating(Optional)"
  })
  void testWithPreviousRatingWithOptional() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();
    Optional<Character> optional = Optional.of('A');

    // Act
    ImmutableSaveMeasurableRatingCommand actualWithPreviousRatingResult =
        immutableSaveMeasurableRatingCommand.withPreviousRating(optional);

    // Assert
    assertSame(immutableSaveMeasurableRatingCommand, actualWithPreviousRatingResult);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withPreviousRating(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withPreviousRating(Optional)}
   */
  @Test
  @DisplayName("Test withPreviousRating(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withPreviousRating(Optional)"
  })
  void testWithPreviousRatingWithOptional2() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
        isPrimaryResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .previousRating('\u0001')
            .provenance("Provenance")
            .rating('A')
            .build();
    Optional<Character> optional = Optional.of('A');

    // Act
    ImmutableSaveMeasurableRatingCommand actualWithPreviousRatingResult =
        immutableSaveMeasurableRatingCommand.withPreviousRating(optional);

    // Assert
    EntityReference entityReferenceResult = actualWithPreviousRatingResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    UserTimestamp lastUpdateResult = actualWithPreviousRatingResult.lastUpdate();
    assertTrue(lastUpdateResult instanceof ImmutableUserTimestamp);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(lastUpdateResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    assertEquals("By", lastUpdateResult.by());
    assertEquals("Provenance", actualWithPreviousRatingResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something",
        actualWithPreviousRatingResult.description());
    assertEquals('A', actualWithPreviousRatingResult.rating());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithPreviousRatingResult.measurableId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithPreviousRatingResult.isPrimary());
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withPreviousRating(char)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withPreviousRating(char)}
   */
  @Test
  @DisplayName("Test withPreviousRating(char) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withPreviousRating(char)"
  })
  void testWithPreviousRatingWithValue() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();

    // Act
    ImmutableSaveMeasurableRatingCommand actualWithPreviousRatingResult =
        immutableSaveMeasurableRatingCommand.withPreviousRating('A');

    // Assert
    assertSame(immutableSaveMeasurableRatingCommand, actualWithPreviousRatingResult);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withPreviousRating(char)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withPreviousRating(char)}
   */
  @Test
  @DisplayName("Test withPreviousRating(char) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withPreviousRating(char)"
  })
  void testWithPreviousRatingWithValue2() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand actualWithPreviousRatingResult =
        isPrimaryResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .previousRating('\u0001')
            .provenance("Provenance")
            .rating('A')
            .build()
            .withPreviousRating('A');

    // Assert
    EntityReference entityReferenceResult = actualWithPreviousRatingResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    UserTimestamp lastUpdateResult = actualWithPreviousRatingResult.lastUpdate();
    assertTrue(lastUpdateResult instanceof ImmutableUserTimestamp);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(lastUpdateResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    assertEquals("By", lastUpdateResult.by());
    assertEquals("Provenance", actualWithPreviousRatingResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something",
        actualWithPreviousRatingResult.description());
    assertEquals('A', actualWithPreviousRatingResult.rating());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithPreviousRatingResult.measurableId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithPreviousRatingResult.isPrimary());
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
        isPrimaryResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .previousRating('A')
            .provenance("42")
            .rating('A')
            .build();

    // Act
    ImmutableSaveMeasurableRatingCommand actualWithProvenanceResult =
        immutableSaveMeasurableRatingCommand.withProvenance("42");

    // Assert
    assertSame(immutableSaveMeasurableRatingCommand, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withProvenance(String)"
  })
  void testWithProvenance_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand actualWithProvenanceResult =
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
            .build()
            .withProvenance("42");

    // Assert
    EntityReference entityReferenceResult = actualWithProvenanceResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    UserTimestamp lastUpdateResult = actualWithProvenanceResult.lastUpdate();
    assertTrue(lastUpdateResult instanceof ImmutableUserTimestamp);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(lastUpdateResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("By", lastUpdateResult.by());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals('A', actualWithProvenanceResult.rating());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithProvenanceResult.measurableId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithProvenanceResult.isPrimary());
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withRating(char)}.
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withRating(char)}
   */
  @Test
  @DisplayName("Test withRating(char)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withRating(char)"
  })
  void testWithRating() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand immutableSaveMeasurableRatingCommand =
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
            .build();

    // Act
    ImmutableSaveMeasurableRatingCommand actualWithRatingResult =
        immutableSaveMeasurableRatingCommand.withRating('A');

    // Assert
    assertSame(immutableSaveMeasurableRatingCommand, actualWithRatingResult);
  }

  /**
   * Test {@link ImmutableSaveMeasurableRatingCommand#withRating(char)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableSaveMeasurableRatingCommand#withRating(char)}
   */
  @Test
  @DisplayName("Test withRating(char); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableSaveMeasurableRatingCommand ImmutableSaveMeasurableRatingCommand.withRating(char)"
  })
  void testWithRating_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder descriptionResult =
        ImmutableSaveMeasurableRatingCommand.builder()
            .description("The characteristics of someone or something");

    Builder isPrimaryResult =
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
    ImmutableSaveMeasurableRatingCommand actualWithRatingResult =
        isPrimaryResult
            .lastUpdate(
                ImmutableUserTimestamp.builder()
                    .at(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .by("By")
                    .build())
            .measurableId(1L)
            .previousRating('A')
            .provenance("Provenance")
            .rating('\u0000')
            .build()
            .withRating('A');

    // Assert
    EntityReference entityReferenceResult = actualWithRatingResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    UserTimestamp lastUpdateResult = actualWithRatingResult.lastUpdate();
    assertTrue(lastUpdateResult instanceof ImmutableUserTimestamp);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String actualFormatResult = simpleDateFormat.format(lastUpdateResult.atTimestamp());
    assertEquals("1970-01-01", actualFormatResult);
    assertEquals("By", lastUpdateResult.by());
    assertEquals("Provenance", actualWithRatingResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithRatingResult.description());
    assertEquals('A', actualWithRatingResult.rating());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithRatingResult.measurableId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithRatingResult.isPrimary());
  }
}
