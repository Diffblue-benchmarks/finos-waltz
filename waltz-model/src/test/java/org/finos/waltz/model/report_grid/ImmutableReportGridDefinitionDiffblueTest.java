package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridDefinitionDiffblueTest {
  /**
   * Test {@link ImmutableReportGridDefinition#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridDefinition#builder()}
   *   <li>{@link ImmutableReportGridDefinition#description(String)}
   *   <li>{@link ImmutableReportGridDefinition#externalId(String)}
   *   <li>{@link ImmutableReportGridDefinition#kind(ReportGridKind)}
   *   <li>{@link ImmutableReportGridDefinition#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableReportGridDefinition#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridDefinition Builder.build()", "Builder Builder.description(String)",
      "Builder Builder.externalId(String)", "Builder Builder.kind(ReportGridKind)",
      "Builder Builder.lastUpdatedAt(LocalDateTime)", "Builder Builder.provenance(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableReportGridDefinition.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualKindResult = actualIdResult.id(id).kind(ReportGridKind.PUBLIC);
    Builder actualLastUpdatedAtResult = actualKindResult.lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Test Builder {@link Builder#addAllDerivedColumnDefinitions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllDerivedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllDerivedColumnDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllDerivedColumnDefinitions(Iterable)"})
  void testBuilderAddAllDerivedColumnDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDerivedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllFixedColumnDefinitions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllFixedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllFixedColumnDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllFixedColumnDefinitions(Iterable)"})
  void testBuilderAddAllFixedColumnDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFixedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableReportGridDerivedColumnDefinition.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)"})
  void testBuilderAddDerivedColumnDefinitionsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addDerivedColumnDefinitions(new ImmutableReportGridDerivedColumnDefinition.Json()));
  }

  /**
   * Test Builder {@link Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableReportGridDerivedColumnDefinition.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   */
  @Test
  @DisplayName("Test Builder addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])"})
  void testBuilderAddDerivedColumnDefinitionsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addDerivedColumnDefinitions(new ImmutableReportGridDerivedColumnDefinition.Json()));
  }

  /**
   * Test Builder {@link Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableReportGridFixedColumnDefinition.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder addFixedColumnDefinitions(ReportGridFixedColumnDefinition) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFixedColumnDefinitions(ReportGridFixedColumnDefinition)"})
  void testBuilderAddFixedColumnDefinitionsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addFixedColumnDefinitions(new ImmutableReportGridFixedColumnDefinition.Json()));
  }

  /**
   * Test Builder {@link Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableReportGridFixedColumnDefinition.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   */
  @Test
  @DisplayName("Test Builder addFixedColumnDefinitions(ReportGridFixedColumnDefinition[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])"})
  void testBuilderAddFixedColumnDefinitionsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addFixedColumnDefinitions(new ImmutableReportGridFixedColumnDefinition.Json()));
  }

  /**
   * Test Builder {@link Builder#derivedColumnDefinitions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#derivedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder derivedColumnDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.derivedColumnDefinitions(Iterable)"})
  void testBuilderDerivedColumnDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.derivedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#fixedColumnDefinitions(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#fixedColumnDefinitions(Iterable)}
   */
  @Test
  @DisplayName("Test Builder fixedColumnDefinitions(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.fixedColumnDefinitions(Iterable)"})
  void testBuilderFixedColumnDefinitions_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fixedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
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
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
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
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
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
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * Test Builder {@link Builder#from(LastUpdatedProvider)} with {@code LastUpdatedProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LastUpdatedProvider)}
   */
  @Test
  @DisplayName("Test Builder from(LastUpdatedProvider) with 'LastUpdatedProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LastUpdatedProvider)"})
  void testBuilderFromWithLastUpdatedProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code Provenance}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; given 'Provenance'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_givenProvenance_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDefinition)} with {@code ReportGridDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDefinition) with 'ReportGridDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDefinition)"})
  void testBuilderFromWithReportGridDefinition() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    verify(instance).kind();
    verify(instance).subjectKind();
    ImmutableReportGridDefinition buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", builderResult.build().description());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = buildResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, buildResult.fixedColumnDefinitions());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDefinition)} with {@code ReportGridDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDefinition) with 'ReportGridDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDefinition)"})
  void testBuilderFromWithReportGridDefinition2() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList = new ArrayList<>();
    ImmutableReportGridFixedColumnDefinition.Json json = new ImmutableReportGridFixedColumnDefinition.Json();
    reportGridFixedColumnDefinitionList.add(json);
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    verify(instance).kind();
    verify(instance).subjectKind();
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = builderResult.build().fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertEquals(reportGridFixedColumnDefinitionList, actualFromResult.build().fixedColumnDefinitions());
    assertSame(json, fixedColumnDefinitionsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDefinition)} with {@code ReportGridDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDefinition) with 'ReportGridDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDefinition)"})
  void testBuilderFromWithReportGridDefinition3() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    ImmutableReportGridDerivedColumnDefinition.Json json = new ImmutableReportGridDerivedColumnDefinition.Json();
    reportGridDerivedColumnDefinitionList.add(json);
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    verify(instance).kind();
    verify(instance).subjectKind();
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = builderResult.build()
        .derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    ImmutableReportGridDefinition buildResult = actualFromResult.build();
    assertTrue(buildResult.fixedColumnDefinitions().isEmpty());
    assertEquals(reportGridDerivedColumnDefinitionList, buildResult.derivedColumnDefinitions());
    assertSame(json, derivedColumnDefinitionsResult.get(0));
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDefinition)} with {@code ReportGridDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDefinition) with 'ReportGridDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDefinition)"})
  void testBuilderFromWithReportGridDefinition4() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    verify(instance).kind();
    verify(instance).subjectKind();
    ImmutableReportGridDefinition buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", builderResult.build().description());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = buildResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, buildResult.fixedColumnDefinitions());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDefinition)} with {@code ReportGridDefinition}.
   * <ul>
   *   <li>Then return build description is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDefinition) with 'ReportGridDefinition'; then return build description is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDefinition)"})
  void testBuilderFromWithReportGridDefinition_thenReturnBuildDescriptionIsNull() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    verify(instance).kind();
    verify(instance).subjectKind();
    ImmutableReportGridDefinition buildResult = actualFromResult.build();
    assertNull(buildResult.description());
    assertNull(builderResult.build().description());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = buildResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, buildResult.fixedColumnDefinitions());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDefinition)} with {@code ReportGridDefinition}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDefinition) with 'ReportGridDefinition'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDefinition)"})
  void testBuilderFromWithReportGridDefinition_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenThrow(new IllegalStateException("instance"));
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    verify(instance).kind();
    verify(instance).subjectKind();
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDefinition)} with {@code ReportGridDefinition}.
   * <ul>
   *   <li>When {@link ReportGridDefinition} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDefinition) with 'ReportGridDefinition'; when ReportGridDefinition id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDefinition)"})
  void testBuilderFromWithReportGridDefinition_whenReportGridDefinitionIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).derivedColumnDefinitions();
    verify(instance).fixedColumnDefinitions();
    verify(instance).kind();
    verify(instance).subjectKind();
    ImmutableReportGridDefinition buildResult = actualFromResult.build();
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals("The characteristics of someone or something", builderResult.build().description());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = buildResult.derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, buildResult.fixedColumnDefinitions());
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#lastUpdatedBy(String)}.
   * <p>
   * Method under test: {@link Builder#lastUpdatedBy(String)}
   */
  @Test
  @DisplayName("Test Builder lastUpdatedBy(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdatedBy(String)"})
  void testBuilderLastUpdatedBy() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#subjectKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#subjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder subjectKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.subjectKind(EntityKind)"})
  void testBuilderSubjectKind() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Test Json {@link Json#derivedColumnDefinitions()}.
   * <p>
   * Method under test: {@link Json#derivedColumnDefinitions()}
   */
  @Test
  @DisplayName("Test Json derivedColumnDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.derivedColumnDefinitions()"})
  void testJsonDerivedColumnDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).derivedColumnDefinitions());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#fixedColumnDefinitions()}.
   * <p>
   * Method under test: {@link Json#fixedColumnDefinitions()}
   */
  @Test
  @DisplayName("Test Json fixedColumnDefinitions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List Json.fixedColumnDefinitions()"})
  void testJsonFixedColumnDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).fixedColumnDefinitions());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#kind()}.
   * <p>
   * Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ReportGridKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).kind());
  }

  /**
   * Test Json {@link Json#lastUpdatedAt()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedAt()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedAt()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LocalDateTime Json.lastUpdatedAt()"})
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedAt());
  }

  /**
   * Test Json {@link Json#lastUpdatedBy()}.
   * <p>
   * Method under test: {@link Json#lastUpdatedBy()}
   */
  @Test
  @DisplayName("Test Json lastUpdatedBy()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.lastUpdatedBy()"})
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdatedBy());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
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
   * <p>
   * Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).provenance());
  }

  /**
   * Test Json {@link Json#subjectKind()}.
   * <p>
   * Method under test: {@link Json#subjectKind()}
   */
  @Test
  @DisplayName("Test Json subjectKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.subjectKind()"})
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).subjectKind());
  }
}
