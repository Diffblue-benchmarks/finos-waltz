package org.finos.waltz.model.report_grid;

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
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.entity_field_reference.EntityFieldReference;
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridFixedColumnDefinitionDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#additionalColumnOptions(AdditionalColumnOptions)}
   *   <li>{@link Builder#columnDescription(String)}
   *   <li>{@link Builder#columnEntityId(Long)}
   *   <li>{@link Builder#columnName(String)}
   *   <li>{@link Builder#columnQualifierId(Long)}
   *   <li>{@link Builder#columnQualifierKind(EntityKind)}
   *   <li>{@link Builder#displayName(String)}
   *   <li>{@link Builder#entityFieldReference(EntityFieldReference)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#gridColumnId(Long)}
   *   <li>{@link Builder#id(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.additionalColumnOptions(AdditionalColumnOptions)",
    "ImmutableReportGridFixedColumnDefinition Builder.build()",
    "Builder Builder.columnDescription(String)",
    "Builder Builder.columnEntityId(Long)",
    "Builder Builder.columnName(String)",
    "Builder Builder.columnQualifierId(Long)",
    "Builder Builder.columnQualifierKind(EntityKind)",
    "Builder Builder.displayName(String)",
    "Builder Builder.entityFieldReference(EntityFieldReference)",
    "Builder Builder.externalId(String)",
    "Builder Builder.gridColumnId(Long)",
    "Builder Builder.id(Long)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDisplayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableEntityFieldReference entityFieldReference =
        ImmutableEntityFieldReference.builder()
            .description("The characteristics of someone or something")
            .displayName("Display Name")
            .entityKind(EntityKind.ALL)
            .fieldName("Field Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .build();
    Builder actualExternalIdResult =
        actualDisplayNameResult.entityFieldReference(entityFieldReference).externalId("42");
    Optional<String> externalId = Optional.of("42");
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition =
        actualExternalIdResult.externalId(externalId).gridColumnId(1L).id(1L).position(1).build();

    // Assert
    assertEquals(
        "Column Description", actualImmutableReportGridFixedColumnDefinition.columnDescription());
    assertEquals("Column Name", actualImmutableReportGridFixedColumnDefinition.columnName());
    assertEquals("Display Name", actualImmutableReportGridFixedColumnDefinition.displayName());
    assertEquals(1, actualImmutableReportGridFixedColumnDefinition.position());
    assertEquals(1L, actualImmutableReportGridFixedColumnDefinition.columnEntityId().longValue());
    assertEquals(
        1L, actualImmutableReportGridFixedColumnDefinition.columnQualifierId().longValue());
    assertEquals(1L, actualImmutableReportGridFixedColumnDefinition.gridColumnId().longValue());
    assertEquals(1L, actualImmutableReportGridFixedColumnDefinition.id().longValue());
    assertEquals(EntityKind.ALL, actualImmutableReportGridFixedColumnDefinition.columnEntityKind());
    assertEquals(
        EntityKind.ALL, actualImmutableReportGridFixedColumnDefinition.columnQualifierKind());
    assertEquals(
        EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION,
        actualImmutableReportGridFixedColumnDefinition.kind());
    assertEquals(
        AdditionalColumnOptions.NONE,
        actualImmutableReportGridFixedColumnDefinition.additionalColumnOptions());
    assertSame(
        entityFieldReference,
        actualImmutableReportGridFixedColumnDefinition.entityFieldReference());
  }

  /**
   * Test Builder {@link Builder#columnEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#columnEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder columnEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.columnEntityKind(EntityKind)"})
  void testBuilderColumnEntityKind() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    // Act
    Builder actualColumnEntityKindResult = builderResult.columnEntityKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualColumnEntityKindResult);
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    Optional<String> externalId = Optional.of("42");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition instance =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition);
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOf42() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("42");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition instance =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition);
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition2() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription(null)
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition instance =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition);
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition3() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(null)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition instance =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition);
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition4() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName(null)
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition instance =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition);
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition5() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(null)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition instance =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition);
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition6() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(null)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition instance =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition);
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition7() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName(null);
    ImmutableReportGridFixedColumnDefinition instance =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition);
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition8() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition instance =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(null)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition);
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code
   * ReportGridFixedColumnDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition9() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition instance =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(null)
            .position(1)
            .build();

    // Act and Assert
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition);
    ImmutableReportGridFixedColumnDefinition actualImmutableReportGridFixedColumnDefinition2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridFixedColumnDefinition2);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}.
   *
   * <ul>
   *   <li>Then entityFieldReference return {@link ImmutableEntityFieldReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ReportGridFixedColumnDefinition); then entityFieldReference return ImmutableEntityFieldReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.copyOf(ReportGridFixedColumnDefinition)"
  })
  void testCopyOf_thenEntityFieldReferenceReturnImmutableEntityFieldReference() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition instance =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualCopyOfResult =
        ImmutableReportGridFixedColumnDefinition.copyOf(instance);

    // Assert
    assertTrue(actualCopyOfResult.entityFieldReference() instanceof ImmutableEntityFieldReference);
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Column Name", actualCopyOfResult.columnName());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.columnEntityId().longValue());
    assertEquals(1L, actualCopyOfResult.columnQualifierId().longValue());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualCopyOfResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualCopyOfResult.additionalColumnOptions());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}, and {@link
   * ImmutableReportGridFixedColumnDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition2 =
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    assertEquals(
        immutableReportGridFixedColumnDefinition, immutableReportGridFixedColumnDefinition2);
    assertEquals(
        immutableReportGridFixedColumnDefinition.hashCode(),
        immutableReportGridFixedColumnDefinition2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}, and {@link
   * ImmutableReportGridFixedColumnDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act and Assert
    assertEquals(
        immutableReportGridFixedColumnDefinition, immutableReportGridFixedColumnDefinition);
    int expectedHashCodeResult = immutableReportGridFixedColumnDefinition.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridFixedColumnDefinition.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.PICK_HIGHEST)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Field Name")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(2L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ACTOR)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Field Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(2L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ACTOR)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Field Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("Field Name")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("Field Name")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(2L)
            .id(1L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(2L)
            .position(1)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(0)
            .build();

    Builder displayNameResult2 =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        immutableReportGridFixedColumnDefinition,
        displayNameResult2
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridFixedColumnDefinition.equals(Object)",
    "int ImmutableReportGridFixedColumnDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertNotEquals(
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build(),
        "Different type to ImmutableReportGridFixedColumnDefinition");
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#externalId()}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableReportGridFixedColumnDefinition.externalId()"})
  void testExternalId() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    Optional<String> actualExternalIdResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#additionalColumnOptions()}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnDescription()}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnEntityId()}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnEntityKind()}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnName()}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnQualifierId()}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnQualifierKind()}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#displayName()}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#entityFieldReference()}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#gridColumnId()}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#id()}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#position()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdditionalColumnOptions ImmutableReportGridFixedColumnDefinition.additionalColumnOptions()",
    "String ImmutableReportGridFixedColumnDefinition.columnDescription()",
    "Long ImmutableReportGridFixedColumnDefinition.columnEntityId()",
    "EntityKind ImmutableReportGridFixedColumnDefinition.columnEntityKind()",
    "String ImmutableReportGridFixedColumnDefinition.columnName()",
    "Long ImmutableReportGridFixedColumnDefinition.columnQualifierId()",
    "EntityKind ImmutableReportGridFixedColumnDefinition.columnQualifierKind()",
    "String ImmutableReportGridFixedColumnDefinition.displayName()",
    "EntityFieldReference ImmutableReportGridFixedColumnDefinition.entityFieldReference()",
    "Long ImmutableReportGridFixedColumnDefinition.gridColumnId()",
    "Long ImmutableReportGridFixedColumnDefinition.id()",
    "int ImmutableReportGridFixedColumnDefinition.position()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    AdditionalColumnOptions actualAdditionalColumnOptionsResult =
        immutableReportGridFixedColumnDefinition.additionalColumnOptions();
    String actualColumnDescriptionResult =
        immutableReportGridFixedColumnDefinition.columnDescription();
    Long actualColumnEntityIdResult = immutableReportGridFixedColumnDefinition.columnEntityId();
    EntityKind actualColumnEntityKindResult =
        immutableReportGridFixedColumnDefinition.columnEntityKind();
    String actualColumnNameResult = immutableReportGridFixedColumnDefinition.columnName();
    Long actualColumnQualifierIdResult =
        immutableReportGridFixedColumnDefinition.columnQualifierId();
    EntityKind actualColumnQualifierKindResult =
        immutableReportGridFixedColumnDefinition.columnQualifierKind();
    String actualDisplayNameResult = immutableReportGridFixedColumnDefinition.displayName();
    EntityFieldReference actualEntityFieldReferenceResult =
        immutableReportGridFixedColumnDefinition.entityFieldReference();
    Long actualGridColumnIdResult = immutableReportGridFixedColumnDefinition.gridColumnId();
    Long actualIdResult = immutableReportGridFixedColumnDefinition.id();

    // Assert
    assertTrue(actualEntityFieldReferenceResult instanceof ImmutableEntityFieldReference);
    assertEquals("Column Description", actualColumnDescriptionResult);
    assertEquals("Column Name", actualColumnNameResult);
    assertEquals("Display Name", actualDisplayNameResult);
    assertEquals(1, immutableReportGridFixedColumnDefinition.position());
    assertEquals(1L, actualColumnEntityIdResult.longValue());
    assertEquals(1L, actualColumnQualifierIdResult.longValue());
    assertEquals(1L, actualGridColumnIdResult.longValue());
    assertEquals(1L, actualIdResult.longValue());
    assertEquals(EntityKind.ALL, actualColumnEntityKindResult);
    assertEquals(EntityKind.ALL, actualColumnQualifierKindResult);
    assertEquals(AdditionalColumnOptions.NONE, actualAdditionalColumnOptionsResult);
  }

  /**
   * Test Json {@link Json#additionalColumnOptions()}.
   *
   * <p>Method under test: {@link Json#additionalColumnOptions()}
   */
  @Test
  @DisplayName("Test Json additionalColumnOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AdditionalColumnOptions Json.additionalColumnOptions()"})
  void testJsonAdditionalColumnOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().additionalColumnOptions());
  }

  /**
   * Test Json {@link Json#columnDescription()}.
   *
   * <p>Method under test: {@link Json#columnDescription()}
   */
  @Test
  @DisplayName("Test Json columnDescription()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.columnDescription()"})
  void testJsonColumnDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnDescription());
  }

  /**
   * Test Json {@link Json#columnEntityId()}.
   *
   * <p>Method under test: {@link Json#columnEntityId()}
   */
  @Test
  @DisplayName("Test Json columnEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.columnEntityId()"})
  void testJsonColumnEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnEntityId());
  }

  /**
   * Test Json {@link Json#columnEntityKind()}.
   *
   * <p>Method under test: {@link Json#columnEntityKind()}
   */
  @Test
  @DisplayName("Test Json columnEntityKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.columnEntityKind()"})
  void testJsonColumnEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnEntityKind());
  }

  /**
   * Test Json {@link Json#columnName()}.
   *
   * <p>Method under test: {@link Json#columnName()}
   */
  @Test
  @DisplayName("Test Json columnName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.columnName()"})
  void testJsonColumnName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnName());
  }

  /**
   * Test Json {@link Json#columnQualifierId()}.
   *
   * <p>Method under test: {@link Json#columnQualifierId()}
   */
  @Test
  @DisplayName("Test Json columnQualifierId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.columnQualifierId()"})
  void testJsonColumnQualifierId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnQualifierId());
  }

  /**
   * Test Json {@link Json#columnQualifierKind()}.
   *
   * <p>Method under test: {@link Json#columnQualifierKind()}
   */
  @Test
  @DisplayName("Test Json columnQualifierKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.columnQualifierKind()"})
  void testJsonColumnQualifierKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnQualifierKind());
  }

  /**
   * Test Json {@link Json#displayName()}.
   *
   * <p>Method under test: {@link Json#displayName()}
   */
  @Test
  @DisplayName("Test Json displayName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.displayName()"})
  void testJsonDisplayName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().displayName());
  }

  /**
   * Test Json {@link Json#entityFieldReference()}.
   *
   * <p>Method under test: {@link Json#entityFieldReference()}
   */
  @Test
  @DisplayName("Test Json entityFieldReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityFieldReference Json.entityFieldReference()"})
  void testJsonEntityFieldReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityFieldReference());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#gridColumnId()}.
   *
   * <p>Method under test: {@link Json#gridColumnId()}
   */
  @Test
  @DisplayName("Test Json gridColumnId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.gridColumnId()"})
  void testJsonGridColumnId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().gridColumnId());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
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
    assertNull(actualJson.columnEntityId);
    assertNull(actualJson.columnQualifierId);
    assertNull(actualJson.gridColumnId);
    assertNull(actualJson.id);
    assertNull(actualJson.columnDescription);
    assertNull(actualJson.columnName);
    assertNull(actualJson.displayName);
    assertNull(actualJson.columnEntityKind);
    assertNull(actualJson.columnQualifierKind);
    assertNull(actualJson.entityFieldReference);
    assertNull(actualJson.additionalColumnOptions);
    assertEquals(0, actualJson.position);
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualJson.kind());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridFixedColumnDefinition.toString()"})
  void testToString() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertEquals(
        "ReportGridFixedColumnDefinition{externalId=42, id=1, gridColumnId=1, columnEntityKind=ALL, columnEntityId=1,"
            + " columnName=Column Name, columnDescription=Column Description, position=1, additionalColumnOptions=NONE,"
            + " displayName=Display Name, entityFieldReference=EntityFieldReference{id=1, entityKind=ALL, fieldName=Field"
            + " Name, displayName=Display Name, description=The characteristics of someone or something, kind=ALL},"
            + " columnQualifierKind=ALL, columnQualifierId=1}",
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridFixedColumnDefinition.toString()"})
  void testToString2() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription(null)
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertEquals(
        "ReportGridFixedColumnDefinition{externalId=42, id=1, gridColumnId=1, columnEntityKind=ALL, columnEntityId=1,"
            + " columnName=Column Name, position=1, additionalColumnOptions=NONE, displayName=Display Name,"
            + " entityFieldReference=EntityFieldReference{id=1, entityKind=ALL, fieldName=Field Name, displayName=Display"
            + " Name, description=The characteristics of someone or something, kind=ALL}, columnQualifierKind=ALL,"
            + " columnQualifierId=1}",
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridFixedColumnDefinition.toString()"})
  void testToString3() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(null)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertEquals(
        "ReportGridFixedColumnDefinition{externalId=42, id=1, gridColumnId=1, columnEntityKind=ALL, columnName=Column"
            + " Name, columnDescription=Column Description, position=1, additionalColumnOptions=NONE, displayName=Display"
            + " Name, entityFieldReference=EntityFieldReference{id=1, entityKind=ALL, fieldName=Field Name,"
            + " displayName=Display Name, description=The characteristics of someone or something, kind=ALL},"
            + " columnQualifierKind=ALL, columnQualifierId=1}",
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridFixedColumnDefinition.toString()"})
  void testToString4() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName(null)
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertEquals(
        "ReportGridFixedColumnDefinition{externalId=42, id=1, gridColumnId=1, columnEntityKind=ALL, columnEntityId=1,"
            + " columnDescription=Column Description, position=1, additionalColumnOptions=NONE, displayName=Display"
            + " Name, entityFieldReference=EntityFieldReference{id=1, entityKind=ALL, fieldName=Field Name,"
            + " displayName=Display Name, description=The characteristics of someone or something, kind=ALL},"
            + " columnQualifierKind=ALL, columnQualifierId=1}",
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridFixedColumnDefinition.toString()"})
  void testToString5() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(null)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertEquals(
        "ReportGridFixedColumnDefinition{externalId=42, id=1, gridColumnId=1, columnEntityKind=ALL, columnEntityId=1,"
            + " columnName=Column Name, columnDescription=Column Description, position=1, additionalColumnOptions=NONE,"
            + " displayName=Display Name, entityFieldReference=EntityFieldReference{id=1, entityKind=ALL, fieldName=Field"
            + " Name, displayName=Display Name, description=The characteristics of someone or something, kind=ALL},"
            + " columnQualifierKind=ALL}",
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridFixedColumnDefinition.toString()"})
  void testToString6() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(null)
            .displayName("Display Name");

    // Act and Assert
    assertEquals(
        "ReportGridFixedColumnDefinition{externalId=42, id=1, gridColumnId=1, columnEntityKind=ALL, columnEntityId=1,"
            + " columnName=Column Name, columnDescription=Column Description, position=1, additionalColumnOptions=NONE,"
            + " displayName=Display Name, entityFieldReference=EntityFieldReference{id=1, entityKind=ALL, fieldName=Field"
            + " Name, displayName=Display Name, description=The characteristics of someone or something, kind=ALL},"
            + " columnQualifierId=1}",
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridFixedColumnDefinition.toString()"})
  void testToString7() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName(null);

    // Act and Assert
    assertEquals(
        "ReportGridFixedColumnDefinition{externalId=42, id=1, gridColumnId=1, columnEntityKind=ALL, columnEntityId=1,"
            + " columnName=Column Name, columnDescription=Column Description, position=1, additionalColumnOptions=NONE,"
            + " entityFieldReference=EntityFieldReference{id=1, entityKind=ALL, fieldName=Field Name, displayName=Display"
            + " Name, description=The characteristics of someone or something, kind=ALL}, columnQualifierKind=ALL,"
            + " columnQualifierId=1}",
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridFixedColumnDefinition.toString()"})
  void testToString8() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertEquals(
        "ReportGridFixedColumnDefinition{externalId=42, id=1, columnEntityKind=ALL, columnEntityId=1,"
            + " columnName=Column Name, columnDescription=Column Description, position=1, additionalColumnOptions=NONE,"
            + " displayName=Display Name, entityFieldReference=EntityFieldReference{id=1, entityKind=ALL, fieldName=Field"
            + " Name, displayName=Display Name, description=The characteristics of someone or something, kind=ALL},"
            + " columnQualifierKind=ALL, columnQualifierId=1}",
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(null)
            .id(1L)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridFixedColumnDefinition.toString()"})
  void testToString9() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act and Assert
    assertEquals(
        "ReportGridFixedColumnDefinition{externalId=42, gridColumnId=1, columnEntityKind=ALL, columnEntityId=1,"
            + " columnName=Column Name, columnDescription=Column Description, position=1, additionalColumnOptions=NONE,"
            + " displayName=Display Name, entityFieldReference=EntityFieldReference{id=1, entityKind=ALL, fieldName=Field"
            + " Name, displayName=Display Name, description=The characteristics of someone or something, kind=ALL},"
            + " columnQualifierKind=ALL, columnQualifierId=1}",
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(null)
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link
   * ImmutableReportGridFixedColumnDefinition#withAdditionalColumnOptions(AdditionalColumnOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFixedColumnDefinition#withAdditionalColumnOptions(AdditionalColumnOptions)}
   */
  @Test
  @DisplayName("Test withAdditionalColumnOptions(AdditionalColumnOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withAdditionalColumnOptions(AdditionalColumnOptions)"
  })
  void testWithAdditionalColumnOptions() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithAdditionalColumnOptionsResult =
        immutableReportGridFixedColumnDefinition.withAdditionalColumnOptions(
            AdditionalColumnOptions.NONE);

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithAdditionalColumnOptionsResult);
  }

  /**
   * Test {@link
   * ImmutableReportGridFixedColumnDefinition#withAdditionalColumnOptions(AdditionalColumnOptions)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFixedColumnDefinition#withAdditionalColumnOptions(AdditionalColumnOptions)}
   */
  @Test
  @DisplayName("Test withAdditionalColumnOptions(AdditionalColumnOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withAdditionalColumnOptions(AdditionalColumnOptions)"
  })
  void testWithAdditionalColumnOptions2() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.PICK_HIGHEST)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithAdditionalColumnOptionsResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withAdditionalColumnOptions(AdditionalColumnOptions.NONE);

    // Assert
    assertTrue(
        actualWithAdditionalColumnOptionsResult.entityFieldReference()
            instanceof ImmutableEntityFieldReference);
    assertEquals("Column Description", actualWithAdditionalColumnOptionsResult.columnDescription());
    assertEquals("Column Name", actualWithAdditionalColumnOptionsResult.columnName());
    assertEquals("Display Name", actualWithAdditionalColumnOptionsResult.displayName());
    assertEquals(1, actualWithAdditionalColumnOptionsResult.position());
    assertEquals(1L, actualWithAdditionalColumnOptionsResult.columnEntityId().longValue());
    assertEquals(1L, actualWithAdditionalColumnOptionsResult.columnQualifierId().longValue());
    assertEquals(1L, actualWithAdditionalColumnOptionsResult.gridColumnId().longValue());
    assertEquals(1L, actualWithAdditionalColumnOptionsResult.id().longValue());
    assertEquals(EntityKind.ALL, actualWithAdditionalColumnOptionsResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithAdditionalColumnOptionsResult.columnQualifierKind());
    assertEquals(
        EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION,
        actualWithAdditionalColumnOptionsResult.kind());
    assertEquals(
        AdditionalColumnOptions.NONE,
        actualWithAdditionalColumnOptionsResult.additionalColumnOptions());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withColumnDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFixedColumnDefinition#withColumnDescription(String)}
   */
  @Test
  @DisplayName("Test withColumnDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withColumnDescription(String)"
  })
  void testWithColumnDescription() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithColumnDescriptionResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withColumnDescription("42");

    // Assert
    assertTrue(
        actualWithColumnDescriptionResult.entityFieldReference()
            instanceof ImmutableEntityFieldReference);
    assertEquals("42", actualWithColumnDescriptionResult.columnDescription());
    assertEquals("Column Name", actualWithColumnDescriptionResult.columnName());
    assertEquals("Display Name", actualWithColumnDescriptionResult.displayName());
    assertEquals(1, actualWithColumnDescriptionResult.position());
    assertEquals(1L, actualWithColumnDescriptionResult.columnEntityId().longValue());
    assertEquals(1L, actualWithColumnDescriptionResult.columnQualifierId().longValue());
    assertEquals(1L, actualWithColumnDescriptionResult.gridColumnId().longValue());
    assertEquals(1L, actualWithColumnDescriptionResult.id().longValue());
    assertEquals(EntityKind.ALL, actualWithColumnDescriptionResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithColumnDescriptionResult.columnQualifierKind());
    assertEquals(
        EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualWithColumnDescriptionResult.kind());
    assertEquals(
        AdditionalColumnOptions.NONE, actualWithColumnDescriptionResult.additionalColumnOptions());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withColumnDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFixedColumnDefinition#withColumnDescription(String)}
   */
  @Test
  @DisplayName("Test withColumnDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withColumnDescription(String)"
  })
  void testWithColumnDescription2() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("42")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithColumnDescriptionResult =
        immutableReportGridFixedColumnDefinition.withColumnDescription("42");

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithColumnDescriptionResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withColumnEntityId(Long)}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withColumnEntityId(Long)}
   */
  @Test
  @DisplayName("Test withColumnEntityId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withColumnEntityId(Long)"
  })
  void testWithColumnEntityId() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithColumnEntityIdResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withColumnEntityId(42L);

    // Assert
    assertTrue(
        actualWithColumnEntityIdResult.entityFieldReference()
            instanceof ImmutableEntityFieldReference);
    assertEquals("Column Description", actualWithColumnEntityIdResult.columnDescription());
    assertEquals("Column Name", actualWithColumnEntityIdResult.columnName());
    assertEquals("Display Name", actualWithColumnEntityIdResult.displayName());
    assertEquals(1, actualWithColumnEntityIdResult.position());
    assertEquals(1L, actualWithColumnEntityIdResult.columnQualifierId().longValue());
    assertEquals(1L, actualWithColumnEntityIdResult.gridColumnId().longValue());
    assertEquals(1L, actualWithColumnEntityIdResult.id().longValue());
    assertEquals(42L, actualWithColumnEntityIdResult.columnEntityId().longValue());
    assertEquals(EntityKind.ALL, actualWithColumnEntityIdResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithColumnEntityIdResult.columnQualifierKind());
    assertEquals(
        EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualWithColumnEntityIdResult.kind());
    assertEquals(
        AdditionalColumnOptions.NONE, actualWithColumnEntityIdResult.additionalColumnOptions());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withColumnEntityId(Long)}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withColumnEntityId(Long)}
   */
  @Test
  @DisplayName("Test withColumnEntityId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withColumnEntityId(Long)"
  })
  void testWithColumnEntityId2() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithColumnEntityIdResult =
        immutableReportGridFixedColumnDefinition.withColumnEntityId(1L);

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithColumnEntityIdResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withColumnEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFixedColumnDefinition#withColumnEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withColumnEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withColumnEntityKind(EntityKind)"
  })
  void testWithColumnEntityKind() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithColumnEntityKindResult =
        immutableReportGridFixedColumnDefinition.withColumnEntityKind(EntityKind.ALL);

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithColumnEntityKindResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withColumnEntityKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFixedColumnDefinition#withColumnEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withColumnEntityKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withColumnEntityKind(EntityKind)"
  })
  void testWithColumnEntityKind2() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ACTOR)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithColumnEntityKindResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withColumnEntityKind(EntityKind.ALL);

    // Assert
    assertTrue(
        actualWithColumnEntityKindResult.entityFieldReference()
            instanceof ImmutableEntityFieldReference);
    assertEquals("Column Description", actualWithColumnEntityKindResult.columnDescription());
    assertEquals("Column Name", actualWithColumnEntityKindResult.columnName());
    assertEquals("Display Name", actualWithColumnEntityKindResult.displayName());
    assertEquals(1, actualWithColumnEntityKindResult.position());
    assertEquals(1L, actualWithColumnEntityKindResult.columnEntityId().longValue());
    assertEquals(1L, actualWithColumnEntityKindResult.columnQualifierId().longValue());
    assertEquals(1L, actualWithColumnEntityKindResult.gridColumnId().longValue());
    assertEquals(1L, actualWithColumnEntityKindResult.id().longValue());
    assertEquals(EntityKind.ALL, actualWithColumnEntityKindResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithColumnEntityKindResult.columnQualifierKind());
    assertEquals(
        EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualWithColumnEntityKindResult.kind());
    assertEquals(
        AdditionalColumnOptions.NONE, actualWithColumnEntityKindResult.additionalColumnOptions());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withColumnName(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withColumnName(String)}
   */
  @Test
  @DisplayName("Test withColumnName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withColumnName(String)"
  })
  void testWithColumnName() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("42")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithColumnNameResult =
        immutableReportGridFixedColumnDefinition.withColumnName("42");

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithColumnNameResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withColumnName(String)}.
   *
   * <ul>
   *   <li>Then entityFieldReference return {@link ImmutableEntityFieldReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withColumnName(String)}
   */
  @Test
  @DisplayName(
      "Test withColumnName(String); then entityFieldReference return ImmutableEntityFieldReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withColumnName(String)"
  })
  void testWithColumnName_thenEntityFieldReferenceReturnImmutableEntityFieldReference() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithColumnNameResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withColumnName("42");

    // Assert
    assertTrue(
        actualWithColumnNameResult.entityFieldReference() instanceof ImmutableEntityFieldReference);
    assertEquals("42", actualWithColumnNameResult.columnName());
    assertEquals("Column Description", actualWithColumnNameResult.columnDescription());
    assertEquals("Display Name", actualWithColumnNameResult.displayName());
    assertEquals(1, actualWithColumnNameResult.position());
    assertEquals(1L, actualWithColumnNameResult.columnEntityId().longValue());
    assertEquals(1L, actualWithColumnNameResult.columnQualifierId().longValue());
    assertEquals(1L, actualWithColumnNameResult.gridColumnId().longValue());
    assertEquals(1L, actualWithColumnNameResult.id().longValue());
    assertEquals(EntityKind.ALL, actualWithColumnNameResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithColumnNameResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualWithColumnNameResult.kind());
    assertEquals(
        AdditionalColumnOptions.NONE, actualWithColumnNameResult.additionalColumnOptions());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withColumnQualifierId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFixedColumnDefinition#withColumnQualifierId(Long)}
   */
  @Test
  @DisplayName("Test withColumnQualifierId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withColumnQualifierId(Long)"
  })
  void testWithColumnQualifierId() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithColumnQualifierIdResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withColumnQualifierId(42L);

    // Assert
    assertTrue(
        actualWithColumnQualifierIdResult.entityFieldReference()
            instanceof ImmutableEntityFieldReference);
    assertEquals("Column Description", actualWithColumnQualifierIdResult.columnDescription());
    assertEquals("Column Name", actualWithColumnQualifierIdResult.columnName());
    assertEquals("Display Name", actualWithColumnQualifierIdResult.displayName());
    assertEquals(1, actualWithColumnQualifierIdResult.position());
    assertEquals(1L, actualWithColumnQualifierIdResult.columnEntityId().longValue());
    assertEquals(1L, actualWithColumnQualifierIdResult.gridColumnId().longValue());
    assertEquals(1L, actualWithColumnQualifierIdResult.id().longValue());
    assertEquals(42L, actualWithColumnQualifierIdResult.columnQualifierId().longValue());
    assertEquals(EntityKind.ALL, actualWithColumnQualifierIdResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithColumnQualifierIdResult.columnQualifierKind());
    assertEquals(
        EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualWithColumnQualifierIdResult.kind());
    assertEquals(
        AdditionalColumnOptions.NONE, actualWithColumnQualifierIdResult.additionalColumnOptions());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withColumnQualifierId(Long)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFixedColumnDefinition#withColumnQualifierId(Long)}
   */
  @Test
  @DisplayName("Test withColumnQualifierId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withColumnQualifierId(Long)"
  })
  void testWithColumnQualifierId2() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithColumnQualifierIdResult =
        immutableReportGridFixedColumnDefinition.withColumnQualifierId(1L);

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithColumnQualifierIdResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withColumnQualifierKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFixedColumnDefinition#withColumnQualifierKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withColumnQualifierKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withColumnQualifierKind(EntityKind)"
  })
  void testWithColumnQualifierKind() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithColumnQualifierKindResult =
        immutableReportGridFixedColumnDefinition.withColumnQualifierKind(EntityKind.ALL);

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithColumnQualifierKindResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withColumnQualifierKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFixedColumnDefinition#withColumnQualifierKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withColumnQualifierKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withColumnQualifierKind(EntityKind)"
  })
  void testWithColumnQualifierKind2() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ACTOR)
            .displayName("Display Name");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithColumnQualifierKindResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withColumnQualifierKind(EntityKind.ALL);

    // Assert
    assertTrue(
        actualWithColumnQualifierKindResult.entityFieldReference()
            instanceof ImmutableEntityFieldReference);
    assertEquals("Column Description", actualWithColumnQualifierKindResult.columnDescription());
    assertEquals("Column Name", actualWithColumnQualifierKindResult.columnName());
    assertEquals("Display Name", actualWithColumnQualifierKindResult.displayName());
    assertEquals(1, actualWithColumnQualifierKindResult.position());
    assertEquals(1L, actualWithColumnQualifierKindResult.columnEntityId().longValue());
    assertEquals(1L, actualWithColumnQualifierKindResult.columnQualifierId().longValue());
    assertEquals(1L, actualWithColumnQualifierKindResult.gridColumnId().longValue());
    assertEquals(1L, actualWithColumnQualifierKindResult.id().longValue());
    assertEquals(EntityKind.ALL, actualWithColumnQualifierKindResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithColumnQualifierKindResult.columnQualifierKind());
    assertEquals(
        EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualWithColumnQualifierKindResult.kind());
    assertEquals(
        AdditionalColumnOptions.NONE,
        actualWithColumnQualifierKindResult.additionalColumnOptions());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withDisplayName(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withDisplayName(String)}
   */
  @Test
  @DisplayName("Test withDisplayName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withDisplayName(String)"
  })
  void testWithDisplayName() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("42");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithDisplayNameResult =
        immutableReportGridFixedColumnDefinition.withDisplayName("42");

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithDisplayNameResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withDisplayName(String)}.
   *
   * <ul>
   *   <li>Then entityFieldReference return {@link ImmutableEntityFieldReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withDisplayName(String)}
   */
  @Test
  @DisplayName(
      "Test withDisplayName(String); then entityFieldReference return ImmutableEntityFieldReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withDisplayName(String)"
  })
  void testWithDisplayName_thenEntityFieldReferenceReturnImmutableEntityFieldReference() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithDisplayNameResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withDisplayName("42");

    // Assert
    assertTrue(
        actualWithDisplayNameResult.entityFieldReference()
            instanceof ImmutableEntityFieldReference);
    assertEquals("42", actualWithDisplayNameResult.displayName());
    assertEquals("Column Description", actualWithDisplayNameResult.columnDescription());
    assertEquals("Column Name", actualWithDisplayNameResult.columnName());
    assertEquals(1, actualWithDisplayNameResult.position());
    assertEquals(1L, actualWithDisplayNameResult.columnEntityId().longValue());
    assertEquals(1L, actualWithDisplayNameResult.columnQualifierId().longValue());
    assertEquals(1L, actualWithDisplayNameResult.gridColumnId().longValue());
    assertEquals(1L, actualWithDisplayNameResult.id().longValue());
    assertEquals(EntityKind.ALL, actualWithDisplayNameResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithDisplayNameResult.columnQualifierKind());
    assertEquals(
        EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualWithDisplayNameResult.kind());
    assertEquals(
        AdditionalColumnOptions.NONE, actualWithDisplayNameResult.additionalColumnOptions());
  }

  /**
   * Test {@link
   * ImmutableReportGridFixedColumnDefinition#withEntityFieldReference(EntityFieldReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridFixedColumnDefinition#withEntityFieldReference(EntityFieldReference)}
   */
  @Test
  @DisplayName("Test withEntityFieldReference(EntityFieldReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withEntityFieldReference(EntityFieldReference)"
  })
  void testWithEntityFieldReference() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithEntityFieldReferenceResult =
        immutableReportGridFixedColumnDefinition.withEntityFieldReference(
            ImmutableEntityFieldReference.builder()
                .description("The characteristics of someone or something")
                .displayName("Display Name")
                .entityKind(EntityKind.ALL)
                .fieldName("Field Name")
                .id(1L)
                .kind(EntityKind.ALL)
                .build());

    // Assert
    assertEquals(immutableReportGridFixedColumnDefinition, actualWithEntityFieldReferenceResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withExternalId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithExternalIdResult =
        immutableReportGridFixedColumnDefinition.withExternalId(optional);

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withExternalId(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional2() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("External Id")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithExternalIdResult =
        immutableReportGridFixedColumnDefinition.withExternalId(optional);

    // Assert
    assertTrue(
        actualWithExternalIdResult.entityFieldReference() instanceof ImmutableEntityFieldReference);
    assertEquals("Column Description", actualWithExternalIdResult.columnDescription());
    assertEquals("Column Name", actualWithExternalIdResult.columnName());
    assertEquals("Display Name", actualWithExternalIdResult.displayName());
    assertEquals(1, actualWithExternalIdResult.position());
    assertEquals(1L, actualWithExternalIdResult.columnEntityId().longValue());
    assertEquals(1L, actualWithExternalIdResult.columnQualifierId().longValue());
    assertEquals(1L, actualWithExternalIdResult.gridColumnId().longValue());
    assertEquals(1L, actualWithExternalIdResult.id().longValue());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualWithExternalIdResult.kind());
    assertEquals(
        AdditionalColumnOptions.NONE, actualWithExternalIdResult.additionalColumnOptions());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withExternalId(String)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithExternalIdResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertTrue(
        actualWithExternalIdResult.entityFieldReference() instanceof ImmutableEntityFieldReference);
    assertEquals("Column Description", actualWithExternalIdResult.columnDescription());
    assertEquals("Column Name", actualWithExternalIdResult.columnName());
    assertEquals("Display Name", actualWithExternalIdResult.displayName());
    assertEquals(1, actualWithExternalIdResult.position());
    assertEquals(1L, actualWithExternalIdResult.columnEntityId().longValue());
    assertEquals(1L, actualWithExternalIdResult.columnQualifierId().longValue());
    assertEquals(1L, actualWithExternalIdResult.gridColumnId().longValue());
    assertEquals(1L, actualWithExternalIdResult.id().longValue());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualWithExternalIdResult.kind());
    assertEquals(
        AdditionalColumnOptions.NONE, actualWithExternalIdResult.additionalColumnOptions());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withExternalId(String)} with {@code
   * value}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withExternalId(String)"
  })
  void testWithExternalIdWithValue2() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithExternalIdResult =
        immutableReportGridFixedColumnDefinition.withExternalId("42");

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withGridColumnId(Long)}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withGridColumnId(Long)}
   */
  @Test
  @DisplayName("Test withGridColumnId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withGridColumnId(Long)"
  })
  void testWithGridColumnId() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithGridColumnIdResult =
        immutableReportGridFixedColumnDefinition.withGridColumnId(1L);

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithGridColumnIdResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withGridColumnId(Long)}.
   *
   * <ul>
   *   <li>Then entityFieldReference return {@link ImmutableEntityFieldReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withGridColumnId(Long)}
   */
  @Test
  @DisplayName(
      "Test withGridColumnId(Long); then entityFieldReference return ImmutableEntityFieldReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withGridColumnId(Long)"
  })
  void testWithGridColumnId_thenEntityFieldReferenceReturnImmutableEntityFieldReference() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithGridColumnIdResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withGridColumnId(42L);

    // Assert
    assertTrue(
        actualWithGridColumnIdResult.entityFieldReference()
            instanceof ImmutableEntityFieldReference);
    assertEquals("Column Description", actualWithGridColumnIdResult.columnDescription());
    assertEquals("Column Name", actualWithGridColumnIdResult.columnName());
    assertEquals("Display Name", actualWithGridColumnIdResult.displayName());
    assertEquals(1, actualWithGridColumnIdResult.position());
    assertEquals(1L, actualWithGridColumnIdResult.columnEntityId().longValue());
    assertEquals(1L, actualWithGridColumnIdResult.columnQualifierId().longValue());
    assertEquals(1L, actualWithGridColumnIdResult.id().longValue());
    assertEquals(42L, actualWithGridColumnIdResult.gridColumnId().longValue());
    assertEquals(EntityKind.ALL, actualWithGridColumnIdResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithGridColumnIdResult.columnQualifierKind());
    assertEquals(
        EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualWithGridColumnIdResult.kind());
    assertEquals(
        AdditionalColumnOptions.NONE, actualWithGridColumnIdResult.additionalColumnOptions());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withId(Long)}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withId(Long)}
   */
  @Test
  @DisplayName("Test withId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withId(Long)"
  })
  void testWithId() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithIdResult =
        immutableReportGridFixedColumnDefinition.withId(1L);

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withId(Long)}.
   *
   * <ul>
   *   <li>Then entityFieldReference return {@link ImmutableEntityFieldReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withId(Long)}
   */
  @Test
  @DisplayName("Test withId(Long); then entityFieldReference return ImmutableEntityFieldReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withId(Long)"
  })
  void testWithId_thenEntityFieldReferenceReturnImmutableEntityFieldReference() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithIdResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withId(42L);

    // Assert
    assertTrue(actualWithIdResult.entityFieldReference() instanceof ImmutableEntityFieldReference);
    assertEquals("Column Description", actualWithIdResult.columnDescription());
    assertEquals("Column Name", actualWithIdResult.columnName());
    assertEquals("Display Name", actualWithIdResult.displayName());
    assertEquals(1, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.columnEntityId().longValue());
    assertEquals(1L, actualWithIdResult.columnQualifierId().longValue());
    assertEquals(1L, actualWithIdResult.gridColumnId().longValue());
    assertEquals(42L, actualWithIdResult.id().longValue());
    assertEquals(EntityKind.ALL, actualWithIdResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithIdResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualWithIdResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualWithIdResult.additionalColumnOptions());
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withPosition(int)"
  })
  void testWithPosition() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    ImmutableReportGridFixedColumnDefinition immutableReportGridFixedColumnDefinition =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(42)
            .build();

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithPositionResult =
        immutableReportGridFixedColumnDefinition.withPosition(42);

    // Assert
    assertSame(immutableReportGridFixedColumnDefinition, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#withPosition(int)}.
   *
   * <ul>
   *   <li>Then entityFieldReference return {@link ImmutableEntityFieldReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridFixedColumnDefinition#withPosition(int)}
   */
  @Test
  @DisplayName(
      "Test withPosition(int); then entityFieldReference return ImmutableEntityFieldReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridFixedColumnDefinition ImmutableReportGridFixedColumnDefinition.withPosition(int)"
  })
  void testWithPosition_thenEntityFieldReferenceReturnImmutableEntityFieldReference() {
    // Arrange
    Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");

    // Act
    ImmutableReportGridFixedColumnDefinition actualWithPositionResult =
        displayNameResult
            .entityFieldReference(
                ImmutableEntityFieldReference.builder()
                    .description("The characteristics of someone or something")
                    .displayName("Display Name")
                    .entityKind(EntityKind.ALL)
                    .fieldName("Field Name")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .build())
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build()
            .withPosition(42);

    // Assert
    assertTrue(
        actualWithPositionResult.entityFieldReference() instanceof ImmutableEntityFieldReference);
    assertEquals("Column Description", actualWithPositionResult.columnDescription());
    assertEquals("Column Name", actualWithPositionResult.columnName());
    assertEquals("Display Name", actualWithPositionResult.displayName());
    assertEquals(1L, actualWithPositionResult.columnEntityId().longValue());
    assertEquals(1L, actualWithPositionResult.columnQualifierId().longValue());
    assertEquals(1L, actualWithPositionResult.gridColumnId().longValue());
    assertEquals(1L, actualWithPositionResult.id().longValue());
    assertEquals(42, actualWithPositionResult.position());
    assertEquals(EntityKind.ALL, actualWithPositionResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualWithPositionResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualWithPositionResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualWithPositionResult.additionalColumnOptions());
  }
}
