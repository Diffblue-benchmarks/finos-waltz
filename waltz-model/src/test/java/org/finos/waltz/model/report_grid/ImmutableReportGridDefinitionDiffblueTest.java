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
import org.finos.waltz.model.entity_field_reference.EntityFieldReference;
import org.junit.jupiter.api.Test;

class ImmutableReportGridDefinitionDiffblueTest {
  /**
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
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGridDefinition.Builder actualExternalIdResult = ImmutableReportGridDefinition.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableReportGridDefinition.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableReportGridDefinition.Builder actualKindResult = actualIdResult.id(id).kind(ReportGridKind.PUBLIC);
    ImmutableReportGridDefinition.Builder actualLastUpdatedAtResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#addAllDerivedColumnDefinitions(Iterable)}
   */
  @Test
  void testBuilderAddAllDerivedColumnDefinitions() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllDerivedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#addAllFixedColumnDefinitions(Iterable)}
   */
  @Test
  void testBuilderAddAllFixedColumnDefinitions() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllFixedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testBuilderAddDerivedColumnDefinitions() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addDerivedColumnDefinitions(new ImmutableReportGridDerivedColumnDefinition.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#addDerivedColumnDefinitions(ReportGridDerivedColumnDefinition[])}
   */
  @Test
  void testBuilderAddDerivedColumnDefinitions2() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addDerivedColumnDefinitions(new ImmutableReportGridDerivedColumnDefinition.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderAddFixedColumnDefinitions() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addFixedColumnDefinitions(new ImmutableReportGridFixedColumnDefinition.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderAddFixedColumnDefinitions2() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    ImmutableReportGridFixedColumnDefinition.Json element = new ImmutableReportGridFixedColumnDefinition.Json();
    element.setEntityFieldReference(mock(EntityFieldReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addFixedColumnDefinitions(element));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   */
  @Test
  void testBuilderAddFixedColumnDefinitions3() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.addFixedColumnDefinitions(new ImmutableReportGridFixedColumnDefinition.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#addFixedColumnDefinitions(ReportGridFixedColumnDefinition[])}
   */
  @Test
  void testBuilderAddFixedColumnDefinitions4() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    ImmutableReportGridFixedColumnDefinition.Json json = new ImmutableReportGridFixedColumnDefinition.Json();
    json.setEntityFieldReference(mock(EntityFieldReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addFixedColumnDefinitions(json));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#derivedColumnDefinitions(Iterable)}
   */
  @Test
  void testBuilderDerivedColumnDefinitions() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.derivedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Json element = new ImmutableReportGridFixedColumnDefinition.Json();
    element.setEntityFieldReference(mock(EntityFieldReference.class));
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    builderResult.addFixedColumnDefinitions(element);
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#fixedColumnDefinitions(Iterable)}
   */
  @Test
  void testBuilderFixedColumnDefinitions() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.fixedColumnDefinitions(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(ReportGridDefinition)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
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
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridDefinition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(ReportGridDefinition)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
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
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(ReportGridDefinition)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

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
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridDefinition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    List<ReportGridFixedColumnDefinition> fixedColumnDefinitionsResult = buildResult.fixedColumnDefinitions();
    assertEquals(1, fixedColumnDefinitionsResult.size());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, buildResult.kind());
    assertSame(json, fixedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(ReportGridDefinition)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
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
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridDefinition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(ReportGridDefinition)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

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
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridDefinition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = buildResult.derivedColumnDefinitions();
    assertEquals(1, derivedColumnDefinitionsResult.size());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, buildResult.kind());
    assertSame(json, derivedColumnDefinitionsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(ReportGridDefinition)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
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
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridDefinition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#from(ReportGridDefinition)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
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
    ImmutableReportGridDefinition.Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridDefinition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinition.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinition.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinition.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Json element = new ImmutableReportGridFixedColumnDefinition.Json();
    element.setEntityFieldReference(mock(EntityFieldReference.class));
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    builderResult.addFixedColumnDefinitions(element);
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinition.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind() {
    // Arrange
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind2() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Json element = new ImmutableReportGridFixedColumnDefinition.Json();
    element.setEntityFieldReference(mock(EntityFieldReference.class));
    ImmutableReportGridDefinition.Builder builderResult = ImmutableReportGridDefinition.builder();
    builderResult.addFixedColumnDefinitions(element);

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition#copyOf(ReportGridDefinition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinition actualCopyOfResult = ImmutableReportGridDefinition.copyOf(instance);

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
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = actualCopyOfResult
        .derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualCopyOfResult.fixedColumnDefinitions());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition#copyOf(ReportGridDefinition)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList = new ArrayList<>();
    reportGridFixedColumnDefinitionList.add(new ImmutableReportGridFixedColumnDefinition.Json());
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinition actualCopyOfResult = ImmutableReportGridDefinition.copyOf(instance);

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
    assertTrue(actualCopyOfResult.derivedColumnDefinitions().isEmpty());
    assertEquals(reportGridFixedColumnDefinitionList, actualCopyOfResult.fixedColumnDefinitions());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition#copyOf(ReportGridDefinition)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<ReportGridFixedColumnDefinition> reportGridFixedColumnDefinitionList = new ArrayList<>();
    reportGridFixedColumnDefinitionList.add(new ImmutableReportGridFixedColumnDefinition.Json());
    reportGridFixedColumnDefinitionList.add(new ImmutableReportGridFixedColumnDefinition.Json());
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(reportGridFixedColumnDefinitionList);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinition actualCopyOfResult = ImmutableReportGridDefinition.copyOf(instance);

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
    assertTrue(actualCopyOfResult.derivedColumnDefinitions().isEmpty());
    assertEquals(reportGridFixedColumnDefinitionList, actualCopyOfResult.fixedColumnDefinitions());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition#copyOf(ReportGridDefinition)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinition actualCopyOfResult = ImmutableReportGridDefinition.copyOf(instance);

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
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = actualCopyOfResult
        .derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualCopyOfResult.fixedColumnDefinitions());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition#copyOf(ReportGridDefinition)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ArrayList<ReportGridDerivedColumnDefinition> reportGridDerivedColumnDefinitionList = new ArrayList<>();
    reportGridDerivedColumnDefinitionList.add(new ImmutableReportGridDerivedColumnDefinition.Json());
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(reportGridDerivedColumnDefinitionList);
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinition actualCopyOfResult = ImmutableReportGridDefinition.copyOf(instance);

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
    assertTrue(actualCopyOfResult.fixedColumnDefinitions().isEmpty());
    assertEquals(reportGridDerivedColumnDefinitionList, actualCopyOfResult.derivedColumnDefinitions());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition#copyOf(ReportGridDefinition)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinition actualCopyOfResult = ImmutableReportGridDefinition.copyOf(instance);

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
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = actualCopyOfResult
        .derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualCopyOfResult.fixedColumnDefinitions());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition#copyOf(ReportGridDefinition)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    ReportGridDefinition instance = mock(ReportGridDefinition.class);
    when(instance.fixedColumnDefinitions()).thenReturn(new ArrayList<>());
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.derivedColumnDefinitions()).thenReturn(new ArrayList<>());
    when(instance.kind()).thenReturn(ReportGridKind.PUBLIC);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinition actualCopyOfResult = ImmutableReportGridDefinition.copyOf(instance);

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
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCopyOfResult.kind());
    List<ReportGridDerivedColumnDefinition> derivedColumnDefinitionsResult = actualCopyOfResult
        .derivedColumnDefinitions();
    assertTrue(derivedColumnDefinitionsResult.isEmpty());
    assertSame(derivedColumnDefinitionsResult, actualCopyOfResult.fixedColumnDefinitions());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Json#derivedColumnDefinitions()}
   */
  @Test
  void testJsonDerivedColumnDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridDefinition.Json()).derivedColumnDefinitions());
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinition.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridDefinition.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinition.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridDefinition.Json()).externalId());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinition.Json#fixedColumnDefinitions()}
   */
  @Test
  void testJsonFixedColumnDefinitions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridDefinition.Json()).fixedColumnDefinitions());
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinition.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridDefinition.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinition.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridDefinition.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinition.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridDefinition.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinition.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridDefinition.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinition.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridDefinition.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableReportGridDefinition.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableReportGridDefinition.Json actualJson = new ImmutableReportGridDefinition.Json();

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
   * Method under test: {@link ImmutableReportGridDefinition.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridDefinition.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinition.Json#subjectKind()}
   */
  @Test
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridDefinition.Json()).subjectKind());
  }
}
