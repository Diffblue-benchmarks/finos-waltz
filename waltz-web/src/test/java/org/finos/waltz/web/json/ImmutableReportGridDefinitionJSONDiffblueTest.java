package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableReportGridDefinitionJSONDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridDefinitionJSON#builder()}
   *   <li>{@link ImmutableReportGridDefinitionJSON#description(String)}
   *   <li>{@link ImmutableReportGridDefinitionJSON#externalId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGridDefinitionJSON.Builder actualExternalIdResult = ImmutableReportGridDefinitionJSON.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableReportGridDefinitionJSON.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#addAllColumns(Iterable)}
   */
  @Test
  void testBuilderAddAllColumns() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllColumns(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#addColumns(ReportGridDefinitionJSON.ReportGridColumnJSON)}
   */
  @Test
  void testBuilderAddColumns() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addColumns(new ImmutableReportGridColumnJSON.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#addColumns(ReportGridDefinitionJSON.ReportGridColumnJSON[])}
   */
  @Test
  void testBuilderAddColumns2() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addColumns(new ImmutableReportGridColumnJSON.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#columns(Iterable)}
   */
  @Test
  void testBuilderColumns() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columns(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableReportGridDefinitionJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableReportGridDefinitionJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableReportGridDefinitionJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableReportGridDefinitionJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableReportGridDefinitionJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableReportGridDefinitionJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinitionJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(ReportGridDefinitionJSON)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ReportGridDefinitionJSON instance = mock(ReportGridDefinitionJSON.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.columns()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinitionJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).columns();
    verify(instance).subjectKind();
    ImmutableReportGridDefinitionJSON buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(ReportGridDefinitionJSON)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ReportGridDefinitionJSON instance = mock(ReportGridDefinitionJSON.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(ReportGridDefinitionJSON)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ReportGridDefinitionJSON instance = mock(ReportGridDefinitionJSON.class);
    when(instance.description()).thenReturn(null);
    when(instance.columns()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinitionJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).columns();
    verify(instance).subjectKind();
    ImmutableReportGridDefinitionJSON buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(ReportGridDefinitionJSON)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    ArrayList<ReportGridDefinitionJSON.ReportGridColumnJSON> reportGridColumnJSONList = new ArrayList<>();
    ImmutableReportGridColumnJSON.Json json = new ImmutableReportGridColumnJSON.Json();
    reportGridColumnJSONList.add(json);
    ReportGridDefinitionJSON instance = mock(ReportGridDefinitionJSON.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.columns()).thenReturn(reportGridColumnJSONList);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinitionJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).columns();
    verify(instance).subjectKind();
    ImmutableReportGridDefinitionJSON buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    List<ReportGridDefinitionJSON.ReportGridColumnJSON> columnsResult = buildResult.columns();
    assertEquals(1, columnsResult.size());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertSame(json, columnsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(ReportGridDefinitionJSON)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ReportGridDefinitionJSON instance = mock(ReportGridDefinitionJSON.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.columns()).thenReturn(new ArrayList<>());
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinitionJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).columns();
    verify(instance).subjectKind();
    ImmutableReportGridDefinitionJSON buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#from(ReportGridDefinitionJSON)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ReportGridDefinitionJSON instance = mock(ReportGridDefinitionJSON.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.columns()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinitionJSON.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).columns();
    verify(instance).subjectKind();
    ImmutableReportGridDefinitionJSON buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinitionJSON.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON#copyOf(ReportGridDefinitionJSON)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridDefinitionJSON instance = mock(ReportGridDefinitionJSON.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.columns()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinitionJSON actualCopyOfResult = ImmutableReportGridDefinitionJSON.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).columns();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.columns().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON#copyOf(ReportGridDefinitionJSON)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ArrayList<ReportGridDefinitionJSON.ReportGridColumnJSON> reportGridColumnJSONList = new ArrayList<>();
    reportGridColumnJSONList.add(new ImmutableReportGridColumnJSON.Json());
    ReportGridDefinitionJSON instance = mock(ReportGridDefinitionJSON.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.columns()).thenReturn(reportGridColumnJSONList);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinitionJSON actualCopyOfResult = ImmutableReportGridDefinitionJSON.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).columns();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(reportGridColumnJSONList, actualCopyOfResult.columns());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON#copyOf(ReportGridDefinitionJSON)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ArrayList<ReportGridDefinitionJSON.ReportGridColumnJSON> reportGridColumnJSONList = new ArrayList<>();
    reportGridColumnJSONList.add(new ImmutableReportGridColumnJSON.Json());
    reportGridColumnJSONList.add(new ImmutableReportGridColumnJSON.Json());
    ReportGridDefinitionJSON instance = mock(ReportGridDefinitionJSON.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.columns()).thenReturn(reportGridColumnJSONList);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinitionJSON actualCopyOfResult = ImmutableReportGridDefinitionJSON.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).columns();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertEquals(reportGridColumnJSONList, actualCopyOfResult.columns());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON#copyOf(ReportGridDefinitionJSON)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ReportGridDefinitionJSON instance = mock(ReportGridDefinitionJSON.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.columns()).thenReturn(new ArrayList<>());
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinitionJSON actualCopyOfResult = ImmutableReportGridDefinitionJSON.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).columns();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.columns().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON#copyOf(ReportGridDefinitionJSON)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ReportGridDefinitionJSON instance = mock(ReportGridDefinitionJSON.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.columns()).thenReturn(new ArrayList<>());
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableReportGridDefinitionJSON actualCopyOfResult = ImmutableReportGridDefinitionJSON.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).columns();
    verify(instance).subjectKind();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.columns().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON#fromJson(ImmutableReportGridDefinitionJSON.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableReportGridDefinitionJSON.Json json = new ImmutableReportGridDefinitionJSON.Json();
    json.setId(null);
    json.setName("Json");
    json.setExternalId(null);
    json.setDescription(null);
    json.setSubjectKind(EntityKind.ALL);
    json.setColumns(null);

    // Act
    ImmutableReportGridDefinitionJSON actualFromJsonResult = ImmutableReportGridDefinitionJSON.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertTrue(actualFromJsonResult.columns().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON#fromJson(ImmutableReportGridDefinitionJSON.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    ArrayList<ReportGridDefinitionJSON.ReportGridColumnJSON> columns = new ArrayList<>();
    columns.add(new ImmutableReportGridColumnJSON.Json());

    ImmutableReportGridDefinitionJSON.Json json = new ImmutableReportGridDefinitionJSON.Json();
    json.setId(null);
    json.setName("Json");
    json.setExternalId(null);
    json.setDescription(null);
    json.setSubjectKind(EntityKind.ALL);
    json.setColumns(columns);

    // Act
    ImmutableReportGridDefinitionJSON actualFromJsonResult = ImmutableReportGridDefinitionJSON.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertEquals(columns, actualFromJsonResult.columns());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON#fromJson(ImmutableReportGridDefinitionJSON.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    ArrayList<ReportGridDefinitionJSON.ReportGridColumnJSON> columns = new ArrayList<>();
    columns.add(new ImmutableReportGridColumnJSON.Json());
    columns.add(new ImmutableReportGridColumnJSON.Json());

    ImmutableReportGridDefinitionJSON.Json json = new ImmutableReportGridDefinitionJSON.Json();
    json.setId(null);
    json.setName("Json");
    json.setExternalId(null);
    json.setDescription(null);
    json.setSubjectKind(EntityKind.ALL);
    json.setColumns(columns);

    // Act
    ImmutableReportGridDefinitionJSON actualFromJsonResult = ImmutableReportGridDefinitionJSON.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertEquals(columns, actualFromJsonResult.columns());
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinitionJSON.Json#columns()}
   */
  @Test
  void testJsonColumns() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridDefinitionJSON.Json()).columns());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridDefinitionJSON.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridDefinitionJSON.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinitionJSON.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridDefinitionJSON.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableReportGridDefinitionJSON.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridDefinitionJSON.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableReportGridDefinitionJSON.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableReportGridDefinitionJSON.Json actualJson = new ImmutableReportGridDefinitionJSON.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.subjectKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertTrue(actualJson.columns.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDefinitionJSON.Json#subjectKind()}
   */
  @Test
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridDefinitionJSON.Json()).subjectKind());
  }
}
