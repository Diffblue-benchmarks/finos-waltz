package org.finos.waltz.model.involvement_kind;

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
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementKindDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableInvolvementKind#builder()}
   *   <li>{@link ImmutableInvolvementKind#description(String)}
   *   <li>{@link ImmutableInvolvementKind#externalId(String)}
   *   <li>{@link ImmutableInvolvementKind#kind(EntityKind)}
   *   <li>{@link ImmutableInvolvementKind#lastUpdatedAt(LocalDateTime)}
   *   <li>{@link ImmutableInvolvementKind#permittedRole(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableInvolvementKind.Builder actualExternalIdResult = ImmutableInvolvementKind.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableInvolvementKind.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableInvolvementKind.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);
    ImmutableInvolvementKind.Builder actualLastUpdatedAtResult = actualKindResult
        .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay());

    // Assert
    assertSame(actualLastUpdatedAtResult, actualLastUpdatedAtResult.permittedRole("Permitted Role"));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
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
   * {@link ImmutableInvolvementKind.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(InvolvementKind)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    InvolvementKind instance = mock(InvolvementKind.class);
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.transitive()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    verify(instance).transitive();
    verify(instance).userSelectable();
    ImmutableInvolvementKind buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Permitted Role", buildResult.permittedRole());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertTrue(buildResult.transitive());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(InvolvementKind)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    InvolvementKind instance = mock(InvolvementKind.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).subjectKind();
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(InvolvementKind)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    InvolvementKind instance = mock(InvolvementKind.class);
    when(instance.permittedRole()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.transitive()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    verify(instance).transitive();
    verify(instance).userSelectable();
    ImmutableInvolvementKind buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.permittedRole());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertTrue(buildResult.transitive());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(InvolvementKind)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    InvolvementKind instance = mock(InvolvementKind.class);
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.transitive()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    verify(instance).transitive();
    verify(instance).userSelectable();
    ImmutableInvolvementKind buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Permitted Role", buildResult.permittedRole());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertTrue(buildResult.transitive());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(InvolvementKind)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    InvolvementKind instance = mock(InvolvementKind.class);
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.transitive()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    verify(instance).transitive();
    verify(instance).userSelectable();
    ImmutableInvolvementKind buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Permitted Role", buildResult.permittedRole());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertTrue(buildResult.transitive());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#from(InvolvementKind)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    InvolvementKind instance = mock(InvolvementKind.class);
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.transitive()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKind.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    verify(instance).transitive();
    verify(instance).userSelectable();
    ImmutableInvolvementKind buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Name", buildResult.name());
    assertEquals("Permitted Role", buildResult.permittedRole());
    assertNull(buildResult.description());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.subjectKind());
    assertTrue(buildResult.transitive());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#subjectKind(EntityKind)}
   */
  @Test
  void testBuilderSubjectKind() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.subjectKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#transitive(boolean)}
   */
  @Test
  void testBuilderTransitive() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.transitive(true));
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Builder#userSelectable(boolean)}
   */
  @Test
  void testBuilderUserSelectable() {
    // Arrange
    ImmutableInvolvementKind.Builder builderResult = ImmutableInvolvementKind.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userSelectable(true));
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind#copyOf(InvolvementKind)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    InvolvementKind instance = mock(InvolvementKind.class);
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.transitive()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKind actualCopyOfResult = ImmutableInvolvementKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    verify(instance).transitive();
    verify(instance).userSelectable();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Permitted Role", actualCopyOfResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.transitive());
    assertTrue(actualCopyOfResult.userSelectable());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind#copyOf(InvolvementKind)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    InvolvementKind instance = mock(InvolvementKind.class);
    when(instance.permittedRole()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.transitive()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKind actualCopyOfResult = ImmutableInvolvementKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    verify(instance).transitive();
    verify(instance).userSelectable();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.permittedRole());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.transitive());
    assertTrue(actualCopyOfResult.userSelectable());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind#copyOf(InvolvementKind)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    InvolvementKind instance = mock(InvolvementKind.class);
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.transitive()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKind actualCopyOfResult = ImmutableInvolvementKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    verify(instance).transitive();
    verify(instance).userSelectable();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Permitted Role", actualCopyOfResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.transitive());
    assertTrue(actualCopyOfResult.userSelectable());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind#copyOf(InvolvementKind)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    InvolvementKind instance = mock(InvolvementKind.class);
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.transitive()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKind actualCopyOfResult = ImmutableInvolvementKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    verify(instance).transitive();
    verify(instance).userSelectable();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Permitted Role", actualCopyOfResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.transitive());
    assertTrue(actualCopyOfResult.userSelectable());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind#copyOf(InvolvementKind)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    InvolvementKind instance = mock(InvolvementKind.class);
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.transitive()).thenReturn(false);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKind actualCopyOfResult = ImmutableInvolvementKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    verify(instance).transitive();
    verify(instance).userSelectable();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Permitted Role", actualCopyOfResult.permittedRole());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertFalse(actualCopyOfResult.transitive());
    assertTrue(actualCopyOfResult.userSelectable());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind#copyOf(InvolvementKind)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    InvolvementKind instance = mock(InvolvementKind.class);
    when(instance.permittedRole()).thenReturn("Permitted Role");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.transitive()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.subjectKind()).thenReturn(EntityKind.ALL);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.description()).thenReturn(null);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableInvolvementKind actualCopyOfResult = ImmutableInvolvementKind.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).subjectKind();
    verify(instance).transitive();
    verify(instance).userSelectable();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Permitted Role", actualCopyOfResult.permittedRole());
    assertNull(actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.transitive());
    assertTrue(actualCopyOfResult.userSelectable());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKind.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKind.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKind.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKind.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKind.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKind.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKind.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableInvolvementKind.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableInvolvementKind.Json actualJson = new ImmutableInvolvementKind.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.permittedRole);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.subjectKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.transitive);
    assertFalse(actualJson.transitiveIsSet);
    assertFalse(actualJson.userSelectable);
    assertFalse(actualJson.userSelectableIsSet);
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Json#permittedRole()}
   */
  @Test
  void testJsonPermittedRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKind.Json()).permittedRole());
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Json#setTransitive(boolean)}
   */
  @Test
  void testJsonSetTransitive() {
    // Arrange
    ImmutableInvolvementKind.Json json = new ImmutableInvolvementKind.Json();

    // Act
    json.setTransitive(true);

    // Assert
    assertTrue(json.transitive);
    assertTrue(json.transitiveIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableInvolvementKind.Json#setUserSelectable(boolean)}
   */
  @Test
  void testJsonSetUserSelectable() {
    // Arrange
    ImmutableInvolvementKind.Json json = new ImmutableInvolvementKind.Json();

    // Act
    json.setUserSelectable(true);

    // Assert
    assertTrue(json.userSelectable);
    assertTrue(json.userSelectableIsSet);
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Json#subjectKind()}
   */
  @Test
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKind.Json()).subjectKind());
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Json#transitive()}
   */
  @Test
  void testJsonTransitive() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKind.Json()).transitive());
  }

  /**
   * Method under test: {@link ImmutableInvolvementKind.Json#userSelectable()}
   */
  @Test
  void testJsonUserSelectable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableInvolvementKind.Json()).userSelectable());
  }
}
