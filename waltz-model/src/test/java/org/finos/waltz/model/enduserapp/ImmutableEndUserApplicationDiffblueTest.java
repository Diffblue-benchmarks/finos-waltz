package org.finos.waltz.model.enduserapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.physical_flow.CriticalityValue;
import org.junit.jupiter.api.Test;

class ImmutableEndUserApplicationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableEndUserApplication#builder()}
   *   <li>{@link ImmutableEndUserApplication#description(String)}
   *   <li>{@link ImmutableEndUserApplication#externalId(String)}
   *   <li>{@link ImmutableEndUserApplication#kind(EntityKind)}
   *   <li>{@link ImmutableEndUserApplication#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableEndUserApplication.Builder actualExternalIdResult = ImmutableEndUserApplication.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableEndUserApplication.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    ImmutableEndUserApplication.Builder actualKindResult = actualIdResult.id(id).kind(EntityKind.ALL);

    // Assert
    assertSame(actualKindResult, actualKindResult.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#applicationKind(String)}
   */
  @Test
  void testBuilderApplicationKind() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationKind("Application Kind"));
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(EntityKindProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(EndUserApplication)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    EndUserApplication instance = mock(EndUserApplication.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.riskRating()).thenReturn(ofResult3);
    when(instance.isPromoted()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.applicationKind()).thenReturn("Application Kind");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).applicationKind();
    verify(instance).isPromoted();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).riskRating();
    ImmutableEndUserApplication buildResult = builderResult.build();
    assertEquals("Application Kind", buildResult.applicationKind());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertTrue(buildResult.isPromoted());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.riskRating());
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(EndUserApplication)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    EndUserApplication instance = mock(EndUserApplication.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.isPromoted()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.applicationKind()).thenReturn("Application Kind");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).applicationKind();
    verify(instance).isPromoted();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(EndUserApplication)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    EndUserApplication instance = mock(EndUserApplication.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    CriticalityValue ofResult2 = CriticalityValue.of("42");
    when(instance.riskRating()).thenReturn(ofResult2);
    when(instance.isPromoted()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.applicationKind()).thenReturn("Application Kind");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).applicationKind();
    verify(instance).isPromoted();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).riskRating();
    ImmutableEndUserApplication buildResult = builderResult.build();
    assertEquals("Application Kind", buildResult.applicationKind());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertTrue(buildResult.isPromoted());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.riskRating());
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(EndUserApplication)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    EndUserApplication instance = mock(EndUserApplication.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    CriticalityValue ofResult2 = CriticalityValue.of("42");
    when(instance.riskRating()).thenReturn(ofResult2);
    when(instance.isPromoted()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.applicationKind()).thenReturn("Application Kind");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).applicationKind();
    verify(instance).isPromoted();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).riskRating();
    ImmutableEndUserApplication buildResult = builderResult.build();
    assertEquals("Application Kind", buildResult.applicationKind());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertTrue(buildResult.isPromoted());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult2, buildResult.riskRating());
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#from(EndUserApplication)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    EndUserApplication instance = mock(EndUserApplication.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.riskRating()).thenReturn(ofResult3);
    when(instance.isPromoted()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.applicationKind()).thenReturn("Application Kind");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEndUserApplication.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).applicationKind();
    verify(instance).isPromoted();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).riskRating();
    ImmutableEndUserApplication buildResult = builderResult.build();
    assertEquals("Application Kind", buildResult.applicationKind());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertTrue(buildResult.isPromoted());
    assertSame(builderResult, actualFromResult);
    assertSame(ofResult3, buildResult.riskRating());
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#isPromoted(Boolean)}
   */
  @Test
  void testBuilderIsPromoted() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isPromoted(true));
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  void testBuilderLifecyclePhase() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#organisationalUnitId(Long)}
   */
  @Test
  void testBuilderOrganisationalUnitId() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnitId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Builder#riskRating(CriticalityValue)}
   */
  @Test
  void testBuilderRiskRating() {
    // Arrange
    ImmutableEndUserApplication.Builder builderResult = ImmutableEndUserApplication.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.riskRating(CriticalityValue.of("42")));
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication#copyOf(EndUserApplication)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    EndUserApplication instance = mock(EndUserApplication.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.riskRating()).thenReturn(ofResult3);
    when(instance.isPromoted()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.applicationKind()).thenReturn("Application Kind");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEndUserApplication actualCopyOfResult = ImmutableEndUserApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).applicationKind();
    verify(instance).isPromoted();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).riskRating();
    CriticalityValue riskRatingResult = actualCopyOfResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualCopyOfResult.applicationKind());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertTrue(actualCopyOfResult.isPromoted());
    assertSame(ofResult3, riskRatingResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication#copyOf(EndUserApplication)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    EndUserApplication instance = mock(EndUserApplication.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    CriticalityValue ofResult2 = CriticalityValue.of("42");
    when(instance.riskRating()).thenReturn(ofResult2);
    when(instance.isPromoted()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.applicationKind()).thenReturn("Application Kind");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEndUserApplication actualCopyOfResult = ImmutableEndUserApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).applicationKind();
    verify(instance).isPromoted();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).riskRating();
    CriticalityValue riskRatingResult = actualCopyOfResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualCopyOfResult.applicationKind());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertTrue(actualCopyOfResult.isPromoted());
    assertSame(ofResult2, riskRatingResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication#copyOf(EndUserApplication)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    EndUserApplication instance = mock(EndUserApplication.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    CriticalityValue ofResult2 = CriticalityValue.of("42");
    when(instance.riskRating()).thenReturn(ofResult2);
    when(instance.isPromoted()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.applicationKind()).thenReturn("Application Kind");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEndUserApplication actualCopyOfResult = ImmutableEndUserApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).applicationKind();
    verify(instance).isPromoted();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).riskRating();
    CriticalityValue riskRatingResult = actualCopyOfResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualCopyOfResult.applicationKind());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertTrue(actualCopyOfResult.isPromoted());
    assertSame(ofResult2, riskRatingResult);
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication#copyOf(EndUserApplication)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    EndUserApplication instance = mock(EndUserApplication.class);
    when(instance.organisationalUnitId()).thenReturn(1L);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    CriticalityValue ofResult3 = CriticalityValue.of("42");
    when(instance.riskRating()).thenReturn(ofResult3);
    when(instance.isPromoted()).thenReturn(true);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.applicationKind()).thenReturn("Application Kind");
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableEndUserApplication actualCopyOfResult = ImmutableEndUserApplication.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).applicationKind();
    verify(instance).isPromoted();
    verify(instance).kind();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).riskRating();
    CriticalityValue riskRatingResult = actualCopyOfResult.riskRating();
    assertEquals("42", riskRatingResult.value());
    assertEquals("Application Kind", actualCopyOfResult.applicationKind());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertTrue(actualCopyOfResult.isPromoted());
    assertSame(ofResult3, riskRatingResult);
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Json#applicationKind()}
   */
  @Test
  void testJsonApplicationKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEndUserApplication.Json()).applicationKind());
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEndUserApplication.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEndUserApplication.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEndUserApplication.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Json#isPromoted()}
   */
  @Test
  void testJsonIsPromoted() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEndUserApplication.Json()).isPromoted());
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEndUserApplication.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Json#lifecyclePhase()}
   */
  @Test
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEndUserApplication.Json()).lifecyclePhase());
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEndUserApplication.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableEndUserApplication.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableEndUserApplication.Json actualJson = new ImmutableEndUserApplication.Json();

    // Assert
    assertNull(actualJson.isPromoted);
    assertNull(actualJson.organisationalUnitId);
    assertNull(actualJson.applicationKind);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.kind);
    assertNull(actualJson.lifecyclePhase);
    assertNull(actualJson.riskRating);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
  }

  /**
   * Method under test:
   * {@link ImmutableEndUserApplication.Json#organisationalUnitId()}
   */
  @Test
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableEndUserApplication.Json()).organisationalUnitId());
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEndUserApplication.Json()).provenance());
  }

  /**
   * Method under test: {@link ImmutableEndUserApplication.Json#riskRating()}
   */
  @Test
  void testJsonRiskRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableEndUserApplication.Json()).riskRating());
  }
}
