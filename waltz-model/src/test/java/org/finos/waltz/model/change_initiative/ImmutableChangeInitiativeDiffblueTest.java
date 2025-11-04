package org.finos.waltz.model.change_initiative;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.OrganisationalUnitIdProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.application.LifecyclePhase;
import org.junit.jupiter.api.Test;

class ImmutableChangeInitiativeDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#changeInitiativeKind(ChangeInitiativeKind)}
   */
  @Test
  void testBuilderChangeInitiativeKind() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.changeInitiativeKind(ChangeInitiativeKind.INITIATIVE));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#changeInitiativeKind(ChangeInitiativeKind)}
   */
  @Test
  void testBuilderChangeInitiativeKind2() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    builderResult.lastUpdate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.changeInitiativeKind(ChangeInitiativeKind.INITIATIVE));
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#endDate(Date)}
   */
  @Test
  void testBuilderEndDate() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.endDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#endDate(java.util.Date)}
   */
  @Test
  void testBuilderEndDate2() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.endDate(mock(java.sql.Date.class)));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    builderResult.lastUpdate(mock(java.sql.Date.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    OrganisationalUnitIdProvider instance = mock(OrganisationalUnitIdProvider.class);
    when(instance.organisationalUnitId()).thenReturn(1L);

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).organisationalUnitId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(OrganisationalUnitIdProvider)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    OrganisationalUnitIdProvider instance = mock(OrganisationalUnitIdProvider.class);
    when(instance.organisationalUnitId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).organisationalUnitId();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ParentIdProvider)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ChangeInitiative)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    ImmutableChangeInitiative buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, buildResult.changeInitiativeKind());
    assertSame(fromResult2, buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ChangeInitiative)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    when(instance.startDate()).thenThrow(new IllegalStateException("instance"));
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.endDate())
        .thenReturn(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ChangeInitiative)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Date> ofResult = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    ImmutableChangeInitiative buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, buildResult.changeInitiativeKind());
    assertSame(fromResult2, buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ChangeInitiative)}
   */
  @Test
  void testBuilderFrom22() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> emptyResult = Optional.empty();
    when(instance.lastUpdate()).thenReturn(emptyResult);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    ImmutableChangeInitiative buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, buildResult.changeInitiativeKind());
    assertSame(fromResult2, buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ChangeInitiative)}
   */
  @Test
  void testBuilderFrom23() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    ImmutableChangeInitiative buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, buildResult.changeInitiativeKind());
    assertSame(fromResult2, buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ChangeInitiative)}
   */
  @Test
  void testBuilderFrom24() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    ImmutableChangeInitiative buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, buildResult.changeInitiativeKind());
    assertSame(fromResult2, buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#from(ChangeInitiative)}
   */
  @Test
  void testBuilderFrom25() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    ImmutableChangeInitiative buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, buildResult.changeInitiativeKind());
    assertSame(fromResult2, buildResult.endDate());
    assertSame(fromResult, buildResult.startDate());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    builderResult.lastUpdate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    builderResult.lastUpdate(mock(java.sql.Date.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  void testBuilderLifecyclePhase() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  void testBuilderLifecyclePhase2() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    builderResult.lastUpdate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#name(String)}
   */
  @Test
  void testBuilderName2() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    builderResult.lastUpdate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#organisationalUnitId(Long)}
   */
  @Test
  void testBuilderOrganisationalUnitId() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnitId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#organisationalUnitId(Long)}
   */
  @Test
  void testBuilderOrganisationalUnitId2() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    builderResult.lastUpdate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnitId(1L));
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#parentId(long)}
   */
  @Test
  void testBuilderParentId() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(1L));
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#parentId(long)}
   */
  @Test
  void testBuilderParentId2() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    builderResult.lastUpdate(mock(java.sql.Date.class));

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#parentId(Optional)}
   */
  @Test
  void testBuilderParentId3() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(parentId));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#parentId(Optional)}
   */
  @Test
  void testBuilderParentId4() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();
    builderResult.lastUpdate(mock(java.sql.Date.class));
    Optional<Long> parentId = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.parentId(parentId));
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Builder#startDate(Date)}
   */
  @Test
  void testBuilderStartDate() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult,
        builderResult.startDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Builder#startDate(java.util.Date)}
   */
  @Test
  void testBuilderStartDate2() {
    // Arrange
    ImmutableChangeInitiative.Builder builderResult = ImmutableChangeInitiative.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.startDate(mock(java.sql.Date.class)));
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative#copyOf(ChangeInitiative)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative actualCopyOfResult = ImmutableChangeInitiative.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualCopyOfResult.changeInitiativeKind());
    assertSame(fromResult2, actualCopyOfResult.endDate());
    assertSame(fromResult, actualCopyOfResult.startDate());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative#copyOf(ChangeInitiative)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<Date> ofResult = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative actualCopyOfResult = ImmutableChangeInitiative.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualCopyOfResult.changeInitiativeKind());
    assertSame(fromResult2, actualCopyOfResult.endDate());
    assertSame(fromResult, actualCopyOfResult.startDate());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative#copyOf(ChangeInitiative)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> emptyResult = Optional.empty();
    when(instance.lastUpdate()).thenReturn(emptyResult);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative actualCopyOfResult = ImmutableChangeInitiative.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualCopyOfResult.changeInitiativeKind());
    assertSame(fromResult2, actualCopyOfResult.endDate());
    assertSame(fromResult, actualCopyOfResult.startDate());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative#copyOf(ChangeInitiative)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Long> ofResult4 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult4);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative actualCopyOfResult = ImmutableChangeInitiative.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualCopyOfResult.changeInitiativeKind());
    assertSame(fromResult2, actualCopyOfResult.endDate());
    assertSame(fromResult, actualCopyOfResult.startDate());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative#copyOf(ChangeInitiative)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult3 = Optional.<Long>of(1L);
    when(instance.parentId()).thenReturn(ofResult3);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative actualCopyOfResult = ImmutableChangeInitiative.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualCopyOfResult.changeInitiativeKind());
    assertSame(fromResult2, actualCopyOfResult.endDate());
    assertSame(fromResult, actualCopyOfResult.startDate());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative#copyOf(ChangeInitiative)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    ChangeInitiative instance = mock(ChangeInitiative.class);
    Date fromResult = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.startDate()).thenReturn(fromResult);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<Date> ofResult2 = Optional
        .of(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    when(instance.lastUpdate()).thenReturn(ofResult2);
    when(instance.changeInitiativeKind()).thenReturn(ChangeInitiativeKind.INITIATIVE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    Date fromResult2 = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    when(instance.endDate()).thenReturn(fromResult2);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableChangeInitiative actualCopyOfResult = ImmutableChangeInitiative.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).organisationalUnitId();
    verify(instance).parentId();
    verify(instance).provenance();
    verify(instance).changeInitiativeKind();
    verify(instance).endDate();
    verify(instance).kind();
    verify(instance).lastUpdate();
    verify(instance).lifecyclePhase();
    verify(instance).startDate();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(ChangeInitiativeKind.INITIATIVE, actualCopyOfResult.changeInitiativeKind());
    assertSame(fromResult2, actualCopyOfResult.endDate());
    assertSame(fromResult, actualCopyOfResult.startDate());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Json#changeInitiativeKind()}
   */
  @Test
  void testJsonChangeInitiativeKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableChangeInitiative.Json()).changeInitiativeKind());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeInitiative.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Json#endDate()}
   */
  @Test
  void testJsonEndDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeInitiative.Json()).endDate());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeInitiative.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeInitiative.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeInitiative.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Json#lastUpdate()}
   */
  @Test
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeInitiative.Json()).lastUpdate());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Json#lifecyclePhase()}
   */
  @Test
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeInitiative.Json()).lifecyclePhase());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeInitiative.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableChangeInitiative.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableChangeInitiative.Json actualJson = new ImmutableChangeInitiative.Json();

    // Assert
    assertNull(actualJson.organisationalUnitId);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.endDate);
    assertNull(actualJson.startDate);
    assertNull(actualJson.kind);
    assertNull(actualJson.lifecyclePhase);
    assertNull(actualJson.changeInitiativeKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.lastUpdate.isPresent());
    assertFalse(actualJson.parentId.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableChangeInitiative.Json#organisationalUnitId()}
   */
  @Test
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableChangeInitiative.Json()).organisationalUnitId());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Json#parentId()}
   */
  @Test
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeInitiative.Json()).parentId());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeInitiative.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableChangeInitiative.Json#startDate()}
   */
  @Test
  void testJsonStartDate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableChangeInitiative.Json()).startDate());
  }
}
