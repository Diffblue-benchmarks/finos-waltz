package org.finos.waltz.model.application;

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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.rating.RagRating;
import org.junit.jupiter.api.Test;

class ImmutableAppRegistrationRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableAppRegistrationRequest#builder()}
   *   <li>{@link ImmutableAppRegistrationRequest#assetCode(String)}
   *   <li>{@link ImmutableAppRegistrationRequest#description(String)}
   *   <li>{@link ImmutableAppRegistrationRequest#parentAssetCode(String)}
   *   <li>{@link ImmutableAppRegistrationRequest#provenance(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableAppRegistrationRequest.Builder actualAssetCodeResult = ImmutableAppRegistrationRequest.builder()
        .assetCode("Asset Code");
    Optional<String> assetCode = Optional.of("foo");
    ImmutableAppRegistrationRequest.Builder actualParentAssetCodeResult = actualAssetCodeResult.assetCode(assetCode)
        .description("The characteristics of someone or something")
        .parentAssetCode("Parent Asset Code");
    Optional<String> parentAssetCode = Optional.of("foo");
    ImmutableAppRegistrationRequest.Builder actualParentAssetCodeResult2 = actualParentAssetCodeResult
        .parentAssetCode(parentAssetCode);

    // Assert
    assertSame(actualParentAssetCodeResult2, actualParentAssetCodeResult2.provenance("Provenance"));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#addAliases(String)}
   */
  @Test
  void testBuilderAddAliases() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAliases("Element"));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#addAliases(String[])}
   */
  @Test
  void testBuilderAddAliases2() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAliases("Elements"));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#addAllAliases(Iterable)}
   */
  @Test
  void testBuilderAddAllAliases() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAliases(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#addAllAliases(Iterable)}
   */
  @Test
  void testBuilderAddAllAliases2() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAliases(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#addAllTags(Iterable)}
   */
  @Test
  void testBuilderAddAllTags() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTags(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#addAllTags(Iterable)}
   */
  @Test
  void testBuilderAddAllTags2() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllTags(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#addTags(String)}
   */
  @Test
  void testBuilderAddTags() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTags("Element"));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#addTags(String[])}
   */
  @Test
  void testBuilderAddTags2() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addTags("Elements"));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#aliases(Iterable)}
   */
  @Test
  void testBuilderAliases() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.aliases(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#aliases(Iterable)}
   */
  @Test
  void testBuilderAliases2() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.aliases(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#applicationKind(ApplicationKind)}
   */
  @Test
  void testBuilderApplicationKind() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.applicationKind(ApplicationKind.IN_HOUSE));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#assetCode(Optional)}
   */
  @Test
  void testBuilderAssetCode() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();
    Optional<String> assetCode = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.assetCode(assetCode));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#businessCriticality(Criticality)}
   */
  @Test
  void testBuilderBusinessCriticality() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.businessCriticality(Criticality.LOW));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableAppRegistrationRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableAppRegistrationRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#from(ProvenanceProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();
    ProvenanceProvider instance = mock(ProvenanceProvider.class);
    when(instance.provenance()).thenReturn("Provenance");

    // Act
    ImmutableAppRegistrationRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).provenance();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#from(AppRegistrationRequest)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    ImmutableAppRegistrationRequest buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#from(AppRegistrationRequest)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.organisationalUnitId()).thenThrow(new IllegalStateException("instance"));
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#from(AppRegistrationRequest)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(stringSet);
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    ImmutableAppRegistrationRequest buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    Set<String> tagsResult = buildResult.tags();
    assertEquals(1, tagsResult.size());
    assertEquals(1L, buildResult.organisationalUnitId());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(tagsResult.contains("instance"));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#from(AppRegistrationRequest)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> emptyResult = Optional.empty();
    when(instance.assetCode()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    ImmutableAppRegistrationRequest buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#from(AppRegistrationRequest)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.parentAssetCode()).thenReturn(emptyResult);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    ImmutableAppRegistrationRequest buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#from(AppRegistrationRequest)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(stringSet);
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    ImmutableAppRegistrationRequest buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertEquals("The characteristics of someone or something", buildResult.description());
    Set<String> aliasesResult = buildResult.aliases();
    assertEquals(1, aliasesResult.size());
    assertEquals(1L, buildResult.organisationalUnitId());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertTrue(aliasesResult.contains("instance"));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#from(AppRegistrationRequest)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    ImmutableAppRegistrationRequest buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("Provenance", buildResult.provenance());
    assertNull(buildResult.description());
    assertEquals(1L, buildResult.organisationalUnitId());
    assertEquals(Criticality.LOW, buildResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, buildResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, buildResult.lifecyclePhase());
    assertEquals(RagRating.R, buildResult.overallRating());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#lifecyclePhase(LifecyclePhase)}
   */
  @Test
  void testBuilderLifecyclePhase() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lifecyclePhase(LifecyclePhase.PRODUCTION));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#organisationalUnitId(long)}
   */
  @Test
  void testBuilderOrganisationalUnitId() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.organisationalUnitId(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#overallRating(RagRating)}
   */
  @Test
  void testBuilderOverallRating() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.overallRating(RagRating.R));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#parentAssetCode(Optional)}
   */
  @Test
  void testBuilderParentAssetCode() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();
    Optional<String> parentAssetCode = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.parentAssetCode(parentAssetCode));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#tags(Iterable)}
   */
  @Test
  void testBuilderTags() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.tags(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Builder#tags(Iterable)}
   */
  @Test
  void testBuilderTags2() {
    // Arrange
    ImmutableAppRegistrationRequest.Builder builderResult = ImmutableAppRegistrationRequest.builder();

    LinkedHashSet<String> elements = new LinkedHashSet<>();
    elements.add("Elements");

    // Act and Assert
    assertSame(builderResult, builderResult.tags(elements));
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest#copyOf(AppRegistrationRequest)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest actualCopyOfResult = ImmutableAppRegistrationRequest.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    Set<String> aliasesResult = actualCopyOfResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualCopyOfResult.tags());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest#copyOf(AppRegistrationRequest)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(stringSet);
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest actualCopyOfResult = ImmutableAppRegistrationRequest.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    Set<String> tagsResult = actualCopyOfResult.tags();
    assertEquals(1, tagsResult.size());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    assertTrue(tagsResult.contains("instance"));
    assertTrue(actualCopyOfResult.aliases().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest#copyOf(AppRegistrationRequest)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("name");
    stringSet.add("instance");
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(stringSet);
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest actualCopyOfResult = ImmutableAppRegistrationRequest.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    assertTrue(actualCopyOfResult.aliases().isEmpty());
    assertEquals(stringSet, actualCopyOfResult.tags());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest#copyOf(AppRegistrationRequest)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> emptyResult = Optional.empty();
    when(instance.assetCode()).thenReturn(emptyResult);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest actualCopyOfResult = ImmutableAppRegistrationRequest.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    Set<String> aliasesResult = actualCopyOfResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualCopyOfResult.tags());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest#copyOf(AppRegistrationRequest)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> emptyResult = Optional.empty();
    when(instance.parentAssetCode()).thenReturn(emptyResult);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest actualCopyOfResult = ImmutableAppRegistrationRequest.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    Set<String> aliasesResult = actualCopyOfResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualCopyOfResult.tags());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest#copyOf(AppRegistrationRequest)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("instance");
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(stringSet);
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest actualCopyOfResult = ImmutableAppRegistrationRequest.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    Set<String> aliasesResult = actualCopyOfResult.aliases();
    assertEquals(1, aliasesResult.size());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    assertTrue(aliasesResult.contains("instance"));
    assertTrue(actualCopyOfResult.tags().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest#copyOf(AppRegistrationRequest)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    AppRegistrationRequest instance = mock(AppRegistrationRequest.class);
    when(instance.tags()).thenReturn(new HashSet<>());
    when(instance.organisationalUnitId()).thenReturn(1L);
    when(instance.lifecyclePhase()).thenReturn(LifecyclePhase.PRODUCTION);
    when(instance.businessCriticality()).thenReturn(Criticality.LOW);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.assetCode()).thenReturn(ofResult);
    Optional<String> ofResult2 = Optional.of("foo");
    when(instance.parentAssetCode()).thenReturn(ofResult2);
    when(instance.aliases()).thenReturn(new HashSet<>());
    when(instance.overallRating()).thenReturn(RagRating.R);
    when(instance.applicationKind()).thenReturn(ApplicationKind.IN_HOUSE);
    when(instance.description()).thenReturn(null);
    when(instance.provenance()).thenReturn("Provenance");
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableAppRegistrationRequest actualCopyOfResult = ImmutableAppRegistrationRequest.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).name();
    verify(instance).provenance();
    verify(instance).aliases();
    verify(instance).applicationKind();
    verify(instance).assetCode();
    verify(instance).businessCriticality();
    verify(instance).lifecyclePhase();
    verify(instance).organisationalUnitId();
    verify(instance).overallRating();
    verify(instance).parentAssetCode();
    verify(instance).tags();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertNull(actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.organisationalUnitId());
    assertEquals(Criticality.LOW, actualCopyOfResult.businessCriticality());
    assertEquals(ApplicationKind.IN_HOUSE, actualCopyOfResult.applicationKind());
    assertEquals(LifecyclePhase.PRODUCTION, actualCopyOfResult.lifecyclePhase());
    assertEquals(RagRating.R, actualCopyOfResult.overallRating());
    Set<String> aliasesResult = actualCopyOfResult.aliases();
    assertTrue(aliasesResult.isEmpty());
    assertSame(aliasesResult, actualCopyOfResult.tags());
  }

  /**
   * Method under test: {@link ImmutableAppRegistrationRequest.Json#aliases()}
   */
  @Test
  void testJsonAliases() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppRegistrationRequest.Json()).aliases());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Json#applicationKind()}
   */
  @Test
  void testJsonApplicationKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppRegistrationRequest.Json()).applicationKind());
  }

  /**
   * Method under test: {@link ImmutableAppRegistrationRequest.Json#assetCode()}
   */
  @Test
  void testJsonAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppRegistrationRequest.Json()).assetCode());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Json#businessCriticality()}
   */
  @Test
  void testJsonBusinessCriticality() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppRegistrationRequest.Json()).businessCriticality());
  }

  /**
   * Method under test: {@link ImmutableAppRegistrationRequest.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppRegistrationRequest.Json()).description());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Json#lifecyclePhase()}
   */
  @Test
  void testJsonLifecyclePhase() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppRegistrationRequest.Json()).lifecyclePhase());
  }

  /**
   * Method under test: {@link ImmutableAppRegistrationRequest.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppRegistrationRequest.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableAppRegistrationRequest.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableAppRegistrationRequest.Json actualJson = new ImmutableAppRegistrationRequest.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.provenance);
    assertNull(actualJson.businessCriticality);
    assertNull(actualJson.applicationKind);
    assertNull(actualJson.lifecyclePhase);
    assertNull(actualJson.overallRating);
    assertEquals(0L, actualJson.organisationalUnitId);
    assertFalse(actualJson.assetCode.isPresent());
    assertFalse(actualJson.parentAssetCode.isPresent());
    assertFalse(actualJson.organisationalUnitIdIsSet);
    assertTrue(actualJson.aliases.isEmpty());
    assertTrue(actualJson.tags.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Json#organisationalUnitId()}
   */
  @Test
  void testJsonOrganisationalUnitId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppRegistrationRequest.Json()).organisationalUnitId());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Json#overallRating()}
   */
  @Test
  void testJsonOverallRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppRegistrationRequest.Json()).overallRating());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Json#parentAssetCode()}
   */
  @Test
  void testJsonParentAssetCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableAppRegistrationRequest.Json()).parentAssetCode());
  }

  /**
   * Method under test: {@link ImmutableAppRegistrationRequest.Json#provenance()}
   */
  @Test
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppRegistrationRequest.Json()).provenance());
  }

  /**
   * Method under test:
   * {@link ImmutableAppRegistrationRequest.Json#setOrganisationalUnitId(long)}
   */
  @Test
  void testJsonSetOrganisationalUnitId() {
    // Arrange
    ImmutableAppRegistrationRequest.Json json = new ImmutableAppRegistrationRequest.Json();

    // Act
    json.setOrganisationalUnitId(1L);

    // Assert
    assertEquals(1L, json.organisationalUnitId);
    assertTrue(json.organisationalUnitIdIsSet);
  }

  /**
   * Method under test: {@link ImmutableAppRegistrationRequest.Json#tags()}
   */
  @Test
  void testJsonTags() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableAppRegistrationRequest.Json()).tags());
  }
}
