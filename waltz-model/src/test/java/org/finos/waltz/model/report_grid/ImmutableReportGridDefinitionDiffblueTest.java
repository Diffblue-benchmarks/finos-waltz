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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.entity_field_reference.ImmutableEntityFieldReference;
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridDefinitionDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllDerivedColumnDefinitions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllDerivedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDerivedColumnDefinitions(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllDerivedColumnDefinitions(Iterable)"})
  void testBuilderAddAllDerivedColumnDefinitions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act
    Builder actualAddAllDerivedColumnDefinitionsResult =
        builderResult.addAllDerivedColumnDefinitions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllDerivedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addAllFixedColumnDefinitions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllFixedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllFixedColumnDefinitions(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllFixedColumnDefinitions(Iterable)"})
  void testBuilderAddAllFixedColumnDefinitions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act
    Builder actualAddAllFixedColumnDefinitionsResult =
        builderResult.addAllFixedColumnDefinitions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllFixedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)}
   * with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridDerivedColumnDefinition.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)"
  })
  void testBuilderAddDerivedColumnDefinitionsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act
    Builder actualAddDerivedColumnDefinitionsResult =
        builderResult.addDerivedColumnDefinitions(
            new ImmutableReportGridDerivedColumnDefinition.Json());

    // Assert
    assertSame(builderResult, actualAddDerivedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   * with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridDerivedColumnDefinition.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   */
  @Test
  @DisplayName(
      "Test Builder addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])"
  })
  void testBuilderAddDerivedColumnDefinitionsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act
    Builder actualAddDerivedColumnDefinitionsResult =
        builderResult.addDerivedColumnDefinitions(
            new ImmutableReportGridDerivedColumnDefinition.Json());

    // Assert
    assertSame(builderResult, actualAddDerivedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition)} with
   * {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridFixedColumnDefinition.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName(
      "Test Builder addFixedColumnDefinitions(ReportGridFixedColumnDefinition) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addFixedColumnDefinitions(ReportGridFixedColumnDefinition)"})
  void testBuilderAddFixedColumnDefinitionsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act
    Builder actualAddFixedColumnDefinitionsResult =
        builderResult.addFixedColumnDefinitions(
            new ImmutableReportGridFixedColumnDefinition.Json());

    // Assert
    assertSame(builderResult, actualAddFixedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])} with
   * {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridFixedColumnDefinition.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link
   * Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   */
  @Test
  @DisplayName(
      "Test Builder addFixedColumnDefinitions(ReportGridFixedColumnDefinition[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Builder Builder.addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])"
  })
  void testBuilderAddFixedColumnDefinitionsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act
    Builder actualAddFixedColumnDefinitionsResult =
        builderResult.addFixedColumnDefinitions(
            new ImmutableReportGridFixedColumnDefinition.Json());

    // Assert
    assertSame(builderResult, actualAddFixedColumnDefinitionsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#kind(ReportGridKind)}
   *   <li>{@link Builder#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(ReportGridKind)",
    "Builder Builder.lastUpdatedAt(LocalDateTime)",
    "Builder Builder.provenance(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    LocalDateTime lastUpdatedAt = LocalDate.of(1970, 1, 1).atStartOfDay();
    ImmutableReportGridDefinition actualImmutableReportGridDefinition =
        actualIdResult
            .id(id)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(lastUpdatedAt)
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Assert
    assertEquals("2020-03-01", actualImmutableReportGridDefinition.lastUpdatedBy());
    assertEquals("Name", actualImmutableReportGridDefinition.name());
    assertEquals("Provenance", actualImmutableReportGridDefinition.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableReportGridDefinition.description());
    assertEquals(EntityKind.ALL, actualImmutableReportGridDefinition.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualImmutableReportGridDefinition.kind());
    assertTrue(actualImmutableReportGridDefinition.derivedColumnDefinitions().isEmpty());
    assertSame(lastUpdatedAt, actualImmutableReportGridDefinition.lastUpdatedAt());
  }

  /**
   * Test Builder {@link Builder#derivedColumnDefinitions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#derivedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder derivedColumnDefinitions(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.derivedColumnDefinitions(Iterable)"})
  void testBuilderDerivedColumnDefinitions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act
    Builder actualDerivedColumnDefinitionsResult =
        builderResult.derivedColumnDefinitions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualDerivedColumnDefinitionsResult);
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
    Builder builderResult = ImmutableReportGridDefinition.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#fixedColumnDefinitions(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#fixedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder fixedColumnDefinitions(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.fixedColumnDefinitions(Iterable)"})
  void testBuilderFixedColumnDefinitions_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act
    Builder actualFixedColumnDefinitionsResult =
        builderResult.fixedColumnDefinitions(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualFixedColumnDefinitionsResult);
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
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ImmutableReportGridDefinition instance =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableReportGridDefinition actualImmutableReportGridDefinition =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridDefinition);
    ImmutableReportGridDefinition actualImmutableReportGridDefinition2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

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
    Builder builderResult = ImmutableReportGridDefinition.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ImmutableReportGridDefinition instance =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableReportGridDefinition actualImmutableReportGridDefinition =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridDefinition);
    ImmutableReportGridDefinition actualImmutableReportGridDefinition2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

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
    Builder builderResult = ImmutableReportGridDefinition.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ImmutableReportGridDefinition instance =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableReportGridDefinition actualImmutableReportGridDefinition =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridDefinition);
    ImmutableReportGridDefinition actualImmutableReportGridDefinition2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ImmutableReportGridDefinition instance =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableReportGridDefinition actualImmutableReportGridDefinition =
        builderResult.from((LastUpdatedProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridDefinition);
    ImmutableReportGridDefinition actualImmutableReportGridDefinition2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider2() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedBy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider3() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ImmutableReportGridDefinition instance =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableReportGridDefinition actualImmutableReportGridDefinition =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridDefinition);
    ImmutableReportGridDefinition actualImmutableReportGridDefinition2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinition2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
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
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ImmutableReportGridDefinition instance =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableReportGridDefinition actualImmutableReportGridDefinition =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridDefinition);
    ImmutableReportGridDefinition actualImmutableReportGridDefinition2 = builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinition2);
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
    Builder builderResult = ImmutableReportGridDefinition.builder();

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
   * Test Builder {@link Builder#from(ReportGridDefinition)} with {@code ReportGridDefinition}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDefinition) with 'ReportGridDefinition'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridDefinition)"})
  void testBuilderFromWithReportGridDefinition() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ImmutableReportGridDefinition instance =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableReportGridDefinition actualImmutableReportGridDefinition = builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinition);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act
    Builder actualLastUpdatedByResult = builderResult.lastUpdatedBy("2020-03-01");

    // Assert
    assertSame(builderResult, actualLastUpdatedByResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#subjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#subjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder subjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subjectKind(EntityKind)"})
  void testBuilderSubjectKind() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act
    Builder actualSubjectKindResult = builderResult.subjectKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualSubjectKindResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#copyOf(ReportGridDefinition)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#copyOf(ReportGridDefinition)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ReportGridDefinition); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.copyOf(ReportGridDefinition)"
  })
  void testCopyOf_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableReportGridDefinition instance =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinition actualCopyOfResult =
        ImmutableReportGridDefinition.copyOf(instance);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCopyOfResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualCopyOfResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualCopyOfResult.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#equals(Object)}, and {@link
   * ImmutableReportGridDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridDefinition#equals(Object)}
   *   <li>{@link ImmutableReportGridDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinition.equals(Object)",
    "int ImmutableReportGridDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();
    ImmutableReportGridDefinition immutableReportGridDefinition2 =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableReportGridDefinition, immutableReportGridDefinition2);
    assertEquals(
        immutableReportGridDefinition.hashCode(), immutableReportGridDefinition2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridDefinition#equals(Object)}, and {@link
   * ImmutableReportGridDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridDefinition#equals(Object)}
   *   <li>{@link ImmutableReportGridDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinition.equals(Object)",
    "int ImmutableReportGridDefinition.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableReportGridDefinition, immutableReportGridDefinition);
    int expectedHashCodeResult = immutableReportGridDefinition.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridDefinition.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinition.equals(Object)",
    "int ImmutableReportGridDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult =
        ImmutableReportGridFixedColumnDefinition.builder()
            .additionalColumnOptions(AdditionalColumnOptions.NONE)
            .columnDescription("Column Description")
            .columnEntityId(1L)
            .columnEntityKind(EntityKind.ALL)
            .columnName("Column Name")
            .columnQualifierId(1L)
            .columnQualifierKind(EntityKind.ALL)
            .displayName("Display Name");
    builderResult.addFixedColumnDefinitions(
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
            .build());
    ImmutableReportGridDefinition immutableReportGridDefinition =
        builderResult
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDefinition,
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinition.equals(Object)",
    "int ImmutableReportGridDefinition.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    builderResult.addDerivedColumnDefinitions(
        ImmutableReportGridDerivedColumnDefinition.builder()
            .columnDescription("Column Description")
            .derivationScript("Derivation Script")
            .displayName("Display Name")
            .externalId("42")
            .gridColumnId(1L)
            .id(1L)
            .position(1)
            .build());
    ImmutableReportGridDefinition immutableReportGridDefinition =
        builderResult
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDefinition,
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinition.equals(Object)",
    "int ImmutableReportGridDefinition.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinition.equals(Object)",
    "int ImmutableReportGridDefinition.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableReportGridDefinition");
  }

  /**
   * Test {@link ImmutableReportGridDefinition#externalId()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableReportGridDefinition.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
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
   *   <li>{@link ImmutableReportGridDefinition#derivedColumnDefinitions()}
   *   <li>{@link ImmutableReportGridDefinition#description()}
   *   <li>{@link ImmutableReportGridDefinition#fixedColumnDefinitions()}
   *   <li>{@link ImmutableReportGridDefinition#lastUpdatedBy()}
   *   <li>{@link ImmutableReportGridDefinition#name()}
   *   <li>{@link ImmutableReportGridDefinition#subjectKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableReportGridDefinition.derivedColumnDefinitions()",
    "String ImmutableReportGridDefinition.description()",
    "List ImmutableReportGridDefinition.fixedColumnDefinitions()",
    "String ImmutableReportGridDefinition.lastUpdatedBy()",
    "String ImmutableReportGridDefinition.name()",
    "EntityKind ImmutableReportGridDefinition.subjectKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    List<ReportGridDerivedColumnDefinition> actualDerivedColumnDefinitionsResult =
        immutableReportGridDefinition.derivedColumnDefinitions();
    String actualDescriptionResult = immutableReportGridDefinition.description();
    List<ReportGridFixedColumnDefinition> actualFixedColumnDefinitionsResult =
        immutableReportGridDefinition.fixedColumnDefinitions();
    String actualLastUpdatedByResult = immutableReportGridDefinition.lastUpdatedBy();
    String actualNameResult = immutableReportGridDefinition.name();

    // Assert
    assertEquals("2020-03-01", actualLastUpdatedByResult);
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, immutableReportGridDefinition.subjectKind());
    assertTrue(actualDerivedColumnDefinitionsResult.isEmpty());
    assertSame(actualDerivedColumnDefinitionsResult, actualFixedColumnDefinitionsResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#id()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableReportGridDefinition.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#derivedColumnDefinitions()}.
   *
   * <p>Method under test: {@link Json#derivedColumnDefinitions()}
   */
  @Test
  @DisplayName("Test Json derivedColumnDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.derivedColumnDefinitions()"})
  void testJsonDerivedColumnDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().derivedColumnDefinitions());
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
   * Test Json {@link Json#fixedColumnDefinitions()}.
   *
   * <p>Method under test: {@link Json#fixedColumnDefinitions()}
   */
  @Test
  @DisplayName("Test Json fixedColumnDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.fixedColumnDefinitions()"})
  void testJsonFixedColumnDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().fixedColumnDefinitions());
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
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   *
   * <p>Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
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
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.subjectKind);
    assertNull(actualJson.kind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertTrue(actualJson.derivedColumnDefinitions.isEmpty());
    assertTrue(actualJson.fixedColumnDefinitions.isEmpty());
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
   * Test Json {@link Json#subjectKind()}.
   *
   * <p>Method under test: {@link Json#subjectKind()}
   */
  @Test
  @DisplayName("Test Json subjectKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.subjectKind()"})
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().subjectKind());
  }

  /**
   * Test {@link ImmutableReportGridDefinition#kind()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#kind()}
   */
  @Test
  @DisplayName("Test kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReportGridKind ImmutableReportGridDefinition.kind()"})
  void testKind() {
    // Arrange, Act and Assert
    assertEquals(
        ReportGridKind.PUBLIC,
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build()
            .kind());
  }

  /**
   * Test {@link ImmutableReportGridDefinition#lastUpdatedAt()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test lastUpdatedAt()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LocalDateTime ImmutableReportGridDefinition.lastUpdatedAt()"})
  void testLastUpdatedAt() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    LocalDateTime actualLastUpdatedAtResult =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build()
            .lastUpdatedAt();

    // Assert
    assertEquals("00:00", actualLastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = actualLastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#provenance()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridDefinition.provenance()"})
  void testProvenance() {
    // Arrange, Act and Assert
    assertEquals(
        "Provenance",
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableReportGridDefinition#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridDefinition.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "ReportGridDefinition{id=1, name=Name, lastUpdatedAt=1970-01-01T00:00, lastUpdatedBy=2020-03-01,"
            + " provenance=Provenance, externalId=42, fixedColumnDefinitions=[], derivedColumnDefinitions=[],"
            + " subjectKind=ALL, kind=PUBLIC}",
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link
   * ImmutableReportGridDefinition#withDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   * with {@code ReportGridDerivedColumnDefinition[]}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDefinition#withDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   */
  @Test
  @DisplayName(
      "Test withDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[]) with 'ReportGridDerivedColumnDefinition[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])"
  })
  void testWithDerivedColumnDefinitionsWithReportGridDerivedColumnDefinition() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinition actualWithDerivedColumnDefinitionsResult =
        immutableReportGridDefinition.withDerivedColumnDefinitions(
            ImmutableReportGridDerivedColumnDefinition.builder()
                .columnDescription("Column Description")
                .derivationScript("Derivation Script")
                .displayName("Display Name")
                .externalId("42")
                .gridColumnId(1L)
                .id(1L)
                .position(1)
                .build());

    // Assert
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualWithDerivedColumnDefinitionsResult.derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    assertTrue(
        derivedColumnDefinitionsResult.get(0)
            instanceof ImmutableReportGridDerivedColumnDefinition);
    assertEquals("2020-03-01", actualWithDerivedColumnDefinitionsResult.lastUpdatedBy());
    assertEquals("Name", actualWithDerivedColumnDefinitionsResult.name());
    assertEquals("Provenance", actualWithDerivedColumnDefinitionsResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithDerivedColumnDefinitionsResult.description());
    assertEquals(EntityKind.ALL, actualWithDerivedColumnDefinitionsResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithDerivedColumnDefinitionsResult.kind());
    assertTrue(actualWithDerivedColumnDefinitionsResult.fixedColumnDefinitions().isEmpty());
    assertSame(ofResult, actualWithDerivedColumnDefinitionsResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinition actualWithDescriptionResult =
        immutableReportGridDefinition.withDescription("42");

    // Assert
    assertEquals(immutableReportGridDefinition, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("42")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinition actualWithDescriptionResult =
        immutableReportGridDefinition.withDescription("42");

    // Assert
    assertSame(immutableReportGridDefinition, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableReportGridDefinition actualWithExternalIdResult =
        immutableReportGridDefinition.withExternalId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithExternalIdResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualWithExternalIdResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualWithExternalIdResult.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridDefinition actualWithExternalIdResult =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithExternalIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithExternalIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Provenance", actualWithExternalIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithExternalIdResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualWithExternalIdResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualWithExternalIdResult.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link
   * ImmutableReportGridDefinition#withFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   * with {@code ReportGridFixedColumnDefinition[]}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDefinition#withFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   */
  @Test
  @DisplayName(
      "Test withFixedColumnDefinitions(ReportGridFixedColumnDefinition[]) with 'ReportGridFixedColumnDefinition[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withFixedColumnDefinitions(ReportGridFixedColumnDefinition[])"
  })
  void testWithFixedColumnDefinitionsWithReportGridFixedColumnDefinition() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    ImmutableReportGridFixedColumnDefinition.Builder displayNameResult =
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
    ImmutableReportGridDefinition actualWithFixedColumnDefinitionsResult =
        immutableReportGridDefinition.withFixedColumnDefinitions(
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
                .build());

    // Assert
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult =
        actualWithFixedColumnDefinitionsResult.fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertTrue(
        fixedColumnDefinitionsResult.get(0) instanceof ImmutableReportGridFixedColumnDefinition);
    assertEquals("2020-03-01", actualWithFixedColumnDefinitionsResult.lastUpdatedBy());
    assertEquals("Name", actualWithFixedColumnDefinitionsResult.name());
    assertEquals("Provenance", actualWithFixedColumnDefinitionsResult.provenance());
    assertEquals(
        "The characteristics of someone or something",
        actualWithFixedColumnDefinitionsResult.description());
    assertEquals(EntityKind.ALL, actualWithFixedColumnDefinitionsResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithFixedColumnDefinitionsResult.kind());
    assertTrue(actualWithFixedColumnDefinitionsResult.derivedColumnDefinitions().isEmpty());
    assertSame(ofResult, actualWithFixedColumnDefinitionsResult.lastUpdatedAt().toLocalDate());
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableReportGridDefinition actualWithIdResult =
        immutableReportGridDefinition.withId(optional);

    // Assert
    assertSame(immutableReportGridDefinition, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withId(Optional) with 'optional'; then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableReportGridDefinition actualWithIdResult =
        immutableReportGridDefinition.withId(optional);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithIdResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualWithIdResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualWithIdResult.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableReportGridDefinition ImmutableReportGridDefinition.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridDefinition actualWithIdResult =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build()
            .withId(42L);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithIdResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithIdResult.lastUpdatedBy());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Provenance", actualWithIdResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithIdResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualWithIdResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualWithIdResult.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withKind(ReportGridKind)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withKind(ReportGridKind)}
   */
  @Test
  @DisplayName("Test withKind(ReportGridKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withKind(ReportGridKind)"
  })
  void testWithKind() {
    // Arrange
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinition actualWithKindResult =
        immutableReportGridDefinition.withKind(ReportGridKind.PUBLIC);

    // Assert
    assertSame(immutableReportGridDefinition, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withKind(ReportGridKind)}.
   *
   * <ul>
   *   <li>Then return lastUpdatedAt toLocalTime toString is {@code 00:00}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withKind(ReportGridKind)}
   */
  @Test
  @DisplayName(
      "Test withKind(ReportGridKind); then return lastUpdatedAt toLocalTime toString is '00:00'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withKind(ReportGridKind)"
  })
  void testWithKind_thenReturnLastUpdatedAtToLocalTimeToStringIs0000() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridDefinition actualWithKindResult =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PRIVATE)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build()
            .withKind(ReportGridKind.PUBLIC);

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithKindResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithKindResult.lastUpdatedBy());
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("Provenance", actualWithKindResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithKindResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualWithKindResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualWithKindResult.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withLastUpdatedAt(LocalDateTime)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withLastUpdatedAt(LocalDateTime)}
   */
  @Test
  @DisplayName("Test withLastUpdatedAt(LocalDateTime)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withLastUpdatedAt(LocalDateTime)"
  })
  void testWithLastUpdatedAt() {
    // Arrange
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinition actualWithLastUpdatedAtResult =
        immutableReportGridDefinition.withLastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertEquals(immutableReportGridDefinition, actualWithLastUpdatedAtResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withLastUpdatedBy(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withLastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test withLastUpdatedBy(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withLastUpdatedBy(String)"
  })
  void testWithLastUpdatedBy() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridDefinition actualWithLastUpdatedByResult =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build()
            .withLastUpdatedBy("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithLastUpdatedByResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("42", actualWithLastUpdatedByResult.lastUpdatedBy());
    assertEquals("Name", actualWithLastUpdatedByResult.name());
    assertEquals("Provenance", actualWithLastUpdatedByResult.provenance());
    assertEquals(
        "The characteristics of someone or something", actualWithLastUpdatedByResult.description());
    assertEquals(EntityKind.ALL, actualWithLastUpdatedByResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithLastUpdatedByResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualWithLastUpdatedByResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(
        derivedColumnDefinitionsResult, actualWithLastUpdatedByResult.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withName(String)"
  })
  void testWithName() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridDefinition actualWithNameResult =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build()
            .withName("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithNameResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithNameResult.lastUpdatedBy());
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Provenance", actualWithNameResult.provenance());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithNameResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualWithNameResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualWithNameResult.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withProvenance(String)"
  })
  void testWithProvenance() {
    // Arrange
    LocalDate ofResult = LocalDate.of(1970, 1, 1);

    // Act
    ImmutableReportGridDefinition actualWithProvenanceResult =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(ofResult.atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build()
            .withProvenance("42");

    // Assert
    LocalDateTime lastUpdatedAtResult = actualWithProvenanceResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualWithProvenanceResult.lastUpdatedBy());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals("Name", actualWithProvenanceResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithProvenanceResult.description());
    assertEquals(EntityKind.ALL, actualWithProvenanceResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualWithProvenanceResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult =
        actualWithProvenanceResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualWithProvenanceResult.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinition#withSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinition#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinition ImmutableReportGridDefinition.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind() {
    // Arrange
    ImmutableReportGridDefinition immutableReportGridDefinition =
        ImmutableReportGridDefinition.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(ReportGridKind.PUBLIC)
            .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
            .lastUpdatedBy("2020-03-01")
            .name("Name")
            .provenance("Provenance")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinition actualWithSubjectKindResult =
        immutableReportGridDefinition.withSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(immutableReportGridDefinition, actualWithSubjectKindResult);
  }
}
