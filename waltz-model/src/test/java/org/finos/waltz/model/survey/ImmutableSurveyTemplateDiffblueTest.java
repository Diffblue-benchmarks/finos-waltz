package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ReleaseLifecycleStatus;
import org.junit.jupiter.api.Test;

class ImmutableSurveyTemplateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableSurveyTemplate#builder()}
   *   <li>{@link ImmutableSurveyTemplate#createdAt(LocalDateTime)}
   *   <li>{@link ImmutableSurveyTemplate#description(String)}
   *   <li>{@link ImmutableSurveyTemplate#externalId(String)}
   *   <li>{@link ImmutableSurveyTemplate#kind(EntityKind)}
   *   <li>{@link ImmutableSurveyTemplate#status(ReleaseLifecycleStatus)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableSurveyTemplate.Builder actualBuilderResult = ImmutableSurveyTemplate.builder();
    ImmutableSurveyTemplate.Builder actualExternalIdResult = actualBuilderResult
        .createdAt(LocalDate.of(1970, 1, 1).atStartOfDay())
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableSurveyTemplate.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableSurveyTemplate.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);

    // Assert
    assertSame(actualKindResult, actualKindResult.status(ReleaseLifecycleStatus.DRAFT));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(SurveyTemplate)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    SurveyTemplate instance = mock(SurveyTemplate.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.ownerId()).thenReturn(1L);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).createdAt();
    verify(instance).issuanceRole();
    verify(instance).kind();
    verify(instance).ownerId();
    verify(instance).status();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplate buildResult = builderResult.build();
    assertEquals("Issuance Role", buildResult.issuanceRole());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(SurveyTemplate)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    SurveyTemplate instance = mock(SurveyTemplate.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.ownerId()).thenReturn(1L);
    when(instance.issuanceRole()).thenReturn(null);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).createdAt();
    verify(instance).issuanceRole();
    verify(instance).kind();
    verify(instance).ownerId();
    verify(instance).status();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplate buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.issuanceRole());
    assertEquals(1L, buildResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(SurveyTemplate)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    SurveyTemplate instance = mock(SurveyTemplate.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.ownerId()).thenReturn(1L);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).createdAt();
    verify(instance).issuanceRole();
    verify(instance).kind();
    verify(instance).ownerId();
    verify(instance).status();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplate buildResult = builderResult.build();
    assertEquals("Issuance Role", buildResult.issuanceRole());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(SurveyTemplate)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    SurveyTemplate instance = mock(SurveyTemplate.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.ownerId()).thenReturn(1L);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).createdAt();
    verify(instance).issuanceRole();
    verify(instance).kind();
    verify(instance).ownerId();
    verify(instance).status();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplate buildResult = builderResult.build();
    assertEquals("Issuance Role", buildResult.issuanceRole());
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#from(SurveyTemplate)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    SurveyTemplate instance = mock(SurveyTemplate.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.ownerId()).thenReturn(1L);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.createdAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.description()).thenReturn(null);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplate.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).createdAt();
    verify(instance).issuanceRole();
    verify(instance).kind();
    verify(instance).ownerId();
    verify(instance).status();
    verify(instance).targetEntityKind();
    ImmutableSurveyTemplate buildResult = builderResult.build();
    assertEquals("Issuance Role", buildResult.issuanceRole());
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(EntityKind.ALL, buildResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, buildResult.status());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Builder#ownerId(Long)}
   */
  @Test
  void testBuilderOwnerId() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ownerId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyTemplate.Builder#targetEntityKind(EntityKind)}
   */
  @Test
  void testBuilderTargetEntityKind() {
    // Arrange
    ImmutableSurveyTemplate.Builder builderResult = ImmutableSurveyTemplate.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.targetEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate#copyOf(SurveyTemplate)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyTemplate instance = mock(SurveyTemplate.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.ownerId()).thenReturn(1L);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplate actualCopyOfResult = ImmutableSurveyTemplate.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).createdAt();
    verify(instance).issuanceRole();
    verify(instance).kind();
    verify(instance).ownerId();
    verify(instance).status();
    verify(instance).targetEntityKind();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualCopyOfResult.issuanceRole());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate#copyOf(SurveyTemplate)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    SurveyTemplate instance = mock(SurveyTemplate.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.ownerId()).thenReturn(1L);
    when(instance.issuanceRole()).thenReturn(null);
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplate actualCopyOfResult = ImmutableSurveyTemplate.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).createdAt();
    verify(instance).issuanceRole();
    verify(instance).kind();
    verify(instance).ownerId();
    verify(instance).status();
    verify(instance).targetEntityKind();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertNull(actualCopyOfResult.issuanceRole());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate#copyOf(SurveyTemplate)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    SurveyTemplate instance = mock(SurveyTemplate.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.ownerId()).thenReturn(1L);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplate actualCopyOfResult = ImmutableSurveyTemplate.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).createdAt();
    verify(instance).issuanceRole();
    verify(instance).kind();
    verify(instance).ownerId();
    verify(instance).status();
    verify(instance).targetEntityKind();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualCopyOfResult.issuanceRole());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate#copyOf(SurveyTemplate)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    SurveyTemplate instance = mock(SurveyTemplate.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.ownerId()).thenReturn(1L);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult2.atStartOfDay());
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplate actualCopyOfResult = ImmutableSurveyTemplate.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).createdAt();
    verify(instance).issuanceRole();
    verify(instance).kind();
    verify(instance).ownerId();
    verify(instance).status();
    verify(instance).targetEntityKind();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualCopyOfResult.issuanceRole());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertSame(ofResult2, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate#copyOf(SurveyTemplate)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    SurveyTemplate instance = mock(SurveyTemplate.class);
    when(instance.status()).thenReturn(ReleaseLifecycleStatus.DRAFT);
    when(instance.ownerId()).thenReturn(1L);
    when(instance.issuanceRole()).thenReturn("Issuance Role");
    when(instance.targetEntityKind()).thenReturn(EntityKind.ALL);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.createdAt()).thenReturn(ofResult3.atStartOfDay());
    when(instance.description()).thenReturn(null);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableSurveyTemplate actualCopyOfResult = ImmutableSurveyTemplate.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).createdAt();
    verify(instance).issuanceRole();
    verify(instance).kind();
    verify(instance).ownerId();
    verify(instance).status();
    verify(instance).targetEntityKind();
    LocalDateTime createdAtResult = actualCopyOfResult.createdAt();
    assertEquals("00:00", createdAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = createdAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("Issuance Role", actualCopyOfResult.issuanceRole());
    assertEquals("Name", actualCopyOfResult.name());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ownerId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.targetEntityKind());
    assertEquals(ReleaseLifecycleStatus.DRAFT, actualCopyOfResult.status());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Json#createdAt()}
   */
  @Test
  void testJsonCreatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplate.Json()).createdAt());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplate.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplate.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplate.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Json#issuanceRole()}
   */
  @Test
  void testJsonIssuanceRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplate.Json()).issuanceRole());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplate.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplate.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyTemplate.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyTemplate.Json actualJson = new ImmutableSurveyTemplate.Json();

    // Assert
    assertNull(actualJson.ownerId);
    assertNull(actualJson.description);
    assertNull(actualJson.issuanceRole);
    assertNull(actualJson.name);
    assertNull(actualJson.createdAt);
    assertNull(actualJson.kind);
    assertNull(actualJson.targetEntityKind);
    assertNull(actualJson.status);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Json#ownerId()}
   */
  @Test
  void testJsonOwnerId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplate.Json()).ownerId());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Json#status()}
   */
  @Test
  void testJsonStatus() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplate.Json()).status());
  }

  /**
   * Method under test: {@link ImmutableSurveyTemplate.Json#targetEntityKind()}
   */
  @Test
  void testJsonTargetEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableSurveyTemplate.Json()).targetEntityKind());
  }
}
