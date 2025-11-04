package org.finos.waltz.model.assessment_definition;

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
import org.finos.waltz.model.Cardinality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.LastUpdatedProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.junit.jupiter.api.Test;

class ImmutableAssessmentDefinitionDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#entityKind(EntityKind)}
   */
  @Test
  void testBuilderEntityKind() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#entityKind(EntityKind)}
   */
  @Test
  void testBuilderEntityKind2() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.entityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    builderResult.qualifierReference(mock(EntityReference.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    LastUpdatedProvider instance = mock(LastUpdatedProvider.class);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(LastUpdatedProvider)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
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
   * {@link ImmutableAssessmentDefinition.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(AssessmentDefinition)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.qualifierReference()).thenThrow(new IllegalStateException("instance"));
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).entityKind();
    verify(instance).qualifierReference();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(AssessmentDefinition)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.permittedRole()).thenReturn(ofResult2);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<EntityReference> ofResult4 = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult4);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    ImmutableAssessmentDefinition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Definition Group", buildResult.definitionGroup());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, buildResult.cardinality());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, buildResult.visibility());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(AssessmentDefinition)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenThrow(new IllegalStateException("instance"));
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<EntityReference> ofResult2 = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult2);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
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
    verify(instance).cardinality();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(AssessmentDefinition)}
   */
  @Test
  void testBuilderFrom17() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(true);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.permittedRole()).thenReturn(ofResult);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<EntityReference> ofResult3 = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult3);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    ImmutableAssessmentDefinition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Definition Group", buildResult.definitionGroup());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, buildResult.cardinality());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, buildResult.visibility());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(AssessmentDefinition)}
   */
  @Test
  void testBuilderFrom18() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.permittedRole()).thenReturn(emptyResult);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<EntityReference> ofResult3 = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult3);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    ImmutableAssessmentDefinition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Definition Group", buildResult.definitionGroup());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, buildResult.cardinality());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, buildResult.visibility());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(AssessmentDefinition)}
   */
  @Test
  void testBuilderFrom19() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.permittedRole()).thenReturn(ofResult2);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<EntityReference> ofResult3 = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult3);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    ImmutableAssessmentDefinition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Definition Group", buildResult.definitionGroup());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, buildResult.cardinality());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, buildResult.visibility());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(AssessmentDefinition)}
   */
  @Test
  void testBuilderFrom20() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.permittedRole()).thenReturn(ofResult2);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.qualifierReference()).thenReturn(emptyResult);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    ImmutableAssessmentDefinition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Definition Group", buildResult.definitionGroup());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, buildResult.cardinality());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, buildResult.visibility());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#from(AssessmentDefinition)}
   */
  @Test
  void testBuilderFrom21() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.permittedRole()).thenReturn(ofResult2);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedAt()).thenReturn(LocalDate.of(1970, 1, 1).atStartOfDay());
    Optional<EntityReference> ofResult4 = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult4);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    ImmutableAssessmentDefinition buildResult = builderResult.build();
    assertEquals("2020-03-01", buildResult.lastUpdatedBy());
    assertEquals("Definition Group", buildResult.definitionGroup());
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, buildResult.cardinality());
    assertEquals(EntityKind.ALL, buildResult.entityKind());
    assertEquals(EntityKind.ALL, buildResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, buildResult.visibility());
    assertTrue(buildResult.isReadOnly());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Builder#id(long)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Builder#id(Optional)}
   */
  @Test
  void testBuilderId3() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Builder#id(Optional)}
   */
  @Test
  void testBuilderId4() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    builderResult.qualifierReference(mock(EntityReference.class));
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#isReadOnly(boolean)}
   */
  @Test
  void testBuilderIsReadOnly2() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.isReadOnly(true));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#lastUpdatedBy(String)}
   */
  @Test
  void testBuilderLastUpdatedBy2() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdatedBy("2020-03-01"));
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Builder#name(String)}
   */
  @Test
  void testBuilderName2() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#permittedRole(Optional)}
   */
  @Test
  void testBuilderPermittedRole() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    Optional<String> permittedRole = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.permittedRole(permittedRole));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#permittedRole(Optional)}
   */
  @Test
  void testBuilderPermittedRole2() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    builderResult.qualifierReference(mock(EntityReference.class));
    Optional<String> permittedRole = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.permittedRole(permittedRole));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#ratingSchemeId(long)}
   */
  @Test
  void testBuilderRatingSchemeId() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#ratingSchemeId(long)}
   */
  @Test
  void testBuilderRatingSchemeId2() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#visibility(AssessmentVisibility)}
   */
  @Test
  void testBuilderVisibility() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.visibility(AssessmentVisibility.PRIMARY));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Builder#visibility(AssessmentVisibility)}
   */
  @Test
  void testBuilderVisibility2() {
    // Arrange
    ImmutableAssessmentDefinition.Builder builderResult = ImmutableAssessmentDefinition.builder();
    builderResult.qualifierReference(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.visibility(AssessmentVisibility.PRIMARY));
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition#copyOf(AssessmentDefinition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.permittedRole()).thenReturn(ofResult2);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    Optional<EntityReference> ofResult5 = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult5);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition actualCopyOfResult = ImmutableAssessmentDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Definition Group", actualCopyOfResult.definitionGroup());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, actualCopyOfResult.cardinality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, actualCopyOfResult.visibility());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition#copyOf(AssessmentDefinition)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(false);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.permittedRole()).thenReturn(ofResult2);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    Optional<EntityReference> ofResult5 = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult5);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition actualCopyOfResult = ImmutableAssessmentDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Definition Group", actualCopyOfResult.definitionGroup());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, actualCopyOfResult.cardinality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, actualCopyOfResult.visibility());
    assertFalse(actualCopyOfResult.isReadOnly());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition#copyOf(AssessmentDefinition)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(true);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.permittedRole()).thenReturn(ofResult);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    Optional<EntityReference> ofResult4 = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult4);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition actualCopyOfResult = ImmutableAssessmentDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Definition Group", actualCopyOfResult.definitionGroup());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, actualCopyOfResult.cardinality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, actualCopyOfResult.visibility());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition#copyOf(AssessmentDefinition)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.permittedRole()).thenReturn(emptyResult);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    Optional<EntityReference> ofResult4 = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult4);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition actualCopyOfResult = ImmutableAssessmentDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Definition Group", actualCopyOfResult.definitionGroup());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, actualCopyOfResult.cardinality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, actualCopyOfResult.visibility());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition#copyOf(AssessmentDefinition)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.permittedRole()).thenReturn(ofResult2);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult3.atStartOfDay());
    Optional<EntityReference> ofResult4 = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult4);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition actualCopyOfResult = ImmutableAssessmentDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Definition Group", actualCopyOfResult.definitionGroup());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, actualCopyOfResult.cardinality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, actualCopyOfResult.visibility());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult3, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition#copyOf(AssessmentDefinition)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.permittedRole()).thenReturn(ofResult2);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    Optional<EntityReference> emptyResult = Optional.empty();
    when(instance.qualifierReference()).thenReturn(emptyResult);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition actualCopyOfResult = ImmutableAssessmentDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Definition Group", actualCopyOfResult.definitionGroup());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, actualCopyOfResult.cardinality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, actualCopyOfResult.visibility());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition#copyOf(AssessmentDefinition)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    AssessmentDefinition instance = mock(AssessmentDefinition.class);
    when(instance.isReadOnly()).thenReturn(true);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.permittedRole()).thenReturn(ofResult2);
    when(instance.definitionGroup()).thenReturn("Definition Group");
    Optional<String> ofResult3 = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult3);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.cardinality()).thenReturn(Cardinality.ZERO_ONE);
    when(instance.kind()).thenReturn(EntityKind.ALL);
    LocalDate ofResult4 = LocalDate.of(1970, 1, 1);
    when(instance.lastUpdatedAt()).thenReturn(ofResult4.atStartOfDay());
    Optional<EntityReference> ofResult5 = Optional.of(mock(EntityReference.class));
    when(instance.qualifierReference()).thenReturn(ofResult5);
    when(instance.visibility()).thenReturn(AssessmentVisibility.PRIMARY);
    when(instance.entityKind()).thenReturn(EntityKind.ALL);
    when(instance.lastUpdatedBy()).thenReturn("2020-03-01");
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAssessmentDefinition actualCopyOfResult = ImmutableAssessmentDefinition.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).lastUpdatedAt();
    verify(instance).lastUpdatedBy();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).cardinality();
    verify(instance).definitionGroup();
    verify(instance).entityKind();
    verify(instance).isReadOnly();
    verify(instance).kind();
    verify(instance).permittedRole();
    verify(instance).qualifierReference();
    verify(instance).ratingSchemeId();
    verify(instance).visibility();
    LocalDateTime lastUpdatedAtResult = actualCopyOfResult.lastUpdatedAt();
    assertEquals("00:00", lastUpdatedAtResult.toLocalTime().toString());
    LocalDate toLocalDateResult = lastUpdatedAtResult.toLocalDate();
    assertEquals("1970-01-01", toLocalDateResult.toString());
    assertEquals("2020-03-01", actualCopyOfResult.lastUpdatedBy());
    assertEquals("Definition Group", actualCopyOfResult.definitionGroup());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(Cardinality.ZERO_ONE, actualCopyOfResult.cardinality());
    assertEquals(EntityKind.ALL, actualCopyOfResult.entityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
    assertEquals(AssessmentVisibility.PRIMARY, actualCopyOfResult.visibility());
    assertTrue(actualCopyOfResult.isReadOnly());
    assertSame(ofResult4, toLocalDateResult);
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#cardinality()}
   */
  @Test
  void testJsonCardinality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).cardinality());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Json#definitionGroup()}
   */
  @Test
  void testJsonDefinitionGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentDefinition.Json()).definitionGroup());
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#entityKind()}
   */
  @Test
  void testJsonEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).entityKind());
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#isReadOnly()}
   */
  @Test
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).isReadOnly());
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#kind()}
   */
  @Test
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).kind());
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#lastUpdatedAt()}
   */
  @Test
  void testJsonLastUpdatedAt() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).lastUpdatedAt());
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#lastUpdatedBy()}
   */
  @Test
  void testJsonLastUpdatedBy() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).lastUpdatedBy());
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAssessmentDefinition.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAssessmentDefinition.Json actualJson = new ImmutableAssessmentDefinition.Json();

    // Assert
    assertNull(actualJson.definitionGroup);
    assertNull(actualJson.description);
    assertNull(actualJson.lastUpdatedBy);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.lastUpdatedAt);
    assertNull(actualJson.cardinality);
    assertNull(actualJson.entityKind);
    assertNull(actualJson.kind);
    assertNull(actualJson.visibility);
    assertEquals(0L, actualJson.ratingSchemeId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.permittedRole.isPresent());
    assertFalse(actualJson.qualifierReference.isPresent());
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.ratingSchemeIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#permittedRole()}
   */
  @Test
  void testJsonPermittedRole() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).permittedRole());
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Json#qualifierReference()}
   */
  @Test
  void testJsonQualifierReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentDefinition.Json()).qualifierReference());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Json#ratingSchemeId()}
   */
  @Test
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAssessmentDefinition.Json()).ratingSchemeId());
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly() {
    // Arrange
    ImmutableAssessmentDefinition.Json json = new ImmutableAssessmentDefinition.Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Json#setIsReadOnly(boolean)}
   */
  @Test
  void testJsonSetIsReadOnly2() {
    // Arrange
    ImmutableAssessmentDefinition.Json json = new ImmutableAssessmentDefinition.Json();
    Optional<EntityReference> qualifierReference = Optional.of(mock(EntityReference.class));
    json.setQualifierReference(qualifierReference);

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Json#setRatingSchemeId(long)}
   */
  @Test
  void testJsonSetRatingSchemeId() {
    // Arrange
    ImmutableAssessmentDefinition.Json json = new ImmutableAssessmentDefinition.Json();

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableAssessmentDefinition.Json#setRatingSchemeId(long)}
   */
  @Test
  void testJsonSetRatingSchemeId2() {
    // Arrange
    ImmutableAssessmentDefinition.Json json = new ImmutableAssessmentDefinition.Json();
    Optional<EntityReference> qualifierReference = Optional.of(mock(EntityReference.class));
    json.setQualifierReference(qualifierReference);

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableAssessmentDefinition.Json#visibility()}
   */
  @Test
  void testJsonVisibility() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAssessmentDefinition.Json()).visibility());
  }
}
