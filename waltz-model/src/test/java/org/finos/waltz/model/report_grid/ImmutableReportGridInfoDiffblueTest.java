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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableReportGridInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridInfo#builder()}
   *   <li>{@link ImmutableReportGridInfo#description(String)}
   *   <li>{@link ImmutableReportGridInfo#externalId(String)}
   *   <li>{@link ImmutableReportGridInfo#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableReportGridInfo#provenance(String)}
   *   <li>{@link ImmutableReportGridInfo#visibilityKind(ReportGridKind)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGridInfo.Builder actualExternalIdResult = ImmutableReportGridInfo.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableReportGridInfo.Builder actualExternalIdResult2 = actualExternalIdResult.externalId(externalId);
    ImmutableReportGridInfo.Builder actualProvenanceResult = actualExternalIdResult2
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .provenance("Provenance");

    // Assert
    assertSame(actualProvenanceResult, actualProvenanceResult.visibilityKind(ReportGridKind.PUBLIC));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableReportGridInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableReportGridInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableReportGridInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableReportGridInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableReportGridInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenThrow(new IllegalStateException("instance"));
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableReportGridInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(ReportGridInfo)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    ReportGridInfo instance = mock(ReportGridInfo.class);
    when(instance.gridId()).thenReturn(1L);
    when(instance.visibilityKind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).gridId();
    verify(instance).subjectKind();
    verify(instance).visibilityKind();
    ImmutableReportGridInfo buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.gridId());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, buildResult.visibilityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(ReportGridInfo)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    ReportGridInfo instance = mock(ReportGridInfo.class);
    when(instance.gridId()).thenThrow(new IllegalStateException("instance"));
    when(instance.visibilityKind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
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
    verify(instance).gridId();
    verify(instance).subjectKind();
    verify(instance).visibilityKind();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(ReportGridInfo)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    ReportGridInfo instance = mock(ReportGridInfo.class);
    when(instance.gridId()).thenReturn(1L);
    when(instance.visibilityKind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).gridId();
    verify(instance).subjectKind();
    verify(instance).visibilityKind();
    ImmutableReportGridInfo buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.gridId());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, buildResult.visibilityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#from(ReportGridInfo)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();
    ReportGridInfo instance = mock(ReportGridInfo.class);
    when(instance.gridId()).thenReturn(1L);
    when(instance.visibilityKind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridInfo.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).gridId();
    verify(instance).subjectKind();
    verify(instance).visibilityKind();
    ImmutableReportGridInfo buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.gridId());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, buildResult.visibilityKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Builder#gridId(long)}
   */
  @Test
  void testBuilderGridId() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.gridId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridInfo.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind() {
    // Arrange
    ImmutableReportGridInfo.Builder builderResult = ImmutableReportGridInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo#copyOf(ReportGridInfo)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridInfo instance = mock(ReportGridInfo.class);
    when(instance.gridId()).thenReturn(1L);
    when(instance.visibilityKind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridInfo actualCopyOfResult = ImmutableReportGridInfo.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).gridId();
    verify(instance).subjectKind();
    verify(instance).visibilityKind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.gridId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCopyOfResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo#copyOf(ReportGridInfo)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ReportGridInfo instance = mock(ReportGridInfo.class);
    when(instance.gridId()).thenReturn(1L);
    when(instance.visibilityKind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridInfo actualCopyOfResult = ImmutableReportGridInfo.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).gridId();
    verify(instance).subjectKind();
    verify(instance).visibilityKind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.gridId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCopyOfResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo#copyOf(ReportGridInfo)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ReportGridInfo instance = mock(ReportGridInfo.class);
    when(instance.gridId()).thenReturn(1L);
    when(instance.visibilityKind()).thenReturn(ReportGridKind.PUBLIC);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult.atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridInfo actualCopyOfResult = ImmutableReportGridInfo.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).gridId();
    verify(instance).subjectKind();
    verify(instance).visibilityKind();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.gridId());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(ReportGridKind.PUBLIC, actualCopyOfResult.visibilityKind());
    assertSame(ofResult, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridInfo.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridInfo.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Json#gridId()}
   */
  @Test
  void testJsonGridId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridInfo.Json()).gridId());
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridInfo.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridInfo.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridInfo.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableReportGridInfo.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableReportGridInfo.Json actualJson = new ImmutableReportGridInfo.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.subjectKind);
    assertNull(actualJson.visibilityKind);
    assertEquals(0L, actualJson.gridId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.gridIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridInfo.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Json#setGridId(long)}
   */
  @Test
  void testJsonSetGridId() {
    // Arrange
    ImmutableReportGridInfo.Json json = new ImmutableReportGridInfo.Json();

    // Act
    json.setGridId(1L);

    // Assert
    assertEquals(1L, json.gridId);
    assertTrue(json.gridIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Json#subjectKind()}
   */
  @Test
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridInfo.Json()).subjectKind());
  }

  /**
   * Method under test: {@link ImmutableReportGridInfo.Json#visibilityKind()}
   */
  @Test
  void testJsonVisibilityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridInfo.Json()).visibilityKind());
  }
}
